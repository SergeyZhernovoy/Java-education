package ru.szhernovoy.storage;

import ru.szhernovoy.products.Products;

/**
 * Created by szhernovoy on 09.08.2016.
 */
public interface StorageInterface {
    void addFood(Products food);
    boolean matchRange(Products food);

}
