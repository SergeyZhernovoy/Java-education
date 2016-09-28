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


/**
 * Created by szhernovoy on 27.09.2016.
 */
public class XMLStaxParser {

    private Action[] action;
    private final String XML_FILE;
   // private final Map<String,Order> orders;


    public XMLStaxParser(String fileName){
        this.XML_FILE = fileName;
       // this.orders = orders;
        this.action = new Action[2];
        this.action[0] = new AddOrder();
        this.action[1] = new DeleteOrder();
    }

    public boolean parsingFile(){

        long start = System.currentTimeMillis();
        String nameBook ="", typeOrder = null;
        float price =0;
        int volume =0,orderId = 0;
        try {
            InputStream in = new FileInputStream(this.XML_FILE);
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader parser = factory.createXMLStreamReader(in);
            while(parser.hasNext()){
                int event = parser.next();
                if(event == XMLStreamReader.START_ELEMENT){
                    int indexAction = 0;
                    if(parser.getLocalName().equalsIgnoreCase("AddOrder")){
                          typeOrder = parser.getAttributeValue(null,"operation");
                          price = Float.valueOf(parser.getAttributeValue(null,"price"));
                          volume = Integer.valueOf(parser.getAttributeValue(null,"volume"));
                          orderId = Integer.valueOf(parser.getAttributeValue(null,"orderId"));
                          nameBook  = parser.getAttributeValue(null,"book");
                    }
                    if(parser.getLocalName().equalsIgnoreCase("DeleteOrder")){
                          indexAction = 1;
                          orderId = Integer.valueOf(parser.getAttributeValue(null,"orderId"));
                          nameBook  = parser.getAttributeValue(null,"book");
                    }
                    action[indexAction].execute(nameBook,typeOrder,price,volume,orderId);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        System.out.printf("Elapsed time is %s ms",System.currentTimeMillis() - start);
        return true;
    }

    public static void main(String[] args) {
        if(args.length > 0){
            XMLStaxParser easyParser = new XMLStaxParser(args[0]);
            easyParser.parsingFile();
        }
    }
}
