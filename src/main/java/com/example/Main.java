/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.utils.DatabaseConnection;
import javax.swing.SwingUtilities;

import com.example.pages.RoleLoginFrame;

/**
 *
 * @author ripsc
 */
public class Main {
    public static void main(String[] args) {
        // Cek koneksi database
        if (!DatabaseConnection.isDatabaseConnected()) {
            // Tampilkan jendela error jika koneksi gagal
            DatabaseConnection.showErrorDialog("Tidak dapat terhubung ke database. Aplikasi akan ditutup.");
            System.exit(1); // Hentikan aplikasi
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Tampilkan halaman login
                RoleLoginFrame loginFrame = new RoleLoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
}
