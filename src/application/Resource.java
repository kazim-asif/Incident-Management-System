package application;

public class Resource {
    private int resourceNo;
    private String location;
    private String postCode;
    private int stationNo;
    private String equipmentType;
    private int numberOfUnits;

    public Resource(int resourceNo, String location, String postCode, int stationNo, String equipmentType, int numberOfUnits) {
        this.resourceNo = resourceNo;
        this.location = location;
        this.postCode = postCode;
        this.stationNo = stationNo;
        this.equipmentType = equipmentType;
        this.numberOfUnits = numberOfUnits;
    }

    public int getResourceNo() {
        return resourceNo;
    }

    public void setResourceNo(int resourceNo) {
        this.resourceNo = resourceNo;
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

    public int getStationNo() {
        return stationNo;
    }

    public void setStationNo(int stationNo) {
        this.stationNo = stationNo;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
    
    @Override
    public String toString() {
        return "Resource{" +
                "resourceNo=" + this.resourceNo +
                ", location='" + this.location + '\'' +
                ", postCode='" + this.postCode + '\'' +
                ", stationNo=" + this.stationNo +
                ", equipmentType='" + this.equipmentType + '\'' +
                ", numberOfUnits=" + this.numberOfUnits +
                '}';
    }


    
}
