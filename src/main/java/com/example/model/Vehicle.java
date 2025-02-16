/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.time.LocalDateTime;

/**
 *
 * @author ripsc
 */
public class Vehicle {
    private int id;
    private String type;
    private String brand;
    private String license_plate;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Vehicle() {}

    // Constructor
    public Vehicle(int id, String type, String brand, String license_plate, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.license_plate = license_plate;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getLisencePlate() {
        return license_plate;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.license_plate = licensePlate;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + (type != null ? type : "null") + '\'' +
                ", brand='" + (brand != null ? brand : "null") + '\'' +
                ", license_plate='" + (license_plate != null ? license_plate : "null") + '\'' +
                ", status='" + (status != null ? status : "null") + '\'' +
                ", createdAt=" + (createdAt != null ? createdAt.toString() : "null") +
                ", updatedAt=" + (updatedAt != null ? updatedAt.toString() : "null") +
                '}';
    }
    
}
