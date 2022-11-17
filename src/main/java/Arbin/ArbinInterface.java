/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Arbin;

/**
 *
 * @author JESUS
 */
public interface ArbinInterface {
    //Inserta un nodo prueba en un nodo izquierdo o derecho
    public void añadir(ArbinNodo nodo);
    //Imprime en consola en el siguiente formato: raiz - izquierdo - derecho
    public void ImprimirInorden();
    public void ImprimirBusqueda(int opcion, ArbinNodo nodo,String Busqueda);
}
