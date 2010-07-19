package com.ttporg.pe.bean;
 
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
public class Empresa{
	
	private Integer	      id;
    private String	      razonSocial;
    private String        pais;
    private String        ruc;
    private String	      usuario;
    private String	      password; 
    private String        estado;
    
    private Departamento  departamento;    
 
    
    //Constructores ...
    public Empresa(){
    }
 
    public Empresa( Integer id, String razonSocial, String pais, String ruc, String usuario, 
                    String password, String estado, Departamento  departamento ){
        this.id            = id;
        this.razonSocial   = razonSocial;
        this.pais          = pais;
        this.ruc           = ruc;
        this.usuario       = usuario;
        this.password      = password;        
        this.estado        = estado;
 
        this.departamento  = departamento;
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
	
	public String getPais(){
		return pais;
	}
	
	public void setPais( String pais ){
		this.pais = pais;
	}
	
	public String getRuc(){
		return ruc;
	}

	public void setRuc( String ruc ){
		this.ruc = ruc;
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
	
	public String getEstado(){
		return estado;
	}
	
	public void setEstado( String estado ){
		this.estado = estado;
	}
	
	public Departamento getDepartamento(){
		return departamento;
	}

	public void setDepartamento( Departamento departamento ){
		this.departamento = departamento;
	}
     
}
