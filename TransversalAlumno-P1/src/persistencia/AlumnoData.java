package persistencia;

import conexion.conexion;
import modelo.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoData {
    private Connection con;

    public AlumnoData(conexion conexion) {
        con = conexion.getConexion();
    }

    public void agregarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (nombre, apellido, dni, fecha_nacimiento, activo) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getDni());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId_alumno(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar alumno: " + e.getMessage());
        }
    }

    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getBoolean("activo")
                );
                alumno.setId_alumno(rs.getInt("id_alumno"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener alumnos: " + e.getMessage());
        }
        return alumnos;
    }
    public void borrar(int id_alumno) throws SQLException {
        String sql = "DELETE FROM alumno WHERE id_alumno = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id_alumno);
            statement.executeUpdate();
        }
    }
    public void actualizar(Alumno alumno) throws SQLException {
        String sql = "UPDATE alumno SET nombre = ?, apellido = ?, dni = ?, fecha_nacimiento = ? WHERE id_alumno = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellido());
            statement.setString(3, alumno.getDni());
            statement.setDate(4, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
            statement.setInt(5, alumno.getId_alumno());
            statement.setBoolean(6, alumno.isActivo());
            statement.executeUpdate();
        }
    }
    public void bajaLogica(int id_alumno) throws SQLException {
        String sql = "UPDATE alumno SET activo = 0 WHERE id_alumno = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id_alumno);
            statement.executeUpdate();
        }
    }

    public void altaLogica(int id_alumno) throws SQLException {
        String sql = "UPDATE alumno SET activo = 1 WHERE id_alumno = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id_alumno);
            statement.executeUpdate();
        }
    }
    
}