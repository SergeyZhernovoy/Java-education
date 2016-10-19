package ru.szhernovoy.storage;

import java.util.Random;

/**
 * Created by szhernovoy on 14.10.2016.
 */
public class User {

    private String name;
    private String id;
     private final Random RN = new Random();
    private int amount =0;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public User(String name) {
        this.name = name;
        this.amount = 0;
        this.id = this.generateId();
    }

    private String generateId() {

        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;


        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return id != null ? id.equals(user.id) : user.id == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public synchronized void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
