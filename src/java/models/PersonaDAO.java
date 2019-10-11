package models;

import db.DB;
import java.sql.*;

public class PersonaDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    public void agregar(Persona p) {
        try {
            conn = conexion.getConexion();
            String query = "INSERT INTO persona (id, primer_nombre, primer_apellido, correo, contrasena) values (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getId());
            ps.setString(2, p.getPrimerNombre());
            ps.setString(3, p.getPrimerApellido());
            ps.setString(4, p.getCorreo());
            ps.setString(5, p.getContrasena());
            ps.executeUpdate();
            System.out.println("Persona ha sido inscrita");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }

    public int validar(String id, String pass) {
        String idBD = null;
        String passBD = null;
        try {
            conn = conexion.getConexion();
            System.out.println("jaja por fin");
            String query = "SELECT id, contrasena FROM persona where id ='" + id + "' and contrasena ='" + pass + "'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                idBD = rs.getString("id");
                passBD = rs.getString("contrasena");
                if (idBD.equals(null) || idBD.equals("") || passBD.equals(null) || passBD.equals("")) {
                    return 0;
                } else if (idBD.equals("root") && passBD.equals("root")) {
                    return 2;
                } else {
                    return 1;
                }
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

    public String obtenerNombre(String id) {
        String nombreBD = null;
        String apellidoBD = null;
        try {
            conn = conexion.getConexion();
            System.out.println("jaja por fin");
            String query = "SELECT primer_nombre, primer_apellido FROM persona where id ='" + id + "'";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                nombreBD = rs.getString("primer_nombre");
                apellidoBD = rs.getString("primer_apellido");
                if (nombreBD.equals(null) || nombreBD.equals("") || apellidoBD.equals(null) || apellidoBD.equals("")) {
                    return "usuario";
                } else if (nombreBD.equals("root") && apellidoBD.equals("root")) {
                    return "administrador";
                } else {
                    return nombreBD + " " + apellidoBD;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
