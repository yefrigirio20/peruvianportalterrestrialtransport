package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.dao.ClienteDao;

/**
 * @author Cesar Ricardo.
 * @clase: ClienteDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ClienteDaoImpl extends SqlMapClientDaoSupport implements ClienteDao{
	
	public static final String OBJETO_NEGOCIO = "Cliente";

	/**
	 * eliminarCliente_x_codigo
	 * @param codigo
	 */
	public boolean eliminarCliente_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarCliente_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteCliente" );
        	  
	    	Map<Object, Object> mapaClientes = new HashMap<Object, Object>();
	    	mapaClientes.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaClientes ); 
            
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
	public boolean ingresarCliente( Cliente cliente ){
        System.out.println( "DENTRO DE 'ingresarCliente' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertCliente" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, cliente );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}

	/**
	 * loginCliente
	 * @param cliente
	 */
	public Cliente loginCliente( Cliente cliente ){
        System.out.println( "DENTRO DE 'loginCliente' " );
        
        Cliente objCliente = null;
              
        try{ 
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getLoginClientes" );
        	
        	objCliente = (Cliente)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, cliente );  
        } 
        catch( Exception e ){
			   e.printStackTrace();
		}
        
        return objCliente;
	}
	
	/**
	 * modificarCliente
	 * @param cliente
	 */
	public boolean modificarCliente( Cliente cliente ){
        System.out.println( "DENTRO DE 'modificarCliente' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateEmpresa" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, cliente );  
            
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
	 * obtenerListaClientes_x_codigo
	 * @param codigo
	 */
	public List<Cliente> obtenerListaClientes_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerListaClientes_x_codigo' " );
        
        List<Cliente> listaCliente = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaCliente" );
        	
        	listaCliente = (List<Cliente>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaCliente;
	}

	/**
	 * obtenerObjetoEmpresa_x_codigo
	 * @param codigo
	 */
	public Cliente obtenerObjetoCliente_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoCliente_x_codigo' " );
		
        Cliente cliente = null;
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getCliente" );
 
        	cliente = (Cliente)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "Cliente: " + cliente ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return cliente;	
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
