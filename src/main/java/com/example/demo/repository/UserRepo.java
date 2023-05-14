package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    /** this query returns a User with a given id */
    @Query(value = "SELECT * FROM dealership.user u WHERE u.id=:user_id", nativeQuery = true)
    User findUserByID(@Param("user_id") Long id);
}
