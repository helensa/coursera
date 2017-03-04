package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract implements MathOperation{

    @Override
    public int execute(int param1, int param2) {
        return param1 - param2;
    }
}
