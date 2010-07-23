package com.ttporg.pe.servicio;

import java.util.List;
import com.ttporg.pe.bean.Empresa;

/**
 * @author Cesar Ricardo.
 * @clase: UsuarioService.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public interface EmpresaService{

	/**
	 * obtenerObjetoEmpresa_x_codigo
	 */
	public Empresa obtenerObjetoEmpresa_x_codigo( int codigo );

	/**
	 * obtenerListaEmpresas
	 */
	public List<Empresa> obtenerListaEmpresas();

	/**
	 * obtenerListaEmpresas_x_departamento
	 */
	public List<Empresa> obtenerListaEmpresas_x_departamento( int codigo );	
	
	/**
	 * eliminarEmpresa_x_codigo
	 */
	public boolean eliminarEmpresa_x_codigo( int codigo );

	/**
	 * ingresarEmpresa
	 */
	public boolean ingresarEmpresa( Empresa empresa );

	/**
	 * modificarEmpresa
	 */
	public boolean modificarEmpresa( Empresa empresa );

	/**
	 * loginEmpresa
	 */
	public Empresa loginEmpresa( Empresa empresa );
	
	/**
	 * loginEmpresa
	 */
	public Empresa loginEmpresa2( String usuario, String password );
 
}
