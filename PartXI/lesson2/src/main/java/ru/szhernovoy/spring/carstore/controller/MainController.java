package ru.szhernovoy.spring.carstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.szhernovoy.spring.carstore.model.User;

/**
 * Created by Admin on 01.02.2017.
 */

@Controller
public class MainController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(Model model){
        User user = new User();
        user.setName("Sergey");
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value = "/")
    public String welcom(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "index";
    }



}
