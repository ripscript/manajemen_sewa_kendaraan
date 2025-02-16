/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repository;

import com.example.model.User;

import com.example.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 *
 * @author ripsc
 */
public class UserRepository {

    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Konversi hasil query ke objek User
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("nik"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.err.println("Gagal mencari pengguna: " + e.getMessage());
        }
        return null; // Return null jika tidak ditemukan
    }
    
    public User getByNIK(String nik) {
        String query = "SELECT * FROM users WHERE nik = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nik);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Konversi hasil query ke objek User
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("nik"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            System.err.println("Gagal mencari pengguna: " + e.getMessage());
        }
        return null; // Return null jika tidak ditemukan
    }
    
    public User createUser(User user) {
        String query = "INSERT INTO users (nik, username, password, role, created_at, updated_at) VALUES (?, ?, ?, ?, NOW(), NOW())";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Set parameter untuk user baru
            statement.setString(1, user.getNik());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());

            // Eksekusi query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Ambil ID yang dihasilkan oleh database
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1); // Ambil ID dari hasil insert

                        // Kembalikan objek User dengan ID yang baru
                        return new User(
                                id,
                                user.getNik(),
                                user.getUsername(),
                                user.getPassword(),
                                user.getRole(),
                                LocalDateTime.now(), // created_at
                                LocalDateTime.now()  // updated_at
                        );
                    } else {
                        throw new SQLException("Gagal mendapatkan ID yang dihasilkan.");
                    }
                }
            }

            return null; // Kembalikan null jika tidak ada baris yang terpengaruh
        } catch (SQLException e) {
            System.err.println("Gagal menambahkan user: " + e.getMessage());
            e.printStackTrace(); // Tampilkan stack trace untuk debugging
            return null;
        }
    }
}