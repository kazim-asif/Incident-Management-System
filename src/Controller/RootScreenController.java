package Controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import application.Firestation;
import application.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RootScreenController implements Initializable {

private MainController controller=new MainController();
	
	public MainController getController() {
		return controller;
	}
	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	
    @FXML
    private Label errorLabel;

    @FXML
    private Button incidentAdminButton;

    @FXML
    private Button incidentButton;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // code to be executed when the FXML file is loaded
    	
    	controller.initailize();
    		
    }

    
    @FXML
    void handleIncidentAdminButton(ActionEvent event) throws IOException {

    	
    	FXMLLoader loader = new FXMLLoader();
		Stage currentStage=(Stage)((Node)event.getSource()).getScene().getWindow();
		String fxmlDocPath = "src/GUI/AssignResource.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);
		AssignResourceController obj= loader.getController();
		obj.setController(controller);
		Scene scene = new Scene(pane,710,468);
		currentStage.setScene(scene);
		currentStage.show();
		
		
    }

    @FXML
    void handleIncidentButton(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
		Stage currentStage=(Stage)((Node)event.getSource()).getScene().getWindow();
		String fxmlDocPath = "src/GUI/ReportIncident.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);
		ReportIncidentController obj= loader.getController();
		obj.setController(controller);
		Scene scene = new Scene(pane,710,468);
		currentStage.setScene(scene);
		currentStage.show();
		
    }

}
