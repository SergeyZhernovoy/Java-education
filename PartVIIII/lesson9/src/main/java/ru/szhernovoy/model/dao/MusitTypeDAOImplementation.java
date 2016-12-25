package ru.szhernovoy.model.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.model.MusicType;
import ru.szhernovoy.model.dao.interfaces.MusicTypeDAO;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public class MusitTypeDAOImplementation implements MusicTypeDAO {
    private final static Logger log = LoggerFactory.getLogger(MusitTypeDAOImplementation.class);

    @Override
    public int createMusicType() {
        return 0;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public MusicType findMusicType(int id) {
        return null;
    }

    @Override
    public boolean updateMusicType() {
        return false;
    }

    @Override
    public boolean deleteMusicType() {
        return false;
    }
}
