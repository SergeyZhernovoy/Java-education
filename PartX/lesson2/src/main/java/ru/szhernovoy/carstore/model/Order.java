package ru.szhernovoy.carstore.model;


import java.sql.Timestamp;
import java.util.List;

/**
 * Created by admin on 05.01.2017.
 */
public class Order {
    private boolean isSold;
    private List<Image> imageCarList;
    private Car car;
    private int price;
    private Timestamp release;
    private int milesage;
    private int id;
    private User user;

    public Order() {
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public List<Image> getImageCarList() {
        return imageCarList;
    }

    public void setImageCarList(List<Image> imageCarList) {
        this.imageCarList = imageCarList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getRelease() {
        return release;
    }

    public void setRelease(Timestamp release) {
        this.release = release;
    }

    public int getMilesage() {
        return milesage;
    }

    public void setMilesage(int milesage) {
        this.milesage = milesage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
