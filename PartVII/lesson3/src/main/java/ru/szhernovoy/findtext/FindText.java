package ru.szhernovoy.findtext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by admin on 15.10.2016.
 */
public class FindText {

    private AtomicBoolean success = new AtomicBoolean(false);
    private boolean nextIfSuccess = true;
    private List<String> filesIncludeText = new ArrayList<>();
    private List<String> filesFromFileSystem = new ArrayList<>(10000);
    private final String TEXT;
    private Thread[] threads;
    private final String MASK = ".txt";


    public  FindText(final boolean nextIfSuccess,final String text){
        this.nextIfSuccess = nextIfSuccess;
        this.TEXT = text;
    }

    private synchronized void addFiles(String files){
        this.filesIncludeText.add(files);
    }


    public void setNextIfSuccess(boolean nextIfSucces) {
        this.nextIfSuccess = nextIfSucces;
    }

    public synchronized void setSuccess(boolean success) {
        this.success.set(success);
    }

    public AtomicBoolean getSuccess(){
        return this.success;
    }

    public void printTextFiles(){
        Iterator<String> iter = filesIncludeText.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
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
