package com.ttporg.pe.dto;
 
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Ricardo.
 * @clase: ObjValidacionDto.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class BeanValidacionDto{
	
	private String       mensajeOK;
	private List<String> mensajesNOK;
	
	//Constructores ...
	public BeanValidacionDto(){
		this.mensajesNOK = new ArrayList<String>();
	}
	
	public BeanValidacionDto( String mensajeOK, List<String> mensajesNOK ){
		super();
		this.mensajeOK   = mensajeOK;
		this.mensajesNOK = mensajesNOK;
	}
	
	public String getMensajeOK(){
		return mensajeOK;
	}
	
	public void setMensajeOK( String mensajeOK ){
		this.mensajeOK = mensajeOK;
	}
	
	public List<String> getMensajesNOK(){
		return mensajesNOK;
	}
	
	public void setMensajesNOK( List<String> mensajesNOK ){
		this.mensajesNOK = mensajesNOK;
	}   
	
}
