package ru.szhernovoy.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

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
    public void whenWeSeeAllValueWeCallIterator() throws Exception {
        PhoneBook<String,String> tinyBook = new PhoneBook<>();
        boolean result = tinyBook.insert("89053758569","Julia");
        tinyBook.insert("89053758569","Julia");
        tinyBook.insert("89053758565","Sergey");
        tinyBook.insert("89053758566","Petr");
        Iterator<String> iter = tinyBook.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    @Test
    public void whenWeWantHowOwnerNumberPhoneWeFindByNumber() throws Exception {
        PhoneBook<String,String> tinyBook = new PhoneBook<>();
        tinyBook.insert("89053758569","Julia");
        tinyBook.insert("89053758565","Sergey");
        tinyBook.insert("89053758566","Petr");
        String name = tinyBook.get("89053758565");
        Assert.assertThat(name,is("Sergey"));
    }

    @Test
    public void whenWeDeleteSizeOfPhoneBookReduce() throws Exception {
        PhoneBook<String,String> tinyBook = new PhoneBook<>();
        tinyBook.insert("89053758569","Julia");
        tinyBook.insert("89053758565","Sergey");
        tinyBook.insert("89053758566","Petr");
        tinyBook.delete("89053758566");
        int count = 0;
        Iterator<String> iter = tinyBook.iterator();
        while(iter.hasNext()){
             count++;
        }
        Assert.assertThat(2,is(count));

    }

}