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


    public Map<String,List<Map<Float,Order>>> prepare(){
       Map<String,List<Map<Float,Order>>> calculate = new HashMap<>();
       this.aggregationAndCheckSide(calculate);
       return calculate;
    }

    private boolean aggregationAndCheckSide(Map<String,List<Map<Float,Order>>> calculate){

        Set<String> keys = this.unsorting.keySet();
        for(String key: keys){

            Set<Order> orders = this.unsorting.get(key);
            Map<Float,Order> priceTreeBuy  = getTree(key,this.buy,OperType.BUY);
            Map<Float,Order> priceTreeSell = getTree(key,this.sell,OperType.SELL);

            Map<Float,Order> priceTreeBuySort  = getTree("",null,OperType.BUY);
            Map<Float,Order> priceTreeSellSort = getTree("",null,OperType.SELL);

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
            checkOppositeSideBook(priceTreeBuy,priceTreeSell,priceTreeBuySort,priceTreeSellSort,true);
            checkOppositeSideBook(priceTreeSell,priceTreeBuy,priceTreeSellSort,priceTreeBuySort,false);
            List<Map<Float,Order>> next = new LinkedList<>();
            next.add(priceTreeBuySort);
            next.add(priceTreeSellSort);
            calculate.put(key,next);
        }
        return true;
    }

    private boolean checkOppositeSideBook(Map<Float,Order> side1,Map<Float,Order> side2,Map<Float,Order> sideSort1,Map<Float,Order> sideSort2
            , boolean checkType){

        Iterator<Float> iterBuy = side1.keySet().iterator();
        while(iterBuy.hasNext()){
            Iterator<Float> iterSell = side2.keySet().iterator();
            float currentPriceSide1 = iterBuy.next();
            boolean removeSide1 = false;
            while(iterSell.hasNext()){
                  boolean removeSide2 = false;
                  float currentPriceSide2 = iterSell.next();
                  if(checkType && currentPriceSide1 >= currentPriceSide2){
                      removeSide2 = true;
                      removeSide1 = true;
                  }

                  if(!checkType && currentPriceSide1 <= currentPriceSide2){
                    removeSide2 = true;
                    removeSide1 = true;
                  }

                  if(!removeSide2){
                     sideSort2.put(currentPriceSide2,side2.get(currentPriceSide2));
                  }


            }
            if(!removeSide1){
                sideSort1.put(currentPriceSide1,side1.get(currentPriceSide1));
            }
        }
        return true;
    }

    private boolean add(Order order,Map<Float,Order> collection){
        if(collection.containsKey(order.getPrice())){
            long oldValue = collection.get(order.getPrice()).getVolume();
            collection.put(order.getPrice(),new Order(order.getId(),order.getVolume() + oldValue,order.getPrice(),order.getType()));
        }
        else{
            collection.put(order.getPrice(),order);
        }
        return true;
    }

    private Map<Float,Order> getTree(String key,Map<String,Map<Float,Order>> collection,final OperType type){
        Map<Float,Order> needBook;
        if(collection != null && collection.containsKey(key)){
            needBook = collection.get(key);
        }
        else{
            needBook = new TreeMap<>(new Comparator<Float>() {
                @Override
                public int compare(Float o1, Float o2) {
                    int result;
                    if(type == OperType.BUY){
                        result = o1.compareTo(o2);
                    }
                    else{
                        result = o2.compareTo(o1);
                    }
                    return result;
                }
            });
            if(collection != null){
               collection.put(key,needBook);
            }

        }
        return needBook;
    }



}
