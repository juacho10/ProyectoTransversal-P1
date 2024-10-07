
package persistencia;

import conexion.conexion;
import modelo.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MateriaData {
    private Connection con;

    public MateriaData(conexion conexion) {
        con = conexion.getConexion();
    }

    public void agregarMateria (Materia materia) {
        String sql = "INSERT INTO materia (nombreMateria) VALUES (?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombreMateria() );
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId_materia(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar materia: " + e.getMessage());
        }
    }
  public void borrar(int id) throws SQLException {
        String sql = "DELETE FROM materia WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    public void actualizar(Materia materia) throws SQLException {
        String sql = "UPDATE materia SET nombreMateria = ? WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, materia.getNombreMateria());
            statement.setInt(2, materia.getId_materia());
            statement.executeUpdate();
        }
    }
    
    public List<Materia> obtenerMateria() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia(
                        rs.getString("nombreMateria")
                );
                materia.setId_materia(rs.getInt("id_materia"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener materias: " + e.getMessage());
        }
        return materias;
    }
}
