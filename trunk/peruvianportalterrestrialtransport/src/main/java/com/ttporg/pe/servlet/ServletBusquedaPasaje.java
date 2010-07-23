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
import javax.servlet.http.HttpSession;

import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.dto.DetallePasajeDTO;
import com.ttporg.pe.servicio.ServiceFactory;
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
	private ServiceFactory    servicio           = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = null;
	
	private String            REDIRECCIONAMIENTO = "/jsp/BusquedaPasaje.jsp";		
		
	{
	 this.servicio       = new ServiceFactory();
	 this.utilCalendario = new UtilCalendario();
	}
	
	/**
	 * service
	 * @param request
	 * @param response
	 **/	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
	    System.out.println( "********* DENTRO DE service **********" ); 
	   
	    List<Departamento> listaDepartamento = null;
	    List<Empresa>      listaEmpresa      = null;
	    List<Agencia>      listaAgencia      = null;
	    List<Servicio>     listaServicio     = null;
	    
	    List<DetallePasajeDTO>  listaDetallePasajeDTO  = null;
	    Departamento            objDepartamento   = null;
	    	
	    try{
    	    String codigoDepartamento = request.getParameter( "choDepartamento"   );
    	    String codigoEmpresa      = request.getParameter( "choEmpresa"        );
    	    String codigoAgencia      = request.getParameter( "choAgencia"        );
    	    String codigoServicio     = request.getParameter( "choServTransporte" );  
    	    
    	    String idCiudadOrigen     = request.getParameter( "choCiudadOrigen"   );
    	    String idCiudadDestina    = request.getParameter( "choCiudadDestino"  );
    	    
    	    String fechaViaje         = request.getParameter( "fechaViaje"        );
    	    
    	    String opcionProceso      = request.getParameter( "opcionProceso"     );
    	    String opcionLista        = request.getParameter( "opcionLista"       );
    	    
    	    String codigoSalida       = request.getParameter( "codigoSalida"      );	  
    	    
    	    String nomCiudadOrigen    = "";
    	    String nomCiudadDestina   = "";
    	    
    	    System.out.println( "" );
    	    System.out.println( "DATOS INGRESADOS DEL CLIENTE: " );
    	    System.out.println( "------------------------------" ); 
    	    System.out.println( "opcionProceso:      " + opcionProceso      );
    	    System.out.println( "opcionLista:        " + opcionLista        );
    	    System.out.println( "" );
    	    System.out.println( "codigoDepartamento: " + codigoDepartamento ); 
    	    System.out.println( "codigoEmpresa:      " + codigoEmpresa      );
    	    System.out.println( "codigoAgencia:      " + codigoAgencia      );
    	    System.out.println( "codigoServicio:     " + codigoServicio     );    	    
    	    
	    	HttpSession session = request.getSession( true );
	    	
	    	//SETEANDO EN SESION ...--------------------------
	    	if( codigoDepartamento != null ){	    		
	    		session.setAttribute( "codigoDepartamento", codigoDepartamento ); 
	    	}
	    	
	    	if( codigoEmpresa != null ){	 	    		
	    		session.setAttribute( "codigoEmpresa",  codigoEmpresa ); 
	    	}
	    	
	    	if( codigoAgencia != null ){	 	    		
	    		session.setAttribute( "codigoAgencia",  codigoAgencia ); 
	    	}
	    	
	    	if( codigoServicio != null ){	 	    		
	    		session.setAttribute( "codigoServicio",  codigoServicio ); 
	    	}
	    	//-------------------------------------------------
    	        	    
    	    //----------------------- DEPARTAMENTO -----------------------//
	    	listaDepartamento = new ArrayList<Departamento>();	
	    	listaDepartamento = this.servicio.getDepartamentoDAO().obtenerListaDepartamentos();	
	    	
	    	//-------------- Obtener 'BASE DE DATOS'. --------------//
	    	if( idCiudadOrigen != null ){	    		
	    		objDepartamento  = this.servicio.getDepartamentoDAO().obtenerObjetoDepartamento_x_codigo( Integer.parseInt( idCiudadOrigen ) );  
	    		nomCiudadOrigen  = objDepartamento.getNombre();
	    	}
	    	
	    	if( idCiudadDestina != null ){	    		
	    		objDepartamento  = this.servicio.getDepartamentoDAO().obtenerObjetoDepartamento_x_codigo( Integer.parseInt( idCiudadDestina ) );  
	    		nomCiudadDestina = objDepartamento.getNombre();
	    	}
	    	
	    	System.out.println( "nomCiudadOrigen:    " + nomCiudadOrigen    );
	    	System.out.println( "nomCiudadDestina:   " + nomCiudadDestina   );
    	    System.out.println( "fechaViaje:         " + fechaViaje         );    	    
    	    System.out.println( "" );
    	    
	    	System.out.println( "TAMANIO 'listaDepartamento': " + listaDepartamento.size() );
	    	//------------------------------------------------------//

		    //-------------------------------------------------------------//
	    	
	    	//Validacion ...
	    	if( opcionProceso != null ){
	    		
	    	    //-------------------------- EMPRESA --------------------------//
		    	if( opcionProceso.equalsIgnoreCase( "cargarEmpresa" )        || 
		    		opcionProceso.equalsIgnoreCase( "cargarAgencia" )        || 		    			
		    	    opcionProceso.equalsIgnoreCase( "cargarServTransporte" ) || 
		    	    opcionProceso.equalsIgnoreCase( "cargarListadoFiltrado" ) ){		    			    		
		    		
			    	listaEmpresa = new ArrayList<Empresa>();
			    	
			    	listaEmpresa = this.servicio.getEmpresaDAO().obtenerListaEmpresas_x_departamento( Integer.parseInt( codigoDepartamento ) ); //FILTRAR ...
		    	}
		    	//-------------------------------------------------------------//
		    	
		    	//------------------------- AGENCIA------------------------//
		    	if( opcionProceso.equalsIgnoreCase( "cargarAgencia" )        || 
		    		opcionProceso.equalsIgnoreCase( "cargarServTransporte" ) ||
		    	    opcionProceso.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
		    		
		    		listaAgencia = new ArrayList<Agencia>();
		    		
		    		listaAgencia = this.servicio.getAgenciaDAO().obtenerListaAgencias_x_empresa( Integer.parseInt( codigoEmpresa ) ); //FILTRAR ...
		    		
		    		System.out.println( "listaAgencia: " + listaAgencia.size() );
		    		System.out.println( "listaAgencia[0]: " + listaAgencia.get( 0 ).getId() );
		    		System.out.println( "listaAgencia[1]: " + listaAgencia.get( 1 ).getId() );
		    	}
		    	
	    	    //------------------------- SERVICIO --------------------------//
		    	if( opcionProceso.equalsIgnoreCase( "cargarServTransporte" ) || 
		    		opcionProceso.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
		    		
			    	listaServicio = new ArrayList<Servicio>();			    	
		    		
			    	listaServicio = this.servicio.getServicioDAO().obtenerListaServicios_x_agencia( Integer.parseInt( codigoAgencia ) ); //FILTRAR ...
		    	}
			    //--------------------------------------------------------------//
		    	
	    	    //------------------------- SALIDAS ----------------------------//
		    	if( opcionProceso.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
		    		listaDetallePasajeDTO = new ArrayList<DetallePasajeDTO>();	    		
		    		
		    		listaDetallePasajeDTO = this.servicio.getSalidaDAO().obtenerListaDetallePasajeDTO( Integer.parseInt( codigoEmpresa  ), 
																			    				       Integer.parseInt( codigoAgencia  ), 
																			    					   Integer.parseInt( codigoServicio ), 
		    				                                                                           nomCiudadOrigen,  
		    				                                                                           nomCiudadDestina, 
		    				                                                                           new Date() );  //FILTRAR ...
		    		
		    		//System.out.println( "TAMANIO [listaDetallePasajeDTO]: " + listaDetallePasajeDTO.size()  );		    		
		            System.out.println( "SI ENTRO ...!!!" );            
		    	}
		    	//--------------------------------------------------------------//
	    	}
	    	
	    	request.setAttribute( "codigoDepartamento", codigoDepartamento );        //estadoValidacion ... (PARA QUE SE QUEDE SELECCIONADO EN EL COMBO).       
	    	request.setAttribute( "codigoEmpresa",      codigoEmpresa );             //estadoValidacion ... (PARA QUE SE QUEDE SELECCIONADO EN EL COMBO).     
	    	request.setAttribute( "codigoAgencia",      codigoAgencia );             //estadoValidacion ... (PARA QUE SE QUEDE SELECCIONADO EN EL COMBO).  
	    	
            request.setAttribute( "listaDepartamento",  listaDepartamento );         //estadoValidacion ...
            request.setAttribute( "listaEmpresa",       listaEmpresa  );             //estadoValidacion ...
            request.setAttribute( "listaAgencia",       listaAgencia  );             //estadoValidacion ...            
            request.setAttribute( "listaServicio",      listaServicio );             //estadoValidacion ...
            
            request.setAttribute( "listaDetallePasajeDTO", listaDetallePasajeDTO );  //estadoValidacion ...  (LISTADO).	             
             
            this.contexto    = this.getServletContext();
            this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
            
            this.despachador.forward( request, response );                           //Redirecciona con los parametros seteados.	  
	    } 
	    catch( Exception e ){
			   e.printStackTrace();
		}	    
	 }  
}
