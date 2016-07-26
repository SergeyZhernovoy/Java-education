package ru.szhernovoy;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by admin on 23.07.2016.
 */
public class Find {

    private LogWriter lgwr = new LogWriter();
    private String[] keys;
    private FilenameFilter filter;
    private ValidateKeys valid ;
    private String directory;

    public Find(String...keys) throws IOException {
        this.keys = new String[keys.length];
        int index = 0;
        for (String key: keys) {
            this.keys[index++] = key;
        }
        valid =new ValidateKeys(this.keys);
    }

    public  void work(){
        if(this.valid.validate()){
           this.filter = valid.getAction();
           this.directory = valid.getDirectory();
           StringBuilder builder = new StringBuilder();
           String result = getFileNames(this.directory,this.filter,builder).toString();
           lgwr.init();
           lgwr.writeLog(result);
           System.out.println("It's fine !!!");
        }
    }

    public StringBuilder getFileNames(String directory, FilenameFilter obj,StringBuilder builder){

           File file = new File(directory);
           for(File name : file.listFiles(obj)){
               //File itCatalog = new File(name);
               if(name.exists() && name.isDirectory()){
                   this.getFileNames(directory,obj,builder);
               }
               else{
                   builder.append(String.format("\n%s", name.getName()));
               }
           }
           return  builder;
    }

    public static void main(String[] args) throws IOException {
        Find find = new Find(args);
        find.work();
    }

}
