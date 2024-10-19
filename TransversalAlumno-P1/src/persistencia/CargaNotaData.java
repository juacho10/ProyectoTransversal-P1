
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.CargaNota;

public class CargaNotaData {
    private Connection connection;

    public CargaNotaData(Connection connection) {
        this.connection = connection;
    }

    public void agregarNota(CargaNota nota) throws SQLException {
        String sql = "INSERT INTO carga_nota (id_inscripcion, nota) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, nota.getIdInscripcion());
            statement.setDouble(2, nota.getNota());
            statement.executeUpdate();
        }
    }

    public void actualizarNota(CargaNota nota) throws SQLException {
        String sql = "UPDATE carga_nota SET nota = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, nota.getNota());
            statement.setInt(2, nota.getId());
            statement.executeUpdate();
        }
    }

    public void borrarNota(int id) throws SQLException {
        String sql = "DELETE FROM carga_nota WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<CargaNota> obtenerNotas() throws SQLException {
        List<CargaNota> notas = new ArrayList<>();
        String sql = "SELECT * FROM carga_nota";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CargaNota nota = new CargaNota(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_inscripcion"),
                    resultSet.getDouble("nota")
                );
                notas.add(nota);
            }
        }
        return notas;
    }
}

