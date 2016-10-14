package ru.szhernovoy.counter;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 14.10.2016.
 */
public class UseCounterTest {
    @Test
    public void whenWeRunThreeThreadsWeShouldBeGetCounterRight() throws Exception {

            UseCounter useCounter = new UseCounter();
            Thread th1 = new Thread(new UseCounter.Count(useCounter));
            Thread th2 = new Thread(new UseCounter.Count(useCounter));
            Thread th3 = new Thread(new UseCounter.Count(useCounter));

            th1.start();
            th2.start();
            th3.start();

            th1.join();
            th2.join();
            th3.join();

           Assert.assertThat(useCounter.getCount(),is(3));

    }

}