package com.ttporg.pe.bean;
 
/**
 * @author Cesar Ricardo.
 * @clase: Servicio.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Servicio{
	
	private Integer	 id;
    private String   nombre;
    private String   descripcion;
    private double	 monto;

    //Objetos Relacionados.
    private Agencia  agencia;
        
    //Constructores ...
    public Servicio(){
        this.agencia = new Agencia();
    }
	
	public Integer getId(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public double getMonto(){
		return monto;
	}
	
	public Agencia getAgencia(){
		return agencia;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public void setNombre( String nombre ){
		this.nombre = nombre;
	}
	
	public void setDescripcion( String descripcion ){
		this.descripcion = descripcion;
	}
	
	public void setMonto( double monto ){
		this.monto = monto;
	}
	
	public void setAgencia( Agencia agencia ){
		this.agencia = agencia;
	}
 
}
