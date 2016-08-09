package ru.szhernovoy.extended;

import ru.szhernovoy.products.Bananas;
import ru.szhernovoy.products.Beard;
import ru.szhernovoy.products.Food;
import ru.szhernovoy.products.Potatos;
import ru.szhernovoy.start.ControlQuality;
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
    private final WarehouseTemp[] storage;
    /**array products */
    private final FoodReproduct[] food;

    /**
     * Constructor.
     * @param control
     * @param storage
     * @param food
     */
    public StartUINext(final ControlQualityExtend control, final WarehouseTemp[] storage, final FoodReproduct[] food){
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

        food[0] = new FoodReproduct(,new Bananas("Banana",new GregorianCalendar(2016, GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,9),45,5));
        ;
        food[1] = new Beard("Darnickiy",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,3),25,7);

        WarehouseTemp[] storage = new WarehouseTemp[3];
        storage[0] = new Shop("METRO",10);
        storage[1] = new Warehouse("1st",10);
        storage[2] = new Trash("Empty",50);

        StartUINext start = new StartUINext(control,storage,food);
        start.work();
        start.printInfo();
    }

}
