/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaEnlazada;

/**
 *
 * @author JESUS
 */
public class ListenImpl implements ListenInterface{
    //Puntero al primer elemento de la lista
    private ListenNodo cabecera;
    //CONSTRUCTOR
    public ListenImpl() {
        this.cabecera = new ListenNodo(null);
    }
    //METODOS PRIVADOS    
    public boolean estaVacia() {
        if (this.cabecera.getElemento() == null) {
            return true;
        } else {
            return false;
        }
    }
    
    private ListenNodo buscarUltimoNodo() {   
        //asigna el Primer Elemento, cabecera
        ListenNodo iterador = this.cabecera;
        //recorre los elementos de la Lista hasta llegar al Final
        while (iterador.getSiguiente() != null) {
            iterador = iterador.getSiguiente();
        }
        return iterador;
    }
    
    @Override
    public void insertarFinal(ListenNodo nuevoNodo) {
        //verifica si la Lista está vacia
        if(this.estaVacia())
            this.cabecera = nuevoNodo;  //asigna el Nuevo Nodo a la Cabecera  
        else //si la Lista no está vacia
        {   //recorre la lista y busca el último nodo
            ListenNodo nodoUltimo = buscarUltimoNodo();
            //agrega al final el Nuevo Nodo
            nodoUltimo.setSiguiente(nuevoNodo);
            //puntero nuevo nodo es Nulo (fin de la lista)
            nuevoNodo.setSiguiente(null);
        }  
    }
    
    @Override
    public String imprimirLista() { //(Parametros)S   
        String cadena = "";
        //APUNTA A LA CABECERA
        ListenNodo iterador = this.cabecera;
        int con = 1;
        //RECORRE LA LISTA
        while (iterador != null) {   //CONCATENA EL CONTENIDO DEL NODO A LA CADENA DE TEXTO
            if (iterador.getElemento() != null){ //Paciente p = iterador.getElemento();
            //if(p.getUUID.equals(txtData) &&            
                cadena += String.valueOf(con + ".-" + iterador.getElemento().toString()) + " => ";
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
            con++;
        }
        //System.out.println(cadena);//IMPRIME CONTENIDO DE LISTA ENLAZADA
        return cadena;
    }
    
    @Override
    public int longitud() {
        ListenNodo iterador = this.cabecera;
        int con = 1;
        while (iterador.getSiguiente() != null) {
            iterador = iterador.getSiguiente();
            con++;
        }
        return con;
    }  
}
