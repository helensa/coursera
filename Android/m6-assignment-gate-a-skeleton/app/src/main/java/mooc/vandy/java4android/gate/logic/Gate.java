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

    //set swing direction to IN, OUT or CLOSED
    public boolean setSwing(int direction) {
        if (direction == IN || direction == OUT || direction == CLOSED) {
            mSwing = direction;
            return true;
        } else
            return false;
    }

    //open gate either IN or OUT
    public boolean open(int direction) {
        boolean openable;

        if (direction == IN || direction == OUT) {
            setSwing(direction);
            openable = true;
        } else
            openable = false;

        return openable;
    }

    //close gate
    public void close() {
        setSwing(CLOSED);
    }

    /*
    return how many snails got through the door
    negative number means they got out of the pen
    positive number means they got into the pen
    zero means the game was closed and no one moved
     */
    public int thru(int count) {
        int number = 0;

        if (mSwing == IN) {
            number = count;
        }

        else if (mSwing == OUT) {
            number = -count;
        }

        else if (mSwing == CLOSED){
            number = 0;
        }

        return number;
    }

    //override toString
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
