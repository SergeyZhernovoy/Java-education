package ru.szhernovoy;

import java.io.*;
import java.util.Random;

/**
 * Created by admin on 19.07.2016.
 */
public class ChatConsole {
    private final String STOP = "стоп";
    private final String CONTINUE = "продолжить";
    private final String EXIT = "закончить";
    private final String FILEPHRASE = String.format("%s%sChat.txt",System.getProperty("user.home"), File.separator);
    private final IO io;
    private StringBuilder chatMessages;
    private String[] phraseArray;

    public ChatConsole(final IO io){
        this.io = io;
        this.chatMessages = new StringBuilder();
    }

    public void init()  {
        BufferedReader fileReader;
        try {
            File file =new File(FILEPHRASE);
            if(!file.exists()){
                file.createNewFile();
                String data = " This content will append to the end of the file";
                BufferedWriter bufferWritter = new BufferedWriter(new FileWriter(file.getName(),true));
                bufferWritter.write(data);
                bufferWritter.close();
            }
            fileReader  = new BufferedReader(new FileReader(FILEPHRASE));
            String sCurrentLine;
            int position = 0;
            this.phraseArray = new String[5];
            while ((sCurrentLine = fileReader.readLine()) != null) {
                 if(position == phraseArray.length){
                     this.phraseArray = this.getDoubleArray(phraseArray);
                 }
                 this.phraseArray[position++] = sCurrentLine;
            }
            String[] temp = new String[position];
            System.arraycopy(this.phraseArray,0,temp,0,position);
            this.phraseArray = temp;
            fileReader.close();
        }
       catch (FileNotFoundException e) {
            this.io.println(String.format("File %s not found or not exist",FILEPHRASE));
       }
        catch (IOException e) {
            e.printStackTrace();
       }
    }

    private String[] getDoubleArray(String[] array){
        int doubleSize = array.length*2;
        String[] doubleArray = new String[doubleSize];
        System.arraycopy(array,0,doubleArray,0,array.length);
        return doubleArray;
    }

    public String getRandomLine(){
        String sCurrentLine;
        //int random = new Random().nextInt(phraseArray.length);
        return phraseArray[new Random().nextInt(phraseArray.length)];
    }

    private String getInput() {
        return  io.read();
    }

    public void work(){
        String input,phrase;
        boolean getPrhase = true;
        this.io.println("Welcome to chat...");
        this.io.print("you :");
        while(!(input = this.getInput()).equalsIgnoreCase(EXIT)){
            this.setString(input);

            if(input.equalsIgnoreCase(STOP)){
               getPrhase = false;
            }

            if(input.equalsIgnoreCase(CONTINUE)){
                getPrhase = true;
            }

            if(getPrhase){
                phrase =  this.getRandomLine();
                this.setString(phrase);
                this.io.println(String.format("answer: %s",phrase));
            }
            this.io.print("you :");
        }
        this.setString(input);

        LogWriter lgwr = null;
        try {
            lgwr = new LogWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lgwr.init();
        lgwr.writeLog(chatMessages.toString());
    }

    public void setString(String msg){
        this.chatMessages.append(String.format("\n%s",msg));
    }

    public static void main(String[] args) {
        ChatConsole cht = new ChatConsole(new ConsoleIO(new BufferedReader(new InputStreamReader(System.in)),  System.out));
        cht.init();
        cht.work();
    }

}
