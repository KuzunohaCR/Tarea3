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

public class Audio extends Material {

    private String formato;
    private String duracion;

    public String getDuracion() {
        return duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Audio() {
    }

    public Audio(String formato, String duracion, LocalDate fechaCompra, boolean restringido, String tema, String idioma) {
        super(fechaCompra, restringido, tema, idioma);
        this.formato = formato;
        this.duracion = duracion;
    }

    public Audio(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.formato = datos[0];
        this.duracion = datos[1];
        super.signatura = Integer.parseInt(datos[2]);
        this.fechaCompra = LocalDate.parse(datos[3]);
        this.restringido = Boolean.parseBoolean(datos[4]);
        this.tema = datos[5];
        this.idioma = datos[6];
    }

    @Override
    public String toString() {
        return "Audio{" + "formato=" + formato + ", duracion=" + duracion + super.toString() + '}';
    }

}
