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

    /**array with place of storage*/
    private ArrayList<StorageExtended> storages = new ArrayList<>();

    /**
     * default constructor
     */
    public ControlQualityExtend(){
     }

    /**
     * Constructor.
     * @param strg
     */
    public ControlQualityExtend(ArrayList<StorageExtended> strg){
        super();
        this.storages = strg;
    }

    /**
     * Add food in storage by sorting.
     * @param food
     */
    public void addFood(FoodReproduct food){

        boolean sort =  false;
        for (StorageExtended place: this.storages){
            if(place.matchRange(food)){
                place.addFood(food);
                sort = true;
                break;
            }
       }

       if(!sort){
          super.addFood(food.getFood());
       }

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
        super.printInfo();
        for (Storage place :this.storages) {
            System.out.println(place);
        }

    }

    public static void main(String[] args) {

        FoodReproduct[] food = new FoodReproduct[2];
        GregorianCalendar today = new GregorianCalendar(2016, GregorianCalendar.AUGUST,8);
        Food beard =   new Beard("Darnickiy",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,3),25,7);
        Food bulka = new Beard("Bulka",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,28),22,8);
        food[0] = new WhiteBeard(true,beard,today);
        food[1] = new DarkBeard(true,bulka,today);

        ArrayList<StorageExtended> strg = new ArrayList<>();
        Warehouse whs = new Warehouse("1st",10, today);
        Trash trash = new Trash("Empty",50, today);
        strg.add(new WarehouseExt("new Warehouse",20,-10,today,whs));
        strg.add(new WarehouseCold("new WarehouseCold",20,-10,today));

        ControlQualityExtend control = new ControlQualityExtend(strg);
        control.addStorages(trash);
        for (int index = 0; index < food.length;index++){
            control.addFood(food[index]);
        }
        control.printInfo();
    }

}
