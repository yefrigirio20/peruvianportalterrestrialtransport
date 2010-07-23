package com.ttporg.pe.servicio.impl;

import java.util.Date;
import java.util.List;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.dto.DetalleAsientoDTO;
import com.ttporg.pe.dto.DetallePasajeDTO;
import com.ttporg.pe.servicio.SalidaService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: SalidaServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class SalidaServiceImpl extends ServiceFactory implements SalidaService{	
	
	public SalidaServiceImpl(){
	}
 
	/**
	 * eliminarSalida_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarSalida_x_codigo( int codigo ){
		boolean estado = this.getSalidaDAO().eliminarSalida_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarSalida
	 * @param  Salida
	 * @return estado
	 */
	public boolean ingresarSalida( Salida salida ){
		boolean estado = this.getSalidaDAO().ingresarSalida( salida );
		return estado;
	}
	
	/**
	 * modificarSalida
	 * @param  Salida
	 * @return estado
	 */
	public boolean modificarSalida( Salida salida ){
		boolean estado = this.getSalidaDAO().modificarSalida( salida );
		return estado;
	}
	
	/**
	 * obtenerListaSalidas
	 * @return List<Salida>
	 */
	public List<Salida> obtenerListaSalidas(){
		List<Salida> listaSalida = this.getSalidaDAO().obtenerListaSalidas();
		return listaSalida;
	}
	
	/**
	 * obtenerObjetoSalida_x_codigo
	 * @param  codigo
	 * @return Salida
	 */
	public Salida obtenerObjetoSalida_x_codigo( int codigo ){
		Salida Salida = this.getSalidaDAO().obtenerObjetoSalida_x_codigo( codigo );
		return Salida;
	}

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
													            String departamentoDestino, Date fechaHoraSalida ){
		List<DetallePasajeDTO> listaDetallePasajeDTO = this.getSalidaDAO().obtenerListaDetallePasajeDTO( idEmpresa, idAgencia,
				                                                                                         idServicio, departamentoSalida, 
				                                                                                         departamentoDestino, fechaHoraSalida 
				                                                                                        );
		return listaDetallePasajeDTO;
	} 
	
	/**
	 * obtenerListaDetalleAsientoDTO
	 * @param  idServicio
	 **/
	public List<DetalleAsientoDTO> obtenerListaDetalleAsientoDTO( int idServicio ){
		List<DetalleAsientoDTO> listaDetalleAsientoDTO = this.getSalidaDAO().obtenerListaDetalleAsientoDTO( idServicio );
		return listaDetalleAsientoDTO;
	} 
	
 }
