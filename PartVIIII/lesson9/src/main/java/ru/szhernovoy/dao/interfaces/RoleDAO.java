package ru.szhernovoy.dao.interfaces;

import ru.szhernovoy.dao.value.Role;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface RoleDAO {
     int createRole(String name);
     Collection getAll();
     Role findRole(int id);
     boolean updateRole(int id, String name);
     boolean deleteRole(int id);
     Role findRoleByName(String name);

}
