package com.ttporg.pe.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Cesar Ricardo.
 * @clase: ClienteServletMB.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ClienteServletMB extends ActionSupport implements ServletResponseAware, ServletRequestAware{

	private static final long serialVersionUID = -9082650078047288321L;
	
	private HttpServletRequest  request;    
	private HttpServletResponse response;
		
	private String	usuario;
	private String	password;
	
	private String  SUCCESS = "success";
	private String  NONE    = "none";
	private String  ERROR   = "error";
	private String  INPUT   = "input";
 	
	private static String     REDIRECCIONAMIENTO = "/jsp/Home.jsp";	   
	
	/**
	 * execute
	 **/
	
	/*
	public String execute(){
		
		String estadoRetorno = "";
		
		try{
			System.out.println( "Usuario:  " + this.usuario  );
			System.out.println( "Password: " + this.password );

			boolean estadoUsuario  = this.getValidaDatosInput( this.getUsuario()  );
			boolean estadoPassword = this.getValidaDatosInput( this.getPassword() );
			
			System.out.println( "Estado Usuario:  " + estadoUsuario  );
			System.out.println( "Estado Password: " + estadoPassword );
			
			//Validacion ...
			if( (estadoUsuario == true) && (estadoPassword == true) ){
				
				if( this.getUsuario().equalsIgnoreCase(  "rguerra" ) && 
				    this.getPassword().equalsIgnoreCase( "admin"   ) ){
					
					addActionMessage( "AUTENTICACION EXITOSA ..!!" );
					estadoRetorno = SUCCESS;  //Se reenvia a la interfaz siguiente.	
				}
				else{	
					addActionError( "Usuario o Password Incorrecto." );     //Setea el mensaje de Error Personalizado.
					estadoRetorno = INPUT;    //Regresa a la misma interfaz.
				}			
			}
			else{
				 addActionError( "Se encontraron datos Nulos." );
				 estadoRetorno = INPUT;
			}
		}
		catch( Exception e ){
			   addActionError( "Exception: " + e.getMessage() );     //Setea el mensaje de Error Personalizado.
			   estadoRetorno = ERROR;                                //Se reenvia a la interfaz de ERROR.	
		} 
		
		System.out.println( "estadoRetorno: " + estadoRetorno );
		
		return estadoRetorno;
	}
     */
	   public String execute() throws Exception {
	        System.out.println( "DENTRO DE 'execute'" );  

		    ServletContext    contexto    = null;
		    RequestDispatcher despachador = null; 
	        
	        ActionContext ctx = ActionContext.getContext();
	        System.out.println( "ctx: " + ctx );
		 	
			contexto    = (ServletContext)ctx.getContext();  
			despachador = contexto.getRequestDispatcher( REDIRECCIONAMIENTO );  
	        
		    //despachador.forward( request, response ); 
		    
			//response.sendRedirect( SERVLET_VALIDATOR );
			
			request.setAttribute( "dato", "parametro_aQUI" );
			
			return SUCCESS;
	   }
	
	   public String validarUsuario() throws ServletException, IOException{
	       System.out.println( "DENTRO DE 'validarUsuario'" );  
	       
	       //System.out.println( "REQUEST:  " + this.getServletRequest()  );
	       //System.out.println( "RESPONSE: " + this.getServletResponse() );
	      
	       //request.getRequestDispatcher( SERVLET_VALIDATOR ).forward( request, response );
		   
		   return SUCCESS;
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

	public void setServletRequest( HttpServletRequest request ){       
	   this.request = request;    
	}
	   
	public void setServletResponse( HttpServletResponse response ){       
	   this.response = response;    
	}
	   
	public HttpServletRequest getServletRequest(){       
	   return request;    
	}
	   
	public HttpServletResponse getServletResponse(){       
	    return response;    
	}
	
 }
