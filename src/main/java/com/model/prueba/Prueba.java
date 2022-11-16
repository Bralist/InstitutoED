/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.prueba;

import com.model.muestra.Muestra;
import com.model.paciente.Paciente;
import java.util.Date;

/**
 *
 * @author JESUS
 */
public class Prueba {
    //ATRIBUTOS
    private Date fecha_corte;
    private String institucion;
    private String resultado;
    private Paciente paciente;
    private Muestra muestra;
    //METODOS GETTER AND SETTER
    public Date getFecha_corte() {
        return fecha_corte;
    }

    public void setFecha_corte(Date fecha_corte) {
        this.fecha_corte = fecha_corte;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Muestra getMuestra() {
        return muestra;
    }

    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }
    
}
