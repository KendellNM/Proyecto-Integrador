/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ppp.dao;

import java.util.List;
import pe.edu.upeu.ppp.entity.UsuarioEntity;

/**
 *
 * @author USER
 */
public interface UsuarioDao {

    int createUsuario(UsuarioEntity u);

    int updateUsuario(UsuarioEntity u);

    int deleteUsuario(int id);

    UsuarioEntity readUsuario(int id);

    List<UsuarioEntity> readAll();
}
