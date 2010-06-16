package com.ttporg.pe.servicio.impl;

import java.util.List;

import com.ttporg.pe.bean.Usuario;
import com.ttporg.pe.servicio.ServiceFactory;
import com.ttporg.pe.servicio.UsuarioService;

/**
 * @author Cesar Ricardo.
 * @clase: UsuarioServiceImpl.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class UsuarioServiceImpl extends ServiceFactory implements UsuarioService{	
	
	public UsuarioServiceImpl(){
	}
	
	/**
	 * obtenerListaUsuarios
	 * @param codigo
	 */
	public List<Usuario> obtenerListaUsuarios( int codigo ){
		List<Usuario> lista = this.getUsuarioDAO().obtenerListaUsuarios( codigo );
		return lista;
	}
	
	/**
	 * eliminarUsuario
	 * @param codigo
	 */
	public boolean eliminarUsuario( int codigo ){
		boolean estado = this.getUsuarioDAO().eliminarUsuario( codigo );
		return  estado;
	}
	
	/**
	 * ingresarUsuario
	 * @param usuario
	 */
	public boolean ingresarUsuario( Usuario usuario ){
		boolean estado = this.getUsuarioDAO().ingresarUsuario( usuario );
		return  estado;
	}
	
	/**
	 * modificarUsuario
	 * @param usuario
	 */
	public boolean modificarUsuario( Usuario usuario ){
		boolean estado = this.getUsuarioDAO().modificarUsuario( usuario );
		return  estado;
	}

	/**
	 * obtenerListaFiltrosUsuarios
	 * @param usuario
	 */
	public List<Usuario> obtenerListaFiltrosUsuarios( Usuario usuario ){
		List<Usuario> lista = this.getUsuarioDAO().obtenerListaFiltrosUsuarios( usuario );
		return lista;
	}
	
	/**
	 * obtenerListaUsuarioFiltroNombreApellido
	 * @param codigo
	 */
	public List<Usuario> obtenerListaUsuarioFiltroNombreApellido( int codigo ){
		List<Usuario> lista = this.getUsuarioDAO().obtenerListaUsuarioFiltroNombreApellido( codigo );
		return lista;
	}
	
	/**
	 * obtenerListaUsuarioFiltroNombreApellido
	 * @param estado
	 */
	public List<Usuario> obtenerListaUsuariosPorEstado( String estado ){
		List<Usuario> lista = this.getUsuarioDAO().obtenerListaUsuariosPorEstado( estado );
		return lista;
	}
	
	/**
	 * obtenerNombreApellidoUsuarios
	 */
	public List<Usuario> obtenerNombreApellidoUsuarios(){
		List<Usuario> lista = this.getUsuarioDAO().obtenerNombreApellidoUsuarios();
		return lista;
	}
	
	/**
	 * obtenerObjetoUsuario
	 * @param codigo
	 */
	public Usuario obtenerObjetoUsuario( int codigo ){
		Usuario objUsuario = this.getUsuarioDAO().obtenerObjetoUsuario( codigo );
		return  objUsuario;
	}

	/**
	 * loginUsuario
	 * @param codigo
	 */
	public Usuario loginUsuario( Usuario usuario ){
		Usuario objUsuario = this.getUsuarioDAO().loginUsuario( usuario );
		return  objUsuario;
	}
	
 }
