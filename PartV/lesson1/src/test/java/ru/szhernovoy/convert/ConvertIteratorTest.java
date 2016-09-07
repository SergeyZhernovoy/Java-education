package ru.szhernovoy.convert;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;

/**
 * Created by Sergey on 07.09.2016.
 */
public class ConvertIteratorTest {
    @Test
    public void whenConvertDataFromIteratorIteratorovThatGetSimpleIterator(){

        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(4,2,0,4,6,4,9));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(0,9,8,7,5));
        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(1,3,5,6,7,0,9,8,4));
        ArrayList<Iterator<Integer>> bigBox = new ArrayList<>(Arrays.asList(one.iterator(),two.iterator(),three.iterator()));

        ConvertIterator converter = new ConvertIterator();
        Iterator<Integer> it = converter.convert(bigBox.iterator());

        int[] control = {4,2,0,4,6,4,9,0,9,8,7,5,1,3,5,6,7,0,9,8,4};
        int[] result = new int[21];

        int position = 0;
        while(it.hasNext()){
            result[position++] = it.next();
        }

        Assert.assertThat(result,is(control));

    }

}