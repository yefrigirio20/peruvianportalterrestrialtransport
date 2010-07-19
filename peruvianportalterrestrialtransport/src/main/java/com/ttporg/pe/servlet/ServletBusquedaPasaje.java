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
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.Calendario;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.bean.Servicio;
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
	   
	    List<Empresa>  listaEmpresa  = null;
	    List<Agencia>  listaAgencia  = null;
	    List<Servicio> listaServicio = null;
	    List<Salida>   listaSalida   = null;
	    
	    try{
    	    String codigoDepartamento = request.getParameter( "choDepartamento" );
    	    String codigoEmpresa      = request.getParameter( "choEmpresa"      );
    	    String codigoAgencia      = request.getParameter( "choAgencia"      );
    	    String opcion             = request.getParameter( "opcion"          );
    	    String opcion2            = request.getParameter( "opcion2"         );
    	    String codigoSalida       = request.getParameter( "codigoSalida"    );
    	    
    	    String nomCiudadOrigen    = request.getParameter( "choCiudadOrigen"  );
    	    String nomCiudadDestina   = request.getParameter( "choCiudadDestino" );
    	        	    
    	    System.out.println( "" );
    	    System.out.println( "DATOS INGRESADOS DEL CLIENTE: " );
    	    System.out.println( "------------------------------" ); 
    	    System.out.println( "opcion:             " + opcion  );
    	    System.out.println( "codigoDepartamento: " + codigoDepartamento ); 
    	    System.out.println( "codigoEmpresa:      " + codigoEmpresa      );
    	    System.out.println( "codigoAgencia:      " + codigoAgencia      );
    	    System.out.println( "codigoSalida:       " + codigoSalida       );
    	    System.out.println( "nomCiudadOrigen:    " + nomCiudadOrigen    );
    	    System.out.println( "nomCiudadDestina:   " + nomCiudadDestina   );
    	    System.out.println( "" );
 		    
    	    //----------------------- DEPARTAMENTO -----------------------//
	    	List<Departamento> listaDepartamento = new ArrayList<Departamento>();	    	
	    	
	    	//-------------- Obtener 'BASE DE DATOS'. --------------//
	    	listaDepartamento = this.servicio.getDepartamentoDAO().obtenerListaDepartamentos();	    	
	    	System.out.println( "TAMANIO 'listaDepartamento': " + listaDepartamento.size() );
	    	//------------------------------------------------------//
	    	
	    	/*
	    	Departamento departamento_01 = new Departamento();
	    	departamento_01.setId(     1 );
	    	departamento_01.setNombre( "LIMA" );
	    	
	    	Departamento departamento_02 = new Departamento();
	    	departamento_02.setId(     2 );
	    	departamento_02.setNombre( "AYACUCHO" );
	    	
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
	    	*/
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
		    	
		    	//------------------------- AGENCIA------------------------//
		    	if( opcion.equalsIgnoreCase( "cargarAgencia" ) || opcion.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
		    		listaAgencia = new ArrayList<Agencia>();
		    		
		    		Agencia agencia_01 = new Agencia();
		    		agencia_01.setId(     1 );
		    		agencia_01.setNombre( "SAN ISIDRO" );
		    		
		    		Agencia agencia_02 = new Agencia();
		    		agencia_02.setId(     2 );
		    		agencia_02.setNombre( "SAN BORJA" );
		    		
			    	//Agregando ...
		    		listaAgencia.add( agencia_01 );
		    		listaAgencia.add( agencia_02 );
		    	}
		    	
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
		    		
		    		Salida salida_01 = new Salida();
		    		salida_01.setId( 1 );
		    		salida_01.setDepartamentoSalida(  nomCiudadOrigen  );
		    		salida_01.setDepartamentoDestino( nomCiudadDestina );
		    		
		    		Salida salida_02 = new Salida();
		    		salida_02.setId( 2 );
		    		salida_02.setDepartamentoSalida(  nomCiudadOrigen  );
		    		salida_02.setDepartamentoDestino( nomCiudadDestina );
		    		
		    		
		    		List<Calendario> listaCalendario = new ArrayList<Calendario>();
		    		
		    		Calendario calendario_A01 = new Calendario();
		    		calendario_A01.setId( 1 );
		    		calendario_A01.setFechaHoraSalida(  new Date() );
		    		calendario_A01.setFechaHoraLlegada( this.utilCalendario.getFechaIncrementaEnHoras( new Date(), 4 ) );
		    		//calendario_A01.setDuracion( this.utilCalendario.getHorasEntreDosFechas( calendario_A01.getFechaHoraSalida(), calendario_A01.getFechaHoraLlegada() ) );   
		    	
		    		Calendario calendario_A02 = new Calendario();
		    		calendario_A02.setId( 2 );
		    		calendario_A02.setFechaHoraSalida(  new Date() );
		    		calendario_A02.setFechaHoraLlegada( this.utilCalendario.getFechaIncrementaEnHoras( new Date(), 8 ) );
		    		//calendario_A02.setDuracion( this.utilCalendario.getHorasEntreDosFechas( calendario_A02.getFechaHoraSalida(), calendario_A02.getFechaHoraLlegada() ) );   
		    		
		    		//Agregar Calendarios a Salida ...
		    		listaCalendario.add( calendario_A01 );
		    		listaCalendario.add( calendario_A02 );
		    		
		    		//salida_01.setListaCalendarioSalidas( listaCalendario );
		    		
		    		//salida_02.setListaCalendarioSalidas( listaCalendario );
		    		
		    		
		    		//Agregando a Lista de Salidas.
		    		listaSalida.add( salida_01 );
		    		listaSalida.add( salida_02 );
		    		
		    		/*
		            for( int i=0; i<listaSalida.size(); i++ ){
						 Salida xxx = listaSalida.get( i );
						 
					     System.out.println( "ID:       " + xxx.getId() );
					     System.out.println( "SALIDA:   " + xxx.getDepartamentoSalida()  );
					     System.out.println( "DESTINO:  " + xxx.getDepartamentoDestino() );
					     
					     for( int j=0; j<xxx.getListaCalendarioSalidas().size(); j++ ){
					    	  Calendario calendario = (Calendario)xxx.getListaCalendarioSalidas().get( j );
					    	  
					    	  System.out.println( "LLEGADA:  " + calendario.getFechaHoraLlegada() );
					    	  System.out.println( "SALIDA:   " + calendario.getFechaHoraSalida()  );
					    	  System.out.println( "DURACION: " + calendario.getDuracion() );
					     }
		            }
		            */
		    		
		            System.out.println( "SI ENTRO ...!!!" );
		            
		            if( (opcion2 != null) && (opcion2.equals( "cargarListadoCalendario" ) ) ){		            	
		            	request.setAttribute( "listaCalendario", listaCalendario );         //estadoValidacion ...
		            }		            
		    	}
		    	//--------------------------------------------------------------//
	    	}
	    	
	    	request.setAttribute( "listaSalida",        listaSalida   );             //estadoValidacion ...
            request.setAttribute( "listaDepartamento",  listaDepartamento );         //estadoValidacion ...
            request.setAttribute( "listaEmpresa",       listaEmpresa  );             //estadoValidacion ...
            request.setAttribute( "listaAgencia",       listaAgencia  );             //estadoValidacion ...            
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
