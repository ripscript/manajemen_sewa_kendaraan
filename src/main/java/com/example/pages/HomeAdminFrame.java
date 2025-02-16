/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.pages;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ripsc
 */
public class HomeAdminFrame extends javax.swing.JFrame {
    /**
     * Creates new form HomeAdminFrame
     */
    public HomeAdminFrame() {
        setTitle("Aplikasi Sewa Kendaraan");
        initComponents();
        
        updateMainContent(new DashboardPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(1280, 720);
        
        // Nonaktifkan resize
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarPanel = new javax.swing.JPanel();
        sidebarMenuDashboard = new javax.swing.JButton();
        sidebarMenuMotor = new javax.swing.JButton();
        sidebarMenuMobil = new javax.swing.JButton();
        sidebarMenuKeluar = new javax.swing.JButton();
        mainContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidebarPanel.setBackground(new java.awt.Color(209, 209, 209));
        sidebarPanel.setLayout(new javax.swing.BoxLayout(sidebarPanel, javax.swing.BoxLayout.Y_AXIS));

        sidebarMenuDashboard.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sidebarMenuDashboard.setText("Dashboard");
        sidebarMenuDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarMenuDashboard.setMaximumSize(new java.awt.Dimension(200, 50));
        sidebarMenuDashboard.setMinimumSize(new java.awt.Dimension(140, 35));
        sidebarMenuDashboard.setPreferredSize(new java.awt.Dimension(200, 50));
        sidebarMenuDashboard.setSelected(true);
        sidebarMenuDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarMenuDashboardActionPerformed(evt);
            }
        });
        sidebarPanel.add(sidebarMenuDashboard);

        sidebarMenuMotor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sidebarMenuMotor.setText("Motor");
        sidebarMenuMotor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarMenuMotor.setMaximumSize(new java.awt.Dimension(200, 50));
        sidebarMenuMotor.setMinimumSize(new java.awt.Dimension(140, 35));
        sidebarMenuMotor.setPreferredSize(new java.awt.Dimension(140, 35));
        sidebarMenuMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarMenuMotorActionPerformed(evt);
            }
        });
        sidebarPanel.add(sidebarMenuMotor);

        sidebarMenuMobil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sidebarMenuMobil.setText("Mobil");
        sidebarMenuMobil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarMenuMobil.setMaximumSize(new java.awt.Dimension(200, 50));
        sidebarMenuMobil.setMinimumSize(new java.awt.Dimension(140, 35));
        sidebarMenuMobil.setPreferredSize(new java.awt.Dimension(140, 35));
        sidebarMenuMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarMenuMobilActionPerformed(evt);
            }
        });
        sidebarPanel.add(sidebarMenuMobil);

        sidebarMenuKeluar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        sidebarMenuKeluar.setText("Keluar");
        sidebarMenuKeluar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarMenuKeluar.setMaximumSize(new java.awt.Dimension(200, 50));
        sidebarMenuKeluar.setMinimumSize(new java.awt.Dimension(140, 35));
        sidebarMenuKeluar.setPreferredSize(new java.awt.Dimension(140, 35));
        sidebarMenuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarMenuKeluarActionPerformed(evt);
            }
        });
        sidebarPanel.add(sidebarMenuKeluar);

        getContentPane().add(sidebarPanel, java.awt.BorderLayout.WEST);

        mainContent.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sidebarMenuDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMenuDashboardActionPerformed
        updateMainContent(new DashboardPanel());
    }//GEN-LAST:event_sidebarMenuDashboardActionPerformed

    private void sidebarMenuMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMenuMotorActionPerformed
        updateMainContent(new MotorAdminPanel(this));
    }//GEN-LAST:event_sidebarMenuMotorActionPerformed

    private void sidebarMenuMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMenuMobilActionPerformed
        updateMainContent(new MobilAdminPanel(this));
    }//GEN-LAST:event_sidebarMenuMobilActionPerformed

    private void sidebarMenuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMenuKeluarActionPerformed
        this.setVisible(false);
        RoleLoginFrame roleLoginFrame = new RoleLoginFrame();
        roleLoginFrame.setVisible(true);
    }//GEN-LAST:event_sidebarMenuKeluarActionPerformed

    
    // Metode untuk mengganti konten utama
    private void updateMainContent(JPanel newContent) {
        mainContent.removeAll(); // Menghapus semua komponen di mainContent
        mainContent.add(newContent, BorderLayout.CENTER);
        mainContent.revalidate(); // Memperbarui tata letak
        mainContent.repaint(); // Memperbarui tampilan
    }
    
    public void changeMainContent(JPanel newContent) {
        updateMainContent(newContent); // Panggil metode private
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainContent;
    private javax.swing.JButton sidebarMenuDashboard;
    private javax.swing.JButton sidebarMenuKeluar;
    private javax.swing.JButton sidebarMenuMobil;
    private javax.swing.JButton sidebarMenuMotor;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables
}
