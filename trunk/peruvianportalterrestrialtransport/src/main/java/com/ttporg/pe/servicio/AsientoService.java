package com.ttporg.pe.servicio;

import java.util.List;
import com.ttporg.pe.bean.Asiento;
  
/**
 * @author Cesar Ricardo.
 * @clase: AsientoService.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public interface AsientoService{

	/**
	 * obtenerObjetoAsiento_x_codigo
	 */
	public Asiento obtenerObjetoAsiento_x_codigo( int codigo );

	/**
	 * obtenerListaAsientos
	 */
	public List<Asiento> obtenerListaAsientos();

	/**
	 * eliminarAsiento_x_codigo
	 */
	public boolean eliminarAsiento_x_codigo( int codigo );

	/**
	 * ingresarAsiento
	 */
	public boolean ingresarAsiento( Asiento asiento );

	/**
	 * modificarAsiento
	 */
	public boolean modificarAsiento( Asiento asiento );
 
}
