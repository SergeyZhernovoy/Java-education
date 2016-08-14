package ru.szhernovoy.model;

/**
 * Created by admin on 14.08.2016.
 */
public class ConsoleOutput implements Output {
    @Override
    public void println(Object value) {
        System.out.println(value);
    }
}
