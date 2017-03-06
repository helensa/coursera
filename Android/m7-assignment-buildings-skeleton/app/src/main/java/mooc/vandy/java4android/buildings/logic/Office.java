package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {

    private String businessName;
    private int parkingSpaces;
    private static int totalOffices = 0;

    /*
    Constructor, basic
     */
    public Office(int length, int width, int lotLength, int lotWidth) {
        this (length, width, lotLength, lotWidth, null, 0);
    }

    /*
    Constructor, with business name
     */
    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this (length, width, lotLength, lotWidth, businessName, 0);
    }

    /*
    Constructor, with business name and parking spaces
     */
    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.businessName = businessName;
        this.parkingSpaces = parkingSpaces;
        totalOffices++;
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

    @Override
    public boolean equals(Object o) {

        if (o == null) return false;
        if (o == this) return true;

        boolean same = false;

        if (o instanceof Office){
            Office newOffice = (Office) o;
            if (newOffice.calcBuildingArea() == this.calcBuildingArea()
                    && newOffice.parkingSpaces == this.parkingSpaces){
                same = true;
            }
        }
        return same;
    }

    public String toString(){

        String myString = "Business: ";

        if (businessName == null){
            myString = myString + "unoccupied";
        }
        else {
            myString = myString + businessName;
        }

        if (parkingSpaces != 0){
            myString = myString + "; has " + parkingSpaces + " parking spaces";
        }

        myString = myString + " (total offices: " + totalOffices + ")";

        return myString;

    }
}
