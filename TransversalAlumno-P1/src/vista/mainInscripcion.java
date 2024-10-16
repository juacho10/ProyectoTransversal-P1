
package vista;

import conexion.conexion;
import java.sql.SQLException;
import modelo.Inscripcion;
import persistencia.InscripcionData;
import java.util.List;

public class mainInscripcion {
    
    public static void main(String[] args) throws SQLException {
        conexion conexion = new conexion();
        InscripcionData inscripcionData = new InscripcionData(conexion);
/*      
        //realizamos inscripciones
        Inscripcion inscripcion = new Inscripcion (8, 3, 5, true);
        inscripcionData.crearInscripcion(inscripcion);
        
        Inscripcion inscripcion1 = new Inscripcion (9, 7, 5, true);
        inscripcionData.crearInscripcion(inscripcion1);
*/        
        
        List<Inscripcion> inscripciones = inscripcionData.obtenerInscripcion();
        for (Inscripcion m: inscripciones) {
            System.out.println(m);
        }
        //borramos las inscripciones
        inscripcionData.borrar(10);
        inscripcionData.borrar(11);
        
        System.out.println("-----------------------------");
        System.out.println("");
        List<Inscripcion> inscripciones1 = inscripcionData.obtenerInscripcion();
        for (Inscripcion m: inscripciones1) {
            System.out.println(m);
        }
    }
}
