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
        String sql = "INSERT INTO inscripcion ( id_materia, id_alumno, bajaAlta) VALUES ( ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getId_materia());
            ps.setInt(2, inscripcion.getId_alumno());
            ps.setBoolean(3, inscripcion.isBajaAlta());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setId_alumno(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al crear inscripcion: " + e.getMessage());
        }
    }
    
        public List<Inscripcion> obtenerInscripcion() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion(
                        rs.getInt("id_materia"),
                        rs.getInt("id_alumno"),
                        rs.getBoolean("bajaAlta")
                );
                inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al crear inscripcion: " + e.getMessage());
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
