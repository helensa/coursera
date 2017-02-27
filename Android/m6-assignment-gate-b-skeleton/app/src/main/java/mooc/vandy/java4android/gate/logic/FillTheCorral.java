package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    /*
    setCorralGates set swing direction of each gate passed in the array Gate[];
    it prints the swing position of each gate
     */
    public void setCorralGates(Gate[] gate, Random selectDirection){
        for (int i = 0; i < gate.length; i++){
            int direction = selectDirection.nextInt(3);

            if (direction == 0) {
                gate[i].setSwing(Gate.OUT);
                mOut.println(String.format("Gate %d is open and swings to exit the pen only", i));
            }
            else if (direction == 1){
                gate[i].setSwing(Gate.CLOSED);
                mOut.println(String.format("Gate %d is closed", i));
            }
            else {
                gate[i].setSwing(Gate.IN);
                mOut.println(String.format("Gate %d is open and swings to enter the pen only", i));
            }
        }
    }

    /*
    anyCorralAvailable checks if there is any corral with the gate swing in the IN position
    to allow the snails to enter it
     */
    public boolean anyCorralAvailable(Gate[] corral){
        for (int i = 0; i < corral.length; i++){
            if (corral[i].getSwingDirection() == Gate.IN){
                return true;
            }
        }
        return false;
    }

    /*
    corralSnails generates a random number of snails to be corralled and
    moves them into gates that are open;
    the current number of snails to be corralled changes depending on the position of the
    gate swing of the current corral;
    the method keeps track of the number of attempts it takes to corral all the snails;
    the method also prints out the number of snails it is trying to move on a given iteration
    the number of the gate being used and the total number of attempts it took
     */
    public  int corralSnails(Gate[]gates, Random rand){
        int snailsAtPasture = 5;
        int attemptCount = 0;

        do {
            int snailToCorral = rand.nextInt(snailsAtPasture) + 1;
            int gateNumber = rand.nextInt(gates.length);
            snailsAtPasture -= gates[gateNumber].thru(snailToCorral);
            attemptCount++;
            mOut.println(String.format("%d are trying to move through corral %d", snailToCorral, gateNumber));
        } while (snailsAtPasture > 0);

        mOut.println(String.format("It took %d attempts to corral all of the snails.", attemptCount));
        return attemptCount;
    }




}
