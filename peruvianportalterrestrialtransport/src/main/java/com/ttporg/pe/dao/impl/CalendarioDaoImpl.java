package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Calendario;
import com.ttporg.pe.dao.CalendarioDao;

/**
 * @author Cesar Ricardo.
 * @clase: CalendarioDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class CalendarioDaoImpl extends SqlMapClientDaoSupport implements CalendarioDao{
	
	public static final String OBJETO_NEGOCIO = "Calendario";

	/**
	 * eliminarCalendario_x_codigo
	 * @param codigo
	 */
	public boolean eliminarCalendario_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarCalendario_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteCalendario" );
        	  
	    	Map<Object, Object> mapaCalendarios = new HashMap<Object, Object>();
	    	mapaCalendarios.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaCalendarios ); 
            
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
	public boolean ingresarCalendario( Calendario calendario ){
        System.out.println( "DENTRO DE 'ingresarCalendario' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertCalendario" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, calendario );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarCalendario
	 * @param Calendario
	 */
	public boolean modificarCalendario( Calendario calendario ){
        System.out.println( "DENTRO DE 'modificarCalendario' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateCalendario" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, calendario );  
            
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
	 * obtenerListaCalendarios
	 * @param codigo
	 */
	public List<Calendario> obtenerListaCalendarios(){
        System.out.println( "DENTRO DE 'obtenerListaCalendarios' " );
        
        List<Calendario> listaCalendario = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaCalendario" );
        	
        	listaCalendario = (List<Calendario>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaCalendario;
	}

	/**
	 * obtenerObjetoCalendario_x_codigo
	 * @param codigo
	 */
	public Calendario obtenerObjetoCalendario_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoCalendario_x_codigo' " );
		
        Calendario calendario = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getCalendario" );
 
        	calendario = (Calendario)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "Calendario: " + calendario ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return calendario;	
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
