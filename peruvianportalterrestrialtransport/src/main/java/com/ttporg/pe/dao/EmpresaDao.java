package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.dto.DetallePopupDTO;
 
/**
 * @author Cesar Ricardo.
 * @clase: EmpresaDao.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public interface EmpresaDao{
 
	/**
	 * obtenerObjetoDatosPopup_x_codigoAsiento
	 * @param codigoAsiento
	 **/
	public DetallePopupDTO obtenerObjetoDatosPopup_x_codigoAsiento( int codigoAsiento );
	
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
	 * loginEmpresa2
	 */
	public Empresa loginEmpresa2( String usuario, String password );
 
}
