package ru.szhernovoy.findtext;

import java.io.File;
import java.util.*;

/**
 * Created by admin on 19.10.2016.
 */
public class ListFiles {

    Set<File> listFiles ;

    public ListFiles(final Set<File> myList){
        this.listFiles = myList;
    }

    public File[] getRoot(){
        return File.listRoots();
    }

    public void getFiles(File file){

        if(!file.canRead()){
            return;
        }

        if(file.isDirectory()) {
            for(File nextFiles : file.listFiles()) {
               getFiles(nextFiles);
            }
        }
        else {
            this.listFiles.add(file);
        }
    }

    public Set<File> getListFiles(){
        for (File files : getRoot()){
            getFiles(files);
        }
        return this.listFiles;
    }


    public static void main(String[] args) {

        HashSet<File> listy = new HashSet<File>();
        new ListFiles(listy).getListFiles();
        Iterator<File> iter = listy.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().getAbsolutePath());
        }

    }

}
