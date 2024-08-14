package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.Incident;
import application.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IncidentReportController {

	private MainController controller=new MainController();
	
	public MainController getController() {
		return controller;
	}
	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	
    @FXML
    private TextField idfield;

    @FXML
    private TextArea reportarea;

    @FXML
    void handleGetReport(ActionEvent event) {

    	if(idfield.getText().isEmpty() || Integer.parseInt(idfield.getText()) < 0 ) {
    		Alert alert = new Alert(AlertType.ERROR, "Not a valid Id");
            alert.showAndWait();
    	}
    	else {
    		int id = Integer.parseInt(idfield.getText());
    		List<Incident> incidents = controller.incidents;
    		
    		for (Incident i : incidents) {
				if(i.getId() == id) {
					reportarea.setText("Reporting\n------------\nIncident Report\n--------------\n"
							+ "Incident No : "+i.getId()+"\nReported by: "+i.getPersonNotifying()+"\n"
							+ "Date : "+i.date+"\tTime : "+i.time+"\n"+"Location : "+i.getLocation()
							+ "\nType : "+i.getType()+"\nDesc : "+i.getDesc()+"\n\nResources:\n");
//					if(i.getResources()!=null)
					for (Resource sr : i.getResources()) {
						reportarea.setText(reportarea.getText()+"\n"+sr.toString()+"\n");
						
					}
					break;
				}
    			
			}
    		
    		
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
