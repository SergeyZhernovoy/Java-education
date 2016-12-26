package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.interfaces.RoleDAO;
import ru.szhernovoy.dao.value.Role;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public class RoleDAOImplementation implements RoleDAO {
    private final static Logger log = LoggerFactory.getLogger(RoleDAOImplementation.class);

    @Override
    public int createRole() {
        return 0;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public Role findRole(int id) {
        return null;
    }

    @Override
    public boolean updateRole() {
        return false;
    }

    @Override
    public boolean deleteRole() {
        return false;
    }
}
