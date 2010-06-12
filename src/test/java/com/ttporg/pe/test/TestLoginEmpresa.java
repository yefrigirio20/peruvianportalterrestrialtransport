package com.ttporg.pe.test;

import org.junit.Assert;
import org.junit.Test;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.servicio.EmpresaService;
import com.ttporg.pe.servicio.impl.EmpresaServiceImpl;
import com.ttporg.pe.util.UtilEncriptacion;

public class TestLoginEmpresa{

	private UtilEncriptacion utilEncriptacion = null;
	private EmpresaService   empresaService   = null;

	{
	 this.utilEncriptacion = new UtilEncriptacion();
	}

	/**
     * main
     * @param argumentos
     */
    public static void main( String[] argumentos ){
        //Permite mostrar el resultado del 'Test' en consola.
        org.junit.runner.JUnitCore.main( "com.ttporg.pe.test.TestLoginEmpresa" );
    }

    @Test
	public void testLoginEmpresa(){

    	try{
    		this.empresaService = new EmpresaServiceImpl();

    		String cadena = "";

    		Empresa empresa =  new Empresa();
    		empresa.setUsuario(  "RGUERRA" );
    		empresa.setPassword( "SqrAquYuou8=" );    //Password 'ENCRIPTADO' y guardado en la 'BD'.

    		empresa = this.empresaService.loginEmpresa( empresa );

    		System.out.println( "Empresa: " + empresa );

    		//----------------------------------------------------------//
    		cadena = this.utilEncriptacion.encriptarCIPHER( "ADMIN" );	 //ADMIN = SqrAquYuou8=
    		System.out.println( "CADENA ENCRIPTADA: " + cadena );

    		cadena = this.utilEncriptacion.desencriptarCIPHER( cadena );
    		System.out.println( "CADENA DESENCRIPTADA: " + cadena );
    		//----------------------------------------------------------//

    		//Test ok si el servicio responde un objeto cargado de la DB.
    		Assert.assertNotNull( "OBJETO DEVUELTO: ", empresa  );
    	}
    	catch( Exception e ){
			   e.printStackTrace();
		}
	}

}

