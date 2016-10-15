package ru.szhernovoy.counter;

/**
 * Created by admin on 14.10.2016.
 */
public class UseCounter{

    private int count = 0;


    public  int getCount() {
        return this.count;
    }

    public synchronized int  incremant(int value){
        this.count += value;
        return this.count;

    }


    public  static class Count implements Runnable{

        UseCounter storage;

        public Count(UseCounter storage){
            this.storage = storage;
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
            this.storage.incremant(1);
        }
    }

}
