package com.ttporg.pe.dao;

import java.util.List;
import com.ttporg.pe.bean.Departamento;
 
/**
 * @author Cesar Ricardo.
 * @clase: DepartamentoDao.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public interface DepartamentoDao{
 
	/**
	 * obtenerObjetoDepartamento_x_codigo
	 */
	public Departamento obtenerObjetoDepartamento_x_codigo( int codigo );

	/**
	 * obtenerListaDepartamentos
	 */
	public List<Departamento> obtenerListaDepartamentos();

	/**
	 * eliminarDepartamento_x_codigo
	 */
	public boolean eliminarDepartamento_x_codigo( int codigo );

	/**
	 * ingresarDepartamento
	 */
	public boolean ingresarDepartamento( Departamento Departamento );

	/**
	 * modificarDepartamento
	 */
	public boolean modificarDepartamento( Departamento Departamento );
 
}
