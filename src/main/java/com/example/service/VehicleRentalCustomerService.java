/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.VehicleRentalCustomer;
import com.example.repository.VehicleRentalCustomerRepository;
import java.util.List;

/**
 *
 * @author ripsc
 */
public class VehicleRentalCustomerService {
    private final VehicleRentalCustomerRepository vehicleRentalCustomerRepository;
    
    public VehicleRentalCustomerService() {
        this.vehicleRentalCustomerRepository = new VehicleRentalCustomerRepository();
    }
    
    public List<VehicleRentalCustomer> getAllRentalWithVehicleDetails() {
        return vehicleRentalCustomerRepository.getAllWithVehicleDetails();
    }

    public List<VehicleRentalCustomer> getAllRentalWithVehicleDetailsByUserId(int userLoginId) {
        return vehicleRentalCustomerRepository.getAllRentalWithVehicleDetailsByUserId(userLoginId);
    }
    
    public boolean delete(int vehicleId) {
        return vehicleRentalCustomerRepository.delete(vehicleId);
    }
    
    public VehicleRentalCustomer getById(int id){
        return vehicleRentalCustomerRepository.getById(id);
    }
}
