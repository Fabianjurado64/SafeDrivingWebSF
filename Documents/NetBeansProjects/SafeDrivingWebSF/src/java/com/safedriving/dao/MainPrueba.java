package com.safedriving.dao;

import com.safedriving.modelo.Vehiculo;
import java.util.List;

public class MainPrueba {
    public static void main(String[] args) {
        VehiculoDAO dao = new VehiculoDAO();

        System.out.println("=== 1. PRUEBA DE INSERCIÓN (CREATE) ===");
        // Insertamos dos vehículos de prueba distintos
        Vehiculo vehiculo1 = new Vehiculo(0, "BUS-099", "Mercedes-Benz", "2023", 1);
        Vehiculo vehiculo2 = new Vehiculo(0, "SENA-99", "Renault", "2021", 1);
        
        dao.insertarVehiculo(vehiculo1);
        dao.insertarVehiculo(vehiculo2);

        System.out.println("\n=== 2. PRUEBA DE LISTADO (READ) ===");
        mostrarLista(dao);

        System.out.println("\n=== 3. PRUEBA DE ACTUALIZACIÓN (UPDATE) ===");
        // Actualizamos los datos del vehículo "SENA-99" a un modelo más reciente
        Vehiculo vehiculoModificado = new Vehiculo(0, "SENA-99", "Renault Duster", "2025", 1);
        dao.actualizarVehiculo(vehiculoModificado);
        mostrarLista(dao);

        System.out.println("\n=== 4. PRUEBA DE ELIMINACIÓN (DELETE) ===");
        // Eliminamos el vehículo "BUS-099" para verificar el borrado selectivo
        dao.eliminarVehiculo("BUS-099");
        mostrarLista(dao);
    }

    // Método auxiliar para imprimir el listado ordenadamente
    public static void mostrarLista(VehiculoDAO dao) {
        List<Vehiculo> listaVehiculos = dao.listarVehiculos();
        System.out.println("--- Estado Actual de la Base de Datos ---");
        if (listaVehiculos.isEmpty()) {
            System.out.println("(La tabla de vehículos está vacía)");
        } else {
            for (Vehiculo v : listaVehiculos) {
                System.out.println("ID: " + v.getId() + 
                                   " | Placa: " + v.getPlaca() + 
                                   " | Marca: " + v.getMarca() + 
                                   " | Modelo: " + v.getModelo() + 
                                   " | Empresa ID: " + v.getIdEmpresa());
            }
        }
        System.out.println("-----------------------------------------\n");
    }
}