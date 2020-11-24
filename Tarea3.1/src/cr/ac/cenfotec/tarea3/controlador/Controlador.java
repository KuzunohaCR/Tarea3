/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.cenfotec.tarea3.controlador;

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
import cr.ac.cenfotec.tarea3.gestor.Gestor;
import cr.ac.cenfotec.tarea3.tipos.Tema;
import cr.ac.cenfotec.tarea3.tipos.TipoAudio;
import cr.ac.cenfotec.tarea3.tipos.TipoContrato;
import cr.ac.cenfotec.tarea3.tipos.TipoNombramiento;
import cr.ac.cenfotec.tarea3.tipos.TipoVideo;
import cr.ac.cenfotec.tarea3.ui.UI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Controlador {

    UI interfaz = new UI();
    Gestor gestor = new Gestor();

    public void mostrarMenu() {
        int opcion = 0;
        do {
            interfaz.mostrarMenu();
            opcion = interfaz.leerEntero();
            procesarOpcion(opcion);
        } while (opcion != 4);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                opcionUsuario();
                break;
            case 2:
                opcionMaterial();
                break;
            case 3:
                prestamo();
                break;
            case 4:
                break;
            default:
                interfaz.mostrarMensaje("Opcion invalida");
        }
    }

    private void opcionUsuario() {
        int opcion = 0;
        do {
            interfaz.mostrarMenuUsuario();
            opcion = interfaz.leerEntero();
            procesarUsuario(opcion);
        } while (opcion != 4);
    }

    private void procesarUsuario(int opcion) {
        switch (opcion) {
            case 1:
                crearEstudiante();
                break;
            case 2:
                crearProfesor();
                break;
            case 3:
                crearAdministrativo();
                break;
            case 4:
                break;
            default:
                interfaz.mostrarMensaje("Opcion invalida");
        }
    }

    private void opcionMaterial() {
        int opcion = 0;
        do {
            interfaz.mostrarMenuMaterial();
            opcion = interfaz.leerEntero();
            procesarMaterial(opcion);
        } while (opcion != 5);
    }

    private void crearEstudiante() {
        interfaz.mostrarMensaje("Escriba nombre del estudiante");
        String nombreEst = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el apellido");
        String apellidoEst = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba numero de identificacion");
        int identificacionEst = interfaz.leerEntero();
        interfaz.mostrarMensaje("Escriba el nombre de la carrera");
        String carrera = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba la cantidad de creditos matriculados");
        int creditos = interfaz.leerEntero();
        this.gestor.crearEstudiante(nombreEst, apellidoEst, identificacionEst, carrera, creditos);
    }

    private void crearProfesor() {
        interfaz.mostrarMensaje("Escriba nombre del profesor");
        String nombreProf = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el apellido");
        String apellidoProf = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba numero de identificacion");
        int identificacionProf = interfaz.leerEntero();
        interfaz.mostrarMensaje("Escriba su tipo de contrato");
        for (TipoContrato e : TipoContrato.values()) {
            System.out.println(e);
        }
        String contrato = interfaz.leerTexto();
        interfaz.mostrarMensaje("Cual es la fecha de contratacion");
        LocalDate fechaDeContratacion = fecha();
        this.gestor.crearProfesor(nombreProf, apellidoProf, identificacionProf, contrato, fechaDeContratacion);
    }

    public LocalDate fecha() {
        interfaz.mostrarMensaje("Escriba la fecha dd/MM/yyyy");
        String fecha = interfaz.leerTexto();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaDato = LocalDate.parse(fecha, fmt);
        return fechaDato;
    }

    private void crearAdministrativo() {
        interfaz.mostrarMensaje("Escriba nombre del administrativo");
        String nombreAdm = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el apellido");
        String apellidoAdm = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba numero de identificacion");
        int identificacionAdm = interfaz.leerEntero();
        interfaz.mostrarMensaje("Tipo nombramiento");
        for (TipoNombramiento e : TipoNombramiento.values()) {
            System.out.println(e);
        }
        String nombramiento = interfaz.leerTexto();
        interfaz.mostrarMensaje("Cantidad de horas");
        int cantidadHoras = interfaz.leerEntero();
        this.gestor.crearAdministrativo(nombreAdm, apellidoAdm, identificacionAdm, nombramiento, cantidadHoras);
    }

    private void procesarMaterial(int opcion) {
        switch (opcion) {
            case 1:
                crearTexto();
                break;
            case 2:
                crearAudio();
                break;
            case 3:
                crearVideo();
                break;
            case 4:
                crearOtro();
                break;
            case 5:
                break;
            default:
                interfaz.mostrarMensaje("Opcion invalida");
        }
    }

    private void crearTexto() {
        int cont = 1;
        interfaz.mostrarMensaje("Fecha de la compra");
        LocalDate fechaDeCompra = fecha();
        boolean restringido = true;
        interfaz.mostrarMensaje("Seleccione un tema");
        for (Tema temas : Tema.values()) {
            System.out.println(cont++ + ". " + temas);
        }
        String tema = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el idioma");
        String idioma = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el titulo");
        String titulo = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el nombre del autor");
        String nombreAutor = interfaz.leerTexto();
        LocalDate fechaPublicacion = fecha();
        interfaz.mostrarMensaje("Numero de paginas");
        int paginas = interfaz.leerEntero();
        this.gestor.crearTexto(fechaDeCompra, restringido, tema, idioma, titulo, nombreAutor, fechaPublicacion, paginas);
    }

    private void crearAudio() {
        int cont = 1;
        interfaz.mostrarMensaje("Fecha de la compra");
        LocalDate fechaDeCompra = fecha();
        boolean restringido = true;
        interfaz.mostrarMensaje("Seleccione un tema");
        for (Tema temas : Tema.values()) {
            System.out.println(cont++ + ". " + temas);
        }
        String tema = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el idioma");
        String idioma = interfaz.leerTexto();
        interfaz.mostrarMensaje("Tipo de formato");
        for (TipoAudio audios : TipoAudio.values()) {
            System.out.println(audios);
        }
        String formato = interfaz.leerTexto();
        interfaz.mostrarMensaje("Duracion de audio");
        String duracion = interfaz.leerTexto();
        this.gestor.crearAudio(fechaDeCompra, restringido, tema, idioma, formato, duracion);
    }

    private void crearVideo() {
        int cont = 1;
        interfaz.mostrarMensaje("Fecha de la compra");
        LocalDate fechaDeCompra = fecha();
        boolean restringido = true;
        interfaz.mostrarMensaje("Seleccione un tema");
        for (Tema temas : Tema.values()) {
            System.out.println(cont++ + ". " + temas);
        }
        String tema = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el idioma");
        String idioma = interfaz.leerTexto();
        interfaz.mostrarMensaje("Tipo de formato");
        for (TipoVideo videos : TipoVideo.values()) {
            System.out.println(videos);
        }
        String formato = interfaz.leerTexto();
        interfaz.mostrarMensaje("Duracion del video");
        String duracion = interfaz.leerTexto();
        interfaz.mostrarMensaje("Director del video");
        String director = interfaz.leerTexto();
        this.gestor.creadorVideo(fechaDeCompra, restringido, tema, idioma, formato, duracion, director);
    }

    private void crearOtro() {
        int cont = 1;
        interfaz.mostrarMensaje("Fecha de la compra");
        LocalDate fechaDeCompra = fecha();
        boolean restringido = true;
        interfaz.mostrarMensaje("Seleccione un tema");
        for (Tema temas : Tema.values()) {
            System.out.println(cont++ + ". " + temas);
        }
        String tema = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba el idioma");
        String idioma = interfaz.leerTexto();
        interfaz.mostrarMensaje("Escriba la descripcion del material");
        String descripcion = interfaz.leerTexto();
        this.gestor.creatOtro(fechaDeCompra, restringido, tema, idioma, descripcion);
    }

    private void prestamo() {
        int contPersona = 0;
        String respuesta = null;
        ArrayList<Persona> listaPersona = new ArrayList<>();
        listaPersona.add(new Estudiante());
        listaPersona.add(new Profesor());
        listaPersona.add(new Administrativo());
        interfaz.mostrarMensaje("Seleccione un usuario");
        for (Persona unaPersona : listaPersona) {
            for (Persona otraPersona : gestor.listAllPersona(unaPersona)) {
                System.out.println(contPersona++ + ". " + otraPersona.getNombre());
            }

        }
        int seleccionUsuario = interfaz.leerEntero();
        Persona nombrePersona = listaPersona.get(seleccionUsuario);
        ArrayList<Material> lista = new ArrayList<>();
        interfaz.mostrarMensaje("Seleccione un material");
        do {
            lista.add(listaMateriales());
            interfaz.mostrarMensaje("Desea agregar otro material? si/no");
            respuesta = interfaz.leerTexto();
        } while (!respuesta.equals("no"));
        interfaz.mostrarMensaje("Fecha de retorno");
        LocalDate retorno = fecha();
        this.gestor.crearPrestamo(nombrePersona, lista, retorno);
        this.listarPrestamo();
    }

    private Material listaMateriales() {
        String opcion = null;
        gestor.obtenerListaMaterial();

        int contMaterial = 0;
        // for (Material unMaterial : gestor.getListaMaterial()) {
        for (Material unMaterial : gestor.obtenerListaMaterial()) {

            for (Material otroMaterial : gestor.listAll(unMaterial)) {
                System.out.println(contMaterial++ + ". " + otroMaterial.getTema());
            }

        }
        int seleccionMaterial = interfaz.leerEntero();
        Material materialPrestamo = gestor.obtenerListaMaterial().get(seleccionMaterial);

        return materialPrestamo;
    }

    public void listarPrestamo() {
        for (Prestamo nuevoPrestamo : gestor.getListaPrestamos()) {
            System.out.println(nuevoPrestamo);
        }
    }
}
