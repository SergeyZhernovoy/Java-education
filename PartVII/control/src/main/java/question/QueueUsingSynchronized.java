package question;

/**
 * Created by admin on 05.11.2016.
 */
public class QueueUsingSynchronized<T> {
    private final Object[] array;
    private final int maxSize;
    // [Tail (cyclic adds)->] [.] [.] [Head (cyclic adds)->]
    private int tail; // read from here (points to a filled element, if not null)
    private int head; // add nodes here (points to a filled element, if not null)
    private volatile int size = 0;
    private Object isEmpty = new Object();
    private Object isFull = new Object();

    public QueueUsingSynchronized(int capacity) {
        this.maxSize = capacity;
        array = new Object[maxSize];
        tail = 0;
        head = 0;
        size = 0; // publish
    }

    final int cycleInc(int index) {
        return ++index == maxSize ? 0 : index;
    }

    public T get() throws InterruptedException {
        if (size == 0) {
            // get() sleeps until size becomes positive
            synchronized (isEmpty) {
                while (size < 1) {                     isEmpty.wait();                 }             }         }         try {             synchronized (this) {                 final Object value = array[tail];                   array[tail] = null;                 if (size > 1) {
            tail = cycleInc(tail);
        }
            size--;
            return (T) value;
        }
        } finally {
            // now we have some place for adding new values (size decreased by 1), wake up put()
            synchronized (isFull) {
                isFull.notify();
            }
        }

    }

    public void put(T value) throws InterruptedException {
        if (value == null) {
            throw new NullPointerException("Cannot add null value");
        }
        if (size == maxSize) {
            // put sleeps until size < maxSize
            synchronized (isFull) {
                while (size == maxSize) {
                    isFull.wait();
                }
            }
        }
        synchronized (this) {
            if (size == 0) {
                //head == tail == null element , assign new value to head element
                array[head] = value;
            } else {
                // increment then assign new value to head element
                head = cycleInc(head);
                array[head] = value;
            }
            size++;
        }
        // now we have some objects which can be retrieved by get (size increased by 1), wake up get()
        synchronized (isEmpty) {
            isEmpty.notify();
        }
    }
}
