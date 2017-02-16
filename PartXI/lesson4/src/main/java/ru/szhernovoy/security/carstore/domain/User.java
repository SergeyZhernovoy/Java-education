package ru.szhernovoy.security.carstore.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by admin on 17.02.2017.
 */
@Entity(name = "body")
public class User {
    private String userName;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
