package question;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by admin on 05.11.2016.
 */
public class Stack<T> {

    private final AtomicReference<Element> headRef = new AtomicReference<Element>(null);

    public void push(T value) {
        Element newHead = new Element();
        newHead.value = value;
        Element oldHead;
        do {
            oldHead = headRef.get();
            newHead.next = oldHead;
        } while (!headRef.compareAndSet(oldHead, newHead));
    }

    public T pop() {
        Element oldHead = null;
        Element newHead = null;
        do {
            oldHead = headRef.get();
            if (oldHead == null) {
                return null;
            }
            newHead = oldHead.next;
        } while (!headRef.compareAndSet(oldHead, newHead));
        return (T)oldHead.value;
    }

    public static class Element<T> {
        private T value;
        private Element next;
    }
}
