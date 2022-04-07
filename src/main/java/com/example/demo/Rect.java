package com.example.demo;

/**
 * Class implements Poly interface to make a Rect shape that AnCom can animate
 *
 * @author  Jeffrey Betty
 * @version 1.0
 * @since   2021-04-02
 */
public class Rect implements Poly{


    private int borderThickness;
    private int[] bColour= new int[3];
    private int[] colour = new int[3];
    private int x;
    private int y;
    private int frame =0;
    private boolean shown;
    private int width;
    private int length;
    private ActionHandler actions = new ActionHandler();

    /**
     * Constructor of method
     * @param llenght lenght value param (int)
     * @param wwidth width value param (int)
     * @param xi x value param (int)
     * @param yi y value param (int)
     * @param c1 R colour param value (int)
     * @param c2 G colour param value (int)
     * @param c3 B colour param value (int)
     * @param bt borderthickness parm value (int)
     * @param b1 R colour value param of border colour (int)
     * @param b2 G colour value param of border colour (int)
     * @param b3 B colour value param of border colour (int)
     */
    public Rect(int llength, int wwidth,int xi, int yi,int c1, int c2, int c3, int bt, int b1, int b2, int b3){

        width = wwidth;
        length= llength;

        x= xi;
        y = yi;
        borderThickness = bt;

        bColour[0] = b1;
        bColour[1] = b2;
        bColour[2] = b3;
        colour[0] = c1;
        colour[1] = c2;
        colour[2] = c3;

        shown = false;

    }

    /**
     * Method returns width value of object
     * @return width (int)
     */

    public int getWidth(){
        return width;
    }

    /**
     * Method returns width value of object
     * @return width (int)
     */
    public int getLength(){

        return length;
    }

    /**
     * Implemented for Poly interface, gets Border Colour value
     * @param a (int) what border colour value is returnerd (0,1,2) -> (R,G,B)
     * @return border colour value (int) at value speficied
     */
    @Override
    public int getBC(int a){

        return bColour[a];
    }

    /**
     * Implemented for Poly interface, returns x value of calss
     *@return x value of class (int)
     */
    @Override
    public int getX(){

        return x;
    }
    /**
     * Implemented for Poly interface, returns y value of calss
     *@return y value of class (int)
     */
    @Override
    public int getY(){

        return y;
    }

    /**
     * Implemented for Poly interface returns border thickness of class
     *@return border thickness of class (int)
     */
    @Override
    public int getBorderThickness(){

        return borderThickness;
    }

    /**
     * Implemented for Poly interface return if the poly is suposed to be shown
     *@return boolean value true if the object is shown false if not
     */
    @Override
    public boolean isShown(){

        return shown;
    }

    /**
     * Implemented for Poly interface, gets Colour value
     * @param a (int) what colour value is returnerd (0,1,2) -> (R,G,B)
     * @return colour value (int) at value speficied
     */
    @Override
    public int getColour(int a){

        return colour[a];
    }

    /**
     * Implemented for Poly interface
     *Updates the cir on all its attributes if effect is to change them on the frame
     */
    @Override
    public void update(){

        frame++;

        while(actions.isAction(frame)){

            char type = actions.getType();

            switch(type){

                case 'j': //jump
                    x = actions.getJumpX();
                    y = actions.getJumpY();
                    break;

                case 'h'://hide
                    shown= false;
                    break;

                case 's'://show
                    shown = true;
                    break;

                case 'c'://change colour
                    colour[0] = actions.getColour(0);
                    colour[1] = actions.getColour(1);
                    colour[2] = actions.getColour(2);

                    break;
            }
        }
    }

    /**
     * Method implement for Poly interface Adds actions to actions (arraylist of actions) for hide/show effect
     * @param c (char) type of effect being added
     * @param a (int) when the effect will be activated
     */
    @Override
    public void addAction(char c, int a){

        actions.addAction(c, a);
    }
    /**
     * Method implemented for poly interface Adds actions to actions (arraylist of actions) for change colour effect
     * @param c (char) type of effect being added
     * @param a (int) when the effect will be activated
     * @param c1 (int) R value of colour
     * @param c2 (int) G value of colour
     * @param c3 (int) B value of colour
     */
    @Override
    public void addAction(char c, int a, int c1, int c2, int c3){

        actions.addAction(c, a, c1, c2, c3);
    }

    /**
     * Adds action to action (arraylist of actions) for jump effect
     * @param c (char) type of effect being added
     * @param a (int) when the effect will be activated
     * @param x (int) jumpX value of jump effect
     * @param y (int) jumpY value of jump effect    */
    @Override
    public void addAction(char c, int a, int x, int y){

        actions.addAction(c, a, x, y);

    }

    /**
     * Method tests class by printing out all data of class
     */
    @Override
    public void test() {
        System.out.println("X Y Width Length" + this.getX()+ " "+ this.getY()+ " "+ this.getWidth()+" " + this.getLength());
        System.out.println("BorderThickness" + this.getBorderThickness());
        System.out.println("R G B "+ this.getColour(0) + " "+ this.getColour(1)+ " "+ this.getColour(2) );
        System.out.println("BorderColour R G B "+ this.getBC(0) + " "+ this.getBC(1)+ " "+ this.getBC(2) );
        System.out.println();

        actions.test();

    }
}