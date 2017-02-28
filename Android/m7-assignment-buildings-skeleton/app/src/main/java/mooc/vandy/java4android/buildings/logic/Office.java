package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {

    private String businessName;
    private int parkingSpaces;
    private static int totalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        totalOffices =+1;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        super(length, width, lotLength, lotWidth);
        this.businessName = businessName;
        totalOffices =+1;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.businessName = businessName;
        this.parkingSpaces = parkingSpaces;
        totalOffices =+1;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public  String toString(){

        String myString = "Business: ";

        if (businessName == null){
            myString = myString + " unoccupied";
        }
        else
            myString = myString + businessName;

        if (parkingSpaces != 0){
            myString = myString + "; has " + parkingSpaces + " parking spaces";
        }

        myString = myString + " (total offices: " + totalOffices + ")";

        return myString;

    }
}
