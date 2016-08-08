package ru.szhernovoy.products;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Created by Sergey on 06.08.2016.
 */
public abstract class Food {

    protected String name;
    protected final GregorianCalendar expireDate;
    protected final GregorianCalendar createDate;
    protected int price = 0;
    protected int disscount = 0;

    public Food(String name, final GregorianCalendar createDate,final GregorianCalendar expireDate, int price, int disscount) {
        this.name = name;
        this.expireDate = expireDate;
        this.price = price;
        this.disscount = disscount;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public int calculatePercent(){

        int percent = 0;
        Calendar todayDate = new GregorianCalendar();
        double differentFull = (this.expireDate.getTimeInMillis() - this.createDate.getTimeInMillis())/1000;
        double differentCurrent = ( todayDate.getTimeInMillis() - this.createDate.getTimeInMillis())/1000;
        percent = (int)Math.abs((differentCurrent / differentFull) * 100);
        return percent;
    }

    public void changePrice(){
        this.price = this.price - this.price * this.disscount/100;
    }

}
