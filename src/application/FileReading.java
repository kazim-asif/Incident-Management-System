package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class FileReading {
	public void readResources(List<Resource> rs) throws Exception {
		
	    Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Taha Asif\\Desktop\\Waqas\\IncidentManagementSystem\\src\\Resources.xls"));
	    Sheet sheet = workbook.getSheet(0);

	    for (int row = 1; row < sheet.getRows(); row++) {
	        Cell[] cells = sheet.getRow(row);

	        int resourceNo = Integer.parseInt(cells[0].getContents());
	        String location = cells[1].getContents();
	        String postCode = cells[2].getContents();
	        int stationNo = Integer.parseInt(cells[3].getContents());
	        String equipmentType = cells[4].getContents();
	        int numberOfUnits = Integer.parseInt(cells[5].getContents());

	        Resource resource = new Resource(resourceNo, location, postCode, stationNo, equipmentType, numberOfUnits);
	        rs.add(resource);
	    }

	    workbook.close();
	}

	public void readIncidents(List<Incident> incidents) throws Exception {
		
	    Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Taha Asif\\Desktop\\Waqas\\IncidentManagementSystem\\src\\Daily_Incident.xls"));
	    Sheet sheet = workbook.getSheet(0);

	    for (int row = 1; row < sheet.getRows(); row++) {
	        Cell[] cells = sheet.getRow(row);

	        int id = Integer.parseInt(cells[0].getContents());
	        String tel = cells[1].getContents();
	        String type = cells[2].getContents();
	        int injured = Integer.parseInt(cells[3].getContents());
	        
	        boolean isLT = false;
	        if(cells[4].getContents().equalsIgnoreCase("Yes")) {
	        	isLT=true;
	        }
	        
	        String desc = cells[5].getContents();
	        String reportedby = cells[6].getContents();
	        String location = cells[7].getContents();

	        Incident i = new Incident(reportedby,location,type,null,injured,tel,desc,isLT);
	        i.setId(id);
	        incidents.add(i);
	    }
	    
	    workbook.close();
	}

	public void readAllocatedResources(List<Incident> incidents, List<Resource> rs) throws Exception {
		
		Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\Taha Asif\\Desktop\\Waqas\\IncidentManagementSystem\\src\\Incident_info.xls"));
	    Sheet sheet = workbook.getSheet(0);
	    
	    int n =sheet.getRows();
	    Cell[] cells;
	    for (int row = 1;row < n;row++) {
	    	
	        cells = sheet.getRow(row);
	        
	        int id = Integer.parseInt(cells[0].getContents());
	        int rid = Integer.parseInt(cells[1].getContents());
	        String dt = cells[2].getContents();
	        String tm = cells[3].getContents();
	        
	        for(Incident i : incidents) {
	        	if(i.getId()==id) {
			        for (Resource resource : rs) {
						if(rid==resource.getResourceNo()) {
							i.getResources().add(resource);
							i.date=dt;i.time=tm;
						}
			        }
	        	}
	        }
	        

	    workbook.close();
	}
		
	}
	

}
