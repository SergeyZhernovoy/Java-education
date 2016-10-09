package ru.szhernovoy.treads2;

import java.util.GregorianCalendar;

/**
 * Created by admin on 09.10.2016.
 */
public class CounterWithWait {
    private final long startTime;

    public CounterWithWait(long startTime) {
        this.startTime = startTime;
    }

    public String info(String info,final long currentTime){
        System.out.println(String.format("%s : %d",info,currentTime - this.startTime));
        return info;
    }


}
