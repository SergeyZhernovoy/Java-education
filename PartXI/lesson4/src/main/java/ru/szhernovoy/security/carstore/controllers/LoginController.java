package ru.szhernovoy.security.carstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 17.02.2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "login";
    }
}


