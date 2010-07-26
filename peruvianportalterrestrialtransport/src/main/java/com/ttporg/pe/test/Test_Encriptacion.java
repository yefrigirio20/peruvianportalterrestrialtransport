package com.ttporg.pe.test;

import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.dao.ServiceFactory;
import com.ttporg.pe.util.UtilEncriptacion;
 
/**
 * @author Cesar Ricardo.
 * @clase: Test_Encriptacion.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Test_Encriptacion{

	private static UtilEncriptacion encriptacion = new UtilEncriptacion(); 	
	private static ServiceFactory   servicio     = null;
 	
	{
	 encriptacion = new UtilEncriptacion();
	 servicio     = new ServiceFactory(); 
	}
	
	/**
	 * @param  argumentos
	 * @throws Exception 
	 */
	public static void main( String[] argumentos ) throws Exception{
		
	    Empresa empresa =  new Empresa();
	    empresa.setUsuario(  "RGUERRA" );
	    empresa.setPassword( "SqrAquYuou8=" );    //Sacar del Script de la 'BD'.

		empresa = servicio.getEmpresaDAO().loginEmpresa( empresa );

		System.out.println( "Empresa: " + empresa );
		
		String cadena = encriptacion.encriptarCIPHER( "ADMIN" );		
		System.out.println( "CADENA ENCRIPTADA: " + cadena );
		
		cadena = encriptacion.desencriptarCIPHER( cadena );
		System.out.println( "CADENA DESENCRIPTADA: " + cadena );
	}
	
}
