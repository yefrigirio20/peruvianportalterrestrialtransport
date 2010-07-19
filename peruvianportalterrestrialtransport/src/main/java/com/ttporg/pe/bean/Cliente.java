package com.ttporg.pe.bean;

import java.util.Date;

/**
 * @author Cesar Ricardo.
 * @clase: Cliente.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Cliente{

	private Integer	id;
    private String	nombres;
    private String	apellidos;
    private String	dni;
    private Date	cumpleanos;
    private String	direccion;
    private String	email;
    
    private String	usuario;
    private String	password;
    private String	tipo;
    private String	estado;

    //Constructores ...
    public Cliente(){		
    }	

    public Cliente( Integer id, String nombres, String apellidos, Date cumpleanos, String direccion, 
                    String foto, String email, String dni, String usuario, String password, String tipo, 
                    String estado ){
        super();
        this.id         = id;
        this.nombres    = nombres;
        this.apellidos  = apellidos;
        this.cumpleanos = cumpleanos;
        this.direccion  = direccion;
        this.email      = email;
        this.usuario    = usuario;
        this.dni        = dni;  
        this.password   = password;
        this.tipo       = tipo;
        this.estado     = estado;
    }
	
	public Integer getId(){
		return id;
	}
	
	public String getNombres(){
		return nombres;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	
	public String getDni(){
		return dni;
	}
	
	public Date getCumpleanos(){
		return cumpleanos;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public String getEstado(){
		return estado;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}

	public void setNombres( String nombres ){
		this.nombres = nombres;
	}
	
	public void setApellidos( String apellidos ){
		this.apellidos = apellidos;
	}
	
	public void setDni( String dni ){
		this.dni = dni;
	}
	
	public void setCumpleanos( Date cumpleanos ){
		this.cumpleanos = cumpleanos;
	}
	
	public void setDireccion( String direccion ){
		this.direccion = direccion;
	}
	
	public void setEmail( String email ){
		this.email = email;
	}
	
	public void setUsuario( String usuario ){
		this.usuario = usuario;
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
	
	public void setTipo( String tipo ){
		this.tipo = tipo;
	}
	
	public void setEstado( String estado ){
		this.estado = estado;
	}    
        
}
