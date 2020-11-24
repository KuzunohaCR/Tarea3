/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Profesor extends Persona {

    private String tipoContrato;
    private LocalDate fechaContratacion;

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Profesor() {
    }

    public Profesor(String tipoContrato, LocalDate fechaContratacion, String nombre, String apellido, int identificacion) {
        super(nombre, apellido, identificacion);
        this.tipoContrato = tipoContrato;
        this.fechaContratacion = fechaContratacion;
    }
    
      public Profesor(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.tipoContrato = datos[0];
        this.fechaContratacion = LocalDate.parse(datos[1]);
        super.id = Integer.parseInt(datos[2]);
        this.nombre = datos[3];
        this.apellido = datos[4];
        this.identificacion = Integer.parseInt( datos[5]);
    }

    @Override
    public String toString() {
        return "Profesor{" + "tipoContrato=" + tipoContrato + ", fechaContratacion=" + fechaContratacion + super.toString() + '}';
    }

}
