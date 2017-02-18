package ru.szhernovoy.security.carstore.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.szhernovoy.security.carstore.domain.Role;

/**
 * Created by szhernovoy on 18.02.2017.
 */
public interface RoleCrud extends CrudRepository<Role,Integer> {
}
