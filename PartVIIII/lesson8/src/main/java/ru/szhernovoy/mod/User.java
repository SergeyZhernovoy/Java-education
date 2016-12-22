package ru.szhernovoy.mod;


import java.util.Date;

/**
 * Created by admin on 27.11.2016.
 */
public class User {
    private final String email;
    private final String login;
    private long createDate;
    private String password;
    private int country_id;
    private int city_id;
    private String nameCountry;
    private String nameCity;

    public User(String email, String login, long createDate, String password) {
        this.email = email;
        this.login = login;
        this.createDate = createDate;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getEmail() {
        return email;
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

}
