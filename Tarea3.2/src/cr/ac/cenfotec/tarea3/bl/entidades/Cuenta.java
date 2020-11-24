/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.bl.entidades;

import cr.ac.cenfotec.tarea3.interfaces.SerializacionCSV;

public abstract class Cuenta implements SerializacionCSV {
    
    protected int idCliente;
    protected int numeroCuenta;
    protected int saldo;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Cuenta() {
    }

    public Cuenta(int idCliente, int numeroCuenta, int saldo) {
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCliente=" + idCliente + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }


}
