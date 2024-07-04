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
import pe.edu.upeu.ppp.dao.UsuarioDao;
import pe.edu.upeu.ppp.entity.UsuarioEntity;

/**
 *
 * @author USER
 */
public class UsuarioDaoImpls implements UsuarioDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int createUsuario(UsuarioEntity u) {
        int x = 0;
        String SQL = "INSERT INTO usuario (id_usuario, usuario, clave, codigoderecuperacion, id_persona) VALUES (?, ?, ?, ?, ?)";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, u.getId_usuario());
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getClave());
            ps.setString(4, u.getCodigoderecuperacion());
            ps.setInt(5, u.getId_persona());
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int updateUsuario(UsuarioEntity u) {
        int x = 0;
        String SQL = "UPDATE usuario SET usuario = ?, clave = ?, codigo_de_recuperacion = ?, id_persona = ? WHERE id_usuario = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getClave());
            ps.setString(3, u.getCodigoderecuperacion());
            ps.setInt(4, u.getId_persona());
            ps.setInt(5, u.getId_usuario());
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int deleteUsuario(int id) {
        int x = 0;
        String SQL = "DELETE FROM usuario WHERE id_usuario = ?";

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
    public UsuarioEntity readUsuario(int id) {
        UsuarioEntity re = new UsuarioEntity();
        String SQL = "SELECT * FROM usuario WHERE id_usuario = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                re.setId_usuario(rs.getInt("id_usuario"));
                re.setUsuario(rs.getString("usuario"));
                re.setClave(rs.getString("clave"));
                re.setCodigoderecuperacion(rs.getString("codigo_de_recuperacion"));
                re.setId_persona(rs.getInt("id_persona"));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return re;
    }

    @Override
    public List<UsuarioEntity> readAll() {
        List<UsuarioEntity> lista = new ArrayList<>();
        String SQL = "SELECT * FROM usuario";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                UsuarioEntity re = new UsuarioEntity();
                re.setId_usuario(rs.getInt("id_usuario"));
                re.setUsuario(rs.getString("usuario"));
                re.setClave(rs.getString("clave"));
                re.setCodigoderecuperacion(rs.getString("codigo_de_recuperacion"));
                re.setId_persona(rs.getInt("id_persona"));
                lista.add(re);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return lista;
    }
}
