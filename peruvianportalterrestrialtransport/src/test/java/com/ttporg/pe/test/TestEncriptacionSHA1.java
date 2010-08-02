package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import com.ttporg.pe.util.UtilEncriptacion;
 
/**
 * @author Cesar Ricardo.
 * @clase: TestEncriptacionSHA1.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class TestEncriptacionSHA1{
	
	private static UtilEncriptacion encriptacion = null; 	
	
	{
	 encriptacion = new UtilEncriptacion();
	}
	
	/**
     * main
     * @param argumentos
     **/
    public static void main( String[] argumentos ){
    	
    	TestEncriptacionSHA1 encriptacion = new TestEncriptacionSHA1();
    	encriptacion.testLoginEmpresa();
    	
        //Permite mostrar el resultado del 'Test' en consola.
        org.junit.runner.JUnitCore.main( "com.ttporg.pe.test.TestEncriptacionSHA1" );        
    }

    @Test
    @Ignore
	public void testLoginEmpresa(){
		
    	try{
    		String cadenaOriginal = new String( "CESAR RICARDO" );
    		String cadenaAuxiliar = new String( "CESAR RICARDO" );
    		
    		String cadenaEncriptada    = encriptacion.encriptarSHA1( cadenaOriginal );
    		boolean estadoEncriptacion = encriptacion.comparaDatoEncriptadoSHA1( cadenaEncriptada, cadenaAuxiliar );
    		
    		System.out.println( "cadena Original:       " + cadenaOriginal     );
    		System.out.println( "cadenaEncriptada SHA1: " + cadenaEncriptada   );
    		System.out.println( "cadena Auxiliar:       " + cadenaAuxiliar     );
    		System.out.println( "estadoEncriptacion:    " + estadoEncriptacion );
      		
    		//Test resultara OK, si la desencriptacion 'SHA1' funciona.
    		Assert.assertTrue( false );     		
    	}
    	catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
	
}
