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
import pe.edu.upeu.ppp.dao.PersonaDao;
import pe.edu.upeu.ppp.entity.PersonaEntity;

/**
 *
 * @author USER
 */
public class PersonaDaoImpls implements PersonaDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int crearPersona(PersonaEntity p) {
        int x = 0;
        String SQL = "INSERT INTO persona (id_persona, PRIMER_NOMBRE, SEGUNDO_NOMBRE, TERCER_NOMBRE, CUARTO_NOMBRE, apepat, apemat, DNI, telefono, correo_electronico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, p.getId_persona());
            ps.setString(2, p.getNombre_1());
            ps.setString(3, p.getNombre_2());
            ps.setString(4, p.getNombre_3());
            ps.setString(5, p.getNombre_4());
            ps.setString(6, p.getApepat());
            ps.setString(7, p.getApemat());
            ps.setString(8, p.getDNI());
            ps.setString(9, p.getTelefono());
            ps.setString(10, p.getCorreo_electronico());
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int actualizarPersona(PersonaEntity p) {
        int x = 0;
        String SQL = "UPDATE persona SET PRIMER_NOMBRE = ?, SEGUNDO_NOMBRE = ?, TERCER_NOMBRE = ?, CUARTO_NOMBRE = ?, apepat = ?, apemat = ?, DNI = ?, telefono = ?, correo_electronico = ? WHERE id_persona = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, p.getNombre_1());
            ps.setString(2, p.getNombre_2());
            ps.setString(3, p.getNombre_3());
            ps.setString(4, p.getNombre_4());
            ps.setString(5, p.getApepat());
            ps.setString(6, p.getApemat());
            ps.setString(7, p.getDNI());
            ps.setString(8, p.getTelefono());
            ps.setString(9, p.getCorreo_electronico());
            ps.setInt(10, p.getId_persona());
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int eliminarPersona(int id) {
        int x = 0;
        String SQL = "DELETE FROM persona WHERE id_persona = ?";

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
    public PersonaEntity leerPersona(int id) {
        PersonaEntity re = new PersonaEntity();
        String SQL = "SELECT * FROM persona WHERE id_persona = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                re.setId_persona(rs.getInt("id_persona"));
                re.setNombre_1(rs.getString("PRIMER_NOMBRE"));
                re.setNombre_2(rs.getString("SEGUNDO_NOMBRE"));
                re.setNombre_3(rs.getString("TERCER_NOMBRE"));
                re.setNombre_4(rs.getString("CUARTO_NOMBRE"));
                re.setApepat(rs.getString("apepat"));
                re.setApemat(rs.getString("apemat"));
                re.setDNI(rs.getString("DNI"));
                re.setTelefono(rs.getString("telefono"));
                re.setCorreo_electronico(rs.getString("correo_electronico"));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return re;
    }

    @Override
    public List<PersonaEntity> leertodo() {
        List<PersonaEntity> lista = new ArrayList<>();
        String SQL = "SELECT * FROM persona";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                PersonaEntity re = new PersonaEntity();
                re.setId_persona(rs.getInt("id_persona"));
                re.setNombre_1(rs.getString("PRIMER_NOMBRE"));
                re.setNombre_2(rs.getString("SEGUNDO_NOMBRE"));
                re.setNombre_3(rs.getString("TERCER_NOMBRE"));
                re.setNombre_4(rs.getString("CUARTO_NOMBRE"));
                re.setApepat(rs.getString("apepat"));
                re.setApemat(rs.getString("apemat"));
                re.setDNI(rs.getString("DNI"));
                re.setTelefono(rs.getString("telefono"));
                re.setCorreo_electronico(rs.getString("correo_electronico"));
                lista.add(re);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return lista;
    }

}
