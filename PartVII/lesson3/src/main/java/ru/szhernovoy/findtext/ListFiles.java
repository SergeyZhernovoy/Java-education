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

    public void startThread() throws InterruptedException {

        File[] root = getRoot();
        ListFilesThread[] threads = new ListFilesThread[root.length];
        int position = 0;
        for (File files : getRoot()){ //hard disks
            for(File next : files.listFiles()) { //content hard disks
                threads[position] = new ListFilesThread(this.listFiles, files);
                threads[position++].start();
            }
        }
    }

    public Set<File> getListFiles() {
        return listFiles;
    }

    private class ListFilesThread extends Thread{
        private Set<File> listFiles;
        private final File path;
        public ListFilesThread(final Set<File> externalSet,final File path){
            this.listFiles = externalSet;
            this.path = path;
        }

        public void getFiles(File file){

            if(!file.canRead()){
                return;
            }

            if(file.isDirectory()) {
                if(file.list() != null) {
                    for (File nextFiles : file.listFiles()) {
                        getFiles(nextFiles);
                    }
                }
            }
            else {
                this.listFiles.add(file);
            }
        }

        @Override
        public void run() {
            getFiles(this.path);
        }
    }
}
