package DoodleJump;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// In this class I made the platform and added methods in order to make the Node as well as the position of the platform accessible to other classes. 
public class Platform {
	
	private Rectangle _rectangle;
	
	public Platform(double x, double y){
	_rectangle = new Rectangle(Constants.PLATFORM_WIDTH,Constants.PLATFORM_HEIGHT,Color.RED);	
	_rectangle.setX(x);
	_rectangle.setY(y);
	}
	public double getXPosition(){
		return _rectangle.getX();
	}
	public double getYPosition(){
		return _rectangle.getY();
	}
	public void setXPosition(double h){
		_rectangle.setX(h);
	}
	public void setYPosition(double v){
		_rectangle.setY(v);
	}
	public Node getNode(){
		return _rectangle;
	}
	
}