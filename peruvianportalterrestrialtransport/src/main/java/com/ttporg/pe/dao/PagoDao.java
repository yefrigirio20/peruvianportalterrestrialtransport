package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Pago;
 
/**
 * @author Cesar Ricardo.
 * @clase: PagoDao.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public interface PagoDao{
 
	/**
	 * obtenerObjetoPago_x_codigo
	 */
	public Pago obtenerObjetoPago_x_codigo( int codigo );

	/**
	 * obtenerListaPagos
	 */
	public List<Pago> obtenerListaPagos();

	/**
	 * eliminarPago_x_codigo
	 */
	public boolean eliminarPago_x_codigo( int codigo );

	/**
	 * ingresarPago
	 */
	public boolean ingresarPago( Pago pago );

	/**
	 * modificarPago
	 */
	public boolean modificarPago( Pago pago );
 
}
