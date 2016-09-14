package ru.szhernovoy.set;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 14.09.2016.
 */
public class LinkedSetTest {
    @Test
    public void whenAddValueInLinkedSetThatArrayHaveOnlyUniqueValue() throws Exception {

        LinkedSet<String> container = new LinkedSet<>();
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