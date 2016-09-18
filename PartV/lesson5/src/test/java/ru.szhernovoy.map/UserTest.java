package ru.szhernovoy.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Sergey on 17.09.2016.
 */
public class UserTest {
    @Test
    public void analyzeWhatDoWithoutOverrideEqualsAndHash(){
        UserWithoutOverride first = new UserWithoutOverride("Sergey", 2, new GregorianCalendar(1978,2,28));
        UserWithoutOverride second = new UserWithoutOverride("Sergey", 2, new GregorianCalendar(1978,2,28));
        Set<UserWithoutOverride> map = new HashSet<>();
        map.add(first);
        map.add(second);
        System.out.println(map);
    }

    @Test
    public void analyzeWhatDoWithoutOverrideEquals(){
        UserWithoutOverrideEquals first = new UserWithoutOverrideEquals("Sergey", 2, new GregorianCalendar(1978,2,28));
        UserWithoutOverrideEquals second = new UserWithoutOverrideEquals("Sergey", 2, new GregorianCalendar(1978,2,28));
        Set<UserWithoutOverrideEquals> map = new HashSet<>();
        map.add(first);
        map.add(second);
        System.out.println(map);
    }

    @Test
    public void analyzeWhatDoWithoutOverrideHash(){
        UserWithoutOverrideHashCode first = new UserWithoutOverrideHashCode("Sergey", 2, new GregorianCalendar(1978,2,28));
        UserWithoutOverrideHashCode second = new UserWithoutOverrideHashCode("Sergey", 2, new GregorianCalendar(1978,2,28));
        Set<UserWithoutOverrideHashCode> map = new HashSet<>();
        map.add(first);
        map.add(second);
        System.out.println(map);
    }

    @Test
    public void analyzeWhatDoAllCover(){
        UserAllCover first = new UserAllCover("Sergey", 2, new GregorianCalendar(1978,2,28));
        UserAllCover second = new UserAllCover("Sergey", 2, new GregorianCalendar(1978,2,28));
        Set<UserAllCover> map = new HashSet<>();
        map.add(first);
        map.add(second);
        System.out.println(map);
    }



}