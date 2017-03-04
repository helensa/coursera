package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {
    private int length;
    private int width;
    private int lotLength;
    private int lotWidth;

    /*
    Constructor
     */
    public Building(int length, int width, int lotLength, int lotWidth) {
        this.length = length;
        this.width = width;
        this.lotLength = lotLength;
        this.lotWidth = lotWidth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLotLength() {
        return lotLength;
    }

    public void setLotLength(int lotLength) {
        this.lotLength = lotLength;
    }

    public int getLotWidth() {
        return lotWidth;
    }

    public void setLotWidth(int lotWidth) {
        this.lotWidth = lotWidth;
    }

    /*
    Calculate building area
     */
    public int calcBuildingArea(){
        return length * width;
    }

    /*
    Calculate lot area
     */
    public int calcLotArea(){
        return lotLength * lotWidth;
    }

    @Override
    public String toString() {
        return "Building{" +
                "length=" + length +
                ", width=" + width +
                ", lotLength=" + lotLength +
                ", lotWidth=" + lotWidth +
                '}';
    }
}
