package com.ttporg.pe.action;


import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Usuario;
import com.ttporg.pe.servicio.UsuarioService;
import com.ttporg.pe.servicio.impl.UsuarioServiceImpl;
import com.ttporg.pe.servlet.LoggerBean;
import com.ttporg.pe.util.ManejoEncriptacion;

import static com.ttporg.pe.util.Constantes.*;

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
 */
public class LoginMB extends BaseBean{

	private static final long serialVersionUID = -9082650078047288321L;
		
	//Utilitarios ...
	private ManejoEncriptacion manejoEncriptacion = null; 
	
	//Service.
	private UsuarioService servicio = null;
	
	//Generacion de Log.
	private LoggerBean loggerBean   = null;
	
	//Parametros de acceso 'GUI'.
	private String	usuario;
	private String	password;
	 		
	{
	 this.servicio           = new UsuarioServiceImpl();	
	 this.loggerBean         = new LoggerBean();
	 this.manejoEncriptacion = new ManejoEncriptacion(); 
	}
	
	/**
	 * execute
	 */
	public String execute(){
		
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
				
				Usuario objUsuario = new Usuario();

				String encrypPassword = this.manejoEncriptacion.encriptarCIPHER( this.getPassword().toUpperCase() );
				
				objUsuario.setUsuario(  this.getUsuario()  );
				objUsuario.setPassword( encrypPassword     );
				
				objUsuario = this.servicio.loginUsuario( objUsuario );
				
				this.imprimeLog( "objUsuario: " + objUsuario );
				
				if( objUsuario != null ){
					
					//Seteando datos en 'Session'.
					this.getObjSession().put( "objUsuario", objUsuario ); 
										
					//Obteniendo datos de 'Session'.
					objUsuario = (Usuario)this.getObjSession().get( "objUsuario" );
					
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
