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
import com.ttporg.pe.util.UtilEncriptacion;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Cesar Ricardo.
 * @clase: LoginMB.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public class LoginMB extends BaseBean{

	private static final long serialVersionUID = -9082650078047288321L;
	
	//Service ...
	//private ClienteService servicio  = null;
		
	//Daos [SPRING] ...
	private ClienteDao       clienteDAO       = null;
	private EmpresaDao       empresaDAO       = null;	
	private DepartamentoDao  departamentoDAO  = null;
	private AgenciaDao       agenciaDAO       = null;		
	private VehiculoDao      vehiculoDAO      = null;	
	private ServicioDao      servicioDAO      = null;
	private AsientoDao       asientoDAO       = null;
	private SalidaDao        salidaDAO        = null;
	private CalendarioDao    calendarioDAO    = null;
	private PagoDao          pagoDAO          = null;
	private ClientePagoDao   clientePagoDAO   = null;
	private TransaccionDao   transaccionDAO   = null;
 	
	//Utilitarios ...
	private UtilEncriptacion utilEncriptacion = null; 
	private BaseBean         beanBase         = null;
	 
	private String	         usuario          = null;  //Struts2
	private String	         password         = null;  //Struts2
	
	{
	 //this.servicio         = new ServiceFactory();
		
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
 
	 this.utilEncriptacion = new UtilEncriptacion(); 
	 this.beanBase         = new BaseBean();
	}
 	
	/**
	 * execute
	 **/
	public String execute(){
		this.imprimeLog( "******  execute() *********" );
		
		String estadoRetorno = "";
 				 
		//INICIALIZANDO 'DAOs'...
		this.inicializaDAOs();	
		
		try{			
			this.imprimeLog( "Usuario:  " + usuario  );
			this.imprimeLog( "Password: " + password );
			
			boolean estadoUsuario  = this.getValidaDatosInput( usuario  );
			boolean estadoPassword = this.getValidaDatosInput( password );
			
			this.imprimeLog( "Estado Usuario:  " + estadoUsuario  );
			this.imprimeLog( "Estado Password: " + estadoPassword );
			
			//Validacion ...
			if( (estadoUsuario == true) && (estadoPassword == true) ){
				
				Cliente objCliente = new Cliente();
 
				String cadenaEncriptada    = this.utilEncriptacion.encriptarCIPHER(    password    );
				String cadenaDesencriptada = this.utilEncriptacion.desencriptarCIPHER( cadenaEncriptada );
				
				this.imprimeLog( "Cadena Original:      " + password       );
				this.imprimeLog( "Cadena Encriptada:    " + cadenaEncriptada    );
				this.imprimeLog( "Cadena Desencriptada: " + cadenaDesencriptada );
				
				objCliente.setUsuario(  usuario  );
				objCliente.setPassword( cadenaEncriptada );
				//objCliente.setPassword( this.password ); 
				 
				//-------------- Obtener 'BASE DE DATOS'. --------------//
				Cliente objClienteBD = this.clienteDAO.loginCliente( objCliente );
				this.imprimeLog( "objClienteDB: " + objClienteBD );
				//------------------------------------------------------//
    	    	 
				if( objClienteBD != null ){
					
					//Validando ...
					if( objClienteBD.getUsuario().equalsIgnoreCase(  usuario  ) &&
							objClienteBD.getPassword().equalsIgnoreCase( cadenaEncriptada ) ){
						
						//Setear Obj.Singleton en SESION.
						this.getObjSession().put( "objCliente", objClienteBD ); 
						
						addActionMessage( MENSAJE_AUTENTICACION_OK );
						estadoRetorno = SUCCESS;                          //Se reenvia a la interfaz siguiente.	
					}
					else{	
						addActionError( MENSAJE_AUTENTICACION_ERROR_01 ); //Setea el mensaje de Error Personalizado.
						estadoRetorno = INPUT;                            //Regresa a la misma interfaz.
					}	
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
	
	public String getUsuario(){
		return usuario;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setUsuario( String usuario ){
		this.usuario = usuario;
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
		
}

