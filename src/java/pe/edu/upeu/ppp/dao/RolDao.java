/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ppp.dao;

import java.util.List;
import pe.edu.upeu.ppp.entity.RolEntity;

/**
 *
 * @author USER
 */
public interface RolDao {

    int createRol(RolEntity r);

    int updateRol(RolEntity r);

    int deleteRol(int id);

    RolEntity readRol(int id);

    List<RolEntity> readAll();
}
