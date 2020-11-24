/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.gestor;

import cr.ac.cenfotec.tarea3.bl.entidades.Administrativo;
import cr.ac.cenfotec.tarea3.bl.entidades.Audio;
import cr.ac.cenfotec.tarea3.bl.entidades.Estudiante;
import cr.ac.cenfotec.tarea3.bl.entidades.Material;
import cr.ac.cenfotec.tarea3.bl.entidades.Otro;
import cr.ac.cenfotec.tarea3.bl.entidades.Persona;
import cr.ac.cenfotec.tarea3.bl.entidades.Prestamo;
import cr.ac.cenfotec.tarea3.bl.entidades.Profesor;
import cr.ac.cenfotec.tarea3.bl.entidades.Texto;
import cr.ac.cenfotec.tarea3.bl.entidades.Video;
import cr.ac.cenfotec.tarea3.dao.AdministrativoDAO;
import cr.ac.cenfotec.tarea3.dao.AudioDAO;
import cr.ac.cenfotec.tarea3.dao.EstudianteDAO;
import cr.ac.cenfotec.tarea3.dao.MaterialDAO;
import cr.ac.cenfotec.tarea3.dao.OtroDAO;
import cr.ac.cenfotec.tarea3.dao.PersonaDAO;
import cr.ac.cenfotec.tarea3.dao.ProfesorDAO;
import cr.ac.cenfotec.tarea3.dao.TextoDAO;
import cr.ac.cenfotec.tarea3.dao.VideoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestor {

    private ArrayList<Material> listaMaterial = new ArrayList<>();
    private ArrayList<Persona> usuarios = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private ArrayList<Material> materiales = new ArrayList<>();

    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
    private ArrayList<Administrativo> administrativos = new ArrayList<>();
    private ArrayList<Texto> textos = new ArrayList<>();
    private ArrayList<Audio> audios = new ArrayList<>();
    private ArrayList<Video> videos = new ArrayList<>();
    

    //Registra la personaDAO
    public void registrar(Persona unaPersona) {
        PersonaDAO tmp = this.determinarPersonaDAO(unaPersona);
        for(Persona nuevoUsuario: usuarios){
            Estudiante nuevo = (Estudiante) nuevoUsuario;
        }
        tmp.save(unaPersona);
        this.usuarios.add(unaPersona);
        
    }

    public ArrayList<Persona> getListaPersona() {
        return this.usuarios;
    }

    //Registra el materialDAO 
    public void registrarMaterial(Material unMaterial) {
        try {
            MaterialDAO tmp = this.determinarObjetoDAO(unMaterial);
            tmp.save(unMaterial);

        } catch (Exception ex) {
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.materiales.add(unMaterial);
    }

    public ArrayList<Material> getListaMaterial() {
        return this.materiales;
    }

    public void crearEstudiante(String nombreEst, String apellidoEst, int identificacionEst, String carrera, int creditos) {
        Estudiante nuevoEstudiante = new Estudiante(carrera, creditos, nombreEst, apellidoEst, identificacionEst);
        this.registrar(nuevoEstudiante);
    }

    public void crearProfesor(String nombreProf, String apellidoProf, int identificacionProf, String contrato, LocalDate fechaContratacion) {
        Profesor nuevoProfesor = new Profesor(contrato, fechaContratacion, nombreProf, apellidoProf, identificacionProf);
        this.registrar(nuevoProfesor);
    }

    public void crearAdministrativo(String nombreAdm, String apellidoAdm, int identificacionAdm, String nombramiento, int cantidadHoras) {
        Administrativo nuevoAdministrativo = new Administrativo(nombramiento, cantidadHoras, nombreAdm, apellidoAdm, identificacionAdm);
        this.registrar(nuevoAdministrativo);
    }

    public void crearTexto(LocalDate fechaDeCompra, boolean restringido, String tema, String idioma, String titulo, String nombreAutor, LocalDate fechaPublicacion, int paginas) {
        Texto nuevoTexto = new Texto(titulo, nombreAutor, fechaPublicacion, paginas, fechaDeCompra, restringido, tema, idioma);
        this.registrarMaterial(nuevoTexto);
    }

    public void crearAudio(LocalDate fechaDeCompra, boolean restringido, String tema, String idioma, String formato, String duracion) {
        Audio nuevoAudio = new Audio(formato, duracion, fechaDeCompra, restringido, tema, idioma);
        this.registrarMaterial(nuevoAudio);
    }

    public void creadorVideo(LocalDate fechaDeCompra, boolean restringido, String tema, String idioma, String formato, String duracion, String director) {
        Video nuevoVideo = new Video(formato, duracion, director, fechaDeCompra, restringido, tema, idioma);
        this.registrarMaterial(nuevoVideo);
    }

    public void creatOtro(LocalDate fechaDeCompra, boolean restringido, String tema, String idioma, String descripcion) {
        Otro nuevoOtro = new Otro(descripcion, fechaDeCompra, restringido, tema, idioma);
        this.registrarMaterial(nuevoOtro);
    }

    public void crearPrestamo(Persona nombrePersona, ArrayList<Material> lista, LocalDate retorno) {
        Prestamo nuevoPrestamo = new Prestamo(nombrePersona, lista, retorno);
        this.prestamos.add(nuevoPrestamo);
    }

    //Calcula el tipo de materialDao
    private MaterialDAO determinarObjetoDAO(Material nuevoMaterial) throws Exception {
        if (nuevoMaterial instanceof Audio) {
            return new AudioDAO();
        }
        if (nuevoMaterial instanceof Video) {
            return new VideoDAO();
        }
        if (nuevoMaterial instanceof Texto) {
            return new TextoDAO();
        }
        if (nuevoMaterial instanceof Otro) {
            return new OtroDAO();
        }
        throw new Exception("Tipo de Material Desconocido");
    }

    //Calcula el tipo de personaDAO
    private PersonaDAO determinarPersonaDAO(Persona unaPersona) {
        if (unaPersona instanceof Estudiante) {
            return new EstudianteDAO();
        }
        if (unaPersona instanceof Administrativo) {
            return new AdministrativoDAO();
        }
        if (unaPersona instanceof Profesor) {
            return new ProfesorDAO();
        }
        return null;
    }

    public List<Material> listAll(Material tipoMaterial) {
        try {
            MaterialDAO objPersistente = determinarObjetoDAO(tipoMaterial);
            return objPersistente.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Material>();
    }

    public List<Persona> listAllPersona(Persona tipoPersona) {
        try {
            PersonaDAO objPersistente = determinarPersonaDAO(tipoPersona);
            return objPersistente.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Persona>();
    }

    public ArrayList<Material> obtenerListaMaterial() {
        ArrayList<Material> listaMaterial = new ArrayList<>();
        listaMaterial.add(new Audio());
        listaMaterial.add(new Texto());
        listaMaterial.add(new Video());
        listaMaterial.add(new Otro());
        return listaMaterial;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return this.prestamos;
    }

}
