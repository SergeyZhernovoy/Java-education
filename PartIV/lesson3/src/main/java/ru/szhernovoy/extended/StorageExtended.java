package ru.szhernovoy.extended;

import ru.szhernovoy.storage.Storage;

import java.util.Arrays;

/**
 * Created by admin on 10.08.2016.
 */
public abstract class StorageExtended extends Storage {

    protected FoodReproduct[] foodReproducts;
    protected int temperature = 0;
    protected int positionReproduct =0;

     /**
     * Constructor.
     *
     * @param name
     * @param size
     */
    public StorageExtended(String name, int size, int temperature) {
        super(name, size);
        this.foodReproducts = new FoodReproduct[size];
        this.temperature = temperature;
    }



    public void addFood(FoodReproduct foodReproduct){
        this.foodReproducts[positionReproduct++] = foodReproduct;
    }

    public abstract boolean matchRange(FoodReproduct food);

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("In %s \'%s\' have next products:\n",this.getClass().getCanonicalName(),this.name));
        for (int index = 0 ; index < food.length; index++){
            if(food[index]!=null){
                info.append(String.format("\n -- %s - %s",food[index].getClass(),food[index].getName()));
            }
        }

        for (int index = 0 ; index < foodReproducts.length; index++){
            if(foodReproducts[index]!=null){
                info.append(String.format("\n -- %s - %s",foodReproducts[index].getClass(),foodReproducts[index].getName()));
            }
        }

        return info.toString();
    }
}
