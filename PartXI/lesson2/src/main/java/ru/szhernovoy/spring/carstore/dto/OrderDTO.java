package ru.szhernovoy.spring.carstore.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;

/**
 * Created by Admin on 06.02.2017.
 */


public class OrderDTO {

    private int bodyId;
    private int modelId;
    private int engineId;
    private int transsmId;
    private int drivetypeId;
    private String nameCar;
    private int price;
    private int mile;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date release;

    private MultipartFile multipartFile = null;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMile() {
        return mile;
    }

    public void setMile(int mile) {
        this.mile = mile;
    }


    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public int getBodyId() {
        return bodyId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public int getTranssmId() {
        return transsmId;
    }

    public void setTranssmId(int transsmId) {
        this.transsmId = transsmId;
    }

    public int getDrivetypeId() {
        return drivetypeId;
    }

    public void setDrivetypeId(int drivetypeId) {
        this.drivetypeId = drivetypeId;
    }

    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }
}
