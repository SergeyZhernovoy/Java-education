package ru.szhernovoy.jmm;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by szhernovoy on 11.10.2016.
 */
public class Problem implements Runnable {

    private int value;
    private boolean decision;

    public Problem(final int value, final boolean decision){
        this.value = value;
        this.decision = decision;
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

      while(!Thread.currentThread().isInterrupted() || this.value <= 500)
        if(this.decision){
            multiple();
        }
        else{
            setDecision(true);
        }

    }

    public void multiple(){
        this.value *= 2;
        this.decision = false;
        System.out.println(String.format("%s change value in %d",Thread.currentThread().getName(),this.value));
        Thread.currentThread().interrupt();
    }

    public void setDecision(boolean decision){
        this.decision = decision;
    }


    public static void main(String[] args) {
        Problem problem = new Problem(1,false);
        new Thread(problem).start();
        new Thread(problem).start();
    }

}
