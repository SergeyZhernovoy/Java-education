package ru.szhernovoy.repository;

import ru.szhernovoy.dao.value.Address;
import ru.szhernovoy.dao.value.MusicType;
import ru.szhernovoy.repository.value.UserRepository;

import java.util.Collection;

/**
 * Created by szhernovoy on 26.12.2016.
 */

public interface UserRepositoryInterface {


        public void getModelWithRefById(int id);
        public void createModelWithRef(User user, Role role, MusicType musicType, Address address);
        public Collection<> getAllModelByRef(T t);

}
