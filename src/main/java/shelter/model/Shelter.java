package shelter.model;

public class Shelter {
    private int shelterID;
    private String name;
    private String address;
    private String phoneNumber;

    public Shelter(int shelterID, String name, String address, String phoneNumber) {
        this.shelterID = shelterID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getShelterID() {
        return shelterID;
    }

    public void setShelterID(int shelterID) {
        this.shelterID = shelterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " - " + address + " - " + phoneNumber;
    }
}
