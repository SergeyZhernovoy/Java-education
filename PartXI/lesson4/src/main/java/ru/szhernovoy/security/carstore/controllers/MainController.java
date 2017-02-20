package ru.szhernovoy.security.carstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.szhernovoy.security.carstore.dto.ViewDTO;
import ru.szhernovoy.security.carstore.service.CarService;
import ru.szhernovoy.security.carstore.service.OrderService;
import ru.szhernovoy.security.carstore.domain.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

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
    public String getAddNewProductForm(Model model, @ModelAttribute("orderDTO") ViewDTO order) {
        //model.addAttribute("orderDTO", order);
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("orderDTO") ViewDTO order, HttpServletRequest request) {

        Car car = new Car();
        car.setBody(this.carService.getBodyById(order.getBodyId()));
        car.setTransmission(this.carService.getTransmissionById(order.getTranssmId()));
        car.setModel(this.carService.getModelById(order.getModelId()));
        car.setDriveType(this.carService.getDriveTypeById(order.getDrivetypeId()));
        car.setEngine(this.carService.getEngineById(order.getEngineId()));
        car.setName(order.getNameCar());

        MultipartFile image = order.getMultipartFile();
        car.setCarImage(image.getOriginalFilename());
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if(image != null && !image.isEmpty()){
                try{
                   image.transferTo(new File(rootDirectory+"resources\\images\\"+car.getCarImage()));
            } catch (Exception e) {
                throw new RuntimeException("Car image saving failed",e);
            }
        }

        this.carService.add(car);
        Order newOrder = new Order();
        newOrder.setCar(car);
        newOrder.setPrice(order.getPrice());
        newOrder.setMilesage(order.getMile());
        newOrder.setRelease(new Timestamp(order.getRelease().getTime()));
        this.orderService.create(newOrder);
        return "redirect:/";
    }

    @ModelAttribute("body")
    public List<Body> getBody(){
        return this.carService.getAllBody();
    }

    @ModelAttribute("model")
    public List<ru.szhernovoy.security.carstore.domain.Model> getModel(){
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

}
