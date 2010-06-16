package com.ttporg.pe.dao;

import java.util.List;

import com.ttporg.pe.bean.Usuario;
 
/**
 * @author Cesar Ricardo.
 * @clase: UsuarioDao.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public interface UsuarioDao{
 

	/**
	 * obtenerObjetoUsuario
	 */
	public Usuario obtenerObjetoUsuario( int codigo );

	/**
	 * obtenerListaUsuarios
	 */
	public List<Usuario> obtenerListaUsuarios( int codigo );

	/**
	 * obtenerListaUsuarios por estado
	 */
	public List<Usuario> obtenerListaUsuariosPorEstado( String estado );

	/**
	 * obtenerNombreApellidoUsuarios
	 */
	public List<Usuario> obtenerNombreApellidoUsuarios();

	/**
	 * obtenerListaUsuarioFiltroNombreApellido
	 */
	public List<Usuario> obtenerListaUsuarioFiltroNombreApellido( int codigo );

	/**
	 * obtenerListaUsuarioFiltroNombreApellido
	 */
	public List<Usuario> obtenerListaFiltrosUsuarios( Usuario usuario );

	/**
	 * eliminarUsuario
	 */
	public boolean eliminarUsuario( int codigo );

	/**
	 * ingresarUsuario
	 */
	public boolean ingresarUsuario( Usuario usuario );

	/**
	 * modificarUsuario
	 */
	public boolean modificarUsuario( Usuario usuario );

	/**
	 * loginUsuario
	 */
	public Usuario loginUsuario( Usuario usuario );
 
}
