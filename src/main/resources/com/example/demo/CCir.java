/**
 *Extends Circle class of javafx to allow for cir class to interact with circle class and animate the circle
 * @author  Liam Rocheleau
 * @version 1.0
 * @since   2021-04-02
 */

package com.example.demo;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class CCir extends Circle {

    private Cir cir;

    /**
     * Constructor of classs
     * @pararm c (cir) is the cir that you want he shape to get its date from
     *
     */
    public CCir(Cir c){
        super();

        cir =c;

        //Animates circle based off the data it gets from cir
        this.setCenterX(cir.getX());
        this.setCenterY(cir.getY());
        this.setRadius(cir.getRadius());

        this.setFill(Color.rgb(cir.getColour(0),cir.getColour(1),cir.getColour(2)));

        this.setStrokeWidth(cir.getBorderThickness());
        this.setStroke(Color.rgb(cir.getBC(0),cir.getBC(1),cir.getBC(2)));

    }
    /**
     *Updates the cir class and changes attributes if effect has taken place
     */

    public void update(){

        cir.update();
        this.setCenterX(cir.getX());//chagnges x if effect has taken place
        this.setCenterY(cir.getY());//chagnges y if effect has taken place
        this.setFill(Color.rgb(cir.getColour(0),cir.getColour(1),cir.getColour(2)));//chagnges colour if effect has taken place



        if(cir.isShown()){//chagnges visiblity if effect has taken place

            this.setOpacity(1);
        }
        else{

            this.setOpacity(0);
        }
    }
}
