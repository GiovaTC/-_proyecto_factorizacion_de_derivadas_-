package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexionOracle {

    private static final String DRIVER = "oracle.jdbc.OracleDriver";

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521/orcl";

    private static final String USUARIO = "system";

    private static final String CLAVE = "Tapiero123";

    static {

        try {

            Class.forName(DRIVER);
            System.out.println("Driver Oracle cargado correctamente.");

        } catch (ClassNotFoundException e) {

            System.err.println("No se encontró el Driver JDBC de Oracle.");
            e.printStackTrace();

        }

    }

    private ConexionOracle() {
        // Evita instanciar la clase
    }

    public static Connection conectar() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USUARIO,
                    CLAVE
            );

        } catch (SQLException e) {

            System.err.println("Error al conectar con Oracle:");
            System.err.println(e.getMessage());

            return null;

        }

    }

    public static boolean probarConexion() {

        try (Connection cn = conectar()) {

            if (cn != null && !cn.isClosed()) {

                System.out.println("Conexión establecida correctamente.");

                return true;

            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());

        }

        return false;
    }
}