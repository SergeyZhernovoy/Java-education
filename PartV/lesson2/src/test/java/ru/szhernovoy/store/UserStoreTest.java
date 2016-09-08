package ru.szhernovoy.store;

import org.junit.Assert;
import org.junit.Test;

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
        String result = andrew.getId();
        Assert.assertThat(result,is(userStore.get(0).getId()));
    }

    @Test
    public void whenUpdateUserInUserStorageThatUserShouldChange(){
        User andrew = new User();
        User sergey = new User();
        UserStore userStore = new UserStore(1);
        userStore.add(andrew);
        userStore.update(sergey,0);
        String result = sergey.getId();
        Assert.assertThat(result,is(userStore.get(0).getId()));
    }

    @Test
    public void whenDeleteUserInUserStorageThatUserShouldDelete(){
        User andrew = new User();
        User sergey = new User();
        UserStore userStore = new UserStore(2);
        userStore.add(andrew);
        userStore.add(sergey);
        userStore.delete(0);
        String result = sergey.getId();
        Assert.assertThat(result,is(userStore.get(0).getId()));
    }



}