package com.ttporg.pe.bean;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Ricardo.
 * @clase: Departamento.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Departamento implements Serializable{
 
	private static final long serialVersionUID = 4221295068386594114L;
	
	private Integer	id;
    private String      nombre;
 
    //Objetos Relacionados.
    private List<Empresa> listaEmpresas;
    
    //Constructores ...
    public Departamento(){
        this.listaEmpresas = new ArrayList<Empresa>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
}    
