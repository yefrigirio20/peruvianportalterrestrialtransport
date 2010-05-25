package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Ricardo.
 * @clase: Empresa.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Empresa implements Serializable{
 
	private static final long serialVersionUID = 1445698493556024684L;
	
	private Integer	      id;
	private String	      razonSocial;
    private String        ruc;
    private String        pais;
    private String        departamento;
    private String        direccion;
    private String        telefono;
    private String        email;
	private String	      usuario;
	private String	      password; 
	private Portal        portal = new Portal();
    private List<Cliente> listaClientes; 
    
	//Constructores ...
	public Empresa(){
		this.portal        = new Portal();
		this.listaClientes = new ArrayList<Cliente>();
	}

	public Empresa( Integer id, String razonSocial, String ruc, String pais, String departamento, 
			        String direccion, String telefono, String email, String usuario, String password, 
			        Portal portal, List<Cliente> listaClientes ){
		super();
		this.id            = id;
		this.razonSocial   = razonSocial;
		this.ruc           = ruc;
		this.pais          = pais;
		this.departamento  = departamento;
		this.direccion     = direccion;
		this.telefono      = telefono;
		this.email         = email;
		this.usuario       = usuario;
		this.password      = password;
		this.portal        = portal;
		this.listaClientes = listaClientes;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId( Integer id ){
		this.id = id;
	}
	
	public String getRazonSocial(){
		return razonSocial;
	}
	
	public void setRazonSocial( String razonSocial ){
		this.razonSocial = razonSocial;
	}
	
	public String getRuc(){
		return ruc;
	}
	
	public void setRuc( String ruc ){
		this.ruc = ruc;
	}
	
	public String getPais(){
		return pais;
	}
	
	public void setPais( String pais ){
		this.pais = pais;
	}
	
	public String getDepartamento(){
		return departamento;
	}
	
	public void setDepartamento( String departamento ){
		this.departamento = departamento;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public void setDireccion( String direccion ){
		this.direccion = direccion;
	}
	
	public String getTelefono(){
		return telefono;
	}
	
	public void setTelefono( String telefono ){
		this.telefono = telefono;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail( String email ){
		this.email = email;
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public void setUsuario( String usuario ){
		this.usuario = usuario;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
	
	public Portal getPortal(){
		return portal;
	}
	
	public void setPortal( Portal portal ){
		this.portal = portal;
	}
	
	public List<Cliente> getListaClientes(){
		return listaClientes;
	}
	
	public void setListaClientes( List<Cliente> listaClientes ){
		this.listaClientes = listaClientes;
	}
	
	public static long getSerialVersionUID(){
		return serialVersionUID;
	}	  
	
}
