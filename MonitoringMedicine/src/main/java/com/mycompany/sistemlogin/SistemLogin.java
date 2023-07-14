/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Agung
 */
public class SistemLogin {

//    public static void main(String[] args) {
//        Connection c = null;
//      try {
//         Class.forName("org.postgresql.Driver");
//         c = DriverManager
//            .getConnection("jdbc:postgresql://localhost:5432/MonitoringMedicine",
//            "postgres", "root");
//         new Login(c);
//      } catch (Exception e) {
//         e.printStackTrace();
//         System.err.println(e.getClass().getName()+": "+e.getMessage());
//         System.exit(0);
//      }
//      System.out.println("Opened database successfully");
//   }
    
    private int userId;
    public static Connection connect() {
        Connection conn = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            
            String mysqlURL = "jdbc:postgresql://localhost:5432/MonitoringMedicine";
            
            conn = (Connection) DriverManager.getConnection(mysqlURL, "postgres", "agung");
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
        
        return conn;
    }
    
    public void setUserId(String id){
        this.userId = Integer.parseInt(id);
    }
    
    public int getUserId(){
        return this.userId;
    }
    
    public static void main(String[] args) {
        new Login();
    }
}

