package ru.szhernovoy.model;

/**
 * Created by admin on 11.08.2016.
 */
public class MenuItem implements MenuAction {
    /** key point menu*/
    private String keyStr;
    /** name point menu*/
    private String name;
    /** value storage input*/
    private final Output io;

    /**
     * Constructor
     * @param name
     */
    public MenuItem(final String name, final Output io){
        this.name = name;
        this.io = io;
    }
    /**
     * Set parametrs in point's menu
     * @param key
     * @param delimetr
     */
    @Override
    public void fillAction(String key, String delimetr) {
        StringBuilder builder = new StringBuilder();
        builder.append(delimetr);
        builder.append(key);
        builder.append(".");
        builder.append("\t");
        builder.append(this.name);
        this.name = builder.toString();
        this.keyStr = key;
    }
    /**
     * Print information about point menu on screen
     */
    @Override
    public void info() {
       io.println(this.name);
    }
    /**
     * Execute any action. This method only prints the name of the menu item and the name of the item changed.
     * @param key key for choice point from menu
     */
    @Override
    public void execute(String key) {
        if(this.keyStr.equals(key)){
            io.println(String.format("You choice is %s and this item is %s",this.keyStr,this.name));
        }
    }


}
