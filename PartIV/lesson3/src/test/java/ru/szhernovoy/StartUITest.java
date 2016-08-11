package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.products.*;
import ru.szhernovoy.start.*;
import ru.szhernovoy.storage.*;

import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;

/**
 * Created by Sergey on 08.08.2016.
 */
public class StartUITest {
    @Test
    public void whenAddFoodInStorageCountFoodInStorageUp(){
        ControlQuality control = new ControlQuality();
        Food[] food = new Food[1];
        GregorianCalendar today = new GregorianCalendar(2016, GregorianCalendar.AUGUST,8);
        food[0] = new Bananas("Banana",new GregorianCalendar(2016, GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,15),45,5);

        Storage[] storage = new Storage[1];
        storage[0] = new Shop("METRO",10,today);


        StartUI start = new StartUI(control,storage,food);
        start.work();
        String getResult = storage[0].toString();
        boolean  contain = getResult.contains("Banana") ;
        boolean  check = true;
        Assert.assertThat(check, is(contain));
    }
}
