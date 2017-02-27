package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    public static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    /*
    method simulateHerd runs ten simulations of picking a gate (west or east) and moving
    a randomly generated number of snails in or out of that pen;
    random number generator's bound for generating number of snails to move
    adjusts depending on which gate is chosen and how many snails are
    available to move through that gate
     */
    public void simulateHerd(Random rand){
        int snailsInPen = HERD;

        String message
                = String.format("There are currently %d snails in the pen and %d snails in the pasture",
                snailsInPen, HERD - snailsInPen);
        mOut.println(message);

        for (int i = 0; i < MAX_ITERATIONS; i++){
            Gate gate;
            if (snailsInPen == HERD) {  //all snails in pen, none in pasture
                gate = mEastGate;
            }
            else if (snailsInPen == 0) { //all snails in pasture, none in pen
                gate = mWestGate;
            }
            else {
                boolean gateEast = rand.nextBoolean();  //snails both in pen and pasture
                if (gateEast) {
                    gate = mEastGate;
                }
                else {
                    gate = mWestGate;
                }
            }
            int bound;
            if (gate.equals(mEastGate)) {
                bound = snailsInPen;
            }
            else {
                bound = HERD - snailsInPen;
            }
            int snailsToMove = 1 + rand.nextInt(bound);
            snailsInPen = simulation(gate, snailsToMove, snailsInPen);
        } //for

    }

    /*
    method simulation attempts to move a given number of snails using
    method thru() and return the number of snails moved;
    it prints out the number of snails in pen and in pasture
     */
    private int simulation(Gate gate, int snailsToMove, int snailsInPen){

        int change = gate.thru(snailsToMove);

        int newSnailsInPen = snailsInPen + change;

        if (newSnailsInPen > HERD || newSnailsInPen < 0 ){  //invalid simulation, no snails moved
            newSnailsInPen  = snailsInPen;
        }

        String message
                = String.format("There are currently %d snails in the pen and %d snails in the pasture",
                newSnailsInPen, HERD - newSnailsInPen);

        mOut.println(message);

        return newSnailsInPen;
    }
}
