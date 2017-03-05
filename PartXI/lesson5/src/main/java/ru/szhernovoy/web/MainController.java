package ru.szhernovoy.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.szhernovoy.service.OrderService;


/**
 * Created by Admin on 01.02.2017.
 */

@Controller
public class MainController {

    private OrderService orderService;


    @Autowired
    public MainController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public ModelAndView main(Model model){
        return new ModelAndView("index", "orders",orderService.get() );
    }



}
