package ru.szhernovoy.lock;

/**
 * Created by admin on 26.10.2016.
 */
public class Locker {

    private Object lock = new Object();
    private boolean flag = false;


    public void lockOject(){
        synchronized (this.lock){
            while(this.flag){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.flag = true;
        }
    }

    public void unlockObject(){
        synchronized (this.lock){
            flag = false;
            this.lock.notify();
        }
    }


}
