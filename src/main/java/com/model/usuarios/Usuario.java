/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.usuarios;

import java.util.Date;

/**
 *
 * @author JESUS
 */
public class Usuario {
    //ATRIBUTOS
    private Integer id_usuario;
    private String usuario;
    private String contraseña;
    private Date fecha_ingreso;
    //CONSTRUCTOR
    public Usuario(Integer id) {
        this.id_usuario = id;
    }
    //METODOS GETTER AND SETTER
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }        
    
}
