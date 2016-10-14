package ru.szhernovoy.storage;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 14.10.2016.
 */
public class UserStorageTest {
    @Test
    public void whenAddUserToStorageThatContainsIt() throws Exception {
        User userFirst = new User("Sergey");
        UserStorage myStorage = new UserStorage();
        boolean result = myStorage.add(userFirst);
        Assert.assertThat(result,is(true));

    }

    @Test
    public void whenUpdateUserInStorageByIdThenUpdateInStorage() throws Exception {
        User userFirst = new User("Sergey");
        User userSecond = new User("Julia");
        String key = userFirst.getId();
        UserStorage myStorage = new UserStorage();
        myStorage.add(userFirst);
        userSecond.setId(key);
        myStorage.update(userSecond);
        Assert.assertThat("Julia",is(myStorage.read(key).getName()));
    }

    @Test
    public void whenDeleteInStorageThatDeleteFromArray() throws Exception {
        User userFirst = new User("Sergey");
        UserStorage myStorage = new UserStorage();
        myStorage.add(userFirst);
        boolean result = myStorage.delete(userFirst.getId());
        Assert.assertThat(result,is(true));
    }

    @Test
    public void whenReadUserThatShouldGetIt() throws Exception {
        User userFirst = new User("Sergey");
        User userSecond = new User("Julia");
        String key = userFirst.getId();
        UserStorage myStorage = new UserStorage();
        myStorage.add(userFirst);
        userSecond.setId(key);
        myStorage.update(userSecond);
        Assert.assertThat("Julia",is(myStorage.read(key).getName()));
    }

    @Test
    public void whenTransferAmountFromAnyUserThatMostDoIt() throws Exception {
        User userFirst = new User("Sergey");
        User userSecond = new User("Julia");

        UserStorage myStorage = new UserStorage();
        myStorage.add(userFirst);
        myStorage.add(userSecond);
        userFirst.setAmount(100);
        userSecond.setAmount(200);
        myStorage.transfer(50,userFirst,userSecond);
        int amount = userFirst.getAmount();
        Assert.assertThat(amount,is(50));

    }

}