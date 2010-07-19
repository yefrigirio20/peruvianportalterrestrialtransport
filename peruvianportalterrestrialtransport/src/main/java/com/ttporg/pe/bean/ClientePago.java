package com.ttporg.pe.bean;
 
/**
 * @author Cesar Ricardo.
 * @clase: ClientePago.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class ClientePago{

	private Integer  id;
	private Cliente  cliente;
	private Pago     pago;	
	
    //Constructor ...
    public ClientePago(){  
    	this.cliente = new Cliente();
    	this.pago    = new Pago();
    }
	
	public Integer getId(){
		return id;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public Pago getPago(){
		return pago;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}

	public void setCliente( Cliente cliente ){
		this.cliente = cliente;
	}
	
	public void setPago( Pago pago ){
		this.pago = pago;
	}
        	
}
