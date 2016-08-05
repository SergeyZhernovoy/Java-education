package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by szhernovoy on 04.08.2016.
 */
public abstract class BaseAction implements UserAction {

    /** name point menu*/
    private String name;

    /** constructor , which set name*/
    public BaseAction(String name){
        this.name = name;

    }

    /**
     * Method print key menu and name action menu.
     * @return
     */
    public String info(){
        return String.format("%s.) %s", this.key(),this.name);
    }


}