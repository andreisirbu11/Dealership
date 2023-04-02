package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** Gets data from requets and sends them to Service which will update the database */
@RestController
@CrossOrigin
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    /** GET Endpoints */
    @GetMapping("/vehicles/findAll")
    public List<Vehicle> findAllUsers() {
        return vehicleService.findAll();
    }

    @GetMapping("/vehicles/findBy/ID/{vehicleID}")
    public Vehicle findVehicleByID(@PathVariable Long vehicleID) { return vehicleService.findByID(vehicleID); }

    @GetMapping("/vehicles/findBy/brand/{vehicleBrand}")
    public List<Vehicle> findVehiclesByBrand(@PathVariable String vehicleBrand) {
        return vehicleService.findByBrand(vehicleBrand);
    }

    /** PUT Endpoints */
    @PutMapping("/vehicles/updateBy/ID/{vehicleID}")
    public Vehicle updateUserByID(@PathVariable Long vehicleID, @RequestBody Vehicle vehicleRequest) {
        return vehicleService.updateByID(vehicleID, vehicleRequest);
    }
    @PutMapping("/vehicles/discount/{vehicleBrand}")
    public String applyDiscount(@PathVariable String vehicleBrand) {
        return vehicleService.reducePriceForBrand(vehicleBrand);
    }
    @PutMapping("/vehicles/increase")
    public String increasePrice() {
        return vehicleService.increasePrice();
    }

    /** DELETE Endpoints */
    @DeleteMapping("vehicles/deleteAll")
    public String deleteAllVehicles() { return vehicleService.deleteAll(); }

    @DeleteMapping("vehicles/deleteBy/ID/{vehicleID}")
    public String deleteVehicleByID(@PathVariable Long vehicleID) { return vehicleService.deleteByID(vehicleID);}

    /** POST Endpoints */
    @PostMapping("/vehicles/add")
    public String insertVehicle(@RequestBody Vehicle newVehicle) { return vehicleService.insert(newVehicle); }

}
