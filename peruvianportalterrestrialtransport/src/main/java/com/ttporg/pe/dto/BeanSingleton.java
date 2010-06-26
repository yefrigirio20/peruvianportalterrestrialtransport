package com.ttporg.pe.dto;

import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.bean.Vehiculo;

/**
 * @author Cesar Ricardo.
 * @clase: BeanSingleton.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class BeanSingleton{

    //Datos que seran almacenados en Memoria.
    private  Cliente  cliente;
    private  Pago     pago; 
    private  Asiento  asiento; 
    private  Vehiculo vehiculo;

    //Constructor...
    public BeanSingleton(){
    	this.cliente  = new Cliente();
    	this.pago     = new Pago();
    	this.asiento  = new Asiento();
    	this.vehiculo = new Vehiculo();
    }
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public void setCliente( Cliente cliente ){
		this.cliente = cliente;
	}
	
	public Pago getPago(){
		return pago;
	}
	
	public void setPago( Pago pago ){
		this.pago = pago;
	}
	
	public Asiento getAsiento(){
		return asiento;
	}
	
	public void setAsiento( Asiento asiento ){
		this.asiento = asiento;
	}
	
	public Vehiculo getVehiculo(){
		return vehiculo;
	}
	
	public void setVehiculo( Vehiculo vehiculo ){
		this.vehiculo = vehiculo;
	} 
	
}

