package com.example.demo.repository;

import com.example.demo.model.RentAVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentAVehicleRepo extends JpaRepository<RentAVehicle, Long> {
    /**
     * this query returns the order with a given id by the user
     * the method findById is already implemented by the Jpa, but it returns the Optional type
     * */
    @Query(value = "SELECT * FROM dealership.rentavehicle r WHERE r.id=:id", nativeQuery = true)
    RentAVehicle findOrderById(@Param("id") Long id);
    /**
     * this query return a list of all orders placed by a user with a given id
     * */
    @Query(value = "SELECT * FROM dealership.rentavehicle r WHERE r.id_user=:id", nativeQuery = true)
    List<RentAVehicle> findOrdersByUserId(@Param("id") Long id);
    /**
     * this query return a list of all orders which have in common the same vehicle
     * */
    @Query(value = "SELECT * FROM dealership.rentavehicle r WHERE r.id_vehicle=:id", nativeQuery = true)
    List<RentAVehicle> findOrdersByVehicleId(@Param("id") Long id);
}
