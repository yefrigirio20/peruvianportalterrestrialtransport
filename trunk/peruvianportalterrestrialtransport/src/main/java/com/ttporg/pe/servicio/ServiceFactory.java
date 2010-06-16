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
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
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


