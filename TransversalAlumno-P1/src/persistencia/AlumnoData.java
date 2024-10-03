package persistencia;

import conexion.conexion;
import modelo.Alumno;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlumnoData {
    private Connection con;

    public AlumnoData(conexion conexion) {
        con = conexion.getConexion();
    }

    public void agregarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (nombre, apellido, dni, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getDni());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(rs.getInt(1));
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
                        rs.getDate("fecha_nacimiento").toLocalDate()
                );
                alumno.setId(rs.getInt("id"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener alumnos: " + e.getMessage());
        }
        return alumnos;
    }
}
