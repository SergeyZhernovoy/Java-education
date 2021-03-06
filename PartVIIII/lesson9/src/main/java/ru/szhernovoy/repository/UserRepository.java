package ru.szhernovoy.repository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import ru.szhernovoy.dao.factory.DAOFactory;
import ru.szhernovoy.dao.interfaces.*;
import ru.szhernovoy.dao.value.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
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
        Collection<User> users  = this.userDAO.getAll();
        for(User user : users){
            UserReferences userReferences = new UserReferences(addressDAO,roleDAO,userDAO,musicTypeDAO);
            if(userReferences.fillData(user.getId())){
                storage.add(userReferences);
            }
        }
        return storage;
    }

    public int createUserReferences(String userName, String addressName,String roleName,String ...music){

            User user = new User();
            user.setName(userName);

            for(String typeMusic : music){
                MusicType musicType = musicTypeDAO.findMusicTypeByName(typeMusic);
                if( musicType!=null){
                    user.setMusicTypeId(musicType.getId());
                } else{
                    user.setMusicTypeId(musicTypeDAO.createMusicType(typeMusic));
                }
            }

            Role role = roleDAO.findRoleByName(roleName);
            if( role!=null){
                user.setRoleId(role.getId());
            } else{
                user.setRoleId(roleDAO.createRole(roleName));
            }


            Address address = addressDAO.findAddressByName(addressName);
            if( address!=null){
                user.setAdressId(address.getId());
            } else{
                user.setRoleId(addressDAO.createAddress(addressName));
            }

            return this.userDAO.createUser(user);

    }

    public Collection<UserReferences> getUserReferences(Address address){

        Collection<UserReferences> storage = new LinkedList<>();
        Collection<Address> addresses = this.addressDAO.getAll();
        Address right = null;
        for(Address find : addresses){
            if(find.equals(address)){
                right = find;
            }
        }
        if(right == null){
            right = this.addressDAO.findAddressByName(address.getName());
        }

        Collection<User> users = this.userDAO.getAll();
        for (User user : users){
            if(user.getRoleId() == right.getId()){
                UserReferences userReferences = new UserReferences(this.addressDAO,this.roleDAO ,this.userDAO,this.musicTypeDAO);
                userReferences.fillData(user.getId());
                storage.add(userReferences);
            }
         }
        return storage;
    }

    public Collection<UserReferences> getUserReferences(Role role){

        Collection<UserReferences> storage = new LinkedList<>();
        Collection<Role> roles = this.roleDAO.getAll();
        Role right = null;
        for(Role find : roles){
            if(find.equals(role)){
                right = find;
            }
        }
        if(right == null){
            right = this.roleDAO.findRoleByName(role.getName());
        }

        Collection<User> users = this.userDAO.getAll();
        for (User user : users){
            if(user.getRoleId() == right.getId()){
                UserReferences userReferences = new UserReferences(this.addressDAO,this.roleDAO ,this.userDAO,this.musicTypeDAO);
                userReferences.fillData(user.getId());
                storage.add(userReferences);
            }
        }
        return storage;
    }

    public Collection<UserReferences> getUserReferences(MusicType musicType){
        Collection<UserReferences> storage = new LinkedList<>();
        Collection<MusicType> musicTypes  = this.musicTypeDAO.getAll();
        MusicType right = null;
        for(MusicType find : musicTypes){
            if(find.equals(musicType)){
                right = find;
            }
        }
        if(right == null){
            right = this.musicTypeDAO.findMusicTypeByName(musicType.getName());
        }

        Collection<User> users = this.userDAO.getAll();
        for (User user : users){

            Set<Integer> types = user.getMusicTypeId();
            if(types.contains(right.getId())){
                UserReferences userReferences = new UserReferences(this.addressDAO,this.roleDAO ,this.userDAO,this.musicTypeDAO);
                userReferences.fillData(user.getId());
                storage.add(userReferences);
            }
        }
        return storage;
    }

    public static class UserReferences{
        private User user;
        private Role role;
        private Address address;
        private Set<Integer> musicType;
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

        public Set<Integer> getMusicType() {
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

                this.musicType = this.serviceMusicType.findMusicTypeById(user.getId());
            }
            return  result;
        }

    }


}
