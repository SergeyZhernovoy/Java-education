package ru.szhernovoy.jpa.carstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 01.02.2017.
 */

@Controller
public class MainController {
/*
    private OrderService orderService;
    private CarService carService;

    @Autowired
    public MainController(OrderService orderService, CarService carService) {
        this.orderService = orderService;
        this.carService = carService;

    }

    @RequestMapping("/")
    public ModelAndView main(Model model){
        return new ModelAndView("index", "orders",orderService.get() );
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
    public String getAddNewProductForm(Model model, @ModelAttribute OrderDTO order) {
        model.addAttribute("newOrder", order);
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newOrder") OrderDTO order, HttpServletRequest request) {
        Car car = new Car();
        this.carService.add(car);
        car.setBody(this.carService.getBodyById(order.getBodyId()));
        car.setTransmission(this.carService.getTransmissionById(order.getTranssmId()));
        car.setModel(this.carService.getModelById(order.getModelId()));
        car.setDriveType(this.carService.getDriveTypeById(order.getDrivetypeId()));
        car.setEngine(this.carService.getEngineById(order.getEngineId()));
        car.setName(order.getNameCar());
        Order newOrder = new Order();

        MultipartFile image = order.getMultipartFile();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if(image != null && !image.isEmpty()){
                try{
                   image.transferTo(new File(rootDirectory+"resources\\images\\"+car.getId() + ".jpg"));
            } catch (Exception e) {
                throw new RuntimeException("Car image saving failed",e);
            }
        }

        this.orderService.create(newOrder);
        newOrder.setCar(car);
        newOrder.setPrice(order.getPrice());
        newOrder.setMilesage(order.getMile());
        newOrder.setRelease(new Timestamp(order.getRelease().getTime()));
        return "redirect:/";
    }

    @ModelAttribute("body")
    public List<Body> getBody(){
        return this.carService.getAllBody();
    }

    @ModelAttribute("model")
    public List<ru.szhernovoy.spring.carstore.domain.Model> getModel(){
        return this.carService.getAllModel();
    }

    @ModelAttribute("engine")
    public List<Engine> getEngine(){
        return this.carService.getAllEngine();
    }

    @ModelAttribute("transsm")
    public List<Transmission> getTranssm(){
        return this.carService.getAllTransmission();
    }

    @ModelAttribute("drivetype")
    public List<DriveType> getDriveType(){
        return this.carService.getAllDriveType();
    }
*/

}
