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
        boolean result = dbManager.add(new Vacancy("java developer","Petja","www.lll.ru","www.f8.ru",3,2,0));
        boolean result1 = dbManager.add(new Vacancy("java developer","Petja","www.l23l.ru","www.fg.ru",2,1,0));
        dbManager.close();
        Assert.assertThat(result&&result1,is(true));
    }

    @Test
    public void weMustGetPropertyAndWeCanLoadIt() throws Exception {
        String file = getClass().getClassLoader().getResource("vacancy.properties").getPath();
        DBManager dbManager = new DBManager(file);
        Properties properties = dbManager.getProperties(file);
        String control = properties.getProperty("url");
        Assert.assertThat(control,is("jdbc:postgresql://localhost:5432/vacancy"));
    }

    @Test
    public void weAddTimeShouldGetLast() throws Exception {
        String file = getClass().getClassLoader().getResource("vacancy.properties").getPath();
        DBManager dbManager = new DBManager(file);
        dbManager.connect(file);
        dbManager.setTimeLoad(System.currentTimeMillis());
        dbManager.setTimeLoad(System.currentTimeMillis());
        long result = System.currentTimeMillis();
        dbManager.setTimeLoad(result);
        Assert.assertThat(result,is(dbManager.getLastLoad()));
        dbManager.close();
    }


}