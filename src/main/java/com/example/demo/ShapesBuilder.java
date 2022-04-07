/**
 *Handles file parser and return shapes class when fully parsered the file sent to it
 * @author  Gabe Bigas
 * @version 1.0
 * @since   2021-04-02
 */

package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapesBuilder {
    private int framecount = 60;
    private int fps = 60;
    private int elements = 0;
    private int section = 1;
    private int lineCount = 1;
    private int x = 0;
    private int y = 0;


    /**
     * Returns the number of frames parsered by file
     * @return framecount (int) number of frame
     */
    public int getFramecount() {
        return framecount;
    }

    /**
     * Returns the fps parsered by file
     * @return fps (int) number of frame
     */
    public int getFPS() {
        return fps;
    }

    /**
     * Takes a file path and returns shapes class parsed from file
     * @param path (Sring) the file path you want the parser to read
     * @return Shapes the shapes described in file
     */
    public Shapes buildShapes(String path) throws IOException {
        Shapes shapes = new Shapes();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {
            int wordCase = this.getType(line);
            if(wordCase>=0) {
                if (wordCase > 1) {
                    switch (wordCase) {
                        case 2://circle
                            line = br.readLine();

                            char shape = line.charAt(0);

                            int r = 0;
                            int x = 0;
                            int y = 0;
                            int bt = 0;
                            int[] colour = {0, 0, 0};

                            int[] bordercolour = {0, 0, 0};


                            while (shape == 'r' || shape == 'x' || shape == 'y' || shape == 'c' || shape == 'b') {
                                if (shape == 'r') {

                                    r = this.parseInt(line);

                                } else if (shape == 'x') {

                                    x = this.parseInt(line);


                                } else if (shape == 'c') {

                                    colour = parseInts(line);
                                } else if (shape == 'b') {
                                    bt = this.parseInt(line);
                                } else if (shape == 'y') {

                                    y = this.parseInt(line);
                                }
                                line = br.readLine();

                                shape = line.charAt(0);
                            }

                            Cir cir = new Cir(r, x, y, colour[0], colour[1], colour[2], bt, bordercolour[0], bordercolour[1], bordercolour[2]);

                            boolean stopper = false;

                            System.out.println(line);
                            while ((line.charAt(0) == 'e') && !stopper) {

                                if (line.charAt(0) == 'e' || line.charAt(0) == 'E') {
                                    line = br.readLine();
                                }
                                if (line.charAt(0) == 'J' || line.charAt(0) == 'j') {

                                    line = br.readLine();
                                    int start = this.parseInt(line);

                                    line = br.readLine();

                                    int nx = this.parseInt(line);

                                    line = br.readLine();

                                    int ny = this.parseInt(line);

                                    cir.addAction('j', start, nx, ny);

                                    line = br.readLine();

                                } else if (line.charAt(0) == 'h' || line.charAt(0) == 'H') {
                                    int start;
                                    line = br.readLine();


                                    start = this.parseInt(line);


                                    cir.addAction('h', start);
                                    line = br.readLine();

                                } else if (line.charAt(0) == 's' || line.charAt(0) == 'S') {


                                    line = br.readLine();


                                    int start = this.parseInt(line);

                                    cir.addAction('s', start);
                                    line = br.readLine();


                                }
                                if (line.isEmpty() || line.isBlank()) {
                                    break;
                                }
                            }


                            shapes.add(cir);

                            break;

                        case 3://rect

                            line = br.readLine();


                            shape = line.charAt(0);

                            r = 0;
                            x = 0;
                            y = 0;
                            bt = 0;
                            int length = 0;
                            int width = 0;
                            int[] color = {0, 0, 0};
                            int[] bcolor = {0, 0, 0};


                            while (shape == 'x' || shape == 'y' || shape == 'c' || shape == 'b' || shape == 'l' || shape == 'w') {
                                System.out.println("bruh");

                                if (shape == 'x') {

                                    x = this.parseInt(line);
                                } else if (shape == 'c') {

                                    colour = parseInts(line);
                                } else if (shape == 'b') {

                                    bt = this.parseInt(line);
                                } else if (shape == 'y') {

                                    y = this.parseInt(line);
                                } else if (shape == 'l') {

                                    length = this.parseInt(line);
                                } else if (shape == 'w') {

                                    width = this.parseInt(line);
                                }
                                line = br.readLine();

                                shape = line.charAt(0);
                            }

                            Rect rect = new Rect(width, length, x, y, color[0], color[1], color[2], bt, bcolor[0], bcolor[1], bcolor[2]);


                            while (line.charAt(0) == 'e' || line.charAt(0) == 'E' || line.charAt(0) == 'J') {//add effect rect
                                if (line.charAt(0) == 'e' || line.charAt(0) == 'E') {
                                    line = br.readLine();
                                }

                                if (line.charAt(0) == 'j' || line.charAt(0) == 'J') {

                                    line = br.readLine();

                                    int start = this.parseInt(line);

                                    line = br.readLine();

                                    int nx = this.parseInt(line);

                                    line = br.readLine();

                                    int ny = this.parseInt(line);

                                    rect.addAction('j', start, nx, ny);

                                    line = br.readLine();

                                    if(line == null){
                                        break;
                                    }
                                    //System.out.println(line);


                                }

                                 else if (line.charAt(0) == 'h' || line.charAt(0) == 'H') {

                                    int start;
                                    line = br.readLine();

                                    start = this.parseInt(line);

                                    rect.addAction('h', start);
                                }


                                if (line.charAt(0) == 's' || line.charAt(0) == 'S') {

                                    line = br.readLine();


                                    int start = this.parseInt(line);

                                    rect.addAction('s', start);
                                    line = br.readLine();

                                    System.out.println(line);

                                }

                                if(line == null||line.isEmpty()){
                                    break;
                                }



                            }

                            line = br.readLine();


                            shapes.add(rect);
                            break;

                        case 4://line

                            line = br.readLine();

                            char s = line.charAt(0);

                            int xa = 0;
                            int ya = 0;
                            int x2 =0;
                            int y2 =0;
                            int bta = 0;



                            while ( s == 'x' || s == 'y' ||  s == 'b') {
                               if (s == 'x') {

                                    x = this.parseInt(line);


                                } else if (s == 'c') {

                                    colour = parseInts(line);
                                } else if (s == 'y') {

                                    y = this.parseInt(line);
                                }
                                line = br.readLine();

                                shape = line.charAt(0);
                            }

                            Lin lin = new Lin(xa,ya,x2,y2,bta);


                            System.out.println(line);
                            while ((line.charAt(0) == 'e') ) {

                                if (line.charAt(0) == 'e' || line.charAt(0) == 'E') {
                                    line = br.readLine();
                                }
                                if (line.charAt(0) == 'J' || line.charAt(0) == 'j') {

                                    line = br.readLine();
                                    int start = this.parseInt(line);

                                    line = br.readLine();

                                    int nx = this.parseInt(line);

                                    line = br.readLine();

                                    int ny = this.parseInt(line);

                                    lin.addAction('j', start, nx, ny);

                                    line = br.readLine();

                                } else if (line.charAt(0) == 'h' || line.charAt(0) == 'H') {
                                    int start;
                                    line = br.readLine();


                                    start = this.parseInt(line);


                                    lin.addAction('h', start);
                                    line = br.readLine();

                                } else if (line.charAt(0) == 's' || line.charAt(0) == 'S') {


                                    line = br.readLine();


                                    int start = this.parseInt(line);

                                    lin.addAction('s', start);
                                    line = br.readLine();


                                }
                                if (line.isEmpty() || line.isBlank()) {
                                    break;
                                }
                            }


                            shapes.add(lin);


                            break;


                    }
                }

                else{
                    if(wordCase == 0){
                        framecount = parseInt(line);

                    }
                    else if(wordCase==1){
                        fps = parseInt(line);

                    }
            }
                }
            }

      return shapes;
    }
    /**
     * Takes a string and returns the int in the string
     * @param s the string you want to parse from
     * @return val (int) the int value you parsered from string
     */
    public int parseInt(String s){
        s = s.replaceAll("[^\\d]", "");
        int val = Integer.parseInt(s);

        return val;
    }
    /**
     * Takes a string and a substring and checks if the substring is in the main string
     * @param substring the string you are looking for
     * @param main the string you are looking from
     * @return boolean value true if substring is main, false if not
     */
    public  boolean contains(String main, String Substring) {
        boolean flag = false;
        if (main == null && main.trim().equals("")) {
            return flag;
        }
        if (Substring == null) {
            return flag;
        }

        char fullstring[] = main.toCharArray();
        char sub[] = Substring.toCharArray();
        int counter = 0;
        if (sub.length == 0) {
            flag = true;
            return flag;
        }

        for (int i = 0; i < fullstring.length; i++) {

            if (fullstring[i] == sub[counter]) {
                counter++;
            } else {
                counter = 0;
            }

            if (counter == sub.length) {
                flag = true;
                return flag;
            }

        }
        return flag;
    }

    /**
     * Parses a String returns mutiply ints in arrayfrom
     * @param s the string you want to parse from
     * @return val[] (int) the ints values you parsered from string
     */
    public int[] parseInts(String s){

        String[] split = s.split("[^\\d]+");
        int number;
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        for(int index = 0; index < split.length; index++){
            try{
                number = Integer.parseInt(split[index]);
                numberList.add(number);
            }catch(Exception exe){

            }
        }

        Integer[] numberArray = numberList.toArray(new Integer[numberList.size()]);


        return arrayint(numberArray);
    }
    /**
     * takes and array of Integer and return array of ints
     * @param n[] Integer array you want parser
     * @return n[] int array you want
     */
    public int[] arrayint(Integer[] n){

        int[] ret = new int[n.length];

        for(int i = 0; i < ret.length; i++){

            ret[i] = n[i].intValue();

        }

        return ret;
    }
    /**
     * Gets a string and see if any values are in it returns a specail number if value is in it that the program is looking for
     *
     */
    private int getType(String s){
        String[] types = {"frames","speed","Circle","Rect","Line"};

        for(int i = 0; i < types.length; i++){

            if(this.contains(s,types[i])){
                System.out.println(types[i]);

                return i;
            }

        }
        return -1;
    }
}