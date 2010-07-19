package com.ttporg.pe.servlet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.bean.Vehiculo;
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilSingleton;

/**
 * @author Cesar Ricardo.
 * @clase: ServletPopupBus.java  sd
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServletPopupBus extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID = 918161070629297916L;

	private ServletContext    contexto           = null;
	private RequestDispatcher despachador        = null;
	
	//Singleton ...
	private UtilSingleton     utilSingleton      = null;
		
	//Service ...
	//private ClienteService    servicio         = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = new UtilCalendario();
	
	private String            REDIRECCIONAMIENTO = "/jsp/PopupBus.jsp";
	
	/**
	 * service
	 * @param request
	 * @param response
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
	    System.out.println( "********* DENTRO DE service **********" ); 
        
	    try{
	    	String nombreServicio = request.getParameter( "nombreServicio" );	    	
	    	String idAsientoSeleccionado      = request.getParameter( "idAsiento" );
	    		    	
	    	System.out.println( "nombreServicio: " + nombreServicio );	    	
	    	System.out.println( "idAsiento:      " + idAsientoSeleccionado );
	    		    	
	    	Servicio objServicio = new Servicio();
	    	
	    	objServicio.setId(     1 );
	    	objServicio.setNombre( nombreServicio );
	    	
	    	Vehiculo objVehiculo = new Vehiculo();
	    	objVehiculo.setId(     1 );
	    	objVehiculo.setTipo(   "SIMPLE" );
	    	objVehiculo.setModelo( "MERCEDES BENZ" );
	    	
	    	//objServicio.setVehiculo( objVehiculo );
	    	
	    	List<Asiento> listaAsiento = new ArrayList<Asiento>();
	    	
	    	int contador = 1;
	    	
	    	for( int i=0; i<20; i++ ){
	    		 
		    	 Asiento objAsiento = new Asiento();
		    	 objAsiento.setId(     contador );
		    	// objAsiento.setEstado( false );
		    		    		
		    	 //Agregando ...
		    	 listaAsiento.add( objAsiento );
		    	
		    	 //objServicio.getVehiculo().setListaAsientos( listaAsiento );
		    	 
		    	 contador ++;
	    	}	    	   	 
	    	
	    	//SETEO HARDCODE... 
	    	for( int i=0; i<listaAsiento.size(); i++ ){
	
		    	 Asiento asiento = listaAsiento.get( i );
		    	 
		    	 if( (asiento.getId() == 5) || (asiento.getId() == 7) || (asiento.getId() == 9) || 
		    	     (asiento.getId() == 13) || (asiento.getId() == 17) || (asiento.getId() == 11) ){
		    		 //asiento.setEstado( true );
		    	 }
		    }	
	    
	    		    	
	    	//Validando ...
	    	if( idAsientoSeleccionado != null ){
		    	for( int i=0; i<listaAsiento.size(); i++ ){
 		
			    	 Asiento asiento = listaAsiento.get( i );
			    	 
			    	 if( asiento.getId() == Integer.parseInt( idAsientoSeleccionado ) ){
			    		// asiento.setEstado( true );
			    	 }
			    }	
	    	}
	    	
	    	//request.setAttribute( "listaAsiento", objServicio.getVehiculo().getListaAsientos() );  //estadoValidacion ...
	    	
	        this.contexto    = this.getServletContext();
	        this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
	        
	        this.despachador.forward( request, response );                           //Redirecciona con los parametros seteados.	  
	    } 
	    catch( Exception e ){
			   e.printStackTrace();
		}	    
	 }  
	
}
