package ru.szhernovoy.findtext;

import java.io.File;
import java.util.*;

/**
 * Created by admin on 19.10.2016.
 */
public class ListFiles {

    private final Set<File> listFiles ;
    List<ListFilesThread> threads;

    public ListFiles(final Set<File> myList){
        this.listFiles = myList;
    }

    public File[] getRoot(){
        return File.listRoots();
    }

    public void startThread() throws InterruptedException {

        this.threads = new LinkedList<>();
        for (File files : getRoot()){ //hard disks
            if(files.list() != null){
                    for(File next : files.listFiles()) { //content hard disks
                        ListFilesThread thread = new ListFilesThread(this.listFiles, next);
                        thread.start();
                        threads.add(thread);
                    }
            }
            else{
                this.listFiles.add(files);
            }
        }
    }

    public void interruptAll(){
        for(ListFilesThread thread : this.threads){
            thread.interrupt();
        }
    }

    private class ListFilesThread extends Thread{
        private final Set<File> listFiles;
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
            if(!isInterrupted()){
                getFiles(this.path);
            }

        }
    }
}
