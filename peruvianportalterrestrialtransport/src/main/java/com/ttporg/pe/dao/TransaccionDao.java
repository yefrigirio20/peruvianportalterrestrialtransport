package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Transaccion;
 
/**
 * @author Cesar Ricardo.
 * @clase: TransaccionDao.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
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
