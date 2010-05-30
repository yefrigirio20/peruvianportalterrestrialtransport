package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Ricardo.
 * @clase: Salida.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Salida implements Serializable{
 
	private static final long serialVersionUID = -4638021671693507485L; 
	
	private Integer   id;
    private String    departamentoSalida; 
    private String    departamentoDestino;
 
    //Objetos Relacionados.
    private List<Calendario> listaCalendarioSalidas;
        
    //Constructores ...
    public Salida(){
       this.listaCalendarioSalidas = new ArrayList<Calendario>();
    }

    public String getDepartamentoDestino() {
        return departamentoDestino;
    }

    public void setDepartamentoDestino(String departamentoDestino) {
        this.departamentoDestino = departamentoDestino;
    }

    public String getDepartamentoSalida() {
        return departamentoSalida;
    }

    public void setDepartamentoSalida(String departamentoSalida) {
        this.departamentoSalida = departamentoSalida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Calendario> getListaCalendarioSalidas() {
        return listaCalendarioSalidas;
    }

    public void setListaCalendarioSalidas(List<Calendario> listaCalendarioSalidas) {
        this.listaCalendarioSalidas = listaCalendarioSalidas;
    }    
    
} 
