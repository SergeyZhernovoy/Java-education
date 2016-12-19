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
    private String password;
    private Role role;
    private String id;
    private String country;
    private String city;

    public User(String email, String name, String login, long createDate, String password, Role role, String id, String country, String city) {
        this.email = email;
        this.name = name;
        this.login = login;
        this.createDate = createDate;
        this.password = password;
        this.role = role;
        this.id = id;
        this.country = country;
        this.city = city;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public Date getCreateDate() {
        return new Date(this.createDate);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return  String.format("User - name:%s; login:%s; email:%s; create:%s",name,login,email,new Date(createDate).toString());

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
