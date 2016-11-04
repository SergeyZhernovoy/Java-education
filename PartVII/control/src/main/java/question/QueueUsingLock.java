package question;

import java.util.concurrent.locks.*;

/**
 * Created by admin on 05.11.2016.
 */
public class QueueUsingLock<T> {
    private volatile int size = 0;
    private final Object[] array;
    private final int maxSize;
    // [Tail (cyclic adds)->] [.] [.] [Head (cyclic adds)->]
    private int tail; // read from here (points to a filled element, if not null)
    private int head; // add nodes here (points to a filled element, if not null)
    private ReentrantLock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();

    public QueueUsingLock(int capacity) {
        try {
            lock.lock();
            this.maxSize = capacity;
            array = new Object[maxSize];
            tail = 0;
            head = 0;
        } finally {
            lock.unlock(); // publish
        }
    }

    final int cycleInc(int index) {
        return ++index == maxSize ? 0 : index;
    }

    public T get() throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (size == 0) {
                // get() sleeps until size becomes positive
                while (size < 1) {
                    isEmpty.await(); // release lock and sleep                 }             }             final Object value = array[tail];               array[tail] = null;             if (size > 1) {
                }
                    tail = cycleInc(tail);
                }
                size--;
                // now we have some place for adding new values (size decreased by 1), wake up put()
                isFull.signal();
                return (T) array[tail];
            } finally {
                lock.unlock();
            }
        }

    public void put(T value) throws InterruptedException {
        try {
            lock.lockInterruptibly();
            if (value == null) {
                throw new NullPointerException("Cannot add null value");
            }
            if (size == maxSize) {
                // put sleeps until size < maxSize
                while (size == maxSize) {
                    isFull.await(); // release lock and wait
                }
            }
            if (size == 0) {
                //head == tail == null element , assign new value to head element
                array[head] = value;
            } else {
                // increment then assign new value to head element
                head = cycleInc(head);
                array[head] = value;
            }
            size++;
            // now we have some objects which can be retrieved by get (size increased by 1), wake up get()
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
}
