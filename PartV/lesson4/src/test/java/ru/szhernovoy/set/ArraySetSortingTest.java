package ru.szhernovoy.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 16.09.2016.
 */
public class ArraySetSortingTest {
    @Test(timeout = 10000)
    public void whenAddThatDoQuickSortAndInsertOnlyUniqueValueInArray() throws Exception {
        ArraySetSorting<Integer> sortArray = new ArraySetSorting<>(20);

        Random r = new Random();
        for(int index = 0 ; index < 200000 ; index ++ ){
            sortArray.add(r.nextInt(index+1));
        }


        while(sortArray.hasNext()){
            System.out.println(sortArray.next());
        }

    }

}