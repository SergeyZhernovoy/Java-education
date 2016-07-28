package ru.szhernovoy.client;

import ru.szhernovoy.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


/**
 * Created by admin on 22.07.2016.
 */
public class ChatClient {

    private final String STOP = "стоп";
    private final String CONTINUE = "продолжить";
    private final String EXIT = "закончить";
    private final IO io;
    private StringBuilder chatMessages;
    //properties server
    private final int port = 5000;
    private final String addressServer = "127.0.0.1";
    private PrintWriter  out;
    private BufferedReader  in;

    public ChatClient(final IO io){
        this.io = io;
        this.chatMessages = new StringBuilder();

    }

    public void init(){
        try {
            InetAddress inetAddres = InetAddress.getByName(addressServer);
            out = new PrintWriter (new Socket(inetAddres,port).getOutputStream(),true);
            in = new BufferedReader( new InputStreamReader(new Socket(inetAddres,port).getInputStream()));
            System.out.println("Connect to server succesfully...");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not connect to server...");
        }
    }

    private String getInput() {
        return  io.read();
    }

    public void work(){
        String input,phrase;
        boolean getPrhase = true;
        System.out.println("Welcome to chat...");
        System.out.print("you :");

        while(!(input = this.getInput()).equalsIgnoreCase(EXIT)){
            try {
                this.setString(input);
                out.println(input);

                if (input.equalsIgnoreCase(STOP)) {
                    getPrhase = false;
                }

                if (input.equalsIgnoreCase(CONTINUE)) {
                    getPrhase = true;
                }

                if (getPrhase) {

                    phrase = in.readLine();
                    this.setString(phrase);
                    this.io.println(String.format("answer: %s", phrase));
                }
                System.out.print("you :");
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        ChatClient cht = new ChatClient(new ConsoleIO(new BufferedReader(new InputStreamReader(System.in)),  System.out));
        cht.init();
        cht.work();
    }

}
