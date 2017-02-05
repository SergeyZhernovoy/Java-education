package ru.szhernovoy.spring.carstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.szhernovoy.spring.carstore.domain.Car;
import ru.szhernovoy.spring.carstore.domain.Order;
import ru.szhernovoy.spring.carstore.service.CarService;
import ru.szhernovoy.spring.carstore.service.OrderService;

import java.sql.Timestamp;

/**
 * Created by Admin on 01.02.2017.
 */

@Controller
public class MainController {

    private OrderService orderService;
    private CarService carService;

    @Autowired
    public MainController(OrderService orderService, CarService carService) {

        this.orderService = orderService;
        this.carService = carService;

        Car car = carService.add(new Car());
        car.setName("Audi 100");
        car.setBody(carService.getBodyById(1));
        car.setDriveType(carService.getDriveTypeById(1));
        car.setEngine(carService.getEngineById(1));
        car.setModel(carService.getModelById(1));
        car.setTransmission(carService.getTransmissionById(1));

        Order order = orderService.create(new Order());
        order.setCar(car);
        order.setMilesage(10000);
        order.setPrice(250000);
        order.setRelease(new Timestamp(System.currentTimeMillis()));

        Car car1 = carService.add(new Car());
        car1.setName("Audi 100");
        car1.setBody(carService.getBodyById(1));
        car1.setDriveType(carService.getDriveTypeById(1));
        car1.setEngine(carService.getEngineById(1));
        car1.setModel(carService.getModelById(1));
        car1.setTransmission(carService.getTransmissionById(1));

        Order order1 = orderService.create(new Order());
        order1.setCar(car1);
        order1.setMilesage(10000);
        order1.setPrice(250000);
        order1.setRelease(new Timestamp(System.currentTimeMillis()));

        Car car2 = carService.add(new Car());
        car2.setName("Audi 100");
        car2.setBody(carService.getBodyById(1));
        car2.setDriveType(carService.getDriveTypeById(1));
        car2.setEngine(carService.getEngineById(1));
        car2.setModel(carService.getModelById(1));
        car2.setTransmission(carService.getTransmissionById(1));

        Order order2 = orderService.create(new Order());
        order2.setCar(car2);
        order2.setMilesage(10000);
        order2.setPrice(250000);
        order2.setRelease(new Timestamp(System.currentTimeMillis()));

        Car car3 = carService.add(new Car());
        car3.setName("Audi 100");
        car3.setBody(carService.getBodyById(1));
        car3.setDriveType(carService.getDriveTypeById(1));
        car3.setEngine(carService.getEngineById(1));
        car3.setModel(carService.getModelById(1));
        car3.setTransmission(carService.getTransmissionById(1));

        Order order3 = orderService.create(new Order());
        order3.setCar(car3);
        order3.setMilesage(10000);
        order3.setPrice(250000);
        order3.setRelease(new Timestamp(System.currentTimeMillis()));

        Car car4 = carService.add(new Car());
        car4.setName("Audi 100");
        car4.setBody(carService.getBodyById(1));
        car4.setDriveType(carService.getDriveTypeById(1));
        car4.setEngine(carService.getEngineById(1));
        car4.setModel(carService.getModelById(1));
        car4.setTransmission(carService.getTransmissionById(1));

        Order order4 = orderService.create(new Order());
        order4.setCar(car4);
        order4.setMilesage(10000);
        order4.setPrice(250000);
        order4.setRelease(new Timestamp(System.currentTimeMillis()));

        Car car5 = carService.add(new Car());
        car5.setName("Audi 100");
        car5.setBody(carService.getBodyById(1));
        car5.setDriveType(carService.getDriveTypeById(1));
        car5.setEngine(carService.getEngineById(1));
        car5.setModel(carService.getModelById(1));
        car5.setTransmission(carService.getTransmissionById(1));

        Order order5 = orderService.create(new Order());
        order5.setCar(car5);
        order5.setMilesage(10000);
        order5.setPrice(250000);
        order5.setSold(true);
        order5.setRelease(new Timestamp(System.currentTimeMillis()));

    }

    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("orders",orderService.get());
        return "index";
    }

    @RequestMapping("/car")
    public String getProductById(@RequestParam("id") int carId, Model model) {
        Car car = carService.getCarById(carId);
        model.addAttribute("car", car);
        model.addAttribute("body",car.getBody());
        model.addAttribute("model",car.getModel());
        model.addAttribute("transsm",car.getTransmission());
        model.addAttribute("engine",car.getEngine());
        model.addAttribute("drive",car.getDriveType());
        return "info";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model, @ModelAttribute Order order, @ModelAttribute Car car) {
        model.addAttribute("newOrder", order);
        model.addAttribute("newCar",car);
        model.addAttribute("model",this.carService.getAllModel());
        model.addAttribute("body",this.carService.getAllBody());
        model.addAttribute("engine",this.carService.getAllEngine());
        model.addAttribute("transsm",this.carService.getAllTransmission());
        model.addAttribute("drive",this.carService.getAllDriveType());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newOrder") Order order,@ModelAttribute("newCar") Car car ) {
        this.carService.add(car);
        this.orderService.create(order);
        order.setCar(car);
        return "redirect:/";
    }

}
