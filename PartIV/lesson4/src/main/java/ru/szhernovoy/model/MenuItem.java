package ru.szhernovoy.model;

/**
 * Created by admin on 11.08.2016.
 */
public class MenuItem implements ItemMenu,Action {

    private String key;
    private String information;
    private MenuAction[] actions;
    private int position = 0 ;

    public MenuItem(String info, int size){
        this.information = info;
        this.actions = new MenuAction[size];
    }

    public void addMenuAction(MenuAction action){
        this.actions[position++] = action;

    }

    public void updateKey(String key){
        this.key = String.format("%s.%s",this.key,key);
    }



    @Override
    public void info() {
        System.out.println(String.format("%s. %s ", this.key, this.information));
        for (MenuAction element:this.actions) {
             element.info();
        }
    }

    @Override
    public String execute() {
        return String.format("Press item menu %s. ", this.key);
    }
}
