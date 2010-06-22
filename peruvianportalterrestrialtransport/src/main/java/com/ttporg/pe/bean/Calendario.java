package com.ttporg.pe.bean;

import com.ttporg.pe.util.UtilCalendario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Cesar Ricardo.
 * @clase: Calendario.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Calendario implements Serializable{
 
	private static final long serialVersionUID = 8169477857746198292L; 
	
	private Integer	id;
    private Date    fechaHoraSalida; 
    private Date    fechaHoraLlegada; 
    private Integer duracion;   
    
    //Constructores ...
    public Calendario(){
    }

    public Integer getDuracion(){
        
        UtilCalendario manejador = new UtilCalendario();
        
        Calendar fecInicio = Calendar.getInstance();
        Calendar fecFin    = Calendar.getInstance();
 
        this.duracion = 0;
        
        if( (this.fechaHoraSalida == null) && (this.fechaHoraLlegada == null) ){
           
            fecInicio.setTime( this.fechaHoraSalida  );
            fecFin.setTime(    this.fechaHoraLlegada );

            int  diaFI     = fecInicio.get( Calendar.DATE  );
            int  mesFI     = fecInicio.get( Calendar.MONTH ) + 1;
            int  anoFI     = fecInicio.get( Calendar.YEAR  );
            int  horaFI    = fecInicio.get( Calendar.DAY_OF_MONTH );
            int  minutoFI  = fecInicio.get( Calendar.MINUTE );
            int  segundoFI = fecInicio.get( Calendar.SECOND );

            int  diaFF     = fecFin.get( Calendar.DATE   );
            int  mesFF     = fecFin.get( Calendar.MONTH  ) + 1;
            int  anoFF     = fecFin.get( Calendar.YEAR   );
            int  horaFF    = fecFin.get( Calendar.DAY_OF_MONTH );
            int  minutoFF  = fecFin.get( Calendar.MINUTE );
            int  segundoFF = fecFin.get( Calendar.SECOND );

            System.out.println( "FechaInicio: " + fecInicio.getTime() );
            System.out.println( "FechaFin:    " + fecFin.getTime()    );

            int diferenciaHoras = manejador.getHorasEntreDosFechas( fecInicio, fecFin );

            System.out.println( "DIFERENCIA HORAS: " + diferenciaHoras ); 
            
            this.setDuracion( diferenciaHoras );
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
    
}
