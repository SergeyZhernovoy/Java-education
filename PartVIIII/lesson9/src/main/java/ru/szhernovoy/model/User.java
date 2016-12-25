package ru.szhernovoy.model;


import java.io.Serializable;

/**
 * Created by admin on 27.11.2016.
 */
public class User implements Serializable{

    private String name;
    private Role role;
    private int id;
    private Address adress;
    private MusicType musicType;

}
