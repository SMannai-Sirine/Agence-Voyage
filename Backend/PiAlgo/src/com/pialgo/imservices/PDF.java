/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import interfaces.Ivol;

/**
 *
 * @author Sémia
 */
public class PDF {
    
    Ivol sV = new ServiceVol(); 
    
    
    public void AfficherPdf() {
    try {
       	//Create Document instance.
	Document document = new Document();
 
	//Create OutputStream instance.
	OutputStream outputStream = 
		new FileOutputStream(new File("H:\\Liste des vols.pdf"));
 
	//Create PDFWriter instance.
        PdfWriter.getInstance(document, outputStream);
 
        //Open the document.
        document.open();
 
        //Add content to the document.
        document.add(new Paragraph("Liste des vols"));
        document.add(new Paragraph(""+sV.afficherVol()));
        //Close document and outputStream.
        document.close();
        outputStream.close();
 
        System.out.println("Pdf created successfully.");
    } catch (Exception e) {
	e.printStackTrace();
    }
    }
    
}
