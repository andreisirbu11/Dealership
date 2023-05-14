package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/get/all")
    public List<User> getAllUsers() { return userService.getAll(); }
    @GetMapping("/users/getby/id/{userID}")
    public User getUserById(@PathVariable Long userID) { return userService.getUserById(userID); }
    @PutMapping("/users/updateby/id/{userID}")
    public User updateUserByID(@PathVariable Long userID, @RequestBody User userRequest) { return userService.updateByID(userID, userRequest); }
    @DeleteMapping("users/delete/all")
    public String deleteAllUsers() { return userService.deleteAll(); }
    @DeleteMapping("users/deleteby/id/{userID}")
    public String deleteUserByID(@PathVariable Long userID) { return userService.deleteByID(userID);}
    @PostMapping("/users/add")
    public String insertUser(@RequestBody User newUser) { return userService.insert(newUser); }
}
