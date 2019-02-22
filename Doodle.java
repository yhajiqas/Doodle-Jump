package DoodleJump;
 
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/* In this class, I made the doole, using a shape ( rectangle ). 
 * I added get() methods to make doodle accessible from other classes.
 * I added a boolean intersect method that checks if the platform intersects with a platform.
 */

public class Doodle {
	private Rectangle _rectangle;
	
	
	public Doodle(double x, double y){
		_rectangle = new Rectangle(Constants.DOODLE_WIDTH, Constants.DOODLE_HEIGHT, Color.BLUE);
		_rectangle.setY(y);
		_rectangle.setX(x);
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
	
	public boolean intersects(double x, double y, double w, double z){
		return _rectangle.intersects(x,y,w,z);
		
	}
	public Node getNode() {
		return _rectangle;
	}
	
		
}
	
	
		
		



