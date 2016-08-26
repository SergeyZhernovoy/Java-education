package ru.szhernovoy.convert;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 26.08.2016.
 */
public class IteratorSimpleTest {
    @Test
    public void convert() throws Exception {

    }

    @Test
    public void hasNext() throws Exception {
        IteratorConvert it = new IteratorSimple(new int[]{1,2,3});

        it.next();
        it.next();

        boolean control = it.hasNext();

        Assert.assertThat(control,is(true));

    }

    @Test
    public void next() throws Exception {
        IteratorConvert it = new IteratorSimple(new int[]{1,2,3});

        it.next();
        int control = it.next();



        Assert.assertThat(control,is(2));

    }

}