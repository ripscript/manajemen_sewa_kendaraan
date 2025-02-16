/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.service;

import com.example.model.Vehicle;
import com.example.repository.VehicleRepository;
import com.example.utils.CustomResult;
import java.util.List;
import javax.swing.JOptionPane;
import com.example.model.VehicleRentalCustomer;
import com.example.repository.VehicleRentalCustomerRepository;

/**
 *
 * @author ripsc
 */
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService() {
        this.vehicleRepository = new VehicleRepository();
    }
    
    public int getTotalVehicles () {
        int totalVehicles = vehicleRepository.getTotalVehicles();
        
        return totalVehicles;
    }
    
    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }
    
    public List<Vehicle> getMotorVehicles() {
        return vehicleRepository.getMotorVehicles();
    }
    
    public List<Vehicle> getMobilVehicles() {
        return vehicleRepository.getMobilVehicles();
    }
    
    public List<Vehicle> getMotorAvailableVehicles() {
        return vehicleRepository.getMotorAvailableVehicles();
    }
    
    public List<Vehicle> getMobilAvailableVehicles() {
        return vehicleRepository.getMobilAvailableVehicles();
    }
    
    public boolean deleteVehicle(int vehicleId) {
        return vehicleRepository.deleteVehicle(vehicleId);
    }

    public boolean deleteVehicles(List<Integer> vehicleIds) {
        return vehicleRepository.deleteVehicles(vehicleIds);
    }
    
    public CustomResult createVehicle(Vehicle vehicle) {
        Vehicle getVehicleByLicensePlate = vehicleRepository.getByLicensePlate(vehicle.getLisencePlate());
        if (getVehicleByLicensePlate != null) {
            return new CustomResult(true, "Plat Nomor Sudah Terdaftar", null);
        }
        
        if (vehicleRepository.createVehicle(vehicle)) {
            return new CustomResult(true, "Berhasil Menambahkan Kendaraan", null);
        } else {
            return new CustomResult(true, "Gagal Menambahkan Kendaraan", null);
        }
    }

    public CustomResult updateVehicle(Vehicle vehicle) {
        Vehicle getVehicleById = vehicleRepository.getById(vehicle.getId());
        if (getVehicleById != null) {
            if (!vehicle.getLisencePlate().equals(getVehicleById.getLisencePlate())) {
                Vehicle getVehicleByLicensePlate = vehicleRepository.getByLicensePlate(vehicle.getLisencePlate());
                if (getVehicleByLicensePlate != null) {
                    return new CustomResult(false, "Plat Nomor Sudah Terdaftar", null);
                }
            }
        }
        
        if (vehicleRepository.updateVehicle(vehicle)) {
            return new CustomResult(true, "Berhasil Mengubah Kendaraan", null);
        } else {
            return new CustomResult(true, "Gagal Mengubah Kendaraan", null);
        }
    }
    
    public Vehicle getById(int id){
        return vehicleRepository.getById(id);
    }
    
    public CustomResult createRental(VehicleRentalCustomer vehicleRentalCustomer){
        Vehicle vehicleById = vehicleRepository.getById(vehicleRentalCustomer.getVehicleId());
        if (vehicleById != null) {
            VehicleRentalCustomerRepository vehicleRentalCustomerRepository = new VehicleRentalCustomerRepository();
            if (vehicleRentalCustomerRepository.create(vehicleRentalCustomer)) {
                vehicleById.setStatus("rented");
                if (vehicleRepository.updateVehicle(vehicleById)) {
                    return new CustomResult(true, "Kendaraan Berhasil Disewa", null); 
                } else {
                    return new CustomResult(false, "Gagal menyewa kendaraan", null); 
                }
            } else {
                return new CustomResult(false, "Gagal menyewa kendaraan", null); 
            }
        }
        
        return new CustomResult(false, "Kendaraan Tidak Ditemukan", null);
    }
}
