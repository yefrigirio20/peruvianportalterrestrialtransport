package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
/**
 * @author Cesar Ricardo.
 * @clase: TestDataSource.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public class TestDataSource{
	
	/**
     * main
     * @param argumentos
     */
    public static void main( String[] argumentos ){
    	
        //Permite mostrar el resultado del 'Test' en consola.
        org.junit.runner.JUnitCore.main( "com.ttporg.pe.test.TestDataSource" );
    }

    @Test
    @Ignore
	public void testLoginEmpresa(){
		
    	try{
			ApplicationContext contexto = new ClassPathXmlApplicationContext( "classpath*:/applicationContext.xml" );  
	
			Object dataSource = (Object)contexto.getBean( "dataSource" ); 			 
 			
			System.out.println( "" );
			System.out.println( "====> [dataSource]: " + dataSource );
			System.out.println( "" );
			
			//Test ok si el servicio responde un objeto cargado de la DB.
			Assert.assertNotNull( "dataSource: ", dataSource );   
		}
		catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
     
}
