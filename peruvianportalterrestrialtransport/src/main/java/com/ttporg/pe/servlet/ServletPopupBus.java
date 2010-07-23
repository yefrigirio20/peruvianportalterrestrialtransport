package com.ttporg.pe.servlet;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ttporg.pe.dto.DetalleAsientoDTO;
import com.ttporg.pe.servicio.ServiceFactory;
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
	private ServiceFactory    servicio           = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = null;
	
	private String            REDIRECCIONAMIENTO = "/jsp/PopupBus.jsp";
	
	{
	 this.servicio       = new ServiceFactory();
	 this.utilCalendario = new UtilCalendario();
	}
	
	/**
	 * service
	 * @param request
	 * @param response
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
	    System.out.println( "********* DENTRO DE service **********" ); 
        
	    List<DetalleAsientoDTO> listaDetalleAsientoDTO = null;
	    
	    try{
	    	String idServicio            = request.getParameter( "idServicio" );	    	
	    	String idAsientoSeleccionado = request.getParameter( "idAsiento"  );
	    		    	
	    	System.out.println( "idServicio: " + idServicio );	    	
	    	System.out.println( "idAsiento:  " + idAsientoSeleccionado );

	    	//-------------- Obtener 'BASE DE DATOS'. --------------//
	    	listaDetalleAsientoDTO = new ArrayList<DetalleAsientoDTO>();
	    	
	    	listaDetalleAsientoDTO = this.servicio.getSalidaDAO().obtenerListaDetalleAsientoDTO( Integer.parseInt( idServicio ) );  
	    	//------------------------------------------------------//
	    	
	    	//Validando ...
	    	if( idAsientoSeleccionado != null ){
		    	for( int i=0; i<listaDetalleAsientoDTO.size(); i++ ){
 		
		    		DetalleAsientoDTO asiento = listaDetalleAsientoDTO.get( i );
			    	 
			    	 if( asiento.getIdAsiento() == Integer.parseInt( idAsientoSeleccionado ) ){
			    		 asiento.setEstadoAsiento( "TRUE" );
			    	 }
			    }				    
	    	}
 	    	
	    	request.setAttribute( "listaDetalleAsientoDTO", listaDetalleAsientoDTO );  //estadoValidacion ...
	    	
	        this.contexto    = this.getServletContext();
	        this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
	        
	        this.despachador.forward( request, response );                           //Redirecciona con los parametros seteados.	  
	    } 
	    catch( Exception e ){
			   e.printStackTrace();
		}	    
	 }  
	
}
