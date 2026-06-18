package dao;

import conexion.ConexionOracle;
import modelo.Derivada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DerivadaDAO {

    //==========================================================
    // GUARDAR
    //==========================================================

    public boolean guardar(Derivada derivada) {

        String sql = """
                INSERT INTO DERIVADAS_Y
                (
                    FUNCION,
                    DERIVADA,
                    FACTORIZACION
                )
                VALUES
                (
                    ?,
                    ?,
                    ?
                )
                """;

        try (
                Connection cn = ConexionOracle.conectar();
                PreparedStatement ps = cn.prepareStatement(sql)
        ) {

            ps.setString(1, derivada.getFuncion());
            ps.setString(2, derivada.getDerivada());
            ps.setString(3, derivada.getFactorizacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error Guardar : " + e.getMessage());

        }

        return false;

    }

    //==========================================================
    // LISTAR
    //==========================================================

    public List<Derivada> listar() {

        List<Derivada> lista = new ArrayList<>();

        String sql = """
                SELECT
                    ID,
                    FUNCION,
                    DERIVADA,
                    FACTORIZACION,
                    FECHA_REGISTRO
                FROM DERIVADAS_Y
                ORDER BY ID
                """;

        try (
                Connection cn = ConexionOracle.conectar();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Derivada d = new Derivada();

                d.setId(rs.getInt("ID"));
                d.setFuncion(rs.getString("FUNCION"));
                d.setDerivada(rs.getString("DERIVADA"));
                d.setFactorizacion(rs.getString("FACTORIZACION"));
                d.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));

                lista.add(d);

            }

        } catch (SQLException e) {

            System.out.println("Error Listar : " + e.getMessage());

        }

        return lista;

    }

    //==========================================================
    // BUSCAR POR ID
    //==========================================================

    public Derivada buscar(int id) {

        String sql = """
                SELECT *
                FROM DERIVADAS_Y
                WHERE ID = ?
                """;

        try (
                Connection cn = ConexionOracle.conectar();
                PreparedStatement ps = cn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Derivada d = new Derivada();

                d.setId(rs.getInt("ID"));
                d.setFuncion(rs.getString("FUNCION"));
                d.setDerivada(rs.getString("DERIVADA"));
                d.setFactorizacion(rs.getString("FACTORIZACION"));
                d.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));

                return d;

            }

        } catch (SQLException e) {

            System.out.println("Error Buscar : " + e.getMessage());

        }

        return null;

    }

    //==========================================================
    // ACTUALIZAR
    //==========================================================

    public boolean actualizar(Derivada derivada) {

        String sql = """
                UPDATE DERIVADAS_Y
                SET
                    FUNCION=?,
                    DERIVADA=?,
                    FACTORIZACION=?
                WHERE ID=?
                """;

        try (
                Connection cn = ConexionOracle.conectar();
                PreparedStatement ps = cn.prepareStatement(sql)
        ) {

            ps.setString(1, derivada.getFuncion());
            ps.setString(2, derivada.getDerivada());
            ps.setString(3, derivada.getFactorizacion());
            ps.setInt(4, derivada.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error Actualizar : " + e.getMessage());

        }

        return false;

    }

    //==========================================================
    // ELIMINAR
    //==========================================================

    public boolean eliminar(int id) {

        String sql = """
                DELETE FROM DERIVADAS_Y
                WHERE ID=?
                """;

        try (
                Connection cn = ConexionOracle.conectar();
                PreparedStatement ps = cn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Error Eliminar : " + e.getMessage());

        }

        return false;

    }

    //==========================================================
    // CONTAR REGISTROS
    //==========================================================

    public int contar() {

        String sql = """
                SELECT COUNT(*)
                FROM DERIVADAS_Y
                """;

        try (
                Connection cn = ConexionOracle.conectar();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {

                return rs.getInt(1);

            }

        } catch (SQLException e) {

            System.out.println("Error Contar : " + e.getMessage());

        }

        return 0;

    }
}