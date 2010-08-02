package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.dao.ServiceFactory;
import com.ttporg.pe.util.UtilEncriptacion;
 
/**
 * @author Cesar Ricardo.
 * @clase: TestLoginCliente.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class TestLoginCliente{
	
	private static UtilEncriptacion encriptacion = null; 	
	private static ServiceFactory   servicio     = null;
	
	{
	 encriptacion = new UtilEncriptacion();
	 servicio     = new ServiceFactory(); 
	}
	
	/**
     * main
     * @param argumentos
     **/
    public static void main( String[] argumentos ){
    	
        //Permite mostrar el resultado del 'Test' en consola.
        org.junit.runner.JUnitCore.main( "com.ttporg.pe.test.TestLoginCliente" );
    }

    @Test
    @Ignore
	public void testLoginEmpresa(){
		
    	try{
    		servicio = new ServiceFactory();
    		
    		Cliente objCliente =  new Cliente(); 
    		objCliente.setUsuario(  "RGUERRA" );
    		objCliente.setPassword( "SqrAquYuou8=" );    //Password 'ENCRIPTADO' y guardado en la 'BD'.
    		
    		objCliente = servicio.getClienteDAO().loginCliente( objCliente );
    		
    		System.out.println( "Cliente: " + objCliente );
 
    		//Test ok si el servicio responde un objeto cargado de la DB.
    		Assert.assertNotNull( "OBJETO DEVUELTO: ", objCliente  );    		
    	}
    	catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
	
}
