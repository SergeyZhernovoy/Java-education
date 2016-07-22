package ru.szhernovoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by szhernovoy on 22.07.2016.
 */
public class ConsoleIO implements IO {
    private PrintStream out;
    BufferedReader messageReader;

    public ConsoleIO(final BufferedReader reader, final PrintStream out){
           this.messageReader = reader;
           this.out = out;
    }

    @Override
    public String read()  {
        String result = "";
        try {
            result =  this.messageReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void print(Object value) {
        this.out.print(value);
    }

    @Override
    public void println(Object value) {
        this.out.println(value);
    }
}
