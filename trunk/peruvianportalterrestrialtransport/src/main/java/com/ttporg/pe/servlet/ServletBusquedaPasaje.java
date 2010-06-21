package com.ttporg.pe.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttporg.pe.bean.Calendario;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilSingleton;

/**
 * @author Cesar Ricardo.
 * @clase: ServletBusquedaPasaje.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServletBusquedaPasaje extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID = -2689096730483634614L;
 
	private ServletContext    contexto           = null;
	private RequestDispatcher despachador        = null;
	
	//Singleton ...
	private UtilSingleton     utilSingleton      = null;
	
	//Service ...
	//private ClienteService    servicio           = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = new UtilCalendario();
	
	private String            REDIRECCIONAMIENTO = "/jsp/BusquedaPasaje.jsp";		
	
	/**
	 * service
	 * @param request
	 * @param response
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
	    System.out.println( "********* DENTRO DE service **********" ); 
	    
	    List<Empresa>  listaEmpresa  = null;
	    List<Servicio> listaServicio = null;
	    List<Salida>   listaSalida   = null;
	    
	    try{
    	    String codigoDepartamento = request.getParameter( "choDepartamento" );
    	    String codigoEmpresa      = request.getParameter( "choEmpresa"      );
    	    String opcion             = request.getParameter( "opcion"          );
    	    
    	    System.out.println( "" );
    	    System.out.println( "DATOS INGRESADOS DEL CLIENTE: " );
    	    System.out.println( "------------------------------" ); 
    	    System.out.println( "opcion:             " + opcion  );
    	    System.out.println( "codigoDepartamento: " + codigoDepartamento ); 
    	    System.out.println( "codigoEmpresa:      " + codigoEmpresa      );
    	    System.out.println( "" );
    	    
		    //BeanValidacionDto objValidacion      = new BeanValidacionDto();
		    //boolean           estadoValidacion   = true;
		    //String            MENSAJE_VALIDACION = " * Ingresar un valor en: ";
		    
    	    //----------------------- DEPARTAMENTO -----------------------//
	    	List<Departamento> listaDepartamento = new ArrayList<Departamento>();
	    	
	    	Departamento departamento_01 = new Departamento();
	    	departamento_01.setId(     1 );
	    	departamento_01.setNombre( "LIMA" );
	    	
	    	Departamento departamento_02 = new Departamento();
	    	departamento_02.setId(     2 );
	    	departamento_02.setNombre( "AYACUCO" );
	    	
	    	Departamento departamento_03 = new Departamento();
	    	departamento_03.setId(     3 );
	    	departamento_03.setNombre( "CUZCO" );
	    	
	    	Departamento departamento_04 = new Departamento();
	    	departamento_04.setId(     4 );
	    	departamento_04.setNombre( "ICA" ); 
	    	
	    	//Agregando ...
	    	listaDepartamento.add( departamento_01 );
	    	listaDepartamento.add( departamento_02 );
	    	listaDepartamento.add( departamento_03 );
	    	listaDepartamento.add( departamento_04 );
		    //-------------------------------------------------------------//
	    	
	    	//Validacion ...
	    	if( opcion != null ){
	    		
	    	    //-------------------------- EMPRESA --------------------------//
		    	if( opcion.equalsIgnoreCase( "cargarEmpresa" )        || 
		    	    opcion.equalsIgnoreCase( "cargarServTransporte" ) || 
		    	    opcion.equalsIgnoreCase( "cargarListadoFiltrado" ) ){		    			    		
		    		
			    	listaEmpresa = new ArrayList<Empresa>();
			    	
			    	Empresa empresa_01 = new Empresa();
			    	empresa_01.setId( 1 );
			    	empresa_01.setRazonSocial( "CRUZ DEL SUR" );
			    	
			    	Empresa empresa_02 = new Empresa();
			    	empresa_02.setId( 2 );
			    	empresa_02.setRazonSocial( "OLTURSA" );
			    	
			    	Empresa empresa_03 = new Empresa();
			    	empresa_03.setId( 3 );
			    	empresa_03.setRazonSocial( "CIVA" );
			    	
			    	//Agregando ...
			    	listaEmpresa.add( empresa_01 );
			    	listaEmpresa.add( empresa_02 );
			    	listaEmpresa.add( empresa_03 );
		    	}
		    	//-------------------------------------------------------------//
		    	
	    	    //------------------------- SERVICIO --------------------------//
		    	if( opcion.equalsIgnoreCase( "cargarServTransporte" ) || opcion.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
			    	listaServicio = new ArrayList<Servicio>();
			    	
			    	Servicio servicio_01 = new Servicio();
			    	servicio_01.setId(     1 );
			    	servicio_01.setNombre( "PREMIUM" );
			    	
			    	Servicio servicio_02 = new Servicio();
			    	servicio_02.setId(     2 );
			    	servicio_02.setNombre( "EJECUTIVO" );
			    	
			    	Servicio servicio_03 = new Servicio();
			    	servicio_03.setId(     3 );
			    	servicio_03.setNombre( "ECONOMICO" );
			    	
			    	//Agregando ...
			    	listaServicio.add( servicio_01 );
			    	listaServicio.add( servicio_02 );
			    	listaServicio.add( servicio_03 );
		    	}
			    //--------------------------------------------------------------//
		    	
	    	    //------------------------- SALIDAS ----------------------------//
		    	if( opcion.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
		    		listaSalida = new ArrayList<Salida>();
		    		
		    		Calendario calendario_A01 = new Calendario();
		    		calendario_A01.setId( 1 );
		    		calendario_A01.setFechaHoraSalida(  new Date() );
		    		calendario_A01.setFechaHoraLlegada( new Date() );
		    	}
		    	//--------------------------------------------------------------//
	    	}
	    	
            request.setAttribute( "listaDepartamento",  listaDepartamento );         //estadoValidacion ...
            request.setAttribute( "listaEmpresa",       listaEmpresa  );             //estadoValidacion ...
            request.setAttribute( "listaServicio",      listaServicio );             //estadoValidacion ...
            
            request.setAttribute( "codigoDepartamento", codigoDepartamento );        //estadoValidacion ...        
            request.setAttribute( "codigoEmpresa",      codigoEmpresa );             //estadoValidacion ...   
            request.setAttribute( "tamanoLista",        listaDepartamento.size() );  //estadoValidacion ...
     	   
            this.contexto    = this.getServletContext();
            this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
            
            this.despachador.forward( request, response );                           //Redirecciona con los parametros seteados.	  
	    } 
	    catch( Exception e ){
			   e.printStackTrace();
		}	    
	 }  
}
