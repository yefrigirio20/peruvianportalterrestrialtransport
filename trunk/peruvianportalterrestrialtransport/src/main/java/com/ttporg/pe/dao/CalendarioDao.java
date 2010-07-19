package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Calendario;
 
/**
 * @author Cesar Ricardo.
 * @clase: CalendarioDao.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public interface CalendarioDao{
 
	/**
	 * obtenerObjetoCalendario_x_codigo
	 */
	public Calendario obtenerObjetoCalendario_x_codigo( int codigo );

	/**
	 * obtenerListaCalendarios
	 */
	public List<Calendario> obtenerListaCalendarios();

	/**
	 * eliminarCalendario_x_codigo
	 */
	public boolean eliminarCalendario_x_codigo( int codigo );

	/**
	 * ingresarCalendario
	 */
	public boolean ingresarCalendario( Calendario calendario );

	/**
	 * modificarCalendario
	 */
	public boolean modificarCalendario( Calendario calendario );
 
}
