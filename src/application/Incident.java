package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Incident {
    private String personNotifying;
    private String location;
    private String type;
    private List<String> neighbouringBuildings;
    private List<Resource> resources;
    private boolean isLifeThreatening;
    private int injured;
    private int id;
    private String telno;
    private String desc;
    public String date;
    public String time;

    public Incident() {
    	
    }
    
    public Incident(String personNotifying, String location, String type, List<String> neighbouringBuildings, int injured, String telno,
    		String desc, boolean isLifeThreatening ) {
        this.personNotifying = personNotifying;
        this.location = location;
        this.type = type;
        this.neighbouringBuildings = neighbouringBuildings;
        this.resources = new ArrayList<Resource>();
        this.isLifeThreatening = isLifeThreatening;
        this.injured= injured;
        this.id=id;
        this.telno=telno;
        this.desc=desc;
    }

    
    
    public int getInjured() {
		return injured;
	}

	public void setInjured(int injured) {
		this.injured = injured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPersonNotifying(String personNotifying) {
		this.personNotifying = personNotifying;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNeighbouringBuildings(List<String> neighbouringBuildings) {
		this.neighbouringBuildings = neighbouringBuildings;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public void setLifeThreatening(boolean isLifeThreatening) {
		this.isLifeThreatening = isLifeThreatening;
	}

	public String getPersonNotifying() {
        return personNotifying;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public List<String> getNeighbouringBuildings() {
        return neighbouringBuildings;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public boolean isLifeThreatening() {
        return isLifeThreatening;
    }
    
    

    public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
    public String toString() {
		if(this.neighbouringBuildings==null) {
			this.neighbouringBuildings = new ArrayList<String>();
		}
        return "Incident{" +
				"Incident No.='"+id+'\'' +
                ", personNotifying='" + personNotifying + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", neighbouringBuildings=" + Arrays.toString(this.neighbouringBuildings.toArray()) +
//                ", resources=" + Arrays.toString(this.resources.toArray()) +
                ", isLifeThreatening=" + isLifeThreatening +
                '}';
    }
    
    
//    
//    public Incident reportIncident() {
//        // Gather incident details from the user
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the name of notifier:");
//        String name = scanner.nextLine();
//        
//        System.out.println("Enter the location of the incident:");
//        String location = scanner.nextLine();
//
//        System.out.println("Enter the type of incident (Building, Grass, Factory, RTC):");
//        String type = scanner.nextLine();
//
//        System.out.println("Enter the neighbouring building names:");
//        List<String > nb = new ArrayList<String>();
//        while(true){
//        	System.out.println("In case there is no building, enter '-1'");
//        	 System.out.println("Enter the neighbouring building name:");
//        	 String b = scanner.nextLine();
//        	 if(b.equals("-1")) {
//        		 break;
//        	 }
//        	 nb.add(b);
//        }
//        
//        System.out.println("Enter number of injured parties");
//        int injuredPartiesInput = scanner.nextInt();
//
//        System.out.println("Incident reported successfully!");
//        
//        return new Incident(name,location,type,nb,injuredPartiesInput);
//        
////        // Create a new transaction with the incident details
////        Transaction transaction = new Transaction(location, type, numNeighbouringBuildings, injuredParties);
////        
////        // Assign resources to the transaction
////        List<Resource> resources = getResourceList();
////        assignResources(transaction, resources);
////
////        // Add the transaction to the list of completed transactions
////        completedTransactions.add(transaction);
//
//        
//    }
//
//    
//    
    
}
