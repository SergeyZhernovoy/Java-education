package ru.szhernovoy.model;

import java.util.List;

/**
 * Created by dort on 17.12.16.
 */
public interface CrudRoleInterface<T extends Role>  {

   boolean addRole(Role role);

   List<T> getRoles();

   void deleteRole(Role role);

   void updateRole(Role role);
}
