package com.safedriving.modelo;

public class Vehiculo {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int idEmpresa;

    // 1. Constructor vacío
    public Vehiculo() {
    }

    // 2. Constructor con todos los parámetros (incluyendo idEmpresa)
    public Vehiculo(int id, String placa, String marca, String modelo, int idEmpresa) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.idEmpresa = idEmpresa;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
}