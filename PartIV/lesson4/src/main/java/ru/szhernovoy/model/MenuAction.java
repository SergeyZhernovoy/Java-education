package ru.szhernovoy.model;

/**
 * Created by admin on 11.08.2016.
 */
public interface MenuAction  {
    /**
     * Execute any action. This method only prints the name of the menu item and the name of the item changed.
     * @param key key for choice point from menu
     */
    void execute(String key);

    /**
     * Print information about point menu on screen
     */
    void info();

    /**
     * Set parametrs in point's menu
     * @param key
     * @param delimetr
     */
    void fillAction(String key,String delimetr);
}
