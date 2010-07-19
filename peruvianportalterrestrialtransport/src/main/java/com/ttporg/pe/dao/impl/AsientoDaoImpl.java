package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.dao.AsientoDao;

/**
 * @author Cesar Ricardo.
 * @clase: AsientoDaoImpl.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class AsientoDaoImpl extends SqlMapClientDaoSupport implements AsientoDao{
	
	public static final String OBJETO_NEGOCIO = "Asiento";

	/**
	 * eliminarAsiento_x_codigo
	 * @param codigo
	 */
	public boolean eliminarAsiento_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarAsiento_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteAsiento" );
        	  
	    	Map<Object, Object> mapaAsientos = new HashMap<Object, Object>();
	    	mapaAsientos.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaAsientos ); 
            
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
	public boolean ingresarAsiento( Asiento asiento ){
        System.out.println( "DENTRO DE 'ingresarAsiento' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertAsiento" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, asiento );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarAsiento
	 * @param Asiento
	 */
	public boolean modificarAsiento( Asiento asiento ){
        System.out.println( "DENTRO DE 'modificarAsiento' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateAsiento" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, asiento );  
            
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
	 * obtenerListaAsientos
	 * @param codigo
	 */
	public List<Asiento> obtenerListaAsientos(){
        System.out.println( "DENTRO DE 'obtenerListaAsientos' " );
        
        List<Asiento> listaAsiento = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaAsiento" );
        	
        	listaAsiento = (List<Asiento>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaAsiento;
	}

	/**
	 * obtenerObjetoAsiento_x_codigo
	 * @param codigo
	 */
	public Asiento obtenerObjetoAsiento_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoAsiento_x_codigo' " );
		
        Asiento Asiento = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getAsiento" );
 
        	Asiento = (Asiento)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "Asiento: " + Asiento ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return Asiento;	
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
