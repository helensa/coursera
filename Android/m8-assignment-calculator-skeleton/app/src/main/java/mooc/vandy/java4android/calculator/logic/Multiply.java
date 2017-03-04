package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply implements MathOperation {

    @Override
    public int execute(int param1, int param2) {
        return param1 * param2;
    }
}
