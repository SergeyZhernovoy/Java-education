package ru.szhernovoy.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.list.DynamicArray;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 11.09.2016.
 */
public class DynamicLinkedListTest {
    @Test
    public void whenAddLinkedListThatWeCanGetItbyIndex() throws Exception {
        DynamicLinkedList<Integer> dlink = new DynamicLinkedList<>();
        dlink.add(4);
        dlink.add(12);
        dlink.add(-7);
        int control = dlink.get(2);
        Assert.assertThat(control,is(-7));
    }

    @Test
    public void whenLinkedListHaveAnyMoreValueWeGetAllAcrossIterator() throws Exception {
        DynamicLinkedList<String> container = new DynamicLinkedList<>();
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