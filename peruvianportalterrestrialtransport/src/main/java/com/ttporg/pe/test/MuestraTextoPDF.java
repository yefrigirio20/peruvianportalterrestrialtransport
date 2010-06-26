package com.ttporg.pe.test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * @author Cesar Ricardo.
 * @clase: MuestraTextoPDF.java
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
 *              http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class MuestraTextoPDF{

	private static final String	RUTA_PATH	= System.getProperty( "user.dir" );
	private static final String	FICHERO		= "Reporte_2010.pdf";


	/**
	 * main
	 * 
	 * @param argumentos
	 */
	public static void main( String[] argumentos ){
		String tituloPDF = "...::: PROFILE 2010 :::...";
		String textPDF = " Cesar Ricardo Guerra Arnaiz: " + "\n" + "\n" + " Informático, interesado en Tecnología, Herramientas OpenSource, Motores de Datos, Lenguajes de Programación, " + " Frameworks, WebService, XML, SOA, Message Broker, Websphere, Ides, Ajax, etc. Abocado y especializado a todo " + " lo relacionado al mundo JAVA. ";
		MuestraTextoPDF pdf = new MuestraTextoPDF();
		pdf.muestraTextoEnPDF( textPDF, tituloPDF );
	}

	/**
	 * muestraTextoEnPDF
	 * 
	 * @param textPDF
	 * @param tituloPDF
	 */
	public void muestraTextoEnPDF( String textPDF, String tituloPDF ){
		int ancho = 800;
		int alto = 600;
		Rectangle objRectangulo = null;
		Document objDocumento = null;
		Paragraph objParagraph = null;
		File archivoSalida = null;
		FileOutputStream archivoOutput = null;
		String rutaFichero = null;
		try{
			objRectangulo = new Rectangle( ancho, alto );
			objDocumento = new Document( objRectangulo );
			archivoOutput = new FileOutputStream( FICHERO );
			PdfWriter.getInstance( objDocumento, archivoOutput );
			objDocumento.addTitle( tituloPDF );
			objDocumento.open();
			objParagraph = new Paragraph( textPDF );
			objDocumento.add( objParagraph );
			rutaFichero = ( RUTA_PATH + "/" + FICHERO );
			System.out.println( "RUTA PATH: " + rutaFichero );
			archivoSalida = new File( rutaFichero );
		}
		catch( IOException e ){
			e.printStackTrace();
		}
		catch( Exception e ){
			e.printStackTrace();
		}
		finally{
			if( objDocumento != null ){
				if( objDocumento.isOpen() == true ){
					objDocumento.close();
				}
			}
		}
		try{
			// Manda Abrir Fichero 'PDF'.
			// Desktop.getDesktop().open( archivoSalida );
			Runtime.getRuntime().exec( "rundll32 url.dll, FileProtocolHandler " + archivoSalida );
		}
		catch( Exception e ){
			e.printStackTrace();
		}
	}
}
