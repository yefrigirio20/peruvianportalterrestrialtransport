package com.ttporg.pe.servicio;

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
 * @clase: ServiceFactory.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServiceFactory{
 
	private ApplicationContext contexto = new ClassPathXmlApplicationContext( "classpath*:/applicationContext.xml" );  
 	 
	//Constructor ...
	public ServiceFactory(){		
	}
	
	public ClienteDao getClienteDAO(){
		ClienteDao clienteDao = (ClienteDaoImpl)this.contexto.getBean( "clienteDao" );		
		return clienteDao;
	}
	
	public EmpresaDao getEmpresaDAO(){		
		EmpresaDao empresaDao = (EmpresaDaoImpl)this.contexto.getBean( "empresaDao" );	
		return empresaDao;
	}
	
	public DepartamentoDao getDepartamentoDAO(){		
		DepartamentoDao departamentoDao = (DepartamentoDaoImpl)this.contexto.getBean( "departamentoDao" );	
		return departamentoDao;
	}
	
	public AgenciaDao getAgenciaDAO(){		
		AgenciaDao agenciaDao = (AgenciaDaoImpl)this.contexto.getBean( "agenciaDao" );	
		return agenciaDao;
	}
	
	public VehiculoDao getVehiculoDAO(){		
		VehiculoDao vehiculoDao = (VehiculoDaoImpl)this.contexto.getBean( "vehiculoDao" );	
		return vehiculoDao;
	}
	
	public ServicioDao getServicioDAO(){		
		ServicioDao servicioDao = (ServicioDaoImpl)this.contexto.getBean( "servicioDao" );	
		return servicioDao;
	}

	public AsientoDao getAsientoDAO(){		
		AsientoDao asientoDao = (AsientoDaoImpl)this.contexto.getBean( "asientoDao" );	
		return asientoDao;
	}

	public SalidaDao getSalidaDAO(){		
		SalidaDao salidaDao = (SalidaDaoImpl)this.contexto.getBean( "salidaDao" );	
		return salidaDao;
	}
	
	public CalendarioDao getCalendarioDAO(){		
		CalendarioDao calendarioDao = (CalendarioDaoImpl)this.contexto.getBean( "calendarioDao" );	
		return calendarioDao;
	}
	
	public PagoDao getPagoDAO(){		
		PagoDao pagoDao = (PagoDaoImpl)this.contexto.getBean( "pagoDao" );	
		return  pagoDao;
	}
	
	public ClientePagoDao getClientePagoDAO(){		
		ClientePagoDao clientePagoDao = (ClientePagoDaoImpl)this.contexto.getBean( "clientePagoDao" );	
		return  clientePagoDao;
	}
	
	public TransaccionDao getTransaccionDAO(){		
		TransaccionDao transaccionDao = (TransaccionDaoImpl)this.contexto.getBean( "transaccionDao" );	
		return  transaccionDao;
	}
 
}


