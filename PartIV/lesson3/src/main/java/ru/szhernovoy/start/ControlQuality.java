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
                    try{
                        place.addFood(product);
                        break;
                    }catch(ArrayIndexOutOfBoundsException aexc){
                        System.out.println("Place storage for product is very small");
                    }
                }
            }
        }
    }
}
