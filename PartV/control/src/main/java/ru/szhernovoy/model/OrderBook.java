package ru.szhernovoy.model;

import java.util.*;

/**
 * Created by Sergey on 29.09.2016.
 */
public class OrderBook {

    private final Map<String,Set<Order>> unsorting;
    private Map<String,Map<Float,Order>> buy = new HashMap<>();
    private Map<String,Map<Float,Order>> sell = new HashMap<>();



    public OrderBook(Map<String, Set<Order>> unsorting) {
        this.unsorting = unsorting;
    }


    public List prepare(){
       List<Map<String,Map<Float,Order>>> calculate = new LinkedList<>();
       this.aggregation();
       this.compareValue();
       calculate.add(this.buy);
       calculate.add(this.sell);
       return calculate;
    }

    private boolean aggregation(){
        Set<String> keys = this.unsorting.keySet();
        for(String key: keys){
            Set<Order> orders = this.unsorting.get(key);
            Map<Float,Order> priceTreeBuy  = getTreeBuy(key);
            Map<Float,Order> priceTreeSell = getTreeSell(key);
            Iterator<Order> orderIterator = orders.iterator();
            while(orderIterator.hasNext()){
                Order order = orderIterator.next();
                if(order.getType() == OperType.BUY){
                    add(order,priceTreeBuy);
                }
                else{
                    add(order,priceTreeSell);
                }
            }
        }
        return true;
    }

}
