/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.controlador;

import cr.ac.cenfotec.tarea3.bl.entidades.Cliente;
import cr.ac.cenfotec.tarea3.bl.entidades.Cuenta;
import cr.ac.cenfotec.tarea3.bl.entidades.CuentaCorriente;
import cr.ac.cenfotec.tarea3.bl.entidades.Deposito;
import cr.ac.cenfotec.tarea3.bl.entidades.Retiro;
import cr.ac.cenfotec.tarea3.dao.CuentaCorrienteDAO;
import cr.ac.cenfotec.tarea3.gestor.Gestor;
import cr.ac.cenfotec.tarea3.ui.UI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controlador {

    UI interfaz = new UI();
    Gestor gestor = new Gestor();

    public void mostrarMenu() {
        int opcion = 0;
        do {
            interfaz.mostrarMenu();
            opcion = interfaz.leerEntero();
            procesarOpcionMenu(opcion);
        } while (opcion != 5);
    }

    private void procesarOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
                crearCliente();
                break;
            case 2:
                listarCliente();
                break;
            case 3:
                ejecutarDeposito();
                break;
            case 4:
                ejecutarRetiro();
                break;
            case 5:
                break;
            default:
                interfaz.mostrarMensaje("Opcion invalida");
        }
    }

    private void crearCliente() {
        Cliente nuevo = new Cliente();
        interfaz.mostrarMensaje("Escriba el nombre del cliente");
        String nombre = interfaz.leerTexto();
        int length = 0;
        int identificacion = 0;
        boolean error = false;
        do {
            interfaz.mostrarMensaje("Ingrese el numero de identificacion");
            interfaz.mostrarMensaje("Debe contener 7 digitos");
            identificacion = interfaz.leerEntero();
            length = String.valueOf(identificacion).length();
            for (Cliente nuevoCliente : gestor.listClientes()) {
                if (nuevoCliente.getIdentificacion() == identificacion) {
                    error = true;
                    interfaz.mostrarMensaje("Numero de identificacion ya registrado");
                } else {
                    error = false;
                }
            }
        } while (length != 7 || error == true);
        interfaz.mostrarMensaje("Escriba la direccion");
        String direccion = interfaz.leerTexto();
        gestor.crearCliente(nombre, identificacion, direccion);
        crearCuenta(identificacion);
    }

    private void listarCliente() {
        List<Cliente> clientes = gestor.listClientes();
        interfaz.mostrarMensaje(clientes.toString());
        List<Deposito> depositos = gestor.listDeposito();
        interfaz.mostrarMensaje(depositos.toString());
        List<Retiro> retiros = gestor.listRetiro();
        interfaz.mostrarMensaje(retiros.toString());
    }

    private void crearCuenta(int identificacion) {
        int seguir = 0;
        do {
            int ID = identificacion;
            interfaz.mostrarMensaje("Escriba el número de cuenta");
            int numero = interfaz.leerEntero();
            int saldo = 0;
            interfaz.mostrarMensaje("Elija el tipo de cuenta:");
            interfaz.mostrarTipoCuenta();
            int opcion = interfaz.leerEntero();
            determinarTipoCuenta(opcion, ID, numero, saldo);

            interfaz.mostrarMensaje("¿Desear registrar otra cuenta?");
            interfaz.mostrarMensaje("1. Sí");
            interfaz.mostrarMensaje("2. No");
            seguir = interfaz.leerEntero();
        } while (seguir != 2);
    }

    private void determinarTipoCuenta(int opcion, int id, int numero, int saldo) {
        switch (opcion) {
            // Cuenta Corriente
            case 1:
                do {
                    interfaz.mostrarMensaje("Digite su depósito inicial (debe ser mayor a 50 mil colones):");
                    saldo = interfaz.leerEntero();
                    if (saldo >= 50000) {
                        gestor.crearCuenta(id, numero, saldo, opcion);
                    }
                } while (saldo < 50000);
                break;
            // Cuenta Ahorro
            case 2:
                interfaz.mostrarMensaje("Digite su depósito inicial (debe ser mayor a 50 mil colones):");
                saldo = interfaz.leerEntero();
                if (saldo >= 50000) {
                    gestor.crearCuenta(id, numero, saldo, opcion);
                }
                break;
            case 3:
                // Listar Cuentas Corrientes
                List<Cuenta> cuentasCorrientes = gestor.encontrarCuentaCorrientePorID(id);
                for (Cuenta cuenta
                        : cuentasCorrientes) {
                    interfaz.mostrarMensaje(cuenta.toString());
                }

                if (cuentasCorrientes.isEmpty()) {
                    interfaz.mostrarMensaje("No hay cuentas asociadas");
                } else {
                    interfaz.mostrarMensaje("Escriba el número de cuenta de la cuenta corriente asociada a su nueva cuenta de ahorro programado:");
                    int numero_cuenta = interfaz.leerEntero();
                    Cuenta cuentaAsociada = new CuentaCorriente();
                    for (Cuenta cuenta
                            : cuentasCorrientes) {
                        if (cuenta.getNumeroCuenta() == numero_cuenta) {
                            cuentaAsociada = cuenta;
                        }
                    }
                    if (cuentaAsociada != null) {
                        saldo = cuentaAsociada.getSaldo();
                        gestor.crearCuenta(id, numero, saldo, opcion);
                    } else {
                        interfaz.mostrarMensaje("Número de cuenta inválido");
                    }
                }
                break;
        }
    }

    private void ejecutarDeposito() {

        Cuenta cuentaSeleccionada = null;
        String fecha = fecha();
        interfaz.mostrarMensaje("Descripcion del deposito");
        String descripcion = interfaz.leerTexto();

        interfaz.mostrarMensaje("Seleccione un cliente");
        for (Cliente unCliente : gestor.listClientes()) {

            interfaz.mostrarMensaje(String.valueOf(unCliente.getIdentificacion()));
        }
        int opcionCliente = interfaz.leerEntero();

        interfaz.mostrarMensaje("Seleccione una cuenta");
        for (Cuenta unaCuenta : gestor.encontrarCuentasPorID(opcionCliente)) {
            interfaz.mostrarMensaje(String.valueOf(unaCuenta.getNumeroCuenta()));

        }

        int opcionCuenta = interfaz.leerEntero();

        for (Cuenta unaCuenta : gestor.encontrarCuentasPorID(opcionCliente)) {
            if (unaCuenta.getNumeroCuenta() == opcionCuenta) {
                cuentaSeleccionada = unaCuenta;
            }
        }

        interfaz.mostrarMensaje("Ingrese la cantidad de dinero que va a depositar");
        int deposito = interfaz.leerEntero();
        cuentaSeleccionada.setSaldo(cuentaSeleccionada.getSaldo() + deposito);
        int monto = cuentaSeleccionada.getSaldo();
        gestor.crearDeposito(fecha, descripcion, deposito, opcionCliente, opcionCuenta);
        /*if (cuentaSeleccionada instanceof CuentaCorriente) {
            CuentaCorrienteDAO dao = new CuentaCorrienteDAO();
            dao.save(cuentaSeleccionada);

        }*/
        interfaz.mostrarMensaje("Deposito exitoso");

    }

    public String fecha() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String fecha = now.format(dtf);
        return fecha;
    }

    private void ejecutarRetiro() {
        Cuenta cuentaSeleccionada = null;
        String fecha = fecha();
        interfaz.mostrarMensaje("Descripcion del retiro");
        String descripcion = interfaz.leerTexto();

        interfaz.mostrarMensaje("Seleccione un cliente");
        for (Cliente unCliente : gestor.listClientes()) {

            interfaz.mostrarMensaje(String.valueOf(unCliente.getIdentificacion()));
        }
        int opcionCliente = interfaz.leerEntero();

        interfaz.mostrarMensaje("Seleccione una cuenta");
        for (Cuenta unaCuenta : gestor.encontrarCuentasPorID(opcionCliente)) {
            interfaz.mostrarMensaje(String.valueOf(unaCuenta.getNumeroCuenta()));

        }

        int opcionCuenta = interfaz.leerEntero();

        for (Cuenta unaCuenta : gestor.encontrarCuentasPorID(opcionCliente)) {
            if (unaCuenta.getNumeroCuenta() == opcionCuenta) {
                cuentaSeleccionada = unaCuenta;
            }
        }
        int retiro = 0;
        boolean error = false;
        do {
            interfaz.mostrarMensaje("Ingrese la cantidad de dinero");
            retiro = interfaz.leerEntero();
            if (cuentaSeleccionada.getSaldo() <= retiro) {
                interfaz.mostrarMensaje("No tiene suficiente saldo");
                error = true;
            }

            if (cuentaSeleccionada.getSaldo() >= retiro) {
                cuentaSeleccionada.setSaldo(cuentaSeleccionada.getSaldo() - retiro);
                error = false;
            }

            if (cuentaSeleccionada.getSaldo() <= 0) {
                cuentaSeleccionada.setSaldo(cuentaSeleccionada.getSaldo() + retiro);
                error = true;
            }

        } while (error == !false);

        int monto = cuentaSeleccionada.getSaldo();
        gestor.crearRetiro(fecha, descripcion, retiro, opcionCliente, opcionCuenta);
        interfaz.mostrarMensaje("Retiro exitoso");
    }

}
