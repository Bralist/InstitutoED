/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.muestra;

import java.util.Date;

/**
 *
 * @author JESUS
 */
public class Muestra {
    //ATRIBUTOS
    private Date fecha_muestra;
    private String ubigeo_muestra;
    private String depatarmento_muestra;
    private String provincia_muestra;
    private String distrito_muestra;
    private String tipo_muestra;
    //METODOS GETTER AND SETTER
    public Date getFecha_muestra() {
        return fecha_muestra;
    }

    public void setFecha_muestra(Date fecha_muestra) {
        this.fecha_muestra = fecha_muestra;
    }

    public String getUbigeo_muestra() {
        return ubigeo_muestra;
    }

    public void setUbigeo_muestra(String ubigeo_muestra) {
        this.ubigeo_muestra = ubigeo_muestra;
    }

    public String getDepatarmento_muestra() {
        return depatarmento_muestra;
    }

    public void setDepatarmento_muestra(String depatarmento_muestra) {
        this.depatarmento_muestra = depatarmento_muestra;
    }

    public String getProvincia_muestra() {
        return provincia_muestra;
    }

    public void setProvincia_muestra(String provincia_muestra) {
        this.provincia_muestra = provincia_muestra;
    }

    public String getDistrito_muestra() {
        return distrito_muestra;
    }

    public void setDistrito_muestra(String distrito_muestra) {
        this.distrito_muestra = distrito_muestra;
    }

    public String getTipo_muestra() {
        return tipo_muestra;
    }

    public void setTipo_muestra(String tipo_muestra) {
        this.tipo_muestra = tipo_muestra;
    }
    
}
