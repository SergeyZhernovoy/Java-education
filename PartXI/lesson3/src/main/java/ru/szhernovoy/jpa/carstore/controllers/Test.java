package ru.szhernovoy.jpa.carstore.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.szhernovoy.jpa.carstore.domain.Car;
import ru.szhernovoy.jpa.carstore.domain.DriveType;
import ru.szhernovoy.jpa.carstore.domain.Model;
import ru.szhernovoy.jpa.carstore.domain.Transmission;
import ru.szhernovoy.jpa.carstore.repositories.*;
import ru.szhernovoy.jpa.carstore.service.CarService;
import ru.szhernovoy.jpa.carstore.service.OrderService;
import ru.szhernovoy.jpa.carstore.service.impl.CarServiceImpl;
import ru.szhernovoy.jpa.carstore.service.impl.OrderServiceImpl;

/**
 * Created by Admin on 13.02.2017.
 */


public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data.xml");
        BodyCrud repository1 = context.getBean(BodyCrud.class);
        DriveTypeCrud repository2 = context.getBean(DriveTypeCrud.class);
        ModelCrud repository3 = context.getBean(ModelCrud.class);
        TranssmCrud repository4 = context.getBean(TranssmCrud.class);
        EngineCrud repository5 = context.getBean(EngineCrud.class);
        CarCrud repository6 = context.getBean(CarCrud.class);
        CarService carService = new CarServiceImpl(repository1,repository2,repository3,repository4,repository5, repository6);
        System.out.println(carService.getAllBody());
        System.out.println(carService.getAllDriveType());
        System.out.println(carService.getAllEngine());
        System.out.println(carService.getAllModel());
        System.out.println(carService.getAllTransmission());

        OrderCrud repo1 = context.getBean(OrderCrud.class);
        OrderService service = new OrderServiceImpl(repo1);

        System.out.println(carService.getAllCar());

        System.out.println("******************************************");
        System.out.println(service.get());

    }
}
