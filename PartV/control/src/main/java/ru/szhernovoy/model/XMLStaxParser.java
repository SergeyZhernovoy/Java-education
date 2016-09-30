package ru.szhernovoy.model;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/**
 * Created by szhernovoy on 27.09.2016.
 */
public class XMLStaxParser {

    private final String XML_FILE;
    private Map<String,Set<Order>> unsort = new HashMap<>(3);

    public XMLStaxParser(String fileName){
        this.XML_FILE = fileName;

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
                          this.add(order,this.unsort,nameBook);
                    }
                    if(parser.getLocalName().equalsIgnoreCase("DeleteOrder")){
                          orderForDelete.setId(Long.valueOf(parser.getAttributeValue(null,"orderId")));
                          nameBook = parser.getAttributeValue(null,"book");
                          this.delete(orderForDelete,this.unsort,nameBook);
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

    private boolean add(Order order,Map<String,Set<Order>> collection,String name){
        if(!unsort.containsKey(name)){
            Set<Order> setBook = new HashSet<>();
            setBook.add(order);
            unsort.put(name,setBook);
        }
        else{
            Set<Order> setBook = unsort.get(name);
            setBook.add(order);
        }
        return true;
    }

    private boolean delete(Order order, Map<String, Set<Order>> collection,String nameBook) {
        if(unsort.containsKey(nameBook)){
            Set<Order> setBook = unsort.get(nameBook);
            setBook.remove(order);
        }
        else{
            throw new NoSuchElementException("This BookOrder is not");
        }
        return true;
    }

}
