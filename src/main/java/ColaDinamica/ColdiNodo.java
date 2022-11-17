/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColaDinamica;

import Model.Prueba;

/**
 *
 * @author Jesus Joaquin
 */
public class ColdiNodo {
    //ATRIBUTOS
    Prueba elemento;	//elemento / contenido
    ColdiNodo siguiente;	//puntero al siguiente elemento
    //CONSTRUCTORES
    //Nodo Solo, no tiene enlace al siguientes
    public ColdiNodo(Prueba obj) {
        this.elemento = obj;
        this.siguiente = null;
    }
    //Nodo con puntero a siguiente elemento
    public ColdiNodo(Prueba obj, ColdiNodo n) {
        this.elemento = obj;
        this.siguiente = n;
    }
    //METODOS GETTER AND SETTER
    public Prueba getElemento() {
        return elemento;
    }

    public void setElemento(Prueba elemento) {
        this.elemento = elemento;
    }

    public ColdiNodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ColdiNodo siguiente) {
        this.siguiente = siguiente;
    }  
}
