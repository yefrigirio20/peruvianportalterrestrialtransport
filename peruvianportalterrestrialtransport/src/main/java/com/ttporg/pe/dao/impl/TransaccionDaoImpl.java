package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Transaccion;
import com.ttporg.pe.dao.TransaccionDao;

/**
 * @author Cesar Ricardo.
 * @clase: TransaccionDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class TransaccionDaoImpl extends SqlMapClientDaoSupport implements TransaccionDao{
	
	public static final String OBJETO_NEGOCIO = "Transaccion";

	/**
	 * eliminarTransaccion_x_codigo
	 * @param codigo
	 */
	public boolean eliminarTransaccion_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarTransaccion_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteTransaccion" );
        	  
	    	Map<Object, Object> mapaTransaccions = new HashMap<Object, Object>();
	    	mapaTransaccions.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaTransaccions ); 
            
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
	public boolean ingresarTransaccion( Transaccion transaccion ){
        System.out.println( "DENTRO DE 'ingresarTransaccion' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertTransaccion" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, transaccion );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarTransaccion
	 * @param Transaccion
	 */
	public boolean modificarTransaccion( Transaccion Transaccion ){
        System.out.println( "DENTRO DE 'modificarTransaccion' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateTransaccion" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, Transaccion );  
            
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
	 * obtenerListaTransaccions
	 * @param codigo
	 */
	public List<Transaccion> obtenerListaTransaccions(){
        System.out.println( "DENTRO DE 'obtenerListaTransaccions' " );
        
        List<Transaccion> listaTransaccion = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaTransaccion" );
        	
        	listaTransaccion = (List<Transaccion>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaTransaccion;
	}

	/**
	 * obtenerObjetoTransaccion_x_codigo
	 * @param codigo
	 */
	public Transaccion obtenerObjetoTransaccion_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoTransaccion_x_codigo' " );
		
        Transaccion Transaccion = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getTransaccion" );
 
        	Transaccion = (Transaccion)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "Transaccion: " + Transaccion ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return Transaccion;	
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
