/**
 *Handles file parser and return shapes class when fully parsered the file sent to it
 * @author  Gabe Bigas
 * @version 1.0
 * @since   2021-04-02
 */

package com.example.demo;

import java.io.*;
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
     * @throws IOException as this does read a file
     * @param  path (Sring) the file path you want the parser to read
     * @return Shapes the shapes described in file
     */
    public Shapes buildShapes(String path) throws IOException {
        Shapes shapes = new Shapes();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while ((line = br.readLine()) != null) {//reads until null
            int type = this.getType(line);
            if(type == 0){

                this.framecount = this.parseInt(line,200);
                line =br.readLine();

            }

            else if(type ==1){
                this.fps = this.parseInt(line,10);
                line =br.readLine();

            }
            else  if(type ==2){
                int x =0;
                int y = 0;
                int bt = 0;
                int[] colour= {0,0,0};
                int [] bc = {0,0,0};
                int r =0;

                while((line = br.readLine())!= null && !line.isEmpty() && !line.equalsIgnoreCase("effect") ){
                    if(line.charAt(0) == 'x' || line.charAt(0) =='X'){
                        x = this.parseInt(line,x);
                    }
                    if(line.charAt(0) == 'y' || line.charAt(0) =='Y'){
                        y = this.parseInt(line,y);

                    }
                    if(line.charAt(0) == 'b' || line.charAt(0) =='B'){
                        if(this.contains(line,"BorderColour")|| this.contains(line,"bordercolor")){
                            bc = this.parseInts(line,bc);

                        }
                        else{
                            bt = this.parseInt(line,bt);

                        }

                    }
                    if(line.charAt(0) == 'r' || line.charAt(0) =='R'){
                        r = this.parseInt(line,r);


                    }
                    if(line.charAt(0) == 'c' || line.charAt(0) =='C'){
                        colour = this.parseInts(line,colour);


                    }
                    if(line.equalsIgnoreCase("effect")){
                        break;
                    }
                }

                Cir circle = new Cir(r,x,y,colour[0],colour[1],colour[2],bt,bc[0],bc[1],bc[2]);

                while((line = br.readLine())!= null&&!line.isEmpty()&&!line.isBlank()){

                    if(line.charAt(0)=='h'|| line.charAt(0)=='H'){

                        line =br.readLine();

                        int start = this.parseInt(line,10);

                        circle.addAction('h', start);

                    }
                   else if(line.charAt(0)=='J'|| line.charAt(0)=='j'){

                        line =br.readLine();
                        int start = this.parseInt(line,10);

                        line = br.readLine();
                        int xa = this.parseInt(line,10);
                        line =br.readLine();

                        int ya = this.parseInt(line,10);

                        circle.addAction('j', start,x,y);

                    }
                    else if(line.charAt(0)=='S'|| line.charAt(0)=='s'){

                        line =br.readLine();

                        int start = this.parseInt(line,10);

                        circle.addAction('s', start);

                    }
                    else if(line.charAt(0)=='c'|| line.charAt(0)=='C'){

                        int[] cl = {0,0,0};
                        line =br.readLine();
                        System.out.println(line);
                        int start = this.parseInt(line,10);
                        line =br.readLine();


                        cl = this.parseInts(line,cl);


                        circle.addAction('c', start,cl[0],cl[1],cl[2]);
                    }



                }

                shapes.add(circle);
            }

            else if(type ==3){
                int x =0;
                int y = 0;
                int bt = 0;
                int[] colour= {0,0,0};
                int [] bc = {0,0,0};
                int length =0;
                int width =0;

                while((line = br.readLine())!= null && !line.isEmpty() && !line.equalsIgnoreCase("effect") ){
                    if(line.charAt(0) == 'x' || line.charAt(0) =='X'){
                        x = this.parseInt(line,x);
                    }
                    if(line.charAt(0) == 'y' || line.charAt(0) =='Y'){
                        y = this.parseInt(line,y);

                    }
                    if(line.charAt(0) == 'b' || line.charAt(0) =='B'){
                        if(this.contains(line,"BorderColour")|| this.contains(line,"bordercolor")){
                            bc = this.parseInts(line,bc);

                        }
                        else{
                            bt = this.parseInt(line,bt);

                        }

                    }
                    if(line.charAt(0) == 'l' || line.charAt(0) =='L'){
                        length = this.parseInt(line,length);


                    }

                    if(line.charAt(0) == 'w' || line.charAt(0) =='W'){
                        width = this.parseInt(line,width);


                    }
                    if(line.charAt(0) == 'c' || line.charAt(0) =='C'){
                        colour = this.parseInts(line,colour);


                    }
                    if(line.equalsIgnoreCase("effect")){
                        break;
                    }
                }

                Rect rect = new Rect(length,width,x,y,colour[0],colour[1],colour[2],bt,bc[0],bc[1],bc[2]);

                while((line = br.readLine())!= null&&!line.isEmpty()&&!line.isBlank()){

                    if(line.charAt(0)=='h'|| line.charAt(0)=='H'){

                        line =br.readLine();

                        int start = this.parseInt(line,10);

                        rect.addAction('h', start);

                    }
                    else if(line.charAt(0)=='J'|| line.charAt(0)=='j'){

                        line =br.readLine();
                        int start = this.parseInt(line,10);

                        line = br.readLine();
                        int xa = this.parseInt(line,10);
                        line =br.readLine();

                        int ya = this.parseInt(line,10);

                        rect.addAction('j', start,x,y);

                    }
                    else if(line.charAt(0)=='S'|| line.charAt(0)=='s'){

                        line =br.readLine();

                        int start = this.parseInt(line,10);

                        rect.addAction('s', start);

                    }
                    else if(line.charAt(0)=='c'|| line.charAt(0)=='C'){

                        int[] cl = {0,0,0};
                        line =br.readLine();
                        System.out.println(line);
                        int start = this.parseInt(line,10);
                        line =br.readLine();


                        cl = this.parseInts(line,cl);


                        rect.addAction('c', start,cl[0],cl[1],cl[2]);
                    }



                }

                shapes.add(rect);

            }

            else if(type ==4){
                int x =0;
                int y = 0;
                int bt = 0;
                int x2 =0;
                int y2=0;
                int[] colour= {0,0,0};


                while((line = br.readLine())!= null && !line.isEmpty() && !line.equalsIgnoreCase("effect") ){
                    if(line.charAt(0) == 'x' || line.charAt(0) =='X'){
                        if(this.contains(line,"x2")){

                            int[] l={0,0};
                            int[] a = this.parseInts(line,l);

                            x2 = a[1];

                        }
                        else {
                            x = this.parseInt(line, x);

                        }
                    }
                    if(line.charAt(0) == 'y' || line.charAt(0) =='Y'){


                        if(this.contains(line,"y2")){


                            int[] l={0,0};
                            int[] a = this.parseInts(line,l);

                            y2 = a[1];

                        }

                        else {
                            y = this.parseInt(line, y);
                        }
                    }
                    if(line.charAt(0) == 'b' || line.charAt(0) =='B'){

                        bt = this.parseInt(line,bt);
                    }

                    if(line.charAt(0) == 'c' || line.charAt(0) =='C'){

                        colour = this.parseInts(line,colour);
                    }
                    if(line.equalsIgnoreCase("effect")){
                        break;
                    }
                }

                Lin lin = new Lin(x,y,x2,y2,colour[0],colour[1],colour[2],bt);

                while((line = br.readLine())!= null&&!line.isEmpty()&&!line.isBlank()){

                    if(line.charAt(0)=='h'|| line.charAt(0)=='H'){

                        line =br.readLine();

                        int start = this.parseInt(line,10);

                        lin.addAction('h', start);

                    }
                    else if(line.charAt(0)=='J'|| line.charAt(0)=='j'){

                        line =br.readLine();
                        int start = this.parseInt(line,10);

                        line = br.readLine();
                        int xa = this.parseInt(line,10);
                        line =br.readLine();

                        int ya = this.parseInt(line,10);

                        lin.addAction('j', start,x,y);

                    }
                    else if(line.charAt(0)=='S'|| line.charAt(0)=='s'){

                        line =br.readLine();

                        int start = this.parseInt(line,10);

                        lin.addAction('s', start);

                    }
                    else if(line.charAt(0)=='c'|| line.charAt(0)=='C'){

                        int[] cl = {0,0,0};
                        line =br.readLine();
                        System.out.println(line);
                        int start = this.parseInt(line,10);
                        line =br.readLine();


                        cl = this.parseInts(line,cl);


                        lin.addAction('c', start,cl[0],cl[1],cl[2]);
                    }



                }

                shapes.add(lin);


            }




        }
        return shapes;
    }

    /**
     * Takes a string and parse an int it it is in the string returns a backup if not
     * @param s string you want parsed
     * @param backup int you want returned if there is no integer to parse
     * @return int value, the value from the string if it exist backup if it does not
     */
    public int parseInt(String s, int backup){
        if(!this.containsInt(s)){

            return backup;
        }
        s = s.replaceAll("[^\\d]", "");
        int val = Integer.parseInt(s);

        return val;
    }

    /**
     * Checks if a string has a numerial in it
     * @param s
     * @return boolean value true if it does contain a numerial false if not
     */
    public boolean containsInt(String s){

        for(int i = 0;i< s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {

                return true;
            }

        }
        return false;

    }

    /**
     * Takes a string and a substring and checks if the substring is in the main string
     * @param substring the string you are looking for
     * @param main the string you are looking from
     * @return boolean value true if substring is main, false if not
     */
    public  boolean contains(String main, String substring) {
        if(main == null || substring == null) return false;

        final int length = substring.length();
        if (length == 0)
            return true;

        for (int i = main.length() - length; i >= 0; i--) {
            if (main.regionMatches(true, i, substring, 0, length))
                return true;
        }
        return false;
    }

    /**
     * Parses a String returns mutiply ints in arrayfrom
     * @param s the string you want to parse from
     * @return val[] (int) the ints values you parsered from string
     */
    public int[] parseInts(String s,int[] backup){

        if(!this.containsInt(s)){
            return backup;
        }

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

        int[] ret = arrayint(numberArray);

        if(ret.length==backup.length){
            return ret;

        }

        else{
            return backup;
        }
    }

    /**
     * takes and array of Integer and return array of ints
     * @param  n Integer array you want parser
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
        String[] types = {"frames","speed","Circle","Rect","Line","effect"};

        for(int i = 0; i < types.length; i++){

            if(this.contains(s,types[i])){

                return i;
            }

        }
        return -1;
    }

}