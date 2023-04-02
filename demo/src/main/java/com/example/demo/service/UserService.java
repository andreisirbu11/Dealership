package com.example.demo.service;

import com.example.demo.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepo;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User findByID(Long userID) { return userRepo.findById(userID).get(); }
    public String deleteAll() { userRepo.deleteAll(); return "All users deleted"; }
    public String deleteByID(Long userID) { userRepo.deleteById(userID); return "User with ID = " + userID + " deleted"; }
    public User updateByID(Long userID, @NotNull User userRequest) {
        User foundUser = userRepo.findById(userID).get();
        if(userRequest.getName() != null) {
            foundUser.setName(userRequest.getName());
        }
        if(userRequest.getEmail() != null) {
            foundUser.setEmail(userRequest.getEmail());
        }
        if(userRequest.getPassword() != null) {
            foundUser.setPassword(userRequest.getPassword());
        }
        if(userRequest.getIdRolol() != null) {
            foundUser.setIdRol(userRequest.getIdRolol());
        }
        return userRepo.save(foundUser);
    };
    public String insert(User newUser) {
        userRepo.save(newUser); return "User inserted";
    }
}
