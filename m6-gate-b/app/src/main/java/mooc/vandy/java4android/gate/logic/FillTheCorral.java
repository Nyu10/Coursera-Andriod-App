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

    // TODO -- Fill your code in here
    public void setCorralGates(Gate [] gate, Random rand){
        mOut.println("Initial Gate Setup:");
        for (int i=0;i<3;i++) {
            int randomNumber = rand.nextInt(3) - 1;
            gate[i].setSwing(randomNumber);
            mOut.println("Gate "+i +": "+gate[i].toString());
        }
    }
    public boolean anyCorralAvailable(Gate [] corral){
        for (Gate x:corral){
            if (x.getSwingDirection()==Gate.IN){
                return true;
            }
        }
        return false;
    }
    public int corralSnails(Gate [] corral, Random rand){
        int pasture = 5;
        int attempts = 0;
        int randomNumber = 0;
        int randomGate = 0;
        do {
            randomGate = rand.nextInt(corral.length);
            randomNumber = rand.nextInt(pasture)+1;
            mOut.println(randomNumber + " are trying to move through corral " + randomGate);
            pasture-=corral[randomGate].thru(randomNumber);
            attempts++;
        } while(pasture != 0);
        mOut.println("It took "+attempts+" attempts to corral all of the snails.");
        return attempts;
    }
}
