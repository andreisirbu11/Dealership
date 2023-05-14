package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * the controller class does the connection with the outside,
 * the methods implemented in this class extract a variable from an endpoint
 * */
@CrossOrigin
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/roles/get/all")
    public List<Role> getAllRoles() { return roleService.getAllRoles(); }
    @DeleteMapping("roles/delete/all")
    public void deleteAllRoles() { roleService.deleteAllRoles(); }
    /**
     * for example this method extracts the id from the given path(endpoint) and
     * sends the parameter to the service and from there it goes to the repository
     * */
    @GetMapping("/roles/get/user/role/id/{id}")
    public String getUserRoleById(@PathVariable Long id) {
        return roleService.getUserRole(id);
    }
}
