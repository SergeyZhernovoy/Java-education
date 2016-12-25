package ru.szhernovoy.model.dao.interfaces;

import ru.szhernovoy.model.MusicType;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface MusicTypeDAO {
    public int createMusicType();
    public Collection getAll();
    public MusicType findMusicType(int id);
    public boolean updateMusicType();
    public boolean deleteMusicType();
}
