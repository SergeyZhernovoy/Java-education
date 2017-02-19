package ru.szhernovoy.security.carstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 17.02.2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout",required = false) String logout, Model model) {

        if (error != null){
            model.addAttribute("error","Invalid username or password");
        }
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


