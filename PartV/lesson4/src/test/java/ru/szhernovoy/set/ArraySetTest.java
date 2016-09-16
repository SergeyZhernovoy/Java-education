package ru.szhernovoy.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 14.09.2016.
 */
public class ArraySetTest {
    @Test(timeout = 1000000)
    public void whenAddValueInMassiveThatArrayHaveOnlyUniqueValue() throws Exception {

        ArraySet<Integer> container = new ArraySet<>(20);
        Random r = new Random();
        for(int index = 0 ; index < 200000 ; index ++ ){
            container.add(r.nextInt(index+1));
        }



        //int control = 0;
        while(container.hasNext()){
            //control = container.next();
            System.out.println(container.next());
        }
       // Assert.assertThat(control,is(5));

    }

}