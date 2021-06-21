package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root);
			
			stage.setTitle("DOFA");
			stage.setScene(scene);
			stage.show();
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
