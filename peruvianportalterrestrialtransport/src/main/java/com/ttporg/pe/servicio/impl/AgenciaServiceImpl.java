package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.servicio.AgenciaService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: AgenciaServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class AgenciaServiceImpl extends ServiceFactory implements AgenciaService{	
	
	public AgenciaServiceImpl(){
	}
 
	/**
	 * eliminarAgencia_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarAgencia_x_codigo( int codigo ){
		boolean estado = this.getAgenciaDAO().eliminarAgencia_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarAgencia
	 * @param  Agencia
	 * @return estado
	 */
	public boolean ingresarAgencia( Agencia agencia ){
		boolean estado = this.getAgenciaDAO().ingresarAgencia( agencia );
		return estado;
	}
	
	/**
	 * modificarAgencia
	 * @param  Agencia
	 * @return estado
	 */
	public boolean modificarAgencia( Agencia agencia ){
		boolean estado = this.getAgenciaDAO().modificarAgencia( agencia );
		return estado;
	}
	
	/**
	 * obtenerListaAgencias
	 * @return List<Agencia>
	 */
	public List<Agencia> obtenerListaAgencias(){
		List<Agencia> listaAgencia = this.getAgenciaDAO().obtenerListaAgencias();
		return listaAgencia;
	}
	
	/**
	 * obtenerListaAgencias_x_empresa
	 **/
	public List<Agencia> obtenerListaAgencias_x_empresa( int codigo ){
		List<Agencia> listaAgencia = this.getAgenciaDAO().obtenerListaAgencias_x_empresa( codigo );
		return listaAgencia;
	}
	
	/**
	 * obtenerObjetoAgencia_x_codigo
	 * @param  codigo
	 * @return Agencia
	 */
	public Agencia obtenerObjetoAgencia_x_codigo( int codigo ){
		Agencia Agencia = this.getAgenciaDAO().obtenerObjetoAgencia_x_codigo( codigo );
		return Agencia;
	}
	
 }
