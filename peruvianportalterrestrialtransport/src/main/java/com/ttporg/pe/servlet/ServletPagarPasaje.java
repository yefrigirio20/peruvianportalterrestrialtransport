package com.ttporg.pe.servlet;

import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.dao.AgenciaDao;
import com.ttporg.pe.dao.AsientoDao;
import com.ttporg.pe.dao.CalendarioDao;
import com.ttporg.pe.dao.ClienteDao;
import com.ttporg.pe.dao.ClientePagoDao;
import com.ttporg.pe.dao.DepartamentoDao;
import com.ttporg.pe.dao.EmpresaDao;
import com.ttporg.pe.dao.PagoDao;
import com.ttporg.pe.dao.SalidaDao;
import com.ttporg.pe.dao.ServicioDao;
import com.ttporg.pe.dao.TransaccionDao;
import com.ttporg.pe.dao.VehiculoDao;
import com.ttporg.pe.dao.impl.AgenciaDaoImpl;
import com.ttporg.pe.dao.impl.AsientoDaoImpl;
import com.ttporg.pe.dao.impl.CalendarioDaoImpl;
import com.ttporg.pe.dao.impl.ClienteDaoImpl;
import com.ttporg.pe.dao.impl.ClientePagoDaoImpl;
import com.ttporg.pe.dao.impl.DepartamentoDaoImpl;
import com.ttporg.pe.dao.impl.EmpresaDaoImpl;
import com.ttporg.pe.dao.impl.PagoDaoImpl;
import com.ttporg.pe.dao.impl.SalidaDaoImpl;
import com.ttporg.pe.dao.impl.ServicioDaoImpl;
import com.ttporg.pe.dao.impl.TransaccionDaoImpl;
import com.ttporg.pe.dao.impl.VehiculoDaoImpl;
import com.ttporg.pe.dto.BeanValidacionDto;
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilGeneraBoletoViaje;
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
 **/
