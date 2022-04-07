package com.example.demo;
/**
 * This class handles arraylist of actions (effects) give to a poly
 *
 * @author  Jeffrey Betty
 * @version 1.0
 * @since   2021-04-02
 */
import java.util.ArrayList;

public class ActionHandler {

    private ArrayList<Action> actions = new ArrayList<Action>();

    private Action nextAction;//top action


    /**
     * Adds action to action (arraylist of actions) for hide/show effect
     * @param c (char) type of effect being added
     * @param a (int) when the effect will be activated
     */
    public void addAction(char c, int a){

        actions.add(new Action(c,a));
    }

    /**
     * Adds action to action (arraylist of actions) for change colour effect
     * @param c (char) type of effect being added
     * @param a (int) when the effect will be activated
     * @param c1 (int) R value of colour
     * @param c2 (int) G value of colour
     * @param c3 (int) B value of colour
     */
    public void addAction(char c, int a, int c1, int c2, int c3){

        actions.add(new Action(c, a, c1, c2, c3));
    }

    /**
     * Adds action to action (arraylist of actions) for jump effect
     * @param c (char) type of effect being added
     * @param a (int) when the effect will be activated
     * @param x (int) jumpX value of jump effect
     * @param y (int) jumpY value of jump effect
     */
    public void addAction(char c, int a, int x, int y){

        actions.add(new Action(c, a, x, y));
    }

    /**
     * Checks if action occurs of on frame
     * @param a (int) what frame to check if effect is on
     * @return boolean value if there is and effect on frame (a)
     */
    public boolean isAction(int a){

        for(int i = 0; i < actions.size(); i++){

            if(actions.get(i).isActionOnFrame(a)){

                nextAction = actions.get(i);//adds action at index to nextAction, so poly above can access it

                actions.remove(i);//removes it from index so it is not triggered again

                return true;
            }
        }

        return false;
    }

    /**
     * Gets type of effect from next Action
     * @return char of what type the effect is
     */
    public char getType(){

        return nextAction.getType();
    }

    /**
     * Gets jumpx value from nextAction
     * @return jumpx (int) value of nextAction
     */
    public int getJumpX(){

        return nextAction.getJumpX();
    }
    /**
     * Gets jumpY value from nextAction
     * @return jumpY (int) value of nextAction
     */
    public int getJumpY(){

        return nextAction.getJumpY();
    }
    /**
     * Gets Colour value from nextAction of change color effect
     * @param a (int) what colour value return (0,1,2) -> (R,B,G)
     * @return colour value (int) of change colour effect from next action
     */
    public int getColour(int a){

        return nextAction.getColour(a);
    }
    /**
     * Method tests class by printing out all data of class
     */
    public void test(){
        for(int i =0; i < actions.size(); i++){

            actions.get(i).test();
        }

    }
}