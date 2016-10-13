package ru.szhernovoy.counter;

/**
 * Created by admin on 14.10.2016.
 */
public class Count implements Runnable{

    private int count = 0;

    /*public int incremant(int value){
            this.count += value;
            return this.count;
    }*/

    public int getCount() {
        return this.count;
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
        //synchronized (this) {
         //   this.incremant(1);
        //
        count = count + 1;
        //}
    }

    public static void main(String[] args) {
        Count tiny = new Count();
        Thread th1 = new Thread(tiny);
        //Thread th2 = new Thread(tiny);
        th1.start();
        //th2.start();

        System.out.println(tiny.getCount());
    }

}
