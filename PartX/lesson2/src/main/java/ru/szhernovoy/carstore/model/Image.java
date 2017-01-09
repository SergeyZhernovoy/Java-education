package ru.szhernovoy.carstore.model;


/**
 * Created by admin on 10.01.2017.
 */
public class Image {
    private int id;
    private byte[] data;

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
