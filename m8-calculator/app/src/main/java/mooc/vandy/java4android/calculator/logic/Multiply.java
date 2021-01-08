package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply {
    // TODO - add your solution here.
    private int argument1=0;
    private int argument2 =0;
    public Multiply(int arg1, int arg2){
        this.argument1=arg1;
        this.argument2=arg2;
    }
    public String toString(){
        return ""+(argument1*argument2);
    }
}
