package com.example.demo;
/**
 *Javafx class handles the animate and stitches together most of the logic
 *
 * @author  Jeff Betty
 * @version 1.0
 * @since   2021-04-02
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class AnimationPlayer extends Application {
    private Pane root = new Pane();

    private int fps = 12;

    private int lastFrame =200;
    private int frameCount =0;


    private Shapes shapes = new Shapes();
    private CCir[] circles;
    private RRect[] rectangles;
    private LLine[] lines;

    /**
     * Method builds pane for scene builder to animate
     * @throws IOException the method reads a files
     * @return Parent returns panes for the scene builder to animate
     */


    private Parent getContent() throws IOException {
       ShapesBuilder b = new ShapesBuilder();//makes a shape builder
       shapes = b.buildShapes("input.txt");//parses file

       fps = b.getFPS();//gets fps
       lastFrame = b.getFramecount();//gets last frame

        //bundles all shapes into there proper form
        circles = shapes.getCirs();
        rectangles = shapes.getRects();
        lines = shapes.getLins();


        root.setPrefSize(1000,1000);//sets the dimension of pane


        Label label = new Label();//add label and set conditoin

        label.setTextFill(Color.BROWN);


        label.setTranslateX(150);
        label.setTranslateY(25);



        AnimationTimer timer = new AnimationTimer() {//makes timer



            private long lastRun = 0;

            double elasped = 0;
            double counter = 0;
            int lastFrame =0;

            int divisor = 60/fps;

            int frames =0;
            @Override
            public void handle(long now) {
                counter++;

                frames =(int)Math.floor( counter/divisor);// keeps track of frame int proper frame rate
                if(frames > lastFrame){
                    lastFrame = frames;

                    try {
                        update();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }



                String text = "Current: " + Double.toString(frames);

                label.setText(text);
            }
        };

        //adds shapes to pane

         for(int i = 0; i < circles.length;i++) {

             root.getChildren().add(circles[i]);
         }
         for(int i = 0; i < rectangles.length; i++){

             root.getChildren().add(rectangles[i]);
         }
         for(int i = 0; i < lines.length;i++){

             root.getChildren().add(lines[i]);
         }
        root.getChildren().add(label);

        timer.start();//starts timer

        return root;
    }

    /**
     *updates all the shapes on there conditions
     * Throws an exception as the system does ext
     * @throws Exception as the system exits
     */

    public void update() throws Exception {//Updates all types of shapes to next frame
            frameCount++;


            if(frameCount >= lastFrame){//exits pane if frames equals lastFrame
            System.exit(0);
        }

        for(int i = 0; i < circles.length;i++){//Updates Circles

            circles[i].update();
        }

        for(int i = 0; i < rectangles.length;i++){//Updates Rectangles

            rectangles[i].update();
        }

        for(int i =0;i < lines.length; i++){//Updates Lines

            lines[i].update();
        }

    }

    /**
     *Starts the stage
     * @throws IOException since this is a javafx application and that can go wrong
     *
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(getContent()));
        stage.show();


    }

    /**
     *Starts the program
     *
     */
    public static void main(String[] args){
        launch(args);
    }
}