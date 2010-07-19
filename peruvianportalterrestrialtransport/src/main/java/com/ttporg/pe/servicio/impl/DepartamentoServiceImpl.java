package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.servicio.DepartamentoService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: DepartamentoServiceImpl.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class DepartamentoServiceImpl extends ServiceFactory implements DepartamentoService{	
	
	public DepartamentoServiceImpl(){
	}
 
	/**
	 * eliminarDepartamento_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarDepartamento_x_codigo( int codigo ){
		boolean estado = this.getDepartamentoDAO().eliminarDepartamento_x_codigo( codigo );
		return estado;
	}
	
	/**
	 * ingresarDepartamento
	 * @param  departamento
	 * @return estado
	 */
	public boolean ingresarDepartamento( Departamento departamento ){
		boolean estado = this.getDepartamentoDAO().ingresarDepartamento( departamento );
		return estado;
	}
	
	/**
	 * modificarDepartamento
	 * @param  departamento
	 * @return estado
	 */
	public boolean modificarDepartamento( Departamento departamento ){
		boolean estado = this.getDepartamentoDAO().modificarDepartamento( departamento );
		return estado;
	}
	
	/**
	 * obtenerListaDepartamentos
	 * @return List<Departamento>
	 */
	public List<Departamento> obtenerListaDepartamentos(){
		List<Departamento> listaDepartamento = this.getDepartamentoDAO().obtenerListaDepartamentos();
		return listaDepartamento;
	}
	
	/**
	 * obtenerObjetoDepartamento_x_codigo
	 * @param  codigo
	 * @return Departamento
	 */
	public Departamento obtenerObjetoDepartamento_x_codigo( int codigo ){
		Departamento departamento = this.getDepartamentoDAO().obtenerObjetoDepartamento_x_codigo( codigo );
		return departamento;
	} 
	
 }
