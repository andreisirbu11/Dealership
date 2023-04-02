package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;
    public List<Role> findAll() { return roleRepo.findAll(); }
}
