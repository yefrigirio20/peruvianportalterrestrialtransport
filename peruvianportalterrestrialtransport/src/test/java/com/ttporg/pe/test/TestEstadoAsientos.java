package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.dao.AsientoDao;
import com.ttporg.pe.dao.impl.AsientoDaoImpl;
 
/**
 * @author Cesar Ricardo.
 * @clase: TestEstadoAsientos.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class TestEstadoAsientos{
	
	/**
     * main
     * @param argumentos
     */
    public static void main( String[] argumentos ){
    	
        //Permite mostrar el resultado del 'Test' en consola.
        org.junit.runner.JUnitCore.main( "com.ttporg.pe.test.TestDaos" );
    }

    @Test
    @Ignore
	public void testLoginEmpresa(){
		
    	try{
			ApplicationContext contexto = new ClassPathXmlApplicationContext( "classpath*:/applicationContext.xml" );  

			AsientoDao      asientoDAO      = (AsientoDaoImpl)contexto.getBean( "asientoDao" );

			Asiento objAsiento = (Asiento)asientoDAO.obtenerObjetoAsiento_x_codigo( 1 );
			
			System.out.println( "" );
			System.out.println( "====> [asientoDAO]:      " + asientoDAO   );
			System.out.println( "" );			
			System.out.println( "====> [objAsiento]:      " + objAsiento   );		
			System.out.println( "" );	
			System.out.println( "ESTADO 'A': " + objAsiento.getEstado_A() );
			System.out.println( "ESTADO 'B': " + objAsiento.getEstado_B() );
			System.out.println( "ESTADO 'C': " + objAsiento.getEstado_C() );
			System.out.println( "ESTADO 'D': " + objAsiento.getEstado_D() );
			System.out.println( "VEHICULO.ID: " + objAsiento.getVehiculo().getId() );
			System.out.println( "" );
			
			//Test ok si el servicio responde un objeto cargado de la DB.
			Assert.assertNotNull( "asientoDAO:      ", asientoDAO      );    	  		
		}
		catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
     
}
