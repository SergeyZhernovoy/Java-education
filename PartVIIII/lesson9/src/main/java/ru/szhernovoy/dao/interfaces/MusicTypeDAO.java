package ru.szhernovoy.dao.interfaces;

import ru.szhernovoy.dao.value.MusicType;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface MusicTypeDAO {
    public int createMusicType(String name);
    public Collection getAll();
    public MusicType findMusicType(int id);
    public boolean updateMusicType(int id, String name);
    public boolean deleteMusicType(int id);
    public MusicType findMusicTypeByName(String name);
}
