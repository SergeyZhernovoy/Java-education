package ru.szhernovoy.model;

/**
 * Created by admin on 13.08.2016.
 */
public class MenuRoot implements Action, ItemMenu {

    private MenuAction[] actions;
    private int key;

    public MenuRoot(int size, int key){
        this.key = ++key;
        this.actions = new MenuAction[size];
    }

    public void addItem(){

    }

    @Override
    public String execute() {
        return null;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void info() {

    }
}
