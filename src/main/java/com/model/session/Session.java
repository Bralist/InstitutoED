/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model.session;

import com.model.usuarios.Usuario;

/**
 *
 * @author JESUS
 */
public class Session {
    
    public static Usuario usuario;

    public Session(Usuario usuario) {
        Session.usuario = usuario;
    }
        
}
