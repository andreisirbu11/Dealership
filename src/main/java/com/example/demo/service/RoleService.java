package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * this class implements methods which call methods already implemented by the jpa repo
 * or methods(querys) written by the developer in the RoleService class
 * */
@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;
    /**
     * we need this constructor for testing method of this class to give a fresh instance of the repo
     * before each test
     * */
    public RoleService(RoleRepo roleRepo) { this.roleRepo = roleRepo; }
    /**
     * for example this is a method that calls an already implemented method in the jpa repository,
     * and it returns all roles stored in the database
     * */
    public List<Role> getAllRoles() { return roleRepo.findAll(); }
    public void deleteAllRoles() { roleRepo.deleteAll(); }
    /**
     * the getUseRole() method calls a method(query), a request sent to the database to provide the information needed
     * which in this case is implemented by the developer
     * */
    public String getUserRole(Long id) { return roleRepo.getUserRole(id); }
}
