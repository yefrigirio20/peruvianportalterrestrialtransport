package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Servicio;
 
/**
 * @author Cesar Ricardo.
 * @clase: ServicioDao.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
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
