package com.ttporg.pe.servlet;

import java.util.ArrayList;
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
import com.ttporg.pe.bean.BaseBean;
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
import com.ttporg.pe.dto.DetalleAsientoDTO;

/**
 * @author Cesar Ricardo.
 * @clase: ServletPopupBus.java  sd
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class ServletPopupBus extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID = 918161070629297916L;

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
	
	private static String     REDIRECCIONAMIENTO = "/jsp/PopupBus.jsp";
	
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
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
		this.imprimeLog( "********* DENTRO DE service **********" ); 
        
	    List<DetalleAsientoDTO> listaDetalleAsientoDTO = null;
	    
	    HttpSession session = request.getSession( true );
	    
	    try{
	    	String idServicio            = request.getParameter( "idServicio" );	    	
	    	String idFila                = request.getParameter( "idFila"     );	
	    	String idAsientoSeleccionado = request.getParameter( "idAsiento"  );
	    	
	    	this.imprimeLog( "idServicio: " + idServicio );	    	
	    	this.imprimeLog( "idFila:     " + idFila     );
	    	this.imprimeLog( "idAsiento:  " + idAsientoSeleccionado );
	    	
	    	//-------------- Obtener 'BASE DE DATOS'. --------------//
	    	listaDetalleAsientoDTO = new ArrayList<DetalleAsientoDTO>();
	    	
	    	listaDetalleAsientoDTO = this.salidaDAO.obtenerListaDetalleAsientoDTO( Integer.parseInt( idServicio ) );  
	    	//------------------------------------------------------//
	    	
	    	//SETEANDO EN SESION ...--------------------------
	    	if( (idFila != null) && (idAsientoSeleccionado != null) ){	  
	    		
	    		String[] arraSting = idFila.split( "-" );
	    		String filaId  = arraSting[ 0 ];
	    		String filaTxt = arraSting[ 1 ];
	    		
	    		session.setAttribute( "idFila",                filaId     ); 
	    		session.setAttribute( "txtFila",               filaTxt    ); 
	    		session.setAttribute( "idServicio",            idServicio ); 
	    		session.setAttribute( "idAsientoSeleccionado", idAsientoSeleccionado ); 
	    	}	    	
	    	
	    	//Validando ...
	    	if( idAsientoSeleccionado != null ){
		    	for( int i=0; i<listaDetalleAsientoDTO.size(); i++ ){
 		
		    		 DetalleAsientoDTO asiento = listaDetalleAsientoDTO.get( i );
			    	 
			    	 if( ( (asiento.getColumnaAsientoA() ).equals( idAsientoSeleccionado )) && 
			    	     (asiento.getEstado_A().equalsIgnoreCase( "FALSE" )) ){
			    		
			    		 asiento.setEstado_A( "TRUE" );
			    		 
				    	  this.imprimeLog( "# FILA:                " + (asiento.getIdAsiento() ) );
			    		  this.imprimeLog( "idAsientoSeleccionado: " + idAsientoSeleccionado );
			    		  this.imprimeLog( "Id ColumnaA: " + asiento.getColumnaAsientoA() + " " +
								    	   "Id ColumnaB: " + asiento.getColumnaAsientoB() + " " +
								    	   "Id ColumnaC: " + asiento.getColumnaAsientoC() + " " +
								    	   "Id ColumnaD: " + asiento.getColumnaAsientoD()  );
			    		  this.imprimeLog( "EstadoA:     " + asiento.getEstado_A() + " " +
								    	   "EstadoB:     " + asiento.getEstado_B() + " " +
								    	   "EstadoC:     " + asiento.getEstado_C() + " " +
								    	   "EstadoD:     " + asiento.getEstado_D()  );
			    		  this.imprimeLog( "" ); 
					      break;
			    	 }			    	
			    	 else if( ( (asiento.getColumnaAsientoB() ).equals( idAsientoSeleccionado )) && 
				    	      (asiento.getEstado_B().equalsIgnoreCase( "FALSE" )) ){
			    		      
			    		      asiento.setEstado_B( "TRUE" ); 
			    		      
					    	  this.imprimeLog( "# FILA:                " + (asiento.getIdAsiento() ) );
				    		  this.imprimeLog( "idAsientoSeleccionado: " + idAsientoSeleccionado );
				    		  this.imprimeLog( "Id ColumnaA: " + asiento.getColumnaAsientoA() + " " +
									    	   "Id ColumnaB: " + asiento.getColumnaAsientoB() + " " +
									    	   "Id ColumnaC: " + asiento.getColumnaAsientoC() + " " +
									    	   "Id ColumnaD: " + asiento.getColumnaAsientoD()  );
				    		  this.imprimeLog( "EstadoA:     " + asiento.getEstado_A() + " " +
									    	   "EstadoB:     " + asiento.getEstado_B() + " " +
									    	   "EstadoC:     " + asiento.getEstado_C() + " " +
									    	   "EstadoD:     " + asiento.getEstado_D()  );
				    		  this.imprimeLog( "" ); 
						      break;
			    	 }
			    	 else if( ( (asiento.getColumnaAsientoC() ).equals( idAsientoSeleccionado )) &&
				    	      (asiento.getEstado_C().equalsIgnoreCase( "FALSE" )) ){		    		 
		    		           
			    		      asiento.setEstado_C( "TRUE" ); 
			    		      
					    	  this.imprimeLog( "# FILA:                " + (asiento.getIdAsiento() ) );
				    		  this.imprimeLog( "idAsientoSeleccionado: " + idAsientoSeleccionado );
				    		  this.imprimeLog( "Id ColumnaA: " + asiento.getColumnaAsientoA() + " " +
									    	   "Id ColumnaB: " + asiento.getColumnaAsientoB() + " " +
									    	   "Id ColumnaC: " + asiento.getColumnaAsientoC() + " " +
									    	   "Id ColumnaD: " + asiento.getColumnaAsientoD()  );
				    		  this.imprimeLog( "EstadoA:     " + asiento.getEstado_A() + " " +
									    	   "EstadoB:     " + asiento.getEstado_B() + " " +
									    	   "EstadoC:     " + asiento.getEstado_C() + " " +
									    	   "EstadoD:     " + asiento.getEstado_D()  );
				    		  this.imprimeLog( "" ); 
						      break;
			    	 }
			    	 else if( ( (asiento.getColumnaAsientoD() ).equals( idAsientoSeleccionado )) &&
				    	      (asiento.getEstado_D().equalsIgnoreCase( "FALSE" )) ){
			    		      
			    		      asiento.setEstado_D( "TRUE" ); 
			    		      
					    	  this.imprimeLog( "# FILA:                " + (asiento.getIdAsiento() ) );
				    		  this.imprimeLog( "idAsientoSeleccionado: " + idAsientoSeleccionado );
				    		  this.imprimeLog( "Id ColumnaA: " + asiento.getColumnaAsientoA() + " " +
									    	   "Id ColumnaB: " + asiento.getColumnaAsientoB() + " " +
									    	   "Id ColumnaC: " + asiento.getColumnaAsientoC() + " " +
									    	   "Id ColumnaD: " + asiento.getColumnaAsientoD()  );
				    		  this.imprimeLog( "EstadoA:     " + asiento.getEstado_A() + " " +
									    	   "EstadoB:     " + asiento.getEstado_B() + " " +
									    	   "EstadoC:     " + asiento.getEstado_C() + " " +
									    	   "EstadoD:     " + asiento.getEstado_D()  );
				    		  this.imprimeLog( "" ); 
						      break;
			    	 }
			    }				    
	    	}
  	    	 	    	
	    	request.setAttribute( "listaDetalleAsientoDTO", listaDetalleAsientoDTO );  //estadoValidacion ...
	    	
	        this.contexto    = this.getServletContext();
	        this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
	        
	        this.despachador.forward( request, response );                             //Redirecciona con los parametros seteados.	  
	    } 
	    catch( Exception e ){
			   e.printStackTrace();
		}	    
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
		this.imprimeLog( "====> [calendarioDAO]:   " + this.calendarioDAO   );
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

