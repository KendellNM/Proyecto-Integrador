/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ppp.test;

import com.google.gson.Gson;
import pe.edu.upeu.ppp.config.Conexion;
import pe.edu.upeu.ppp.dao.LoginDTODao;
import pe.edu.upeu.ppp.dao.UsuarioDao;
import pe.edu.upeu.ppp.daoImpls.LoginDTOImpls;
import pe.edu.upeu.ppp.daoImpls.UsuarioDaoImpls;
import pe.edu.upeu.ppp.entity.UsuarioEntity;

/**
 *
 * @author USER
 */
public class test {

    static UsuarioDao udao = new UsuarioDaoImpls();
    static LoginDTODao loginudao = new LoginDTOImpls();
    static Gson g = new Gson();

    public static void main(String[] args) {
        if (Conexion.getConnection() != null) {
            System.out.println("Conectado");

        } else {
            System.out.println("Error");
        }

        //System.out.println(g.toJson(udao.createUsuario(new UsuarioEntity(0, "vamos.jalar", "524", "458", 4))));
        System.out.println(g.toJson(loginudao.login("vamos.jalar", "524")));

    }
}
