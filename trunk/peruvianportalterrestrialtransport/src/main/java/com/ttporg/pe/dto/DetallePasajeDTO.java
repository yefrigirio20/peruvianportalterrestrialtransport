package com.ttporg.pe.dto;

import java.util.Date;

/**
 * @author Cesar Ricardo.
 * @clase: DetallePasajeDTO.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
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
