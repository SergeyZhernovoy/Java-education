package ru.szhernovoy.findtext;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by admin on 15.10.2016.
 */
public class FindText {

    private AtomicBoolean success = new AtomicBoolean(false);
    private boolean continueSearch = true;
    private Set<File> listFiles = new ConcurrentSkipListSet<>();

    private final String REGEX;

    public  FindText(final boolean continueSearch,final String text){
        this.continueSearch = continueSearch;
        this.REGEX = text;
    }



    public void setParametrSearch(boolean continueSearch) {
        this.continueSearch = continueSearch;
    }

    public synchronized void setSuccess(boolean success) {
        this.success.set(success);
    }

    public AtomicBoolean getSuccess(){
        return this.success;
    }



    public void startThread(){
        this.threads = new Thread[50];
        int chunck = filesFromFileSystem.size()/50;
        for (int index = 0; index < 50; index++){
            ArrayList<String> tiny = new ArrayList<>();

            tiny.addAll(index + chunck,filesFromFileSystem);
            this.threads[index] = new Thread(new FindThread(tiny));
            this.threads[index].start();
        }
    }

    private class FindThread implements Runnable{

        private ArrayList<String> myFiles;

        public FindThread(final ArrayList<String> files){
            this.myFiles = files;
        }


        public void interruptAll(){
            for (Thread th: threads){
                th.interrupt();
            }
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

            while(!Thread.currentThread().isInterrupted()){
                if(nextIfSuccess && getSuccess().get()){

                }
                else{
                    break;
                }
            }

        }
    }


}
