package DoodleJump;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
/**
  * This is the  main class where your DoodleJump game will start.
  * The main method of this application calls the App constructor. You 
  * will need to fill in the constructor to instantiate your game.
  *
  * Class comments here...
  *
  * @author <yhajiqas>
  *Created a top-level object, set up the scene and showed the stage.
  */

public class App extends Application {

    @Override
	public void start(Stage stage) {
    PaneOrganizer organizer = new PaneOrganizer();
	Scene scene = new Scene(organizer.getRoot(),800,800);
    stage.setTitle("DoodleJump!");
    stage.setScene(scene);
    stage.show();
  }

	/*
	* Here is the mainline! No need to change this.  
	*/
	public static void main(String[] argv) {
        	// launch is a method inherited from Application
		launch(argv);
	}
}
