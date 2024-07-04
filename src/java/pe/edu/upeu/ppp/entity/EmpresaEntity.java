/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ppp.entity;

import java.util.Date;
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
public class EmpresaEntity {

    private int id_empresa;
    private String razon_social;
    private String direccion;
    private String sector;
    private String tipo_de_vinculacion;
    private Date ano_de_vinculacion;
    private String representante;
    private String RUC;
    private String telefono;
    private int id_estado;

}
