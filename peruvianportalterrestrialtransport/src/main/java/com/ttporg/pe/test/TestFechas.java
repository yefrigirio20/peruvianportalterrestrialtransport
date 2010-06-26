package com.ttporg.pe.test;

import java.util.Date;
import com.ttporg.pe.bean.Calendario;
import com.ttporg.pe.util.UtilCalendario;

/**
 * @author Cesar Ricardo.
 * @clase: TestFechas.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public class TestFechas{

	/**
	 * @param args
	 */
	public static void main( String[] args ){

		UtilCalendario utilCalendario = new UtilCalendario();
		
		Calendario calendario_A02 = new Calendario();
		calendario_A02.setId( 2 );
		calendario_A02.setFechaHoraSalida(  new Date() );
		calendario_A02.setFechaHoraLlegada( utilCalendario.getFechaIncrementaEnHoras( new Date(), 8 ) );
		
		int duracion = utilCalendario.getHorasEntreDosFechas( calendario_A02.getFechaHoraSalida(), calendario_A02.getFechaHoraLlegada() );
 	
		calendario_A02.setDuracion( duracion );
		
		System.out.println( "F.SALIDA:  " + calendario_A02.getFechaHoraSalida()  );
		System.out.println( "F.LLEGADA: " + calendario_A02.getFechaHoraLlegada() );
		System.out.println( "DURACION:  " + calendario_A02.getDuracion()         );		
	}
	
}
