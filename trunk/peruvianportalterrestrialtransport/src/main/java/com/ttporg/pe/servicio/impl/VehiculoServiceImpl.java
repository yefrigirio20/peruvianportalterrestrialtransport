package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Vehiculo;
import com.ttporg.pe.servicio.VehiculoService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: VehiculoServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class VehiculoServiceImpl extends ServiceFactory implements VehiculoService{	
	
	public VehiculoServiceImpl(){
	}
 
	/**
	 * eliminarVehiculo_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarVehiculo_x_codigo( int codigo ){
		boolean estado = this.getVehiculoDAO().eliminarVehiculo_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarVehiculo
	 * @param  Vehiculo
	 * @return estado
	 */
	public boolean ingresarVehiculo( Vehiculo vehiculo ){
		boolean estado = this.getVehiculoDAO().ingresarVehiculo( vehiculo );
		return estado;
	}
	
	/**
	 * modificarVehiculo
	 * @param  Vehiculo
	 * @return estado
	 */
	public boolean modificarVehiculo( Vehiculo vehiculo ){
		boolean estado = this.getVehiculoDAO().modificarVehiculo( vehiculo );
		return estado;
	}
	
	/**
	 * obtenerListaVehiculos
	 * @return List<Vehiculo>
	 */
	public List<Vehiculo> obtenerListaVehiculos(){
		List<Vehiculo> listaVehiculo = this.getVehiculoDAO().obtenerListaVehiculos();
		return listaVehiculo;
	}
	
	/**
	 * obtenerObjetoVehiculo_x_codigo
	 * @param  codigo
	 * @return Vehiculo
	 */
	public Vehiculo obtenerObjetoVehiculo_x_codigo( int codigo ){
		Vehiculo Vehiculo = this.getVehiculoDAO().obtenerObjetoVehiculo_x_codigo( codigo );
		return Vehiculo;
	} 
	
 }
