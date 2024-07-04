/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ppp.daoImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import pe.edu.upeu.ppp.config.Conexion;
import pe.edu.upeu.ppp.dao.EstudianteDao;
import pe.edu.upeu.ppp.entity.EstudianteEntity;

/**
 *
 * @author USER
 */
public class EstudianteDaoImpls implements EstudianteDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int crearEstudiante(EstudianteEntity e) {
        int x = 0;
        String SQL = "INSERT INTO estudiante (idestudiante, codigo, id_persona) VALUES (?,?, ?)";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, e.getId_estudiante());
            ps.setInt(2, e.getCodigo());
            ps.setInt(3, e.getId_persona());
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int actualizarEstudiante(EstudianteEntity e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminarEstudiante(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EstudianteEntity leerEstudiante(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EstudianteEntity> leertodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
