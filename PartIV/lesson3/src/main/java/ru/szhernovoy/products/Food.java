package ru.szhernovoy.products;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * main  class food
 * Created by Sergey on 06.08.2016.
 */
public abstract class Food {

    /** name product*/
    protected String name;
    /**this value identify date expire product */
    protected final GregorianCalendar expireDate;
    /**value storage date create product */
    protected final GregorianCalendar createDate;
    /**price in product */
    protected int price = 0;
    /** discount on product*/
    protected int disscount = 0;

    /**
     * Contructor.
     * @param name
     * @param createDate
     * @param expireDate
     * @param price
     * @param disscount
     */
    public Food(String name, final GregorianCalendar createDate,final GregorianCalendar expireDate, int price, int disscount) {
        this.name = name;
        this.expireDate = expireDate;
        this.price = price;
        this.disscount = disscount;
        this.createDate = createDate;
    }

    /**
     * Get name product.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * calculate difference between expire and create date product.
     * @return
     */
    public int calculatePercent(GregorianCalendar day){

        int percent = 0;
        Calendar todayDate = day;
        double differentFull = (this.expireDate.getTimeInMillis() - this.createDate.getTimeInMillis())/1000;
        double differentCurrent = ( todayDate.getTimeInMillis() - this.createDate.getTimeInMillis())/1000;
        percent = (int)Math.abs((differentCurrent / differentFull) * 100);
        return percent;
    }

    /**
     * Change price on product if expire date is begun.
     */
    public void changePrice(){
        this.price = this.price - this.price * this.disscount/100;
    }

}
