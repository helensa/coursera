package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here
        int i;
        int j;
        int line = 1;

        /**
         *
         * Print top of frame
         */
        PrintFrameTopAndBottom(size);


        /**
         *
         * Print diamond
         */


        /**
         *
         * print top half of diamond
         */
        for (i=1; i<size; i++){

            PrintTopHalf(size, line); //i is line number of diamond, not counting frame
            line++;
        }


        /**
         *
         * print middle line of diamond
         */
        PrintMiddleLine(size);
        line++;

        /**
         *
         * print bottom half of diamond
         */
        for (j=line; j < 2 *  size; j++){

            PrintBottomHalf(size, line);
            line++;
        }
        /**
         *
         * Print bottom of frame
         */
        PrintFrameTopAndBottom(size);





    }
    private  void PrintFrameTopAndBottom(int size) {
        String MyString;
        int i;

        MyString="+"; //start with leading 'plus' for left corner of frame

        //add as many dashes as the 'size'
        for (i=1; i<=size * 2; i++){
            MyString=MyString+"-";
        }

        MyString=MyString+"+"; //finish with trailing 'plus' for right corner of frame

        mOut.println(MyString);
        Log.i(TAG, MyString);

    }

    /**
     *
     * print top half of the diamond
     */
    private void PrintTopHalf(int size, int line){
        String s;
        int i;

        s = "|";
        //print leading spaces
        for (i=1; i < size - line + 1; i++){
            s = s + " ";
        }
        //print opening slash
        s = s + "/";

        //print dashes, if any
        for (i = 1; i < 2 * line - 1; i++){
            s =s + nextElement(line);
        }
        //print closing slash
        s = s + "\\";

        //print trailing spaces
        for (i=1; i < size - line + 1; i++){
            s = s + " ";
        }

        s = s + "|";
        mOut.println(s);

    }


    /**
     *
     * print bottom half of the diamond
     */
    private void PrintBottomHalf(int size, int line){
        String s;
        int i;

        s = "|";
        //print leading spaces
        for (i = line - size; i > 0; i--){
            s = s + " ";
        }
        //print opening slash
        s = s + "\\";

        //print dashes, if any
        for (i = 2*(2 * size - line) - 2; i > 0; i--){
            s = s +  nextElement(line);

        }
        //print closing slash
        s = s + "/";

        //print trailing spaces
        for (i = line - size; i > 0; i--){
            s = s + " ";
        }

        s = s + "|";
        mOut.println(s);

    }

    /**
     *
     * print middle line of the diamond
     */
    private void PrintMiddleLine(int size){
        String s;
        int i;

        s = "|<"; //Start line with vertical line and less sign

        //add 2*size-2 dashes
        for (i=0; i < 2 * size - 2; i++){
            s = s + nextElement(size);
        }

        s = s + ">|";  //End line with greater sign and vertical line
        mOut.println(s);
    }


    //add single dash if size is even, double dash if size is odd
    private String nextElement(int line) {
        if (line % 2 == 0) {   //size is even
            return "-";
        }

        //size is odd
        return "=";

    }
}