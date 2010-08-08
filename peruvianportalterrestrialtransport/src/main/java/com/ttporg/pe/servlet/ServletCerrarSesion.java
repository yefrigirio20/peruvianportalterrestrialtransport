package com.ttporg.pe.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ttporg.pe.bean.BaseBean;

/**
 * @author Cesar Ricardo.
 * @clase: ServletCerrarSesion.java   
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServletCerrarSesion extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID = 918161038759297916L;

	private ServletContext    contexto           = null;
	private RequestDispatcher despachador        = null;
	
	//Utilitarios ...
	private BaseBean          beanBase           = null;
	
	private static String     REDIRECCIONAMIENTO = "/login.action";
	
	{
	 this.beanBase = new BaseBean();
	}
 	
	/**
	 * service
	 * @param request
	 * @param response
	 **/	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
		this.imprimeLog( "********* DENTRO DE service **********" ); 
  	    
	    HttpSession session = request.getSession( true );
	    
	    try{ 
	    	session.invalidate();  //Elimina la sesion ...
	    	
	        this.contexto    = this.getServletContext();
	        this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
	        
	        this.despachador.forward( request, response );  //Redirecciona con los parametros seteados.	  
	    } 
	    catch( Exception e ){
			   e.printStackTrace();
		}	    
	}  
 	
	/**
	 * imprimeLog
	 * @param mensaje
	 **/
	public void imprimeLog( String mensaje ){ 
		this.beanBase.imprimeLog( mensaje, this.getClass().toString() );
	}
	
}

