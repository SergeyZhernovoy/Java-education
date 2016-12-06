package ru.szhernovoy.model;


import java.util.Date;

/**
 * Created by admin on 27.11.2016.
 */
public class User {
    private final String email;
    private final String name;
    private final String login;
    private long createDate;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public long getCreateDate() {
        return createDate;
    }

    public User(final String email, final String name, final String login, final long createDate) {
        this.email = email;
        this.name = name;
        this.login = login;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return  String.format("User - name:%s; login:%s; email:%s; create:%s",name,login,email,new Date(createDate).toString());

    }
}
