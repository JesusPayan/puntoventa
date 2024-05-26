package com.puntoventa.api.service;

import com.puntoventa.api.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAllUsers();
    public User createUser(User newUser);
    public User findByUID(String uuid);
    public User updateUserPassword(String uuid,User newPass);
    public User updateUserRole(String uuid,String newRole);
}
