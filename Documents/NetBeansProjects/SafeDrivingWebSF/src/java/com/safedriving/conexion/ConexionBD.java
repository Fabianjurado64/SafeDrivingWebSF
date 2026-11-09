package com.safedriving.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Configuración para MySQL corriendo en XAMPP (sin contraseña por defecto)
    private static final String URL = "jdbc:mysql://localhost:3306/safe_driving?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String PASSWORD = ""; // Vacío porque usas XAMPP

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("¡Conexión exitosa a la base de datos Safe Driving con XAMPP!");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se encontró el driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de SQL al conectar: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        obtenerConexion();
    }
}
