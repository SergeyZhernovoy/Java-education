package ru.szhernovoy.storages;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 27.01.2017.
 */
public class ImportUserTest {

    @Test
    public void whenAddUserInMemoryStorageShouldAssignId(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-test.xml");
        ImportUser importUser = new ImportUser(context.getBean(MemoryDAO.class));
        User user = new User();
        user.setName("test");
        importUser.add(user);
        assertThat(1,is(user.getId()));
    }
}