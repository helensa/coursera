package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic 
       implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation){

        MathOperation mathOperation = null;
        //switch sets mathOperation to the appropriate class
        switch (operation) {
            case 1:
                mathOperation = new Add();
                break;

            case 2:
                mathOperation = new Subtract();
                break;

            case 3:
                mathOperation = new Multiply();
                break;

            case 4:
                mathOperation = new Divide();
                break;
        }

        int result = mathOperation.execute(argumentOne, argumentTwo);

        //get remainder in case of division; print output
        if (mathOperation instanceof Divide){
            Divide divide = (Divide)mathOperation;
            int remainder = divide.getRemainder();
            mOut.print(String.format("%d R: %d",result, remainder));
        }
        //print output for add, subtract, multiply
        else {
            mOut.print(String.valueOf(result));
        }
    }
}
