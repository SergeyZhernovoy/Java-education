package ru.szhernovoy.findtext;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 15.10.2016.
 */
public class FindText {

    private AtomicBoolean success = new AtomicBoolean(false);

    private boolean continueSearch = true;
    private Set<File> listFiles;
    private Set<Thread> listThreads;

    private final String REGEX;

    public  FindText(final boolean continueSearch,final String text){
        this.continueSearch = continueSearch;
        this.REGEX = text;
        this.listThreads = new ConcurrentSkipListSet<>();
    }



    public AtomicBoolean getSuccess(){

        return this.success;
    }


    public synchronized void setSuccess(boolean success){
        this.success.set(success);
    }

    public void startThread() throws InterruptedException {




       // while()
        Thread.sleep(10000);
    }

    private class SnifferName extends Thread{

        private final List<File> chunk;

        public boolean find(String name){
            Matcher m = Pattern.compile(REGEX).matcher(name);
            return m.find();
        }

        public void stopThread(){
            Iterator<Thread> iter = listThreads.iterator();
            while(iter.hasNext()){
                iter.next().interrupt();
            }
        }


        public SnifferName(final List<File> part){
            this.chunk = part;
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
                          System.out.println(String.format("Success the search. File is  in %s",next.getAbsolutePath()));
                      }
                  }


            }
            listThreads.remove(Thread.currentThread());
        }
    }


}
