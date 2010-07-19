package com.ttporg.pe.servlet;

import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.dto.BeanValidacionDto;
import com.ttporg.pe.servicio.ServiceFactory;
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilSingleton;

/**
 * @author Cesar Ricardo.
 * @clase: ServletPagoPasaje.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServletPagoPasaje extends HttpServlet implements Servlet{
 
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
		    
		    BeanValidacionDto objValidacion      = new BeanValidacionDto();
		    boolean           estadoValidacion   = true;
		    String            MENSAJE_VALIDACION = " * Ingresar un valor en: ";
		    
		    try{
	    	    String tipoPago        = request.getParameter( "choTipoPago"        );
	    	    String numeroTarjeta   = request.getParameter( "txtNumeroTarjeta"   );
	    	    String fechaExpiracion = request.getParameter( "txtFechaExpiracion" );
	    	    String precio          = request.getParameter( "txtPrecio" );
	    	    
	    	    String idAsientoSelec  = request.getParameter( "idAsiento"          );
	    	     
	    	    System.out.println( "" );
	    	    System.out.println( "DATOS INGRESADOS DEL CLIENTE: "       );
	    	    System.out.println( "------------------------------"       ); 
	    	    System.out.println( "Tipo Pago:        " + tipoPago        ); 
	    	    System.out.println( "Numero Tarjeta:   " + numeroTarjeta   );
	    	    System.out.println( "Fecha Expiracion: " + fechaExpiracion ); 
	    	    System.out.println( "Precio:           " + precio ); 
	    	    System.out.println( "" );
	    	    System.out.println( "idAsientoSelec:   " + idAsientoSelec       ); 
	    	    
	    	    if( idAsientoSelec != null ){
	    	    	
		    	    //---------------- Guardar el 'SINGLETON'. ----------------//
		    	    this.utilSingleton = UtilSingleton.getInstancia();
		    	    this.utilSingleton.setEstadoActivacion( true );
		    	    
		    	    Asiento asiento = new Asiento();
		    	    asiento.setId( Integer.parseInt( idAsientoSelec ) );
		    	    
		    	    Pago pago = new Pago();
		    	    pago.setId( 1 );
		    	   // pago.setMontoPago(  Double.parseDouble( precio ) );
		    	    pago.setTipoPago(   tipoPago );
		    	    pago.setNumTarjeta( numeroTarjeta );
		    	    
		    	    //----------------------------------//
		    	    String[] arrayCadena = fechaExpiracion.split( "-" );  //Fecha STRING a DATE.
		    	    
		    	    String anio = arrayCadena[ 0 ];
		    	    String mes  = arrayCadena[ 1 ];
		    	    String dia  = arrayCadena[ 2 ];
		    	    
		    	    System.out.println( "Anio: " + anio );
		    	    System.out.println( "Mes:  " + mes  );
		    	    System.out.println( "Dia:  " + dia  );
		    	    
		    	    Date xxx = this.utilCalendario.getFecha( Integer.parseInt( anio ), 
		    	    		                                             Integer.parseInt( mes  ), 
		    	    		                                             Integer.parseInt( dia  ) );
		    	    //----------------------------------//
		    	    
		    	    pago.setFechaExpiracion( xxx );
		    	    
		    	    //Asiento.
		    	    this.utilSingleton.getObjetoSingleton().setAsiento( asiento );  
		    	    
		    	    //Pago.
		    	    this.utilSingleton.getObjetoSingleton().setPago( pago );
		    	    //------------------------------------------------------//
	    	    }	    	    
	    	    
	    	    //------------- VALIDACION 'JSP' -------------//
	    	    if( tipoPago == null || tipoPago.equals( "" ) ){
	    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Tipo Pago]" );
	    		    estadoValidacion = false;
	    	    }
	    	    
	    	    if( numeroTarjeta == null || numeroTarjeta.equals( "" ) ){
	    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Numero Tarjeta]" );
	    		    estadoValidacion = false;
	    	    }
	    	    
	    	    if( fechaExpiracion == null || fechaExpiracion.equals( "" ) ){
	    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Fecha Expiracion]" );
	    		    estadoValidacion = false;
	    	    }
	    	    else{
		    	    String[] arrayCadena = fechaExpiracion.split( "-" );  //Fecha STRING a DATE.
		    	    
		    	    String anio = arrayCadena[ 0 ];
		    	    String mes  = arrayCadena[ 1 ];
		    	    String dia  = arrayCadena[ 2 ];
		    	    
		    	    System.out.println( "Anio: " + anio );
		    	    System.out.println( "Mes:  " + mes  );
		    	    System.out.println( "Dia:  " + dia  );
		    	     
		    	    Date expiracion = this.utilCalendario.getFecha( Integer.parseInt( anio ), 
		    	    		                                        Integer.parseInt( mes  ), 
		    	    		                                        Integer.parseInt( dia  ) );		    	     
		    	    //Validando de la Tarjeta este en Fecha.
		    	    if( expiracion.after( new Date() ) ){
		    	    	//OK
		    	    }
		    	    else{ 
		    		     objValidacion.getMensajesNOK().add( "* La tarjeta de credito a caducado." );
		    		     estadoValidacion = false;
		    	    }
	    	    }	    	    
	    	    //---------------------------------------//
	    	    
	    	    //Validacion ...
	    	    if( estadoValidacion == true ){
	    	    	objValidacion.setMensajeOK( "Proceso Exitoso" ); 	    	    	
	    	    
		    	    //---------------------------- MEMORIA Y/O BD ----------------------------//
		    	    //this.servicio.ingresarCliente( objCliente );  //PERSISTENCIA.
		    	    
		    	    String[] arrayCadena = fechaExpiracion.split( "-" );  //Fecha STRING a DATE.
		    	    
		    	    String anio = arrayCadena[ 0 ];
		    	    String mes  = arrayCadena[ 1 ];
		    	    String dia  = arrayCadena[ 2 ];
		    	    
		    	    System.out.println( "Anio: " + anio );
		    	    System.out.println( "Mes:  " + mes  );
		    	    System.out.println( "Dia:  " + dia  );
		    	     
		    	    Date expiracion = this.utilCalendario.getFecha( Integer.parseInt( anio ), 
		    	    		                                        Integer.parseInt( mes  ), 
		    	    		                                        Integer.parseInt( dia  ) );
		    	    
		    	    //---------------- Obtener 'SINGLETON'. ----------------//
		    	    this.utilSingleton = UtilSingleton.getINSTANCIA_GUARDADA();
		    	    //------------------------------------------------------//
		    	    
		    	    System.out.println( "Util Singleton: " + this.utilSingleton );
		    	    
		    	    //Validacion ...
		    	    if( (this.utilSingleton != null) && (this.utilSingleton.isEstadoActivacion() == true) ){
		    	    	
			    	    Cliente objCliente = this.utilSingleton.getObjetoSingleton().getCliente();
			    	    
			    	    System.out.println( "Nombre Cliente que Pago:: " + objCliente.getNombres() );
			    	    
			    	   // Pago objPago = new Pago( 1, tipoPago, numeroTarjeta, 40, expiracion, objCliente );
			    	    
			    	   // System.out.println( "objPago: " + objPago );
		    	    	    	     
			    	    //---------------- Guardar el 'SINGLETON'. ----------------//
			    	    this.utilSingleton = UtilSingleton.getInstancia();
			    	    this.utilSingleton.setEstadoActivacion( true );
			    	    this.utilSingleton.getObjetoSingleton().setCliente( objCliente );
			    	  //  this.utilSingleton.getObjetoSingleton().setPago(    objPago    );
			    	  //-----------------------------------------------------------//
		    	    }		    	    
	    	    }
	    	    
	            request.setAttribute( "estadoValidacion", estadoValidacion );  //estadoValidacion ...
	            request.setAttribute( "objValidacion",    objValidacion    );  //Objeto Validacion ...
	            
	            this.contexto    = this.getServletContext();
	            this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
	           
	            this.despachador.forward( request, response );                 //Redirecciona con los parametros seteados.	           
		    }
		    catch( Exception e ){
				   e.printStackTrace();
			}
	 }    
	
}
