package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private String url = "jdbc:mariadb://127.0.0.1:3306/transversalDB";
    private String user = "root";
    private String password = "";

    private Connection conexion;

    public Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(url, user, password);
                System.out.println("Conexión exitosa!");
            } catch (SQLException e) {
                System.out.println("Error en la conexión: " + e.getMessage());
            }
        }
        return conexion;
    }
}
