package ru.szhernovoy.dao.interfaces;

import ru.szhernovoy.dao.value.Role;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface RoleDAO {
    public int createRole(String name);
    public Collection getAll();
    public Role findRole(int id);
    public boolean updateRole(int id, String name);
    public boolean deleteRole(int id);
    public Role findRoleByName(String name);
}
