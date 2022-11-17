/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaEnlazada;

/**
 *
 * @author JESUS
 */
public class ListenNodo {
    //ATRIBUTOS
    private Object elemento; //elemento / contenido
    private ListenNodo siguiente; //puntero al siguiente elemento
    //CONSTRUCTORES
    //Nodo solo, no tiene enlace al siguiente
    public ListenNodo(Object obj) {
        this.elemento = obj;
        this.siguiente = null;
    }
    //Nodo con puntero a siguiente elemento
    public ListenNodo(Object obj, ListenNodo n) {
        this.elemento = obj;
        this.siguiente = n;
    }
    //METODOS GETTER AND SETTER
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public ListenNodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ListenNodo siguiente) {
        this.siguiente = siguiente;
    }
}
