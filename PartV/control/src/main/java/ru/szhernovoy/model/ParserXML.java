package ru.szhernovoy.model;


import ru.szhernovoy.controler.Action;

import java.util.Map;

/**
 * Created by szhernovoy on 27.09.2016.
 */
public class ParserXML{

    private Action[] action;
    private final String XML_FILE;
    private final Map<String,Order> orders;


    public ParserXML(String fileName, Map<String,Order> orders){
        this.XML_FILE = fileName;
        this.orders = orders;
    }




}
