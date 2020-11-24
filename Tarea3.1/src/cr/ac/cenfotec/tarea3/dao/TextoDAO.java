package cr.ac.cenfotec.tarea3.dao;

import cr.ac.cenfotec.tarea3.bl.entidades.Administrativo;
import cr.ac.cenfotec.tarea3.bl.entidades.Audio;
import cr.ac.cenfotec.tarea3.bl.entidades.Material;
import cr.ac.cenfotec.tarea3.bl.entidades.Persona;
import cr.ac.cenfotec.tarea3.bl.entidades.Texto;
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

public class TextoDAO extends MaterialDAO {

    @Override
    public boolean save(Material newMaterial) {

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("c:\\dev\\texto.csv"));
            writer.write(this.toCSVLine((Texto) newMaterial));
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Texto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public List<Material> findAll() {
           ArrayList<Material> result = new ArrayList<>();
        BufferedReader reader;
        try {
            File file = new File("c:\\dev\\texto.csv");
      
            if (file.exists()) {
                 FileReader fileReader = new FileReader(file);
                reader = new BufferedReader(fileReader);
                String currentLine = reader.readLine();
                while (currentLine != null) {
                    result.add(new Texto(currentLine));
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
        Texto tmp = (Texto) objecto;
        return tmp.getTitulo() + "," + tmp.getNombreAutor() + "," + tmp.getFechaPublicacion() + "," + tmp.getPaginas() + "," + tmp.getSignatura() + "," + tmp.getFechaCompra() + "," + tmp.isRestringido() + "," + tmp.getTema() + "," + tmp.getIdioma() + "\n";

    }
}
