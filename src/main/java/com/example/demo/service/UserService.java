package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public List<User> getAll() {
        return userRepo.findAll();
    }
    public User getUserById(Long userID) { return userRepo.findUserByID(userID); }
    public String deleteAll() { userRepo.deleteAll(); return "All users deleted"; }
    public String deleteByID(Long userID) { userRepo.deleteById(userID); return "User with ID = " + userID + " deleted"; }
    public User updateByID(Long userID, User userRequest) {
        User foundUser = userRepo.findUserByID(userID);
        if(userRequest.getName() != null) {
            foundUser.setName(userRequest.getName());
        }
        if(userRequest.getEmail() != null) {
            foundUser.setEmail(userRequest.getEmail());
        }
        if(userRequest.getPassword() != null) {
            foundUser.setPassword(userRequest.getPassword());
        }
        if(userRequest.getIdRol() != null) {
            foundUser.setIdRol(userRequest.getIdRol());
        }
        userRepo.save(foundUser);
        return foundUser;
    };
    public String insert(User newUser) {
        userRepo.save(newUser); return "User inserted";
    }
}
