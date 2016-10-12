package ru.szhernovoy.treads3;

import ru.szhernovoy.treads1.CounterValuesText;
import ru.szhernovoy.treads1.TokenCounter;
import ru.szhernovoy.treads2.CounterWithWait;

/**
 * Created by admin on 10.10.2016.
 */
public class CounterWithProgrammInterrupt {

    private final TokenCounter word;
    private final TokenCounter space;

    public CounterWithProgrammInterrupt(TokenCounter word, TokenCounter space) {

        this.word = word;
        this.space = space;
    }


    public boolean start() throws InterruptedException {

        Thread threadWord = new Thread(word.new TokenThread());
        threadWord.setName("Thread's word");
        Thread threadSpace = new Thread(space.new TokenThread());
        threadSpace.setName("Thread's space");
        threadSpace.start();
        threadSpace.join(20);
        //;
        threadWord.start();
        threadWord.join(20);
        interruptThread(threadSpace);
        interruptThread(threadWord);
        return true;
    }


    public void interruptThread(Thread thread){
        if(!thread.isInterrupted()){
            thread.interrupt();
            System.out.println(String.format("%s is interrupted",thread.getName()));
        }
    }


    public static void main(String[] args) throws InterruptedException {
        if(args.length > 0){
            CounterValuesText obj = new CounterValuesText(args[0]);
            String text = obj.readTxtFile(args[1]);
            CounterWithProgrammInterrupt counter = new CounterWithProgrammInterrupt(new TokenCounter(false,text),new TokenCounter(true,text));
            counter.start();
        }
    }

}
