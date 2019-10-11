package models;

import db.DB;
import java.sql.*;

public class TelefonoDAO {

    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    public void agregar(Telefono t) {
        try {
            conn = conexion.getConexion();
            System.out.println("jaja por fin");
            String query = "INSERT INTO telefono (id, marca, nombre, color, capacidad, precio, cantidad) values (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getMarca());
            ps.setString(3, t.getNombre());
            ps.setString(4, t.getColor());
            ps.setDouble(5, t.getCapacidad());
            ps.setDouble(6, t.getPrecio());
            ps.setInt(7, t.getCantidad());
            ps.executeUpdate();
            conn.close();
            System.out.println("Telefono ha sido inscrito");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }

    public double obtenerPrecio(int id) {
        double precioBD = 0;
        try {
            conn = conexion.getConexion();
            System.out.println("jaja por fin");
            String query = "SELECT precio FROM telefono where id ='" + id + "'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                precioBD = rs.getDouble("precio");
                return precioBD;
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

    public void restarCantidad(int id, int cant) {
        try {
            conn = conexion.getConexion();
            String query = "SELECT cantidad FROM telefono where id ='" + id + "'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                int valor = rs.getInt("cantidad");
                if ((valor - cant) >= 0) {
                    query = "update telefono set cantidad = ?  where id ='" + id + "'";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1, valor - cant);
                    ps.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
        }
    }

}
