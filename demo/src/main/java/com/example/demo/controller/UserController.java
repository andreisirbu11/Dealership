package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /** GET Endpoints */
    @GetMapping("/users/findAll")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/findBy/ID/{userID}")
    public User findUserByID(@PathVariable Long userID) { return userService.findByID(userID); }

    /** PUT Endpoints */
    @PutMapping("/users/updateBy/ID/{userID}")
    public User updateUserByID(@PathVariable Long userID, @RequestBody User userRequest) {
        return userService.updateByID(userID, userRequest);
    }

    /** DELETE Endpoints */
    @DeleteMapping("users/deleteAll")
    public String deleteAllUsers() { return userService.deleteAll(); }

    @DeleteMapping("users/deleteBy/ID/{userID}")
    public String deleteUserByID(@PathVariable Long userID) { return userService.deleteByID(userID);}

    /** POST Endpoints */
    @PostMapping("/users/add")
    public String insertUser(@RequestBody User newUser) { return userService.insert(newUser); }

}
