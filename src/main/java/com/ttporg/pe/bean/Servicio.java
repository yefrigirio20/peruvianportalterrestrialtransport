package com.ttporg.pe.bean;

import java.io.Serializable; 
import java.util.ArrayList;

/**
 * @author Cesar Ricardo.
 * @clase: Servicio.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Servicio implements Serializable{
 
	private static final long serialVersionUID = 9077905645082144658L;
	
	private Integer	    id;
    private String      nombre;
    private String      descripcion;

    //Objetos Relacionados.
    private ArrayList<Salida>   listaSalidas; 
    private ArrayList<Vehiculo> listaVehiculos;
        
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

    public ArrayList<Salida> getListaSalidas() {
        return listaSalidas;
    }

    public void setListaSalidas(ArrayList<Salida> listaSalidas) {
        this.listaSalidas = listaSalidas;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
}
