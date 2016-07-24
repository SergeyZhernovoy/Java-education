package ru.szhernovoy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by admin on 21.07.2016.
 */
public class LogWriter {
    private final String FILENAME = String.format("%s%slog.txt",System.getProperty("user.home"), File.separator);
    private BufferedWriter bw;

    public LogWriter() throws IOException {
    }

    public void init(){

        File file = new File(FILENAME);
        try {
            if (!file.exists()) {

                file.createNewFile();
            }
            this.bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        } catch (IOException e) {
               System.out.println("Error crate log.txt ");
               e.printStackTrace();
        }
    }

    public void writeLog(String message){

        try {
            bw.write(message);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


