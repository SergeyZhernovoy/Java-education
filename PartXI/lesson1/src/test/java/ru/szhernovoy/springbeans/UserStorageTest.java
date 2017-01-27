package ru.szhernovoy.springbeans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 27.01.2017.
 */
public class UserStorageTest {
    @Test
    public void whenAddUserInStorageShouldSaveIt() throws Exception {

        User user = new User();
        MemoryStorageImpl memoryStorage = new MemoryStorageImpl();
        UserStorage userStorage = new UserStorage(memoryStorage);
        userStorage.add(user);
    }

    @Test
    public void whenLoadContextShouldGetBeans(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Storage storage = context.getBean(MemoryStorageImpl.class);
        assertNotNull(storage);
    }

    @Test
    public void whenLoadContextWithDependenciesShouldGetBeans(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User());
        assertNotNull(storage);
    }

}