package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    public VehicleService(VehicleRepo vehicleRepo) { this.vehicleRepo = vehicleRepo; }
    public List<Vehicle> getAllVehicles() { return vehicleRepo.findAll(); }
    public Vehicle getVehicleById(Long vehicleId) { return vehicleRepo.getVehicleById(vehicleId); }
    public List<Vehicle> getAllVehiclesByBrand(String brand) { return vehicleRepo.getAllVehiclesByBrand(brand); }
    public List<String> getBrandModelName(Long id) { return vehicleRepo.getBrandModelName(id); }
    public void deleteAllVehicles() { vehicleRepo.deleteAll(); }
    public String deleteVehicleById(Long id) { vehicleRepo.deleteById(id); return "Vehicle with id " + id + " deleted!"; }
    public String insertNewVehicle(Vehicle vehicle) { vehicleRepo.save(vehicle); return "Vehicle inserted!"; }
    public Vehicle updateVehicleById(Long id, Vehicle requestVehicle) {
        Vehicle foundVehicle = vehicleRepo.getVehicleById(id);
        if(requestVehicle.getBrand() != null) {
            foundVehicle.setBrand(requestVehicle.getBrand());
        }
        if(requestVehicle.getModel() != null) {
            foundVehicle.setModel(requestVehicle.getModel());
        }
        if(requestVehicle.getClaSS() != null) {
            foundVehicle.setClaSS(requestVehicle.getClaSS());
        }
        if(requestVehicle.getTopSpeed() != null) {
            foundVehicle.setTopSpeed(requestVehicle.getTopSpeed());
        }
        if(requestVehicle.getPrice() != null) {
            foundVehicle.setPrice(requestVehicle.getPrice());
        }
        vehicleRepo.save(foundVehicle);
        return foundVehicle;
    }
    public String discount(String brand) {
        vehicleRepo.discount(brand);
        return "Discount applied!";
    }
    public String increasePrice() {
        vehicleRepo.increasePrice();
        return "Price increased!";
    }
}
