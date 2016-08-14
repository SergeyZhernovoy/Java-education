package ru.szhernovoy.model;

/**
 * Created by admin on 13.08.2016.
 */
public class MenuRoot implements MenuAction {

    private MenuAction[] actions;
    private int position = 0;
    private String keyStr;
    private String name;
    /** value storage input*/
    private final Output io;


    public MenuRoot(int size, String name,final Output io){
        this.actions = new MenuAction[size];
        this.name = name;
        this.io = io;
    }

    public void addItem(MenuAction item){
        this.actions[position++] = item;
    }
    /**
     * Set parametrs in point's menu
     * @param keyStr
     * @param delimetr
     */
    @Override
    public void fillAction(String keyStr,String delimetr) {
        setParametrs(keyStr, delimetr);
        delimetr = String.format("%s%s","-",delimetr);
        for (int index = 0; index < this.actions.length; index++){
            String keyInSide = String.format("%s.%s",keyStr,String.valueOf(1+index));
            actions[index].fillAction(keyInSide,delimetr);
        }
    }

    /**
     * Set parametrs in point's menu
     * @param keyStr
     * @param delimetr
     */
    private void setParametrs(String keyStr, String delimetr) {
        StringBuilder builder = new StringBuilder();
        builder.append(delimetr);
        builder.append(keyStr);
        builder.append(".");
        builder.append("\t");
        builder.append(this.name);
        this.name = builder.toString();
        this.keyStr = keyStr;
    }

    /**
     * Print information about point menu on screen
     */
    @Override
    public void info() {
        io.println(this.name);
        for (MenuAction action : this.actions){
             action.info();
        }
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

        for (MenuAction action : this.actions){
            action.execute(key);
        }
     }



}
