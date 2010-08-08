package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.dao.AgenciaDao;

/**
 * @author Cesar Ricardo.
 * @clase: AgenciaDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class AgenciaDaoImpl extends SqlMapClientDaoSupport implements AgenciaDao{
	
	public static final String OBJETO_NEGOCIO = "Agencia";

	private BaseBean  beanBase = null;
	
	{
	 this.beanBase = new BaseBean();
	}
	
	/**
	 * eliminarAgencia_x_codigo
	 * @param codigo
	 */
	public boolean eliminarAgencia_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'eliminarAgencia_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteAgencia" );
        	  
	    	Map<Object, Object> mapaAgencias = new HashMap<Object, Object>();
	    	mapaAgencias.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaAgencias ); 
            
        	this.imprimeLog( "EstadoEliminacion: " + estadoEliminacion ); 
			
        	if( estadoEliminacion == 1 ){
        		mensaje = true;	
        	}
        	else{
        		mensaje = false;	
        	}
		}
		catch( Exception e ){
	           e.printStackTrace();
               mensaje = false;
		}
		
	    return mensaje;
	}

	/**
	 * ingresarEmpresa
	 * @param empresa
	 */
	public boolean ingresarAgencia( Agencia agencia ){
        this.imprimeLog( "DENTRO DE 'ingresarAgencia' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertAgencia" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, agencia );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarAgencia
	 * @param Agencia
	 */
	public boolean modificarAgencia( Agencia agencia ){
        this.imprimeLog( "DENTRO DE 'modificarAgencia' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateAgencia" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, agencia );  
            
        	this.imprimeLog( "Estado Guardar: " + estadoGuardar ); 
			
        	if( estadoGuardar == 1 ){
        		mensaje = true;	
        	}
        	else{
        		mensaje = false;	
        	}			
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
	
	/**
	 * obtenerListaAgencias
	 * @param codigo
	 */
	public List<Agencia> obtenerListaAgencias(){
        this.imprimeLog( "DENTRO DE 'obtenerListaAgencias' " );
        
        List<Agencia> listaAgencia = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaAgencia" );
        	
        	listaAgencia = (List<Agencia>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaAgencia;
	}

	/**
	 * obtenerListaAgencias_x_codigo
	 **/
	public List<Agencia> obtenerListaAgencias_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerListaAgencias_x_codigo' " );
        
        List<Agencia> listaAgencia = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaAgencia_x_codigo" );
        	
        	listaAgencia = (List<Agencia>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaAgencia;
	}
	
	/**
	 * obtenerListaAgencias_x_empresa
	 **/
	public List<Agencia> obtenerListaAgencias_x_empresa( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerListaAgencias_x_empresa' " );
        
        List<Agencia> listaAgencia = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaAgencia_x_empresa" );
        	
        	listaAgencia = (List<Agencia>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaAgencia;
	}
	
	/**
	 * obtenerObjetoAgencia_x_codigo
	 * @param codigo
	 */
	public Agencia obtenerObjetoAgencia_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerObjetoAgencia_x_codigo' " );
		
        Agencia Agencia = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getAgencia" );
 
        	Agencia = (Agencia)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	this.imprimeLog( "Agencia: " + Agencia ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return Agencia;	
	}	
	
	/**
	 * getObjetoNegocio
	 * @param  nombReferMetodoMapeado
	 * @return String
	 */
	private String getObjetoNegocio( String nombReferMetodoMapeado ){
		
		String nombObjNegocio = (OBJETO_NEGOCIO + "." + nombReferMetodoMapeado);
		
		return nombObjNegocio;
	}
 	
	/**
	 * this.imprimeLog
	 * @param mensaje
	 **/
	public void imprimeLog( String mensaje ){ 
		this.beanBase.imprimeLog( mensaje, this.getClass().toString() );
	}
	
}
