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
import pe.edu.upeu.ppp.dao.LoginDTODao;
import pe.edu.upeu.ppp.dto.LoginDTO;

/**
 *
 * @author USER
 */
public class LoginDTOImpls implements LoginDTODao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public List<LoginDTO> login(String usuario, String contrasena) {
        List<LoginDTO> lista = new ArrayList<>();

        String sql = "SELECT u.idusuario, u.username, u.estado, r.nombre as rol, p.nombre as menu, p.url, p.icono FROM usuario u "
                + "inner join empleado e on u.idempleado = e.idempleado "
                + "inner join rol r on u.idrol=r.idrol "
                + "inner join rol_privilegios rp on r.idrol = rp.idrol "
                + "inner join privilegios p on rp.idprivilegio = p.idprivilegio "
                + "where u.username = ? and u.clave = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();

            while (rs.next()) {

                LoginDTO ld = new LoginDTO();

                if (rs.getString("estado").equals("0")) {
                    System.out.println("Bloqueado");
                    return lista;
                }

                ld.setId_usuario(rs.getInt("idusuario"));
                ld.setNombre(rs.getString("nombre_1"));
                ld.setApellido(rs.getString("apepat"));
                ld.setSexo(rs.getString("sexo"));
                ld.setMenu(rs.getString("menu"));
                ld.setRol(rs.getString("rol"));
                ld.setURL(rs.getString("url"));
                ld.setIcon(rs.getString("icono"));
                ld.setEstado(rs.getString("estado"));

                lista.add(ld);
            }
        } catch (Exception e) {
            System.out.println("Consulta: " + e);
        }

        return lista;
    }

    @Override
    public boolean actualizarestado(String usuario, String estado) {
        String sql = "UPDATE usuario SET estado = ? WHERE username = ?";
        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setString(2, usuario);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar estado: " + e.getMessage());
        }

        return true;
    }

}
