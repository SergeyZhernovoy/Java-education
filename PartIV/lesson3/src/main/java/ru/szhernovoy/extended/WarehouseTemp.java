package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;
import ru.szhernovoy.storage.Storage;
import ru.szhernovoy.storage.Warehouse;

/**
 * Created by admin on 09.08.2016.
 */
public class WarehouseTemp extends Storage {

    private Warehouse tiny;
    private int temperature = 0;

    /**
     * Constructor.
     *
     * @param name
     * @param size
     */
    public WarehouseTemp(String name, int size, Warehouse tiny) {
        super(name, size);
        this.tiny = tiny;
    }

    /**
     * Abstract method identify check range
     *
     * @param food
     * @return
     */
    @Override
    public boolean matchRange(Food food) {
        boolean result = this.tiny.matchRange(food);
        return result;
    }

    public boolean matchRange(FoodReproduct food) {
       boolean result =false;
        if(food.isCanReproduct() && this.temperature < 0 ){
           result = matchRange(food.getFood());
       }
       return result;
    }

}
