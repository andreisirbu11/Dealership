package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * this class extends the jpa repository which contains a lot of useful methods already implemented and tested,
 * the developer can also add querys to this interface if neccessary
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    /**
     * this query return information about the name and model of the cars a user ordered
     * in String format
     * */
    @Query(value = "SELECT r.name\n" +
            "FROM dealership.role r\n" +
            "JOIN dealership.user u ON r.id = u.id_rol\n" +
            "WHERE u.id=:user_id", nativeQuery = true)
    String getUserRole(@Param("user_id") Long id);
}
