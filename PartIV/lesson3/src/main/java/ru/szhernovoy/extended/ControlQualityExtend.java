package ru.szhernovoy.extended;


/**
 * Created by admin on 09.08.2016.
 */
public class ControlQualityExtend{


    /**
     * sort product in storage place.
     * @param storages
     * @param foods
     */
    public void sortProduct(StorageExtended[] storages, FoodReproduct[] foods){
        for (FoodReproduct product: foods) {
            for (StorageExtended place: storages){
                if(place.matchRange(product)){
                    place.addFood(product);
                    break;
                }
            }
        }
    }


}
