package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage extends House {

    int dimension;
    boolean secondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth, null, false);
        this.dimension = dimension;
        this.secondFloor = secondFloor;
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, dimension, lotLength, lotWidth, owner);
        this.dimension = dimension;
        this.secondFloor = secondFloor;
    }

    @Override
    public String toString() {
        String myString = super.toString();
        if (secondFloor == true){
            myString = myString + "; is a two story cottage";
        }
        return myString;
    }
}

