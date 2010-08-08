package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.dao.ServicioDao;

/**
 * @author Cesar Ricardo.
 * @clase: ServicioDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServicioDaoImpl extends SqlMapClientDaoSupport implements ServicioDao{
	
	public static final String OBJETO_NEGOCIO = "Servicio";

	private BaseBean  beanBase = null;
	
	{
	 this.beanBase = new BaseBean();
	}
	
	/**
	 * eliminarServicio_x_codigo
	 * @param codigo
	 */
	public boolean eliminarServicio_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'eliminarServicio_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteServicio" );
        	  
	    	Map<Object, Object> mapaServicios = new HashMap<Object, Object>();
	    	mapaServicios.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaServicios ); 
            
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
	public boolean ingresarServicio( Servicio servicio ){
        this.imprimeLog( "DENTRO DE 'ingresarServicio' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertServicio" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, servicio );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarServicio
	 * @param Servicio
	 */
	public boolean modificarServicio( Servicio servicio ){
        this.imprimeLog( "DENTRO DE 'modificarServicio' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateServicio" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, servicio );  
            
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
	 * obtenerListaServicios
	 * @param codigo
	 */
	public List<Servicio> obtenerListaServicios(){
        this.imprimeLog( "DENTRO DE 'obtenerListaServicios' " );
        
        List<Servicio> listaServicio = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaServicio" );
        	
        	listaServicio = (List<Servicio>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaServicio;
	}

	/**
	 * obtenerListaServicios_x_agencia
	 */
	public List<Servicio> obtenerListaServicios_x_agencia( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerListaServicios_x_agencia' " );
        
        List<Servicio> listaServicio = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaServicio_x_agencia" );
        	
        	listaServicio = (List<Servicio>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaServicio;
	}
	
	/**
	 * obtenerObjetoServicio_x_codigo
	 * @param codigo
	 */
	public Servicio obtenerObjetoServicio_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerObjetoServicio_x_codigo' " );
		
        Servicio Servicio = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getServicio" );
 
        	Servicio = (Servicio)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	this.imprimeLog( "Servicio: " + Servicio ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return Servicio;	
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
