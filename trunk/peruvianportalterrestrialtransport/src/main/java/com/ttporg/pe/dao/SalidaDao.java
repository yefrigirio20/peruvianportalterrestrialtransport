package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Salida;
 
/**
 * @author Cesar Ricardo.
 * @clase: SalidaDao.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public interface SalidaDao{
 
	/**
	 * obtenerObjetoSalida_x_codigo
	 */
	public Salida obtenerObjetoSalida_x_codigo( int codigo );

	/**
	 * obtenerListaSalidas
	 */
	public List<Salida> obtenerListaSalidas();

	/**
	 * eliminarSalida_x_codigo
	 */
	public boolean eliminarSalida_x_codigo( int codigo );

	/**
	 * ingresarSalida
	 */
	public boolean ingresarSalida( Salida salida );

	/**
	 * modificarSalida
	 */
	public boolean modificarSalida( Salida salida );
 
}
