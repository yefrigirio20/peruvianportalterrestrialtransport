package com.ttporg.pe.dto;

/**
 * @author Cesar Ricardo.
 * @clase: DetalleAsientoDTO.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public class DetalleAsientoDTO{
	
	private Integer  idVehiculo;
	private Integer  idServicio;
	private Integer  idAsiento;
	private String   modeloVehiculo;
	private String   nombVehiculo;
	private String   estadoAsiento;	
  	
    //Constructor ...
    public DetalleAsientoDTO(){  
    }

	public Integer getIdVehiculo(){
		return idVehiculo;
	}
	
	public Integer getIdServicio(){
		return idServicio;
	}
	
	public Integer getIdAsiento(){
		return idAsiento;
	}
	
	public String getModeloVehiculo(){
		return modeloVehiculo;
	}
	
	public String getNombVehiculo(){
		return nombVehiculo;
	}
	
	public String getEstadoAsiento(){
		return estadoAsiento;
	}
	
	public void setIdVehiculo( Integer idVehiculo ){
		this.idVehiculo = idVehiculo;
	}
	
	public void setIdServicio( Integer idServicio ){
		this.idServicio = idServicio;
	}
	
	public void setIdAsiento( Integer idAsiento ){
		this.idAsiento = idAsiento;
	}
	
	public void setModeloVehiculo( String modeloVehiculo ){
		this.modeloVehiculo = modeloVehiculo;
	}
	
	public void setNombVehiculo( String nombVehiculo ){
		this.nombVehiculo = nombVehiculo;
	}
	
	public void setEstadoAsiento( String estadoAsiento ){
		this.estadoAsiento = estadoAsiento;
	}
  	
 }
