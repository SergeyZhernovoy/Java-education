package ru.szhernovoy.model;

/**
 * Created by admin on 11.08.2016.
 */
public class MenuItem implements Action, Information {
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
    private MenuItem[] actions;

    /**
     * Constructor
     * @param name
     */
    public MenuItem(final String name, String key){
        this.name = name;
        this.root = false;
        this.keyStr = key;
    }

    /**
     * Constructor for root.
     * @param size
     * @param name
     */
    public MenuItem(final String name, int size, String key){
        this.actions = new MenuItem[size];
        this.name = name;
        this.root = true;
        this.keyStr = key;

    }

    /**
     * Constructor for root.
     * @param name
     * @param actions
     */
    public MenuItem(final String name, MenuItem[] actions, String key){
        this.actions = actions;
        this.name = name;
        this.root = true;
        this.keyStr = key;
     }

    /**
     *
     * @param item
     */
    public void addItem(MenuItem item){
        if(this.root){
           this.actions[position++] = item;
        }
     }

    /**
     * Print information about point menu on screen
     */

    private void info(String delimetr) {
        System.out.println(getLineMenu(delimetr));
        if(this.root){
            delimetr = String.format("%s%s","-",delimetr);
            for (int index = 0; index < this.actions.length; index++){
                 this.actions[index].info(delimetr);
            }
        }
    }


    /**
     * Get line menu
     * @param delimetr
     */
    private String getLineMenu(String delimetr) {
        StringBuilder builder = new StringBuilder();
        builder.append(delimetr);
        builder.append(this.keyStr);
        builder.append("\t");
        builder.append(this.name);
        return builder.toString();
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
            for (Action action : this.actions){
                action.execute(key);
            }
        }
    }

    public String getKeyStr() {
        return keyStr;
    }

    @Override
    public void info() {
        System.out.println(getLineMenu(""));
        String delimetr = "-";
        if(root){
            for (MenuItem action : this.actions){
                action.info(delimetr);
            }
        }

    }
}
