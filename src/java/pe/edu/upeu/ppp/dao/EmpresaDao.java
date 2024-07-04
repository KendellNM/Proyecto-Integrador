/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ppp.dao;

import java.util.List;
import pe.edu.upeu.ppp.entity.EmpresaEntity;

/**
 *
 * @author USER
 */
public interface EmpresaDao {

    int crearEmpresa(EmpresaEntity e);

    int actualizarEmpresa(EmpresaEntity e);

    int actualizarEmpresa(int id);

    EmpresaEntity leerEmpresa(int id);

    List<EmpresaEntity> leertodo();
}
