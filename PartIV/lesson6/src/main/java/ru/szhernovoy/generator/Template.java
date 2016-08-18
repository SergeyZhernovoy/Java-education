package ru.szhernovoy.generator;

/**
 * Created by admin on 18.08.2016.
 */
public interface Template {
    String generate(String template, Object[] value);
}
