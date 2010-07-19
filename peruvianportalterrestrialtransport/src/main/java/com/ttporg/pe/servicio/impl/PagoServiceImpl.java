package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.servicio.PagoService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: PagoServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class PagoServiceImpl extends ServiceFactory implements PagoService{	
	
	public PagoServiceImpl(){
	}
 
	/**
	 * eliminarPago_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarPago_x_codigo( int codigo ){
		boolean estado = this.getPagoDAO().eliminarPago_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarPago
	 * @param  Pago
	 * @return estado
	 */
	public boolean ingresarPago( Pago pago ){
		boolean estado = this.getPagoDAO().ingresarPago( pago );
		return estado;
	}
	
	/**
	 * modificarPago
	 * @param  Pago
	 * @return estado
	 */
	public boolean modificarPago( Pago pago ){
		boolean estado = this.getPagoDAO().modificarPago( pago );
		return estado;
	}
	
	/**
	 * obtenerListaPagos
	 * @return List<Pago>
	 */
	public List<Pago> obtenerListaPagos(){
		List<Pago> listaPago = this.getPagoDAO().obtenerListaPagos();
		return listaPago;
	}
	
	/**
	 * obtenerObjetoPago_x_codigo
	 * @param  codigo
	 * @return Pago
	 */
	public Pago obtenerObjetoPago_x_codigo( int codigo ){
		Pago Pago = this.getPagoDAO().obtenerObjetoPago_x_codigo( codigo );
		return Pago;
	} 
	
 }
