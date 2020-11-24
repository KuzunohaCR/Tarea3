/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

public class CuentaAhorroProgramado extends Cuenta {


    public CuentaAhorroProgramado() {
    }

    public CuentaAhorroProgramado(int idCliente, int numeroCuenta, int saldo/*, Cuenta cuentaAsociada*/) {
        super(idCliente, numeroCuenta, saldo);
       // this.cuentaAsociada = cuentaAsociada;
    }

    public CuentaAhorroProgramado(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.idCliente = Integer.parseInt(datos[0]);
        this.numeroCuenta = Integer.parseInt(datos[1]);
        this.saldo = Integer.parseInt(datos[2]);
       // this.cuentaAsociada.numeroCuenta = Integer.parseInt(datos[3]);
    }

    @Override
    public String toString() {
        return "CuentaAhorroProgramado{" + "cuentaAsociada=" + /*cuentaAsociada +*/ super.toString() + '}';
    }

    @Override
    public String toCSVLine() {
        return this.idCliente + "," + this.numeroCuenta + "," + this.saldo + "," /*+ this.cuentaAsociada.numeroCuenta*/;
    }

}
