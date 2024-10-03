package vista;

import conexion.conexion;
import java.sql.SQLException;
import modelo.Alumno;
import persistencia.AlumnoData;
import java.time.LocalDate;
import java.util.List;
//import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws SQLException {
        conexion conexion = new conexion();
        AlumnoData alumnoData = new AlumnoData(conexion);

        // Agregar un nuevo alumno
        Alumno nuevoAlumno = new Alumno(1,"Juan", "Molina", "34485532", LocalDate.of(1989, 3, 20));
        Alumno nuevoAlumno2 = new Alumno(2,"Michael", "Mayers", "46626729", LocalDate.of(1989, 6, 18));
        alumnoData.agregarAlumno(nuevoAlumno);
        alumnoData.agregarAlumno(nuevoAlumno2);
        Alumno nuevoAlumno3 = new Alumno(3,"Yaciel", "Muñoz", "46408906", LocalDate.of(2005, 4, 20));
        alumnoData.agregarAlumno(nuevoAlumno3);

        
        // Mostrar todos los alumnos
        List<Alumno> alumnos = alumnoData.obtenerAlumnos();
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
        
        // Se va a borrar el alumno de ID 1
        alumnoData.borrar(1);
        
        //Actualizamos el alumno de ID 4 (Michael Mayers) y le cambiamos el apellido
        Alumno alumnoActualizado = new Alumno(4, "Michael", "Jackson", "46626729", LocalDate.of(1989,3, 25));
        alumnoData.actualizar(alumnoActualizado);
        
        System.out.println("-----------------------------");
        
        //Mostramos devuelta 
        for (Alumno a : alumnos) {
            System.out.println(a); 
        }


        
    }
}
