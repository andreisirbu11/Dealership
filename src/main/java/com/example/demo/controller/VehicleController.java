package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @GetMapping("vehicles/get/all")
    public List<Vehicle> getAllVehicles() { return vehicleService.getAllVehicles(); }
    @GetMapping("vehicles/getby/id/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) { return vehicleService.getVehicleById(id); }
    @GetMapping("/vehicles/getby/brand/{brand}")
    public List<Vehicle> getAllVehiclesById(@PathVariable String brand) { return  vehicleService.getAllVehiclesByBrand(brand); }
    @GetMapping("/vehicles/get/brand-model/{id}")
    public List<String> getBrandModelName(@PathVariable Long id) {
        return vehicleService.getBrandModelName(id);
    }
    @DeleteMapping("/vehicles/delete/all")
    public void deleteAllVehicles() { vehicleService.deleteAllVehicles(); }
    @DeleteMapping("/vehicles/deleteby/id/{id}")
    public String deleteVehicleById(@PathVariable Long id) { return vehicleService.deleteVehicleById(id); }
    @PostMapping("vehicles/insert")
    public String insertNewVehicle(@RequestBody Vehicle newVehicle) {
        return vehicleService.insertNewVehicle(newVehicle);
    }
    @PutMapping("vehicles/update/id/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle requestVehicle) {
        return vehicleService.updateVehicleById(id, requestVehicle);
    }
    @PutMapping("vehicles/discount/brand/{brand}")
    public String discount(@PathVariable String brand) { return vehicleService.discount(brand); }
    @PutMapping("vehicles/increase-price")
    public String increasePrice() { return vehicleService.increasePrice(); }
}
