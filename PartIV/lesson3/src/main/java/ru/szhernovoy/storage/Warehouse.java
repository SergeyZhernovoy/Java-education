package ru.szhernovoy.storage;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 * Created by admin on 08.08.2016.
 */
public class Warehouse extends Storage {

    public Warehouse(String name, int size, GregorianCalendar today) {
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
    if(food.calculatePercent(this.today) < 25 && !this.checkFullingStorage()){
        result = true;
    }
    return result;

    }
}
