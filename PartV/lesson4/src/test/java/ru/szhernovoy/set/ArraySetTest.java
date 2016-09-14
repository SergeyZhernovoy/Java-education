package ru.szhernovoy.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 14.09.2016.
 */
public class ArraySetTest {
    @Test
    public void whenAddValueInMassiveThatArrayHaveOnlyUniqueValue() throws Exception {

        ArraySet<String> container = new ArraySet<>(10);
        container.add("first");
        container.add("second");
        container.add("first");
        String control = "";
        while(container.hasNext()){
            control = container.next();
        }
        Assert.assertThat(control,is("second"));

    }

}