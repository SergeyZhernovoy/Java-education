package ru.szhernovoy.models;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 12.11.2016.
 */
public class TrackerTest {

    @Test
    public void whenAddItemInBDThatWeMayGetFrom() throws Exception {
        Tracker myTrack = new Tracker();
        myTrack.connect();
        Item item = new Item("first","opis",System.currentTimeMillis());
        String beforeId = item.getId();
        myTrack.addItem(item);

        String Resultid = item.getId();

        Assert.assertThat(Resultid,is("1"));
        if(!myTrack.close()){
            throw new UnknownError("connector in SQL base not close");
        }
    }


    @Test
    public void whenFilterItemInBDThatWeMayGetFrom() throws Exception {
        Tracker myTrack = new Tracker();
        myTrack.connect();
        Item item = myTrack.findByFilter("first").get(0);
        String Resultid = item.getId();
        Assert.assertThat(Resultid,is("1"));
        if(!myTrack.close()){
            throw new UnknownError("connector in SQL base not close");
        }
    }
}