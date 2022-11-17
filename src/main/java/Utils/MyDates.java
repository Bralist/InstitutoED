/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jesus Joaquin
 */
public class MyDates {    
    
    private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
    
    //Para convertir los Strings leido en el CSV a Date con el mismo formato
    public static Date getDateToFormat(String date) throws ParseException{        
        Date fecha = formato.parse(date);
        return fecha;
    }
    
    //Para hacer busquedas y mantener el mismo formato
    public static String getDateToString(Date date){
        return formato.format(date);
    }  
            
//    public static StringBuilder getDate(String fecha){
//        StringBuilder sb = new StringBuilder();
//        sb.append(MyDates.getAnho(fecha));
//        sb.append(MyDates.getMes(fecha));
//        sb.append(MyDates.getDia(fecha));
//        return sb;
//    }
    
//    public static StringBuilder getAnho(String fecha){                
//        StringBuilder anho = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            anho.append(fecha.charAt(i));            
//        }
//        return anho;
//    }
//    
//    public static StringBuilder getMes(String fecha){
//        StringBuilder mes = new StringBuilder();
//        for (int i = 5; i < 7; i++) {
//            mes.append(fecha.charAt(i));            
//        }
//        return mes;
//    }
//    
//    public static StringBuilder getDia(String fecha){
//        StringBuilder dia = new StringBuilder();
//        for (int i = 8; i < 10; i++) {
//            dia.append(fecha.charAt(i));            
//        }
//        return dia;
//    }
}
