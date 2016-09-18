package ru.szhernovoy.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by admin on 18.09.2016.
 */
public class UserWithoutOverrideEqualsTest {
    @Test
    public void analyzeWhatDoWithoutOverrideEquals(){
        UserWithoutOverrideEquals first = new UserWithoutOverrideEquals("Sergey", 2, new GregorianCalendar(1978,2,28));
        UserWithoutOverrideEquals second = new UserWithoutOverrideEquals("Sergey", 2, new GregorianCalendar(1978,2,28));
        Set<UserWithoutOverrideEquals> map = new HashSet<>();
        map.add(first);
        map.add(second);
        System.out.println(map);
    }
}