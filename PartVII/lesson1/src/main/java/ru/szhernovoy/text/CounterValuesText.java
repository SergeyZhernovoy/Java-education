package ru.szhernovoy.text;

/**
 * Created by szhernovoy on 08.10.2016.
 */
public class CounterValuesText {
    public static final class Calculator implements Runnable{
        public String name;

        public Calculator(String name) {
            this.name = name;
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
            System.out.println(this.name);
        }
    }

    public static void main(String[] args) {
        new Thread(new Calculator("Treads 1")).start();
        new Thread(new Calculator("Treads 2")).start();
        new Thread(new Calculator("Treads 3")).start();
        new Thread(new Calculator("Treads 4")).start();
    }
}
