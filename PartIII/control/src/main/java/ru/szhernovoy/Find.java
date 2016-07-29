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
        this.keys = keys;
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
           System.out.println("It's find OK!!! Let's see log file");
        }
    }

    public StringBuilder getFileNames(String directory, FilenameFilter obj,StringBuilder builder){

           File file = new File(directory);
           if(file.canRead() && !file.isHidden()){
           for(File nameFile : file.listFiles(obj)){
               builder.append(String.format("\npath:%s\tname:%s",directory, nameFile.getName()));
           }

           for(File nameDirectory : file.listFiles()){
               //File itCatalog = new File(name);
               if(nameDirectory.exists() && nameDirectory.isDirectory() && nameDirectory.canRead()){
                   this.getFileNames(nameDirectory.getAbsolutePath(),obj,builder);
               }
              }
           }
           return  builder;
    }

    public static void main(String[] args) throws IOException {
        Find find = new Find(args);
        find.work();
    }

}
