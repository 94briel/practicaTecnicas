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
            System.out.println("Telefono ha sido inscrito");
        } catch (Exception e) {
            e.printStackTrace();
        } finally { 
            try { 
                rs.close(); 
            } catch (Exception e) { /* ignored */ }
        }
    }
    public double obtenerPrecio(String nombreTel){
        double precioBD = 0;
        try {
            conn = conexion.getConexion();
            System.out.println("jaja por fin");
            String query = "SELECT precio FROM telefono where nombre ='" + nombreTel + "'";
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
    
}
