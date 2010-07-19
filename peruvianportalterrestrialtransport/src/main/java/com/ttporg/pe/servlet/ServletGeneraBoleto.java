package com.ttporg.pe.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilGeneraBoletoViaje;
import com.ttporg.pe.util.UtilSingleton;

/**
 * @author Cesar Ricardo.
 * @clase: ServletGeneraBoleto.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServletGeneraBoleto extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID   = 7462872182111077306L;

	private ServletContext    contexto           = null;
	private RequestDispatcher despachador        = null;
	
	//Singleton ...
	private UtilSingleton     utilSingleton      = null;
	
	//Service ...
	//private ClienteService    servicio           = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = new UtilCalendario();
	
	private String            REDIRECCIONAMIENTO = "/jsp/PagoPasaje.jsp";		
	
	/**
	 * service
	 * @param request
	 * @param response
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
		    System.out.println( "********* DENTRO DE service **********" ); 
 
		    
		    try{
		    	UtilGeneraBoletoViaje generaBoleto = new UtilGeneraBoletoViaje();
		    	generaBoleto.muestraBoletoViaje();
	            
	            this.contexto    = this.getServletContext();
	            this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
	           
	            this.despachador.forward( request, response );                 //Redirecciona con los parametros seteados.	           
		    }
		    catch( Exception e ){
				   e.printStackTrace();
			}
	 }    
	
}
