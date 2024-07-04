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
import pe.edu.upeu.ppp.dao.EmpresaDao;
import pe.edu.upeu.ppp.entity.EmpresaEntity;

/**
 *
 * @author USER
 */
public class EmpresaDaoImpls implements EmpresaDao {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int crearEmpresa(EmpresaEntity e) {
        int x = 0;
        String SQL = "INSERT INTO empresa (id_empresa, razon_social, direccion, sector, tipo_de_vinculacion, ano_de_vinculacion, representante, RUC, telefono, id_estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, e.getId_empresa());
            ps.setString(2, e.getRazon_social());
            ps.setString(3, e.getDireccion());
            ps.setString(4, e.getSector());
            ps.setString(5, e.getTipo_de_vinculacion());
            ps.setInt(6, e.getAno_de_vinculacion());
            ps.setString(7, e.getRepresentante());
            ps.setString(8, e.getRUC());
            ps.setString(9, e.getTelefono());
            ps.setInt(10, e.getId_estado());
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int actualizarEmpresa(EmpresaEntity e) {
        int x = 0;
        String SQL = "UPDATE empresa SET razon_social = ?, direccion = ?, sector = ?, tipo_de_vinculacion = ?, ano_de_vinculacion = ?, representante = ?, RUC = ?, telefono = ?, id_estado = ? WHERE id_empresa = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, e.getRazon_social());
            ps.setString(2, e.getDireccion());
            ps.setString(3, e.getSector());
            ps.setString(4, e.getTipo_de_vinculacion());
            ps.setInt(5, e.getAno_de_vinculacion());
            ps.setString(6, e.getRepresentante());
            ps.setString(7, e.getRUC());
            ps.setString(8, e.getTelefono());
            ps.setInt(9, e.getId_estado());
            ps.setInt(10, e.getId_empresa());
            x = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return x;
    }

    @Override
    public int actualizarEmpresa(int id) {
        int x = 0;
        String SQL = "DELETE FROM empresa WHERE id_empresa = ?";

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
    public EmpresaEntity leerEmpresa(int id) {
        EmpresaEntity re = new EmpresaEntity();
        String SQL = "SELECT * FROM empresa WHERE id_empresa = ?";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                re.setId_empresa(rs.getInt("id_empresa"));
                re.setRazon_social(rs.getString("razon_social"));
                re.setDireccion(rs.getString("direccion"));
                re.setSector(rs.getString("sector"));
                re.setTipo_de_vinculacion(rs.getString("tipo_de_vinculacion"));
                re.setAno_de_vinculacion(rs.getInt("ano_de_vinculacion"));
                re.setRepresentante(rs.getString("representante"));
                re.setRUC(rs.getString("RUC"));
                re.setTelefono(rs.getString("telefono"));
                re.setId_estado(rs.getInt("id_estado"));
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return re;
    }

    @Override
    public List<EmpresaEntity> leertodo() {
        List<EmpresaEntity> lista = new ArrayList<>();
        String SQL = "SELECT * FROM empresa";

        try {
            cx = Conexion.getConnection();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                EmpresaEntity re = new EmpresaEntity();
                re.setId_empresa(rs.getInt("id_empresa"));
                re.setRazon_social(rs.getString("razon_social"));
                re.setDireccion(rs.getString("direccion"));
                re.setSector(rs.getString("sector"));
                re.setTipo_de_vinculacion(rs.getString("tipo_de_vinculacion"));
                re.setAno_de_vinculacion(rs.getInt("ano_de_vinculacion"));
                re.setRepresentante(rs.getString("representante"));
                re.setRUC(rs.getString("RUC"));
                re.setTelefono(rs.getString("telefono"));
                re.setId_estado(rs.getInt("id_estado"));
                lista.add(re);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        return lista;
    }

}
