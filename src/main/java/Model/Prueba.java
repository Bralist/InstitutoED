/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author JESUS
 */
public class Prueba {
    //ATRIBUTOS
    private String UUID;
    private Date fecha_muestra;
    private Date fecha_corte;
    private int edad;
    private String sexo;
    private String institucion;
    private String ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;

    private String dep_muestra;
    private String prov_muestra;
    private String dist_muestra;
    private String tipo_muestra;
    private String resultado;

    //CONSTRUCTORES
    public Prueba(Date fecha_corte, String uuid, Date fecha_muestra, int edad, String sexo,
            String institucion, String ubigeo, String departamento, String provincia, String distrito,
            String dep_muestra, String prov_muestra, String dist_muestra, String tipo_muestra, String resultado) {  
        this.UUID = uuid;
        this.fecha_muestra = fecha_muestra;
        this.fecha_corte = fecha_corte;
        this.edad = edad;
        this.sexo = sexo;
        this.institucion = institucion;
        this.ubigeo = ubigeo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.dep_muestra = dep_muestra;
        this.prov_muestra = prov_muestra;
        this.dist_muestra = dist_muestra;
        this.tipo_muestra = tipo_muestra;
        this.resultado = resultado;
    }
    
    //METODOS GETTER AND SETTER
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Date getFecha_muestra() {
        return fecha_muestra;
    }

    public void setFecha_muestra(Date fecha_muestra) {
        this.fecha_muestra = fecha_muestra;
    }

    public Date getFecha_corte() {
        return fecha_corte;
    }

    public void setFecha_corte(Date fecha_corte) {
        this.fecha_corte = fecha_corte;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDep_muestra() {
        return dep_muestra;
    }

    public void setDep_muestra(String dep_muestra) {
        this.dep_muestra = dep_muestra;
    }

    public String getProv_muestra() {
        return prov_muestra;
    }

    public void setProv_muestra(String prov_muestra) {
        this.prov_muestra = prov_muestra;
    }

    public String getDist_muestra() {
        return dist_muestra;
    }

    public void setDist_muestra(String dist_muestra) {
        this.dist_muestra = dist_muestra;
    }

    public String getTipo_muestra() {
        return tipo_muestra;
    }

    public void setTipo_muestra(String tipo_muestra) {
        this.tipo_muestra = tipo_muestra;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
        
    @Override
    public String toString() {
        return "UUID: " + UUID + ", Edad: " + edad + ", Sexo: " + sexo;
    }
}
