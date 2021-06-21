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
	public void start(Stage mainStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root);
			
			mainStage.setTitle("DOFA");
			mainStage.setScene(scene);
			mainStage.show();
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
