package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing = CLOSED;

    public int getSwingDirection() {
        return mSwing;
    }

    public boolean setSwing(int direction) {
        if (direction == IN || direction == OUT || direction == CLOSED) {
            mSwing = direction;
            return true;
        } else
            return false;
    }

    public boolean open(int direction) {
        boolean openable;

        if (direction == IN || direction == OUT) {
            setSwing(direction);
            openable = true;
        } else
            openable = false;

        return openable;
    }

    public void close() {
        setSwing(CLOSED);
    }

    public int thru(int count) {
        int number = 0;

        if (mSwing == IN) {
            number = count;
        }

        else if (mSwing == OUT) {
            number = -count;
        }

        else if (mSwing == CLOSED){
            number = CLOSED;
        }

        return number;
    }

    public String toString(){
        String message;

        if (mSwing == CLOSED){
            message = "This gate is closed";
        }
        else if (mSwing == IN){
            message = "This gate is open and swings to enter the pen only";
        }
        else if (mSwing == OUT){
            message = "This gate is open and swings to exit the pen only";
        }
        else {
            message = "This gate has an invalid swing direction";
        }
        return message;
    }


}
