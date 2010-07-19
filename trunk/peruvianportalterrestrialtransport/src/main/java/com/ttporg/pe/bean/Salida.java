package com.ttporg.pe.bean;
 
/**
 * @author Cesar Ricardo.
 * @clase: Salida.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Salida{
	
	private Integer   id;
    private String    departamentoSalida; 
    private String    departamentoDestino;
 
    //Objetos Relacionados.
    private Servicio  servicio;
        
    //Constructores ...
    public Salida(){
       this.servicio = new Servicio();
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
	
	public Servicio getServicio(){
		return servicio;
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
	
	public void setServicio( Servicio servicio ){
		this.servicio = servicio;
	}
 
} 
