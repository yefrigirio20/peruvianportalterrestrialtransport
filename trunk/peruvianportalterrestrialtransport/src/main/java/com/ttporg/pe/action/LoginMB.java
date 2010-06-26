package com.ttporg.pe.action;

import static com.ttporg.pe.util.Constantes.MENSAJE_AUTENTICACION_ERROR_01;
import static com.ttporg.pe.util.Constantes.MENSAJE_AUTENTICACION_ERROR_02;
import static com.ttporg.pe.util.Constantes.MENSAJE_AUTENTICACION_OK;
import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.servicio.EmpresaService;
import com.ttporg.pe.servicio.impl.EmpresaServiceImpl;
import com.ttporg.pe.servlet.LoggerBean;
import com.ttporg.pe.util.UtilEncriptacion;
import com.ttporg.pe.util.UtilSingleton;

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
 */
public class LoginMB extends BaseBean{

	private static final long serialVersionUID = -9082650078047288321L;
		
	//Utilitarios ...
	private UtilEncriptacion manejoEncriptacion = null; 
	
	//Service.
	private EmpresaService servicio = null;
	
	//Generacion de Log.
	private LoggerBean loggerBean   = null;
	
	//Parametros de acceso 'GUI'.
	private String	usuario;
	private String	password;
	 		
	{
	 this.servicio           = new EmpresaServiceImpl();	
	 this.loggerBean         = new LoggerBean();
	 this.manejoEncriptacion = new UtilEncriptacion(); 
	}
	
	/**
	 * execute
	 */
	public String execute(){
		System.out.println( "******  execute() *********" );
		
		String estadoRetorno = "";
		
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
								
				//objCliente = this.servicio.loginEmpresa( objCliente );
				
	    	    //---------------- Obtener 'SINGLETON'. ----------------//
				UtilSingleton utilSingleton = UtilSingleton.getINSTANCIA_GUARDADA();
			 
	    	    System.out.println( "Util Singleton: " + utilSingleton );
	    	    
	    	    //Validacion ...
	    	    if( (utilSingleton != null) && (utilSingleton.isEstadoActivacion() == true) ){
	    	    	 Cliente objClienteSingleton = utilSingleton.getObjetoSingleton().getCliente();
				
	    	    	 System.out.println( "Singleton EXISTE: " );
		    	    
	    	    	 //Validando ...
	    	    	 if( objClienteSingleton.getUsuario().equalsIgnoreCase( this.usuario )  &&
	    	    		 objClienteSingleton.getPassword().equalsIgnoreCase( this.password ) ){
	    	    		 
	    				  //Setear Obj.Singleton en SESION.
	    	    		  this.getObjSession().put( "objCliente", objClienteSingleton ); 
	    	    		  
	  					  addActionMessage( MENSAJE_AUTENTICACION_OK );
						  estadoRetorno = SUCCESS;                           //Se reenvia a la interfaz siguiente.	
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
	    	    

				
				//this.imprimeLog( "objCliente: " + objCliente );
				
				
				
				/*
				if( objCliente != null ){
										
					//UtilSingleton utilSingleton = UtilSingleton.getINSTANCIA_GUARDADA();	 	    	    
		    	    //System.out.println( "Util Singleton: " + utilSingleton );
					
	    	    	//System.out.println( "Usuario  s: " + utilSingleton.getObjetoSingleton().getCliente().getUsuario() );
	    	    	//System.out.println( "Password s: " + utilSingleton.getObjetoSingleton().getCliente().getPassword() );
					
					//Seteando datos en 'Session'.
					this.getObjSession().put( "objCliente", objCliente ); 
										
					//Obteniendo datos de 'Session'.
					//objEmpresa = (Empresa)this.getObjSession().get( "objEmpresa" );
					
					addActionMessage( MENSAJE_AUTENTICACION_OK );
					estadoRetorno = SUCCESS;                           //Se reenvia a la interfaz siguiente.	
				}
				else{	
					 addActionError( MENSAJE_AUTENTICACION_ERROR_01 ); //Setea el mensaje de Error Personalizado.
					 estadoRetorno = INPUT;                            //Regresa a la misma interfaz.
				}			
			}
			else{
				 addActionError( MENSAJE_AUTENTICACION_ERROR_02 );
				 estadoRetorno = INPUT;
			
			*/
	    	    
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
	 * imprimeLog
	 * @param mensaje
	 */
	public void imprimeLog( String mensaje ){
		this.loggerBean.getLoggerLog4j().info( mensaje );
	}
	
	/**
	 * getValidaDatosInput
	 * @param  valorParam
	 * @return boolean
	 */
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

 }
