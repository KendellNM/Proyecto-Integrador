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
import pe.edu.upeu.ppp.dao.UsuarioRolDao;
import pe.edu.upeu.ppp.entity.RolEntity;
import pe.edu.upeu.ppp.entity.UsuarioRolEntity;

/**
 *
 * @author USER
 */
public class UsuarioRolDaoImpls implements UsuarioRolDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int crearUsuarioRol(UsuarioRolEntity u) {
        int filas = 0;
        String SQL = "INSERT INTO usuario_rol (id_usuario_rol, id_usuario, id_rol) VALUES (?, ?, ?)";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, u.getId_usuario_rol());
            ps.setInt(2, u.getId_usuario());
            ps.setInt(3, u.getId_rol());
            filas = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return filas;
    }

    @Override
    public int actualizarUsuarioRol(UsuarioRolEntity u) {
        int filas = 0;
        String SQL = "UPDATE usuario_rol SET id_usuario = ?, id_rol = ? WHERE id_usuario_rol = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, u.getId_usuario());
            ps.setInt(2, u.getId_rol());
            ps.setInt(3, u.getId_usuario_rol());
            filas = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return filas;
    }

    @Override
    public int eliminarUsuarioRol(int id) {
        int x = 0;
        String SQL = "DELETE FROM rol WHERE id_usuario_rol=?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);

            x = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return x;
    }

    @Override
    public UsuarioRolEntity leerUsuarioRol(int id) {
        UsuarioRolEntity re = new UsuarioRolEntity();

        String SQL = "SELECT *FROM rol WHERE id_usuario_rol=?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                re.setId_usuario_rol(rs.getInt("id_usuario_rol"));
                re.setId_usuario(rs.getInt("id_usuario"));
                re.setId_rol(rs.getInt("id_rol"));

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return re;
    }

    @Override
    public List<UsuarioRolEntity> leerTodo() {
        List<UsuarioRolEntity> lista = new ArrayList<>();
        String SQL = "SELECT *FROM rol";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                UsuarioRolEntity re = new UsuarioRolEntity();
                re.setId_usuario_rol(rs.getInt("id_usuario_rol"));
                re.setId_usuario(rs.getInt("id_usuario"));
                re.setId_rol(rs.getInt("id_rol"));
                lista.add(re);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return lista;
    }

}
