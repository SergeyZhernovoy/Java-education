package ru.szhernovy.jobvacancy.controller;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovy.jobvacancy.model.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;


public class DBManager {
    private static Logger log = LoggerFactory.getLogger(DBManager.class);
   // private final Set<Vacancy> storage;

    public DBManager() {

    }

    public Vacancy add(Vacancy vacancy){
        return vacancy;
    }

    public long getFirstLoad(){
        return  0;
    }

}
