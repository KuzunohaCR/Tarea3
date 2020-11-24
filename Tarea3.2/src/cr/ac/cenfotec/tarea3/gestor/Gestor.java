/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.gestor;

import cr.ac.cenfotec.tarea3.bl.entidades.Cliente;
import cr.ac.cenfotec.tarea3.bl.entidades.Cuenta;
import cr.ac.cenfotec.tarea3.bl.entidades.CuentaAhorro;
import cr.ac.cenfotec.tarea3.bl.entidades.CuentaAhorroProgramado;
import cr.ac.cenfotec.tarea3.bl.entidades.CuentaCorriente;
import cr.ac.cenfotec.tarea3.bl.entidades.Deposito;
import cr.ac.cenfotec.tarea3.bl.entidades.Retiro;
import cr.ac.cenfotec.tarea3.dao.ClienteDAO;
import cr.ac.cenfotec.tarea3.dao.CuentaAhorroDAO;
import cr.ac.cenfotec.tarea3.dao.CuentaAhorroProgramadoDAO;
import cr.ac.cenfotec.tarea3.dao.CuentaCorrienteDAO;
import cr.ac.cenfotec.tarea3.dao.CuentaDAO;
import cr.ac.cenfotec.tarea3.dao.DepositoDAO;
import cr.ac.cenfotec.tarea3.dao.RetiroDAO;
import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private CuentaCorrienteDAO cuentaCorrienteDAO = new CuentaCorrienteDAO();
    private CuentaAhorroDAO cuentaAhorroDAO = new CuentaAhorroDAO();
    private CuentaAhorroProgramadoDAO cuentaAhorroProgramadoDAO = new CuentaAhorroProgramadoDAO();
    private DepositoDAO depositoDAO = new DepositoDAO();
    private RetiroDAO retiroDAO = new RetiroDAO();

    public boolean crearCliente(String nombre, int identificacion, String direccion) {
        Cliente nuevoCliente = new Cliente(nombre, identificacion, direccion);
        try {
            return this.clienteDAO.save(nuevoCliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Cliente> listClientes() {
        try {
            return this.clienteDAO.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Cliente>();
    }

    public List<Cuenta> encontrarCuentasPorID(int id) {
        List<Cuenta> cuentasDeCliente = new ArrayList<>();
        for (Cuenta cuenta : this.cuentaCorrienteDAO.findAll()) {
            if (cuenta.getIdCliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }
        for (Cuenta cuenta : this.cuentaAhorroDAO.findAll()) {
            if (cuenta.getIdCliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }
        for (Cuenta cuenta : this.cuentaAhorroProgramadoDAO.findAll()) {
            if (cuenta.getIdCliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }

        return cuentasDeCliente;
    }

    public List<Cuenta> encontrarCuentaCorrientePorID(int id) {
        ArrayList<Cuenta> cuentasDeCliente = new ArrayList<>();
        for (Cuenta cuenta : this.cuentaCorrienteDAO.findAll()) {
            if (cuenta.getIdCliente() == id) {
                cuentasDeCliente.add(cuenta);
            }
        }

        return cuentasDeCliente;
    }

    public void crearCuenta(int id, int numero, int saldo, int tipo) {
        if (tipo == 1) {
            Cuenta nuevaCuenta = new CuentaCorriente(id, numero, saldo);
            cuentaCorrienteDAO.save(nuevaCuenta);
        }
        if (tipo == 2) {
            Cuenta nuevaCuenta = new CuentaAhorro(id, numero, saldo);
            cuentaAhorroDAO.save(nuevaCuenta);
        }
        if (tipo == 3) {
            Cuenta nuevaCuenta = new CuentaAhorroProgramado(id, numero, saldo);
            cuentaAhorroProgramadoDAO.save(nuevaCuenta);
        }
    }

    /*  public void crearCuentaAsociada(int id, int numero, int saldo, Cuenta cuentaAsociada) {
        Cuenta nuevaCuenta = new CuentaAhorroProgramado(id, numero, saldo, cuentaAsociada);
        cuentaAhorroDAO.save(nuevaCuenta);
    }*/
    private CuentaDAO determinarObjetoDAO(Cuenta nuevaCuenta) throws Exception {
        if (nuevaCuenta instanceof CuentaAhorro) {
            return new CuentaAhorroDAO();
        }
        if (nuevaCuenta instanceof CuentaAhorroProgramado) {
            return new CuentaAhorroProgramadoDAO();
        }
        if (nuevaCuenta instanceof CuentaCorriente) {
            return new CuentaCorrienteDAO();
        }
        throw new Exception("Tipo de Material Desconocido");
    }

    public List<Cuenta> listAll(Cuenta nuevaCuenta) {
        try {
            CuentaDAO objPersistente = determinarObjetoDAO(nuevaCuenta);
            return objPersistente.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Cuenta>();
    }

    public boolean crearDeposito(String fecha, String descripcion, int monto, int opcionCliente, int opcionCuenta) {
        Deposito nuevoDeposito = new Deposito(opcionCliente, opcionCuenta, fecha, descripcion, monto);
        try {
            return this.depositoDAO.save(nuevoDeposito);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Deposito> listDeposito() {
        try {
            return this.depositoDAO.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Deposito>();
    }

    public boolean crearRetiro(String fecha, String descripcion, int monto, int opcionCliente, int opcionCuenta) {
        Retiro nuevoRetiro = new Retiro(opcionCliente, opcionCuenta, fecha, descripcion, monto);
        try {
            return this.retiroDAO.save(nuevoRetiro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Retiro> listRetiro() {
        try {
            return this.retiroDAO.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Retiro>();
    }
    
}
