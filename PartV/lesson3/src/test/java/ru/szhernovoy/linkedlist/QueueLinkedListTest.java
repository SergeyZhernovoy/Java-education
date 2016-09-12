package ru.szhernovoy.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 12.09.2016.
 */
public class QueueLinkedListTest {
    @Test
    public void whenAddQueueThatWeCanGetItbyIndex() throws Exception {
        QueueLinkedList<Integer> dlink = new QueueLinkedList<>();
        dlink.push(4);
        dlink.push(12);
        dlink.push(-7);
        int control = dlink.get(2);
        Assert.assertThat(control,is(-7));
    }

    @Test
    public void whenPopValueWeGetItAndRemoveValueFromList() throws Exception {
        QueueLinkedList<Integer> dlink = new QueueLinkedList<>();
        dlink.push(4);
        dlink.push(12);
        dlink.push(-7);
        System.out.println(dlink.getCapacility());
        int control = dlink.pop();
        System.out.println(dlink.getCapacility());
        Assert.assertThat(control,is(-7));
    }

}