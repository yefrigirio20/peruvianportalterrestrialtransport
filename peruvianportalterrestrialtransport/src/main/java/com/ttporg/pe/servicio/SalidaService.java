package com.ttporg.pe.servicio;

import java.util.Date;
import java.util.List;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.dto.DetalleAsientoDTO;
import com.ttporg.pe.dto.DetallePasajeDTO;
  
/**
 * @author Cesar Ricardo.
 * @clase: SalidaService.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public interface SalidaService{

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
	 
	/**
	 * obtenerListaDetallePasajeDTO
	 * @param  idEmpresa
	 * @param  idAgencia
	 * @param  idServicio
	 * @param  departamentoSalida
	 * @param  departamentoDestino
	 * @param  fechaHoraSalida
	 * @return List<DetallePasajeDTO>
	 */
	public List<DetallePasajeDTO> obtenerListaDetallePasajeDTO( int idEmpresa,  int idAgencia, 
			                                                    int idServicio, String departamentoSalida, 
			                                                    String departamentoDestino, Date fechaHoraSalida );	
	/**
	 * obtenerListaDetalleAsientoDTO
	 * @param  idServicio
	 * @return List<DetalleAsientoDTO>
	 */
	public List<DetalleAsientoDTO> obtenerListaDetalleAsientoDTO( int idServicio );
	
}
