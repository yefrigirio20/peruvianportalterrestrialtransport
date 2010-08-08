package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Vehiculo;
import com.ttporg.pe.dao.VehiculoDao;

/**
 * @author Cesar Ricardo.
 * @clase: VehiculoDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class VehiculoDaoImpl extends SqlMapClientDaoSupport implements VehiculoDao{
	
	public static final String OBJETO_NEGOCIO = "Vehiculo";

	private BaseBean  beanBase = null;
	
	{
	 this.beanBase = new BaseBean();
	}
	
	/**
	 * eliminarVehiculo_x_codigo
	 * @param codigo
	 */
	public boolean eliminarVehiculo_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'eliminarVehiculo_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteVehiculo" );
        	  
	    	Map<Object, Object> mapaVehiculos = new HashMap<Object, Object>();
	    	mapaVehiculos.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaVehiculos ); 
            
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
	public boolean ingresarVehiculo( Vehiculo Vehiculo ){
        this.imprimeLog( "DENTRO DE 'ingresarVehiculo' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertVehiculo" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, Vehiculo );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarVehiculo
	 * @param Vehiculo
	 */
	public boolean modificarVehiculo( Vehiculo Vehiculo ){
        this.imprimeLog( "DENTRO DE 'modificarVehiculo' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateVehiculo" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, Vehiculo );  
            
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
	 * obtenerListaVehiculos
	 * @param codigo
	 */
	public List<Vehiculo> obtenerListaVehiculos(){
        this.imprimeLog( "DENTRO DE 'obtenerListaVehiculos' " );
        
        List<Vehiculo> listaVehiculo = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaVehiculo" );
        	
        	listaVehiculo = (List<Vehiculo>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaVehiculo;
	}

	/**
	 * obtenerObjetoVehiculo_x_codigo
	 * @param codigo
	 **/
	public Vehiculo obtenerObjetoVehiculo_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerObjetoVehiculo_x_codigo' " );
		
        Vehiculo Vehiculo = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getVehiculo" );
 
        	Vehiculo = (Vehiculo)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	this.imprimeLog( "Vehiculo: " + Vehiculo ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return Vehiculo;	
	}	
	
	/**
	 * obtenerListaVehiculo_x_idServicio
	 * @param codigo
	 **/
	public List<Vehiculo> obtenerListaVehiculo_x_idServicio( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerListaVehiculo_x_idServicio' " );
		
        List<Vehiculo> listaVehiculo = null;
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaVehiculo_x_idServicio" );
 
        	listaVehiculo = (List<Vehiculo>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );   //FORMA #2
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaVehiculo;	
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

