package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReportIncidentController {

	
	private MainController controller=new MainController();
	
	public MainController getController() {
		return controller;
	}
	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	
    @FXML
    private Button backbtn;

    @FXML
    private TextField injuredPartiesField;
    
    @FXML 
    private TextField lifethreatfield;

    @FXML
    private TextField locationField;

    @FXML
    private TextField neighbouringBuilding1Field;

    @FXML
    private TextField neighbouringBuilding2Field;

    @FXML
    private TextField neighbouringBuilding3Field;

    @FXML
    private TextField neighbouringBuilding4Field;

    @FXML
    private TextField neighbouringBuilding5Field;

    @FXML
    private VBox neighbouringBuildingsBox;

    @FXML
    private TextField personNotifyingField;

    @FXML
    private Button reportbtn;

    @FXML
    private TextField typeField;
    
    @FXML
    private Text buildingerror;

    @FXML
    private TextArea descarea;
    
    @FXML
    private TextField telnofield;
    
    @FXML
    void handleBack(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader();
		Stage currentStage=(Stage)((Node)event.getSource()).getScene().getWindow();
		String fxmlDocPath = "src/GUI/RootScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);
		RootScreenController obj= loader.getController();
		obj.setController(controller);
		Scene scene = new Scene(pane,710,468);
		currentStage.setScene(scene);
		currentStage.show();
		
    }

    @FXML
    void handleReport(ActionEvent event) {
    	
    	if (personNotifyingField.getText().isEmpty() || locationField.getText().isEmpty()
                || typeField.getText().isEmpty() || injuredPartiesField.getText().isEmpty()
                || telnofield.getText().isEmpty() 
                || descarea.getText().isEmpty() || neighbouringBuilding2Field.getText().isEmpty()
                && neighbouringBuilding1Field.getText().isEmpty()
                && neighbouringBuilding3Field.getText().isEmpty() && neighbouringBuilding4Field.getText().isEmpty()
                && neighbouringBuilding5Field.getText().isEmpty() ) {
            // If any of the required fields are empty, show an error message
            Alert alert = new Alert(AlertType.ERROR, "Please fill in all required fields and provide atleast 1 neighbouring building.");
            alert.showAndWait();
        } 
    	// Proceed with incident report submission
    	else {
            // All required fields are filled, so proceed with reporting the incident
            
    		ArrayList<String> bs = new ArrayList<String>();
	    	
    		if(!neighbouringBuilding1Field.getText().isEmpty()) {
    			bs.add(neighbouringBuilding1Field.getText());
    		}
    		if(!neighbouringBuilding2Field.getText().isEmpty()) {
    			bs.add(neighbouringBuilding2Field.getText());
    		}
    		if(!neighbouringBuilding3Field.getText().isEmpty()) {
    			bs.add(neighbouringBuilding3Field.getText());
    		}
    		if(!neighbouringBuilding4Field.getText().isEmpty()) {
    			bs.add(neighbouringBuilding4Field.getText());
    		}
    		if(!neighbouringBuilding5Field.getText().isEmpty()) {
    			bs.add(neighbouringBuilding5Field.getText());
    		}
    	
    		boolean lt =false;
    		if(!lifethreatfield.getText().isEmpty()) {
    			if(lifethreatfield.getText().equals(1))
    				lt=true;
    		}
    	
    	controller.reportIncident(personNotifyingField.getText(),locationField.getText(),
    			typeField.getText(), bs ,Integer.parseInt(injuredPartiesField.getText()), 
    			telnofield.getText(), descarea.getText(),lt);
//    	
//    	buildingerror.setText("Incident is reported.");
//    	buildingerror.setVisible(true);
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION, "Incident Sucessfully Reported");
        alert.showAndWait();
    	
    		
            // After reporting the incident, clear all the fields
            personNotifyingField.setText("");
            locationField.setText("");
            typeField.setText("");
            injuredPartiesField.setText("");
            neighbouringBuilding1Field.setText("");
            neighbouringBuilding2Field.setText("");
            neighbouringBuilding3Field.setText("");
            neighbouringBuilding4Field.setText("");
            neighbouringBuilding5Field.setText("");
            telnofield.setText("");
            descarea.setText("");
            lifethreatfield.setText("");
        }
    	
    	
    }

}
