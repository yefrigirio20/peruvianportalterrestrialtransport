package com.ttporg.pe.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.bean.Transaccion;
import com.ttporg.pe.bean.Vehiculo;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: UtilGeneraBoletoViaje.java
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
 
	//Service ...
	private ServiceFactory servicio = null;
	
	{
	 this.servicio = new ServiceFactory();
	}
	
    /**
     * muestraBoletoViaje
     * @param objCliente
     * @param objPago
     * @param idServicio
     * @param idAsientoSeleccionado
     **/
	public void muestraBoletoViaje( Cliente objCliente,        Pago objPago, 
			                        String codigoDepartamento, String codigoEmpresa,
			                        String codigoAgencia,      String codigoServicio, 
			                        String codigoAsiento ){
			 	
		String tituloPDF = "...::: BOLETO DE VIAJE :::...";
 
		UtilGeneraBoletoViaje pdf = new UtilGeneraBoletoViaje();
				
		Departamento objDepartamento = (Departamento)this.servicio.getDepartamentoDAO().obtenerObjetoDepartamento_x_codigo( Integer.parseInt( codigoDepartamento ) );
		Empresa      objEmpresa      = (Empresa)this.servicio.getEmpresaDAO().obtenerObjetoEmpresa_x_codigo(   Integer.parseInt( codigoEmpresa ) );
		//Agencia      objAgencia      = (Agencia)this.servicio.getAgenciaDAO().obtenerObjetoAgencia_x_codigo(   Integer.parseInt( codigoAgencia ) );
		//Servicio     objServicio     = (Servicio)this.servicio.getServicioDAO().obtenerObjetoServicio_x_codigo( Integer.parseInt( codigoServicio ) );
		Asiento      objAsiento      = (Asiento)this.servicio.getAsientoDAO().obtenerObjetoAsiento_x_codigo( Integer.parseInt( codigoAsiento ) );

		
		System.out.println( "objDepartamento: " + objDepartamento );
		System.out.println( "objEmpresa:      " + objEmpresa  );
		System.out.println( "objAsiento:      " + objAsiento  );
		
		//Seteando datos en 'Session'.
		Transaccion objTransaccion = new Transaccion();
 		
		Vehiculo objVehiculo = new Vehiculo();
		objVehiculo.setNombre( "VOLVO"  );
		objVehiculo.setTipo(   "1 PISO" );
		
		Agencia objAgencia = new Agencia();
		objAgencia.setId( Integer.parseInt( codigoAgencia ) );
		
		Servicio objServicio = new Servicio();
		objServicio.setId( Integer.parseInt( codigoServicio ) );
		
		System.out.println( "objAgencia:      " + objAgencia  );
		System.out.println( "objServicio:     " + objServicio );
		
		objTransaccion.setId( 1 );
		objTransaccion.getEmpresa().setDepartamento( objDepartamento );
		objTransaccion.setEmpresa(   objEmpresa  );
		objTransaccion.setCliente(   objCliente  );
		objTransaccion.setAgencia(   objAgencia  );
		objTransaccion.setServicio(  objServicio );
		objTransaccion.setSalida(    null  );
		objTransaccion.setVehiculo(  objVehiculo );
		objTransaccion.setAsiento(   objAsiento  );
         
		//String tituloPDF = "Comprobante Pago";
		String textPDF = "Nombre de Cliente : " + objTransaccion.getCliente().getNombres() + " " + objTransaccion.getCliente().getApellidos() + 
		"\n" + "Empresa Transporte   : " + objTransaccion.getEmpresa().getRazonSocial() + 
		" Nombre Empresa: " + objTransaccion.getEmpresa().getRazonSocial() + "\n" + "\n" + "Lugar de salida      : Lima                     Lugar de Destino    : Puno " + "\n" + 
		"Fecha y hora salida  : 2010-06-30 06:00 a.m.    Duracion Estimada   : 20hras." + "\n" + "Tipo Vehiculo        : " + 
		objTransaccion.getVehiculo().getNombre() + " - " + objTransaccion.getVehiculo().getTipo() + "  Nro. Asiento : " + 
		objTransaccion.getAsiento().getId() + "\n" + "\n" + "\n" /*+ "Nro. Tarjeta " + objTransaccion.get.getNumTarjeta() */ + 
		" Pago Total : " + 45;
		 
		//GUI		
		int ancho = 800;
		int alto  = 600;
		
		Rectangle        objRectangulo = null;
		Document         objDocumento  = null;
		Paragraph        objParagraph  = null;
		File             archivoSalida = null;
		FileOutputStream archivoOutput = null;
		String           rutaFichero   = null;
		
		try{
			objRectangulo = new Rectangle( ancho, alto );
			objDocumento  = new Document( objRectangulo );
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
			//Manda Abrir Fichero 'PDF'.
			Runtime.getRuntime().exec( "rundll32 url.dll, FileProtocolHandler " + archivoSalida );
		}
		catch( Exception e ){
			e.printStackTrace();
		} 
	}
	
}
