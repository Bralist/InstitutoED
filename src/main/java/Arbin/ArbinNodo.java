/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbin;

import Model.Prueba;

/**
 *
 * @author JESUS
 */
public class ArbinNodo {
    //ATRIBUTOS
    private Prueba prueba;
    private ArbinNodo nodoIzq;
    private ArbinNodo nodoDer;
    //CONSTRUCTOR
    public ArbinNodo(Prueba p){
        this.prueba = p;
    }
    //METODOS GETTER AND SETTER
    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public ArbinNodo getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(ArbinNodo nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public ArbinNodo getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(ArbinNodo nodoDer) {
        this.nodoDer = nodoDer;
    }
    
}
