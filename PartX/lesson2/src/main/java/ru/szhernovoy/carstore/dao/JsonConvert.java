package ru.szhernovoy.carstore.dao;

import com.google.gson.JsonArray;

import java.util.Collection;

/**
 * Created by szhernovoy on 13.01.2017.
 */
public interface JsonConvert<T> {
    JsonArray convert(Collection<T> collection);
}
