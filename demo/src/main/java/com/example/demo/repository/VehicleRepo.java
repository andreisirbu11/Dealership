package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    @Query(value = "SELECT * FROM dealership.vehicle v WHERE v.brand=:brand", nativeQuery = true)
    List<Vehicle> findByBrand(@Param("brand") String brand);
}
