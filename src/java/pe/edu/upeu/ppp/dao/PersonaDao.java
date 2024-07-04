/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ppp.dao;

import java.util.List;
import pe.edu.upeu.ppp.entity.PersonaEntity;

/**
 *
 * @author USER
 */
public interface PersonaDao {

    int crearPersona(PersonaEntity p);

    int actualizarPersona(PersonaEntity p);

    int eliminarPersona(int id);

    PersonaEntity leerPersona(int id);

    List<PersonaEntity> leertodo();
}
