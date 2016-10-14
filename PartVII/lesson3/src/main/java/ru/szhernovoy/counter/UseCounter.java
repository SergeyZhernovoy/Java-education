package ru.szhernovoy.counter;

/**
 * Created by admin on 14.10.2016.
 */
public class UseCounter{

    private int count = 0;


    public  int getCount() {
        return this.count;
    }

    public void  add(int value){
        count += value;
    }


    public  static class Count implements Runnable{

        UseCounter storage;

        public Count(UseCounter storage){
            this.storage = storage;
        }

        public int incremant(int value){
            synchronized (this.storage) {
                this.storage.add(1);
            }
            return this.storage.getCount();
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
            this.incremant(1);
        }
    }

}
