/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ppp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Conexion {

    private static Connection cx;

    public static Connection getConnection() {
        try {

            Class.forName("oracle.jdbc.OracleDriver");

            if (cx == null) {
                cx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##Proyecto_integrador", "123");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Conexión: " + e);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cx;
    }
}
