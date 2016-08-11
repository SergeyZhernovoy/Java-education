package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.products.*;
import ru.szhernovoy.storage.*;


import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;

/**
 * Created by Sergey on 08.08.2016.
 */
public class StorageTest {
    @Test
    public void checkRangeForAddOrNotAddInStorageInShop(){
        Food food = new Bananas("Banana",new GregorianCalendar(2016, GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,14),45,5);
        GregorianCalendar today = new GregorianCalendar(2016, GregorianCalendar.AUGUST,10);
        Shop shop = new Shop("METRO",10, today);

        boolean result = shop.matchRange(food);
        boolean control = true;

        Assert.assertThat(control, is(result));



     }

  @Test
    public void checkRangeForAddOrNotAddInStorageInWH(){
        Food food = new Bananas("Banana",new GregorianCalendar(2016, GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,10),45,5);
        GregorianCalendar today = new GregorianCalendar(2016, GregorianCalendar.AUGUST,8);
        Warehouse whs = new Warehouse("1st",10,today);

        boolean result = whs.matchRange(food);
        boolean control = false;

        Assert.assertThat(control, is(result));

    }

    @Test
    public void checkRangeForAddOrNotAddInStorageInTrash(){
        Food food = new Bananas("Banana",new GregorianCalendar(2016, GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,9),45,5);
        GregorianCalendar today = new GregorianCalendar(2016, GregorianCalendar.AUGUST,8);
        Trash trssh = new Trash("Empty",50,today);

        boolean result = trssh.matchRange(food);
        boolean control = false;

        Assert.assertThat(control, is(result));

    }


}
