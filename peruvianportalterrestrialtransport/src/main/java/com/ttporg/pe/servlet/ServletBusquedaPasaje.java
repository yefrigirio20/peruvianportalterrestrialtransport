package com.ttporg.pe.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Servicio;
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
import com.ttporg.pe.dto.DetallePasajeDTO;

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
 
	List<DetallePasajeDTO> listaXXX = new ArrayList<DetallePasajeDTO>();
	
	private ServletContext    contexto           = null;
	private RequestDispatcher despachador        = null;
	
	//Singleton ...
	//private UtilSingleton     utilSingleton    = null;
		
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
	private BaseBean          beanBase           = null;
	
	private static String     REDIRECCIONAMIENTO = "/jsp/BusquedaPasaje.jsp";		
		
	{
	 //this.servicio     = new ServiceFactory();
		
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
		this.imprimeLog( "********* DENTRO DE service **********" ); 
	   
	    List<Departamento> listaDepartamento = null;
	    List<Empresa>      listaEmpresa      = null;
	    List<Agencia>      listaAgencia      = null;
	    List<Servicio>     listaServicio     = null;
	    
	    List<DetallePasajeDTO>  listaDetallePasajeDTO = null;
	    Departamento            objDepartamento       = null;
	    	
	    BeanValidacionDto objValidacion      = new BeanValidacionDto();	  
	    
	    String            MSJ_VALIDACION_INS = " * Ingresar un valor en: ";
	    String            MSJ_VALIDACION_CST = " * Selecciona un valor en: ";
	    
	    boolean           estadoValidacion   = true;
	    
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
     	    
    	    String estado             = request.getParameter( "estado"            );
    	    
    	    String nomCiudadOrigen    = "";
    	    String nomCiudadDestina   = "";
    	    
    	    this.imprimeLog( "" );
    	    this.imprimeLog( "DATOS INGRESADOS DEL CLIENTE: " );
    	    this.imprimeLog( "------------------------------" ); 
    	    this.imprimeLog( "opcionProceso:      " + opcionProceso      );
    	    this.imprimeLog( "opcionLista:        " + opcionLista        );
    	    this.imprimeLog( "" );
    	    this.imprimeLog( "codigoDepartamento: " + codigoDepartamento ); 
    	    this.imprimeLog( "codigoEmpresa:      " + codigoEmpresa      );
    	    this.imprimeLog( "codigoAgencia:      " + codigoAgencia      );
    	    this.imprimeLog( "codigoServicio:     " + codigoServicio     );
    	    this.imprimeLog( "estado:             " + estado             );
    	    this.imprimeLog( "" );
    	    
	    	HttpSession session = request.getSession( true );
	    	
	    	//SETEANDO EN SESION ...--------------------------
	    	if( (codigoDepartamento != null) && !(codigoDepartamento.equals( "0" )) ){	    		
	    		session.setAttribute( "codigoDepartamento", codigoDepartamento ); 	
	    		
	    		objValidacion.setMensajeOK( "TRUE" );
	    	}
	    	else{
	    		objValidacion.getMensajesNOK().add( MSJ_VALIDACION_CST + "[Departamento]" );
	    		estadoValidacion = false;	
	    		objValidacion.setMensajeOK( "FALSE" );
	    	}
	    	
	    	if( (codigoEmpresa != null) && !(codigoEmpresa.equals( "0" )) ){	 	    		
	    		session.setAttribute( "codigoEmpresa",  codigoEmpresa ); 
	    		
	    		objValidacion.setMensajeOK( "TRUE" );
	    	}
	    	else{
    		    objValidacion.getMensajesNOK().add( MSJ_VALIDACION_CST + "[Empresa]" );
	    		estadoValidacion = false;	
	    		objValidacion.setMensajeOK( "FALSE" );
	    	}
	    	
	    	if( (codigoAgencia != null) && !(codigoAgencia.equals( "0" )) ){	 	    		
	    		session.setAttribute( "codigoAgencia",  codigoAgencia ); 
	    		
	    		objValidacion.setMensajeOK( "TRUE" );
	    	}
	    	else{
    		    objValidacion.getMensajesNOK().add( MSJ_VALIDACION_CST + "[Agencia]" );
	    		estadoValidacion = false;	
	    		objValidacion.setMensajeOK( "FALSE" );
	    	}
	    	
	    	if( (codigoServicio != null) && !(codigoServicio.equals( "0" )) ){	 	    		
	    		session.setAttribute( "codigoServicio",  codigoServicio ); 
	    		
	    		objValidacion.setMensajeOK( "TRUE" );
	    	}
	    	else{
    		    objValidacion.getMensajesNOK().add( MSJ_VALIDACION_CST + "[Servicio]" );
	    		estadoValidacion = false;	
	    		objValidacion.setMensajeOK( "FALSE" );
	    	}
	    	
	    	if( (fechaViaje != null) && !(fechaViaje.equals( "" )) ){	 	    		
	    		session.setAttribute( "fechaViaje",  fechaViaje );   
	    		
	    		objValidacion.setMensajeOK( "TRUE" );
	    	}
	    	else{
    		    objValidacion.getMensajesNOK().add( MSJ_VALIDACION_INS + "[Fecha]" );
	    		estadoValidacion = false;	
	    		objValidacion.setMensajeOK( "FALSE" );
	    	}
	    	
	    	//-------------------------------------------------
    	        	    
    	    //----------------------- DEPARTAMENTO -----------------------//
	    	listaDepartamento = new ArrayList<Departamento>();	
	    	
	    	listaDepartamento = this.departamentoDAO.obtenerListaDepartamentos();
	    	
	    	//-------------- Obtener 'BASE DE DATOS'. --------------//
	    	if( (idCiudadOrigen != null) && !(idCiudadOrigen.equals( "0" )) ){	    		
	    		objDepartamento  = this.departamentoDAO.obtenerObjetoDepartamento_x_codigo( Integer.parseInt( idCiudadOrigen ) );  
	    		nomCiudadOrigen  = objDepartamento.getNombre();
	    	}
	    	
	    	if( (idCiudadDestina != null) && !(idCiudadDestina.equals( "0" )) ){	    		
	    		objDepartamento  = this.departamentoDAO.obtenerObjetoDepartamento_x_codigo( Integer.parseInt( idCiudadDestina ) );  
	    		nomCiudadDestina = objDepartamento.getNombre();
	    	}
	    	
	    	this.imprimeLog( "nomCiudadOrigen:    " + nomCiudadOrigen    );
	    	this.imprimeLog( "nomCiudadDestina:   " + nomCiudadDestina   );
    	    this.imprimeLog( "fechaViaje:         " + fechaViaje         );    	    
    	    this.imprimeLog( "" );
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
					    	
					    	listaEmpresa = this.empresaDAO.obtenerListaEmpresas_x_departamento( Integer.parseInt( codigoDepartamento ) ); //FILTRAR ...
				    	}
				    	//-------------------------------------------------------------//
				    	
				    	//------------------------- AGENCIA------------------------//
				    	if( opcionProceso.equalsIgnoreCase( "cargarAgencia" )        || 
				    		opcionProceso.equalsIgnoreCase( "cargarServTransporte" ) ||
				    	    opcionProceso.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
				    		
				    		
				    		if( codigoEmpresa != null ){		    			
				    			listaAgencia = new ArrayList<Agencia>();
				    			listaAgencia = this.agenciaDAO.obtenerListaAgencias_x_empresa( Integer.parseInt( codigoEmpresa ) ); //FILTRAR ...
				    		}		    		
				    	}
				    	
			    	    //------------------------- SERVICIO --------------------------//
				    	if( opcionProceso.equalsIgnoreCase( "cargarServTransporte" ) || 
				    		opcionProceso.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
				    		
				    		if( codigoEmpresa != null ){		    			
				    			listaServicio = new ArrayList<Servicio>();			    			    		
				    			listaServicio = this.servicioDAO.obtenerListaServicios_x_agencia( Integer.parseInt( codigoAgencia ) ); //FILTRAR ...
				    		}
				    	}
					    //--------------------------------------------------------------//
				    	
			    		
	    	    //Validacion ...
	    	    if( estadoValidacion == true ){
	    	    	objValidacion.setMensajeOK( "Proceso Exitoso" ); 
	    	    	
			    	    //------------------------- SALIDAS ----------------------------//
				    	if( opcionProceso.equalsIgnoreCase( "cargarListadoFiltrado" ) ){
				    		listaDetallePasajeDTO = new ArrayList<DetallePasajeDTO>();	    		
				    		
				    		if( (codigoEmpresa != null) && (codigoAgencia != null) && (codigoServicio != null) ){
				    			
				    			listaDetallePasajeDTO = this.salidaDAO.obtenerListaDetallePasajeDTO( Integer.parseInt( codigoEmpresa  ), 
																			    					 Integer.parseInt( codigoAgencia  ), 
																			    					 Integer.parseInt( codigoServicio ), 
																			    					 nomCiudadOrigen,  
																			    					 nomCiudadDestina, 
																			    					 new Date() );  //FILTRAR ...    		
				    			listaXXX = listaDetallePasajeDTO;
				    		}        
				    	}
				    	//--------------------------------------------------------------//
	    	    }
	    	}
			    	
	    	this.imprimeLog( "totalErrores: " + objValidacion.getMensajesNOK().size() );
	    		    	
            request.setAttribute( "estadoValidacion", estadoValidacion );  //estadoValidacion ...
            request.setAttribute( "objValidacion",    objValidacion    );  //Objeto Validacion ...            
            request.setAttribute( "totalErrores",     objValidacion.getMensajesNOK().size() );  //Objeto Validacion ...
            request.setAttribute( "estado",           estado );            //Objeto Validacion ...
            
	    	
	    	request.setAttribute( "codigoDepartamento", codigoDepartamento );        //estadoValidacion ... (PARA QUE SE QUEDE SELECCIONADO EN EL COMBO).       
	    	request.setAttribute( "codigoEmpresa",      codigoEmpresa );             //estadoValidacion ... (PARA QUE SE QUEDE SELECCIONADO EN EL COMBO).     
	    	request.setAttribute( "codigoAgencia",      codigoAgencia );             //estadoValidacion ... (PARA QUE SE QUEDE SELECCIONADO EN EL COMBO).  
	    	
            request.setAttribute( "listaDepartamento",  listaDepartamento );         //estadoValidacion ...
            request.setAttribute( "listaDepartaOrigen", listaDepartamento );         //estadoValidacion ...
            request.setAttribute( "listaDepartaDestino",listaDepartamento );         //estadoValidacion ...
            
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
	 
		/**
		 * getListaTotalAutos
		 * @return List<Car>
		 */
		public List<DetallePasajeDTO> getListaXXX(){ 
			return listaXXX;
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
