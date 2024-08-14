package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import application.*;
import jxl.read.biff.BiffException;

public class MainController {

	List<Incident> incidents = new ArrayList<Incident>();
	List<Resource> resources = new ArrayList<Resource>();
	Map<Integer, Firestation> firestations = new HashMap<Integer, Firestation>();
	
	FileWriting fw = new FileWriting();
	FileReading fr = new FileReading();
	
	Admin admin = new Admin(firestations,resources);
	
	public void initailize() {
//		Resource resource1 = new Resource(1, "London", "SW1A 1AA", 1, "Fire Extinguisher", 2);
//    	Resource resource2 = new Resource(2, "Manchester", "M1 1AF", 2, "Hose Reel", 3);
//    	Resource resource3 = new Resource(3, "Birmingham", "B1 1BB", 3, "Breathing Apparatus", 5);

		try {
			fr.readResources(resources);
			fr.readIncidents(incidents);
			fr.readAllocatedResources(incidents,resources);
			
//			System.out.println("in inital i= "+incidentsRead);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	Firestation fs1 = new Firestation(1, "Location 1", "12345");
    	Firestation fs2 = new Firestation(2, "Location 2", "54321");
    	Firestation fs3 = new Firestation(3, "Location 3", "67890");
    	
    	// Dummy firestations
    	Map<Integer, Firestation> fs = new HashMap<Integer, Firestation>();
    	firestations.put(1, fs1);	firestations.put(2, fs2)	;firestations.put(3, fs3);
	}
	
//	public List<Incident> getIncidentList() {
//		List<Incident> is = new ArrayList<Incident>();
//		for (int i=incidentsRead ; i<incidents.size() ; i++) {
//			is.add(incidents.get(i));
//		}
//		return is;
//	}
	
	
	public void reportIncident(String name, String location, String type, List<String> nb, 
			int injured,String telno, String desc, boolean islifethreat) {
		
		Incident newinci = new Incident(name,location,type,nb,injured, telno, desc, islifethreat);
		
		int id = 0;
		if(incidents.size()>0) {
			id = incidents.get(incidents.size()-1).getId() + 1 ;
		}
		newinci.setId(id);
		
		Date date = new Date();
	     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	     String d = formatter.format(date);
	     formatter = new SimpleDateFormat("hh:mm:ss a");
	     String t = formatter.format(date);
		
	     newinci.date = d;
	     newinci.time = t;
		
		incidents.add(newinci);
		
		fw.addDailyIncident(newinci);
		
	}

	
	public Resource addResource(int id) {
		if(id>=0) {
			for (Resource r : resources) {
				if(r.getResourceNo()==id) {
					return r;
				}
			}
		}
		return null;
	}
	
	public void allocateResources(int in, int fn, List<Resource> rc) throws IOException, BiffException {
		
		
		for (Incident i : incidents) {
			if(i.getId()==in) {
				for (Resource r : rc) {
					i.getResources().add(r);
				}
				admin.allocateResources(i,fn,resources);
				break;
			}
		}
		
//		boolean c = false;
		
//		for (int i=0 ; i<incidents.size() ; i++  ) {
//			
//			if(incidents.get(i).getId()==in && incidents.get(i).getResources().size()==0 ) {
//				for (Resource r : rc) {
//					incidents.get(i).getResources().add(r);
//				}
//				admin.allocateResources(incidents.get(i),fn,incidents.get(i).getResources());
//				c=true;
//				break;
//			}
//			
//		}
//		
//		if(!c) {
//			System.out.println("already alloated");
//		}
//		
//		return c;
		
	}
	
	
	public void CreateResource( String location, String postCode, int stationNo, String equipmentType, int numberOfUnits) {
		
		int resourceNo = 0;
		if(resources.size()>0)
			resourceNo=resources.get(resources.size()-1).getResourceNo()+1;
		
		Resource newresource = admin.createResource(resourceNo, location, postCode, stationNo, equipmentType, numberOfUnits);
		resources.add(newresource);
		
		fw.CreateResource(newresource);
		
	}
	
}
