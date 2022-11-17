/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import ColaDinamica.ColdiInterface;
import ColaDinamica.ColdiNodo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Joaquin
 */
public class MyWriter {
    
    //Metodo para REGISTRAR usuarios en el CSV
    public boolean Registrar(String usuario, String password){
        //Inicializacion de dato boolean activo
        boolean activo = false;
        //Inicializacion de BufferedWriter y FileWriter
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            //Inicializacion de cabecera y data
            String cabecera = "";
            String data = "\n"+usuario+";"+password;
            //Instancia de new File con la ruta del archivo CSV
            File file = new File("src\\main\\resources\\csv\\USUARIOS.csv");
            //Condicional para ver si el archivo no existe, si no se crea
            if (!file.exists()) {
                file.createNewFile();
                //Asiganmos a la cabecera usuario y contraseña
                cabecera = "usuario"+";"+"contraseña";
            }
            // getAbsolute nos permite adjuntar(append) información al archivo
            fw = new FileWriter(file.getAbsoluteFile(), true);
            //Mandamos el FileWriter fw como parametro al BufferedWriter
            bw = new BufferedWriter(fw);
            //Mandamos a escribir en el CSV la cabereca y data
            bw.write(cabecera+data);
            //Devolvemos valor TRUE
            activo = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return activo;
    }
    
    //PARA EXPORTAR CSV EN BUSQUEDAS
    public void ExportarCSV(ColdiInterface x, String directorio){       
        ColdiNodo iterador = x.getCabecera();
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String cabecera = "";
            File file = new File("src\\main\\resources\\exportcsv\\"+directorio+".csv");            
            if (!file.exists()) {
                file.createNewFile();
                //Asiganmos a la cabecera usuario y contraseña
                cabecera = "FECHA_CORTE"+";"+
                           "UUID"+";"+
                           "FECHA_MUESTRA"+";"+
                           "EDAD"+";"+
                           "SEXO"+";"+
                           "INSTITUCIÓN"+";"+
                           "UBIGEO_PACIENTE"+";"+
                           "DEPARTAMENTO_PACIENTE"+";"+
                           "PROVINCIA_PACIENTE"+";"+
                           "DISTRITO_PACIENTE"+";"+
                           "DEPARTAMENTO_MUESTRA"+";"+
                           "PROVINCIA_MUESTRA"+";"+
                           "DISTRITO_MUESTRA"+";"+
                           "TIPO_MUESTRA"+";"+
                           "RESULTADO";
            }            
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(cabecera);
            while (iterador != null) {   //CONCATENA EL CONTENIDO DEL NODO A LA CADENA DE TEXTO
                if (iterador.getElemento() != null) {                    
                    String data = "\n"+
                            MyDates.getDateToString(iterador.getElemento().getFecha_corte())+";"+
                            iterador.getElemento().getUUID()+";"+
                            MyDates.getDateToString(iterador.getElemento().getFecha_muestra())+";"+
                            iterador.getElemento().getEdad()+";"+
                            iterador.getElemento().getSexo()+";"+
                            iterador.getElemento().getInstitucion()+";"+
                            iterador.getElemento().getUbigeo()+";"+
                            iterador.getElemento().getDepartamento()+";"+
                            iterador.getElemento().getProvincia()+";"+
                            iterador.getElemento().getDistrito()+";"+
                            iterador.getElemento().getDep_muestra()+";"+
                            iterador.getElemento().getProv_muestra()+";"+
                            iterador.getElemento().getDist_muestra()+";"+
                            iterador.getElemento().getTipo_muestra()+";"+
                            iterador.getElemento().getResultado();
                    bw.write(data);
                }
                //SALTA AL SIGUIENTE NODO
                iterador = iterador.getSiguiente();
            }

            JOptionPane.showMessageDialog(null,"Se ha generado el CSV: "+ directorio);            
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
