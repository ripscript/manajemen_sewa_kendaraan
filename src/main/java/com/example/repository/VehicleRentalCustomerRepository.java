/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repository;

import com.example.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.example.model.VehicleRentalCustomer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ripsc
 */
public class VehicleRentalCustomerRepository {
    public boolean create(VehicleRentalCustomer vehicleRentalCustomer) {
        String query = "INSERT INTO vehicle_rental_customers (user_id, vehicle_id, tanggal_pengembalian, created_at, updated_at) VALUES (?, ?, ?, NOW(), NOW())";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set parameter untuk kendaraan baru
            statement.setInt(1, vehicleRentalCustomer.getUserId());
            statement.setInt(2, vehicleRentalCustomer.getVehicleId());
            statement.setString(3, vehicleRentalCustomer.getTanggalPengembalian().toString());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Kembalikan true jika ada baris yang terpengaruh
        } catch (SQLException e) {
            System.err.println("Gagal menambahkan rental kendaraan: " + e.getMessage());
            return false;
        }
    }
    
    public List<VehicleRentalCustomer> getAllWithVehicleDetails() {
        List<VehicleRentalCustomer> vehicleRentalCustomers = new ArrayList<>();
        String query = "SELECT vrc.id AS rental_id, vrc.user_id, vrc.vehicle_id, v.type, v.brand, v.plat_nomor, " +
                       "vrc.tanggal_pengembalian, vrc.created_at, vrc.updated_at " +
                       "FROM vehicle_rental_customers vrc " +
                       "JOIN vehicles v ON vrc.vehicle_id = v.id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                // Mengambil data dari ResultSet
                int rentalId = resultSet.getInt("rental_id");
                int userId = resultSet.getInt("user_id");
                int vehicleId = resultSet.getInt("vehicle_id");
                String type = resultSet.getString("type");
                String brand = resultSet.getString("brand");
                String platNomor = resultSet.getString("plat_nomor");
                LocalDate tanggalPengembalian = resultSet.getDate("tanggal_pengembalian").toLocalDate();
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                LocalDateTime updatedAt = resultSet.getTimestamp("updated_at").toLocalDateTime();

                // Membuat objek VehicleRentalCustomer dengan detail kendaraan
                VehicleRentalCustomer vehicleRentalCustomer = new VehicleRentalCustomer(
                        rentalId, userId, vehicleId, tanggalPengembalian, createdAt, updatedAt
                );

                // Menambahkan detail kendaraan ke objek (misalnya sebagai field tambahan)
                vehicleRentalCustomer.setVehicleType(type);
                vehicleRentalCustomer.setVehicleBrand(brand);
                vehicleRentalCustomer.setVehiclePlatNomor(platNomor);

                // Menambahkan objek ke dalam list
                vehicleRentalCustomers.add(vehicleRentalCustomer);
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil data rental kendaraan dengan detail: " + e.getMessage());
        }

        return vehicleRentalCustomers;
    }
    
    public List<VehicleRentalCustomer> getAllRentalWithVehicleDetailsByUserId(int userId) {
        List<VehicleRentalCustomer> vehicleRentalCustomers = new ArrayList<>();
        String query = "SELECT vrc.*, v.type, v.brand, v.license_plate " +
                       "FROM vehicle_rental_customers AS vrc " +
                       "JOIN vehicles v ON vrc.vehicle_id = v.id " +
                       "WHERE vrc.user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameter untuk user_id
            statement.setInt(1, userId);

            // Eksekusi query
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Mengambil data dari ResultSet
                    int rentalId = resultSet.getInt("id");
                    int vehicleId = resultSet.getInt("vehicle_id");
                    String type = resultSet.getString("type");
                    String brand = resultSet.getString("brand");
                    String platNomor = resultSet.getString("license_plate");
                    LocalDate tanggalPengembalian = resultSet.getDate("tanggal_pengembalian").toLocalDate();
                    LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
                    LocalDateTime updatedAt = resultSet.getTimestamp("updated_at").toLocalDateTime();

                    // Membuat objek VehicleRentalCustomer dengan detail kendaraan
                    VehicleRentalCustomer vehicleRentalCustomer = new VehicleRentalCustomer(
                            rentalId, userId, vehicleId, tanggalPengembalian, createdAt, updatedAt
                    );

                    // Menambahkan detail kendaraan ke objek
                    vehicleRentalCustomer.setVehicleType(type);
                    vehicleRentalCustomer.setVehicleBrand(brand);
                    vehicleRentalCustomer.setVehiclePlatNomor(platNomor);

                    // Menambahkan objek ke dalam list
                    vehicleRentalCustomers.add(vehicleRentalCustomer);
                }
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil data rental kendaraan berdasarkan user_id: " + e.getMessage());
        }

        return vehicleRentalCustomers;
    }
    
    public boolean delete(int vehicleId) {
        String query = "DELETE FROM vehicle_rental_customers WHERE id = ?";
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
    
    public VehicleRentalCustomer getById(int id) {
        String query = "SELECT * FROM vehicle_rental_customers WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Konversi hasil query ke objek User
                return new VehicleRentalCustomer(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("vehicle_id"),
                        resultSet.getDate("tanggal_pengembalian").toLocalDate(),
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
