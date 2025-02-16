 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ripsc
 */
public class VehicleRentalCustomer {
    private int id;
    private int userId;
    private int vehicleId;
    private LocalDate tanggalPengembalian;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    // Field tambahan untuk detail kendaraan
    private String vehicleType;
    private String vehicleBrand;
    private String vehiclePlatNomor;

    public VehicleRentalCustomer() {}

    public VehicleRentalCustomer(int id, int userId, int vehicleId, LocalDate tanggalPengembalian, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.tanggalPengembalian = tanggalPengembalian;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDate getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(LocalDate tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Getter dan Setter untuk field tambahan
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehiclePlatNomor() {
        return vehiclePlatNomor;
    }

    public void setVehiclePlatNomor(String vehiclePlatNomor) {
        this.vehiclePlatNomor = vehiclePlatNomor;
    }

    // Override toString untuk mencetak detail lengkap
    @Override
    public String toString() {
        return "VehicleRentalCustomer{" +
                "id=" + id +
                ", userId=" + userId +
                ", vehicleId=" + vehicleId +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", vehiclePlatNomor='" + vehiclePlatNomor + '\'' +
                ", tanggalPengembalian=" + (tanggalPengembalian != null ? tanggalPengembalian.toString() : "null") +
                ", createdAt=" + (createdAt != null ? createdAt.toString() : "null") +
                ", updatedAt=" + (updatedAt != null ? updatedAt.toString() : "null") +
                '}';
    }
}
