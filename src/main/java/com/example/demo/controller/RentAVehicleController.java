package com.example.demo.controller;

import com.example.demo.model.RentAVehicle;
import com.example.demo.service.RentAVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RentAVehicleController {
    @Autowired
    private RentAVehicleService rentAVehicleService;
    @GetMapping("/orders/get/all")
    public List<RentAVehicle> getAllOrders() { return rentAVehicleService.getAllOrders(); }
    @GetMapping("/orders/getby/order/id/{orderId}")
    public RentAVehicle getOrderById(@PathVariable Long orderId) { return rentAVehicleService.getOrderById(orderId); }
    @GetMapping("orders/getby/vehicle/id/{vehicleId}")
    public List<RentAVehicle> getAllOrdersByVehicleId(@PathVariable Long vehicleId) { return rentAVehicleService.getAllOrdersByVehicleId(vehicleId);}
    @GetMapping("orders/getby/user/id/{userId}")
    public List<RentAVehicle> getAllOrdersByUserId(@PathVariable Long userId) { return rentAVehicleService.getAllOrdersByUserId(userId); }
    @DeleteMapping("orders/delete/all")
    public void deleteAllOrders() { rentAVehicleService.deleteAllOrders(); }
}
