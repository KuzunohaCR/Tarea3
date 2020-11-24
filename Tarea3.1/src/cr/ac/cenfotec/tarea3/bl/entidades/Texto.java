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

public class Texto extends Material {

    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
    private int paginas;

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Texto() {
    }

    public Texto(String titulo, String nombreAutor, LocalDate fechaPublicacion, int paginas, LocalDate fechaCompra, boolean restringido, String tema, String idioma) {
        super(fechaCompra, restringido, tema, idioma);
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
        this.paginas = paginas;
    }

    public Texto(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.titulo = datos[0];
        this.nombreAutor = datos[1];
        this.fechaCompra = LocalDate.parse(datos[2]);
        this.paginas = Integer.parseInt(datos[3]);
        super.signatura = Integer.parseInt(datos[4]);
        this.fechaCompra = LocalDate.parse(datos[5]);
        this.restringido = Boolean.parseBoolean(datos[6]);
        this.tema = datos[7];
        this.idioma = datos[8];
    }

    @Override
    public String toString() {
        return "Texto{" + "titulo=" + titulo + ", nombreAutor=" + nombreAutor + ", fechaPublicacion=" + fechaPublicacion + ", paginas=" + paginas + super.toString() + '}';
    }

}
