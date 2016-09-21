package ru.szhernovoy.map;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by szhernovoy on 21.09.2016.
 */
public class PhoneBookTest {
    @Test(timeout = 100)
    public void whenInsertPairsInBookThenTheyAddInAnyBasket() throws Exception {
        PhoneBook<String,String> tinyBook = new PhoneBook<>();
        boolean result = tinyBook.insert("89053758569","Julia");
        tinyBook.insert("89053758569","Julia");
        tinyBook.insert("89053758569","Julia");
        tinyBook.insert("89053758569","Julia");
        Assert.assertThat(true, is(result));

    }


    @Test
    public void resize() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getNode() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void removeNode() throws Exception {

    }

    @Test
    public void whenWeWantHashCodeFuncItShouldHashFromAllFieldsObjects() throws Exception {

    }

    @Test
    public void equals() throws Exception {

    }

}