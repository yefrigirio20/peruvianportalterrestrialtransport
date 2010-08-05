package com.ttporg.pe.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ajaxtags.servlets.BaseAjaxServlet;

/**
 * @author Cesar Ricardo.
 * @clase: ServletAjax.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class ServletAjax extends BaseAjaxServlet{

	private static final long serialVersionUID = 8156759678414871371L;

	/**
	 * getXmlContent
	 **/
	public String getXmlContent( HttpServletRequest request, HttpServletResponse response ) throws Exception, IOException{			   
		   System.out.println( "**** DENTRO DE 'ServletAjax', (extends BaseAjaxServlet) **** " );	
		   
		   String CADENA = "";

	       try{		
	    	   String objValidacion = "Ricardo Guerra"; //request.getParameter( "PERSONA" );
	    	   
	    	   System.out.println("EL PARAMETRO LLEGADO ES: " + objValidacion );
	    	   
	    	   String MENSAJE = validator(objValidacion);                  //VALIDANDO PARAMETRO LLEGADO!!!
	    	   
	    	   System.out.println("EL PARAMETRO LLEGADO ES: " + MENSAJE );
	    	     	   
	    	   CADENA = "<H1>" + MENSAJE + "</H1>";
	    	   
	       }
	       catch( Exception e ){ 
		   	      e.printStackTrace();
	       } 
	       
		   return CADENA;
	}

	/**
	 * validator
	 * @param  parametro
	 * @return String
	 **/
    public String validator( String parametro ){		
		
		String DISTRITO = "";
		
		if( parametro.equals("Jesus Hernandez") ){
			DISTRITO = "GUADALAJARA";
	   	    System.out.println( "SELECCIONO: GUADALAJARA" );
		}
		else if( parametro.equals("Ricardo Guerra") ){
			DISTRITO = "CHORRILLOS";
	   	    System.out.println( "SELECCIONO: CHORRILLOS" );
		}
		else if( parametro.equals("Felipe Sebastiani") ){
			DISTRITO = "UNIVERSITARIA";
	   	    System.out.println( "SELECCIONO: UNIVERSITARIA" );
		}
		else if( parametro.equals("Maria Arnaiz") ){
			DISTRITO = "CALLAO";
	   	    System.out.println( "SELECCIONO: CALLAO" );
		}
		else if( parametro.equals("Cathy Cotrina") ){
			DISTRITO = "LOS OLIVOS";
	   	    System.out.println( "SELECCIONO: LOS OLIVOS" );
		}		
		else{
			DISTRITO = "PERSONA DESCONOCIDA!!!!";  
	   	    System.out.println( "SELECCIONO: PERSONA DESCONOCIDA!!!!" );
		}	
		
		return DISTRITO;
	}

 }
