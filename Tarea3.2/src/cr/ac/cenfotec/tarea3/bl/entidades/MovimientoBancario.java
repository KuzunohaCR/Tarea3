/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

import java.time.LocalDate;

public class MovimientoBancario {

    protected int idCliente;
    protected int idCuenta;
    protected String fecha;
    protected String descripcion;
    protected int monto;

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public int getMonto() {
        return monto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public MovimientoBancario() {
    }

    public MovimientoBancario(int idCliente, int idCuenta, String fecha, String descripcion, int monto) {
        this.idCliente = idCliente;
        this.idCuenta = idCuenta;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "MovimientoBancario{" + "idCliente=" + idCliente + ", idCuenta=" + idCuenta + ", fecha=" + fecha + ", descripcion=" + descripcion + ", monto=" + monto + '}';
    }

    public String toCSVLine() {
        return this.idCliente + "," + this.idCuenta + "," + this.fecha + "," + this.descripcion + "," + this.monto;
    }

}
