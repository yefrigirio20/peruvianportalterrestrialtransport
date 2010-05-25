package com.ttporg.pe.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ttporg.pe.bean.Usuario;
import com.ttporg.pe.dao.UsuarioDao;

/**
 * @author Cesar Ricardo.
 * @clase: UsuarioDaoImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class UsuarioDaoImpl extends SqlMapClientDaoSupport implements UsuarioDao{
	
	public static final String OBJETO_NEGOCIO = "Usuario";
	
	/**
	 * eliminarUsuario
	 * @param codigo
	 */
	public boolean eliminarUsuario( int codigo ){		
        System.out.println( "DENTRO DE 'eliminarUsuario' " );
        
		boolean mensaje = false;	
				
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "deleteUsuario" );
        	
	    	Map<Object, Object> mapaUsuarios = new HashMap<Object, Object>();
	    	mapaUsuarios.put( "codigoEliminacion", codigo );    //Lo Obtiene por medio del 'KEY = codigoEliminacion'
	    	
            //int estadoEliminacion = this.delete( "deleteUsuario", codigo );  //Tambien puede ser asi y alterando el parametro del xml
            int estadoEliminacion = getSqlMapClientTemplate().delete( nombReferMetodoMapeado, mapaUsuarios ); 
            
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
	 * ingresarUsuario
	 */
	public boolean ingresarUsuario( Usuario usuario ){
        System.out.println( "DENTRO DE 'ingresarUsuario' " );
        
		boolean mensaje = false;	
		
		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "insertUsuario" );
        	
            Usuario objUsuario = (Usuario)getSqlMapClientTemplate().insert( nombReferMetodoMapeado, usuario );  
            
        	System.out.println( "Obj.Usuario: " + objUsuario ); 
			
        	if( objUsuario != null ){
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
	 * modificarUsuario
	 */
	public boolean modificarUsuario( Usuario usuario ){  
        System.out.println( "DENTRO DE 'modificarUsuario' " );
		
		boolean mensaje = false;					

		try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "updateUsuario" );
        	
            Integer estadoGuardar = (Integer)getSqlMapClientTemplate().update( nombReferMetodoMapeado, usuario );  
            
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
	 * obtenerObjetoUsuario
	 */
	public Usuario obtenerObjetoUsuario( int codigo ){
        System.out.println( "DENTRO DE 'obtenerObjetoUsuario' " );
		
        Usuario usuario = null;
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getUsuario2" );
        	
            //usuario = (Usuario)queryForObject( nombReferMetodoMapeado, codigo );    //FORMA #1
            usuario = (Usuario)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, codigo );   //FORMA #2
             
        	System.out.println( "usuario: " + usuario ); 
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return usuario;	
    }
	
    /**
	 * obtenerListaUsuarios
	 */
	public List<Usuario> obtenerListaUsuarios( int codigo ){
        System.out.println( "DENTRO DE 'obtenerListaUsuarios' " );
        
        List<Usuario> listaUsuario = null;
        
        try{      
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaUsuario" );
        	
        	listaUsuario = (List<Usuario>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );  
        	
        	/*
        	for( int i=0; i<listaUsuario.size(); i++ ){
				 Usuario usuario = (Usuario)listaUsuario.get( i );
				 System.out.println( "Nombres: " + usuario.getNombres() );
			}   
			*/     	
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaUsuario;	
	}

    /**
	 * obtenerListaUsuariosPorEstado
	 */
	public List<Usuario> obtenerListaUsuariosPorEstado( String estado ){
        System.out.println( "DENTRO DE 'obtenerListaUsuariosPorEstado' " );
        
        List<Usuario> listaUsuarioPorEstado = null;
        
        try{
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaUsuarioPorEstado" );
        	
        	listaUsuarioPorEstado = (List<Usuario>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, estado );  
        	
        	/*
        	for( int i=0; i<listaUsuario.size(); i++ ){
				 Usuario usuario = (Usuario)listaUsuario.get( i );
				 System.out.println( "Nombres: " + usuario.getNombres() );
			}   
			*/     	
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaUsuarioPorEstado;	
	}

    /**
	 * obtenerNombreApellidoUsuarios
	 */
	public List<Usuario> obtenerNombreApellidoUsuarios(){
        System.out.println( "DENTRO DE 'obtenerNombreApellidoUsuarios' " );
        
        List<Usuario> listaNombreApellidoUsuarios = null;
        
        try{  
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getListaNombreApellidoUsuario" );
        	
        	listaNombreApellidoUsuarios = (List<Usuario>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, null );  
        } 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaNombreApellidoUsuarios;			
	}	
	
    /**
	 * obtenerListaUsuarioFiltroNombreApellido
	 */
	public List<Usuario> obtenerListaUsuarioFiltroNombreApellido( int codigo ){
        System.out.println( "DENTRO DE 'obtenerListaUsuarioFiltroNombreApellido' " );
		
        List<Usuario> listaUsuarioFiltroNombreApellido = null;
        
        try{  
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getUsuario2" );
        	
            //listaUsuarioFiltroNombreApellido = (List<Usuario>)queryForList( nombReferMetodoMapeado, codigo );    //FORMA #1
        	listaUsuarioFiltroNombreApellido = (List<Usuario>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, codigo );   //FORMA #2
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaUsuarioFiltroNombreApellido;	
    }
    
	/**
	 * obtenerListaFiltrosUsuarios
	 */
	public List<Usuario> obtenerListaFiltrosUsuarios( Usuario usuario ){
        System.out.println( "DENTRO DE 'obtenerListaFiltrosUsuarios' " );
        
        List<Usuario> listaFiltrosUsuarios = null;
        
        try{ 
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getFiltrosUsuarios" );
        	
	        //Aplicando Comodin en 'Nombres'
	        if( (usuario.getNombres() != null) && (usuario.getApellidos() != null) ){        	
	        	String nombreFiltro = ("%" + usuario.getNombres() + "%"); 
	        	usuario.setNombres( nombreFiltro );
	        } 
	        else{
	        	usuario.setNombres( null ); 
	        }
	        
	        //Aplicando Comodin en 'Apellidos'
	        if( (usuario.getApellidos() != null) && (usuario.getApellidos() != null) ){        	
	        	String apellidoFiltro = ("%" + usuario.getApellidos() + "%"); 
	        	usuario.setApellidos( apellidoFiltro );        
	        } 
	        else{
	        	usuario.setApellidos( null ); 
	        }
	        
        	listaFiltrosUsuarios = (List<Usuario>)getSqlMapClientTemplate().queryForList( nombReferMetodoMapeado, usuario );   //FORMA #2
 		} 
        catch( Exception e ){
			   e.printStackTrace();
		}	

        return listaFiltrosUsuarios;		
	}

	/**
	 * loginUsuario
	 */
	public Usuario loginUsuario( Usuario usuario ){
        System.out.println( "DENTRO DE 'loginUsuario' " );
        
        Usuario objUsuario = null;
              
        try{ 
        	String nombReferMetodoMapeado = this.getObjetoNegocio( "getLoginUsuarios" );
        	
        	objUsuario = (Usuario)getSqlMapClientTemplate().queryForObject( nombReferMetodoMapeado, usuario );  
        } 
        catch( Exception e ){
			   e.printStackTrace();
		}
        
        return objUsuario;
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
