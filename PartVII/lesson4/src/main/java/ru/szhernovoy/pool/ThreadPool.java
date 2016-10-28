package ru.szhernovoy.pool;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by szhernovoy on 26.10.2016.
 */
public class ThreadPool {

    private final int KERNEL = Runtime.getRuntime().availableProcessors();
    private final Deque<Runnable> pool = new ArrayDeque<>(this.KERNEL);

    public ThreadPool(){
        for (int index = 0; index < this.pool.size(); index++){
            this.pool.add(new Work());
        }
    }

    public void add(Work work){

        synchronized (this.pool){
            this.pool.add(work);
            this.pool.notifyAll();
            System.out.println(String.format("Work -%s is add",Thread.currentThread().getId()));
        }
    }

    public void execute(){

        synchronized (this.pool){
            while(this.pool.isEmpty()){
                try {
                    this.pool.wait();
                    System.out.println(String.format("wait - current thread %s",Thread.currentThread().getId()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Runnable work = null;
            while((work = this.pool.poll()) != null){
                 System.out.println(String.format("work  - current thread %s",Thread.currentThread().getId()));
                 new Thread(work).start();
            }
        }
    }

    public static void main(String[] args) {

        final ThreadPool threadPool = new ThreadPool();

        Thread poolAdd = new Thread(){
            @Override
            public void run() {
              threadPool.add(new Work());
                threadPool.add(new Work());
            }
        };
        Thread executorPool = new Thread(){
            @Override
            public void run() {
              threadPool.execute();
            }
        };

        poolAdd.start();
        executorPool.start();

    }

}
