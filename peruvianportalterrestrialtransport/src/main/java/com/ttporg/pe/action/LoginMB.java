package com.ttporg.pe.action;

import static com.ttporg.pe.util.Constantes.MENSAJE_AUTENTICACION_ERROR_01;
import static com.ttporg.pe.util.Constantes.MENSAJE_AUTENTICACION_ERROR_02;
import static com.ttporg.pe.util.Constantes.MENSAJE_AUTENTICACION_OK;
import javax.servlet.ServletContext;
import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Cliente;
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
import com.ttporg.pe.util.UtilEncriptacion;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Cesar Ricardo.
 * @clase: LoginMB.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class LoginMB extends BaseBean{

	private static final long serialVersionUID = -9082650078047288321L;
		
	//Utilitarios ...
	private UtilEncriptacion manejoEncriptacion = null; 
	
	//Service ...
	//private ClienteService servicio  = null;
		
	//Daos [SPRING] ...
	private ClienteDao      clienteDAO      = null;
	private EmpresaDao      empresaDAO      = null;	
	private DepartamentoDao departamentoDAO = null;
	private AgenciaDao      agenciaDAO      = null;		
	private VehiculoDao     vehiculoDAO     = null;	
	private ServicioDao     servicioDAO     = null;
	private AsientoDao      asientoDAO      = null;
	private SalidaDao       salidaDAO       = null;
	private CalendarioDao   calendarioDAO   = null;
	private PagoDao         pagoDAO         = null;
	private ClientePagoDao  clientePagoDAO  = null;
	private TransaccionDao  transaccionDAO  = null;
 	
	//Utilitarios ...
	private UtilCalendario  utilCalendario  = null;
	private BaseBean        beanBase        = null;
	
	//Parametros de acceso 'GUI'.
	private String	usuario;
	private String	password;
 
	{
	 //this.servicio         = new ServiceFactory();
		
	 this.clienteDAO         = new ClienteDaoImpl();
	 this.empresaDAO         = new EmpresaDaoImpl();	
	 this.departamentoDAO    = new DepartamentoDaoImpl();
	 this.agenciaDAO         = new AgenciaDaoImpl();		
	 this.vehiculoDAO        = new VehiculoDaoImpl();	
	 this.servicioDAO        = new ServicioDaoImpl();
	 this.asientoDAO         = new AsientoDaoImpl();
	 this.salidaDAO          = new SalidaDaoImpl();
	 this.calendarioDAO      = new CalendarioDaoImpl();
	 this.pagoDAO            = new PagoDaoImpl();
	 this.clientePagoDAO     = new ClientePagoDaoImpl();
	 this.transaccionDAO     = new TransaccionDaoImpl();
 
	 this.manejoEncriptacion = new UtilEncriptacion(); 
	 this.utilCalendario     = new UtilCalendario();	 
	 this.beanBase           = new BaseBean();
	}
 	
	/**
	 * execute
	 */
	public String execute(){
		this.imprimeLog( "******  execute() *********" );
		
		String estadoRetorno = "";
 				 
		//INICIALIZANDO 'DAOs'...
		this.inicializaDAOs();	
		
		try{
			this.imprimeLog( "Usuario:  " + this.usuario  );
			this.imprimeLog( "Password: " + this.password );

			boolean estadoUsuario  = this.getValidaDatosInput( this.getUsuario()  );
			boolean estadoPassword = this.getValidaDatosInput( this.getPassword() );
			
			this.imprimeLog( "Estado Usuario:  " + estadoUsuario  );
			this.imprimeLog( "Estado Password: " + estadoPassword );
			
			//Validacion ...
			if( (estadoUsuario == true) && (estadoPassword == true) ){
				
				Cliente objCliente = new Cliente();

				//String encrypPassword = this.manejoEncriptacion.encriptarCIPHER( this.getPassword().toUpperCase() );
				
				objCliente.setUsuario(  this.usuario  );
				//objCliente.setPassword( encrypPassword   );
				objCliente.setPassword( this.password ); 
				
				//-------------- Obtener 'BASE DE DATOS'. --------------//
				Cliente objClienteDB = this.clienteDAO.loginCliente( objCliente );
				this.imprimeLog( "objClienteDB: " + objClienteDB );
				//------------------------------------------------------//
				
    	    	 this.imprimeLog( "BD EXISTE: " );
 
    	    	 //Validando ...
    	    	 if( objClienteDB.getUsuario().equalsIgnoreCase(  this.usuario  ) &&
    	    		 objClienteDB.getPassword().equalsIgnoreCase( this.password ) ){
    	    		 
    				 //Setear Obj.Singleton en SESION.
                     this.getObjSession().put( "objCliente", objClienteDB ); 
    	    		  
  					 addActionMessage( MENSAJE_AUTENTICACION_OK );
					 estadoRetorno = SUCCESS;                          //Se reenvia a la interfaz siguiente.	
 				}
 				else{	
 					 addActionError( MENSAJE_AUTENTICACION_ERROR_01 ); //Setea el mensaje de Error Personalizado.
 					 estadoRetorno = INPUT;                            //Regresa a la misma interfaz.
 				}	
			}
			else{
				 addActionError( MENSAJE_AUTENTICACION_ERROR_02 );
				 estadoRetorno = INPUT;
			}   
		}
		catch( Exception e ){
			   addActionError( "Exception: " + e.getMessage() );     //Setea el mensaje de Error Personalizado.
			   estadoRetorno = ERROR;                                //Se reenvia a la interfaz de ERROR.	
		} 
		
		this.imprimeLog( "ESTADO 'NAVEGACION': " + estadoRetorno );
		
		return estadoRetorno;
	}
 
	/**
	 * getValidaDatosInput
	 * @param  valorParam
	 * @return boolean
	 **/
	private boolean getValidaDatosInput( String valorParam ){
		
		boolean estadoRetorno = false;
		
		if( (valorParam == null) || (valorParam.length() == 0) ){
			estadoRetorno = false;
		}
		else{
			estadoRetorno = true;
		}
		
		return estadoRetorno;
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public void setUsuario( String usuario ){
		this.usuario = usuario;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
	
	public static long getSerialVersionUID(){
		return serialVersionUID;
	}	

	/**
	 * inicializaDAOs
	 **/
	public void inicializaDAOs(){
		
		//OBTENER [ServletContext] USANDO [STRUTs 2]: 'ServletActionContext.getServletContext()'.
		//OBTENER [ServletContext] USANDO [SERVLETs]: 'this.getServletContext()'.
		ServletContext servletContext = ServletActionContext.getServletContext();	
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

