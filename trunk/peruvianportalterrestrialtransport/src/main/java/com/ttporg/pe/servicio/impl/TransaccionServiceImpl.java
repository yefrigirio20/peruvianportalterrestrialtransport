package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Transaccion;
import com.ttporg.pe.servicio.TransaccionService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: TransaccionServiceImpl.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class TransaccionServiceImpl extends ServiceFactory implements TransaccionService{	
	
	public TransaccionServiceImpl(){
	}
 
	/**
	 * eliminarTransaccion_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarTransaccion_x_codigo( int codigo ){
		boolean estado = this.getTransaccionDAO().eliminarTransaccion_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarTransaccion
	 * @param  Transaccion
	 * @return estado
	 */
	public boolean ingresarTransaccion( Transaccion transaccion ){
		boolean estado = this.getTransaccionDAO().ingresarTransaccion( transaccion );
		return estado;
	}
	
	/**
	 * modificarTransaccion
	 * @param  Transaccion
	 * @return estado
	 */
	public boolean modificarTransaccion( Transaccion transaccion ){
		boolean estado = this.getTransaccionDAO().modificarTransaccion( transaccion );
		return estado;
	}
	
	/**
	 * obtenerListaTransaccions
	 * @return List<Transaccion>
	 */
	public List<Transaccion> obtenerListaTransaccions(){
		List<Transaccion> listaTransaccion = this.getTransaccionDAO().obtenerListaTransaccions();
		return listaTransaccion;
	}
	
	/**
	 * obtenerObjetoTransaccion_x_codigo
	 * @param  codigo
	 * @return Transaccion
	 */
	public Transaccion obtenerObjetoTransaccion_x_codigo( int codigo ){
		Transaccion Transaccion = this.getTransaccionDAO().obtenerObjetoTransaccion_x_codigo( codigo );
		return Transaccion;
	} 
	
 }
