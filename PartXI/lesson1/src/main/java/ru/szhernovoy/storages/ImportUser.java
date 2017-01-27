package ru.szhernovoy.storages;/**
 * Created by szhernovoy on 27.01.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ImportUser {

    private final Crud storage;

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportUser.class);

    @Autowired
    public   ImportUser(Crud storage){
        this.storage = storage;
    }

    public void add(User user){
        this.storage.add(user);
    }

    public void getUsers(){
        for(User user : this.storage.get()){
            System.out.println(user);
        }
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Crud storage = context.getBean(JdbcDAO.class);
        ImportUser importUser = new ImportUser(storage);
        User user = new User();
        user.setName("Sergey");
        importUser.add(user);
        user = new User();
        user.setName("Petr");
        importUser.add(user);
        importUser.getUsers();
    }



}
