package com.safedriving.dao;

import com.safedriving.conexion.ConexionBD;
import com.safedriving.modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    // 1. INSERTAR (Create) - Incluye el id_empresa para evitar errores de restricción
    public boolean insertarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (placa, marca, modelo, id_empresa) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, vehiculo.getPlaca());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setString(3, vehiculo.getModelo());
            pstmt.setInt(4, vehiculo.getIdEmpresa());
            
            pstmt.executeUpdate();
            System.out.println("¡Vehículo registrado con éxito!");
            return true;
            
        } catch (SQLException e) {
            System.err.println("Error al insertar vehículo: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTAR / LISTAR (Read) - Extrae los datos incluyendo el id_empresa
    public List<Vehiculo> listarVehiculos() {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        String sql = "SELECT id_vehiculo, placa, marca, modelo, id_empresa FROM vehiculo";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehiculo v = new Vehiculo();
                v.setId(rs.getInt("id_vehiculo"));
                v.setPlaca(rs.getString("placa"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setIdEmpresa(rs.getInt("id_empresa"));
                listaVehiculos.add(v);
            }
            System.out.println("¡Vehículos consultados con éxito!");

        } catch (SQLException e) {
            System.err.println("Error al listar vehículos: " + e.getMessage());
        }

        return listaVehiculos;
    }

    // 3. ACTUALIZAR (Update)
    public boolean actualizarVehiculo(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET marca = ?, modelo = ?, id_empresa = ? WHERE placa = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehiculo.getMarca());
            pstmt.setString(2, vehiculo.getModelo());
            pstmt.setInt(3, vehiculo.getIdEmpresa());
            pstmt.setString(4, vehiculo.getPlaca());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("¡Vehículo actualizado con éxito!");
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar vehículo: " + e.getMessage());
        }
        return false;
    }

    // 4. ELIMINAR (Delete)
    public boolean eliminarVehiculo(String placa) {
        String sql = "DELETE FROM vehiculo WHERE placa = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, placa);
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("¡Vehículo eliminado con éxito!");
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar vehículo: " + e.getMessage());
        }
        return false;
    }
}