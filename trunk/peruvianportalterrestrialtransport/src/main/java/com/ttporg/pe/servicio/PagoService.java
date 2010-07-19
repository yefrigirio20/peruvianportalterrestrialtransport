package com.ttporg.pe.servicio;

import java.util.List;
import com.ttporg.pe.bean.Pago;
  
/**
 * @author Cesar Ricardo.
 * @clase: PagoService.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public interface PagoService{

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
