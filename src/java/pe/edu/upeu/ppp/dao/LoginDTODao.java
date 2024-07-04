/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ppp.dao;

import java.util.List;
import pe.edu.upeu.ppp.dto.LoginDTO;

/**
 *
 * @author USER
 */
public interface LoginDTODao {

    public List<LoginDTO> login(String usuario, String contrasena);

    public boolean actualizarestado(String usuario, String estado);
}
