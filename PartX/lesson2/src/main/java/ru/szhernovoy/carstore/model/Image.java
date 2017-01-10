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
    private String fileName;
    private byte[] dataimage;
    private String filename;
    private Order order;

    /**
     * Created by admin on 10.01.2017.
     */
    public Image() {
    }

    public void setId(Integer id) {
        this.id = id;
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

     /**
     * Created by admin on 10.01.2017.
     * @return String
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param fileName .
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getDataimage() {
        return dataimage;
    }

    public void setDataimage(byte[] dataimage) {
        this.dataimage = dataimage;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
