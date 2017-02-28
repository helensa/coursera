package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building {

    private  String owner;
    private boolean pool;


    public House(int length, int width, int lotLength, int lotWidth) {
        this(length, width, lotLength, lotWidth, null);  //why not false at the end?
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner){
        this(length, width, lotLength, lotWidth, owner, false);
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);
        this.owner = owner;
        this.pool = pool;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }  //repeats code from constructor

    public boolean hasPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }  //repeats code from constructor

    @Override
    public boolean equals(Object o) {
        boolean same = false; //mine

        //if (this == o) return true;  //?
        //if (o == null || getClass() != o.getClass()) return false; //?

        if (o instanceof House) {
            House newHouse = (House) o;
            return same;
        }

        if (this.pool == newHouse.pool && this.calcBuildingArea() == newHouse.calcBuildingArea()) {
            same = true;
        }
        return same;
    }

    @Override
    public String toString() {
        String myString;
        int space = calcLotArea() - calcBuildingArea();
        boolean openSpace = false;

        if (space > 0){
            openSpace = true;
        }

        myString = "Owner: " + owner;

        if (hasPool()){
            myString = myString + "; has a pool";
        }
        if (openSpace == true){
            myString = myString + "; has a big open space";
        }
        return myString;
    }
}
