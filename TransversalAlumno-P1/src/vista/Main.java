package vista;

import conexion.conexion;
import modelo.Alumno;
import persistencia.AlumnoData;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        conexion conexion = new conexion();
        AlumnoData alumnoData = new AlumnoData(conexion);

        // Agregar un nuevo alumno
        Alumno nuevoAlumno = new Alumno("ivan", "auriol", "36046332", LocalDate.of(1992, 1, 9));
        alumnoData.agregarAlumno(nuevoAlumno);

        // Mostrar todos los alumnos
        List<Alumno> alumnos = alumnoData.obtenerAlumnos();
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }
}
