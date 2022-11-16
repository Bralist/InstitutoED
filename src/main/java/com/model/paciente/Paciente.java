/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.paciente;

/**
 *
 * @author JESUS
 */
public class Paciente {
    //ATRIBUTOS
    private String UUID;
    private int edad;
    private String sexo;
    private String ubigeo_paciente;
    private String departamento_paciente;
    private String provincia_paciente;
    private String distrito_paciente;
    //METODOS GETTER AND SETTER
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUbigeo_paciente() {
        return ubigeo_paciente;
    }

    public void setUbigeo_paciente(String ubigeo_paciente) {
        this.ubigeo_paciente = ubigeo_paciente;
    }

    public String getDepartamento_paciente() {
        return departamento_paciente;
    }

    public void setDepartamento_paciente(String departamento_paciente) {
        this.departamento_paciente = departamento_paciente;
    }

    public String getProvincia_paciente() {
        return provincia_paciente;
    }

    public void setProvincia_paciente(String provincia_paciente) {
        this.provincia_paciente = provincia_paciente;
    }

    public String getDistrito_paciente() {
        return distrito_paciente;
    }

    public void setDistrito_paciente(String distrito_paciente) {
        this.distrito_paciente = distrito_paciente;
    }
            
}
