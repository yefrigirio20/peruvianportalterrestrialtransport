package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.servicio.AsientoService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: AsientoServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class AsientoServiceImpl extends ServiceFactory implements AsientoService{	
	
	public AsientoServiceImpl(){
	}
 
	/**
	 * eliminarAsiento_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarAsiento_x_codigo( int codigo ){
		boolean estado = this.getAsientoDAO().eliminarAsiento_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarAsiento
	 * @param  Asiento
	 * @return estado
	 */
	public boolean ingresarAsiento( Asiento asiento ){
		boolean estado = this.getAsientoDAO().ingresarAsiento( asiento );
		return estado;
	}
	
	/**
	 * modificarAsiento
	 * @param  Asiento
	 * @return estado
	 */
	public boolean modificarAsiento( Asiento asiento ){
		boolean estado = this.getAsientoDAO().modificarAsiento( asiento );
		return estado;
	}
	
	/**
	 * obtenerListaAsientos
	 * @return List<Asiento>
	 */
	public List<Asiento> obtenerListaAsientos(){
		List<Asiento> listaAsiento = this.getAsientoDAO().obtenerListaAsientos();
		return listaAsiento;
	}
	
	/**
	 * obtenerObjetoAsiento_x_codigo
	 * @param  codigo
	 * @return Asiento
	 */
	public Asiento obtenerObjetoAsiento_x_codigo( int codigo ){
		Asiento Asiento = this.getAsientoDAO().obtenerObjetoAsiento_x_codigo( codigo );
		return Asiento;
	} 
	
 }
