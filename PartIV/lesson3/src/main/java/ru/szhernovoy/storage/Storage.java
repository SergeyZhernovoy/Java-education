package ru.szhernovoy.storage;

import ru.szhernovoy.products.Food;

/**
 * Created by admin on 08.08.2016.
 */
public abstract class Storage {

    private String name;
    protected Food[] food = new Food[100];
    protected int position =0;

    public Storage(String name) {
        this.name = name;
    }

    public void addFood(Food food){
        this.food[position++] = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
