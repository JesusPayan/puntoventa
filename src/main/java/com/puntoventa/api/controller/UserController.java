package com.puntoventa.api.controller;

import com.puntoventa.api.entity.User;
import com.puntoventa.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/users")
    List<User> showActiveUsers(){
        System.out.println("Entro al controller");
        System.out.println(userService.findAllUsers());
        return userService.findAllUsers();
    }
    @PostMapping("/user")
    User savenewUser(@RequestBody User newUser){
        System.out.println("Usuario que llego al controller:" + newUser);
        return userService.createUser(newUser);
    }
    @GetMapping("/{uuid}")
    User getUserByUUID(@RequestParam String uuid){
        User userFound;
        System.out.println("ID que llego "+ uuid);
        return userService.findByUID(uuid);
    }
    @PutMapping("/{uuid}")
    User updatePass(@RequestParam String uuid,@RequestBody User user){
        System.out.println("lo que llego  "+ uuid);
        System.out.println(userService.updateUserPassword(uuid,user));
        return userService.updateUserPassword(uuid,user);//userService.updateUserPassword(uuid,newPass);
    }
}

