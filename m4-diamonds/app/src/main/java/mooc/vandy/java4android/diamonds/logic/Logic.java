package mooc.vandy.java4android.diamonds.logic;

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
        int height = size*2 + 1;
        int width = size*2 +2;
        for (int i=1;i<=height;i++){//starts at row 1
            for (int j=1;j<=width;j++){//iterates left to right
                if ((i==1||i==height)& (j==1||j==width)){//checks corners
                    mOut.print("+");
                }
                else if ((i==1||i==height)){//checks first and last row
                    mOut.print("-");
                }
                else if(j==1||j==width){//checks first and last columns
                    mOut.print("|");
                }
                else{
                    draw(size,i,j);//checks middle of entire picture
                }

            }
            mOut.print("\n");//new line
        }
        
    }
    // TODO -- add any helper methods here
    public void draw(int size, int i, int j){
        int height = size*2 + 1;
        int width = size*2 +2;
        int midline= size+1;//the middle row
        int counter=i-1;//only used in top part of diamond (checking for amount of characters in each row)
        if (i<midline){//top part of diamond
            if (j==midline+1-counter){
                mOut.print("/");//left right part of diamond
            }
            else if(j==midline+counter){//top right part of diamond
                mOut.print("\\");
            }
            else if(j<midline+counter&j>midline+1-counter){//checks for ==== or ----
                if (i%2==0) mOut.print("=");
                else if (i%2==1) mOut.print("-");
            }
            else mOut.print(" ");
        }
        else if (i==midline){//middle line of diamond
             if (j==2){
                mOut.print("<");//middle left corner of diamond
            }
             else if (j==width-1){
                 mOut.print(">");//middle right corner of diamond
             }
             else if (midline%2==0) mOut.print("=");
             else if (midline%2==1) mOut.print("-");
        }
        else if(i>midline){//bottom of diamond
            if (j==i-midline+2){
                mOut.print("\\");//bottom left of diamond
            }
            else if (j==midline+height-i){//checks bottom right of diamond
                mOut.print("/");
            }
            else if (j>i-midline+2&j<midline+height-i){// finds ==== or ----
                if (i%2==0) mOut.print("=");
                else if (i%2==1) mOut.print("-");
            }
            else mOut.print(" ");
        }
    }


    
}
