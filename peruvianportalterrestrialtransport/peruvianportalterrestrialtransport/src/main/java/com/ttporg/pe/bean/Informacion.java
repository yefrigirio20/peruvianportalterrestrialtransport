package com.ttporg.pe.bean;

import java.io.Serializable;

/**
 * @author Cesar Ricardo.
 * @clase: Informacion.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Informacion implements Serializable{
 
	private static final long serialVersionUID = 7225330725902262349L;
	
	private Integer id;
	private String  titulo;
	private String  texto;
	private String  imagen;
	private String  link_01;
	private String  link_02;
		
	//Constructores ...
	public Informacion(){		
	}
	
	public Informacion( Integer id, String titulo, String texto, String imagen, 
			            String link_01, String link_02 ){
		super();
		this.id      = id;
		this.titulo  = titulo;
		this.texto   = texto;
		this.imagen  = imagen;
		this.link_01 = link_01;
		this.link_02 = link_02;
	}

	public Integer getId(){
		return id;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo( String titulo ){
		this.titulo = titulo;
	}
	
	public String getTexto(){
		return texto;
	}
	
	public void setTexto( String texto ){
		this.texto = texto;
	}
	
	public String getImagen(){
		return imagen;
	}
	
	public void setImagen( String imagen ){
		this.imagen = imagen;
	}

	public String getLink_01(){
		return link_01;
	}
	
	public void setLink_01( String link_01 ){
		this.link_01 = link_01;
	}
	
	public String getLink_02(){
		return link_02;
	}
	
	public void setLink_02( String link_02 ){
		this.link_02 = link_02;
	}
	
}

