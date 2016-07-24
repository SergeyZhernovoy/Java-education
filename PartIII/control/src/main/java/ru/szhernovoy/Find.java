package ru.szhernovoy;

import java.io.IOException;

/**
 * Created by admin on 23.07.2016.
 */
public class Find {

    //private LogWriter lgwr = new LogWriter();
    //private IO io;
    private String[] keys;

    private ValidateKeys valid = new ValidateKeys(keys);


    public Find(String...keys) throws IOException {
        this.keys = new String[keys.length];
        int index = 0;
        for (String key: keys) {
            this.keys[index++] = key;
        }
    }

    public static void main(String[] args) throws IOException {
        Find find = new Find(args);
    }

}
