package com.ttporg.pe.dto;

/** 
 * @author Cesar Ricardo.
 * @clase: DetallePopupDTO.java
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
 *              http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class DetallePopupDTO{

	private String	asientoId;
	private String	vehiculoNombre;
	private String	vehiculoModelo;
	private String	vehiculoTipo;
	private String	agenciaNombre;
	private String	empresaRazonSocial;


	//Constructor ...
	public DetallePopupDTO(){
	}
	
	public String getAsientoId(){
		return asientoId;
	}
	
	public void setAsientoId( String asientoId ){
		this.asientoId = asientoId;
	}

	public String getVehiculoNombre(){
		return vehiculoNombre;
	}

	public String getVehiculoModelo(){
		return vehiculoModelo;
	}

	public String getVehiculoTipo(){
		return vehiculoTipo;
	}

	public String getAgenciaNombre(){
		return agenciaNombre;
	}

	public String getEmpresaRazonSocial(){
		return empresaRazonSocial;
	}

	public void setVehiculoNombre( String vehiculoNombre ){
		this.vehiculoNombre = vehiculoNombre;
	}

	public void setVehiculoModelo( String vehiculoModelo ){
		this.vehiculoModelo = vehiculoModelo;
	}

	public void setVehiculoTipo( String vehiculoTipo ){
		this.vehiculoTipo = vehiculoTipo;
	}

	public void setAgenciaNombre( String agenciaNombre ){
		this.agenciaNombre = agenciaNombre;
	}

	public void setEmpresaRazonSocial( String empresaRazonSocial ){
		this.empresaRazonSocial = empresaRazonSocial;
	}

 }
