package ru.szhernovoy.carstore.model;


import java.util.Arrays;

/**
 * Created by admin on 10.01.2017.
 */
public class Image {
    /**
     * Created by admin on 10.01.2017.
     */
    private int id;
    /**
     * Created by admin on 10.01.2017.
     */

    private byte[] dataimage;

    private Order order;

    /**
     * Created by admin on 10.01.2017.
     */
    public Image() {
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


    public byte[] getDataimage() {
        return dataimage;
    }

    public void setDataimage(byte[] dataimage) {
        this.dataimage = dataimage;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
