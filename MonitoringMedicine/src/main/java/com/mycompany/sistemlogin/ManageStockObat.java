/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemlogin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ritz
 */
public class ManageStockObat extends javax.swing.JFrame {

    /**
     * Creates new form ManageStockObat
     */
    public ManageStockObat(int userId) {
        initComponents();
        initObat();
        this.userId = userId;   
        try {
            getObat();
        } catch (SQLException ex) {
            Logger.getLogger(ManageStockObat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int centerX = (screenSize.width - getWidth()) / 2;
        int centerY = (screenSize.height - getHeight()) / 2;
        
        setLocation(centerX, centerY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private int id;
    private int userId;
    HashMap<Integer, String> obat = new HashMap<Integer, String>();

    private void initObat(){
        Connection con = (Connection)SistemLogin.connect();
        
        try {
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT namaobat, stockin, stockout, tanggal FROM ppobat p "
                    + "INNER JOIN obat o "
                    + " ON p.idobat  = o.idobat ");
            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }
            rs = query.executeQuery("SELECT idppobat, namaobat, stockin, stockout, tanggal FROM ppobat p "
                    + "INNER JOIN obat o "
                    + " ON p.idobat  = o.idobat ");
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
                row++;
            }
            
            DefaultTableModel tableModel = new DefaultTableModel(dataTable, columnName){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };

            appareltable.setModel(tableModel);
            appareltable.getColumnModel().getColumn(0).setPreferredWidth(rsMd.getColumnDisplaySize(1));
            appareltable.getColumnModel().getColumn(0).setResizable(false);
            appareltable.getColumnModel().getColumn(1).setPreferredWidth(rsMd.getColumnDisplaySize(2));
            appareltable.getColumnModel().getColumn(1).setResizable(false);
            appareltable.getColumnModel().getColumn(2).setPreferredWidth(rsMd.getColumnDisplaySize(3));
            appareltable.getColumnModel().getColumn(2).setResizable(false);
            appareltable.getColumnModel().getColumn(3).setPreferredWidth(rsMd.getColumnDisplaySize(4));
            appareltable.getColumnModel().getColumn(3).setResizable(false);
            appareltable.getColumnModel().getColumn(4).setPreferredWidth(rsMd.getColumnDisplaySize(5));
            appareltable.getColumnModel().getColumn(4).setResizable(false);
        
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        obatField.setSelectedItem("");
        tanggalField.setDate(new Date());
        stockInField.setText("");
        stockOutField.setText("");
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
        appareltable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        stockInField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        obatField = new javax.swing.JComboBox<>();
        tanggalField = new com.toedter.calendar.JDateChooser();
        stockOutField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        appareltable.setModel(new javax.swing.table.DefaultTableModel(
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
        appareltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appareltableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(appareltable);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Barang");

        jLabel3.setText("Tanggal");

        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Stock Masuk");

        jLabel5.setText("Stock Out");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Obat");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(stockOutField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(stockInField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(obatField, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tanggalField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(obatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stockInField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton4)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockOutField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appareltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appareltableMouseClicked

        DefaultTableModel tbModel = (DefaultTableModel)appareltable.getModel();

//        String nama = tbModel.getValueAt(appareltable.getSelectedRow(), 1).toString();        
        String obat = tbModel.getValueAt(appareltable.getSelectedRow(), 1).toString();
        String tanggal = tbModel.getValueAt(appareltable.getSelectedRow(), 4).toString();
        String stockIn = tbModel.getValueAt(appareltable.getSelectedRow(), 2).toString();
        String stockOut = tbModel.getValueAt(appareltable.getSelectedRow(), 3).toString();
//        this.id = (int) tbModel.getValueAt(appareltable.getSelectedRow(), 0);
//        System.out.println(obat);
        obatField.setSelectedItem(obat);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
       try {
           date = dateFormat.parse(tanggal);
       } catch (ParseException ex) {
           Logger.getLogger(ListPasien.class.getName()).log(Level.SEVERE, null, ex);
       }
               tanggalField.setDate(date);

        stockInField.setText(stockIn);
        stockOutField.setText(stockOut);
    }//GEN-LAST:event_appareltableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = (Connection)SistemLogin.connect();
        try {
            int idObat = 0;
            for (int i : obat.keySet()) {
                if (obat.get(i).equals(obatField.getSelectedItem())) {
                    idObat = i;
                }
            }
            Date tanggal = tanggalField.getDate();
            
            String stockIn = stockInField.getText();
            String stockOut = stockOutField.getText();
            java.sql.Date sqlDate = new java.sql.Date(tanggal.getTime());
            // Insert To Table ppobat
            PreparedStatement query = conn.prepareStatement("insert into ppobat (tanggal, stockin, stockout, idobat) values (?, ?, ?, ?)");
            query.setDate(1, (java.sql.Date) sqlDate);
            query.setInt(2, Integer.parseInt(stockIn));
            query.setInt(3, Integer.parseInt(stockOut));
            query.setInt(4, idObat);
            query.executeUpdate();
            
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("SELECT * FROM obat where idobat = "+ idObat);
            int total = 0;
            while (rs.next()) {
//                System.out.println(rs.getInt(3));
                total = rs.getInt(3)+Integer.parseInt(stockIn) - Integer.parseInt(stockOut);
            }
            
            // Update total obat
            query = conn.prepareStatement ("UPDATE obat set totalstock="+ total +" WHERE idobat = "+ idObat);
            query.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Manage Obat berhasil ditambahkan");
            appareltable.setModel(new DefaultTableModel(null, new String[]{ "nama barang", "stock"}));

        } catch (SQLException e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Data Manage Obat gagal ditambahkan");
        }

        initObat();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        setVisible(false);
        try {
            new Home(this.userId);
        } catch (SQLException ex) {
            Logger.getLogger(ListObat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appareltable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> obatField;
    private javax.swing.JTextField stockInField;
    private javax.swing.JTextField stockOutField;
    private com.toedter.calendar.JDateChooser tanggalField;
    // End of variables declaration//GEN-END:variables
}
