package DoodleJump;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// this class simply organizes and presents graphically the gamePane and the quit button. 

public class PaneOrganizer{
 	private BorderPane _root;
 	private Game _game;
 	private VBox _buttonPane;
 	
 	
	public PaneOrganizer() {
		_root = new BorderPane();
		_root.setStyle("-fx-background-color: orange;");
		_root.setPrefSize(800,800);
		Pane gamePane = new Pane();
		_game = new Game(gamePane);
		_root.setCenter(gamePane);
		this.setupButton();
	}
	
	// a method to register the quit button with the ClickHandler. 
	public void setupButton(){
		_buttonPane = new VBox();
		Button btn = new Button("Quit");
		_buttonPane.getChildren().add(btn);
		_root.setBottom(_buttonPane);
		btn.setOnAction(new ClickHandler());		
	}
	
	// method to return the _root in the App class. 
	public Pane getRoot() {	
		return _root;
	}
	
	// private inner class to add functionality to the quit button. 
	
	private class ClickHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			System.exit(0);
		}
	}
}

	
		

