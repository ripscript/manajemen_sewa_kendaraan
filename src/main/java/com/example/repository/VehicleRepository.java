/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repository;

import com.example.model.Vehicle;
import com.example.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ripsc
 */
public class VehicleRepository {
    public int getTotalVehicles() {
        String query = "SELECT COUNT(*) AS total FROM vehicles"; // Query untuk menghitung jumlah kendaraan
        int totalVehicles = 0; // Variabel untuk menyimpan hasil

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                // Ambil nilai kolom 'total' dari hasil query
                totalVehicles = resultSet.getInt("total");
            }

        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan jumlah kendaraan: " + e.getMessage());
        }

        return totalVehicles; // Kembalikan jumlah kendaraan
    }
    
    public List<Vehicle> getVehicles() {
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>(); // List untuk menyimpan hasil

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Eksekusi query dan ambil hasil
            ResultSet resultSet = statement.executeQuery();

            // Iterasi hasil query dan konversi ke objek Vehicle
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("brand"),
                        resultSet.getString("license_plate"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
                vehicles.add(vehicle);
            }

        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan kendaraan bermotor: " + e.getMessage());
        }

        return vehicles; // Kembalikan daftar kendaraan
    }
    
    public List<Vehicle> getMotorVehicles() {
        String query = "SELECT * FROM vehicles WHERE type = ? ORDER BY vehicles.id DESC"; // Query untuk mengambil kendaraan dengan tipe motor
        List<Vehicle> motorVehicles = new ArrayList<>(); // List untuk menyimpan hasil

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameter untuk tipe kendaraan
            statement.setString(1, "motor");

            // Eksekusi query dan ambil hasil
            ResultSet resultSet = statement.executeQuery();

            // Iterasi hasil query dan konversi ke objek Vehicle
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("brand"),
                        resultSet.getString("license_plate"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
                motorVehicles.add(vehicle); // Tambahkan ke list
            }

        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan kendaraan bermotor: " + e.getMessage());
        }

        return motorVehicles; // Kembalikan daftar kendaraan
    }
    
    public List<Vehicle> getMotorAvailableVehicles() {
        String query = "SELECT * FROM vehicles WHERE type = ? AND status = 'available' ORDER BY vehicles.id DESC";
        List<Vehicle> motorVehicles = new ArrayList<>(); // List untuk menyimpan hasil

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameter untuk tipe kendaraan
            statement.setString(1, "motor");

            // Eksekusi query dan ambil hasil
            ResultSet resultSet = statement.executeQuery();

            // Iterasi hasil query dan konversi ke objek Vehicle
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("brand"),
                        resultSet.getString("license_plate"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
                motorVehicles.add(vehicle); // Tambahkan ke list
            }

        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan kendaraan bermotor: " + e.getMessage());
        }

        return motorVehicles; // Kembalikan daftar kendaraan
    }
    
    public List<Vehicle> getMobilVehicles() {
        String query = "SELECT * FROM vehicles WHERE type = ? ORDER BY vehicles.id DESC"; // Query untuk mengambil kendaraan dengan tipe motor
        List<Vehicle> motorVehicles = new ArrayList<>(); // List untuk menyimpan hasil

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameter untuk tipe kendaraan
            statement.setString(1, "mobil");

            // Eksekusi query dan ambil hasil
            ResultSet resultSet = statement.executeQuery();

            // Iterasi hasil query dan konversi ke objek Vehicle
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("brand"),
                        resultSet.getString("license_plate"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
                motorVehicles.add(vehicle); // Tambahkan ke list
            }

        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan kendaraan bermotor: " + e.getMessage());
        }

        return motorVehicles; // Kembalikan daftar kendaraan
    }
    
    public List<Vehicle> getMobilAvailableVehicles() {
        String query = "SELECT * FROM vehicles WHERE type = ? AND status = 'available' ORDER BY vehicles.id DESC";
        List<Vehicle> motorVehicles = new ArrayList<>(); // List untuk menyimpan hasil

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameter untuk tipe kendaraan
            statement.setString(1, "mobil");

            // Eksekusi query dan ambil hasil
            ResultSet resultSet = statement.executeQuery();

            // Iterasi hasil query dan konversi ke objek Vehicle
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("brand"),
                        resultSet.getString("license_plate"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
                motorVehicles.add(vehicle); // Tambahkan ke list
            }

        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan kendaraan bermotor: " + e.getMessage());
        }

        return motorVehicles; // Kembalikan daftar kendaraan
    }
    
    public boolean deleteVehicle(int vehicleId) {
        String query = "DELETE FROM vehicles WHERE id = ?"; // Query untuk menghapus kendaraan
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set parameter untuk ID kendaraan
            statement.setInt(1, vehicleId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Kembalikan true jika ada baris yang terpengaruh
        } catch (SQLException e) {
            System.err.println("Gagal menghapus kendaraan: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteVehicles(List<Integer> vehicleIds) {
        if (vehicleIds == null || vehicleIds.isEmpty()) {
            return false; // Tidak ada kendaraan untuk dihapus
        }

        StringBuilder queryBuilder = new StringBuilder("DELETE FROM vehicles WHERE id IN (");
        for (int i = 0; i < vehicleIds.size(); i++) {
            queryBuilder.append("?");
            if (i < vehicleIds.size() - 1) {
                queryBuilder.append(",");
            }
        }
        queryBuilder.append(")");

        String query = queryBuilder.toString();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set parameter untuk setiap ID kendaraan
            for (int i = 0; i < vehicleIds.size(); i++) {
                statement.setInt(i + 1, vehicleIds.get(i));
            }
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Kembalikan true jika ada baris yang terpengaruh
        } catch (SQLException e) {
            System.err.println("Gagal menghapus kendaraan: " + e.getMessage());
            return false;
        }
    }
    
    public boolean createVehicle(Vehicle vehicle) {
        String query = "INSERT INTO vehicles (type, brand, license_plate, status, created_at, updated_at) VALUES (?, ?, ?, ?, NOW(), NOW())";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set parameter untuk kendaraan baru
            statement.setString(1, vehicle.getType());
            statement.setString(2, vehicle.getBrand());
            statement.setString(3, vehicle.getLisencePlate());
            statement.setString(4, vehicle.getStatus());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Kembalikan true jika ada baris yang terpengaruh
        } catch (SQLException e) {
            System.err.println("Gagal menambahkan kendaraan: " + e.getMessage());
            return false;
        }
    }

    public boolean updateVehicle(Vehicle vehicle) {
        String query = "UPDATE vehicles SET type = ?, brand = ?, license_plate = ?, status = ?, updated_at = NOW() WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set parameter untuk memperbarui kendaraan
            statement.setString(1, vehicle.getType());
            statement.setString(2, vehicle.getBrand());
            statement.setString(3, vehicle.getLisencePlate());
            statement.setString(4, vehicle.getStatus());
            statement.setInt(5, vehicle.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Kembalikan true jika ada baris yang terpengaruh
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui kendaraan: " + e.getMessage());
            return false;
        }
    }
    
    public Vehicle getByLicensePlate(String licensePlate) {
        String query = "SELECT * FROM vehicles WHERE license_plate = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, licensePlate);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Konversi hasil query ke objek User
                return new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("brand"),
                        resultSet.getString("license_plate"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.err.println("Gagal mencari kendaraan: " + e.getMessage());
        }
        return null; // Return null jika tidak ditemukan
    }
    
    public Vehicle getById(int id) {
        String query = "SELECT * FROM vehicles WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Konversi hasil query ke objek User
                return new Vehicle(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("brand"),
                        resultSet.getString("license_plate"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.err.println("Gagal mencari kendaraan: " + e.getMessage());
        }
        return null; // Return null jika tidak ditemukan
    }
}
