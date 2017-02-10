package ru.szhernovoy.jpa.carstore.persistance;

import org.springframework.data.repository.CrudRepository;
import ru.szhernovoy.jpa.carstore.domain.Model;

import java.net.Inet4Address;
import java.util.List;

/**
 * Created by Admin on 05.02.2017.
 */
public interface ModelCrud extends CrudRepository<Model,Integer> {
    List<Model> findByAll();
    Model findById(int id);
}
