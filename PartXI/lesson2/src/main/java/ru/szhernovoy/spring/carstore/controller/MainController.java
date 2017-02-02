package ru.szhernovoy.spring.carstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 01.02.2017.
 */

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String welcome(Model model){

        model.addAttribute("greeting","Education spring");
        return "index";
    }
}
