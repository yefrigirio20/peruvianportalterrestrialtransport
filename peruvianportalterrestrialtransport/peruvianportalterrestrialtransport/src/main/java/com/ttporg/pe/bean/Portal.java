package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
    
/**
 * @author Cesar Ricardo.
 * @clase: Portal.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Portal implements Serializable{
 
	private static final long serialVersionUID = 2353401384110006510L;
	
	private Integer           id;
    private String            url;
	private String            cabecera;
	private Informacion       infoCentral;
	private List<Informacion> listaInfoIzquierda;
	private Informacion       infoPie;
	
	//Constructores ...
	public Portal(){
		this.infoCentral        = new Informacion();
		this.listaInfoIzquierda = new ArrayList<Informacion>();
		this.infoPie            = new Informacion();
	}

	public Portal( Integer id, String url, String cabecera, Informacion infoCentral, 
			       List<Informacion> listaInfoIzquierda, Informacion infoPie ){
		super();
		this.id                 = id;
		this.url                = url;
		this.cabecera           = cabecera;
		this.infoCentral        = infoCentral;
		this.listaInfoIzquierda = listaInfoIzquierda;
		this.infoPie            = infoPie;
	}

	public Integer getId(){
		return id;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setUrl( String url ){
		this.url = url;
	}
	
	public String getCabecera(){
		return cabecera;
	}
	
	public void setCabecera( String cabecera ){
		this.cabecera = cabecera;
	}
	
	public Informacion getInfoCentral(){
		return infoCentral;
	}
	
	public void setInfoCentral( Informacion infoCentral ){
		this.infoCentral = infoCentral;
	}
	
	public List<Informacion> getListaInfoIzquierda(){
		return listaInfoIzquierda;
	}
	
	public void setListaInfoIzquierda( List<Informacion> listaInfoIzquierda ){
		this.listaInfoIzquierda = listaInfoIzquierda;
	}
	
	public Informacion getInfoPie(){
		return infoPie;
	}
	
	public void setInfoPie( Informacion infoPie ){
		this.infoPie = infoPie;
	}
	
	public static long getSerialVersionUID(){
		return serialVersionUID;
	}	
		
}
