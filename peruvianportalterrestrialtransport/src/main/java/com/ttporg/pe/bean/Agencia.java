package com.ttporg.pe.bean;
 
/**
 * @author Cesar Ricardo.
 * @clase: Agencia.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Agencia{
	
	private Integer	    id;
    private String      nombre;
    private String      direccion;
    private String      telefono;
    private String      email;
    private String      estado;
    
    private Empresa     empresa;
    
    //Constructores ...
    public Agencia(){
        this.empresa = new Empresa();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
	public String getEstado(){
		return estado;
	}
	
	public void setEstado( String estado ){
		this.estado = estado;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
	
	public Empresa getEmpresa(){
		return empresa;
	}
	
	public void setEmpresa( Empresa empresa ){
		this.empresa = empresa;
	}    
        
}
