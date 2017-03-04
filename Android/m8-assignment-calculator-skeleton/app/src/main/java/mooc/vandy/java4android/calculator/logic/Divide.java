package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide implements MathOperation {

    private int remainder;

    public int getRemainder() {
        return remainder;
    }

    @Override
    public int execute(int param1, int param2) {
        remainder = param1 % param2;
        return param1 / param2;
    }

}
