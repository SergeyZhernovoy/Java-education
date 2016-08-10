package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;
import ru.szhernovoy.storage.Trash;

/**
 * Created by admin on 10.08.2016.
 */
public class WarehouseCold extends StorageExtended {

    private Trash trash;

    /**
     * Constructor.
     *
     * @param name
     * @param size
     * @param temperature
     */
    public WarehouseCold(String name, int size, int temperature, Trash trash) {
        super(name, size, temperature);
        this.trash = trash;
    }

    @Override
    public boolean matchRange(FoodReproduct food) {
        boolean result = false;
        if(food.isCanReproduct() && this.trash.matchRange(food.getFood())&& this.temperature < 0){
            result = true;
        }
        else{
            this.addFood(food.getFood());
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
        return this.trash.matchRange(food);
    }

    /**
     * Add food in storage
     *
     * @param food

     */
    @Override
    public void addFood(Food food) {
           this.trash.addFood(food);
     }

}
