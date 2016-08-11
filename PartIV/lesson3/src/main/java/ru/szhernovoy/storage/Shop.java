package ru.szhernovoy.storage;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 * Created by admin on 08.08.2016.
 */
public class Shop extends Storage {

    public Shop(String name, int size, GregorianCalendar today) {
        super(name,size, today);
    }

    /**
     * check food on range
     * @param food
     * @return
     */
    @Override
    public boolean matchRange(Food food) {
        boolean result = false;
        int percent = food.calculatePercent(today);
        if(percent >= 25 && percent <= 75){
            result = true;
        }
        else {
            if(percent > 75 && percent <= 100){
                food.changePrice();
                result = true;
            }
        }
        return result;
    }
}
