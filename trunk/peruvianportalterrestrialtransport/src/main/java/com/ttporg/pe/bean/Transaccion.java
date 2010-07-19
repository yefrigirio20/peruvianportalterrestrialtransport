package com.ttporg.pe.bean;

/**
 * @author Cesar Ricardo.
 * @clase: Transaccion.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Transaccion{
 
	private Integer      id;
	private Empresa      empresa;
	private Cliente      cliente;
	private Agencia      agencia;
	private Servicio     servicio;
	private Salida       salida;
	private Vehiculo     vehiculo;
	private Asiento      asiento; 
         
    //Constructores ...
    public Transaccion(){  
    	this.empresa  = new Empresa();
    	this.cliente  = new Cliente();
    	this.agencia  = new Agencia();
    	this.servicio = new Servicio();
    	this.vehiculo = new Vehiculo();
    	this.asiento  = new Asiento();
    }
	
	public Integer getId(){
		return id;
	}
	
	public Empresa getEmpresa(){
		return empresa;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public Agencia getAgencia(){
		return agencia;
	}
	
	public Servicio getServicio(){
		return servicio;
	}
	
	public Salida getSalida(){
		return salida;
	}
	
	public Vehiculo getVehiculo(){
		return vehiculo;
	}
	
	public Asiento getAsiento(){
		return asiento;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public void setEmpresa( Empresa empresa ){
		this.empresa = empresa;
	}
	
	public void setCliente( Cliente cliente ){
		this.cliente = cliente;
	}
	
	public void setAgencia( Agencia agencia ){
		this.agencia = agencia;
	}
	
	public void setServicio( Servicio servicio ){
		this.servicio = servicio;
	}
	
	public void setSalida( Salida salida ){
		this.salida = salida;
	}
	
	public void setVehiculo( Vehiculo vehiculo ){
		this.vehiculo = vehiculo;
	}
	
	public void setAsiento( Asiento asiento ){
		this.asiento = asiento;
	} 
	
}
