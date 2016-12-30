package ru.szhernovoy.dao.interfaces;

import ru.szhernovoy.dao.value.MusicType;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface MusicTypeDAO {
     int createMusicType(String name);
     Collection getAll();
     MusicType findMusicType(int id);
     boolean updateMusicType(int id, String name);
     boolean deleteMusicType(int id);
     MusicType findMusicTypeByName(String name);

}
