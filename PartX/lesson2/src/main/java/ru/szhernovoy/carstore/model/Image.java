package ru.szhernovoy.carstore.model;


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
    private byte[] data;
    /**
     * Created by admin on 10.01.2017.
     */
    private String filepath;

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

    /**
     * Created by admin on 10.01.2017.
     * @return byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param data .
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return String
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param filepath .
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
