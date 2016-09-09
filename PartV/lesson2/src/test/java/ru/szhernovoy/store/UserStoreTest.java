package ru.szhernovoy.store;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sergey on 08.09.2016.
 */
public class UserStoreTest {

    @Test
    public void whenAddUserInUserStorageThatArrayShouldIncrease(){
        User andrew = new User();
        User sergey = new User();
        UserStore userStore = new UserStore(5);
        userStore.add(andrew);
        userStore.add(sergey);
        Assert.assertThat(andrew,is(userStore.get(andrew.getId())));
    }

    @Test
    public void whenUpdateUserInUserStorageThatUserShouldChange(){
        User andrew = new User();
        User sergey = new User();
        UserStore userStore = new UserStore(1);
        userStore.add(andrew);
        sergey.setId(andrew.getId());
        userStore.update(sergey);
        Assert.assertThat(sergey,is(userStore.get(andrew.getId())));
    }

    @Test
    public void whenDeleteUserInUserStorageThatUserShouldDelete() {
        User andrew = new User();
        User sergey = new User();
        UserStore userStore = new UserStore(2);
        userStore.add(andrew);
        userStore.add(sergey);
        Assert.assertThat(userStore.delete(sergey.getId()),is(true));
    }



}