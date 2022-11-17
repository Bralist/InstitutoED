/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ColaDinamica;

/**
 *
 * @author Jesus Joaquin
 */
public interface ColdiInterface {
    public void enqueue(ColdiNodo nuevoNodo); //ENCOLAR 
    public void dequeue();
    public int longitud();
    public ColdiNodo getCabecera();
    public void vaciarCola(ColdiInterface ci);    
    public void imprimirCola();
    public void FiltroEdad(ColdiInterface lista, int edad);
    public void FiltroSexo(ColdiInterface lista, String texto);
    public void FiltroDepartamento(ColdiInterface lista, String texto);
    public void FiltroProvincia(ColdiInterface lista, String texto);
    public void FiltroDistrito(ColdiInterface lista, String texto);
    public void FiltroTipoMuestra(ColdiInterface lista, String texto);
    public void FiltroResultado(ColdiInterface lista, String texto);
}
