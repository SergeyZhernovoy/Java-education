package ru.szhernovoy.storage;

import ru.szhernovoy.products.Food;

/**
 * Created by admin on 08.08.2016.
 */
public class Shop extends Storage {

    public Shop(String name, int size) {
        super(name,size);
    }

    @Override
    public boolean matchRange(Food food) {
        boolean result = false;
        int percent = food.calculatePercent();
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
