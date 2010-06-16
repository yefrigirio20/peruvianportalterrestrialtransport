package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.servicio.ClienteService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: UsuarioServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ClienteServiceImpl extends ServiceFactory implements ClienteService{	
	
	public ClienteServiceImpl(){
	}
	
	/**
	 * eliminarCliente_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarCliente_x_codigo( int codigo ){
		boolean estado = this.getClienteDAO().eliminarCliente_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarCliente
	 * @param  cliente
	 * @return boolean
	 */
	public boolean ingresarCliente( Cliente cliente ){
		boolean estado = this.getClienteDAO().ingresarCliente( cliente );
		return estado;
	}
	
	/**
	 * loginCliente
	 * @param  cliente
	 * @return Cliente
	 */
	public Cliente loginCliente( Cliente cliente ){
		Cliente objCliente = this.getClienteDAO().loginCliente( cliente );
		return objCliente;
	}
	
	/**
	 * modificarCliente
	 * @param  cliente
	 * @return boolean
	 */
	public boolean modificarCliente( Cliente cliente ){
		boolean estado = this.getClienteDAO().modificarCliente( cliente );
		return estado;
	}
	
	/**
	 * obtenerListaClientes_x_codigo
	 * @param  codigo
	 * @return List<Cliente>
	 */
	public List<Cliente> obtenerListaClientes_x_codigo( int codigo ){
		List<Cliente> listaCliente = this.getClienteDAO().obtenerListaClientes_x_codigo( codigo );
		return listaCliente;
	}
	
	/**
	 * obtenerObjetoCliente_x_codigo
	 * @param  codigo
	 * @return Cliente
	 */
	public Cliente obtenerObjetoCliente_x_codigo( int codigo ){
		Cliente objCliente = this.getClienteDAO().obtenerObjetoCliente_x_codigo( codigo );
		return  objCliente;
	}	 
	
 }
