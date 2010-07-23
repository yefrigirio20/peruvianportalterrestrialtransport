package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.dao.EmpresaDao;

/**
 * @author Cesar Ricardo.
 * @clase: EmpresaDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class EmpresaDaoImpl extends SqlMapClientDaoSupport implements EmpresaDao{
	
	public static final String OBJETO_NEGOCIO = "Empresa";
 
	/**
	 * eliminarEmpresa_x_codigo
	 * @param codigo
	 */
	public boolean eliminarEmpresa_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'eliminarEmpresa_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteEmpresa" );
        	 
	    	Map<Object, Object> mapaEmpresas = new HashMap<Object, Object>();
	    	mapaEmpresas.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaEmpresas ); 
            
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
	public boolean ingresarEmpresa( Empresa empresa ){
        System.out.println( "DENTRO DE 'ingresarEmpresa' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertEmpresa" );
        	
            Empresa objEmpresa = (Empresa)getSqlMapClientTemplate().insert( nombReferMetodoMapeado, empresa );  
            
        	System.out.println( "objEmpresa: " + objEmpresa ); 
			
        	if( objEmpresa != null ){
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
	 * loginEmpresa
	 * @param empresa
	 */
	public Empresa loginEmpresa( Empresa empresa ){
        System.out.println( "DENTRO DE 'loginUsuario' " );
        
        Empresa objEmpresa = null;
              
        try{ 
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getLoginEmpresas" );
        	
        	objEmpresa = (Empresa)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, empresa );  
        } 
        catch( Exception e ){
			   e.printStackTrace();
		}
        
        return objEmpresa;
	}
	
	/**
	 * modificarEmpresa
	 * @param empresa
	 */
	public boolean modificarEmpresa( Empresa empresa ){
        System.out.println( "DENTRO DE 'modificarEmpresa' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateEmpresa" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, empresa );  
            
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
	 * obtenerListaEmpresas
	 */
	public List<Empresa> obtenerListaEmpresas(){
        System.out.println( "DENTRO DE 'obtenerListaEmpresas' " );
        
        List<Empresa> listaEmpresa = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaEmpresa" );
        	
        	listaEmpresa = (List<Empresa>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaEmpresa;
	}

    /**
     * obtenerListaEmpresas_x_departamento
     */
	public List<Empresa> obtenerListaEmpresas_x_departamento( int codigo ){
        System.out.println( "DENTRO DE 'obtenerListaEmpresas_x_departamento' " );
        
        List<Empresa> listaEmpresa = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaEmpresa_x_departamento" );
        	
        	listaEmpresa = (List<Empresa>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaEmpresa;
	}
	
	/**
	 * obtenerObjetoEmpresa_x_codigo
	 * @param codigo
	 */
	public Empresa obtenerObjetoEmpresa_x_codigo( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoEmpresa_x_codigo' " );
		
        Empresa empresa = null;
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getEmpresa" );
 
        	empresa = (Empresa)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "Empresa: " + empresa ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return empresa;	
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
	 * loginEmpresa2
	 */
	public Empresa loginEmpresa2( String usuario, String password ){
 
	        System.out.println( "DENTRO DE 'loginUsuario' " );
	        
	        Empresa objEmpresa = new Empresa(); 
	        
	        objEmpresa.setUsuario(  usuario  );
	        objEmpresa.setPassword( password );
	              
	        try{ 
	        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getLoginEmpresas" );
	        	
	        	objEmpresa = (Empresa)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, objEmpresa );  
	        } 
	        catch( Exception e ){
				   e.printStackTrace();
			}
	        
	        return objEmpresa;
		}

}
