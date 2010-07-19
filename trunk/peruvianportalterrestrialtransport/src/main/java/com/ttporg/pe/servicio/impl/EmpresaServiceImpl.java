package com.ttporg.pe.servicio.impl;

import java.util.List;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.servicio.EmpresaService;
import com.ttporg.pe.servicio.ServiceFactory;

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
public class EmpresaServiceImpl extends ServiceFactory implements EmpresaService{	
	
	public EmpresaServiceImpl(){
	}
	
	/**
	 * eliminarEmpresa_x_codigo
	 * @param  codigo
	 * @return boolean
	 */
	public boolean eliminarEmpresa_x_codigo( int codigo ){
		boolean estado = this.getEmpresaDAO().eliminarEmpresa_x_codigo( codigo );
		return  estado;
	}
	
	/**
	 * ingresarEmpresa
	 * @param  empresa
	 * @return boolean
	 */
	public boolean ingresarEmpresa( Empresa empresa ){
		boolean estado = this.getEmpresaDAO().ingresarEmpresa( empresa );
		return  estado;
	}
	
	/**
	 * loginEmpresa
	 * @param  empresa
	 * @return Empresa
	 */
	public Empresa loginEmpresa( Empresa empresa ){
		Empresa objEmpresa = this.getEmpresaDAO().loginEmpresa( empresa );
		return  objEmpresa;
	}
	
	/**
	 * modificarEmpresa
	 * @param  empresa
	 * @return boolean
	 */
	public boolean modificarEmpresa( Empresa empresa ){
		boolean estado = this.getEmpresaDAO().modificarEmpresa( empresa );
		return  estado;
	}
	
	/**
	 * obtenerListaEmpresas
	 * @param  codigo
	 * @return List<Empresa>
	 */
	public List<Empresa> obtenerListaEmpresas(){
		List<Empresa> listaEmpresa = this.getEmpresaDAO().obtenerListaEmpresas();
		return listaEmpresa;
	}
	
	/**
	 * obtenerObjetoEmpresa_x_codigo
	 * @param  codigo
	 * @return Empresa
	 */
	public Empresa obtenerObjetoEmpresa_x_codigo( int codigo ){
		Empresa objEmpresa = this.getEmpresaDAO().obtenerObjetoEmpresa_x_codigo( codigo );
		return  objEmpresa;
	}

	/**
	 * loginEmpresa2
	 * @param  usuario
	 * @param  password
	 * @return Empresa
	 */
	public Empresa loginEmpresa2( String usuario, String password ){
		Empresa objEmpresa = this.getEmpresaDAO().loginEmpresa2( usuario, password );
		return  objEmpresa;
	}
 
 }
