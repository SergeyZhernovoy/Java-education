package ru.szhernovoy.storage;

import ru.szhernovoy.products.Food;

/**
 * Created by admin on 08.08.2016.
 */
public class Trash extends Storage {

    public Trash(String name, int size) {
        super(name,size);
    }

    /**
     * check food on range
     * @param food
     * @return
     */
    @Override
    public boolean matchRange(Food food) {
        boolean result = false;
        if(food.calculatePercent() > 100){
            result = true;
        }
        return result;

    }

}
