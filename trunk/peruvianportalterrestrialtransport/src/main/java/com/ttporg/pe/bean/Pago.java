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
	private Cliente cliente;
	
	//Constructores ...
	public Pago(){
		this.cliente = new Cliente();
	}
		
	public Pago( Integer id, String tipoPago, String  numTarjeta, Date fechaExpiracion, Cliente cliente ){
		super();
		this.id              = id;
		this.tipoPago        = tipoPago;
		this.numTarjeta      = numTarjeta;
		this.fechaExpiracion = fechaExpiracion;
		this.cliente         = cliente;
	}	
	
	public String getNumTarjeta(){
		return numTarjeta;
	}
	
	public void setNumTarjeta( String numTarjeta ){
		this.numTarjeta = numTarjeta;
	}

	public Integer getId(){
		return id;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public String getTipoPago(){
		return tipoPago;
	}
	
	public void setTipoPago( String tipoPago ){
		this.tipoPago = tipoPago;
	}
	
	public Date getFechaExpiracion(){
		return fechaExpiracion;
	}
	
	public void setFechaExpiracion( Date fechaExpiracion ){
		this.fechaExpiracion = fechaExpiracion;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public void setCliente( Cliente cliente ){
		this.cliente = cliente;
	}	
	
 }
