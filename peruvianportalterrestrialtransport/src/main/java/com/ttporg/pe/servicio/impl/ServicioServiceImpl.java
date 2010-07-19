package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.servicio.ServicioService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: ServicioServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServicioServiceImpl extends ServiceFactory implements ServicioService{	
	
	public ServicioServiceImpl(){
	}
 
	/**
	 * eliminarServicio_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarServicio_x_codigo( int codigo ){
		boolean estado = this.getServicioDAO().eliminarServicio_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarServicio
	 * @param  Servicio
	 * @return estado
	 */
	public boolean ingresarServicio( Servicio servicio ){
		boolean estado = this.getServicioDAO().ingresarServicio( servicio );
		return estado;
	}
	
	/**
	 * modificarServicio
	 * @param  Servicio
	 * @return estado
	 */
	public boolean modificarServicio( Servicio servicio ){
		boolean estado = this.getServicioDAO().modificarServicio( servicio );
		return estado;
	}
	
	/**
	 * obtenerListaServicios
	 * @return List<Servicio>
	 */
	public List<Servicio> obtenerListaServicios(){
		List<Servicio> listaServicio = this.getServicioDAO().obtenerListaServicios();
		return listaServicio;
	}
	
	/**
	 * obtenerObjetoServicio_x_codigo
	 * @param  codigo
	 * @return Servicio
	 */
	public Servicio obtenerObjetoServicio_x_codigo( int codigo ){
		Servicio Servicio = this.getServicioDAO().obtenerObjetoServicio_x_codigo( codigo );
		return Servicio;
	} 
	
 }
