package ru.szhernovoy.generator;

import java.util.Map;

/**
 * Created by admin on 18.08.2016.
 */
public interface Template {
    String generate(String template, Map<String,String> map) throws KeyException;
}
