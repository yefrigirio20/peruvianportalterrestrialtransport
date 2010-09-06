package com.ttporg.pe.servlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder;
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
import com.ttporg.pe.dto.DetallePopupDTO;  

//---------------------- IMPORTANTE: ----------------------//
//1.- AJAX-TAGs v1.1.5: Version estable descargada con el MAVEN de intenet y su paquete es:
//                      [org.ajaxtags.servlets].
//2.- AJAX-TAGs v1.5.1: Ultima version (Mas controles AJAX), instalacion manual en la
//                      carpeta .lib, ya que no se hay repositorio MAVEN en internet 
//                      donde descargar esta version. Su paquete es:
//                      [org.ajaxtags.servlets.BaseAjaxServlet]. 
//
//Actualmente se estan utilizando las 2 versiones, la primera para evitar errores de compilacion 
//al pasar el MAVEN y la segunda para fines de la aplicacion (Librerias mas completa).

//import org.ajaxtags.servlets.BaseAjaxServlet;             //PARA COMPILACION MAVEN.
import net.sourceforge.ajaxtags.servlets.BaseAjaxServlet;   //PARA USO.
//----------------------------------------------------------/

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
	private BaseBean          beanBase           = null;
	
	{
	 //this.servicio       = new ServiceFactory();
		
	 this.clienteDAO       = new ClienteDaoImpl();
	 this.empresaDAO       = new EmpresaDaoImpl();	
	 this.departamentoDAO  = new DepartamentoDaoImpl();
	 this.agenciaDAO       = new AgenciaDaoImpl();		
	 this.vehiculoDAO      = new VehiculoDaoImpl();	
	 this.servicioDAO      = new ServicioDaoImpl();
	 this.asientoDAO       = new AsientoDaoImpl();
	 this.salidaDAO        = new SalidaDaoImpl();
	 this.calendarioDAO    = new CalendarioDaoImpl();
	 this.pagoDAO          = new PagoDaoImpl();
	 this.clientePagoDAO   = new ClientePagoDaoImpl();
	 this.transaccionDAO   = new TransaccionDaoImpl();

	 this.beanBase         = new BaseBean();
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
		 //this.inicializaDAOs();	
	}
	
	/**
	 * getXmlContent
	 * @param request
	 * @param response
	 **/
	public String getXmlContent( HttpServletRequest request, HttpServletResponse response ){			   
		   this.imprimeLog( "**** DENTRO DE 'ServletAjax', (extends BaseAjaxServlet) **** " );	
		   
		   //INICIALIZANDO 'DAOs'...
		   this.inicializaDAOs();
		   
		   String opcionAjax = request.getParameter( "opcionAjax" ).trim();
		   System.out.println( "OPCION AJAX: " + opcionAjax );
		   
		   String cadenaAjaxReturn = "";
		   
			if( (opcionAjax != null) && (opcionAjax.equalsIgnoreCase( "PROCESO_AJAX_01" )) ){			
				cadenaAjaxReturn = this.procesoAjax_01( request, response );
			}		
			else if( (opcionAjax != null) && (opcionAjax.equalsIgnoreCase( "PROCESO_AJAX_02" )) ){		
				     cadenaAjaxReturn = this.procesoAjax_02( request, response );
			}		
 	       
		    return cadenaAjaxReturn;
	}
 	
	/**
	 * procesoAjax_01
	 * @param  request
	 * @param  response
	 * @return String
	 **/
	public String procesoAjax_01( HttpServletRequest request, HttpServletResponse response ){	
		   this.imprimeLog( "******* DENTRO DE: 'procesoAjax_01' *******" );
		
		   String mensajeRespuesta = new String( "" ); 

	       try{	
	    	   AjaxXmlBuilder constructorAjaxXML = new AjaxXmlBuilder();
	    	   
        	   String posicion = request.getParameter( "idAsiento" ).trim();
        	   
	    	   if( posicion != null ){
	    		   
	    		   DetallePopupDTO objDetallePopup = (DetallePopupDTO)this.empresaDAO.obtenerObjetoDatosPopup_x_codigoAsiento( Integer.parseInt( posicion ) );

	    		   String mensajeAJAX = "";
	    			   
		   		   this.imprimeLog( "" );
				   this.imprimeLog( "====> [empresaDAO]:      " + empresaDAO   );
				   this.imprimeLog( "" );			
				   this.imprimeLog( "====> [objDetallePopup]: " + objDetallePopup   );		
				   this.imprimeLog( "" );	
				   this.imprimeLog( "AsientoId:          " + objDetallePopup.getAsientoId()      );
				   this.imprimeLog( "AgenciaNombre:      " + objDetallePopup.getAgenciaNombre()  );
				   this.imprimeLog( "VehiculoNombre:     " + objDetallePopup.getVehiculoNombre() );
				   this.imprimeLog( "VehiculoModelo:     " + objDetallePopup.getVehiculoModelo() );
				   this.imprimeLog( "VehiculoTipo:       " + objDetallePopup.getVehiculoTipo()   );
				   this.imprimeLog( "AgenciaNombre:      " + objDetallePopup.getAgenciaNombre()      );
				   this.imprimeLog( "EmpresaRazonSocial: " + objDetallePopup.getEmpresaRazonSocial() );
				   this.imprimeLog( "Posicion:           " + posicion );
				   this.imprimeLog( "" );
	    		   
				   //Armando Mensaje. AJAX.
	    		   mensajeAJAX =  " <table with='100' bgcolor='white' > ";
	    		   mensajeAJAX += " <tr> <td style='color:#003300'> <strong> - Razon Social: </strong>    </td> <td style='color:#003300'>" + objDetallePopup.getEmpresaRazonSocial() + "</td> </tr>"; 
	    		   mensajeAJAX += " <tr> <td style='color:#003300'> <strong> - Agencia: </strong>         </td> <td>" + objDetallePopup.getAgenciaNombre()      + "</td> </tr>";
	    		   mensajeAJAX += " <tr> <td style='color:#003300'> <strong> - Nombre Vehiculo: </strong> </td> <td>" + objDetallePopup.getVehiculoNombre()     + "</td> </tr>"; 
	    		   mensajeAJAX += " <tr> <td style='color:#003300'> <strong> - Modelo Vehiculo: </strong> </td> <td>" + objDetallePopup.getVehiculoModelo()     + "</td> </tr>";
	    		   mensajeAJAX += " <tr> <td style='color:#003300'> <strong> - Tipo Vehiculo: </strong>   </td> <td>" + objDetallePopup.getVehiculoTipo()       + "</td> </tr>"; 
	    		   mensajeAJAX += " <tr> <td style='color:#003300'> <strong> - Columna #: </strong>       </td> <td>" + objDetallePopup.getAsientoId()          + "</td> </tr>";  
	    		   mensajeAJAX += " <tr> <td style='color:#003300'> <strong> - Posicion #: </strong>      </td> <td>" + posicion          + "</td> </tr>"; 
	    		   mensajeAJAX += " </table>"; 
	    		   
	    		   this.imprimeLog( "CADENA 'AJAX': " + mensajeAJAX );
	    		   	    		   
	    		   mensajeRespuesta = constructorAjaxXML.addItemAsCData( "INFORMACION", mensajeAJAX ).toString();
	    	   } 
	       }
	       catch( Exception e ){ 
		   	      e.printStackTrace();
	       } 
	       
		   return mensajeRespuesta;
	}
	
	/**
	 * procesoAjax_02
	 * @param  request
	 * @param  response
	 * @return String
	 **/
	public String procesoAjax_02( HttpServletRequest request, HttpServletResponse response ){	
		   this.imprimeLog( "******* DENTRO DE: 'procesoAjax_02' *******" );
		
		   String mensajeRespuesta = new String( "" ); 

	       try{				
				//EJECUTAR UN PROCESO EN BASE AL PARAMETRO PROCESAR...
				
				this.imprimeLog( "PROCESO EJECUTADO ...!!! " );
				
				//Proceso ASINCRONO.
				return "";
	       }
	       catch( Exception e ){ 
		   	      e.printStackTrace();
	       } 
	       
		   return mensajeRespuesta;
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
