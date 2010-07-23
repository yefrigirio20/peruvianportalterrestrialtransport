package com.ttporg.pe.dto;

import java.util.Date;

/**
 * @author Cesar Ricardo.
 * @clase: DetallePasajeDTO.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public class DetallePasajeDTO{
	
	private Integer  id;
    private String   departamentoSalida; 
    private String   departamentoDestino;
    
    private Date     fechaHoraSalida; 
    private Date     fechaHoraLlegada; 
    private Integer  duracion;   
 	
    //Constructor ...
    public DetallePasajeDTO(){    	
    }
	
	public Integer getId(){
		return id;
	}
	
	public String getDepartamentoSalida(){
		return departamentoSalida;
	}
	
	public String getDepartamentoDestino(){
		return departamentoDestino;
	}
	
	public Date getFechaHoraSalida(){
		return fechaHoraSalida;
	}
	
	public Date getFechaHoraLlegada(){
		return fechaHoraLlegada;
	}

	public Integer getDuracion(){
		return duracion;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public void setDepartamentoSalida( String departamentoSalida ){
		this.departamentoSalida = departamentoSalida;
	}
	
	public void setDepartamentoDestino( String departamentoDestino ){
		this.departamentoDestino = departamentoDestino;
	}
	
	public void setFechaHoraSalida( Date fechaHoraSalida ){
		this.fechaHoraSalida = fechaHoraSalida;
	}
	
	public void setFechaHoraLlegada( Date fechaHoraLlegada ){
		this.fechaHoraLlegada = fechaHoraLlegada;
	}
	
	public void setDuracion( Integer duracion ){
		this.duracion = duracion;
	}    
        
}
