package ru.szhernovoy.extended;

import ru.szhernovoy.products.Bananas;
import ru.szhernovoy.products.Beard;
import ru.szhernovoy.products.Food;
import ru.szhernovoy.storage.Shop;
import ru.szhernovoy.storage.Storage;
import ru.szhernovoy.storage.Trash;
import ru.szhernovoy.storage.Warehouse;

import java.util.GregorianCalendar;

/**
 * Created by admin on 09.08.2016.
 */
public class StartUINext {
    /**value save object control quality */
    private final ControlQualityExtend control;
    /**array storage  */
    private final StorageExtended[] storage;
    /**array products */
    private final FoodReproduct[] food;

    /**
     * Constructor.
     * @param control
     * @param storage
     * @param food
     */
    public StartUINext(final ControlQualityExtend control, final StorageExtended[] storage, final FoodReproduct[] food){
        this.control = control;
        this.storage = storage;
        this.food = food;
    }

    /**
     * Main method , which do sorting food
     */
    public void work() {
        control.sortProduct(storage,food);
    }

    /**
     * print products in storage
     */
    public void printInfo(){
        for (Storage place :storage) {
            System.out.println(place);
        }
    }

    public static void main(String[] args) {

        ControlQualityExtend control = new ControlQualityExtend();
        FoodReproduct[] food = new FoodReproduct[2];

        Food beard =   new Beard("Darnickiy",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,3),25,7);
        Food bulka = new Beard("Bulka",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,28),22,8);
        food[0] = new WhiteBeard(true,beard);
        food[1] = new DarkBeard(true,bulka);

        Warehouse whs = new Warehouse("1st",10);
        Trash trash = new Trash("Empty",50);


        StorageExtended[] storage = new WarehouseExt[2];
        storage[0] = new WarehouseExt("new Warehouse",20,-10,whs);
        storage[1] = new WarehouseCold("new WarehouseCold",20,-10,trash);


        StartUINext start = new StartUINext(control,storage,food);
        start.work();
        start.printInfo();
    }

}
