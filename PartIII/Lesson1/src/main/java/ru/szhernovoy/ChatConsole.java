package ru.szhernovoy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.Reader;

/**
 * Created by admin on 19.07.2016.
 */
public class ChatConsole {
    private final String STOP = "стоп";
    private final String CONTINUE_CHAT = "продолжить";
    private final String EXIT = "закончить";
    private final String filename = "resources\\Chat.txt";
    private FileInputStream fs;

    public ChatConsole(){

    }

    public void init(Reader in){
        BufferedReader br = new BufferedReader(in);
        do{

        }
        while(true);
    }

    public void writeMessage(String message){

    }

    public static void main(String[] args) {
        ChatConsole cs = new ChatConsole();

    }

    try (BufferedReader br = new BufferedReader(new FileReader("C:\\testing.txt")))
    {

        String sCurrentLine;

        while ((sCurrentLine = br.readLine()) != null) {
            System.out.println(sCurrentLine);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    File file = new File("c:/newfile.txt");
    String content = "This is the text content";

		try (FileOutputStream fop = new FileOutputStream(file)) {

        // if file doesn't exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        // get the content in bytes
        byte[] contentInBytes = content.getBytes();

        fop.write(contentInBytes);
        fop.flush();
        fop.close();

        System.out.println("Done");

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
