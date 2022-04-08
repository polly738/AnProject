/**
 *Extends Rectangle class of javafx to allow for Rect class to interact with Rect class and animate the circle
 *
 * @author  Taaha Abdullah
 * @version 1.0
 * @since   2021-04-02
 */

package com.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Constructor of classs
 * @pararm l (lin) is the lin  you want the shape to get its date from
 *
 */
public class LLine extends Line {
    private Lin line;
    public LLine(Lin l){
        super();

        line =l;
        this.setStartX(line.getX());
        this.setStartY(line.getY());
        this.setEndX(line.getX2());
        this.setEndY(line.getY2());
        this.setStrokeWidth(line.getBorderThickness());
        this.setStroke(Color.rgb(line.getColour(0),line.getColour(1),line.getColour(2)));


    }
    /**
     * Update
     * Updates the frame and if effect occured changes the attributes based off of that effect
     *
     */
    public void update(){

        line.update();
        this.setStroke(Color.rgb(line.getColour(0),line.getColour(1),line.getColour(2)));
        this.setStartX(line.getX());
        this.setStartY(line.getY());


        if(line.isShown()){

            this.setOpacity(1);
        }
        else{

            this.setOpacity(0);
        }
    }
}
