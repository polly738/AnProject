package com.example.demo;
/**
 * Class keeps track of singular effect (action) given to a poly (rect,line,cir)
 *
 * @author  Jeffrey Betty
 * @version 1.0
 * @since   2021-04-02
 */
public class Action {
    private int startFrame;
    private char type;
    private int colour[];
    private int jumpX;
    private int jumpY;

    /**
     * Constuctor for making hide/show effect
     * @param c type of effect, in this case hide or show
     * @param a frame when effect takes action
     */
    public Action(char c, int a){

        type = c;
        startFrame = a;
    }

    /**
     * Constuctor for making change colour effect
     * @param c type of effect, in this case hide or show
     * @param a frame when effect takes action
     * @param c1 R value of changing colour value
     * @param c2 G value of changing colour value
     * @param c3 B value of changing colour value
     *
     */
    public Action(char c, int a, int c1, int c2, int c3){

        type = c;
        colour = new int[3];
        startFrame = a;

        colour[0] = c1;
        colour[1] = c2;
        colour[2] = c3;

    }

    /**
     * Constuctor for making jump effect
     * @param c type of effect, in this case hide or show
     * @param a frame when effect takes action
     * @param x jumpX value
     * @param y jumpY value
     */
    public Action(char c, int a,int x, int y){

        type = c;

        jumpX = x;
        jumpY = y;

        startFrame = a;
    }

    /**
     * Method that returns start frame value
     * @return startFrame integer value (when the effect is to take place)
     */
    public int getStartFrame(){

        return startFrame;
    }

    /**
     * Method that returns a singular colour value of change colour effect
     * @param a what colour value you want to return (0,1,2) -> (R,G,B)
     * @return colour returns int value of specified colour value
     */
    public int getColour(int a){

        return colour[a];
    }

    /**
     * Method that returns type of effect in form of char
     * @return type (char value) of what type of effect
     */
    public char getType(){

        return type;
    }

    /**
     * Method that returns jumpX value of jumpX effect
     * @return jumpX (int value) of jumpX effect
     */
    public int getJumpX(){

        return jumpX;
    }

    /**
     * Method that returns jumpY value of jumpY effect
     * @return jumpY (int value) of jumpY effect
     */
    public int getJumpY(){

        return jumpY;
    }

    /**
     * Method that an int value(frame) and check if effect occurs on this value
     * and return
     * @param a is the number used to check if event occurs on that number
     * @return boolen value, true if effect occurs on the frame, false if not
     */
    public boolean isActionOnFrame(int a){

        if(a == startFrame){

            return true;
        }

        else{

            return false;
        }
    }


    /**
     * Method tests class by printing out all data of class
     */
    public void test(){
        switch(type){
            case 'c':
                System.out.printf("Colour Change R G B %d %d %d start: %d",this.getColour(0),this.getColour(1),this.getColour(2),this.getStartFrame());

                break;

            case 'j':

                System.out.printf("Jump x y %d %d start: %d",this.getJumpX(),this.getJumpY(),this.getStartFrame());

                break;

            case 'h':
                System.out.printf("Hide  start: %d",this.getStartFrame());

                break;

            case 's':
                System.out.printf("Show  start: %d",this.getStartFrame());

                break;


        }

        System.out.println();

    }
}//end class