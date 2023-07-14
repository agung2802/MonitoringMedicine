/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemlogin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Agung
 */
public class ListPasien extends javax.swing.JFrame {

    /**
     * Creates new form ListPasien
     */
   public ListPasien(int userId) throws SQLException {
        initComponents();
        initListPasien();
        getDokter();
        getStatusPasien();
        getObat();
        getPoli();
        this.userId = userId;  
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int centerX = (screenSize.width - getWidth()) / 2;
        int centerY = (screenSize.height - getHeight()) / 2;
        
        setLocation(centerX, centerY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private int id;
    private int idObat = 0;
    private int userId = 0;

    HashMap<Integer, String> poli = new HashMap<Integer, String>();
    HashMap<String, String> dokter = new HashMap<String, String>();
    HashMap<Integer, String> statusPasien = new HashMap<Integer, String>();
    HashMap<Integer, String> obat = new HashMap<Integer, String>();

    private void initListPasien(){
        Connection con = (Connection)SistemLogin.connect();
        
        try {
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT idpasien, namapasien, jumlahobat, tanggalberobat, statuspasien, namapoli, namadokter, namaobat FROM pasien p INNER JOIN statuspasien s "
                    + " ON s.idstatuspasien  = p.idstatuspasien "
                    + "inner join poli p2 "
                    + "on p2.idpoli = p.idpoli "
                    + "inner join dokter d "
                    + "on d.iddokter = p.iddokter "
                    + "inner join obat o "
                    + "on o.idobat = p.idobat ");
            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }
            rs = query.executeQuery("SELECT idpasien, namapasien, jumlahobat, tanggalberobat, statuspasien, namapoli, namadokter, namaobat FROM pasien p "
                    + "INNER JOIN statuspasien s "
                    + " ON s.idstatuspasien  = p.idstatuspasien "
                    + "inner join poli p2 "
                    + "on p2.idpoli = p.idpoli "
                    + "inner join dokter d "
                    + "on d.iddokter = p.iddokter "
                    + "inner join obat o "
                    + "on o.idobat = p.idobat ");
            ResultSetMetaData rsMd = rs.getMetaData();
            int numbers = rsMd.getColumnCount();

            String[] columnName = new String[numbers];
            for (int i = 0; i < numbers; i++) {
                    columnName[i] = rsMd.getColumnName(i+1);
            }
            Object dataTable[][] = new Object[rowNumber][numbers];
            int row = 0;
            while (rs.next()) {                
                dataTable[row][0] = rs.getString(1);
                dataTable[row][1] = rs.getString(2);                
                dataTable[row][2] = rs.getString(3);
                dataTable[row][3] = rs.getString(4);
                dataTable[row][4] = rs.getString(5);
                dataTable[row][5] = rs.getString(6);
                dataTable[row][6] = rs.getString(7);
                dataTable[row][7] = rs.getString(8);
                row++;
            }
            
            DefaultTableModel tableModel = new DefaultTableModel(dataTable, columnName){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };

            TablePasien.setModel(tableModel);
            TablePasien.getColumnModel().getColumn(0).setPreferredWidth(rsMd.getColumnDisplaySize(1));
            TablePasien.getColumnModel().getColumn(0).setResizable(false);
            TablePasien.getColumnModel().getColumn(1).setPreferredWidth(rsMd.getColumnDisplaySize(2));
            TablePasien.getColumnModel().getColumn(1).setResizable(false);
            TablePasien.getColumnModel().getColumn(2).setPreferredWidth(rsMd.getColumnDisplaySize(3));
            TablePasien.getColumnModel().getColumn(2).setResizable(false);
            TablePasien.getColumnModel().getColumn(3).setPreferredWidth(rsMd.getColumnDisplaySize(4));
            TablePasien.getColumnModel().getColumn(3).setResizable(false);
            TablePasien.getColumnModel().getColumn(4).setPreferredWidth(rsMd.getColumnDisplaySize(5));
            TablePasien.getColumnModel().getColumn(4).setResizable(false);
            TablePasien.getColumnModel().getColumn(5).setPreferredWidth(rsMd.getColumnDisplaySize(6));
            TablePasien.getColumnModel().getColumn(5).setResizable(false);
            TablePasien.getColumnModel().getColumn(6).setPreferredWidth(rsMd.getColumnDisplaySize(7));
            TablePasien.getColumnModel().getColumn(6).setResizable(false);
            TablePasien.getColumnModel().getColumn(7).setPreferredWidth(rsMd.getColumnDisplaySize(8));
            TablePasien.getColumnModel().getColumn(7).setResizable(false);
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }           
    }
    
