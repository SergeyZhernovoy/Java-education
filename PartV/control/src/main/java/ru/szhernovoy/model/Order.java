package ru.szhernovoy.model;

/**
 * Created by admin on 26.09.2016.
 */
public class Order {

    private long id;
    private long volume;
    private float price;

    public float getPrice() {
        return this.price;
    }

    public long getId() {
        return id;
    }

    public long getVolume() {
        return volume;
    }

    private OperType type;

    public Order(long id, long volume, float price, OperType type) {
        this.id = id;
        this.volume = volume;
        this.price = price;
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (volume != order.volume) return false;
        if (Float.compare(order.price, price) != 0) return false;
        return type == order.type;

    }

    @Override
    public int hashCode() {
        return (int)this.id;
    }

    public OperType getType() {
        return type;
    }
}
