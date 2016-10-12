package ru.szhernovoy.treads2;

import ru.szhernovoy.treads1.CounterValuesText;
import ru.szhernovoy.treads1.TokenCounter;

/**
 * Created by admin on 09.10.2016.
 */
public class CounterWithWait {
    private final long startTime;
    private final TokenCounter word;
    private final TokenCounter space;

    public CounterWithWait(long startTime, TokenCounter word, TokenCounter space) {
        this.startTime = startTime;
        this.word = word;
        this.space = space;
    }

    public String info(String info,final long currentTime){
        System.out.println(String.format("thread %s : time milisecond %d",info,currentTime - this.startTime));
        return info;
    }

    public boolean start() throws InterruptedException {

        Thread threadWord = new Thread(word.new TokenThread());
        Thread threadSpace = new Thread(space.new TokenThread());

        this.info(String.format("%s %s",Thread.currentThread().getName()," start"),System.currentTimeMillis());

        threadSpace.start();
        threadSpace.join();
        threadWord.start();
        threadWord.join();

        while(threadSpace.isAlive() || threadWord.isAlive()){
             if(((System.currentTimeMillis() - this.startTime) > 1000) && (threadSpace.isAlive() || threadWord.isAlive())){
                 this.info(String.format("",Thread.currentThread().getName()," tired of waiting"),System.currentTimeMillis());
                 if(threadSpace.isAlive()){
                     threadSpace.interrupt();
                     if(threadSpace.isInterrupted()){
                         throw new InterruptedException();
                     }
                 }
                 if(threadWord.isAlive()){
                     threadWord.interrupt();
                     if(threadWord.isInterrupted()){
                         throw new InterruptedException();
                     }
                 }
             }
        }
        this.info(String.format("%s %s ",Thread.currentThread().getName()," finally job"),System.currentTimeMillis());
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        if(args.length > 0){
            CounterValuesText obj = new CounterValuesText(args[0]);
            String text = obj.readTxtFile(args[1]);
            CounterWithWait counter = new CounterWithWait(System.currentTimeMillis(),new TokenCounter(false,text),new TokenCounter(true,text));
            counter.start();
        }
    }

}
