/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

import java.time.LocalDate;

public  class Material  {
    
    protected static int numSignatura = 0;

    protected int signatura;
    protected LocalDate fechaCompra;
    protected boolean restringido;
    protected String tema;
    protected String idioma;

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getSignatura() {
        return this.signatura;
    }

    public String getTema() {
        return tema;
    }

    public boolean isRestringido() {
        return restringido;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setRestringido(boolean restringido) {
        this.restringido = restringido;
    }

    public void setSignatura(int signatura) {
        this.signatura = signatura;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Material() {
    }

    public Material(LocalDate fechaCompra, boolean restringido, String tema, String idioma) {
        this.signatura = numSignatura++;
        this.fechaCompra = fechaCompra;
        this.restringido = restringido;
        this.tema = tema;
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Material{" + "signatura=" + signatura + ", fechaCompra=" + fechaCompra + ", restringido=" + restringido + ", tema=" + tema + ", idioma=" + idioma + '}';
    }

   
}
