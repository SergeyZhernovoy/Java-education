package ru.szhernovoy.convert;

import java.util.Iterator;

/**
 * Created by szhernovoy on 26.08.2016.
 */
public interface Converter <Integer> {
    Iterator <Integer> convert(Iterator<Iterator<Integer>> it);
}
