package ru.szhernovoy.findtext;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by admin on 19.10.2016.
 */
public class ListFiles {

    Map<String,Object> listFiles = new Bloc;


    public void getRoot(){

        File[] rootIO = File.listRoots();
        Path[] rootNio = new Path[rootIO.length];

        for (int index = 0; index < rootIO.length; index++){
            rootNio[index] = rootIO[index].toPath();
        }
    }

    public static void main(String[] args) {
        new ListFiles().getRoot();

    }

}
