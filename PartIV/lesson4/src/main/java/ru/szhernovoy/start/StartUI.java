package ru.szhernovoy.start;

import ru.szhernovoy.model.MenuAction;

/**
 * Created by admin on 11.08.2016.
 */
public class StartUI {

    private MenuAction[] actions;
    private int position = 0;

    public StartUI(int size){
        this.actions = new MenuAction[size];
    }

    public void print(){
        for (MenuAction action:this.actions) {
            action.info();
        }
    }

    public void addItem(MenuAction action){
        actions[position++] = action;
    }

    public void work(){

    }
}
