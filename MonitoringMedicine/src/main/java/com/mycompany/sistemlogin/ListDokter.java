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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Agung
 */
public class ListDokter extends javax.swing.JFrame {

    /**
     * Creates new form ListDokter
     */
    public ListDokter(int userId) {
        initComponents();
        initapparelhelm();
        this.userId = userId;   
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int centerX = (screenSize.width - getWidth()) / 2;
        int centerY = (screenSize.height - getHeight()) / 2;
        
        setLocation(centerX, centerY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private int id;
    private int userId;
    
    private void initapparelhelm(){
        Connection con = (Connection)SistemLogin.connect();
        
        try {
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM dokter");
            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }
            rs = query.executeQuery("SELECT * FROM dokter");
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
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }           
    }

    private void cleartextfield() {
        namaField.setText("");
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
        namaField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
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

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Dokter");

        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("List Dokter");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appareltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appareltableMouseClicked

        DefaultTableModel tbModel = (DefaultTableModel)appareltable.getModel();

        String nama = tbModel.getValueAt(appareltable.getSelectedRow(), 1).toString();
        this.id = Integer.parseInt(tbModel.getValueAt(appareltable.getSelectedRow(), 0).toString());
        namaField.setText(nama);
    }//GEN-LAST:event_appareltableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn = (Connection)SistemLogin.connect();
        try {
            String nama = namaField.getText();
            PreparedStatement query = conn.prepareStatement("insert into dokter (namadokter) values (?)");
            query.setString(1, nama);
            //                query.setString(3, emailAddress);
            //                query.setInt(4, dropdown);
            query.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Dokter berhasil ditambahkan");
            appareltable.setModel(new DefaultTableModel(null, new String[]{ "nama barang", "stock"}));

        } catch (SQLException e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Data Manage Obat gagal ditambahkan");
        }

        initapparelhelm();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conn = (Connection)SistemLogin.connect();

        try {
            String nama = namaField.getText();

            String query = "UPDATE dokter set namadokter='"+nama+"' WHERE iddokter = "+ this.id;

            var statement = conn.prepareStatement(query);

            statement.execute();

            conn.close();
 
            //            cleartextfield();
            JOptionPane.showMessageDialog(null, "User Berhasil Didaftarkan");
            appareltable.setModel(new DefaultTableModel(null, new String[]{ "namaobat", "totalstock" }));

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "User Gagal Didaftarkan");
        }

        initapparelhelm();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection conn = (Connection)SistemLogin.connect();
        try {
            String query = "DELETE FROM dokter WHERE iddokter= '"+this.id+"'";

            var statement = conn.prepareStatement(query);

            statement.execute();

            conn.close();

            cleartextfield();

            appareltable.setModel(new DefaultTableModel(null, new String[]{ "namaobat", "totalstock" }));


        } catch (SQLException ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "User Gagal Didaftarkan");
        }
        initapparelhelm();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaField;
    // End of variables declaration//GEN-END:variables
}
