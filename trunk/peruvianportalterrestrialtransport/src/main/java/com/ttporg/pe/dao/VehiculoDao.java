package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Vehiculo;
 
/**
 * @author Cesar Ricardo.
 * @clase: VehiculoDao.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public interface VehiculoDao{
 
	/**
	 * obtenerObjetoVehiculo_x_codigo
	 */
	public Vehiculo obtenerObjetoVehiculo_x_codigo( int codigo );

	/**
	 * obtenerListaVehiculo_x_idServicio
	 */
	public List<Vehiculo> obtenerListaVehiculo_x_idServicio( int codigo );	
	
	/**
	 * obtenerListaVehiculos
	 */
	public List<Vehiculo> obtenerListaVehiculos();

	/**
	 * eliminarVehiculo_x_codigo
	 */
	public boolean eliminarVehiculo_x_codigo( int codigo );

	/**
	 * ingresarVehiculo
	 */
	public boolean ingresarVehiculo( Vehiculo vehiculo );

	/**
	 * modificarVehiculo
	 */
	public boolean modificarVehiculo( Vehiculo vehiculo );
 
}
