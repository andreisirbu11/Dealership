package com.example.demo.management;

import com.example.demo.model.Vehicle;
import java.util.List;

/** It's role is to update the price of all vehicle of a given brand and to increase the price of all vehicles */
public class VehicleManagement {
    private List<Vehicle> vehicleList;
    public VehicleManagement(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void setDiscount() {
        for(Vehicle v: this.vehicleList) {
            v.discount();
        }
    }
    public void increasePrice() {
        for(Vehicle v: this.vehicleList) {
            v.increasePrice();
        }
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
