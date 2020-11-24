/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

public class CuentaAhorro extends Cuenta {
    
    private final double interes = 0.7;

    public double getInteres() {
        return interes;
    }

    public CuentaAhorro() {
    }

    public CuentaAhorro(int idCliente, int numeroCuenta, int saldo) {
        super(idCliente, numeroCuenta, saldo);
    }

    public CuentaAhorro(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.idCliente = Integer.parseInt(datos[0]);
        this.numeroCuenta = Integer.parseInt(datos[1]);
        this.saldo = Integer.parseInt(datos[2]);
    }

    @Override
    public String toCSVLine() {
        return this.idCliente + "," + this.numeroCuenta + "," + this.saldo + "," + getInteres();
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" + "interes=" + interes + super.toString() + '}';
    }

}
