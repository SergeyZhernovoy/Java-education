package ru.szhernovoy.model;

/**
 * Created by admin on 11.08.2016.
 */
public class MenuItem implements MenuAction {
    /** key point menu*/
    private String keyStr;
    /** name point menu*/
    private String name;
    /**currant position in array action */
    private int position = 0;
    /**type of item */
    private boolean root;
    /**
     * value storage point action menu 1st level.*/
    private MenuAction[] actions;

    /**
     * Constructor
     * @param name
     */
    public MenuItem(final String name){
        this.name = name;
        this.root = false;
    }

    /**
     * Constructor for root.
     * @param size
     * @param name
     */
    public MenuItem(final String name, int size){
        this.actions = new MenuAction[size];
        this.name = name;
        this.root = true;
    }

    /**
     * Constructor for root.
     * @param name
     * @param actions
     */
    public MenuItem(final String name, MenuAction[] actions){
        this.actions = actions;
        this.name = name;
        this.root = true;
    }

    /**
     *
     * @param item
     */
    public void addItem(MenuAction item){
        if(this.root){
           this.actions[position++] = item;
        }
     }

    /**
     * Set parametrs in point's menu
     * @param keyStr
     * @param delimetr
     */
    @Override
    public void fillAction(String keyStr,String delimetr) {
        setParametrs(keyStr, delimetr);
        if(this.root){
            delimetr = String.format("%s%s","-",delimetr);
            for (int index = 0; index < this.actions.length; index++){
                String keyInSide = String.format("%s.%s",keyStr,String.valueOf(1+index));
                this.actions[index].fillAction(keyInSide,delimetr);
            }
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
        System.out.println(this.name);
        if(root){
            for (MenuAction action : this.actions){
                action.info();
            }
        }
    }

    /**
     * Execute any action. This method only prints the name of the menu item and the name of the item changed.
     * @param key key for choice point from menu
     */
    @Override
    public void execute(String key) {
        if(this.keyStr.equals(key)){
            System.out.println(String.format("You choice is %s and this item is %s",this.keyStr,this.name));
        }
        if(root){
            for (MenuAction action : this.actions){
                action.execute(key);
            }
        }
    }

    public String getKeyStr() {
        return keyStr;
    }
}
