package ru.szhernovoy.view;

import ru.szhernovoy.model.OrderBook;
import ru.szhernovoy.model.XMLStaxParser;

/**
 * Created by admin on 26.09.2016.
 */
public class StartUI {
       //
    public static void main(String[] args) {
        if(args.length > 0){
            long start = System.currentTimeMillis();
            XMLStaxParser easyParser = new XMLStaxParser(args[0]);
            easyParser.parsingFile();
            OrderBook books = new OrderBook(easyParser.getListOfBook());
            StartUI view = new StartUI();
            view.printBooks(books);
            System.out.println(String.format("Elapsed time is %d ms.",System.currentTimeMillis()-start));
        }
    }

    public void printBooks(OrderBook book){

    }



}
