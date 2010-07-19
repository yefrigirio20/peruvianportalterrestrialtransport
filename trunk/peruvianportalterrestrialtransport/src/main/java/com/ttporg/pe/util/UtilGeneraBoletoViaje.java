package com.ttporg.pe.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.bean.Transaccion;
import com.ttporg.pe.bean.Vehiculo;
import com.ttporg.pe.test.MuestraTextoPDF;

/**
 * @author Cesar Ricardo.
 * @clase: MuestraTextoPDF.java
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
 *              http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class UtilGeneraBoletoViaje{

	private static final String	RUTA_PATH	= System.getProperty( "user.dir" );
	private static final String	FICHERO		= "Reporte_2010.pdf";

	/**
	 * main
	 * 
	 * @param argumentos
	 */
	public static void main( String[] argumentos ){
		
		UtilGeneraBoletoViaje xxx = new UtilGeneraBoletoViaje();
		xxx.muestraBoletoViaje();
	}
 
	public void muestraBoletoViaje(){
			/*	
		String tituloPDF = "...::: BOLETO DE VIAJE :::...";
 
		UtilGeneraBoletoViaje pdf = new UtilGeneraBoletoViaje();
					
		// Seteando datos en 'Session'.
		Transaccion objTransaccion = new Transaccion();
 
		Cliente objCliente = new Cliente();
		objCliente.setId( 1 );
		objCliente.setNombres( "Cesar Ricardo" );
		objCliente.setApellidos( "Guerra Arnaiz" );
		
		Pago objPago = new Pago();
		objPago.setId( 1 );
		objPago.setNumTarjeta( "3563 4355 3222 6446" );
		objPago.setTipoPago( "Efectivo" );
		objPago.setCliente( objCliente );
		
     	//------------------------ APLICACION DE SINGLETON ------------------------//
		UtilSingleton utilSingleton = UtilSingleton.getINSTANCIA_GUARDADA();
	     
		Cliente objClienteSingleton = null;
		Pago    objPagoSingleton    = null;
		
        if( utilSingleton != null && 
            utilSingleton.getObjetoSingleton() != null && 
            utilSingleton.getObjetoSingleton().getCliente() != null  ){
	    	
        	objClienteSingleton = utilSingleton.getObjetoSingleton().getCliente();
        	objCliente          = objClienteSingleton;
	    }
        
        if( utilSingleton != null && 
            utilSingleton.getObjetoSingleton() != null && 
            utilSingleton.getObjetoSingleton().getPago() != null  ){
    	    	
        	objPagoSingleton = utilSingleton.getObjetoSingleton().getPago();
        	objPago          = objPagoSingleton;	
    	}
		//----------------------------------------------------------------------//
		
		Empresa objEmpresa = new Empresa();
		objEmpresa.setId( 1 );
		objEmpresa.setRazonSocial( "Cruz del Sur" );
		objEmpresa.setDireccion( "Av. Javier Prado 1109 - La Victoria" );
		
		Vehiculo objVehiculo = new Vehiculo();
		objVehiculo.setId( 1 );
		objVehiculo.setNombre( "Cruzero" );
		objVehiculo.setTipo( "Bus" );
		objTransaccion.setIdT( 1 );
		objTransaccion.setPago( objPago );
		objTransaccion.setEmpresa( objEmpresa );
		objTransaccion.setCliente( objCliente );
		objTransaccion.setVehiculo( objVehiculo );
		objTransaccion.setIdAsiento( 20 );
		objTransaccion.setMonto( 45.00 );
        
		//String tituloPDF = "Comprobante Pago";
		String textPDF = "Nombre de Cliente : " + objTransaccion.getCliente().getNombres() + " " + objTransaccion.getCliente().getApellidos() + "\n" + "Empresa Transporte   : " + objTransaccion.getEmpresa().getRazonSocial() + " Direccion Empresa: " + objTransaccion.getEmpresa().getDireccion() + "\n" + "\n" + "Lugar de salida      : Lima                     Lugar de Destino    : Puno " + "\n" + "Fecha y hora salida  : 2010-06-30 06:00 a.m.    Duracion Estimada   : 20hras." + "\n" + "Tipo Vehiculo        : " + objTransaccion.getVehiculo().getNombre() + " - " + objTransaccion.getVehiculo().getTipo() + "  Nro. Asiento : " + objTransaccion.getIdAsiento() + "\n" + "\n" + "Pago " + "\n" + "Nro. Tarjeta " + objTransaccion.getPago().getNumTarjeta() + " Pago Total : " + objTransaccion.getMonto().toString();
 
		//GUI		
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
		}*/
	}
}
