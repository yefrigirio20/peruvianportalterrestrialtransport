package com.ttporg.pe.test;

import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.servicio.EmpresaService;
import com.ttporg.pe.servicio.impl.EmpresaServiceImpl;
import com.ttporg.pe.util.ManejoEncriptacion;
 
/**
 * @author Cesar Ricardo.
 * @clase: Test.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Test{

	static ManejoEncriptacion xxx = new ManejoEncriptacion(); 
	
	/**
	 * @param  argumentos
	 * @throws Exception 
	 */
	public static void main( String[] argumentos ) throws Exception{

		EmpresaService servicio = new EmpresaServiceImpl();
				 
	    Empresa empresa =  new Empresa();
	    empresa.setUsuario(  "RGUERRA" );
	    empresa.setPassword( "SqrAquYuou8=" );    //Sacar del Script de la 'BD'.

		empresa = servicio.loginEmpresa( empresa );

		System.out.println( "Empresa: " + empresa );
		
		String cadena = xxx.encriptarCIPHER( "ADMIN" );		
		System.out.println( "CADENA ENCRIPTADA: " + cadena );
		
		cadena = xxx.desencriptarCIPHER( cadena );
		System.out.println( "CADENA DESENCRIPTADA: " + cadena );
	}
	
}
