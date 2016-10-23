package ru.szhernovoy.findtext;

import java.io.File;
import java.util.*;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 15.10.2016.
 */
public class FindText {

    private AtomicBoolean success = new AtomicBoolean(false);
    private boolean continueSearch = true;
    private Set<File> listFiles ;
    private Set<SnifferName> threads = new ConcurrentSkipListSet<>();

    private final String REGEX;

    public  FindText(final boolean continueSearch,final String text, final Set<File> files){
        this.continueSearch = continueSearch;
        this.REGEX = text;
        this.listFiles = files;
    }

    public AtomicBoolean getSuccess(){
        return this.success;
    }

    public synchronized void setSuccess(boolean success){
        this.success.set(success);
    }

    public void startThread() throws InterruptedException {

       ListFiles searcher = new ListFiles(listFiles);
       searcher.startThread();
       Thread.sleep(1000);
       Iterator<File> iter = this.listFiles.iterator();

       int counter = 0;
       List<File> next = new LinkedList<>();
       while(iter.hasNext() ){
            if(this.success.get()){
                if(!this.continueSearch){
                    break;
                }
            }
            next.add(iter.next());
            if(counter == 2000){
                counter=0;
                SnifferName nextThread = new SnifferName(next,searcher);
                nextThread.start();
                this.threads.add(nextThread);
                next = new LinkedList<>();
            }
            else{
                counter++;
            }
       }
    }

    private class SnifferName extends Thread{

        private final List<File> chunk;
        private final ListFiles files;

        public boolean find(String name){
            Matcher m = Pattern.compile(REGEX).matcher(name);
            return m.find();
        }

        public void stopThread(){
            this.files.interruptAll();
            Iterator<SnifferName> iter = threads.iterator();
            while(iter.hasNext()){
                iter.next().interrupt();
            }
        }

        public SnifferName(final List<File> part, final ListFiles file){
            this.chunk = part;
            this.files = file;
        }

        @Override
        public void run() {
            Iterator<File> iter = this.chunk.iterator();
            while(!Thread.currentThread().isInterrupted() && iter.hasNext()){
                  if(!getSuccess().get()){
                      File next = iter.next();
                      if(this.find(next.getName())){
                          setSuccess(true);
                          if(!continueSearch){
                              this.stopThread();
                          }
                          System.out.println(String.format("Success in the search. File is  in %s",next.getAbsolutePath()));
                      }
                  }
            }
            threads.remove(Thread.currentThread());
        }
    }

}
