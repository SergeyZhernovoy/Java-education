package ru.szhernovy.jobvacancy.view;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovy.jobvacancy.model.Vacancy;

import java.util.concurrent.ConcurrentSkipListSet;


public class Executor {



    private static Logger log = LoggerFactory.getLogger(Executor.class);

    public Executor(){
        String path = this.getClass().getClassLoader().getResource("vacancy.properties").getPath();
    }


}
