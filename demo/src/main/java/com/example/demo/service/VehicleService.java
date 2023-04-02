package com.example.demo.service;

import com.example.demo.management.VehicleManagement;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Does database operations */
@Service
public class VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    public List<Vehicle> findAll() { return vehicleRepo.findAll(); }
    public Vehicle findByID(Long vehicleID) { return vehicleRepo.findById(vehicleID).get(); }
    public String deleteAll() { vehicleRepo.deleteAll(); return "All vehicles deleted"; }
    public String deleteByID(Long vehicleID) { vehicleRepo.deleteById(vehicleID); return "Vehicle with ID = " + vehicleID + " deleted"; }
    public Vehicle updateByID(Long vehicleID, @NotNull Vehicle vehicleRequest) {
        Vehicle foundVehicle = vehicleRepo.findById(vehicleID).get();
        if(vehicleRequest.getBrand() != null) {
            foundVehicle.setBrand(vehicleRequest.getBrand());
        }
        if(vehicleRequest.getModel() != null) {
            foundVehicle.setModel(vehicleRequest.getModel());
        }
        if(vehicleRequest.getClaSS() != null) {
            foundVehicle.setClaSS(vehicleRequest.getClaSS());
        }
        if(vehicleRequest.getTopSpeed() != null) {
            foundVehicle.setTopSpeed(vehicleRequest.getTopSpeed());
        }
        if(vehicleRequest.getPrice() != null) {
            foundVehicle.setPrice(vehicleRequest.getPrice());
        }
        return vehicleRepo.save(foundVehicle);
    };
    public String insert(Vehicle newVehicle) { vehicleRepo.save(newVehicle); return "Vehicle inserted"; }

    public List<Vehicle> findByBrand(String s) {
        return vehicleRepo.findByBrand(s);
    }
    public String reducePriceForBrand(String s) {
        List vehicles = findByBrand(s);
        if(vehicles.isEmpty()) {
            return "No vehicles with brand: " + s;
        }
        else {
            VehicleManagement vehicleManagement = new VehicleManagement(vehicles);
            vehicleManagement.setDiscount();
            for (Vehicle v : vehicleManagement.getVehicleList()) {
                Vehicle currentVehicle = v;
                vehicleRepo.save(v);
            }
            return "Price updated for brand: " + s;
        }
    }
    public String increasePrice() {
        List vehicles = findAll();
        if(vehicles.isEmpty()) {
            return "No vehicles in database";
        }
        else {
            VehicleManagement vehicleManagement = new VehicleManagement(vehicles);
            vehicleManagement.increasePrice();
            for(Vehicle v: vehicleManagement.getVehicleList()) {
                Vehicle currentVehicle = v;
                vehicleRepo.save(currentVehicle);
            }
            return "Price increased for all vehicles";
        }
    }
}
