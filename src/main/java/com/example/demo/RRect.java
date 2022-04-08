/**
 *Extends Line class of javafx to allow for Line class to interact with lin class and animate the line
 *
 * @author  Gabriel Bigas
 * @version 1.0
 * @since   2021-04-02
 */

package com.example.demo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RRect extends Rectangle {

    Rect r;
    /**
     * Constructor of classs
     * @pararm rect (Rect) is the Rect that you want the shape to get its data from
     *
     */
    public RRect(Rect rect){
        super();

        r = rect;

        this.setX(r.getX());
        this.setY(r.getY());
        this.setWidth(r.getWidth());
        this.setHeight(r.getLength());

        this.setFill(Color.rgb(r.getColour(0),r.getColour(1),r.getColour(2)));
        this.setStrokeWidth(r.getBorderThickness());
        this.setStroke(Color.rgb(r.getBC(0),r.getBC(1),r.getBC(2)));
    }

    /**
     * Updates all the attributes based off the effects that occur in the rect class
     *
     */
    public void update(){
        r.update();
        this.setX(r.getX());
        this.setY(r.getY());
        this.setFill(Color.rgb(r.getColour(0),r.getColour(1),r.getColour(2)));

        if(r.isShown()){
            this.setOpacity(1);
        }
        else{
            this.setOpacity(0);
        }
    }
}
