package vista;

import conexion.conexion;
import java.sql.SQLException;
import modelo.Materia;
import persistencia.MateriaData;
import java.util.List;

public class mainMateria {
    public static void main(String[] args) throws SQLException {
        conexion conexion = new conexion();
        MateriaData materiaData = new MateriaData(conexion);
        
        Materia matematica = new Materia ("Fisica", true);
        materiaData.agregarMateria(matematica);
        
        
        List<Materia> materias = materiaData.obtenerMateria();
        for (Materia m: materias) {
            System.out.println(m);
        }
    }
}
