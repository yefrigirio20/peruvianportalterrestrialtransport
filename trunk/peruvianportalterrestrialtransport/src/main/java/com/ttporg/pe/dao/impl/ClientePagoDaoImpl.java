package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.ClientePago;
import com.ttporg.pe.dao.ClientePagoDao;

/**
 * @author Cesar Ricardo.
 * @clase: ClientePagoDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ClientePagoDaoImpl extends SqlMapClientDaoSupport implements ClientePagoDao{
	
	public static final String OBJETO_NEGOCIO = "ClientePago";

	/**
	 * eliminarClientePago_x_codigo
	 * @param codigo
	 */
	public boolean eliminarClientePago_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarClientePago_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteClientePago" );
        	  
	    	Map<Object, Object> mapaClientePagos = new HashMap<Object, Object>();
	    	mapaClientePagos.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaClientePagos ); 
            
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
	public boolean ingresarClientePago( ClientePago clientePago ){
        System.out.println( "DENTRO DE 'ingresarClientePago' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertClientePago" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, clientePago );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarClientePago
	 * @param ClientePago
	 */
	public boolean modificarClientePago( ClientePago clientePago ){
        System.out.println( "DENTRO DE 'modificarClientePago' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateClientePago" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, clientePago );  
            
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
	 * obtenerListaClientePagos
	 * @param codigo
	 */
	public List<ClientePago> obtenerListaClientePagos(){
        System.out.println( "DENTRO DE 'obtenerListaClientePagos' " );
        
        List<ClientePago> listaClientePago = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaClientePago" );
        	
        	listaClientePago = (List<ClientePago>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaClientePago;
	}

	/**
	 * obtenerObjetoClientePago_x_codigo
	 * @param codigo
	 */
	public ClientePago obtenerObjetoClientePago_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoClientePago_x_codigo' " );
		
        ClientePago ClientePago = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getClientePago" );
 
        	ClientePago = (ClientePago)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "ClientePago: " + ClientePago ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return ClientePago;	
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
