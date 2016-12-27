package ru.szhernovoy.repository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import ru.szhernovoy.dao.factory.DAOFactory;
import ru.szhernovoy.dao.interfaces.*;
import ru.szhernovoy.dao.value.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by admin on 27.12.2016.
 */
public class UserRepository {
    private final static Logger log = LoggerFactory.getLogger(UserRepository.class);
    private DAOFactory factory = DAOFactory.getFactory();

    private AddressDAO addressDAO = factory.getAddressDAO();
    private MusicTypeDAO musicTypeDAO = factory.getMusicDAO();
    private RoleDAO roleDAO = factory.getRoleDAO();
    private UserDAO userDAO = factory.getUserDAO();

    public Collection<UserReferences> getUserReferences(int id){
        Collection<UserReferences> storage = new CopyOnWriteArrayList<>();
        UserReferences userReferences = new UserReferences(addressDAO,roleDAO,userDAO,musicTypeDAO);
        if(userReferences.fillData(id)){
            storage.add(userReferences);
        }
        return storage;
    }

    public Collection<UserReferences> getUserReferences(){
        Collection<UserReferences> storage = new CopyOnWriteArrayList<>();
        Iterator<User> iter = userDAO.getAll().iterator();
        while(iter.hasNext()){
            UserReferences userReferences = new UserReferences(addressDAO,roleDAO,userDAO,musicTypeDAO);
            if(userReferences.fillData(iter.next().getId())){
                storage.add(userReferences);
            }
        }
        return storage;
    }

    public int createUserReferences(String userName, String music,String addressName,String roleName){

            User user = new User();
            user.setName(userName);
            MusicType musicType = musicTypeDAO.findMusicTypeByName(music);
            if( musicType!=null){
                user.setMusicTypeId(musicTypeDAO.createMusicType(music));
            } else{
                user.setMusicTypeId(musicType.getId());
            }

            Role role = roleDAO.findRoleByName(roleName);
            if( role!=null){
                user.setRoleId(roleDAO.createRole(roleName));
            } else{
                user.setRoleId(role.getId());
            }

            Address address = addressDAO.findAddressByName(addressName);
            if( address!=null){
                user.setAdressId(addressDAO.createAddress(addressName));
            } else{
                user.setRoleId(address.getId());
            }
            return this.userDAO.createUser(user);

    }

    public Collection<UserReferences> getUserReferences(Address address){
        Collection<UserReferences> storage = new CopyOnWriteArrayList<>();
        Iterator<User> iter = userDAO.getAll().iterator();
        while(iter.hasNext()){
            UserReferences userReferences = new UserReferences(addressDAO,roleDAO,userDAO,musicTypeDAO);
            if(userReferences.fillData(address)){
                storage.add(userReferences);
            }
        }
        return storage;
    }

    public Collection<UserReferences> getUserReferences(Role role){
        Collection<UserReferences> storage = new CopyOnWriteArrayList<>();
        Iterator<User> iter = roleDAO.getAll().iterator();
        while(iter.hasNext()){
            UserReferences userReferences = new UserReferences(addressDAO,roleDAO,userDAO,musicTypeDAO);
            if(userReferences.fillData(role)){
                storage.add(userReferences);
            }
        }
        return storage;
    }

    public Collection<UserReferences> getUserReferences(MusicType musicType){
        Collection<UserReferences> storage = new CopyOnWriteArrayList<>();
        Iterator<User> iter = userDAO.getAll().iterator();
        while(iter.hasNext()){
            UserReferences userReferences = new UserReferences(addressDAO,roleDAO,userDAO,musicTypeDAO);
            if(userReferences.fillData(musicType)){
                storage.add(userReferences);
            }
        }
        return storage;
    }

    private static class UserReferences{
        private User user;
        private Role role;
        private Address address;
        private MusicType musicType;
        private AddressDAO serviceAddress;
        private RoleDAO serviceRole;
        private UserDAO serviceUser;
        private MusicTypeDAO serviceMusicType;

        public UserReferences(AddressDAO serviceAddress, RoleDAO serviceRole, UserDAO serviceUser, MusicTypeDAO serviceMusicType) {
            this.serviceAddress = serviceAddress;
            this.serviceRole = serviceRole;
            this.serviceUser = serviceUser;
            this.serviceMusicType = serviceMusicType;
        }

        public User getUser() {
            return user;
        }

        public Role getRole() {
            return role;
        }

        public Address getAddress() {
            return address;
        }

        public MusicType getMusicType() {
            return musicType;
        }

        public boolean fillData(int id){
            boolean result = false;
            this.user = this.serviceUser.findUser(id);
            if(this.user != null){
                result = true;
            }

            if(result){
                this.role = this.serviceRole.findRole(user.getRoleId());
                this.address = this.serviceAddress.findAddress(user.getAdressId());
                this.musicType = this.serviceMusicType.findMusicType(user.getMusicTypeId());
            }
            return  result;
        }

        public boolean fillData(Address address){
            boolean result = false;
            this.user = this.serviceUser.findUser(id);
            if(this.user != null){
                result = true;
            }

            if(result){
                this.role = this.serviceRole.findRole(user.getRoleId());
                this.address = this.serviceAddress.findAddress(user.getAdressId());
                this.musicType = this.serviceMusicType.findMusicType(user.getMusicTypeId());
            }
            return  result;
        }

        public boolean fillData(Role role){
            boolean result = false;
            this.user = this.serviceUser.findUser(id);
            if(this.user != null){
                result = true;
            }

            if(result){
                this.role = this.serviceRole.findRole(user.getRoleId());
                this.address = this.serviceAddress.findAddress(user.getAdressId());
                this.musicType = this.serviceMusicType.findMusicType(user.getMusicTypeId());
            }
            return  result;
        }

        public boolean fillData(MusicType musicType){
            boolean result = false;
            this.user = this.serviceUser.findUser(id);
            if(this.user != null){
                result = true;
            }

            if(result){
                this.role = this.serviceRole.findRole(user.getRoleId());
                this.address = this.serviceAddress.findAddress(user.getAdressId());
                this.musicType = this.serviceMusicType.findMusicType(user.getMusicTypeId());
            }
            return  result;
        }


    }


}
