package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Agencia;
 
/**
 * @author Cesar Ricardo.
 * @clase: AgenciaDao.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public interface AgenciaDao{
 
	/**
	 * obtenerObjetoAgencia_x_codigo
	 */
	public Agencia obtenerObjetoAgencia_x_codigo( int codigo );

	/**
	 * obtenerListaAgencias
	 */
	public List<Agencia> obtenerListaAgencias();

	/**
	 * obtenerListaAgencias_x_empresa
	 */
	public List<Agencia> obtenerListaAgencias_x_empresa( int codigo );	
	
	/**
	 * eliminarAgencia_x_codigo
	 */
	public boolean eliminarAgencia_x_codigo( int codigo );

	/**
	 * ingresarAgencia
	 */
	public boolean ingresarAgencia( Agencia Agencia );

	/**
	 * modificarAgencia
	 */
	public boolean modificarAgencia( Agencia Agencia );
 
}
