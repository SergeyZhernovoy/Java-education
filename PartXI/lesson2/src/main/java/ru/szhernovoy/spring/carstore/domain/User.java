package ru.szhernovoy.spring.carstore.domain;


import java.util.Set;

/**
 * Created by admin on 09.01.2017.
 */
public class User {

    /**
     * Created by admin on 10.01.2017.
     */
    private String name;
    /**
     * Created by admin on 10.01.2017.
     */
    private String password;
    /**
     * Created by admin on 10.01.2017.
     */
    private int id;
    /**
     * Created by admin on 10.01.2017.
     */
    private Set<Order> orderSet;

    /**
     * Created by admin on 10.01.2017.
     */
    public User() {
    }

    /**
     * Created by admin on 10.01.2017.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param password .
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param id .
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Created by admin on 10.01.2017.
     * @return Set<Order>
     */
    public Set<Order> getOrderSet() {
        return orderSet;
    }

    /**
     * Created by admin on 10.01.2017.
     * @param orderSet .
     */
    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }
}
