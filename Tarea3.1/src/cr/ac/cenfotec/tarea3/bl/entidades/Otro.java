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

public class Otro extends Material {

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Otro() {
    }

    public Otro(String descripcion, LocalDate fechaCompra, boolean restringido, String tema, String idioma) {
        super(fechaCompra, restringido, tema, idioma);
        this.descripcion = descripcion;
    }

    public Otro(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.descripcion = datos[0];
        super.signatura = Integer.parseInt(datos[1]);
        this.fechaCompra = LocalDate.parse(datos[2]);
        this.restringido = Boolean.parseBoolean(datos[3]);
        this.tema = datos[4];
        this.idioma = datos[5];
    }

    @Override
    public String toString() {
        return "Otro{" + "descripcion=" + descripcion + super.toString() + '}';
    }

}
