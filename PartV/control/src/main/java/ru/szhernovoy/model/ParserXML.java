package ru.szhernovoy.model;

import java.io.*;

/**
 * Created by szhernovoy on 27.09.2016.
 */
public class ParserXML {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        long timeFinish;

        if(args.length == 0){
            System.out.println("Don't get file for parsing");
            return;
        }
        else{
            try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {

              /*  String sCurrentLine;
                int position = 0;
                phraseArray = new String[5];
                while ((sCurrentLine = fileReader.readLine()) != null) {
                    if(position == phraseArray.length){
                        .phraseArray = this.getDoubleArray(phraseArray);
                    }
                    this.phraseArray[position++] = sCurrentLine;
                }
                String[] temp = new String[position];
                System.arraycopy(this.phraseArray,0,temp,0,position);
                this.phraseArray = temp;*/

            } catch (FileNotFoundException e) {
                System.out.println("File not found or not exist");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() - timeStart);
        }
    }

}
