package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.read.biff.BiffException;

public class Admin {
    private Map<Integer, Firestation> firestations; // Map of firestation number to firestation object
    private List<Resource> resources; // List of resources not yet assigned to a firestation
    
    public Admin( Map<Integer, Firestation> firestations, List<Resource> resources ) {
        this.firestations = firestations;
        this.resources = resources;
    }
    
    // Add a new firestation to the system
    public void addFirestation(int stationNo, String location, String postCode) {
        Firestation firestation = new Firestation(stationNo, location, postCode);
        firestations.put(stationNo, firestation);
    }
    
    // Add a new resource to the system
    public void addResource(Resource resource) {
        resources.add(resource);
    }
    
    public void addFirestationResources() {
    	
    }
    
    // Assign resources to firestations
    public void assignResources() {
        // Sort unassigned resources by distance from nearest firestation
        resources.sort((r1, r2) -> {
            int distance1 = Integer.MAX_VALUE, distance2 = Integer.MAX_VALUE;
            for (Firestation firestation : firestations.values()) {
                if (firestation.getPostCode().equals(r1.getPostCode())) {
                    distance1 = firestation.getDistanceFromLocation(r1.getLocation());
                }
                if (firestation.getPostCode().equals(r2.getPostCode())) {
                    distance2 = firestation.getDistanceFromLocation(r2.getLocation());
                }
            }
            return distance1 - distance2;
        });
        
        // Assign resources to nearest firestation that has the required equipment type
        for (Resource resource : resources) {
            for (Firestation firestation : firestations.values()) {
                if (firestation.getPostCode().equals(resource.getPostCode())
                        && firestation.hasEquipmentType(resource.getEquipmentType())) {
                    firestation.addResource(resource);
                    break;
                }
            }
        }
        
        // Clear the list of unassigned resources
//        unassignedResources.clear();
    }

    
    public void allocateResources(Incident in, int fn, List<Resource> resources) throws IOException, BiffException {
    	FileWriting fw = new FileWriting();
    	fw.allocateResource(in,fn,resources);
    }

    public Resource createResource(int resourceNo, String location, String postCode, int stationNo, String equipmentType, int numberOfUnits) {
        return new Resource(resourceNo, location, postCode, stationNo, equipmentType, numberOfUnits);
    }
    
    
}

