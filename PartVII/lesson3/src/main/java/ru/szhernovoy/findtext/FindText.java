package ru.szhernovoy.findtext;

import java.io.File;
import java.util.*;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 15.10.2016.
 */
public class FindText {

    /**flag success search */
    private AtomicBoolean success = new AtomicBoolean(false);
    /**flag contionue search after success */
    private boolean continueSearch = true;
    /**list current threads */
    private List<SnifferName> threads = new CopyOnWriteArrayList<>();
    /**list result search */
    private List<String> result = new CopyOnWriteArrayList<>();

    /**
     * Return result work searcher
     * @return
     */
    public List<String> getResult() {
        return this.result;
    }

    /**regulary sentence */
    private final String REGEX;

    public  FindText(final boolean continueSearch,final String text){
        this.continueSearch = continueSearch;
        this.REGEX = String.format("(?i)%s",text);
    }

    /**
     * Getter flag success
     * @return
     */
    public AtomicBoolean getSuccess(){
        return this.success;
    }

    /**
     * Setter flag success
     * @param success
     */
    public synchronized void setSuccess(boolean success){
        this.success.set(success);
    }

    /**
     * Main thread constructor
     * @throws InterruptedException
     */
    public void startThread() throws InterruptedException {

       ListFiles searcher = new ListFiles();
       searcher.startThread();

        Set<File>  listFiles = searcher.getListFiles();
       Iterator<File> iter = listFiles.iterator();

       int counter = 0;
       List<File> next = new LinkedList<>();
       while(iter.hasNext()){
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
                nextThread.join(200);

            }
            else{
                counter++;
            }
       }
    }

    /**
     * inner class
     */
    private class SnifferName extends Thread{

        private final List<File> chunk;
        private final ListFiles  files;

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
                          result.add(String.format("Success in the search. File is  in %s",next.getAbsolutePath()));
                      }
                  }
            }
            threads.remove(Thread.currentThread());
        }
    }


}
