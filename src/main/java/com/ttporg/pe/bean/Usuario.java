package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cesar Ricardo.
 * @clase: Usuario.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Usuario implements Serializable{

	private static final long serialVersionUID = -3885996850827455569L;
	
	private Integer	id;
	private String	nombres;
	private String	apellidos;
	private Date	cumpleanos;
	private String	direccion;
	private String	foto;
	private String	email;
	private String	usuario;
	private String	password;
	private String	tipo;
	private String	estado;
	
	//Constructores ...
	public Usuario(){		
	}	
	
	public Usuario( Integer id, String nombres, String apellidos, Date cumpleanos, String direccion, 
			        String foto, String email, String usuario, String password, String tipo, String estado ){
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cumpleanos = cumpleanos;
		this.direccion = direccion;
		this.foto = foto;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
		this.estado = estado;
	}

	/**
	 * @return Retorna el Id.
	 */
	public Integer getId(){
		return id;
	}

	/**
	 * @return Retorna el nombres.
	 */
	public String getNombres(){
		return nombres;
	}

	/**
	 * @param nombres El nombres a ingresar.
	 */
	public void setNombres( String nombres ){
		this.nombres = nombres;
	}

	/**
	 * @return Retorna el apellidos.
	 */
	public String getApellidos(){
		return apellidos;
	}

	/**
	 * @param apellidos El apellidos a ingresar.
	 */
	public void setApellidos( String apellidos ){
		this.apellidos = apellidos;
	}

	/**
	 * @return Retorna el cumpleanos.
	 */
	public Date getCumpleanos(){
		return cumpleanos;
	}

	/**
	 * @param cumpleanos El cumpleanos a ingresar.
	 */
	public void setCumpleanos( Date cumpleanos ){
		this.cumpleanos = cumpleanos;
	}

	/**
	 * @return Retorna el direccion.
	 */
	public String getDireccion(){
		return direccion;
	}

	/**
	 * @param direccion El direccion a ingresar.
	 */
	public void setDireccion( String direccion ){
		this.direccion = direccion;
	}

	/**
	 * @return Retorna el foto.
	 */
	public String getFoto(){
		return foto;
	}

	/**
	 * @param foto El foto a ingresar.
	 */
	public void setFoto( String foto ){
		this.foto = foto;
	}

	/**
	 * @return Retorna el email.
	 */
	public String getEmail(){
		return email;
	}

	/**
	 * @param email El email a ingresar.
	 */
	public void setEmail( String email ){
		this.email = email;
	}

	/**
	 * @return Retorna el usuario.
	 */
	public String getUsuario(){
		return usuario;
	}

	/**
	 * @param usuario El usuario a ingresar.
	 */
	public void setUsuario( String usuario ){
		this.usuario = usuario;
	}

	/**
	 * @return Retorna el password.
	 */
	public String getPassword(){
		return password;
	}

	/**
	 * @param password El password a ingresar.
	 */
	public void setPassword( String password ){
		this.password = password;
	}

	/**
	 * @return Retorna el tipo.
	 */
	public String getTipo(){
		return tipo;
	}

	/**
	 * @param tipo El tipo a ingresar.
	 */
	public void setTipo( String tipo ){
		this.tipo = tipo;
	}

	/**
	 * @return Retorna el estado.
	 */
	public String getEstado(){
		return estado;
	}

	/**
	 * @param estado El estado a ingresar.
	 */
	public void setEstado( String estado ){
		this.estado = estado;
	}

	/**
	 * @return Retorna el serialVersionUID.
	 */
	public static long getSerialVersionUID(){
		return serialVersionUID;
	}

	/**
	 * @param id El id a ingresar.
	 */
	public void setId( Integer id ){
		this.id = id;
	}
	
}
