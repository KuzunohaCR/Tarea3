/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {

    private Persona personas;
    private ArrayList<Material> materiales;
    private LocalDate retorno;

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public Persona getPersonas() {
        return personas;
    }

    public LocalDate getRetorno() {
        return retorno;
    }

    public void setMateriales(ArrayList<Material> materiales) {
        this.materiales = materiales;
    }

    public void setPersonas(Persona personas) {
        this.personas = personas;
    }

    public void setRetorno(LocalDate retorno) {
        this.retorno = retorno;
    }

    public Prestamo() {
    }

    public Prestamo(Persona personas, ArrayList<Material> materiales, LocalDate retorno) {
        this.personas = personas;
        this.materiales = materiales;
        this.retorno = retorno;
    }
    

    @Override
    public String toString() {
        return "Prestamo{" + "personas=" + personas + ", materiales=" + materiales + ", retorno=" + retorno + '}';
    }

}
