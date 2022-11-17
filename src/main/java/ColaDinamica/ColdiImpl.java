/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColaDinamica;

import static View.BusquedasView.initDatos;

/**
 *
 * @author Jesus Joaquin
 */
public class ColdiImpl implements ColdiInterface{
    //puntero al primer elemento de la Lista
    private  ColdiNodo cabecera;
    //CONSTRUCTOR
    public ColdiImpl()
    {
        this.cabecera = new ColdiNodo(null);
    } 
    //METODOS PRIVADOS
    private boolean estaVacia() {
        if (this.cabecera.getElemento() == null) {
            return true;
        } else {
            return false;
        }
    }
    private ColdiNodo buscarUltimoNodo()
    {   //asigna el Primer Elemento, cabecera
        ColdiNodo iterador = this.cabecera;
        //recorre los elementos de la Lista hasta llegar al Final
        while(iterador.getSiguiente()!=null)
            iterador = iterador.getSiguiente();

        return iterador;
    }          
    
    //METODOS PUBLICOS
    @Override
    public void enqueue(ColdiNodo nuevoNodo) {	//verifica si la Lista está vacia
        if (this.estaVacia()) {
            this.cabecera = nuevoNodo;  //asigna el Nuevo Nodo a la Cabecera  
        } else {   //recorre la lista y busca el último nodo
            ColdiNodo nodoUltimo = buscarUltimoNodo();
            //agrega al final el Nuevo Nodo
            nodoUltimo.setSiguiente(nuevoNodo);
            //puntero nuevo nodo es Nulo (fin de la lista)
            nuevoNodo.setSiguiente(null);
        }
    }
    
    @Override
    public void dequeue() {
        ColdiNodo iterador = this.cabecera;     //recorre la lista
        ColdiNodo nodoEliminar = null;          //nodo eliminado
        //CASO 1. Si la Lista esta vacia
        if (this.estaVacia()) {
            System.out.println("Error esta vacia la COLA");
        }
        //CASO 2. SOLO TIENE el Primer Elemento
        if (iterador.getSiguiente() == null) {
            nodoEliminar = this.cabecera;
            this.cabecera.setElemento(null);
        } else {   //CASO 3. Lista con Nodos
            nodoEliminar = iterador;
            this.cabecera = iterador.getSiguiente();
        }        
    }
    
    @Override
    public int longitud() {
        ColdiNodo iterador = this.cabecera;
        int con = 1;
        while (iterador.getSiguiente() != null) {
            iterador = iterador.getSiguiente();
            con++;
        }
        return con;
    }
    
    @Override
    public ColdiNodo getCabecera() {
        return cabecera;
    }
    
    @Override
    public void vaciarCola(ColdiInterface ci) {
        int tamaño = ci.longitud();
        int con = 1;
        while (con <= tamaño) {
            ci.dequeue();
            con++;
        }
    }
    
    @Override
    public void imprimirCola() { 
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }
        String cadena = "";
        //APUNTA A LA CABECERA
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                initDatos(iterador.getElemento());
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }
    }
    
    @Override
    public void FiltroEdad(ColdiInterface lista, int edad){        
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }                
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                if(iterador.getElemento().getEdad() == edad){
                    lista.enqueue(new ColdiNodo(iterador.getElemento()));
                }
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }
    }
    
    @Override
    public void FiltroSexo(ColdiInterface lista, String sexo){        
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }                
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                if(iterador.getElemento().getSexo().equals(sexo)){
                    lista.enqueue(new ColdiNodo(iterador.getElemento()));
                }
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }
    }
    
    @Override
    public void FiltroDepartamento(ColdiInterface lista, String filtro){        
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }                
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                if(iterador.getElemento().getDepartamento().equals(filtro)){
                    lista.enqueue(new ColdiNodo(iterador.getElemento()));
                }
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }
    }
    
    @Override
    public void FiltroProvincia(ColdiInterface lista, String provincia){        
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }                
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                if(iterador.getElemento().getProvincia().equals(provincia)){
                    lista.enqueue(new ColdiNodo(iterador.getElemento()));
                }
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }     
    }
    
    @Override
    public void FiltroDistrito(ColdiInterface lista, String distrito){        
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }                
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                if(iterador.getElemento().getDistrito().equals(distrito)){
                    lista.enqueue(new ColdiNodo(iterador.getElemento()));
                }
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }
    }
    
    @Override
    public void FiltroTipoMuestra(ColdiInterface lista, String tipo){        
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }                
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                if(iterador.getElemento().getTipo_muestra().equals(tipo)){
                    lista.enqueue(new ColdiNodo(iterador.getElemento()));
                }
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }
    }
    
    @Override
    public void FiltroResultado(ColdiInterface lista, String resultado){        
        if (this.estaVacia()) {            
            System.out.println("Error: La cola dinamica está vacia");
        }                
        ColdiNodo iterador = this.cabecera;
        //RECORRE LA LISTA
        while (iterador != null) {
            if (iterador.getElemento() != null) {                
                if(iterador.getElemento().getResultado().equals(resultado)){
                    lista.enqueue(new ColdiNodo(iterador.getElemento()));
                }
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        } 
    }
    
}
