package com.ttporg.pe.servlet;

import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Cesar Ricardo.
 * @clase: ValidaUsuarioServlet.java
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
 *              http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class ValidaUsuarioServlet extends HttpServlet implements Servlet{

	private static final long serialVersionUID = 5755376929184172512L;

	private static final String FORMATO_CONTEXTO = "text/html";

	/**
	 * service
	 * @param request
	 * @param response
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
	    System.out.println( "********* DENTRO DE service **********" ); 
	  
		response.setContentType( FORMATO_CONTEXTO );

		PrintWriter escritor = null; 

		try{
			escritor = response.getWriter();
			
			escritor.println( "<HTML>"    );
			escritor.println( "<HEAD><TITLE>...::: OPCION: ' ' :::...</TITLE></HEAD>" );
			escritor.println( "<BODY bgColor='black'>" );
			escritor.println( "<BR></BR>" );
			escritor.println( "<BR></BR>" );
			escritor.println( "<CENTER> <FONT COLOR='WHITE'> EL SERVLET EJECUTADO ES DE TIPO: <STRONG><FONT COLOR='YELLOW'> '" + "AAAS" + "'</FONT></STRONG>.</FONT> </CENTER>" );
			escritor.println( "<BR></BR>" );
			escritor.println( "<BR></BR>" );
			escritor.println( "<BR></BR>" );
			escritor.println( "<BR></BR>" );
			escritor.println( "</BODY>"   );
			escritor.println( "</HTML>"   );
		} 
		catch( IOException e ){
			   e.printStackTrace();
		} 
		catch( Exception e ){
			   e.printStackTrace();
		}
		finally{
				if( escritor != null ){
					escritor.close();
				}			   
		}
    }
 

 } 
