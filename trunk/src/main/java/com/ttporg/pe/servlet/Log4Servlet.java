
package com.ttporg.pe.servlet;

import org.apache.log4j.PropertyConfigurator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Ricardo Guerra.
 * @clase: Log4Servlet.java  
 * @descripción: servlet que inicializar el framework 'log4j'.
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com 
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creación: 10-01-2009.
 * @fecha_de_ultima_actualización: 23-07-2009.
 * @versión: 1.0
 */
 public class Log4Servlet extends HttpServlet{

	private static final long serialVersionUID = 9199912763205533615L;
	
	 public void init(){
		System.out.println("****************** CARGANDO 'LOG4J' ********************");  
		  
	    String  prefix  =  this.getServletContext().getRealPath( "/" );
	    String  file    =  this.getInitParameter( "log4j_Servlet" );
	    
		System.out.println("****************** prefix: " + prefix ); 
		System.out.println("****************** file:   " + file   ); 
	    
	    if( file != null ){
	        PropertyConfigurator.configure( prefix + file );	   
	        
	        //Probando Impresion 'Logger' ...
	   	    LoggerBean imprimerLogger = new LoggerBean();
	      	 
	   	    imprimerLogger.manejoLog4jLogger();
	   	    imprimerLogger.manejoCommonsLogger();
	   	    imprimerLogger.manejoUtilLogger();   
	    }	    
	  }
	
	  public void doGet( HttpServletRequest req, HttpServletResponse res ){
	  }
  
	  public void doPost( HttpServletRequest req, HttpServletResponse res ){
	  }
	  
 }
