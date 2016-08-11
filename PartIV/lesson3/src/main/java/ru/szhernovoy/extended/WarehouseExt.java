package ru.szhernovoy.extended;


import ru.szhernovoy.products.Food;
import ru.szhernovoy.storage.Warehouse;

import java.util.GregorianCalendar;

/**
 * Created by admin on 09.08.2016.
 */
public class WarehouseExt extends StorageExtended{

    private final Warehouse whs;
    /**
     * Constructor.
     *
     * @param name
     * @param size
     * @param temperature
     */
    public WarehouseExt(String name, int size, int temperature, GregorianCalendar today, final Warehouse whs ) {
        super(name, size, temperature, today);
        this.whs = whs;
    }

    /**
     * Abstract method identify check range
     *
     * @param food
     * @return
     */
    @Override
    public boolean matchRange(Food food) {
        boolean result = false;
        if(this.whs.matchRange(food)){
            if(this.whs.checkFullingStorage()){
                result = true;
            }
        }
        return result;
    }

    /**
     * method identify check range
     * @param food
     * @return
     */
    @Override
    public boolean matchRange(FoodReproduct food) {
        return this.matchRange(food.getFood());
    }

    /**
     * Add food in storage
     *
     * @param food
     */
    @Override
    public void addFood(Food food) {
        if(!this.whs.checkFullingStorage()){
            this.whs.addFood(food);
        }
        else{
            super.addFood(food);
        }
    }

}
