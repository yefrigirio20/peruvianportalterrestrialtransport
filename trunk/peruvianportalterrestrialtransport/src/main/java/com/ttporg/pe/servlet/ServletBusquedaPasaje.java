package com.ttporg.pe.servlet;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletBusquedaPasaje extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID = -2689096730483634614L;

	/**
	 * service
	 * @param request
	 * @param response
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
	    System.out.println( "********* DENTRO DE service **********" ); 
	 }    
	
}
