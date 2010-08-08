package com.ttporg.pe.servlet;
 
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ajaxtags.servlets.BaseAjaxServlet;
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
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilEmail;
import com.ttporg.pe.util.UtilEncriptacion;

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
	private UtilEmail         utilEmail          = null; 
	private UtilEncriptacion  utilEncriptacion   = null;
	private BaseBean          beanBase           = null;
	
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
	 * getXmlContent
	 * @param request
	 * @param response
	 **/
	public String getXmlContent( HttpServletRequest request, HttpServletResponse response ){			   
		   System.out.println( "**** DENTRO DE 'ServletAjax', (extends BaseAjaxServlet) **** " );	
		   
		   String mensajeRespuesta = new String( "" ); 

	       try{		
	    	   String objValidacion = "Ricardo Guerra"; //request.getParameter( "PERSONA" );
	    	   
	    	   System.out.println("EL PARAMETRO LLEGADO ES: " + objValidacion );
	    	   
	    	   String MENSAJE = validator(objValidacion);                 //VALIDANDO PARAMETRO LLEGADO!!!
	    	   
	    	   System.out.println("EL PARAMETRO LLEGADO ES: " + MENSAJE );
	    	     	   
	    	   mensajeRespuesta = "<H1>" + MENSAJE + "</H1>";
	    	   
	       }
	       catch( Exception e ){ 
		   	      e.printStackTrace();
	       } 
	       
		   return mensajeRespuesta;
	}

	/**
	 * validator
	 * @param  parametro
	 * @return String
	 **/
    public String validator( String parametro ){		
		
		String cadena = ""; 
		
		if( parametro.equals( "Jesus Hernandez" ) ){
			cadena = "GUADALAJARA";
	   	    System.out.println( "SELECCIONO: GUADALAJARA" );
		}
		else if( parametro.equals("Ricardo Guerra") ){
			cadena = "CHORRILLOS";
	   	    System.out.println( "SELECCIONO: CHORRILLOS" );
		}
		else if( parametro.equals("Felipe Sebastiani") ){
			cadena = "UNIVERSITARIA";
	   	    System.out.println( "SELECCIONO: UNIVERSITARIA" );
		}
		else if( parametro.equals("Maria Arnaiz") ){
			cadena = "CALLAO";
	   	    System.out.println( "SELECCIONO: CALLAO" );
		}
		else if( parametro.equals("Cathy Cotrina") ){
			cadena = "LOS OLIVOS";
	   	    System.out.println( "SELECCIONO: LOS OLIVOS" );
		}		
		else{
			cadena = "PERSONA DESCONOCIDA!!!!";  
	   	    System.out.println( "SELECCIONO: PERSONA DESCONOCIDA!!!!" );
		}	
		
		return cadena;
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
