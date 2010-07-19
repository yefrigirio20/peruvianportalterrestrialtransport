package com.ttporg.pe.servicio.impl;

import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.servicio.PeruvianPortalService;
import com.ttporg.pe.servicio.ServiceFactory;

/**
 * @author Cesar Ricardo.
 * @clase: PeruvianPortalServiceImpl.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public class PeruvianPortalServiceImpl extends ServiceFactory implements PeruvianPortalService{

	/**
	 * loginCliente
	 * @param  cliente
	 * @return Cliente
	 */
	public Cliente loginCliente( Cliente cliente ){
		Cliente objCliente = this.getClienteDAO().loginCliente( cliente );
		return objCliente;
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
