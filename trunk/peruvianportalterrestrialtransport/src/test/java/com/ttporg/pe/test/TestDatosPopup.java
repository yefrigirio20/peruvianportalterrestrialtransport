package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ttporg.pe.dao.EmpresaDao;
import com.ttporg.pe.dao.impl.EmpresaDaoImpl;
import com.ttporg.pe.dto.DetallePopupDTO;
 
/**
 * @author Cesar Ricardo.
 * @clase: TestDatosPopup.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class TestDatosPopup{
	
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

			EmpresaDao      empresaDAO      = (EmpresaDaoImpl)contexto.getBean( "empresaDao" );

			DetallePopupDTO objDetallePopup = (DetallePopupDTO)empresaDAO.obtenerObjetoDatosPopup_x_codigoAsiento( 1 );
			
			System.out.println( "" );
			System.out.println( "====> [empresaDAO]:      " + empresaDAO   );
			System.out.println( "" );			
			System.out.println( "====> [objDetallePopup]: " + objDetallePopup   );		
			System.out.println( "" );	
			System.out.println( "AsientoId:      " + objDetallePopup.getAsientoId()      );
			System.out.println( "AgenciaNombre:  " + objDetallePopup.getAgenciaNombre()  );
			System.out.println( "VehiculoNombre: " + objDetallePopup.getVehiculoNombre() );
			System.out.println( "VehiculoModelo: " + objDetallePopup.getVehiculoModelo() );
			System.out.println( "VehiculoTipo:   " + objDetallePopup.getVehiculoTipo()   );
			System.out.println( "AgenciaNombre:      " + objDetallePopup.getAgenciaNombre()      );
			System.out.println( "EmpresaRazonSocial: " + objDetallePopup.getEmpresaRazonSocial() );
			System.out.println( "" );
			
			//Test ok si el servicio responde un objeto cargado de la DB.
			Assert.assertNotNull( "asientoDAO:      ", objDetallePopup  );    	
		}
		catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
     
}
