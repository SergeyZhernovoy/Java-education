package ru.szhernovoy.treads1;

import java.io.*;

/**
 * Created by szhernovoy on 08.10.2016.
 */
public class CounterValuesText {


    /** path to directory with file */
    private final String PATH;
    /**Object for agregate string from file */
    private final StringBuilder builder;

    public CounterValuesText(final String path){
          this.PATH = path;
          this.builder = new StringBuilder();

    }

    /**
     * Read file and get string from file
     * @param fileName
     * @return
     */
    public String readTxtFile(String fileName){
        String fullName  = String.format("%s%s%s",this.PATH, File.separator,fileName);
        File file = new File(fullName);

        if(file.exists() && file.canRead() && file.isFile()){
            try(BufferedReader in = new BufferedReader(new FileReader(fullName))){
                String next = null;
                while((next = in.readLine()) != null){
                    builder.append(String.format("%s\n",next));
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not exist");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.builder.toString();
    }



    public static void main(String[] args) {


        if(args.length > 0){
            CounterValuesText obj = new CounterValuesText(args[0]);
            String text = obj.readTxtFile(args[1]);
            TokenCounter.TokenThread threadSpace = new TokenCounter(true,text).new TokenThread();
            TokenCounter.TokenThread threadWord = new TokenCounter(false,text).new TokenThread();
            new Thread(threadWord).start();
            new Thread(threadSpace).start();
        }


    }


}
