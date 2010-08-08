package com.ttporg.pe.bean;

/**
 * @author Cesar Ricardo.
 * @clase: Asiento.java
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
 *              http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class Asiento{

	private Integer		id;
	private String		columna_A;
	private String		columna_B;
	private String		columna_C;
	private String		columna_D;
	private String		estado_A;
	private String		estado_B;
	private String		estado_C;
	private String		estado_D;
	private String		estado;	    //True = Libre - False = Ocupado
	private Vehiculo	vehiculo;


	// Constructores ...
	public Asiento(){
		this.vehiculo = new Vehiculo();
	}

	public Integer getId(){
		return id;
	}

	public String getColumna_A(){
		return columna_A;
	}

	public String getColumna_B(){
		return columna_B;
	}

	public String getColumna_C(){
		return columna_C;
	}

	public String getColumna_D(){
		return columna_D;
	}

	public String getEstado(){
		return estado;
	}

	public Vehiculo getVehiculo(){
		return vehiculo;
	}

	public void setId( Integer id ){
		this.id = id;
	}

	public void setColumna_A( String columna_A ){
		this.columna_A = columna_A;
	}

	public void setColumna_B( String columna_B ){
		this.columna_B = columna_B;
	}

	public void setColumna_C( String columna_C ){
		this.columna_C = columna_C;
	}

	public void setColumna_D( String columna_D ){
		this.columna_D = columna_D;
	}

	public void setEstado( String estado ){
		this.estado = estado;
	}

	public void setVehiculo( Vehiculo vehiculo ){
		this.vehiculo = vehiculo;
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

 }

