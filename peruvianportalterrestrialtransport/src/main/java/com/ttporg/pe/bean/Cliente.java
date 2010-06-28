package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.Date;
 
/**
 * @author Cesar Ricardo.
 * @clase: Cliente.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Cliente implements Serializable{
 
	private static final long serialVersionUID = -4559388532885775967L; 
	
	private Integer	id;
    private String	nombres;
    private String	apellidos;
    private Date	cumpleanos;
    private String	direccion;
    private String	dni;
    private String	foto;
    private String	email;
    private String	usuario;
    private String	password;
    private String	tipo;
    private String	estado;

    //Constructores ...
    public Cliente(){		
    }	

    public Cliente( Integer id, String nombres, String apellidos, Date cumpleanos, String direccion, 
                    String foto, String email, String dni, String usuario, String password, String tipo, String estado ){
            super();
            this.id         = id;
            this.nombres    = nombres;
            this.apellidos  = apellidos;
            this.cumpleanos = cumpleanos;
            this.direccion  = direccion;
            this.foto       = foto;
            this.email      = email;
            this.usuario    = usuario;
            this.dni        = dni;  
            this.password   = password;
            this.tipo       = tipo;
            this.estado     = estado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(Date cumpleanos) {
        this.cumpleanos = cumpleanos;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
	
	public String getDni(){
		return dni;
	}
	
	public void setDni( String dni ){
		this.dni = dni;
	}
	
	public static long getSerialVersionUID(){
		return serialVersionUID;
	}    
        
}