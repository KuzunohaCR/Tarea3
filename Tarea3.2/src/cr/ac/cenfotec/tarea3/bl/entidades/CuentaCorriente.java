/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {
    }

    public CuentaCorriente(int idCliente, int numeroCuenta, int saldo) {
        super(idCliente, numeroCuenta, saldo);
    }

    public CuentaCorriente(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.idCliente = Integer.parseInt(datos[0]);
        this.numeroCuenta = Integer.parseInt(datos[1]);
        this.saldo = Integer.parseInt(datos[2]);
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + super.toString() + '}';
    }

    @Override
    public String toCSVLine() {
        return this.idCliente + "," + this.numeroCuenta + "," + this.saldo;
    }

}
