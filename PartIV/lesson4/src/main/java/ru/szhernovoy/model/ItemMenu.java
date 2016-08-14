package ru.szhernovoy.model;

/**
 *
 * Created by admin on 11.08.2016.
 */
public interface ItemMenu {

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
