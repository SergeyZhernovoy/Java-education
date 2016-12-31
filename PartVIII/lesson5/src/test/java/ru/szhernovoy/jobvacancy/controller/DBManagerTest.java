package ru.szhernovoy.jobvacancy.controller;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.jobvacancy.model.Vacancy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.core.Is.is;

/**
 * Created by szhernovoy on 19.11.2016.
 */
public class DBManagerTest {

    @Test
    public void whenAddVacancyWeShouldGetThem() throws Exception {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(this.getClass().getClassLoader().getResource("vacancy.properties").getPath())) {
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        DBManager dbManager = new DBManager(properties);
        boolean result = dbManager.add(new Vacancy("java developer","Petja","www.lll.ru","www.f8.ru",3,2,0));
        boolean result1 = dbManager.add(new Vacancy("java developer","Petja","www.l23l.ru","www.fg.ru",2,1,0));
        dbManager.close();
        Assert.assertThat(result&&result1,is(true));
    }

    @Test
    public void weMustGetPropertyAndWeCanLoadIt() throws Exception {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(this.getClass().getClassLoader().getResource("vacancy.properties").getPath())) {
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        DBManager dbManager = new DBManager(properties);
        String control = properties.getProperty("url");
        Assert.assertThat(control,is("jdbc:postgresql://localhost:5432/vacancy"));
    }

    @Test
    public void weAddTimeShouldGetLast() throws Exception {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(this.getClass().getClassLoader().getResource("vacancy.properties").getPath())) {
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        DBManager dbManager = new DBManager(properties);
        dbManager.setTimeLoad(System.currentTimeMillis());
        dbManager.setTimeLoad(System.currentTimeMillis());
        long result = System.currentTimeMillis();
        dbManager.setTimeLoad(result);
        Assert.assertThat(result,is(dbManager.getLastLoad()));
        dbManager.close();
    }


}