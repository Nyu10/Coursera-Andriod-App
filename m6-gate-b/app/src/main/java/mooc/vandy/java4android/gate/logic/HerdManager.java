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
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public static final int HERD =24;
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here
    public void simulateHerd(Random rand){
        int pen = HERD;
        int pasture =0;
        int snail_count=0;
        mOut.println("There are currently "+pen+" snails in the pen and "+pasture+" snails in the pasture");
        for (int i=0;i<10;i++){
            if (pen==HERD){
                snail_count = mEastGate.thru(rand.nextInt(pen)+1);
                pen += snail_count;
                pasture = HERD - pen;
            }
            else if (pasture==HERD){
                snail_count = mWestGate.thru(rand.nextInt(pasture)+1);
                pen += snail_count;
                pasture = HERD - pen;
            }
            else{
                int whichGate = rand.nextInt(2);//0 or 1
                if (whichGate==0){//east
                    snail_count = mEastGate.thru(rand.nextInt(pen)+1);
                    pen += snail_count;
                    pasture = HERD - pen;
                }
                else if (whichGate==1){//west
                    snail_count = mWestGate.thru(rand.nextInt(pasture)+1);
                    pen += snail_count;
                    pasture = HERD - pen;
                }
            }
            mOut.println("There are currently "+pen+" snails in the pen and "+pasture+" snails in the pasture");
        }
    }

    
}
