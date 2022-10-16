package com.example.durc.Durc.controller;

import com.example.durc.Durc.model.User;
import com.example.durc.Durc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping
    public User updateUser(User user){

        return userService.update(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id){

        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAllUserById(){

        return (List<User>)userService.findAllUser();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){

        userService.deleteById(id);
    }

}
