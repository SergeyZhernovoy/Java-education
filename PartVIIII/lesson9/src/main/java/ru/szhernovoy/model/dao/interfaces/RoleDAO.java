package ru.szhernovoy.model.dao.interfaces;

import ru.szhernovoy.model.Role;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface RoleDAO {
    public int createRole();
    public Collection getAll();
    public Role findRole(int id);
    public boolean updateRole();
    public boolean deleteRole();
}
