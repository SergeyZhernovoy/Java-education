package ru.szhernovoy.security.carstore.domain;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by admin on 05.01.2017.
 */
@Entity(name = "orders")
public class Order {

    /**
     * Created by admin on 10.01.2017.
     */
    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;
    /**
     * Created by admin on 10.01.2017.
     */
    private int price;
    /**
     * Created by admin on 10.01.2017.
     */
    private Timestamp release;
    /**
     * Created by admin on 10.01.2017.
     */
    private int milesage;
    /**
     * Created by admin on 10.01.2017.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Created by admin on 10.01.2017.
     */
    private boolean sold;

    /**
     * Created by admin on 10.01.2017.
     */
    public Order() {

    }

    /**
     * Created by admin on 10.01.2017.
     * @return boolean
     */
    public boolean getSold() {
        return sold;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param sold .
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }


    /**
     * Created by admin on 10.01.2017.
     * @return Car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param car .
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param price .
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return Timestamp
     */
    public Timestamp getRelease() {
        return release;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param release .
     */
    public void setRelease(Timestamp release) {
        this.release = release;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return int
     */
    public int getMilesage() {
        return milesage;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param milesage .
     */
    public void setMilesage(int milesage) {
        this.milesage = milesage;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param id .
     */
    public void setId(int id) {
        this.id = id;
    }

    public boolean isSold() {
        return sold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
