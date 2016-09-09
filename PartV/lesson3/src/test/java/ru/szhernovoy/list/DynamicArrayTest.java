package ru.szhernovoy.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sergey on 09.09.2016.
 */
public class DynamicArrayTest {
    @Test
    public void whenAddInConatainerThenAddInArray() throws Exception {
        DynamicArray<String> container = new DynamicArray<>();
        container.add("First message");
        Assert.assertThat("First message",is(container.get(0)));
    }


    @Test
    public void whenNeedLoopByListItDoIterator() throws Exception {
        DynamicArray<String> container = new DynamicArray<>();
        container.add("First message");
        container.add("Second message");
        container.add("Third message");
        Iterator<String> iter = container.iterator();
        int index = 0;
        String message = "";
        while(iter.hasNext() && index < 2 ){
            message =  iter.next();
            index++;
        }
        Assert.assertThat("Second message",is(message));
    }

}