package com.puntoventa.api.service;

import com.puntoventa.api.entity.User;
import com.puntoventa.api.repository.UserRepository;
import com.puntoventa.api.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository ur;

    Utils utils = new Utils();

    @Override
    public List<User> findAllUsers() {
        List<User> activeUser = new ArrayList<>();
        activeUser = ur.findAllUserByActiveTrueAndDeleteDateNull();
        return activeUser;
    }

    @Override
    public User createUser(User newUser) {
        newUser.setPassword(utils.generatePassword(newUser.getPassword()));
        newUser.setUserID(utils.generateUUID(newUser.getUserName(), newUser.getUserLastname()));
        newUser.setCreateDate(new Date());
        System.out.println("usario que se guardara: "+ newUser);
        return ur.saveAndFlush(newUser);
    }

    @Override
    public User findByUID(String uuid) {
        return ur.findByuserID(uuid);
    }

    @Override
    public User updateUserPassword(String uuid,User user) {
        System.out.println(user);
        User usertoUpdate =  ur.findByuserID(uuid);
        if(usertoUpdate!=null){
            usertoUpdate.setPassword(utils.generatePassword(user.getPassword()));
            usertoUpdate.setUpdateDate(new Date());
            ur.saveAndFlush(usertoUpdate);
            System.out.println("Usuario Actualizado correctamente");
        }
        return usertoUpdate;
    }
    @Override
    public User updateUserRole(String uuid,String newRole) {
        User usertoUpdate =   ur.findByuserID(uuid);

        usertoUpdate.setRole(newRole);
        usertoUpdate.setUpdateDate(new Date());
        System.out.println(usertoUpdate);
        return ur.saveAndFlush(usertoUpdate);
    }
}
