package com.ttporg.pe.bean;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Ricardo.
 * @clase: Servicio.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Servicio implements Serializable{
 
	private static final long serialVersionUID = 9077905645082144658L;
	
	private Integer	    id;
    private String      nombre;
    private String      descripcion;

    //Objetos Relacionados.
    private List<Salida>   listaSalidas; 
    private List<Vehiculo> listaVehiculos;
        
    //Constructores ...
    public Servicio(){
        this.listaSalidas   = new ArrayList<Salida>();
        this.listaVehiculos = new ArrayList<Vehiculo>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Salida> getListaSalidas() {
        return listaSalidas;
    }

    public void setListaSalidas( List<Salida> listaSalidas) {
        this.listaSalidas = listaSalidas;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos( List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
}
