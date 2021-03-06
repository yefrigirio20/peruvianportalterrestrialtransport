package com.ttporg.pe.bean;

import java.util.Calendar;
import java.util.Date;
import com.ttporg.pe.util.UtilCalendario;

/**
 * @author Cesar Ricardo.
 * @clase: Calendario.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class Calendario{

	private Integer	id;
    private Date    fechaHoraSalida; 
    private Date    fechaHoraLlegada; 
    private Integer duracion;   
    private Salida  salida;
    
    //Constructores ...
    public Calendario(){
    	this.salida = new Salida();
    }

    public Integer getDuracion(){
    	
        UtilCalendario utilCalendario = new UtilCalendario();
         
        Calendar fecInicio = Calendar.getInstance();
        Calendar fecFin    = Calendar.getInstance();
 
        this.duracion = 0;
        
        if( (this.fechaHoraSalida != null) && (this.fechaHoraLlegada != null) ){
           
        	fecInicio.setTime( this.fechaHoraSalida  );
        	fecFin.setTime(    this.fechaHoraLlegada );
        	
        	int duracionNew = utilCalendario.getHorasEntreDosFechas( fecInicio, fecFin );

        	 this.duracion = duracionNew;  
        }       
        
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	
	public Salida getSalida(){
		return salida;
	}
	
	public void setSalida( Salida salida ){
		this.salida = salida;
	}    
    
}
