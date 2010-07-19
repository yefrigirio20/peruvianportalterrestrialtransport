package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Servicio;
 
/**
 * @author Cesar Ricardo.
 * @clase: ServicioDao.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public interface ServicioDao{
 
	/**
	 * obtenerObjetoServicio_x_codigo
	 */
	public Servicio obtenerObjetoServicio_x_codigo( int codigo );

	/**
	 * obtenerListaServicios
	 */
	public List<Servicio> obtenerListaServicios();

	/**
	 * eliminarServicio_x_codigo
	 */
	public boolean eliminarServicio_x_codigo( int codigo );

	/**
	 * ingresarServicio
	 */
	public boolean ingresarServicio( Servicio servicio );

	/**
	 * modificarServicio
	 */
	public boolean modificarServicio( Servicio servicio );
 
}
