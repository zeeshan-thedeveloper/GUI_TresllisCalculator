package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		  try {
			 
			   Matrix.meta_Data_Holder = new Meta_Data_Holder();
	            // Read file fxml and draw interface.
	            Parent root = FXMLLoader.load(getClass().getResource("/application/MyScene.fxml"));
	            Scene scene = new Scene(root, 1350,670);
	            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	            primaryStage.setTitle("My Application");
	            primaryStage.setScene(scene);
	            primaryStage.show();       
	         
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
