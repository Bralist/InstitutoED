/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import Model.Prueba;
import Arbin.ArbinImpl;
import Arbin.ArbinNodo;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Joaquin
 */
public class MyReader {
    
    public static final char SEPARATOR= ';';
    
    //Metodo para leer archivo CSV Usuarios
    public boolean ReaderCSV_Session(String usuario, String password) {
        //Inicializacion de dato boolean activo
        boolean activo = false;
        //Inicializacion de CSVReader
        CSVReader reader = null;
        try {
            //Instancia de CSVReader mas intancia de FileReader con dirección de ubicacion del archivo
            reader = new CSVReader(new FileReader("src\\main\\resources\\csv\\USUARIOS.csv"), SEPARATOR);
            //Inicialización de caberacera y nextLine
            String[] cabecera = null;
            String[] nextLine = null;
            int cont = 0;
            //While para recorrer el archivo fila por fila
            //Entramos solo si la fila a recorrer es diferente de NULL
            while ((nextLine = reader.readNext()) != null) {
                //Condicional para evitar la primera fila usuario,contraseña
                if (cont == 0) {
                    cabecera = nextLine;
                } else {
                    //Comparamos el usuario y contraseña ingresado con los del CSV
                    if (nextLine[0].equals(usuario) && nextLine[1].equals(password)){
                        //Si se accede al if, encontró un usuario valido
                        //Retornamos TRUE
                        activo = true;
                        //Paramos el while
                        break;
                    } 
                }
                cont++;
            }            
        } catch (IOException | NumberFormatException e) {
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return activo;
    }        
    
    //Metodo para leer archivo CSV Pruebas
    //public void ReaderCSV_Pruebas(ArbinImpl ao) {
    public void ReaderCSV_Pruebas(ArbinImpl ao) {        
        //Inicializacion de CSVReader
        CSVReader reader = null;
        try {
            //Instancia de CSVReader mas intancia de FileReader con dirección de ubicacion del archivo
            reader = new CSVReader(new FileReader("src\\main\\resources\\csv\\PRUEBAS_COVID_CSV.csv"), SEPARATOR);
            //Inicialización de caberacera y nextLine
            String[] cabecera = null;
            String[] nextLine = null;            
            System.out.println("Leyendo CSV...");
            int cont = 0;
            //While para recorrer el archivo fila por fila
            //Entramos solo si la fila a recorrer es diferente de NULL
            while ((nextLine = reader.readNext()) != null) {                
                //Condicional para evitar la primera fila usuario,contraseña
                if (cont == 0) {
                    cabecera = nextLine;
                } else { 
                    //Creamos un objeto Prueba por cada lectura de fila del CSV
                    Prueba p = new Prueba(MyDates.getDateToFormat(nextLine[0]), nextLine[1],
                            MyDates.getDateToFormat(nextLine[2]),Integer.parseInt(nextLine[3]),
                            nextLine[4], nextLine[5], nextLine[6],nextLine[7], nextLine[8],
                            nextLine[9], nextLine[10], nextLine[11],nextLine[12],
                            nextLine[13], nextLine[14]);
                    //Añadimos al arbol el objeto Prueba
                    //System.out.println("Linea: "+cont+" -> "+p.toString());
                    ao.añadir(new ArbinNodo(p));                      
                }
                cont++;                
            }
            System.out.println("Lectura del CSV finalizada");
        } catch (IOException | NumberFormatException e) {
        } catch (ParseException ex) {
            Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
