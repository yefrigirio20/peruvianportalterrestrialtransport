package com.ttporg.pe.servicio;

import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Empresa;

/**
  * @author Cesar Ricardo.
 * @clase: PeruvianPortalService.java  
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 */
public interface PeruvianPortalService{
 
	/**
	 * loginEmpresa
	 */
	public Empresa loginEmpresa2( String usuario, String password );
	
	/**
	 * loginCliente
	 */
	public Cliente loginCliente( Cliente cliente );
	
}
