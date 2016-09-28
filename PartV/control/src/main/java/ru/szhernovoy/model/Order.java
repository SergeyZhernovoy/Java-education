package ru.szhernovoy.model;

/**
 * Created by admin on 26.09.2016.
 */
public class Order {

    private int id;
    private int volume;
    private float price;

    public Order(int id, int volume, float price) {
        this.id = id;
        this.volume = volume;

        this.price = price;
    }
}
