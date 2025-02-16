/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example.pages;

import com.example.GlobalContext;
import com.example.model.Vehicle;
import com.example.model.VehicleRentalCustomer;
import com.example.service.VehicleRentalCustomerService;
import com.example.service.VehicleService;
import com.example.utils.CustomResult;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ripsc
 */
public class KendaraanYangKamuSewaPanel extends javax.swing.JPanel {
    private HomePelangganFrame homePelangganFrame;
    private DefaultTableModel tableModel;
    private JTableHeader tableHeader;
    private final VehicleService vehicleService = new VehicleService();
    private final VehicleRentalCustomerService vehicleRentalCustomerService = new VehicleRentalCustomerService();
    private List<VehicleRentalCustomer> daftarKendaraan; 

    /**
     * Creates new form MotorAdminPanel
     */
    public KendaraanYangKamuSewaPanel(HomePelangganFrame homePelangganFrame) {
        int userLoginId = GlobalContext.getUserId();
        System.out.println(userLoginId);
        daftarKendaraan = vehicleRentalCustomerService.getAllRentalWithVehicleDetailsByUserId(userLoginId);
        
        String[] columnNames = {"No", "Tipe Kendaraan", "Brand", "Plat Nomor", "Tangga Pengembalian", "Aksi"};
        Object[][] data = new Object[daftarKendaraan.size()][columnNames.length];
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            VehicleRentalCustomer vehicleRentalCustomer = daftarKendaraan.get(i);
            data[i][0] = i + 1; // Nomor urut
            data[i][1] = vehicleRentalCustomer.getVehicleType();
            data[i][2] = vehicleRentalCustomer.getVehicleBrand();
            data[i][3] = vehicleRentalCustomer.getVehiclePlatNomor();
            
            // Format tanggal pengembalian
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
            LocalDate tanggalPengembalian = vehicleRentalCustomer.getTanggalPengembalian();
            String formattedTanggalPengembalian = tanggalPengembalian != null 
                ? tanggalPengembalian.format(formatter) 
                : "Tidak Ada"; // Handle jika tanggal null

            data[i][4] = formattedTanggalPengembalian;
            data[i][5] = "Pengembalian";
        }
        
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };
        
        initComponents();
        
        JTableHeader header = dataTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 18)); // Ukuran font header
        header.setPreferredSize(new Dimension(header.getWidth(), 40)); // Tinggi header
        header.setBackground(Color.BLACK.LIGHT_GRAY); // Warna latar belakang header
        header.setForeground(Color.BLACK);
        
        dataTable.setRowSelectionAllowed(false);
        dataTable.setEnabled(true);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Horizontal center
        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        
        for (int i = 0; i < dataTable.getColumnCount(); i++) {
            dataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        dataTable.getColumnModel().getColumn(0).setPreferredWidth(50); // Lebar kolom checkbox
        dataTable.getColumnModel().getColumn(0).setMaxWidth(50); // Batas maksimum lebar
        dataTable.getColumnModel().getColumn(0).setMinWidth(50); // Batas minimum lebar
        
        // Terapkan custom renderer/editor untuk kolom "Aksi"
        dataTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        // Tambahkan mouse listener untuk menangani klik tombol
        dataTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = dataTable.rowAtPoint(e.getPoint());
                int col = dataTable.columnAtPoint(e.getPoint());

                // Pastikan klik terjadi di kolom "Aksi"
                if (col == 5 && row >= 0) {
                    // Ambil ID kendaraan dari baris yang diklik
                    int id = daftarKendaraan.get(row).getId();
                    
                    // Tampilkan dialog konfirmasi
                    int confirm = JOptionPane.showConfirmDialog(
                        null, // Parent component (null berarti tidak ada parent)
                        "Apakah Anda yakin ingin melanjutkan aksi ini?", // Pesan konfirmasi
                        "Konfirmasi Aksi", // Judul dialog
                        JOptionPane.YES_NO_OPTION // Pilihan Ya/Tidak
                    );

                    // Periksa hasil konfirmasi
                    if (confirm == JOptionPane.YES_OPTION) {
                        
                        VehicleRentalCustomer vehicleRentalCustomerById = vehicleRentalCustomerService.getById(id);
                        if (vehicleRentalCustomerById != null) {
                            if (vehicleRentalCustomerService.delete(id)) {
                                Vehicle vehicleById = vehicleService.getById(vehicleRentalCustomerById.getVehicleId());
                                vehicleById.setStatus("available");
                                CustomResult result = vehicleService.updateVehicle(vehicleById);
                                if (result.isSuccess()) {
                                    JOptionPane.showMessageDialog(null, "Pengembalian Kendaaran Berhasil");
                                    
                                    KendaraanYangKamuSewaPanel kendaraanYangKamuSewaPanel = new KendaraanYangKamuSewaPanel(homePelangganFrame);
        
                                    if (homePelangganFrame != null) {
                                        homePelangganFrame.changeMainContent(kendaraanYangKamuSewaPanel);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, result.getMessage(), "Oops", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Terjadi kesalahan mohon hubungi admin", "Oops", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Terjadi kesalahan mohon hubungi admin", "Oops", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        this.homePelangganFrame = homePelangganFrame;
    }
    
    // Renderer untuk tombol
    static class ButtonRenderer extends JPanel implements TableCellRenderer {
        private final JButton detailButton = new JButton("Pengembalian");

        public ButtonRenderer() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0; // Kolom 0
            gbc.gridy = 0; // Baris 0
            gbc.insets = new Insets(0, 5, 0, 5); // Padding atas, kiri, bawah, kanan
            add(detailButton, gbc);
            detailButton.setFocusPainted(false); // Opsional: Menghilangkan outline focus
        }

        @Override
        public Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
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
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Kendaraan Yang Kamu Sewa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(jLabel1, gridBagConstraints);

        dataTable.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        dataTable.setModel(tableModel);
        dataTable.setRowHeight(30);
        dataTable.setRowSelectionAllowed(false);
        dataTable.setShowGrid(true);
        jScrollPane3.setViewportView(dataTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(jScrollPane3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void updateNomorUrut() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(i + 1, i, 1); // Update kolom "No" (indeks kolom = 1)
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
