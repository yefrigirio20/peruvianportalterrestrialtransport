package com.ttporg.pe.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.servicio.ServiceFactory;
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilGeneraBoletoViaje;
import com.ttporg.pe.util.UtilSingleton;

/**
 * @author Cesar Ricardo.
 * @clase: ServletGeneraBoleto.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class ServletGeneraBoleto extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID   = 7462872182111077306L;

	private ServletContext    contexto           = null;
	private RequestDispatcher despachador        = null;
	
	//Singleton ...
	private UtilSingleton     utilSingleton      = null;
	
	//Service ...
	private ServiceFactory    servicio           = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = null;
	
	private String            REDIRECCIONAMIENTO = "/jsp/PagoPasaje.jsp";		
	
	
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
 
		    
		    try{
		    	HttpSession session = request.getSession( true );
		    	
		    	//OBTENIENDO DE SESION ...
				Cliente objCliente         = (Cliente)session.getValue( "objCliente" );  		    	
				Pago    objPago            = (Pago)session.getValue(    "objPago" ); 
    	    	String  codigoDepartamento = (String)session.getValue( "codigoDepartamento" ); 
    	    	String  codigoEmpresa      = (String)session.getValue( "codigoEmpresa" ); 							
    	    	String  codigoAgencia      = (String)session.getValue( "codigoAgencia" ); 
    	    	String  codigoServicio     = (String)session.getValue( "codigoServicio" ); 	    	    		    	
    	    	String  codigoAsiento      = (String)session.getValue( "idAsientoSeleccionado" ); 
    	    	    	    	
		    	UtilGeneraBoletoViaje generaBoleto = new UtilGeneraBoletoViaje();
		    	generaBoleto.muestraBoletoViaje( objCliente, objPago, codigoDepartamento, codigoEmpresa, codigoAgencia, codigoServicio, codigoAsiento );
	            
	            this.contexto    = this.getServletContext();
	            this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
	           
	            this.despachador.forward( request, response );                 //Redirecciona con los parametros seteados.	           
		    }
		    catch( Exception e ){
				   e.printStackTrace();
			}
	 }    
	
}