    public void getPoli() throws SQLException{
        Connection con = (Connection)SistemLogin.connect();
        Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM poli");
            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }
            rs = query.executeQuery("SELECT * FROM poli");

            while (rs.next()) {
                poli.put(rs.getInt(1), rs.getString(2));
                poliField.addItem(rs.getString(2));
            }
            
            
    }
    
    public void getDokter() throws SQLException{
        Connection con = (Connection)SistemLogin.connect();
        Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM dokter");
            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }
            rs = query.executeQuery("SELECT * FROM dokter");

            while (rs.next()) {
                dokter.put(rs.getString(1), rs.getString(2));
                dokterField.addItem(rs.getString(2));
            }
            
    }
    
    public void getStatusPasien() throws SQLException{
        Connection con = (Connection)SistemLogin.connect();
        Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM statuspasien");
            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }
            rs = query.executeQuery("SELECT * FROM statuspasien");
            
            while (rs.next()) {
                statusPasien.put(rs.getInt(1), rs.getString(2));
                statusPasienField.addItem(rs.getString(2));
            }
    }
    
    public void getObat() throws SQLException{
        Connection con = (Connection)SistemLogin.connect();
        Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM obat");
            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }
            rs = query.executeQuery("SELECT * FROM obat ORDER BY namaobat ASC");

            while (rs.next()) {
                obat.put(rs.getInt(1), rs.getString(2));
                obatField.addItem(rs.getString(2));
            }
    }

    private void cleartextfield() {
        namaField.setText("");
        kuantitasField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablePasien = new javax.swing.JTable();
        namaField = new javax.swing.JTextField();
        kuantitasField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        poliField = new javax.swing.JComboBox<>();
        statusPasienField = new javax.swing.JComboBox<>();
        dokterField = new javax.swing.JComboBox<>();
        tanggalField = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        obatField = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablePasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablePasien.setToolTipText("");
        TablePasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablePasien);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Pasien");

        jLabel3.setText("Jumlah Obat");

        jLabel4.setText("Poli");

        jLabel5.setText("Status Pasien");

        poliField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poliFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Dokter");

        jLabel7.setText("Obat");

        jLabel8.setText("Tanggal");

        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Pasien");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kuantitasField)
                                    .addComponent(tanggalField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namaField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(poliField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(statusPasienField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dokterField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(obatField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(poliField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(statusPasienField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dokterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(obatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(kuantitasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablePasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePasienMouseClicked

        DefaultTableModel tbModel = (DefaultTableModel)TablePasien.getModel();

        String nama = tbModel.getValueAt(TablePasien.getSelectedRow(), 1).toString();
        String kuantitas = tbModel.getValueAt(TablePasien.getSelectedRow(), 2).toString();
        String dokter = tbModel.getValueAt(TablePasien.getSelectedRow(), 6).toString();
        String obat = tbModel.getValueAt(TablePasien.getSelectedRow(), 7).toString();
        String poli = tbModel.getValueAt(TablePasien.getSelectedRow(), 5).toString();
        String status = tbModel.getValueAt(TablePasien.getSelectedRow(), 4).toString();
        String tanggal = tbModel.getValueAt(TablePasien.getSelectedRow(), 3).toString();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
       try {
           date = dateFormat.parse(tanggal);
       } catch (ParseException ex) {
           Logger.getLogger(ListPasien.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        this.id = Integer.parseInt(tbModel.getValueAt(TablePasien.getSelectedRow(), 0).toString());
        namaField.setText(nama);
        kuantitasField.setText(kuantitas);
        tanggalField.setDate(date);
        poliField.setSelectedItem(poli);
        statusPasienField.setSelectedItem(status);
        obatField.setSelectedItem(obat);
        dokterField.setSelectedItem(dokter);
    }//GEN-LAST:event_TablePasienMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = (Connection)SistemLogin.connect();
        try {
            String nama = namaField.getText();
            int kuantitas = Integer.parseInt(kuantitasField.getText());
            int idPoli = 0;
            String idDokter = "";
            int idStatusPasien = 0;

            for (int i : poli.keySet()) {
                if (poli.get(i).equals(poliField.getSelectedItem())) {
                    idPoli = i;
                }
            }
            for (int i : obat.keySet()) {
                if (obat.get(i).equals(obatField.getSelectedItem())) {
                    this.idObat = i;
                }
            }
            for (String i : dokter.keySet()) {
//                System.out.println(i);
                if (dokter.get(i).equals(dokterField.getSelectedItem())) {
                    idDokter = i;
                }

            }
            for (int i : statusPasien.keySet()) {
                if (statusPasien.get(i).equals(statusPasienField.getSelectedItem())) {
                    idStatusPasien= i;
                }
            }
            
            Date tanggal = tanggalField.getDate();
            
            // Insert To Table Pasien
            java.sql.Date sqlDate = new java.sql.Date(tanggal.getTime());
            PreparedStatement query = conn.prepareStatement("insert into pasien (namapasien, idpoli, iddokter, idobat, idstatuspasien, jumlahobat, tanggalberobat) values (?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, nama);
            query.setInt(2, idPoli);
            query.setInt(3, Integer.parseInt(idDokter));
            query.setInt(4, this.idObat);
            query.setInt(5, idStatusPasien);
            query.setInt(6, kuantitas);
            query.setDate(7, (java.sql.Date) sqlDate);
            query.executeUpdate();
            
            // Insert To Table ppobat
            query = conn.prepareStatement("insert into ppobat (tanggal, stockin, stockout, idobat) values (?, ?, ?, ?)");
            query.setDate(1, (java.sql.Date) sqlDate);
            query.setInt(2, 0);
            query.setInt(3, kuantitas);
            query.setInt(4, this.idObat);
            query.executeUpdate();
            
            
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM obat where idobat = "+ this.idObat);
            int total = 0;
            while (rs.next()) {
//                System.out.println(rs.getInt(3));
                total = rs.getInt(3) - kuantitas;
            }
            
            // Update total obat
            query = conn.prepareStatement ("UPDATE obat set totalstock="+ total +" WHERE idobat = "+ this.idObat);
            query.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Pasien berhasil ditambahkan");
            TablePasien.setModel(new DefaultTableModel(null, new String[]{ "nama barang", "stock"}));

        } catch (SQLException e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Data Pasien berhasil ditambahkan");
        }

        initListPasien();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void poliFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poliFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poliFieldActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       try {
           // TODO add your handling code here:
           setVisible(false);
           new Home(this.userId);
       } catch (SQLException ex) {
           Logger.getLogger(ListPasien.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablePasien;
    private javax.swing.JComboBox<String> dokterField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kuantitasField;
    private javax.swing.JTextField namaField;
    private javax.swing.JComboBox<String> obatField;
    private javax.swing.JComboBox<String> poliField;
    private javax.swing.JComboBox<String> statusPasienField;
    private com.toedter.calendar.JDateChooser tanggalField;
    // End of variables declaration//GEN-END:variables
}