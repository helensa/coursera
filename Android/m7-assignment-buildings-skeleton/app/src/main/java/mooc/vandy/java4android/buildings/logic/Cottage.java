package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage extends House {

    private boolean secondFloor;

    /*
    Constructor, basic
     */
    public Cottage(int dimension, int lotLength, int lotWidth) {
        this(dimension, lotLength, lotWidth, null, false);
    }

    /*
    Constructor, with second floor parameter
     */
    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, dimension, lotLength, lotWidth, owner);
        this.secondFloor = secondFloor;
    }

    public boolean hasSecondFloor() {
        return secondFloor;
    }

    @Override
    public String toString() {
        String myString = super.toString();
        if (secondFloor){
            myString = myString + "; is a two story cottage";
        }
        return myString;
    }
}