public class ServletPagarPasaje extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID   = 7462872182111077306L;

	private ServletContext    contexto           = null;
	private RequestDispatcher despachador        = null;
	
	//Singleton ...
	private UtilSingleton     utilSingleton      = null;
	
	//Service ...
	//private ServiceFactory    servicio         = null;
	
	//Daos [SPRING] ...
	private ClienteDao        clienteDAO         = null;
	private EmpresaDao        empresaDAO         = null;	
	private DepartamentoDao   departamentoDAO    = null;
	private AgenciaDao        agenciaDAO         = null;		
	private VehiculoDao       vehiculoDAO        = null;	
	private ServicioDao       servicioDAO        = null;
	private AsientoDao        asientoDAO         = null;
	private SalidaDao         salidaDAO          = null;
	private CalendarioDao     calendarioDAO      = null;
	private PagoDao           pagoDAO            = null;
	private ClientePagoDao    clientePagoDAO     = null;
	private TransaccionDao    transaccionDAO     = null;	
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = null;
	private BaseBean          beanBase           = null;
	
	private static String     REDIRECCIONAMIENTO = "/jsp/PagoPasaje.jsp";		
	
	{
	 //this.servicio      = new ServiceFactory();
		
	 this.clienteDAO      = new ClienteDaoImpl();
	 this.empresaDAO      = new EmpresaDaoImpl();	
	 this.departamentoDAO = new DepartamentoDaoImpl();
	 this.agenciaDAO      = new AgenciaDaoImpl();		
	 this.vehiculoDAO     = new VehiculoDaoImpl();	
	 this.servicioDAO     = new ServicioDaoImpl();
	 this.asientoDAO      = new AsientoDaoImpl();
	 this.salidaDAO       = new SalidaDaoImpl();
	 this.calendarioDAO   = new CalendarioDaoImpl();
	 this.pagoDAO         = new PagoDaoImpl();
	 this.clientePagoDAO  = new ClientePagoDaoImpl();
	 this.transaccionDAO  = new TransaccionDaoImpl();
 
	 this.utilCalendario  = new UtilCalendario(); 
	 this.beanBase        = new BaseBean();
	}
 
	/**
	 * init
	 * @param configuracion
	 **/
	public void init( ServletConfig configuracion ){
		this.imprimeLog( "********* DENTRO DE 'init( ServletConfig config )' **********" ); 
	    
		try{
			super.init( configuracion );
			
			String servletName = (String)configuracion.getServletName();			 
			this.imprimeLog( "ServletName: " + servletName );
		 
	        this.acceso_InitParam();
	        this.acceso_ContextParam(); 
		} 
	    catch( ServletException e ){
			   e.printStackTrace();
		}
	}

	/**
	 * acceso_InitParam
	 **/
	public void acceso_InitParam(){
		this.imprimeLog( "********** DENTRO DE 'acceso_InitParam' **********" );
		
		ServletConfig servletConfig = this.getServletConfig();		
		this.imprimeLog( "=====> ServletConfig: " + servletConfig );
	}
	
	/**
	 * acceso_ContextParam
	 **/
	public void acceso_ContextParam(){
		 this.imprimeLog( "********** DENTRO DE 'acceso_ContextParam' **********" );
		
		 //INICIALIZANDO 'DAOs'...
		 this.inicializaDAOs();	
	}	
	
	/**
	 * service
	 * @param request
	 * @param response
	 **/	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
		    this.imprimeLog( "********* DENTRO DE service [ServletPagoPasaje] **********" ); 
		    
		    BeanValidacionDto objValidacion      = new BeanValidacionDto();
		    boolean           estadoValidacion   = true;
		    String            MENSAJE_VALIDACION = " * Ingresar un valor en: ";
		    
		    try{
	    	    String tipoPago        = request.getParameter( "choTipoPago"        );
	    	    String numeroTarjeta   = request.getParameter( "txtNumeroTarjeta"   );
	    	    String fechaExpiracion = request.getParameter( "txtFechaExpiracion" );
	    	    String precio          = request.getParameter( "txtPrecio" );	    	    
	    	    
	    	    String estadoPopup     = request.getParameter( "estadoPopup" );	  
	    	    
	    	    HttpSession session = request.getSession( true );
	    	    
    	    	String idServicio            = (String)session.getValue( "idServicio" ); 
    	    	String idAsientoSeleccionado = (String)session.getValue( "idAsientoSeleccionado" ); 
	    	    
	    	    this.imprimeLog( "" );
	    	    this.imprimeLog( "DATOS INGRESADOS DEL CLIENTE: "       );
	    	    this.imprimeLog( "------------------------------"       ); 
	    	    this.imprimeLog( "Tipo Pago:        " + tipoPago        ); 
	    	    this.imprimeLog( "Numero Tarjeta:   " + numeroTarjeta   );
	    	    this.imprimeLog( "Fecha Expiracion: " + fechaExpiracion ); 
	    	    this.imprimeLog( "Precio:           " + precio ); 
	    	    this.imprimeLog( "" );
	    	    this.imprimeLog( "idServicio:            " + idServicio  ); 
	    	    this.imprimeLog( "idAsientoSeleccionado: " + idAsientoSeleccionado  ); 
	    	    this.imprimeLog( "estadoPopup:           " + estadoPopup ); 
	    	    this.imprimeLog( "" );
	    	    
	    	    if( (idAsientoSeleccionado != null) && (estadoPopup.equalsIgnoreCase( "TRUE" ) ) ){
 		    	     	    	    		    	    	
		    	    Pago pago = new Pago();		    	    
		    	    pago.setTipoPago(   tipoPago      );
		    	    pago.setNumTarjeta( numeroTarjeta );

		    	    if( (fechaExpiracion != null) && !(fechaExpiracion.equals( "" )) ){
		    	    	
		    	    	String[] arrayCadena = fechaExpiracion.split( "-" );  //Fecha STRING a DATE.
		    	    	
		    	    	String anio = arrayCadena[ 0 ];
		    	    	String mes  = arrayCadena[ 1 ];
		    	    	String dia  = arrayCadena[ 2 ];
		    	    	
		    	    	this.imprimeLog( "Anio: " + anio );
		    	    	this.imprimeLog( "Mes:  " + mes  );
		    	    	this.imprimeLog( "Dia:  " + dia  );
		    	    	
		    	    	Date fecha = this.utilCalendario.getFecha( Integer.parseInt( anio ), 
										    	    			   Integer.parseInt( mes  ), 
										    	    			   Integer.parseInt( dia  ) );		    	    	
		    	    	pago.setFechaExpiracion( fecha );
		    	    }
				    
		    	    //Se INGRESA el pago en la BD.
		    	    this.pagoDAO.ingresarPago( pago );
		    	    
		    	    session.setAttribute( "objPago", pago ); 
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
		    	    
		    	    this.imprimeLog( "Anio: " + anio );
		    	    this.imprimeLog( "Mes:  " + mes  );
		    	    this.imprimeLog( "Dia:  " + dia  );
		    	     
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
		    	    
		    	    this.imprimeLog( "Anio: " + anio );
		    	    this.imprimeLog( "Mes:  " + mes  );
		    	    this.imprimeLog( "Dia:  " + dia  );
		    	     
		    	    Date expiracion = this.utilCalendario.getFecha( Integer.parseInt( anio ), 
		    	    		                                        Integer.parseInt( mes  ), 
		    	    		                                        Integer.parseInt( dia  ) );
		    	    
		    	    this.imprimeLog( "Util Singleton: " + this.utilSingleton );

			    	Cliente objCliente = (Cliente)session.getValue( "objCliente" );
			    	
		            
		            //-------------- Generacion de Boleto. --------------//
		            this.generaBoleto( request );
		            //---------------------------------------------------//
	    	    }
	    	    	    	    
	            request.setAttribute( "estadoPopup",      estadoPopup      );  //estadoPopup ...
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
	
	 /**
	  * generaBoleto
	  * @param request
	  **/
	public void generaBoleto(  HttpServletRequest request ){
	    this.imprimeLog( "********* DENTRO DE [generaBoleto] **********" ); 
	    
    	HttpSession session = request.getSession( true );
    	
    	//OBTENIENDO DE SESION ...
		Cliente objCliente         = (Cliente)session.getValue( "objCliente" );  		    	
		Pago    objPago            = (Pago)session.getValue(    "objPago"    ); 
    	String  codigoDepartamento = (String)session.getValue(  "codigoDepartamento" ); 
    	String  codigoEmpresa      = (String)session.getValue(  "codigoEmpresa"  ); 							
    	String  codigoAgencia      = (String)session.getValue(  "codigoAgencia"  ); 
    	String  codigoServicio     = (String)session.getValue(  "codigoServicio" ); 	    	    		    	
    	String  codigoAsiento      = (String)session.getValue(  "idAsientoSeleccionado" ); 
    	String  codigoFila         = (String)session.getValue(  "idFila"    ); 
    	String  txtFila            = (String)session.getValue(  "txtFila"   );
    	    	  
    	this.imprimeLog( "" );
    	this.imprimeLog( "OBTENIENDO DATO DE MEMORIA");
    	this.imprimeLog( "-------------------------" );
    	this.imprimeLog( "objCliente:         " + objCliente     );
    	this.imprimeLog( "objPago:            " + objPago        );
    	this.imprimeLog( "codigoDepartamento: " + codigoDepartamento );
    	this.imprimeLog( "codigoEmpresa:      " + codigoEmpresa  );
    	this.imprimeLog( "codigoAgencia:      " + codigoAgencia  );
    	this.imprimeLog( "codigoServicio:     " + codigoServicio );
    	this.imprimeLog( "codigoAsiento:      " + codigoAsiento  );
    	this.imprimeLog( "codigoFila:         " + codigoFila     );
    	this.imprimeLog( "txtFila:            " + txtFila        );
    	this.imprimeLog( "" );
    	
    	UtilGeneraBoletoViaje utilGeneraBoleto = new UtilGeneraBoletoViaje( this.clienteDAO,    this.empresaDAO,  this.departamentoDAO, this.agenciaDAO,
    			                                                            this.vehiculoDAO,   this.servicioDAO, this.asientoDAO,      this.salidaDAO,
    			                                                            this.calendarioDAO, this.pagoDAO,     this.clientePagoDAO,  this.transaccionDAO );  
    	
    	utilGeneraBoleto.muestraBoletoViaje( objCliente, objPago, codigoDepartamento, codigoEmpresa, 
    			                             codigoAgencia, codigoServicio, codigoFila, txtFila, codigoAsiento );	
	} 
	 
	/**
	 * inicializaDAOs
	 **/
	public void inicializaDAOs(){
		
		//OBTENER [ServletContext] USANDO [STRUTs 2]: 'ServletActionContext.getServletContext()'.
		//OBTENER [ServletContext] USANDO [SERVLETs]: 'this.getServletContext()'.
		ServletContext servletContext = this.getServletContext();	
		this.imprimeLog( "=====> servletContext: " + servletContext );
				 
		WebApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext( servletContext );
		this.imprimeLog( "=====> contexto: " + contexto );
		
		this.imprimeLog( "****************** OBTENIENDO 'DAOS' [INICIO] ******************" );

		this.clienteDAO      = (ClienteDaoImpl)contexto.getBean(      "clienteDao"      ); 
		this.empresaDAO      = (EmpresaDaoImpl)contexto.getBean(      "empresaDao"      );
		this.departamentoDAO = (DepartamentoDaoImpl)contexto.getBean( "departamentoDao" );
		this.agenciaDAO      = (AgenciaDaoImpl)contexto.getBean(      "agenciaDao"      );	
		this.vehiculoDAO     = (VehiculoDaoImpl)contexto.getBean(     "vehiculoDao"     );
		this.servicioDAO     = (ServicioDaoImpl)contexto.getBean(     "servicioDao"     );
		this.asientoDAO      = (AsientoDaoImpl)contexto.getBean(      "asientoDao"      );
		this.salidaDAO       = (SalidaDaoImpl)contexto.getBean(       "salidaDao"       );
		this.calendarioDAO   = (CalendarioDaoImpl)contexto.getBean(   "calendarioDao"   );
		this.pagoDAO         = (PagoDaoImpl)contexto.getBean(         "pagoDao"         );
		this.clientePagoDAO  = (ClientePagoDaoImpl)contexto.getBean(  "clientePagoDao"  );
		this.transaccionDAO  = (TransaccionDaoImpl)contexto.getBean(  "transaccionDao"  );
		
		this.imprimeLog( "====> [clienteDAO]:      " + this.clienteDAO      );
		this.imprimeLog( "====> [empresaDAO]:      " + this.empresaDAO      );
		this.imprimeLog( "====> [departamentoDAO]: " + this.departamentoDAO );
		this.imprimeLog( "====> [agenciaDAO]:      " + this.agenciaDAO      );
		this.imprimeLog( "====> [vehiculoDAO]:     " + this.vehiculoDAO     );
		this.imprimeLog( "====> [servicioDAO]:     " + this.servicioDAO     );
		this.imprimeLog( "====> [asientoDAO]:      " + this.asientoDAO      );
		this.imprimeLog( "====> [salidaDAO]:       " + this.salidaDAO       );
		this.imprimeLog( "==+=> [calendarioDAO]:   " + this.calendarioDAO   );
		this.imprimeLog( "====> [pagoDAO]:         " + this.pagoDAO         );
		this.imprimeLog( "====> [clientePagoDAO]:  " + this.clientePagoDAO  );
		this.imprimeLog( "====> [transaccionDAO]:  " + this.transaccionDAO  );
		
		this.imprimeLog( "******************* OBTENIENDO 'DAOS' [FIN] *******************" );
	}
	
	/**
	 * imprimeLog
	 * @param mensaje
	 **/
	public void imprimeLog( String mensaje ){ 
		this.beanBase.imprimeLog( mensaje, this.getClass().toString() );
	}
	
}
