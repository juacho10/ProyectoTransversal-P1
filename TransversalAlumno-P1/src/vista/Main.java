package vista;

import conexion.conexion;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.Alumno;
import persistencia.AlumnoData;
import java.util.List;
//import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws SQLException {
        conexion conexion = new conexion();
        AlumnoData alumnoData = new AlumnoData(conexion);
/*
        //Agregar un nuevo alumno
        Alumno nuevoAlumno = new Alumno("Chango", "Mas", "11111111", LocalDate.of(1989, 3, 20), true);
        alumnoData.agregarAlumno(nuevoAlumno);
        Alumno nuevoAlumno2 = new Alumno("Michael", "Mayers", "46626729", LocalDate.of(1989, 6, 18), true);
        alumnoData.agregarAlumno(nuevoAlumno2);
        Alumno nuevoAlumno3 = new Alumno("Yaciel", "Muñoz", "46408906", LocalDate.of(2005, 4, 20), true);
        alumnoData.agregarAlumno(nuevoAlumno3);
        Alumno nuevoAlumno4 = new Alumno("Juan", "Molina", "34485532", LocalDate.of(1989, 3, 20), true);
        alumnoData.agregarAlumno(nuevoAlumno4);
 */       
         //Mostrar todos los alumnos

         List<Alumno> alumnos = alumnoData.obtenerAlumnos();
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
 /*       
        // Se va a borrar el alumno
        alumnoData.borrar(10);
        alumnoData.borrar(11);
 */
 /*
        //Actualizamos el alumno
        Alumno alumnoActualizado = new Alumno(8, "Gaston", "Jackson", "46626729", LocalDate.of(1989,3, 25), false);
        alumnoData.actualizar(alumnoActualizado);
 */       
        System.out.println("-----------------------------");
        
        //Mostramos devuelta 
        for (Alumno a : alumnos) {
            System.out.println(a); 
        }


        
    }
}
