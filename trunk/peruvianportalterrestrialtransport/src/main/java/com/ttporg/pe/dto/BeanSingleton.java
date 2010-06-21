package com.ttporg.pe.dto;

import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Pago;

/**
 * ObjetoSingleton
 * @author cguerraa
 */
public class BeanSingleton{

    //Datos que seran almacenados en Memoria.
    private Cliente cliente;
    private Pago    pago;  

    //Constructor...
    public BeanSingleton(){
    	this.cliente = new Cliente();
    	this.pago    = new Pago();
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
    
}

