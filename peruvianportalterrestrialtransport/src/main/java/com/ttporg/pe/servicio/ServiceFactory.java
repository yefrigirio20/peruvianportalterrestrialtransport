package com.ttporg.pe.servicio;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ttporg.pe.dao.ClienteDao;
import com.ttporg.pe.dao.EmpresaDao;
import com.ttporg.pe.dao.UsuarioDao;
import com.ttporg.pe.dao.impl.ClienteDaoImpl;
import com.ttporg.pe.dao.impl.EmpresaDaoImpl;
import com.ttporg.pe.dao.impl.UsuarioDaoImpl;

/**
 * @author Cesar Ricardo.
 * @clase: GeneralService.java  
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
 
	private ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext( "classpath*:/applicationContext.xml" );  
	
	public UsuarioDao getUsuarioDAO(){
		UsuarioDao usuarioDao = (UsuarioDaoImpl)this.contexto.getBean( "usuarioDao" );		
		return usuarioDao;
	}
	
	public ClienteDao getClienteDAO(){
		ClienteDao clienteDao = (ClienteDaoImpl)this.contexto.getBean( "clienteDao" );		
		return clienteDao;
	}
	
	public EmpresaDao getEmpresaDAO(){		
		EmpresaDao empresaDao = (EmpresaDaoImpl)this.contexto.getBean( "empresaDao" );	
		return empresaDao;
	}
	
}


