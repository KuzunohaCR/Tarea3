/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.dao;

import cr.ac.cenfotec.tarea3.bl.entidades.Administrativo;
import cr.ac.cenfotec.tarea3.bl.entidades.Material;
import cr.ac.cenfotec.tarea3.bl.entidades.Persona;
import cr.ac.cenfotec.tarea3.bl.entidades.Profesor;
import cr.ac.cenfotec.tarea3.bl.entidades.Video;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfesorDAO extends PersonaDAO {

    @Override
    public boolean save(Persona newPersona) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("c:\\dev\\profesor.csv"));
            writer.write(this.toCSVLine((Profesor) newPersona));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public List<Persona> findAll() {
            ArrayList<Persona> result = new ArrayList<>();
        BufferedReader reader;
        try {
            File file = new File("c:\\dev\\profesor.csv");
      
            if (file.exists()) {
                 FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    result.add(new Profesor(currentLine));
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

    @Override
    public String toCSVLine(Object objecto) {
        Profesor tmp = (Profesor) objecto;
        return tmp.getTipoContrato() + "," + tmp.getFechaContratacion() + "," + tmp.getId() + "," + tmp.getNombre() + "," + tmp.getApellido() + "," + tmp.getIdentificacion() + "\n";

    }

}
