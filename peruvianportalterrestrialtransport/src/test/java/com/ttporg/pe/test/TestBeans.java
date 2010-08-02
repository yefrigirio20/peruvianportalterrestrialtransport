package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.bean.Calendario;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.ClientePago;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.bean.Transaccion;
import com.ttporg.pe.bean.Vehiculo;
 
/**
 * @author Cesar Ricardo.
 * @clase: TestBeans.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class TestBeans{
	
	/**
     * main
     * @param argumentos
     */
    public static void main( String[] argumentos ){
    	
        //Permite mostrar el resultado del 'Test' en consola.
        org.junit.runner.JUnitCore.main( "com.ttporg.pe.test.TestBeans" );
    }

    @Test
    @Ignore
	public void testLoginEmpresa(){
		
    	try{
			ApplicationContext contexto = new ClassPathXmlApplicationContext( "classpath*:/applicationContext.xml" );  
	
			Cliente      cliente      = (Cliente)contexto.getBean(      "cliente"      ); 			 
			Empresa      empresa      = (Empresa)contexto.getBean(      "empresa"      );
			Departamento departamento = (Departamento)contexto.getBean( "departamento" );
			Agencia      agencia      = (Agencia)contexto.getBean(      "agencia"      );	
			Vehiculo     vehiculo     = (Vehiculo)contexto.getBean(     "vehiculo"     );
			Servicio     servicio     = (Servicio)contexto.getBean(     "servicio"     );
			Asiento      asiento      = (Asiento)contexto.getBean(      "asiento"      );
			Salida       salida       = (Salida)contexto.getBean(       "salida"       );
			Calendario   calendario   = (Calendario)contexto.getBean(   "calendario"   );
			Pago         pago         = (Pago)contexto.getBean(         "pago"         );
			ClientePago  clientePago  = (ClientePago)contexto.getBean(  "clientePago"  );
			Transaccion  transaccion  = (Transaccion)contexto.getBean(  "transaccion"  );
			
			System.out.println( "" );
			System.out.println( "====> [cliente]:      " + cliente      );
			System.out.println( "====> [empresa]:      " + empresa      );
			System.out.println( "====> [departamento]: " + departamento );
			System.out.println( "====> [agencia]:      " + agencia      );
			System.out.println( "====> [vehiculo]:     " + vehiculo     );
			System.out.println( "====> [servicio]:     " + servicio     );
			System.out.println( "====> [asiento]:      " + asiento      );
			System.out.println( "====> [salida]:       " + salida       );
			System.out.println( "====> [calendario]:   " + calendario   );
			System.out.println( "====> [pago]:         " + pago         );
			System.out.println( "====> [clientePago]:  " + clientePago  );
			System.out.println( "====> [transaccion]:  " + transaccion  );
			System.out.println( "" );
			
			//Test ok si el servicio responde un objeto cargado de la DB.
			Assert.assertNotNull( "cliente:      ", cliente      );    		
			Assert.assertNotNull( "empresa:      ", empresa      ); 
			Assert.assertNotNull( "departamento: ", departamento );    		
			Assert.assertNotNull( "agencia:      ", agencia      ); 
			Assert.assertNotNull( "vehiculo:     ", vehiculo     );    		
			Assert.assertNotNull( "servicio:     ", servicio     ); 
			Assert.assertNotNull( "salida:       ", salida       );    		
			Assert.assertNotNull( "calendario:   ", calendario   ); 
			Assert.assertNotNull( "pago:         ", pago         );    		
			Assert.assertNotNull( "clientePago:  ", clientePago  ); 
			Assert.assertNotNull( "transaccion:  ", transaccion  );    		
		}
		catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
     
}
