package com.ttporg.pe.bean;
 
/**
 * @author Cesar Ricardo.
 * @clase: Vehiculo.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Vehiculo{
	
	private Integer	id;
    private String  nombre;
    private String  modelo;
    private String  tipo;
    
    //Objetos Relacionados.
     private Servicio servicio;
        
    //Constructores ...
    public Vehiculo(){
       this.servicio = new Servicio();
    }
	
	public Integer getId(){
		return id;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre( String nombre ){
		this.nombre = nombre;
	}
	
	public String getModelo(){
		return modelo;
	}
	
	public void setModelo( String modelo ){
		this.modelo = modelo;
	}

	public String getTipo(){
		return tipo;
	}
	
	public void setTipo( String tipo ){
		this.tipo = tipo;
	}
	
	public Servicio getServicio(){
		return servicio;
	}
	
	public void setServicio( Servicio servicio ){
		this.servicio = servicio;
	}
      
}
