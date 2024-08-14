package application;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.time.LocalDateTime;  
//import java.time.format.DateTimeFormatter;  


import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class FileWriting {

	void allocateResource(Incident in, int fn, List<Resource> resources) throws IOException {
 
		try {
			
			String filePath = "C:\\Users\\Taha Asif\\Desktop\\Waqas\\IncidentManagementSystem\\src\\Incident_Info.xls";
			
		    // Open the existing file for writing
		    Workbook existingWorkbook = Workbook.getWorkbook(new File(filePath));
		    WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath), existingWorkbook);

		    // Access the sheet
		    WritableSheet sheet = workbook.getSheet(0);

		    int existingRows = sheet.getRows();
		    
		    for (Resource r : resources) {
				
	        	 Date date = new Date();
	  	         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	  	         String d = formatter.format(date);
	  	         formatter = new SimpleDateFormat("hh:mm:ss a");
	  	         String t = formatter.format(date);
		        	
		  	       Label label = new Label(0, existingRows, in.getId()+"" );
		  	       sheet.addCell(label);
		  	       label = new Label(1, existingRows, r.getResourceNo()+"" );
		  	       sheet.addCell(label);
		  	       label = new Label(2, existingRows, d );
		  	       sheet.addCell(label);
		  	       label = new Label(3, existingRows, t );
		  	       sheet.addCell(label);
		  	         
		  	       existingRows+=1;
		        
		  	       in.date=d;
		  	       in.time=t;
		  	       
		        }
		    
		    
		    // Write the changes to the workbook and close it
		    workbook.write();
		    workbook.close();
		    
		} catch (IOException | BiffException | WriteException e) {
		    e.printStackTrace();
		}


		
    }
	
	
	public void addDailyIncident(Incident i) {
		
		try {
			
			String filePath = "C:\\Users\\Taha Asif\\Desktop\\Waqas\\IncidentManagementSystem\\src\\Daily_Incident.xls";
			
		    // Open the existing file for writing
		    Workbook existingWorkbook = Workbook.getWorkbook(new File(filePath));
		    WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath), existingWorkbook);

		    // Access the sheet
		    WritableSheet sheet = workbook.getSheet(0);

		    int existingRows = sheet.getRows();

  	       Label label = new Label(0, existingRows, i.getId()+"" );
  	       sheet.addCell(label);
  	       label = new Label(1, existingRows, i.getTelno()+"" );
  	       sheet.addCell(label);
  	       label = new Label(2, existingRows, i.getType() );
  	       sheet.addCell(label);
  	       label = new Label(3, existingRows, i.getInjured()+"" );
  	       sheet.addCell(label);
  	       if(i.isLifeThreatening()) {
  	    	 label = new Label(4, existingRows, "Yes" );
  	       }
  	       else {
  	    	 label = new Label(4, existingRows, "No" );
  	       }
  	       
	       sheet.addCell(label);
	       label = new Label(5, existingRows, i.getDesc()+"" );
  	       sheet.addCell(label);
  	       label = new Label(6, existingRows, i.getPersonNotifying()+"" );
	       sheet.addCell(label);
	       label = new Label(7, existingRows, i.getLocation()+"" );
	       sheet.addCell(label);
  	        
		    // Write the changes to the workbook and close it
		    workbook.write();
		    workbook.close();
		    
		} catch (IOException | BiffException | WriteException e) {
		    e.printStackTrace();
		}
		
	}
	
	public void CreateResource(Resource r) {
		
		try {
			
			String filePath = "C:\\Users\\Taha Asif\\Desktop\\Waqas\\IncidentManagementSystem\\src\\Resources.xls";
			
		    // Open the existing file for writing
			Workbook existingWorkbook = Workbook.getWorkbook(new File(filePath));
		    WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath), existingWorkbook);
		    

		    // Access the sheet
		    WritableSheet sheet = workbook.getSheet(0);
		    int existingRows = sheet.getRows();
		    
		       Label label = new Label(0, existingRows, r.getResourceNo()+"" );
	  	       sheet.addCell(label);
	  	       label = new Label(1, existingRows, r.getLocation()+"" );
	  	       sheet.addCell(label);
	  	       label = new Label(2, existingRows, r.getPostCode() );
	  	       sheet.addCell(label);
	  	       label = new Label(3, existingRows, r.getStationNo()+"" );
	  	       sheet.addCell(label);
		       label = new Label(4, existingRows, r.getEquipmentType()+"" );
	  	       sheet.addCell(label);
	  	       label = new Label(5, existingRows, r.getNumberOfUnits()+"" );
		       sheet.addCell(label);
	  	        
			    // Write the changes to the workbook and close it
			    workbook.write();
			    workbook.close();
	  	       
		    
		} catch (IOException | BiffException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    
	}
	
	
}
