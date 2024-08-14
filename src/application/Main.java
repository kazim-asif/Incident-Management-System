package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    
	Stage stage;
	FXMLLoader loader = new FXMLLoader();
	
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the initial view (menu system)

    	String fxmlDocPath = "src/GUI/RootScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		//Create the Pane and all Details
		AnchorPane root = (AnchorPane) loader.load(fxmlStream);	
		Scene scene = new Scene(root,370,200);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Online Marketplace System");
		primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

