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

public class Video extends Material {

    private String formato;
    private String duracion;
    private String director;

    public String getDirector() {
        return director;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Video() {
    }

    public Video(String formato, String duracion, String director, LocalDate fechaCompra, boolean restringido, String tema, String idioma) {
        super(fechaCompra, restringido, tema, idioma);
        this.formato = formato;
        this.duracion = duracion;
        this.director = director;
    }

    public Video(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.formato = datos[0];
        this.duracion = datos[1];
        this.director = datos[2];
        super.signatura = Integer.parseInt(datos[3]);
        this.fechaCompra = LocalDate.parse(datos[4]);
        this.restringido = Boolean.parseBoolean(datos[5]);
        this.tema = datos[6];
        this.idioma = datos[7];
    }

    @Override
    public String toString() {
        return "Video{" + "formato=" + formato + ", duracion=" + duracion + ", director=" + director + super.toString() + '}';
    }

}
