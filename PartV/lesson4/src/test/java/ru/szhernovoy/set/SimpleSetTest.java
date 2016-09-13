package ru.szhernovoy.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 13.09.2016.
 */
public class SimpleSetTest {
    @Test
    public void whenAddDuplicateInSetThatOnlyUniqueValueSetCanHave() throws Exception {
        SimpleSet<String> container = new SimpleSet<>();
        container.add("first");
        container.add("second");
        container.add("first");
        Iterator<String> iter =  container.iterator();
        String control = "";
        while(iter.hasNext()){
            control = iter.next();
        }
        Assert.assertThat(control,is("second"));

    }


}