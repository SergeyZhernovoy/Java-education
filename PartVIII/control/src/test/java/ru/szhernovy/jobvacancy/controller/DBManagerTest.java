package ru.szhernovy.jobvacancy.controller;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovy.jobvacancy.model.Vacancy;

import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 19.11.2016.
 */
public class DBManagerTest {


    @Test
    public void whenAddVacancyWeShouldGetThem() throws Exception {
        String file = getClass().getClassLoader().getResource("vacancy.properties").getPath();
        DBManager dbManager = new DBManager(file);
        dbManager.connect(file);
        dbManager.add(new Vacancy("java developer","Petja","www.lll.ru","www.fg.ru",1,2,0));



        dbManager.close();



      //  Properties properties = dbManager.getProperties(file);
      //  String control = properties.getProperty("url");
     //   Assert.assertThat(control,is("jdbc:postgresql://localhost:5432/vacancy"));
    }

    @Test
    public void printVacancy() throws Exception {

    }

    @Test
    public void getLastLoad() throws Exception {

    }

    @Test
    public void setTimeLoad() throws Exception {

    }

    @Test
    public void weMustGetPropertyAndWeCanLoadIt() throws Exception {
        String file = getClass().getClassLoader().getResource("vacancy.properties").getPath();
        DBManager dbManager = new DBManager(file);
        Properties properties = dbManager.getProperties(file);
        String control = properties.getProperty("url");
        Assert.assertThat(control,is("jdbc:postgresql://localhost:5432/vacancy"));
    }



}