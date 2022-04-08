package com.example.demo;

/**
 * Class implements Poly interface to make a Line that AnCom can animate
 *
 * @author  Jeffrey Betty
 * @version 1.0
 * @since   2021-04-02
 */
public class Lin implements Poly{


    private int borderThickness;

    private int x;
    private int y;
    private int x2;
    private int y2;
    private int c[];
    private int frame =0;
    private boolean shown;

    private ActionHandler actions = new ActionHandler();

    /**
     * Constructor of method
     * @param xi x value param (int)
     * @param yi y value param (int)
     * @param xi2 x2  param value (int)
     * @param yi2 y2  param value (int)
     */
    public Lin(int xi, int yi,int xi2,int yi2,int c1,int c2,int c3, int bt){
        c= new int[3];
        x= xi;
        y = yi;
        y2 = yi2;
        x2= xi2;
        borderThickness = bt;
        c[0] =c1;
        c[1] =c2;
        c[2] =c2;

        shown = false;
    }


    /**
     * returns x2 value of line object
     * @return x2 value (int)
     */
    public int getX2(){

        return x2;
    }

    /**
     * returns y2 value of line object
     * @return y2 value (int)
     */
    public int getY2(){
        return y2;
    }

    /**
     * Implemented for Poly interface, gets Border Colour value
     * @param a (int) what border colour value is returnerd (0,1,2) -> (R,G,B)
     * @return border colour value (int) at value speficied
     */
    @Override
    public int getBC(int a){

        return -1;
    }

    /**
     * Implemented for Poly interface, returns x value of class
     *@return x value of class (int)
     */
    @Override
    public int getX(){

        return x;
    }

    /**
     * Implemented for Poly interface, returns y value of class
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

        return c[a];
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
        System.out.println("Lin");
        System.out.println("X Y X2 Y2 Bt"+ this.getX()+" " + this.getY()+" "+ this.getX2()+" " + this.getY2() +" " + this.getBorderThickness());
        System.out.println("BorderThicknes " + this.getBorderThickness());
        actions.test();
        System.out.println();


    }
}
