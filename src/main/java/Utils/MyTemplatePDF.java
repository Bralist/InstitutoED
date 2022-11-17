/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import ColaDinamica.ColdiImpl;
import ColaDinamica.ColdiInterface;
import ColaDinamica.ColdiNodo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author JESUS
 */
public class MyTemplatePDF {
    String nombreDirector, fecha;
    ColdiInterface pruebas = new ColdiImpl();   
    ColdiNodo iterador;    
    FileOutputStream archivo;
    Paragraph titulo;    

    public MyTemplatePDF(String nombreDirector, String fecha,
            ColdiInterface pruebas) {
        this.nombreDirector = nombreDirector;
        this.fecha = fecha;        
        this.pruebas = pruebas;       
    }
    
    public void crearPlantilla() {
        String nextlines = "\n\n\n";
        Font fuente = new Font();
        fuente.setStyle(1);
        fuente.setSize(30);
        titulo = new Paragraph(nextlines+"REPORTE DE PRUEBAS COVID - INSTITUTO NACIONAL DE SALUD", fuente);
        
        Document documento = new Document(PageSize.A1.rotate());
        
        Image image = null;
        Image image2 = null;
        try {
            archivo = new FileOutputStream("src\\main\\resources\\exportpdf\\"+nombreDirector + ".pdf");
            PdfWriter writer = PdfWriter.getInstance(documento, archivo);
            documento.open();
            
            titulo.setAlignment(1);
            
            try {
                image = Image.getInstance("src/main/resources/img/logoins.jpg"); //Carga imagen
                image.scaleAbsolute(600,200); //Cambia tamaño
                image.setAbsolutePosition(20, 1460); // Coloca imagen en la pos
                
                image2 = Image.getInstance("src/main/resources/img/logoministerio.png"); //Carga imagen
                image2.scaleAbsolute(600,130); //Cambia tamaño
                image2.setAbsolutePosition(1760, 1510); // Coloca imagen en la pos
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }            
            documento.add(image);//Agrega la imagen al documento  
            documento.add(image2);//Agrega la imagen al documento           
            documento.add(titulo);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            PdfPTable table = crearTabla();
            documento.add(table);
            documento.add(new Paragraph("Fecha del reporte: " + fecha));
            
            JOptionPane.showMessageDialog(null, "El archivo PDF se ha creado correctamente");
            
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (DocumentException e) {
            System.err.println(e.getMessage());
        }
        documento.close();
    }
    
    private PdfPTable crearTabla() {
        PdfPTable tabla = new PdfPTable(15);
        tabla.setWidthPercentage(100);
        PdfPCell fecha_corte = new PdfPCell(new Phrase("FECHA_CORTE"));
        fecha_corte.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell UUID = new PdfPCell(new Phrase("UUID"));
        UUID.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell fecha_muestra = new PdfPCell(new Phrase("FECHA_MUESTRA"));
        fecha_muestra.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell edad = new PdfPCell(new Phrase("EDAD"));
        edad.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell sexo = new PdfPCell(new Phrase("SEXO"));
        sexo.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell institucion = new PdfPCell(new Phrase("INSTITUCIÓN"));
        institucion.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell ubigeo_pac = new PdfPCell(new Phrase("UBIGEO_PACIENTE"));
        ubigeo_pac.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell departamento_pac = new PdfPCell(new Phrase("DEPARTAMENTO_PACIENTE"));
        departamento_pac.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell provincia_pac = new PdfPCell(new Phrase("PROVINCIA_PACIENTE"));
        provincia_pac.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell distrito_pac = new PdfPCell(new Phrase("DISTRITO_PACIENTE"));
        distrito_pac.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell departamento_mues = new PdfPCell(new Phrase("DEPARTAMENTO_MUESTRA"));
        departamento_mues.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell provincia_mues = new PdfPCell(new Phrase("PROVINCIA_MUESTRA"));
        provincia_mues.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell distrito_mues = new PdfPCell(new Phrase("DISTRITO_MUESTRA"));
        distrito_mues.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell tipo_mues = new PdfPCell(new Phrase("TIPO_MUESTRA"));
        tipo_mues.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell resultado = new PdfPCell(new Phrase("RESULTADO"));
        resultado.setBackgroundColor(BaseColor.LIGHT_GRAY);

        tabla.addCell(fecha_corte);
        tabla.addCell(UUID);
        tabla.addCell(fecha_muestra);
        tabla.addCell(edad);
        tabla.addCell(sexo);
        tabla.addCell(institucion);
        tabla.addCell(ubigeo_pac);
        tabla.addCell(departamento_pac);
        tabla.addCell(provincia_pac);
        tabla.addCell(distrito_pac);
        tabla.addCell(departamento_mues);
        tabla.addCell(provincia_mues);
        tabla.addCell(distrito_mues);
        tabla.addCell(tipo_mues);
        tabla.addCell(resultado);

        iterador = pruebas.getCabecera();

        while (iterador != null) {
            if (iterador.getElemento() != null) {
                tabla.addCell(MyDates.getDateToString(iterador.getElemento().getFecha_corte()));
                tabla.addCell(iterador.getElemento().getUUID());
                tabla.addCell(MyDates.getDateToString(iterador.getElemento().getFecha_muestra()));
                tabla.addCell(iterador.getElemento().getEdad() + "");
                tabla.addCell(iterador.getElemento().getSexo());
                tabla.addCell(iterador.getElemento().getInstitucion());
                tabla.addCell(iterador.getElemento().getUbigeo());
                tabla.addCell(iterador.getElemento().getDepartamento());
                tabla.addCell(iterador.getElemento().getProvincia());
                tabla.addCell(iterador.getElemento().getDistrito());
                tabla.addCell(iterador.getElemento().getDep_muestra());
                tabla.addCell(iterador.getElemento().getProv_muestra());
                tabla.addCell(iterador.getElemento().getDist_muestra());
                tabla.addCell(iterador.getElemento().getTipo_muestra());
                tabla.addCell(iterador.getElemento().getResultado());
            }
            //SALTA AL SIGUIENTE NODO
            iterador = iterador.getSiguiente();
        }
        return tabla;
    }    
}
