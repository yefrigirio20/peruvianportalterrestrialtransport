package com.ttporg.pe.servicio;

import java.util.List;
import com.ttporg.pe.bean.Cliente;

/**
 * @author Cesar Ricardo.
 * @clase: UsuarioService.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public interface ClienteService{

	/**
	 * obtenerObjetoCliente_x_codigo
	 */
	public Cliente obtenerObjetoCliente_x_codigo( int codigo );

	/**
	 * obtenerListaClientes_x_codigo
	 */
	public List<Cliente> obtenerListaClientes_x_codigo( int codigo );

	/**
	 * eliminarCliente_x_codigo
	 */
	public boolean eliminarCliente_x_codigo( int codigo );

	/**
	 * ingresarCliente
	 */
	public boolean ingresarCliente( Cliente cliente );

	/**
	 * modificarCliente
	 */
	public boolean modificarCliente( Cliente cliente );

	/**
	 * loginCliente
	 */
	public Cliente loginCliente( Cliente cliente );
  
}
