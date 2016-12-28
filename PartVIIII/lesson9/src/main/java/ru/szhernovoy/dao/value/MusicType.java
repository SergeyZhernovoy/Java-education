package ru.szhernovoy.dao.value;


import java.io.Serializable;

/**
 * Created by dort on 25.12.16.
 */
public class MusicType implements Serializable{

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicType musicType = (MusicType) o;

        if (id != musicType.id) return false;
        return name != null ? name.equals(musicType.name) : musicType.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
