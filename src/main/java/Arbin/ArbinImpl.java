/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbin;

import Utils.MyDates;
import static View.BusquedasView.initDatos;
import static View.BusquedasView.initDatosBusqueda;
import javax.swing.JOptionPane;

/**
 *
 * @author JESUS
 */
public class ArbinImpl implements ArbinInterface {
    //ATRIBUTOS
    private ArbinNodo inicial;
    //CONSTRUCTORES
    public ArbinImpl() {
        this.inicial = null;        
    }
    //METODOS GETTER AND SETTER
    public ArbinNodo getInicial() {
        return this.inicial;
    }

    public void setInicial(ArbinNodo inicial) {
        this.inicial = inicial;
    }
    
    //METODOS PUBLICOS
    @Override
    public void añadir(ArbinNodo nodo) {        
        this.insertarNodo(nodo, this.inicial);
    }
    
    private void insertarNodo(ArbinNodo nodo, ArbinNodo raiz){
        //CASO BASE
        if(raiz == null){
            //Nodo NUEVO ingresa como NODO PADRE
            this.setInicial(nodo);
        }else{ //CASO GENERAL donde NODO PADRE ya existe            
            //NODO NUEVO < NODO PADRE -> Pasamos a NODO IZQUIERDA
            if( Integer.parseInt(nodo.getPrueba().getUUID()) <= Integer.parseInt(raiz.getPrueba().getUUID())){
                //Si NODO IZQUIERDA está vacio, agregamos nodo NUEVO
                if(raiz.getNodoIzq() == null){
                    raiz.setNodoIzq(nodo);
                } else{
                    //Recursividad, pasamos NODO IZQUIERDA como RAIZ
                    insertarNodo(nodo, raiz.getNodoIzq());
                }
            }
            else{
                //NODO NUEVO > NODO PADRE -> Pasamos a NODO DERECHA
                //Si NODO DERECHA está vacio, agregamos nodo NUEVO
                if(raiz.getNodoDer() == null){
                    raiz.setNodoDer(nodo);
                } else{
                    //Recursividad, pasamos NODO DERECHA como RAIZ
                    insertarNodo(nodo, raiz.getNodoDer());
                }
            }
        }
    }

    @Override
    public void ImprimirInorden() {
        Inorden(this.inicial);
    }
    
    private void Inorden(ArbinNodo raiz) {        
        if(raiz != null){
            Inorden(raiz.getNodoIzq());  
            initDatos(raiz.getPrueba());
            Inorden(raiz.getNodoDer());
        }     
    }
    
    @Override
    public void ImprimirBusqueda(int opcion, ArbinNodo raiz, String Busqueda){
        switch(opcion){
            case 1: //Busqueda por UUID
                JOptionPane.showMessageDialog(null, "Busqueda por UUID");
                BusquedaUUID(raiz,Busqueda);
                break;
            case 2: //Busqueda por FECHA MUESTRA
                JOptionPane.showMessageDialog(null, "Busqueda por FECHA MUESTRA");
                BusquedaFecha(raiz,Busqueda);
                break;
            case 3: //Busqueda por FECHA INSTITUCION
                JOptionPane.showMessageDialog(null, "Busqueda por INSTITUCION");
                BusquedaINS(raiz,Busqueda);
                break;
            case 4: //Busqueda por UBIGEO
                JOptionPane.showMessageDialog(null, "Busqueda por UBIGEO");
                BusquedaUBG(raiz,Busqueda);
                break;
        }        
    }
    
    private void BusquedaUUID(ArbinNodo nodo, String UUID) {
        if (nodo != null) {
            BusquedaUUID(nodo.getNodoIzq(),UUID);
            if (nodo.getPrueba().getUUID().equals(UUID)){
                initDatosBusqueda(nodo.getPrueba());
            }
            BusquedaUUID(nodo.getNodoDer(), UUID);
        }                   
    }    
    
    private void BusquedaFecha(ArbinNodo nodo, String Fechamuestra) {
        if (nodo != null) {
            BusquedaFecha(nodo.getNodoIzq(),Fechamuestra);
            if (MyDates.getDateToString(nodo.getPrueba().getFecha_muestra()).equals(Fechamuestra)){
                initDatosBusqueda(nodo.getPrueba());
            }
            BusquedaFecha(nodo.getNodoDer(), Fechamuestra);
        }
    }
    
    private void BusquedaINS(ArbinNodo nodo, String INS) {
        if (nodo != null) {
            BusquedaINS(nodo.getNodoIzq(),INS);
            if (nodo.getPrueba().getInstitucion().equals(INS)){
                initDatosBusqueda(nodo.getPrueba());
            }
            BusquedaINS(nodo.getNodoDer(), INS);
        }
    }
    
    private void BusquedaUBG(ArbinNodo nodo, String UBG) {
        if (nodo != null) {
            BusquedaUBG(nodo.getNodoIzq(),UBG);
            if (nodo.getPrueba().getUbigeo().equals(UBG)){
                initDatosBusqueda(nodo.getPrueba());
            }
            BusquedaUBG(nodo.getNodoDer(), UBG);
        }
    }    
}
