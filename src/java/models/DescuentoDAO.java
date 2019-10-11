package models;

import db.DB;
import java.sql.*;

public class DescuentoDAO {

    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    public double obtenerPorcentaje(String nombre) {
        double porcentaje = 0;
        try {
            conn = conexion.getConexion();
            String query = "SELECT porcentaje FROM descuento where nombre ='" + nombre + "'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                porcentaje = rs.getDouble("porcentaje");
                return porcentaje;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

}
