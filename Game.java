package DoodleJump;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/* this is the main class in which the game is set up through the following methods/classes. 
 * Using an instance of platform, I created an ArrayList to store all the platforms. 
 * Created a semi-random function to use for generating semi-randomly located platforms.
 * Created a setupTimeline method to be called in the constructor. 
 * Created a gameOver label to be called whenever the _doodle falls beyond the bottom of the Pane. 
 * Created a generatePlatfoms method that generates infinite platforms, to make the game playable infinitely.  
 * Created a TimeHandler to add functionality to the timeline. 
 * Created a KeyHandler to add functionality to the arrow keys, when moving the doodle right and left.  
 */

public class Game {
	private Doodle _doodle;
	private Platform _platform;
	private ArrayList<Platform> _platforms;
	private Pane _gamepane;
	private Label _label;
	
	public Game(Pane gamePane){
		gamePane.setPrefSize(800, 800);
		gamePane.setStyle("-fx-background-color: orange;");
		_gamepane = gamePane;
		_platform = new Platform(400,790);
		_platforms = new ArrayList<Platform>();
		_platforms.add(_platform);
		_label = new Label();
		_doodle = new Doodle(400,770);
		_gamepane.getChildren().addAll(_doodle.getNode(), _platform.getNode(),_label);
		KeyHandler myKeyHandler = new KeyHandler();
		_gamepane.addEventHandler(KeyEvent.KEY_PRESSED, myKeyHandler);
		_gamepane.setFocusTraversable(true);
		this.generatePlatforms();
		this.setupTimeline();	

	}
	
	public double semiRandom(double x,double y){
		double Range = x - y;
		double semiRandom = ((double)Range*(Math.random())) + y;
		return semiRandom;
	}
	
	public void keepPlatformsInThePane(){
		if (_platform.getXPosition() < 0){
			_platform.setXPosition(0);
		}
		if (_platform.getXPosition()>800){
			_platform.setXPosition(750);
		}
	}
	public void setupTimeline(){
		KeyFrame keyframe = new KeyFrame(Duration.millis(16), new TimeHandler());
		Timeline timeline = new Timeline(keyframe);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	public void gameOver(){
		if (_doodle.getYPosition() >= 800){
			_label.setText("Game Over!");
		}
	}
	
	public void generatePlatforms(){
		
		while (_platform.getYPosition() > 0){
			Platform plat = new Platform((_platform.getXPosition() + this.semiRandom(-150,150)), (_platform.getYPosition() - this.semiRandom(140,60)));
			_platforms.add(plat);	
			_platform = plat;
			this.keepPlatformsInThePane();
			
			_gamepane.getChildren().add(_platform.getNode());
		}

	}
	
	private class TimeHandler implements EventHandler <ActionEvent>{
		private double _velocity;
		private double _yPosition;
		private double _yPrevPosition;
		public void handle(ActionEvent e){
			_yPosition= _doodle.getYPosition();	
			_velocity = _velocity + (Constants.GRAVITY)*(16/1000.0);
			_yPrevPosition = _yPosition;
			_yPosition = _yPosition + _velocity*(16/1000.0);
			_doodle.setYPosition(_yPosition);
			Game.this.generatePlatforms();
			
			for (int j = 0; j < _platforms.size(); j++){
				if (_doodle.intersects(_platforms.get(j).getXPosition(), _platforms.get(j).getYPosition(), Constants.PLATFORM_WIDTH,Constants.PLATFORM_HEIGHT) && (_yPrevPosition < _yPosition)){
					_velocity = Constants.REBOUND_VELOCITY;
				}
				if ( _doodle.getYPosition() <= 400){
					_doodle.setYPosition(400);
					_platforms.get(j).setYPosition(_platforms.get(j).getYPosition() - _velocity*(16/1000.0));
					
				}	
			}
			Game.this.gameOver();
		}
		
	}
	
	private class KeyHandler implements EventHandler<KeyEvent>{
		@Override
		public void handle(KeyEvent e){
			KeyCode KeyPressed = e.getCode();
			if (KeyPressed == KeyCode.RIGHT &&  _doodle.getXPosition() < 810){
				_doodle.setXPosition(_doodle.getXPosition() + 15);
			} else if(KeyPressed == KeyCode.LEFT && _doodle.getXPosition() > -10){
				_doodle.setXPosition(_doodle.getXPosition() - 15);
			} e.consume();
		}
	}
 	
}