package com.example.demo.service;

import com.example.demo.model.RentAVehicle;
import com.example.demo.repository.RentAVehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentAVehicleService {
    @Autowired
    private RentAVehicleRepo rentAVehicleRepo;
    public RentAVehicleService(RentAVehicleRepo rentAVehicleRepo) {this.rentAVehicleRepo = rentAVehicleRepo; }
    public List<RentAVehicle> getAllOrders() { return rentAVehicleRepo.findAll(); }
    public void deleteAllOrders() { rentAVehicleRepo.deleteAll(); }
    public void deleteOrderById(Long id) { rentAVehicleRepo.deleteById(id); }
    public RentAVehicle getOrderById(Long id) { return rentAVehicleRepo.findOrderById(id); }
    public List<RentAVehicle> getAllOrdersByUserId(Long id) { return rentAVehicleRepo.findOrdersByUserId(id); }
    public List<RentAVehicle> getAllOrdersByVehicleId(Long id) { return rentAVehicleRepo.findOrdersByVehicleId(id); }
}
