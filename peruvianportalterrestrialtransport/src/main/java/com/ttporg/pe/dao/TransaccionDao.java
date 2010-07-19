package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Transaccion;
 
/**
 * @author Cesar Ricardo.
 * @clase: TransaccionDao.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public interface TransaccionDao{
 
	/**
	 * obtenerObjetoTransaccion_x_codigo
	 */
	public Transaccion obtenerObjetoTransaccion_x_codigo( int codigo );

	/**
	 * obtenerListaTransaccions
	 */
	public List<Transaccion> obtenerListaTransaccions();

	/**
	 * eliminarTransaccion_x_codigo
	 */
	public boolean eliminarTransaccion_x_codigo( int codigo );

	/**
	 * ingresarTransaccion
	 */
	public boolean ingresarTransaccion( Transaccion transaccion );

	/**
	 * modificarTransaccion
	 */
	public boolean modificarTransaccion( Transaccion transaccion );
 
}
