package ru.szhernovoy.io;

import ru.szhernovoy.model.Order;
import ru.szhernovoy.model.OrderBook;
import ru.szhernovoy.model.XMLStaxParser;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
            Map<String,List<Map<Float,Order>>>  sortBooks = books.prepare();
            StartUI view = new StartUI();
            view.printBooks(sortBooks);
            System.out.println(String.format("Elapsed time is %d ms.",System.currentTimeMillis()-start));
        }
    }

    public void printBooks(Map<String,List<Map<Float,Order>>>  sortList){
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,List<Map<Float,Order>>> currentBook : sortList.entrySet()) {
            builder.append("\n\n\n");
            builder.append(String.format("Order book: ${%s}\n\n", currentBook.getKey()));
            builder.append(String.format("|%-10s|%-10s|%-10s%n", "BID|", "PRICE|","ASK|"));
            Map<Float,Order> buy  = currentBook.getValue().get(0);
            Map<Float,Order> sell = currentBook.getValue().get(1);

            Iterator<Map.Entry<Float, Order>> iterSell = sell.entrySet().iterator();
            Iterator<Map.Entry<Float, Order>> iterBuy = buy.entrySet().iterator();
            while (iterSell.hasNext() || iterBuy.hasNext()) {


                Map.Entry<Float,Order> pairB = iterBuy.hasNext()  ? iterBuy.next() : null;
                Map.Entry<Float,Order> pairS = iterSell.hasNext() ? iterSell.next() : null;



                if(pairB != null && pairS != null){
                    builder.append(String.format("%d@%.2f - %d@%.2f \n", pairB.getValue().getVolume(), pairB.getValue().getPrice(), pairS.getValue().getVolume(),pairS.getValue().getPrice()));
                }

                if (pairS == null && pairB != null) {
                    builder.append(String.format("%d@%.2f - ------- \n", pairB.getValue().getVolume(), pairB.getValue().getPrice()));
                }
                if (pairS != null && pairB == null) {
                    builder.append(String.format("------- - %d@%.2f \n", pairS.getValue().getVolume(), pairS.getValue().getPrice()));
                }
         }

    }
        System.out.println(builder.toString());
    }

}
