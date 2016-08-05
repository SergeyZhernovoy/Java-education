package ru.szhernovoy.calculator.model;

/**Own exception out value from range
 * Created by szhernovoy on 04.08.2016.
 */
public class MenuOfException extends RuntimeException {

    /**
     * Constructor.
     * @param msg
     */
    public MenuOfException(String msg){
        super(msg);
    }
}