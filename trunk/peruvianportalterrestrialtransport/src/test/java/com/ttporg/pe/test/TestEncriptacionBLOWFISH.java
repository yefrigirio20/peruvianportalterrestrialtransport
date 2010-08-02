package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import com.ttporg.pe.util.UtilEncriptacion;
 
/**
 * @author Cesar Ricardo.
 * @clase: TestEncriptacionBLOWFISH.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class TestEncriptacionBLOWFISH{
	
	private static UtilEncriptacion encriptacion = new UtilEncriptacion(); 	
	
	{
	 encriptacion = new UtilEncriptacion();
	}
	
	/**
     * main
     * @param argumentos
     **/
    public static void main( String[] argumentos ){
    	
    	TestEncriptacionBLOWFISH encriptacion = new TestEncriptacionBLOWFISH();
    	encriptacion.testLoginEmpresa();
    	
        //Permite mostrar el resultado del 'Test' en consola.
        org.junit.runner.JUnitCore.main( "com.ttporg.pe.test.TestEncriptacionBLOWFISH" );        
    }

    @Test
    @Ignore
	public void testLoginEmpresa(){
		
    	try{
    		String cadena = new String( "CESAR RICARDO" );
    		
		    String llavePrivada = "JavaClavePrivada";  //Maximo 16 Caracterres...
    		
    		String cadenaEncriptada    = encriptacion.encriptarBLOWFISH(    cadena, llavePrivada );
    		String cadenaDesencriptada = encriptacion.desencriptarBLOWFISH( cadenaEncriptada, llavePrivada );
    		
    		System.out.println( "cadena Original:     " + cadena );
    		System.out.println( "llavePrivada:        " + llavePrivada );
    		System.out.println( "cadenaEncriptada:    " + cadenaEncriptada );
    		System.out.println( "cadenaDesencriptada: " + cadenaDesencriptada );
      		
    		//Test resultara OK, si la desencriptacion 'BLOWFISH' funciona.
    		Assert.assertEquals( cadena, cadenaDesencriptada );    		
    	}
    	catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
	
}
