package com.ttporg.pe.test;

import java.util.ArrayList;
import java.util.List;

import com.ttporg.pe.bean.Usuario;
import com.ttporg.pe.servicio.UsuarioService;
import com.ttporg.pe.servicio.impl.UsuarioServiceImpl;
import com.ttporg.pe.util.ManejoEncriptacion;

/**
 * @author Cesar Ricardo.
 * @clase: Test.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Test{

	static ManejoEncriptacion xxx = new ManejoEncriptacion(); 
	
	/**
	 * @param argumentos
	 * @throws Exception 
	 */
	public static void main( String[] argumentos ) throws Exception{

		UsuarioService servicio = new UsuarioServiceImpl();
				 
	    Usuario usuario =  new Usuario();
		usuario.setUsuario(  "RGUERRA" );
		usuario.setPassword( "hRoN8ON82Ct/w7wkG7nAuA=="   );
 
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		listaUsuarios = (List<Usuario>)servicio.obtenerListaFiltrosUsuarios( usuario );
		
		//Iterando ...xi
		for( int i=0; i<listaUsuarios.size(); i++ ){
			 Usuario objUsuario = listaUsuarios.get(  i  ); 
			 
			 String nombres   = objUsuario.getNombres();
			 String apellidos = objUsuario.getApellidos();
			 
			 System.out.println( "nombres:   " +  nombres   );
			 System.out.println( "apellidos: " +  apellidos );
		}
		
		String cadena = xxx.encriptarCIPHER( "ADMIN" );		
		System.out.println( "CADENA ENCRIPTADA: " + cadena );
		
		cadena = xxx.desencriptarCIPHER( cadena );
		System.out.println( "CADENA DESENCRIPTADA: " + cadena );
	}
	
}
