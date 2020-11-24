/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.dao;

import cr.ac.cenfotec.tarea3.bl.entidades.Cuenta;
import cr.ac.cenfotec.tarea3.bl.entidades.CuentaAhorro;
import cr.ac.cenfotec.tarea3.bl.entidades.CuentaCorriente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K_DaS
 */
public class CuentaCorrienteDAO extends CuentaDAO {

    @Override
    public boolean save(Cuenta nuevaCuenta) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(nuevaCuenta.toCSVLine());
        try {
            Files.write(Paths.get("c:\\dev\\CuentasCorriente.csv"), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Cuenta> findAll() {
        ArrayList<Cuenta> result = new ArrayList<>();
        BufferedReader reader;
        try {
            File file = new File("c:\\dev\\CuentasCorriente.csv");

            if (file.exists()) {
                FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    result.add(new CuentaCorriente(currentLine));
                    currentLine = reader.readLine();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
