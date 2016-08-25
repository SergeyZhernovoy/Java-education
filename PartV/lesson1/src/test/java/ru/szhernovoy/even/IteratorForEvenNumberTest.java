package ru.szhernovoy.even;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 25.08.2016.
 */
public class IteratorForEvenNumberTest {
    @Test
    public void hasNext() throws Exception {

        IteratorForEvenNumber it = new IteratorForEvenNumber(new int[]{1,2,4,6,8,4,100,200});

        it.next();
        it.next();

        boolean result = it.hasNext();

        Assert.assertThat(result,is(true));


    }

    @Test
    public void next() throws Exception {

        IteratorForEvenNumber it = new IteratorForEvenNumber(new int[]{1,2,4,6,8,4,100,200});

        it.next();
        int result = (Integer) it.next();

        Assert.assertThat(result,is(4));

    }

}