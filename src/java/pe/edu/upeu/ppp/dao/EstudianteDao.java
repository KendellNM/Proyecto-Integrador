/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ppp.dao;

import java.util.List;
import pe.edu.upeu.ppp.entity.EstudianteEntity;

/**
 *
 * @author USER
 */
public interface EstudianteDao {
    
    
    int crearEstudiante(EstudianteEntity e);

    int actualizarEstudiante(EstudianteEntity e);

    int eliminarEstudiante(int id);

    EstudianteEntity leerEstudiante(int id);

    List<EstudianteEntity> leertodo();
}
