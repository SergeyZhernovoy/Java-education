package ru.szhernovy.jobvacancy.controller;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovy.jobvacancy.model.Vacancy;

import java.util.Set;


public class DBManager {
    private static Logger log = LoggerFactory.getLogger(DBManager.class);
    private final Set<Vacancy> storage;

    public DBManager(Set<Vacancy> storage) {
        this.storage = storage;
    }

    public Vacancy add(Vacancy vacancy){
        return vacancy;
    }




}
