package com.example.demo;

/**
 * interface that when implemented allows for AnCom to animate instance of interface,
 *
 * @author  Jeffrey Betty
 * @version 1.0
 * @since   2021-04-02
 */

public interface Poly {

    public int getBC(int a);//makes class return Border Colour value at a
    public int getX();//makes class return x value of class
    public int getY();//makes class return Y value of class
    public int getBorderThickness();//makes class return borderthickness of class
    public boolean isShown();//makes class return if the poly is shown or not
    public int getColour(int a);
    public void update();//update shape based off of actions
    public void addAction(char c, int a);//makes class that implements this interfce add effect of show/hide type
    public void addAction(char c, int a, int c1, int c2, int c3);//makes class that implements this interface add effect of change colour type
    public void addAction(char c, int a, int x, int y);//makes class that implements this interface add effect of jump type
    public void test();//
}