package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.Firestation;
import application.Incident;
import application.Resource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;

public class AssignResourceController {

	private MainController controller=new MainController();
	
	public MainController getController() {
		return controller;
	}
	public void setController(MainController controller) {
		this.controller = controller;
	}
	
	private List<Resource> resources = new ArrayList<>();
	
	
    @FXML
    private TextField firestationNoTextField;

    @FXML
    private TextArea firestationarea;

    @FXML
    private TextField idfield;

    @FXML
    private TextField incidentNoTextField;

    @FXML
    private TextArea incidentarea;

    @FXML
    private TextField numResourcesTextField;

    @FXML
    private TextArea resourcesarea;

    @FXML
    private TextArea selectedresourcesarea;

    @FXML
    void allocateResources(ActionEvent event) throws IOException, BiffException {
    	
    	if(incidentNoTextField.getText().isEmpty() || firestationNoTextField.getText().isEmpty() ) {
    		Alert alert = new Alert(AlertType.ERROR, "Please fill in all required fields and allocate atleast one resource");
            alert.showAndWait();
    	}
    	else {
    	
	    	int in = Integer.parseInt(incidentNoTextField.getText());
	    	int fn = Integer.parseInt(firestationNoTextField.getText());
	    	
	    	if(in>=0 && fn>=0 && resources.size()>0) {
//	    		if(!controller.allocateResources(in,fn,resources)) {
//	    			Alert alert = new Alert(AlertType.INFORMATION, "Resources already Allocated!");
//		            alert.showAndWait();
//	    		}
	    		
	    		controller.allocateResources(in,fn,resources);
	    		
//	    		else {
		    		resources.clear();
		    		Alert alert = new Alert(AlertType.CONFIRMATION, "Resources Succesfully Allocated!");
		            alert.showAndWait();
		            
		            firestationNoTextField.setText("");
		            firestationarea.setText("");
		            idfield.setText("");
		            incidentNoTextField.setText("");
		            incidentarea.setText("");
		            numResourcesTextField.setText("");
		            resourcesarea.setText("");
		            selectedresourcesarea.setText("");
//	    		}
	            
	    		
	    	}
    	}
    	
    }
    
    void PrintInfo() {
    	
    	incidentarea.setText("");
    	firestationarea.setText("");
    	
    	List<Incident> incidents = controller.incidents;
    	List<Resource> rs = controller.resources;
    	Map<Integer, Firestation> firestations = controller.firestations;
    	
    	for (Incident i : incidents) {
//    		if(i.getResources().size()==0)
    		incidentarea.setText(incidentarea.getText()+"\n-------------------------\n"+i.toString());
    		
    	}
    	
    	for (Resource r : rs) {
    		resourcesarea.setText(resourcesarea.getText()+"\n-------------------------\n"+r.toString());
    		
    	}
    	
    	for (Map.Entry<Integer, Firestation> entry : firestations.entrySet()) {
//    	    System.out.println("Firestation No.: " + entry.getKey());
//    	    System.out.println(entry.getValue().toString());
    		
    		firestationarea.setText(firestationarea.getText()+"\n-------------------\n"+entry.getValue().toString());
    		
    	}
    	
    }

    
    @FXML 
    void handleRefresh(ActionEvent event){
    	PrintInfo();
    }
    
    @FXML
    void handleGetReport(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		Stage currentStage=(Stage)((Node)event.getSource()).getScene().getWindow();
		String fxmlDocPath = "src/GUI/IncidentReport.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);
		IncidentReportController obj= loader.getController();
		obj.setController(controller);
		Scene scene = new Scene(pane,710,468);
		currentStage.setScene(scene);
		currentStage.show();
    }
    
	@FXML
    void handleAddResource(ActionEvent event) {
    	int id = Integer.parseInt(idfield.getText());
    	int num = Integer.parseInt(numResourcesTextField.getText());
    	if(id>=0 && num>0 ) {
    		Resource obj = controller.addResource(id);
    		if(obj!=null) {
    			obj.setNumberOfUnits(num);
    			resources.add(obj);
    			selectedresourcesarea.setText(selectedresourcesarea.getText()+"\n--------------------\n"
    					+ "Equipment : "+obj.getEquipmentType());
    		}
    	}
    }

	@FXML
	void handleCreateResource(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		Stage currentStage=(Stage)((Node)event.getSource()).getScene().getWindow();
		String fxmlDocPath = "src/GUI/Add Resource.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		AnchorPane pane = (AnchorPane) loader.load(fxmlStream);
		AddResourceController obj= loader.getController();
		obj.setController(controller);
		Scene scene = new Scene(pane,710,468);
		currentStage.setScene(scene);
		currentStage.show();
	}
	
    @FXML
    void handleGoBack(ActionEvent event) throws IOException {
    	
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

}
