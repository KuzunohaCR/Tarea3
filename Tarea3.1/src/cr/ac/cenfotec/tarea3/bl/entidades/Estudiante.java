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

public class Estudiante extends Persona {

    private String carrera;
    private int creditosMatriculados;

    public String getCarrera() {
        return carrera;
    }

    public int getCreditosMatriculados() {
        return creditosMatriculados;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setCreditosMatriculados(int creditosMatriculados) {
        this.creditosMatriculados = creditosMatriculados;
    }

    public Estudiante() {
    }

    public Estudiante(String carrera, int creditosMatriculados, String nombre, String apellido, int identificacion) {
        super(nombre, apellido, identificacion);
        this.carrera = carrera;
        this.creditosMatriculados = creditosMatriculados;
    }

    public Estudiante(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.carrera = datos[0];
        this.creditosMatriculados = Integer.parseInt(datos[1]);
        super.id = Integer.parseInt(datos[2]);
        this.nombre = datos[3];
        this.apellido = datos[4];
        this.identificacion = Integer.parseInt(datos[5]);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carrera=" + carrera + ", creditosMatriculados=" + creditosMatriculados + super.toString() + '}';
    }

}
