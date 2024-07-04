/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ppp.daoImpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        int x = 0;
        String SQL = "UPDATE estudiante SET codigo = ?, idpersona = ? WHERE idestudiante = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, e.getCodigo());
            ps.setInt(2, e.getId_persona());
            ps.setInt(3, e.getId_estudiante());

            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int eliminarEstudiante(int id) {
        int x = 0;
        String SQL = "DELETE FROM estudiante WHERE idestudiante = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public EstudianteEntity leerEstudiante(int id) {
        EstudianteEntity re = new EstudianteEntity();
        String SQL = "SELECT * FROM estudiante WHERE idestudiante = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                re.setId_estudiante(rs.getInt("idestudiante"));
                re.setCodigo(rs.getInt("codigo"));
                re.setId_persona(rs.getInt("idpersona"));

            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return re;
    }

    @Override
    public List<EstudianteEntity> leertodo() {
        List<EstudianteEntity> lista = new ArrayList<>();
        String SQL = "SELECT * FROM estudiante";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                EstudianteEntity re = new EstudianteEntity();
                re.setId_estudiante(rs.getInt("idestudiante"));
                re.setCodigo(rs.getInt("codigo"));
                re.setId_persona(rs.getInt("idpersona"));
                lista.add(re);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return lista;
    }

}
