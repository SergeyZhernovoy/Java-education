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
    private final String FILEPHRASE = "D:\\temp\\Chat.txt";
    private BufferedReader messageReader;
    private StringBuilder chatMessages;
    private String[] phraseArray;

    public ChatConsole(Reader in){
        this.messageReader = new BufferedReader(in);
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
            System.out.println(String.format("File %s not found or not exist",FILEPHRASE));
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

    private String getInput(){

        String recieveMessage = "Error reading";
        try{
            recieveMessage = messageReader.readLine();

        } catch (IOException e) {
            System.out.println("Error input reading");
            e.printStackTrace();
        }
        return  recieveMessage;
    }

    public void work(){
        String input,phrase;
        boolean getPrhase = true;
        System.out.println("Welcome to chat...");
        System.out.print("you :");
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
                System.out.println(String.format("answer: %s",phrase));
            }
            System.out.print("you :");
        }
        this.setString(input);

        LogWriter lgwr = new LogWriter();
        lgwr.init();
        lgwr.writeLog(chatMessages.toString());
    }

    public void setString(String msg){
        this.chatMessages.append(String.format("\n%s",msg));
    }

    public static void main(String[] args) {
        ChatConsole cht = new ChatConsole(new InputStreamReader(System.in));
        cht.init();
        cht.work();
    }

}
