package persistencia;

import conexion.conexion;
import modelo.Inscripcion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionData {
    private Connection con;

    public InscripcionData(conexion conexion) {
        con = conexion.getConexion();
    }

    public void crearInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (id_materia, id_alumno, bajaAlta) VALUES (?, ?, ?)";
        try (
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, inscripcion.getId_materia());
            ps.setInt(2, inscripcion.getId_alumno());
            ps.setBoolean(3, inscripcion.isBajaAlta());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    inscripcion.setId_alumno(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al crear inscripcion: " + e.getMessage());
        }
    }
    
    public List<Inscripcion> obtenerInscripciones() {
    List<Inscripcion> inscripciones = new ArrayList<>();
    String sql = "SELECT i.id_inscripcion, i.id_materia, i.id_alumno, i.bajaAlta, "
                 + "a.nombre AS alumno_nombre, a.apellido AS alumno_apellido, "
                 + "m.nombreMateria AS materia_nombre "
                 + "FROM inscripcion i "
                 + "JOIN alumno a ON i.id_alumno = a.id_alumno "
                 + "JOIN materia m ON i.id_materia = m.id_materia";
    try (PreparedStatement ps = con.prepareStatement(sql); 
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
            inscripcion.setId_materia(rs.getInt("id_materia"));
            inscripcion.setId_alumno(rs.getInt("id_alumno"));
            inscripcion.setBajaAlta(rs.getBoolean("bajaAlta"));
            inscripcion.setAlumnoNombre(rs.getString("alumno_nombre"));
            inscripcion.setMateriaNombre(rs.getString("materia_nombre"));

            inscripciones.add(inscripcion);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener inscripciones: " + e.getMessage());
    }
    return inscripciones;
}
        
        
    public void borrar(int id) throws SQLException {
            String sql = "DELETE FROM inscripcion WHERE id_inscripcion = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
    }
    
    public void bajaLogica(int id) throws SQLException {
            String sql = "UPDATE inscripcion SET bajaAlta = 0 WHERE id_inscripcion = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
    }

    public void altaLogica(int id) throws SQLException {
            String sql = "UPDATE inscripcion SET bajaAlta = 1 WHERE id = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
    }

        
}
