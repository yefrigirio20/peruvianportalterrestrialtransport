package com.ttporg.pe.bean;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ttporg.pe.util.UtilLogger;

/**
 * @author Cesar Ricardo.
 * @clase: BaseBean.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class BaseBean extends ActionSupport{
 
	private static final long serialVersionUID = -8848886051809932163L;
	
	//Redirecccionamiento ...
	protected static final String  SUCCESS = "success";
	protected static final String  NONE    = "none";
	protected static final String  ERROR   = "error";
	protected static final String  INPUT   = "input";
	
	//Obteniendo Objetos.
	private Map<String, Object> objAtribute    = null;
	private Map<String, Object> objApplication = null;
	private Map<String, Object> objSession     = null;
	private Map<String, Object> objRequest     = null;
		
	//Generacion de Log.
	private UtilLogger loggerBean = null;	
	
	//Constructor ...
	public BaseBean(){		
	}
	
	/***********************************************************************************/
	/*********************** IMPORTANTE: OBJETOS 'ActionContext' ***********************/
	/***********************************************************************************/
	
	/**
	 * imprimeLog
	 * @param mensaje
	 * @param nombreClase
	 **/
	public void imprimeLog( String mensaje, String nombreClase ){
		
		this.loggerBean = new UtilLogger( nombreClase  );  //Envia el nombre de la ubicacion de la clase al LOGs..	
		this.loggerBean.getLoggerLog4j().debug( mensaje );
	}
	
	public Map<String, Object> getObjAtribute(){
		if( this.objAtribute == null ){			
			this.objAtribute = (Map<String, Object>)ActionContext.getContext().get( "attr" );
		}
		
		return objAtribute;
	}	
	
	public Map<String, Object> getObjApplication(){
		if( this.objAtribute == null ){			
			this.objApplication = (Map<String, Object>)ActionContext.getContext().get( "application" );
		}
		
		return objApplication;
	}	
	
	public Map<String, Object> getObjSession(){
		if( this.objAtribute == null ){			
			this.objSession = (Map<String, Object>)ActionContext.getContext().get( "session" );
		}
		
		return objSession;
	}	
	
	public Map<String, Object> getObjRequest(){
		if( this.objAtribute == null ){			
			this.objRequest = (Map<String, Object>)ActionContext.getContext().get( "request" );
		}
		
		return objRequest;
	}
	
	public void setObjAtribute( Map<String, Object> objAtribute ){
		this.objAtribute = objAtribute;
	}
	
	public void setObjApplication( Map<String, Object> objApplication ){
		this.objApplication = objApplication;
	}
	
	public void setObjSession( Map<String, Object> objSession ){
		this.objSession = objSession;
	}
	
	public void setObjRequest( Map<String, Object> objRequest ){
		this.objRequest = objRequest;
	}	
	
}
