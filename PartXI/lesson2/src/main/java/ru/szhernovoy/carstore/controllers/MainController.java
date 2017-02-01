package ru.szhernovoy.carstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.szhernovoy.carstore.utils.HibernateSessionFactory;

/**
 * Created by Admin on 31.01.2017.
 */

@Controller
public class MainController {

    public void init(){
        HibernateSessionFactory.getSessionFactory();
    }


    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public Boolean matchUserSignin(ModelMap model){

        return true;
    }

}
