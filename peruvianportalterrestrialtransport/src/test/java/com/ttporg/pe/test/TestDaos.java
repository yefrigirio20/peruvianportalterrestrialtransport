package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ttporg.pe.dao.AgenciaDao;
import com.ttporg.pe.dao.AsientoDao;
import com.ttporg.pe.dao.CalendarioDao;
import com.ttporg.pe.dao.ClienteDao;
import com.ttporg.pe.dao.ClientePagoDao;
import com.ttporg.pe.dao.DepartamentoDao;
import com.ttporg.pe.dao.EmpresaDao;
import com.ttporg.pe.dao.PagoDao;
import com.ttporg.pe.dao.SalidaDao;
import com.ttporg.pe.dao.ServicioDao;
import com.ttporg.pe.dao.TransaccionDao;
import com.ttporg.pe.dao.VehiculoDao;
import com.ttporg.pe.dao.impl.AgenciaDaoImpl;
import com.ttporg.pe.dao.impl.AsientoDaoImpl;
import com.ttporg.pe.dao.impl.CalendarioDaoImpl;
import com.ttporg.pe.dao.impl.ClienteDaoImpl;
import com.ttporg.pe.dao.impl.ClientePagoDaoImpl;
import com.ttporg.pe.dao.impl.DepartamentoDaoImpl;
import com.ttporg.pe.dao.impl.EmpresaDaoImpl;
import com.ttporg.pe.dao.impl.PagoDaoImpl;
import com.ttporg.pe.dao.impl.SalidaDaoImpl;
import com.ttporg.pe.dao.impl.ServicioDaoImpl;
import com.ttporg.pe.dao.impl.TransaccionDaoImpl;
import com.ttporg.pe.dao.impl.VehiculoDaoImpl;
 
/**
 * @author Cesar Ricardo.
 * @clase: TestDaos.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class TestDaos{
	
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
	
			ClienteDao      clienteDAO      = (ClienteDaoImpl)contexto.getBean(      "clienteDao"      ); 			 
			EmpresaDao      empresaDAO      = (EmpresaDaoImpl)contexto.getBean(      "empresaDao"      );
			DepartamentoDao departamentoDAO = (DepartamentoDaoImpl)contexto.getBean( "departamentoDao" );
			AgenciaDao      agenciaDAO      = (AgenciaDaoImpl)contexto.getBean(      "agenciaDao"      );	
			VehiculoDao     vehiculoDAO     = (VehiculoDaoImpl)contexto.getBean(     "vehiculoDao"     );
			ServicioDao     servicioDAO     = (ServicioDaoImpl)contexto.getBean(     "servicioDao"     );
			AsientoDao      asientoDAO      = (AsientoDaoImpl)contexto.getBean(      "asientoDao"      );
			SalidaDao       salidaDAO       = (SalidaDaoImpl)contexto.getBean(       "salidaDao"       );
			CalendarioDao   calendarioDAO   = (CalendarioDaoImpl)contexto.getBean(   "calendarioDao"   );
			PagoDao         pagoDAO         = (PagoDaoImpl)contexto.getBean(         "pagoDao"         );
			ClientePagoDao  clientePagoDAO  = (ClientePagoDaoImpl)contexto.getBean(  "clientePagoDao"  );
			TransaccionDao  transaccionDAO  = (TransaccionDaoImpl)contexto.getBean(  "transaccionDao"  );

			System.out.println( "" );
			System.out.println( "====> [clienteDAO]:      " + clienteDAO      );
			System.out.println( "====> [empresaDAO]:      " + empresaDAO      );
			System.out.println( "====> [departamentoDAO]: " + departamentoDAO );
			System.out.println( "====> [agenciaDAO]:      " + agenciaDAO      );
			System.out.println( "====> [vehiculoDAO]:     " + vehiculoDAO     );
			System.out.println( "====> [servicioDAO]:     " + servicioDAO     );
			System.out.println( "====> [asientoDAO]:      " + asientoDAO      );
			System.out.println( "====> [salidaDAO]:       " + salidaDAO       );
			System.out.println( "====> [calendarioDAO]:   " + calendarioDAO   );
			System.out.println( "====> [pagoDAO]:         " + pagoDAO         );
			System.out.println( "====> [clientePagoDAO]:  " + clientePagoDAO  );
			System.out.println( "====> [transaccionDAO]:  " + transaccionDAO  );
			System.out.println( "" );
			
			//Test ok si el servicio responde un objeto cargado de la DB.
			Assert.assertNotNull( "clienteDAO:      ", clienteDAO      );    		
			Assert.assertNotNull( "empresaDAO:      ", empresaDAO      ); 
			Assert.assertNotNull( "departamentoDAO: ", departamentoDAO );    		
			Assert.assertNotNull( "agenciaDAO:      ", agenciaDAO      ); 
			Assert.assertNotNull( "vehiculoDAO:     ", vehiculoDAO     );    		
			Assert.assertNotNull( "servicioDAO:     ", servicioDAO     ); 
			Assert.assertNotNull( "salidaDAO:       ", salidaDAO       );    		
			Assert.assertNotNull( "calendarioDAO:   ", calendarioDAO   ); 
			Assert.assertNotNull( "pagoDAO:         ", pagoDAO         );    		
			Assert.assertNotNull( "clientePagoDAO:  ", clientePagoDAO  ); 
			Assert.assertNotNull( "transaccionDAO:  ", transaccionDAO  );    		
		}
		catch( Exception e ){
			   e.printStackTrace();
		}    	
	}
     
}
