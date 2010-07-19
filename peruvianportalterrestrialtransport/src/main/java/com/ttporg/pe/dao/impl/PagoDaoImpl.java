package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.dao.PagoDao;

/**
 * @author Cesar Ricardo.
 * @clase: PagoDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class PagoDaoImpl extends SqlMapClientDaoSupport implements PagoDao{
	
	public static final String OBJETO_NEGOCIO = "Pago";

	/**
	 * eliminarPago_x_codigo
	 * @param codigo
	 */
	public boolean eliminarPago_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarPago_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deletePago" );
        	  
	    	Map<Object, Object> mapaPagos = new HashMap<Object, Object>();
	    	mapaPagos.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaPagos ); 
            
        	System.out.println( "EstadoEliminacion: " + estadoEliminacion ); 
			
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
	public boolean ingresarPago( Pago pago ){
        System.out.println( "DENTRO DE 'ingresarPago' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertPago" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, pago );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarPago
	 * @param Pago
	 */
	public boolean modificarPago( Pago pago ){
        System.out.println( "DENTRO DE 'modificarPago' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updatePago" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, pago );  
            
        	System.out.println( "Estado Guardar: " + estadoGuardar ); 
			
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
	 * obtenerListaPagos
	 * @param codigo
	 */
	public List<Pago> obtenerListaPagos(){
        System.out.println( "DENTRO DE 'obtenerListaPagos' " );
        
        List<Pago> listaPago = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaPago" );
        	
        	listaPago = (List<Pago>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaPago;
	}

	/**
	 * obtenerObjetoPago_x_codigo
	 * @param codigo
	 */
	public Pago obtenerObjetoPago_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoPago_x_codigo' " );
		
        Pago Pago = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getPago" );
 
        	Pago = (Pago)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "Pago: " + Pago ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return Pago;	
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
 	
}
