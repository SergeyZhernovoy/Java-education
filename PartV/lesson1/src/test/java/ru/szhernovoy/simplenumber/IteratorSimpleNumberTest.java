package ru.szhernovoy.simplenumber;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 26.08.2016.
 */
public class IteratorSimpleNumberTest {
    @Test
    public void hasNext() throws Exception {

        IteratorSimpleNumber it = new IteratorSimpleNumber(new int[]{1,2,3,4,5,11,67});

        it.next();
        it.next();

        boolean result = it.hasNext();

        Assert.assertThat(result,is(true));

    }

    @Test
    public void next() throws Exception {

        IteratorSimpleNumber it = new IteratorSimpleNumber(new int[]{1,2,3,4,5,11,67});

        it.next();
        int result = (Integer) it.next();

        Assert.assertThat(result,is(2));

    }

}