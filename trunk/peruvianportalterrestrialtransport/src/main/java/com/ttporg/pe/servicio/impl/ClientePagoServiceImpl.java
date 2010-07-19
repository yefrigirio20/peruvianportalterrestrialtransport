package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.ClientePago;
import com.ttporg.pe.servicio.ClientePagoService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: ClientePagoServiceImpl.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class ClientePagoServiceImpl extends ServiceFactory implements ClientePagoService{	
	
	public ClientePagoServiceImpl(){
	}
 
	/**
	 * eliminarClientePago_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarClientePago_x_codigo( int codigo ){
		boolean estado = this.getClientePagoDAO().eliminarClientePago_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarClientePago
	 * @param  ClientePago
	 * @return estado
	 */
	public boolean ingresarClientePago( ClientePago clientePago ){
		boolean estado = this.getClientePagoDAO().ingresarClientePago( clientePago );
		return estado;
	}
	
	/**
	 * modificarClientePago
	 * @param  ClientePago
	 * @return estado
	 */
	public boolean modificarClientePago( ClientePago clientePago ){
		boolean estado = this.getClientePagoDAO().modificarClientePago( clientePago );
		return estado;
	}
	
	/**
	 * obtenerListaClientePagos
	 * @return List<ClientePago>
	 */
	public List<ClientePago> obtenerListaClientePagos(){
		List<ClientePago> listaClientePago = this.getClientePagoDAO().obtenerListaClientePagos();
		return listaClientePago;
	}
	
	/**
	 * obtenerObjetoClientePago_x_codigo
	 * @param  codigo
	 * @return ClientePago
	 */
	public ClientePago obtenerObjetoClientePago_x_codigo( int codigo ){
		ClientePago ClientePago = this.getClientePagoDAO().obtenerObjetoClientePago_x_codigo( codigo );
		return ClientePago;
	} 
	
 }
