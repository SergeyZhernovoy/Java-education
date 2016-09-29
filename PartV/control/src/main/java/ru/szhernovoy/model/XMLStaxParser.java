package ru.szhernovoy.model;

import ru.szhernovoy.controler.Action;
import ru.szhernovoy.controler.AddOrder;
import ru.szhernovoy.controler.DeleteOrder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 * Created by szhernovoy on 27.09.2016.
 */
public class XMLStaxParser {

    private Action[] action;
    private final String XML_FILE;
    private Map<String,Set<Order>> unsort = new HashMap<>(3);

    public XMLStaxParser(String fileName){
        this.XML_FILE = fileName;
        this.action = new Action[2];
        this.action[0] = new AddOrder();
        this.action[1] = new DeleteOrder();
    }

    public Map<String, Set<Order>> getListOfBook() {
        return this.unsort;
    }

    public boolean parsingFile(){

        Order  orderForDelete = new Order(0,0,0,OperType.BUY);
        Order  order = null;
        String nameBook = null;
        try {
            InputStream in = new FileInputStream(this.XML_FILE);
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader parser = factory.createXMLStreamReader(in);
            while(parser.hasNext()){
                int event = parser.next();
                if(event == XMLStreamReader.START_ELEMENT){
                     if(parser.getLocalName().equalsIgnoreCase("AddOrder")){
                          nameBook = parser.getAttributeValue(null,"book");
                          order = new Order(Long.valueOf(parser.getAttributeValue(null,"orderId")),
                                                     Long.valueOf(parser.getAttributeValue(null,"volume")),
                                                     Float.valueOf(parser.getAttributeValue(null,"price")),
                                                     parser.getAttributeValue(null,"operation").equals("BUY")? OperType.BUY:OperType.SELL);
                          action[0].firstRound(order,this.unsort,nameBook);
                    }
                    if(parser.getLocalName().equalsIgnoreCase("DeleteOrder")){
                          orderForDelete.setId(Long.valueOf(parser.getAttributeValue(null,"orderId")));
                          nameBook = parser.getAttributeValue(null,"book");
                          action[1].firstRound(orderForDelete,this.unsort,nameBook);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return true;
    }


}
