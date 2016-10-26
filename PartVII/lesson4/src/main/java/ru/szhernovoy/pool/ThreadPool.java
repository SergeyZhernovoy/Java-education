package ru.szhernovoy.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by szhernovoy on 26.10.2016.
 */
public class ThreadPool {

    private BlockingQueue<Object> pool = new ArrayBlockingQueue<>(10);

}
