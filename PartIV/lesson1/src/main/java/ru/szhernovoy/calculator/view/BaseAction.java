package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by szhernovoy on 04.08.2016.
 */
public abstract class BaseAction implements UserAction {

    private String name;



    public BaseAction(String name){
        this.name = name;

    }

    public String info(){
        return String.format("%s.) %s", this.key(),this.name);
    }


}