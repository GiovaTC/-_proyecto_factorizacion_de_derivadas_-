package dao;

import conexion.ConexionOracle;
import modelo.Derivada;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DerivadaDAO {

    public void guardar(Derivada d) {

        try {

            Connection cn = ConexionOracle.conectar();

            String  sql = "INSERT INTO DERIVADAS_Y(FUNCION, DERIVADA, FACTORIZACION) " +
                    "VALUES(?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, d.getFuncion());
            ps.setString(2, d.getDerivada());
            ps.setString(3, d.getFactorizacion());

            ps.executeUpdate();

            ps.close();
            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   
