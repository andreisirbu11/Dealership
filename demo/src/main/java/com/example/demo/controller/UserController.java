package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/findAll")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/findBy/ID/{userID}")
    public User findUserByID(@PathVariable Long userID) { return userService.findByID(userID); }

    @PutMapping("/users/updateBy/ID/{userID}")
    public User updateUserByID(@PathVariable Long userID, @RequestBody User userRequest) {
        return userService.updateUserByID(userID, userRequest);
    }

    @DeleteMapping("users/deleteAll")
    public String deleteAllUsers() { return userService.deleteAll(); }

    @DeleteMapping("users/deleteBy/ID/{userID}")
    public String deleteUserByID(@PathVariable Long userID) { return userService.deleteByID(userID);}

    @PostMapping("/users/add")
    public String insertUser(@RequestBody User newUser) { return userService.insertUser(newUser); }

}
