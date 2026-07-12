package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    // Constantes de colores ANSI para la consola
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001B[1m";

    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static ProfesorDAO profesorDAO = new ProfesorDAO();
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    // ==========================================
    // SECCIÓN DE MÉTODOS DE ALUMNOS
    // ==========================================

    private static void inscribir() throws IOException {
        System.out.println(ANSI_CYAN + "\n--- Registrar Nuevo Alumno ---" + ANSI_RESET);
        Alumno alumno = new Alumno();
        System.out.print("Nombre completo: ");
        alumno.setNombre(leer.readLine());
        System.out.print("CURP (18 caracteres): ");
        alumno.setCurp(leer.readLine());
        System.out.print("Número de Expediente (entre 2000000000 y 2140000000): ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Promedio (0.0 - 10.0): ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.inscribirAlumno(alumno);
    }

    private static void mostrarAlumnos() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumno();
        System.out.println(ANSI_PURPLE + "\n=====================================" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_PURPLE + "          LISTA DE ALUMNOS           " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "=====================================" + ANSI_RESET);
        
        if (alumnos.isEmpty()) {
            System.out.println(ANSI_YELLOW + "No hay alumnos registrados en el sistema." + ANSI_RESET);
        } else {
            for (Alumno al : alumnos) {
                System.out.println(al);
            }
        }
    }

    private static void actualizarAlumno() throws IOException {
        System.out.println(ANSI_CYAN + "\n--- Actualizar Datos de Alumno ---" + ANSI_RESET);
        Alumno alumno = new Alumno();
        System.out.print("Número de Expediente del Alumno a modificar: ");
        alumno.setNumExpediente(Integer.parseInt(leer.readLine()));

        System.out.print("Nuevo Nombre: ");
        alumno.setNombre(leer.readLine());
        System.out.print("Nuevo CURP: ");
        alumno.setCurp(leer.readLine());
        System.out.print("Nuevo Grupo: ");
        alumno.setGrupo(leer.readLine());
        System.out.print("Nuevo Promedio: ");
        alumno.setPromedio(Double.parseDouble(leer.readLine()));

        alumnoDAO.actualizar(alumno);
    }

    private static void bajaAlumno() throws IOException {
        System.out.println(ANSI_RED + "\n--- Dar de Baja Alumno ---" + ANSI_RESET);
        System.out.print("Ingrese el número de expediente del Alumno: ");
        int num = Integer.parseInt(leer.readLine());
        
        System.out.print(ANSI_YELLOW + "¿Está seguro de eliminar al alumno con expediente " + num + "? (S/N): " + ANSI_RESET);
        String confirmacion = leer.readLine();
        if (confirmacion.equalsIgnoreCase("s")) {
            boolean eliminado = alumnoDAO.eliminarAlumno(num);
            if (eliminado) {
                System.out.println(ANSI_GREEN + "Alumno eliminado correctamente de la base de datos." + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Error: El expediente " + num + " no existe." + ANSI_RESET);
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    private static void buscarAlumno() throws IOException {
        System.out.println(ANSI_CYAN + "\n--- Buscar Alumno ---" + ANSI_RESET);
        System.out.print("Ingrese el número de expediente: ");
        int num = Integer.parseInt(leer.readLine());
        
        Alumno al = alumnoDAO.buscarAlumno(num);
        if (al != null) {
            System.out.println(ANSI_GREEN + "\nAlumno Encontrado:" + ANSI_RESET);
            System.out.println(al);
        } else {
            System.out.println(ANSI_RED + "El Alumno con expediente " + num + " no existe." + ANSI_RESET);
        }
    }

    // ==========================================
    // SECCIÓN DE MÉTODOS DE PROFESORES
    // ==========================================

    private static void agregarProfesor() throws IOException {
        System.out.println(ANSI_CYAN + "\n--- Registrar Nuevo Profesor ---" + ANSI_RESET);
        Profesor profesor = new Profesor();
        System.out.print("Nombre completo: ");
        profesor.setNombre(leer.readLine());
        System.out.print("CURP: ");
        profesor.setCurp(leer.readLine());
        System.out.print("Número de Empleado: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.print("Puesto: ");
        profesor.setPuesto(leer.readLine());
        System.out.print("Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.agregarProfesor(profesor);
    }

    private static void mostrarProfesores() {
        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();
        System.out.println(ANSI_PURPLE + "\n=====================================" + ANSI_RESET);
        System.out.println(ANSI_BOLD + ANSI_PURPLE + "         LISTA DE PROFESORES         " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "=====================================" + ANSI_RESET);

        if (profesores.isEmpty()) {
            System.out.println(ANSI_YELLOW + "No hay profesores registrados en el sistema." + ANSI_RESET);
        } else {
            for (Profesor pr : profesores) {
                System.out.println(pr);
            }
        }
    }

    private static void actualizarProfesor() throws IOException {
        System.out.println(ANSI_CYAN + "\n--- Actualizar Datos de Profesor ---" + ANSI_RESET);
        Profesor profesor = new Profesor();
        System.out.print("Número de Empleado del profesor a modificar: ");
        profesor.setNumEmpleado(Integer.parseInt(leer.readLine()));

        System.out.print("Nuevo Nombre: ");
        profesor.setNombre(leer.readLine());
        System.out.print("Nuevo CURP: ");
        profesor.setCurp(leer.readLine());
        System.out.print("Nuevo Puesto: ");
        profesor.setPuesto(leer.readLine());
        System.out.print("Nuevo Sueldo: ");
        profesor.setSueldo(Double.parseDouble(leer.readLine()));

        profesorDAO.actualizarProfesor(profesor);
    }

    private static void bajaProfesor() throws IOException {
        System.out.println(ANSI_RED + "\n--- Dar de Baja Profesor ---" + ANSI_RESET);
        System.out.print("Ingrese el número de empleado del Profesor: ");
        int num = Integer.parseInt(leer.readLine());

        System.out.print(ANSI_YELLOW + "¿Está seguro de eliminar al profesor con número " + num + "? (S/N): " + ANSI_RESET);
        String confirmacion = leer.readLine();
        if (confirmacion.equalsIgnoreCase("s")) {
            boolean eliminado = profesorDAO.eliminarProfesor(num);
            if (eliminado) {
                System.out.println(ANSI_GREEN + "Profesor eliminado correctamente de la base de datos." + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + "Error: El número de empleado " + num + " no existe." + ANSI_RESET);
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    private static void buscarProfesor() throws IOException {
        System.out.println(ANSI_CYAN + "\n--- Buscar Profesor ---" + ANSI_RESET);
        System.out.print("Ingrese el número de empleado: ");
        int num = Integer.parseInt(leer.readLine());

        Profesor pr = profesorDAO.buscarProfesor(num);
        if (pr != null) {
            System.out.println(ANSI_GREEN + "\nProfesor Encontrado:" + ANSI_RESET);
            System.out.println(pr);
        } else {
            System.out.println(ANSI_RED + "El Profesor con número de empleado " + num + " no existe." + ANSI_RESET);
        }
    }

    // ==========================================
    // SECCIÓN DE MENÚS PRINCIPALES Y DE CONTROL
    // ==========================================

    private static void menuAlumnos() throws IOException {
        int opcion = 0;
        do {
            System.out.println(ANSI_BLUE + "\n=====================================" + ANSI_RESET);
            System.out.println(ANSI_BOLD + ANSI_BLUE + "          SECCIÓN ALUMNOS            " + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================" + ANSI_RESET);
            System.out.println("1.- Inscribir Alumno");
            System.out.println("2.- Mostrar Alumnos");
            System.out.println("3.- Actualizar Alumno");
            System.out.println("4.- Dar de baja Alumno");
            System.out.println("5.- Buscar Alumno");
            System.out.println("6.- Volver al Menú Principal");
            System.out.println(ANSI_BLUE + "=====================================" + ANSI_RESET);
            System.out.print("Elige tu opción: ");
            
            try {
                opcion = Integer.parseInt(leer.readLine());
                switch (opcion) {
                    case 1: inscribir(); break;
                    case 2: mostrarAlumnos(); break;
                    case 3: actualizarAlumno(); break;
                    case 4: bajaAlumno(); break;
                    case 5: buscarAlumno(); break;
                    case 6: System.out.println("Regresando..."); break;
                    default: System.out.println(ANSI_RED + "Opción inválida." + ANSI_RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Por favor, introduce un número válido." + ANSI_RESET);
            }
        } while (opcion != 6);
    }

    private static void menuProfesores() throws IOException {
        int opcion = 0;
        do {
            System.out.println(ANSI_BLUE + "\n=====================================" + ANSI_RESET);
            System.out.println(ANSI_BOLD + ANSI_BLUE + "         SECCIÓN PROFESORES          " + ANSI_RESET);
            System.out.println(ANSI_BLUE + "=====================================" + ANSI_RESET);
            System.out.println("1.- Registrar Profesor");
            System.out.println("2.- Mostrar Profesores");
            System.out.println("3.- Actualizar Profesor");
            System.out.println("4.- Dar de baja Profesor");
            System.out.println("5.- Buscar Profesor");
            System.out.println("6.- Volver al Menú Principal");
            System.out.println(ANSI_BLUE + "=====================================" + ANSI_RESET);
            System.out.print("Elige tu opción: ");
            
            try {
                opcion = Integer.parseInt(leer.readLine());
                switch (opcion) {
                    case 1: agregarProfesor(); break;
                    case 2: mostrarProfesores(); break;
                    case 3: actualizarProfesor(); break;
                    case 4: bajaProfesor(); break;
                    case 5: buscarProfesor(); break;
                    case 6: System.out.println("Regresando..."); break;
                    default: System.out.println(ANSI_RED + "Opción inválida." + ANSI_RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Por favor, introduce un número válido." + ANSI_RESET);
            }
        } while (opcion != 6);
    }

    public static void menu() throws IOException {
        int seccion = 0;
        do {
            System.out.println(ANSI_GREEN + "\n==========================================" + ANSI_RESET);
            System.out.println(ANSI_BOLD + ANSI_GREEN + "   UNIVERSIDAD UT - CONTROL ESCOLAR       " + ANSI_RESET);
            System.out.println(ANSI_GREEN + "==========================================" + ANSI_RESET);
            System.out.println("1.- Sección Alumnos");
            System.out.println("2.- Sección Profesores");
            System.out.println("3.- Salir");
            System.out.println(ANSI_GREEN + "==========================================" + ANSI_RESET);
            System.out.print("Elige la sección a la que deseas ingresar: ");
            
            try {
                seccion = Integer.parseInt(leer.readLine());
                switch (seccion) {
                    case 1:
                        menuAlumnos();
                        break;
                    case 2:
                        menuProfesores();
                        break;
                    case 3:
                        System.out.println(ANSI_BOLD + ANSI_YELLOW + "\nSaliendo del programa... ¡Hasta luego!" + ANSI_RESET);
                        break;
                    default:
                        System.out.println(ANSI_RED + "Sección inválida. Intente de nuevo." + ANSI_RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Por favor, introduce un número válido." + ANSI_RESET);
            }
        } while (seccion != 3);
    }
}
