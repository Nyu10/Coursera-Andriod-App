package mooc.vandy.java4android.calculator.logic;

import java.util.HashMap;

import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    private static final int addition=1;
    private static final int subtraction=2;
    private static final int multiplication=3;
    private static final int division=4;
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }

    

    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        // TODO - Put your code here.
        if (operation==addition){
            Add object = new Add(argumentOne,argumentTwo);
            mOut.print(object.toString());
        }
        else if (operation==subtraction){
            Subtract object = new Subtract(argumentOne,argumentTwo);
            mOut.print(object.toString());
        }
        else if (operation==multiplication){
            Multiply object = new Multiply(argumentOne,argumentTwo);
            mOut.print(object.toString());
        }
        else if (operation==division){
            if (argumentTwo==0){
                mOut.print("Error: Divide by Zero");
            }
            else{
                Divide object = new Divide(argumentOne,argumentTwo);
                mOut.print(object.toString());
            }
        }
    }
}
