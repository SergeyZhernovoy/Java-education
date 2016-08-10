package ru.szhernovoy.start;

import ru.szhernovoy.products.Food;
import ru.szhernovoy.storage.Storage;

/**
 * Class control quality food
 * Created by admin on 08.08.2016.
 */
public class ControlQuality {

    /**
     * Move product in storage if conditions coincide
     * @param storage
     * @param food
     */
    public void sortProduct(Storage[] storage, Food[] food) {
        for (Food product: food) {
            for (Storage place: storage){
                if(place.matchRange(product)){
                        place.addFood(product);
                        break;
                }
            }
        }
    }
}
