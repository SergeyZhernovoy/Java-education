package ru.szhernovoy.extended;


import ru.szhernovoy.products.Beard;
import ru.szhernovoy.products.Food;
import ru.szhernovoy.start.ControlQuality;
import ru.szhernovoy.storage.Storage;
import ru.szhernovoy.storage.Trash;
import ru.szhernovoy.storage.Warehouse;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by admin on 09.08.2016.
 */
public class ControlQualityExtend extends ControlQuality{

    private ArrayList<StorageExtended> storages = new ArrayList<StorageExtended>();
    private ArrayList <FoodReproduct> foods = new ArrayList<FoodReproduct>();
    /**
     * Move product in storage if conditions coincide
     */
    public void sortProduct() {
        for (FoodReproduct product: this.foods) {
            for (StorageExtended place: this.storages){
                if(place.matchRange(product)){
                    place.addFood(product);
                    break;
                }
            }
        }
    }

    /**
     * Add food in array list
     * @param food
     */
    public void addFood(FoodReproduct food){
        this.foods.add(food);
    }

    /**
     * Add storage in array list
     * @param storage
     */
    public void addStorages(StorageExtended storage){
        this.storages.add(storage);
    }

    /**
     * print products in storage
     */
    public void printInfo(){
        for (Storage place :this.storages) {
            System.out.println(place);
        }
    }

    public static void main(String[] args) {
        ControlQualityExtend control = new ControlQualityExtend();
        FoodReproduct[] food = new FoodReproduct[2];
        GregorianCalendar today = new GregorianCalendar(2016, GregorianCalendar.AUGUST,8);
        Food beard =   new Beard("Darnickiy",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,3),25,7);
        Food bulka = new Beard("Bulka",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,28),22,8);
        food[0] = new WhiteBeard(true,beard,today);
        food[1] = new DarkBeard(true,bulka,today);

        Warehouse whs = new Warehouse("1st",10, today);
        Trash trash = new Trash("Empty",50, today);

        StorageExtended[] storage = new StorageExtended[2];
        storage[0] = new WarehouseExt("new Warehouse",20,-10,today,whs);
        storage[1] = new WarehouseCold("new WarehouseCold",20,-10,today,trash);

        for (int index = 0; index < food.length;index++){
            control.addFood(food[index]);
        }

        for (int index = 0; index < storage.length;index++){
            control.addStorages(storage[index]);
        }
        control.sortProduct();
        control.printInfo();
    }

}
