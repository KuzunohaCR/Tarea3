/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.dao;

import cr.ac.cenfotec.tarea3.bl.entidades.Cuenta;
import java.util.List;

public abstract class CuentaDAO {

    public abstract boolean save(Cuenta nuevaCuenta);
    public abstract List<Cuenta> findAll();
}

