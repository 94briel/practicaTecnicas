package models;

import db.DB;
import java.sql.*;

public class PagoDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    public void agregar(Pago p) {
        try {
            conn = conexion.getConexion();
            String query = "INSERT INTO pago (id_compra, nombre_cliente, id_cliente, nombre_cel, precio_cel, descuento, total, tarjeta) values (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, p.getIdCompra());
            ps.setString(2, p.getNombreCliente());
            ps.setString(3, p.getIdCliente());
            ps.setString(4, p.getNombreCel());
            ps.setDouble(5, p.getPrecioCel());
            ps.setDouble(6, p.getDescuento());
            ps.setDouble(7, p.getTotal());
            ps.setString(8, p.getTarjeta());
            ps.executeUpdate();
            System.out.println("Registro de pago ha sido inscrito");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }

    public int obtenerID() {
        try {
            conn = conexion.getConexion();
            String query = "SELECT * FROM pago ORDER BY id_compra DESC LIMIT 1";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return rs.getInt("id_compra") + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                return 1;
            }
        }
        return 1;
    }

}
