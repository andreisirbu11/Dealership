package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    /** this returns a Vehicle with a given id */
    @Query(value = "SELECT * FROM dealership.vehicle v WHERE v.id=:vehicle_id", nativeQuery = true)
    Vehicle getVehicleById(@Param("vehicle_id") Long id);
    /** this returns a list of vehicles with a given brand name */
    @Query(value = "SELECT * FROM dealership.vehicle v WHERE v.brand=:vehicle_brand", nativeQuery = true)
    List<Vehicle> getAllVehiclesByBrand(@Param("vehicle_brand") String brand);
    /**
     * this query returns a list of concatenated brand names and models, in String form
     * */
    @Query(value = "SELECT concat(v.brand, ' ', v.model) as full_name\n" +
            "FROM dealership.vehicle v\n" +
            "JOIN dealership.rentavehicle r ON r.id_vehicle = v.id\n" +
            "JOIN dealership.user u ON u.id = r.id_user\n" +
            "WHERE u.id=:user_id", nativeQuery = true)
    List<String> getBrandModelName(@Param("user_id") Long id);
    /** this applies a discount to all vehicles with a given brand name */
    @Query(value = "UPDATE dealership.vehicle v\n" +
            "SET price = price - (price * 10 / 100)\n" +
            "WHERE v.brand=:vehicle_brand", nativeQuery = true)
    void discount(@Param("vehicle_brand") String brand);
    @Query(value = "UPDATE dealership.vehicle v\n" +
            "SET price = price + (price * 10 / 100)", nativeQuery = true)
    void increasePrice();
}
