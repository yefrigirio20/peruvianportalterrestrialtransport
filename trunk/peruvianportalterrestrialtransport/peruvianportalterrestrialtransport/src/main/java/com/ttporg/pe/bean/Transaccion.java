package com.ttporg.pe.bean;

import java.io.Serializable;

/**
 * @author Cesar Ricardo.
 * @clase: Transaccion.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Transaccion implements Serializable{
 
	private static final long serialVersionUID = 1790104835598537803L;
	
	private Integer  id;
    private Cliente  cliente;
    private Empresa  empresa;
        
    //Constructores ...
    public Transaccion(){
        this.cliente = new Cliente();
        this.empresa = new Empresa();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
