package application;

import java.util.ArrayList;
import java.util.List;

public class Firestation {
    private int stationNo;
    private String location;
    private String postCode;
    private List<Resource> resources; // List of resources assigned to this firestation
    
    public Firestation(int stationNo, String location, String postCode) {
        this.stationNo = stationNo;
        this.location = location;
        this.postCode = postCode;
        this.resources = new ArrayList<>();
    }
    
    
    
    public int getStationNo() {
		return stationNo;
	}


	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}


	// Add a new resource to this firestation
    public void addResource(Resource resource) {
        resources.add(resource);
    }
    
    
    @Override
    public String toString() {
       
    	return "Firestation{" +
                "stationNo=" + stationNo +
                ", location='" + location + '\'' +
                ", postCode='" + postCode + '\'' +
                ", resources=" + resources +
                '}';
    }
    
    
    // Check if this firestation has a resource with the given equipment type
    public boolean hasEquipmentType(String equipmentType) {
        for (Resource resource : resources) {
            if (resource.getEquipmentType().equals(equipmentType)) {
                return true;
            }
        }
        return false;
    }
    
    // Calculate the distance between this firestation's location and the given location
    public int getDistanceFromLocation(String location) {
        // Use a dummy implementation that always returns 1 for demonstration purposes
        return 1;
    }
}
