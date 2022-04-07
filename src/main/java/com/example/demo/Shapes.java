package com.example.demo;

/**
 *Class that is an arraylist of Poly interface, use to handle large amount of Poly interfaces at once
 * @author  Jeffrey Betty
 * @version 1.0
 * @since   2021-04-02
 */
import java.util.ArrayList;

public class Shapes {

    private ArrayList<Poly> shapes;
    private int cursor =0;

    /**
     * Constructor of classs
     *
     */
    public Shapes(){

        shapes = new ArrayList<Poly>();

       /* Cir c1 = new Cir(50, 100, 100, 255, 0, 255, 50, 255, 100, 0);


        c1.addAction('s', 10);
        c1.addAction('j', 20, 3, 100);
        c1.addAction('c',90,255,0,0);

        Cir c2 = new Cir(100, 78, 0, 255, 255, 2, 0, 0, 0, 0);

        c2.addAction('s', 10);
        c2.addAction('j', 25, 100, 100);
        c2.addAction('c',100,255,255,0);
        c2.addAction('h',1000);



        shapes.add(c2);
        shapes.add(c1);

        Rect r1 = new Rect(100, 100, 500, 500, 255, 0, 0,60 , 255, 255, 255);

        r1.addAction('s', 60);
        shapes.add(r1);

        Lin l = new Lin(500, 60, 700, 120, 50);

        l.addAction('s', 10);

        shapes.add(l);


        */
    }
    /**
     * Adds effect to top poly
     * @param c is the type of action
     * @param a is the frame it starts at
     *
     */
    public void addAction(char c, int a){

        shapes.get(cursor).addAction(c, a);
    }
    /**
     * Adds poly to arraylist of polys
     * @param s (poly) the poly you want added
     *
     */
    public void add(Poly s){

        shapes.add(s);
        cursor++;
    }

    /**
     * Iterates throught the arraylist and find the polys that are visible and returns them in the form of an arraylist of polys
     * @return ArrayList<Poly> all the polys that are visble
     *
     */

    public ArrayList<Poly> getShapes(){
        this.update();

        ArrayList<Poly> temp = new ArrayList<Poly>();

        for(int i = 0; i < shapes.size();i++){

            if(shapes.get(i).isShown()){

                temp.add(shapes.get(i));
            }
        }

        return temp;
    }

    /**
     * Returns the arraylist of polys
     * @return ArrayList<Poly>
     *
     */
    public ArrayList<Poly> getAllShapes(){

        return shapes;
    }

    /**
     * Updates all the polys in the arraylist
     *
     */
    public void update(){
        cursor =0;

        for(int i = 0; i < shapes.size(); i++){

            shapes.get(i).update();
        }
    }

    /**
     * Returns all the Cir in the arraylist but int CCir form and in in arrayform
     * @return CCir[]
     */
    public CCir[] getCirs(){
        CCir[] ret;

       int counter =0;

        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof Cir){
                counter++;
            }

        }



        ret = new CCir[counter];
        for(int i =0,j=0; i < shapes.size();i++){


            if(shapes.get(i) instanceof Cir){

                ret[j] = new CCir((Cir) shapes.get(i));
                j++;
            }
        }

        return ret;

    }
    /**
     * Returns all the Rect in the arraylist but int RRect form and in in arrayform
     * @return RRect[]
     */
    public RRect[] getRects(){

        RRect[] ret;

        int counter =0;

        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof Rect){
                counter++;
            }

        }


        ret = new RRect[counter];
        for(int i =0,j=0; i < shapes.size();i++){


            if(shapes.get(i) instanceof Rect){

                ret[j] = new RRect((Rect) shapes.get(i));
                j++;
            }
        }



        return ret;
    }
    /**
     * Returns all the Lin in the arraylist but int LLine form and in in arrayform
     * @return LLine[]
     */
    public LLine[] getLins(){
        LLine ret[];

        int counter =0;

        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof Lin){
                counter++;
            }
        }


        ret = new LLine[counter];
        for(int i =0,j=0; i < shapes.size();i++){


            if(shapes.get(i) instanceof Lin){

                ret[j] = new LLine((Lin) shapes.get(i));
                j++;
            }
        }

        return ret;
    }
    /**
     * Test the polys by making them print out all there date
     */
    public void test(){

        for(int i = 0; i< shapes.size();i++){

            shapes.get(i).test();
        }
    }
}