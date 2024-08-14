package Controller;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddResourceController {

	private MainController controller=new MainController();
	
	public MainController getController() {
		return controller;
	}
	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	
    @FXML
    private TextField equipmentTypeField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField numberOfUnitsField;

    @FXML
    private TextField postCodeField;

    @FXML
    private TextField stationNoField;

    @FXML
    void createResource(ActionEvent event) {
    	
    	// Get the values of the input fields
        String location = locationField.getText();
        String postCode = postCodeField.getText();
        int stationNo = Integer.parseInt(stationNoField.getText());
        String equipmentType = equipmentTypeField.getText();
        int numberOfUnits = Integer.parseInt(numberOfUnitsField.getText());
        
    	// Check if any of the fields are empty
        if (location.isEmpty() || postCode.isEmpty() || equipmentType.isEmpty()) {
            // Show an error message and return
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Missing fields");
            alert.setContentText("Please fill in all fields");
            alert.showAndWait();
            
        }
        else if(stationNo<1 || numberOfUnits<1 ) {
        	// Show an error message and return
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please input valid stationNo & numberOfUnits should be atleast 1");
            alert.showAndWait();
        }
        else {
        
        	controller.CreateResource(location, postCode, stationNo, equipmentType, numberOfUnits);
        	
        	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        	alert.setTitle("Success!");
            alert.setHeaderText("Operation Successful");
            alert.setContentText("New Resource Added");
            alert.showAndWait();
        }
    }

    @FXML
    void handleGoBack(ActionEvent event) throws IOException {

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

}
