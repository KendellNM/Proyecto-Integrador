/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ppp.dao;

import java.util.List;
import pe.edu.upeu.ppp.entity.UsuarioRolEntity;

/**
 *
 * @author USER
 */
public interface UsuarioRolDao {

    int crearUsuarioRol(UsuarioRolEntity u);

    int actualizarUsuarioRol(UsuarioRolEntity u);

    int eliminarUsuarioRol(int id);

    UsuarioRolEntity leerUsuarioRol(int id);

    List<UsuarioRolEntity> leerTodo();
}
