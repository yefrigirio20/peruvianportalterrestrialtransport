package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.dao.DepartamentoDao;

/**
 * @author Cesar Ricardo.
 * @clase: DepartamentoDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class DepartamentoDaoImpl extends SqlMapClientDaoSupport implements DepartamentoDao{
	
	public static final String OBJETO_NEGOCIO = "Departamento";

	/**
	 * eliminarDepartamento_x_codigo
	 * @param codigo
	 */
	public boolean eliminarDepartamento_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarDepartamento_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteDepartamento" );
        	  
	    	Map<Object, Object> mapaDepartamentos = new HashMap<Object, Object>();
	    	mapaDepartamentos.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaDepartamentos ); 
            
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
	public boolean ingresarDepartamento( Departamento Departamento ){
        System.out.println( "DENTRO DE 'ingresarDepartamento' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertDepartamento" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, Departamento );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarDepartamento
	 * @param Departamento
	 */
	public boolean modificarDepartamento( Departamento Departamento ){
        System.out.println( "DENTRO DE 'modificarDepartamento' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateDepartamento" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, Departamento );  
            
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
	 * obtenerListaDepartamentos
	 * @param codigo
	 */
	public List<Departamento> obtenerListaDepartamentos(){
        System.out.println( "DENTRO DE 'obtenerListaDepartamentos' " );
        
        List<Departamento> listaDepartamento = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaDepartamento" );
        	
        	listaDepartamento = (List<Departamento>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaDepartamento;
	}

	/**
	 * obtenerObjetoDepartamento_x_codigo
	 * @param codigo
	 */
	public Departamento obtenerObjetoDepartamento_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoDepartamento_x_codigo' " );
		
        Departamento departamento = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getDepartamento" );
 
        	departamento = (Departamento)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "Departamento: " + departamento ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return departamento;	
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
