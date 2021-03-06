package com.ttporg.pe.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.dao.SalidaDao;
import com.ttporg.pe.dto.DetalleAsientoDTO;
import com.ttporg.pe.dto.DetallePasajeDTO;

/**
 * @author Cesar Ricardo.
 * @clase: SalidaDaoImpl.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class SalidaDaoImpl extends SqlMapClientDaoSupport implements SalidaDao{
	
	public static final String OBJETO_NEGOCIO  = "Salida";
	public static final String OBJETO_NEGOCIO2 = "DetallePasajeDTO";
	public static final String OBJETO_NEGOCIO3 = "DetalleAsientoDTO";

	private BaseBean  beanBase = null;
	
	{
	 this.beanBase = new BaseBean();
	}
	
	/**
	 * eliminarSalida_x_codigo
	 * @param codigo
	 **/
	public boolean eliminarSalida_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'eliminarSalida_x_codigo' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteSalida" );
        	  
	    	Map<Object, Object> mapaSalidas = new HashMap<Object, Object>();
	    	mapaSalidas.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
 
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaSalidas ); 
            
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
	public boolean ingresarSalida( Salida Salida ){
        this.imprimeLog( "DENTRO DE 'ingresarSalida' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertSalida" );
     	
        	this.getSqlMapClientTemplate().insert( nombReferMetodoMapeado, Salida );
        		
        	mensaje = true;	 					
		}
		catch( Exception e ){
	           e.printStackTrace();
	           mensaje = false;	
		}
		
		return  mensaje;  
	}
 	
	/**
	 * modificarSalida
	 * @param Salida
	 */
	public boolean modificarSalida( Salida Salida ){
        this.imprimeLog( "DENTRO DE 'modificarSalida' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateSalida" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, Salida );  
            
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
	 * obtenerListaSalidas
	 * @param codigo
	 */
	public List<Salida> obtenerListaSalidas(){
        this.imprimeLog( "DENTRO DE 'obtenerListaSalidas' " );
        
        List<Salida> listaSalida = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaSalida" );
        	
        	listaSalida = (List<Salida>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado );  
		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaSalida;
	}

	/**
	 * obtenerObjetoSalida_x_codigo
	 * @param codigo
	 **/
	public Salida obtenerObjetoSalida_x_codigo( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerObjetoSalida_x_codigo' " );
		
        Salida salida = null; 
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getSalida" );
 
        	salida = (Salida)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	this.imprimeLog( "Salida: " + salida ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return salida;	
	}	

	/**
	 * obtenerListaSalida_x_idServicio
	 * @param codigo
	 **/
	public List<Salida> obtenerListaSalida_x_idServicio( int codigo ){
        this.imprimeLog( "DENTRO DE 'obtenerListaSalida_x_idServicio' " );
		
        List<Salida> listaSalida = null;
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaSalida_x_idServicio" );
 
        	listaSalida = (List<Salida>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );   //FORMA #2
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaSalida;	
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
	 * getObjetoNegocio2
	 * @param nombReferMetodoMapeado
	 * @return
	 */
	private String getObjetoNegocio2( String nombReferMetodoMapeado ){
		
		String nombObjNegocio = (OBJETO_NEGOCIO2 + "." + nombReferMetodoMapeado);
		
		return nombObjNegocio;
	}

	/**
	 * getObjetoNegocio3
	 * @param nombReferMetodoMapeado
	 * @return
	 */
	private String getObjetoNegocio3( String nombReferMetodoMapeado ){
		
		String nombObjNegocio = (OBJETO_NEGOCIO3 + "." + nombReferMetodoMapeado);
		
		return nombObjNegocio;
	}	
	
	/**
	 * obtenerListaDetallePasajeDTO
	 * @param  idEmpresa
	 * @param  idAgencia
	 * @param  idServicio
	 * @param  departamentoSalida
	 * @param  departamentoDestino
	 * @param  fechaHoraSalida
	 * @return List<DetallePasajeDTO>
	 */
	public List<DetallePasajeDTO> obtenerListaDetallePasajeDTO( int idEmpresa, int idAgencia, int idServicio, 
			                                                    String departamentoSalida, String departamentoDestino, 
			                                                    Date fechaHoraSalida ){
        this.imprimeLog( "DENTRO DE 'obtenerListaDetallePasajeDTO' " );
        
        List<DetallePasajeDTO> listaDetallePasajeDTO = null;
         
        DetallePasajeDTO objDetallePasajeDTO = new DetallePasajeDTO();
        
        objDetallePasajeDTO.setIdEmpresa(           idEmpresa  );
        objDetallePasajeDTO.setIdAgencia(           idAgencia  );
        objDetallePasajeDTO.setIdServicio(          idServicio );
        objDetallePasajeDTO.setDepartamentoSalida(  departamentoSalida  );
        objDetallePasajeDTO.setDepartamentoDestino( departamentoDestino );
        objDetallePasajeDTO.setFechaHoraSalida(     fechaHoraSalida     );
                
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio2( "getListaDetallePasaje" );
        	
        	listaDetallePasajeDTO = (List<DetallePasajeDTO>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, objDetallePasajeDTO );  
        } 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaDetallePasajeDTO;
	}

	/**
	 * obtenerListaDetalleAsientoDTO
	 * @param idServicio
	 **/
	public List<DetalleAsientoDTO> obtenerListaDetalleAsientoDTO( int idServicio ){
        this.imprimeLog( "DENTRO DE 'obtenerListaDetalleAsientoDTO' " );
        
        List<DetalleAsientoDTO> listaDetalleAsientoDTO = null; 
                 
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio3( "getListaDetalleAsiento2" );
        	
        	DetalleAsientoDTO objDetalleAsientoDTO = new DetalleAsientoDTO();
        	
        	objDetalleAsientoDTO.setIdServicio( idServicio );
        	
        	listaDetalleAsientoDTO = (List<DetalleAsientoDTO>)this.getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, objDetalleAsientoDTO );  
            
        	this.imprimeLog( "listaDetalleAsientoDTO A: " + listaDetalleAsientoDTO.size() );
        } 
        catch( Exception e ){
			   e.printStackTrace();
		}	
 
        return listaDetalleAsientoDTO;
	}
	
	/**
	 * this.imprimeLog
	 * @param mensaje
	 **/
	public void imprimeLog( String mensaje ){ 
		this.beanBase.imprimeLog( mensaje, this.getClass().toString() );
	}
	
}
