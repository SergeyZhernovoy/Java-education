package ru.szhernovoy.start;

import ru.szhernovoy.products.*;
import ru.szhernovoy.storage.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Class control quality food
 * Created by admin on 08.08.2016.
 */
public class ControlQuality {

    private ArrayList <Storage> storages = new ArrayList<Storage>();
    private ArrayList <Food> foods = new ArrayList<Food>();
    /**
     * Move product in storage if conditions coincide
     */
    public void sortProduct() {
        for (Food product: foods) {
            for (Storage place: storages){
                if(place.matchRange(product)){
                        place.addFood(product);
                        break;
                }
            }
        }
    }

    public void addFood(Food food){
        this.foods.add(food);
    }

    public void addStorages(Storage storage){
        this.storages.add(storage);
    }

    /**
     * print products in storage
     */
    public void printInfo(){
        for (Storage place :storages) {
            System.out.println(place);
        }
    }

    public static void main(String[] args) {
        ControlQuality control = new ControlQuality();
        Food[] food = new Food[8];
        GregorianCalendar today = new GregorianCalendar(2016, GregorianCalendar.AUGUST,8);

        food[0] = new Bananas("Banana",new GregorianCalendar(2016, GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,9),45,5);
        food[1] = new Beard("Darnickiy",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,3),25,7);
        food[2] = new Beard("Bulka",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,28),22,8);
        food[3] = new Beard("4ebureck",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,10),35,10);
        food[4] = new Bananas("Banana Africa",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,12),99,25);
        food[5] = new Potatos("Red chilly peppers",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,15),17,35);
        food[6] = new Potatos("Fantazy",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,14),45,4);
        food[7] = new Potatos("White horse",new GregorianCalendar(2016,GregorianCalendar.AUGUST,1),new GregorianCalendar(2016,GregorianCalendar.AUGUST,9),50,6);

        for (int index = 0; index < food.length;index++){
            control.addFood(food[index]);
        }

        Storage[] storage = new Storage[3];
        storage[0] = new Shop("METRO",10, today);
        storage[1] = new Warehouse("1st",10, today);
        storage[2] = new Trash("Empty",50, today);

        for (int index = 0; index < storage.length;index++){
            control.addStorages(storage[index]);
        }
        control.sortProduct();
        control.printInfo();

    }

}
