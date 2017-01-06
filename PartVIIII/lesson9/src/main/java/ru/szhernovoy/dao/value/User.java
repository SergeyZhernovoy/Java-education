package ru.szhernovoy.dao.value;


import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by admin on 27.11.2016.
 */
public class User implements Serializable{

    private String name;
    private int roleId;
    private int id;
    private int adressId;
    private Set<Integer> musicTypeId = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public Set<Integer> getMusicTypeId() {
        return musicTypeId;
    }

    public void setMusicTypeId(int musicTypeId) {
        this.musicTypeId.add(musicTypeId);
    }

    public void setMusicTypeId(Set<Integer> musicType) {
        this.musicTypeId.addAll(musicType);
    }

}
