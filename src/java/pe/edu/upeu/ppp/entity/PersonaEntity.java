/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ppp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author USER
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEntity {

    private int id_persona;
    private String nombre_1;
    private String nombre_2;
    private String nombre_3;
    private String nombre_4;
    private String apepat;
    private String apemat;
    private String DNI;
    private String telefono;
    private String correo_electronico;

}
