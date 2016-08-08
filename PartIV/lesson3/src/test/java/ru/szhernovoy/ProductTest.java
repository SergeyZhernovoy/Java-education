package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.products.*;


import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;

/**
 * Created by Sergey on 08.08.2016.
 */
public class ProductTest {
    @Test
    public void CalculatePercentDateWhenExpireDateNotEnd(){
        Food food = new Bananas("Banana",new GregorianCalendar(2016, GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,9),45,5);
        boolean result = food.calculatePercent() < 99;
        boolean control = true;
        Assert.assertThat(result, is(control));
    }

}
