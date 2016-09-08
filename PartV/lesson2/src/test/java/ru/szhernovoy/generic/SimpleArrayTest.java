package ru.szhernovoy.generic;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 07.09.2016.
 */
public class SimpleArrayTest {
    @Test
    public void whenAddValueShouldGetItFRomList() throws Exception {

        SimpleArray<Integer> simple = new SimpleArray<Integer>(3);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        int result = simple.get(1);
        Assert.assertThat(result, is(2));

    }

    @Test
    public void whenUpdateValueShouldUpdateIt() throws Exception {
        Integer[] myNum = new Integer[]{1,2,3,4,5};
        SimpleArray<Integer> simple = new SimpleArray<Integer>(myNum);
        simple.update(5,0);
        int result = simple.get(0);
        Assert.assertThat(result, is(5));
    }

    @Test
    public void delete() throws Exception {
        Integer[] myNum = new Integer[]{1,2,3,4,5};
        SimpleArray<Integer> simple = new SimpleArray<Integer>(myNum);
        simple.delete(0);
        Assert.assertThat(2, is(simple.get(0)));
    }

}