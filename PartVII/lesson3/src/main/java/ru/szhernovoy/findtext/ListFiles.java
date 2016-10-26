package ru.szhernovoy.findtext;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by admin on 19.10.2016.
 */
public class ListFiles {

    /**set all files in system    */
    private final Set<File> listFiles  = new ConcurrentSkipListSet<>();

    public Set<File> getListFiles() {
        return listFiles;
    }

    /**list all threads for search files */
    List<ListFilesThread> threads;

    /**
     * return list root disk
     * @return
     */
    public File[] getRoot(){
        return File.listRoots();
    }

    /**
     * Main function search files across threads
     * @throws InterruptedException
     */
    public void startThread() throws InterruptedException {

        this.threads = new LinkedList<>();
        for (File files : getRoot()){ //hard disks
            if(files.list() != null){
                    for(File next : files.listFiles()) { //content hard disks
                        ListFilesThread thread = new ListFilesThread(next);
                        thread.start();
                        threads.add(thread);
                        thread.join(50);
                    }
            }
            else{
                this.listFiles.add(files);
            }
        }
    }

    /**
     * This method to end all threads
     */
    public void interruptAll(){
        for(ListFilesThread thread : this.threads){
            thread.interrupt();
        }
    }

    /**
     * inner class for multi threading
     */
    private class ListFilesThread extends Thread{

        /**part files from filesystems */
        private final File path;
        public ListFilesThread(final File path){
           this.path = path;
        }

        /**
         * Reccurce finder files
         * @param file
         */
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
                listFiles.add(file);
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
