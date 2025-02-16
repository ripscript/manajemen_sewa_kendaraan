/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example.pages;

import com.example.model.Vehicle;
import com.example.service.VehicleService;
import com.example.utils.CustomResult;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author ripsc
 */
public class UbahKendaraanMotorPanel extends javax.swing.JPanel {
    private HomeAdminFrame homeAdminFrame;
    private int vehicleId;
    private final VehicleService vehicleService = new VehicleService();

    /**
     * Creates new form TambahKendaraanPanel
     */
    public UbahKendaraanMotorPanel(HomeAdminFrame homeAdminFrame, int vehicleId) {
        initComponents();
        
        this.homeAdminFrame = homeAdminFrame;
        this.vehicleId = vehicleId;
        
        Vehicle oldVehicle = vehicleService.getById(vehicleId);
        if (oldVehicle != null) {
            brandInput.setText(oldVehicle.getBrand());
            platNomorInput.setText(oldVehicle.getLisencePlate());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        labelBrand = new javax.swing.JLabel();
        labelPlatNomor = new javax.swing.JLabel();
        brandInput = new javax.swing.JTextField();
        platNomorInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        buttonKembali = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Ubah Kendaraan Motor");
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(jLabel1, gridBagConstraints);

        labelBrand.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelBrand.setText("Brand :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(labelBrand, gridBagConstraints);

        labelPlatNomor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelPlatNomor.setText("Plat Nomor :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(labelPlatNomor, gridBagConstraints);

        brandInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        brandInput.setToolTipText("Masukan nama brand");
        brandInput.setPreferredSize(new java.awt.Dimension(300, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(brandInput, gridBagConstraints);

        platNomorInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        platNomorInput.setToolTipText("Masukan plat nomor");
        platNomorInput.setPreferredSize(new java.awt.Dimension(300, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(platNomorInput, gridBagConstraints);

        jButton1.setText("Simpan");
        jButton1.setPreferredSize(new java.awt.Dimension(300, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 6;
        add(jButton1, gridBagConstraints);

        buttonKembali.setText("Kembali");
        buttonKembali.setPreferredSize(new java.awt.Dimension(100, 30));
        buttonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        add(buttonKembali, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliActionPerformed
        MotorAdminPanel motorAdminPanel = new MotorAdminPanel(homeAdminFrame);
        
        if (homeAdminFrame != null) {
            homeAdminFrame.changeMainContent(motorAdminPanel);
        }
    }//GEN-LAST:event_buttonKembaliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String brandValue = brandInput.getText();
        String platNomorValue = platNomorInput.getText();
        
        if (brandValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Brand harus diisi", "Oops", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (platNomorValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Plat Nomor harus diisi", "Oops", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Vehicle newVehicle = new Vehicle();
        newVehicle.setId(vehicleId);
        newVehicle.setType("motor");
        newVehicle.setBrand(brandValue);
        newVehicle.setLicensePlate(platNomorValue);
        newVehicle.setStatus("available");

        CustomResult result = vehicleService.updateVehicle(newVehicle);
        if (result.isSuccess()) {
            JOptionPane.showMessageDialog(this, result.getMessage());
            MotorAdminPanel motorAdminPanel = new MotorAdminPanel(homeAdminFrame);
            homeAdminFrame.changeMainContent(motorAdminPanel);
        } else {
            JOptionPane.showMessageDialog(null, result.getMessage(), "Oops", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brandInput;
    private javax.swing.JButton buttonKembali;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelBrand;
    private javax.swing.JLabel labelPlatNomor;
    private javax.swing.JTextField platNomorInput;
    // End of variables declaration//GEN-END:variables
}
