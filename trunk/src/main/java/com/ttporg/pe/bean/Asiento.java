package com.ttporg.pe.bean;

import java.io.Serializable;

/**
 * @author Cesar Ricardo.
 * @clase: Asiento.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Asiento implements Serializable{
 
	private static final long	serialVersionUID	= 8515852719018556407L;
	
	private Integer	     id;
    private String        fila;
    private String        columna;
    private boolean       estado;   //True = Libre - False = Ocupado
    
    //Constructores ...
    public Asiento(){
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   
    
}
