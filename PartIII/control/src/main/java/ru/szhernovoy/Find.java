package ru.szhernovoy;

/**
 * Created by admin on 23.07.2016.
 */
public class Find {
    //private LogWriter lgwr = new LogWriter();
    //private IO io;
    private String[] keys;

    //keys
    private final String DIR     = "-d";
    private final String NAME    = "-n";
    private final String MASK_M  = "-m";
    private final String MASK_F  = "-f";
    private final String MASK_R  = "-r";
    private final String LOG     = "-o";


    public Find(String...keys){
        this.keys = new String[keys.length];
        int index = 0;
        for (String key: keys) {
            this.keys[index++] = key;
        }
    }
}
