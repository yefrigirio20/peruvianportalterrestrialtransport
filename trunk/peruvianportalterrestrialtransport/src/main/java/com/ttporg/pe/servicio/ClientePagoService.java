package com.ttporg.pe.servicio;

import java.util.List;
import com.ttporg.pe.bean.ClientePago;
  
/**
 * @author Cesar Ricardo.
 * @clase: ClientePagoService.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public interface ClientePagoService{

	/**
	 * obtenerObjetoClientePago_x_codigo
	 */
	public ClientePago obtenerObjetoClientePago_x_codigo( int codigo );

	/**
	 * obtenerListaClientePagos
	 */
	public List<ClientePago> obtenerListaClientePagos();

	/**
	 * eliminarClientePago_x_codigo
	 */
	public boolean eliminarClientePago_x_codigo( int codigo );

	/**
	 * ingresarClientePago
	 */
	public boolean ingresarClientePago( ClientePago clientePago );

	/**
	 * modificarClientePago
	 */
	public boolean modificarClientePago( ClientePago clientePago );
 
}
