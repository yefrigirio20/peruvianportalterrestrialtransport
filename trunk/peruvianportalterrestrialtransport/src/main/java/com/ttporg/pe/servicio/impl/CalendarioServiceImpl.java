package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Calendario;
import com.ttporg.pe.servicio.CalendarioService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: CalendarioServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class CalendarioServiceImpl extends ServiceFactory implements CalendarioService{	
	
	public CalendarioServiceImpl(){
	}
 
	/**
	 * eliminarCalendario_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarCalendario_x_codigo( int codigo ){
		boolean estado = this.getCalendarioDAO().eliminarCalendario_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarCalendario
	 * @param  Calendario
	 * @return estado
	 */
	public boolean ingresarCalendario( Calendario calendario ){
		boolean estado = this.getCalendarioDAO().ingresarCalendario( calendario );
		return estado;
	}
	
	/**
	 * modificarCalendario
	 * @param  Calendario
	 * @return estado
	 */
	public boolean modificarCalendario( Calendario calendario ){
		boolean estado = this.getCalendarioDAO().modificarCalendario( calendario );
		return estado;
	}
	
	/**
	 * obtenerListaCalendarios
	 * @return List<Calendario>
	 */
	public List<Calendario> obtenerListaCalendarios(){
		List<Calendario> listaCalendario = this.getCalendarioDAO().obtenerListaCalendarios();
		return listaCalendario;
	}
	
	/**
	 * obtenerObjetoCalendario_x_codigo
	 * @param  codigo
	 * @return Calendario
	 */
	public Calendario obtenerObjetoCalendario_x_codigo( int codigo ){
		Calendario calendario = this.getCalendarioDAO().obtenerObjetoCalendario_x_codigo( codigo );
		return calendario;
	} 
	
 }
