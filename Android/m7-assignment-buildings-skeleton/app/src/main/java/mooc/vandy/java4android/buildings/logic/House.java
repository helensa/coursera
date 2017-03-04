package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building {

    private  String owner;
    private boolean pool;

    /*
    Constructor, basic
     */
    public House(int length, int width, int lotLength, int lotWidth) {
        this(length, width, lotLength, lotWidth, null);
    }

    /*
    Constructor, with owner parameter
     */
    public House(int length, int width, int lotLength, int lotWidth, String owner){
        this(length, width, lotLength, lotWidth, owner, false);
    }

    /*
    Constructor, with owner and hasPool parameters
     */
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
    }

    public boolean hasPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        boolean same = false;

        if (o instanceof House) {
            House newHouse = (House) o;

            if (this.pool == newHouse.pool && this.calcBuildingArea() == newHouse.calcBuildingArea()) {
                same = true;
            }
        }

        return same;
    }

    @Override
    public String toString() {
        String myString;
        boolean openSpace = calcLotArea() > calcBuildingArea();

        myString = "Owner: " + (owner == null ? "n/a" : owner);

        if (hasPool()){
            myString = myString + "; has a pool";
        }

        if (openSpace) {
            myString = myString + "; has a big open space";
        }

        return myString;
    }
}
