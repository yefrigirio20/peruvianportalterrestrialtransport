package com.ttporg.pe.bean;

import java.util.Date;

/**
 * @author Cesar Ricardo.
 * @clase: Pago.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Pago{
	
	private Integer id;
	private String  tipoPago;
	private String  numTarjeta;
	private Date    fechaExpiracion;  
	
	//Constructores ...
	public Pago(){
	}
 
	public Pago( Integer id, String tipoPago, String  numTarjeta, 
			     Date fechaExpiracion ){
		super();
		this.id              = id;
		this.tipoPago        = tipoPago;
		this.numTarjeta      = numTarjeta;
		this.fechaExpiracion = fechaExpiracion;
	}
	
	public Integer getId(){
		return id;
	}
	
	public String getTipoPago(){
		return tipoPago;
	}
	
	public String getNumTarjeta(){
		return numTarjeta;
	}
	
	public Date getFechaExpiracion(){
		return fechaExpiracion;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public void setTipoPago( String tipoPago ){
		this.tipoPago = tipoPago;
	}
	
	public void setNumTarjeta( String numTarjeta ){
		this.numTarjeta = numTarjeta;
	}
	
	public void setFechaExpiracion( Date fechaExpiracion ){
		this.fechaExpiracion = fechaExpiracion;
	}	
	
 }
