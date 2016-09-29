package ru.szhernovoy.view;

import ru.szhernovoy.model.XMLStaxParser;

/**
 * Created by admin on 26.09.2016.
 */
public class StartUI {
    private XMLStaxParser item;
//
    public static void main(String[] args) {
    if(args.length > 0){
        XMLStaxParser easyParser = new XMLStaxParser(args[0]);
        easyParser.parsingFile();
    }
}


}
