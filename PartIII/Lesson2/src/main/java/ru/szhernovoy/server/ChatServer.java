package ru.szhernovoy.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


/**
 * Created by admin on 22.07.2016.
 */
public class ChatServer {

    private final String STOP = "стоп";
    private final String CONTINUE = "продолжить";
    private final String EXIT = "закончить";
    private final String FILEPHRASE = String.format("%s%sChat.txt",System.getProperty("user.home"), File.separator);
    private String[] phraseArray;

    //server properties
    private ServerSocket serverSocket;
    private final int port = 5000;
    private BufferedReader  in;
    private PrintWriter out;

    public ChatServer() throws IOException {
    }

    public boolean init()  {
        //initialize answers server
        this.initializeAnswers();
        boolean success = true;
        //init socket
        try (ServerSocket serverSocket = this.serverSocket = new ServerSocket(port)) {
            System.out.println("Wait connect to server...");
            in = new BufferedReader( new InputStreamReader(serverSocket.accept().getInputStream()));
            out =  new PrintWriter (serverSocket.accept().getOutputStream(),true);

        }   catch (IOException exc){
            success = false;
            System.out.println("Error create socket");
        }
        return success;
    }

    private void initializeAnswers(){

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
        } catch (FileNotFoundException e) {
            System.out.println(String.format("File %s not found or not exist",FILEPHRASE));
        } catch (IOException e) {
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
         return phraseArray[new Random().nextInt(phraseArray.length)];
    }

    public void work(){

        String input,phrase;
        boolean getPrhase = true;
        try {
            while(!(input = this.in.readLine()).equalsIgnoreCase(EXIT)){
                System.out.println(String.format("We recieve message - %s",input));
                if(input.equalsIgnoreCase(STOP)){
                    getPrhase = false;
                }
                if(input.equalsIgnoreCase(CONTINUE)){
                    getPrhase = true;
                }
                if(getPrhase){
                    phrase =  this.getRandomLine();
                    out.println(phrase);
                }
          }
          out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ChatServer cht = new ChatServer();
        if(cht.init()){
           cht.work();
        }

    }
}
