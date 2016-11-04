package question;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by admin on 05.11.2016.
 */
public class Counter {
    private AtomicReference refCounter = new AtomicReference(null);

    public BigInteger next() {
        BigInteger oldValue;
        BigInteger newValue;
        do {
            oldValue = (BigInteger) refCounter.get();
            newValue = oldValue==null ? BigInteger.valueOf(1) : oldValue.shiftLeft(1);
        } while(!refCounter.compareAndSet(oldValue, newValue));
        return newValue;
    }
}
