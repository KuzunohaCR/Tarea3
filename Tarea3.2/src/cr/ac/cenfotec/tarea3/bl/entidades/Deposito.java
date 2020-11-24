/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

import java.time.LocalDate;

public class Deposito extends MovimientoBancario {


    public Deposito() {
    }

    public Deposito(int idCliente, int idCuenta, String fecha, String descripcion, int monto) {
        super(idCliente, idCuenta, fecha, descripcion, monto);
    } 

    public Deposito(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.idCliente = Integer.parseInt(datos[0]);
        this.idCuenta = Integer.parseInt(datos[1]);
        this.fecha = datos[2];
        this.descripcion = datos[3];
        this.monto = Integer.parseInt(datos[4]);
    }

    @Override
    public String toString() {
        return "Deposito{" + super.toString() + '}';
    }

    public String toCSVLine() {
         return this.idCliente + "," + this.idCuenta + "," + this.fecha + "," +  this.descripcion + "," +  this.monto;
    }

}
