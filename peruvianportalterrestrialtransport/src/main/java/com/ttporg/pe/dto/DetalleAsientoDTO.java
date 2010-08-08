
package com.ttporg.pe.dto;

/**
 * @author Cesar Ricardo.
 * @clase: DetalleAsientoDTO.java
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
 *              http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class DetalleAsientoDTO{

	private Integer	idAsiento;
	private Integer	idVehiculo;
	private Integer	idServicio;
	private String	modeloVehiculo;
	private String	nombVehiculo;
	private String	filaAsiento;
	private String	columnaAsientoA;
	private String	columnaAsientoB;
	private String	columnaAsientoC;
	private String	columnaAsientoD;
	private String	estado_A;
	private String	estado_B;
	private String	estado_C;
	private String	estado_D;
	private String	estado;


	//Constructor ...
	public DetalleAsientoDTO(){
	}

	public String getEstado_A(){
		return estado_A;
	}

	public String getEstado_B(){
		return estado_B;
	}

	public String getEstado_C(){
		return estado_C;
	}

	public String getEstado_D(){
		return estado_D;
	}

	public void setEstado_A( String estado_A ){
		this.estado_A = estado_A;
	}

	public void setEstado_B( String estado_B ){
		this.estado_B = estado_B;
	}

	public void setEstado_C( String estado_C ){
		this.estado_C = estado_C;
	}

	public void setEstado_D( String estado_D ){
		this.estado_D = estado_D;
	}

	public Integer getIdAsiento(){
		return idAsiento;
	}

	public Integer getIdVehiculo(){
		return idVehiculo;
	}

	public Integer getIdServicio(){
		return idServicio;
	}

	public String getModeloVehiculo(){
		return modeloVehiculo;
	}

	public String getNombVehiculo(){
		return nombVehiculo;
	}

	public String getFilaAsiento(){
		return filaAsiento;
	}

	public String getColumnaAsientoA(){
		return columnaAsientoA;
	}

	public String getColumnaAsientoB(){
		return columnaAsientoB;
	}

	public String getColumnaAsientoC(){
		return columnaAsientoC;
	}

	public String getColumnaAsientoD(){
		return columnaAsientoD;
	}

	public String getEstado(){
		return estado;
	}

	public void setIdAsiento( Integer idAsiento ){
		this.idAsiento = idAsiento;
	}

	public void setIdVehiculo( Integer idVehiculo ){
		this.idVehiculo = idVehiculo;
	}

	public void setIdServicio( Integer idServicio ){
		this.idServicio = idServicio;
	}

	public void setModeloVehiculo( String modeloVehiculo ){
		this.modeloVehiculo = modeloVehiculo;
	}

	public void setNombVehiculo( String nombVehiculo ){
		this.nombVehiculo = nombVehiculo;
	}

	public void setFilaAsiento( String filaAsiento ){
		this.filaAsiento = filaAsiento;
	}

	public void setColumnaAsientoA( String columnaAsientoA ){
		this.columnaAsientoA = columnaAsientoA;
	}

	public void setColumnaAsientoB( String columnaAsientoB ){
		this.columnaAsientoB = columnaAsientoB;
	}

	public void setColumnaAsientoC( String columnaAsientoC ){
		this.columnaAsientoC = columnaAsientoC;
	}

	public void setColumnaAsientoD( String columnaAsientoD ){
		this.columnaAsientoD = columnaAsientoD;
	}

	public void setEstado( String estado ){
		this.estado = estado;
	}

 }

