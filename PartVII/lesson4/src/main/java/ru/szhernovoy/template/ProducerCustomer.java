package ru.szhernovoy.template;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by szhernovoy on 26.10.2016.
 */
public class ProducerCustomer {


    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
    private AtomicInteger num = new AtomicInteger(1);


    public void add(){
        synchronized (this.queue){
            System.out.println(String.format("work Producer %s - add num %d",Thread.currentThread().getId(),this.num.get()));
            try {
                this.queue.put(this.num.get());
                this.num.getAndIncrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.queue.notify();
        }

    }

    public void getData()  {
         synchronized (this.queue){
            while(this.queue.isEmpty()){
                try {
                    System.out.println(String.format("wait Customer %s",Thread.currentThread().getId()));
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

             try {
                 System.out.println(String.format("wait Customer %s - get num %d",Thread.currentThread().getId(),this.queue.take()));
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         }

    }

    public static void main(String[] args) {

        final ProducerCustomer info = new ProducerCustomer();
        Thread producer = new Thread(){
            /**
             * If this thread was constructed using a separate
             * <code>Runnable</code> run object, then that
             * <code>Runnable</code> object's <code>run</code> method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of <code>Thread</code> should override this method.
             *
             * @see #start()
             * @see #stop()
             * @see #(ThreadGroup, Runnable, String)
             */
            @Override
            public void run() {
                info.add();
            }
        };

        Thread customer = new Thread(){
            /**
             * If this thread was constructed using a separate
             * <code>Runnable</code> run object, then that
             * <code>Runnable</code> object's <code>run</code> method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of <code>Thread</code> should override this method.
             *
             * @see #start()
             * @see #stop()
             * @see #(ThreadGroup, Runnable, String)
             */
            @Override
            public void run() {
                info.getData();
            }
        };
        customer.start();
        producer.start();


    }
}
