package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;
import ru.szhernovoy.storage.Trash;

import java.util.GregorianCalendar;

/**
 * Created by admin on 10.08.2016.
 */
public class WarehouseCold extends StorageExtended {

    /**need for method matches */
     private Trash trash ;
     /**
     * Constructor.
     *
     * @param name
     * @param size
     * @param temperature
     */
    public WarehouseCold(String name, int size, int temperature, GregorianCalendar today) {
        super(name, size, temperature, today);
        this.trash = new Trash(name,size,today);
     }


    /**
     * method identify check range.
     * @param food
     * @return
     */

    @Override
    public boolean matchRange(FoodReproduct food) {
        boolean result = false;
        if(food.isCanReproduct() && this.trash.matchRange(food.getFood()) && this.temperature < 0){
            result = true;
            }

        return result;
    }

    /**
     * Abstract method identify check range
     *
     * @param food
     * @return
     */
    @Override
    public boolean matchRange(Food food) {
        return false;
    }
}
