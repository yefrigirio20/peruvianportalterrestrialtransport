package com.ttporg.pe.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.bean.Calendario;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.bean.Vehiculo;

/**
 * @author Cesar Ricardo.
 * @clase: TestObjetosRelaciodos.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class Test_ObjetosRelacionados{
	
	/**
	 * main
	 * @param argumentos
	 */
	public static void main( String[] argumentos ){
		
		Test_ObjetosRelacionados objeto = new Test_ObjetosRelacionados();
		Empresa objEmpresa = null;
		
		//SETEANDO DATOS ...
		objEmpresa = objeto.seteandoObjetos();
		
		//OBTENIENDO DATOS ...
		objeto.obteniendoObjetos( objEmpresa );
	}
	
	/**
	 * seteandoObjetos
	 * @return Empresa
	 **/
	public Empresa seteandoObjetos(){
		
		//Departamento
		Departamento departamento = new Departamento();
		departamento.setId( 1 );
		departamento.setNombre( "Lima" );
		
		//Empresa
		Empresa empresa = new Empresa();
		empresa.setId( 1 );
		empresa.setRazonSocial( "CRUZ DEL SUR" );
		empresa.setTelefono( "4184575"  );
		empresa.setUsuario(  "admin" );
		empresa.setPassword( "admin" );
		//..
		//....  (El seteo de [Agencia] en [Empresas] al Final).
		//......
				
		//Agencia #1
		Agencia agencia_01 = new Agencia();
		agencia_01.setId( 1 );
		agencia_01.setNombre( "AGENCIA #1" );
		//..
		//....  (El seteo de [Servicios] en [Agencia] al Final).
		//......
		
		//Servicio #1
		Servicio servicio_01 = new Servicio();
		servicio_01.setId(     1 );
		servicio_01.setNombre( "ROYAL CLASS" );
		//..
		//....  (El seteo de [Salida] en [Servicio] al Final).
		//......
		
		//Salida #1
		Salida salida_01 = new Salida();
		salida_01.setId( 1 );
		salida_01.setDepartamentoSalida(  "LIMA"     );
		salida_01.setDepartamentoDestino( "AREQUIPA" );
		//..
		//....  (El seteo de [Calendario] en [Salida] al Final).
		//......
				
		//Calendario #1 
		Calendario calendario_01 = new Calendario();
		calendario_01.setId( 1 );
		calendario_01.setFechaHoraSalida(  new Date() );
		calendario_01.setFechaHoraLlegada( new Date() );

		//Vehiculo #1
		Vehiculo vehiculo_01 = new Vehiculo();
		vehiculo_01.setId( 1 );
		vehiculo_01.setTipo(   "1 PISO" );
		vehiculo_01.setModelo( "TOYOTA" );
		//..
		//....  (El seteo de [Asiento] en [Vehiculo] al Final).
		//......
		
		//Asiento #1
		Asiento asiento_01 = new Asiento();
		asiento_01.setId( 1 );
		asiento_01.setColumna( "A"  );
		asiento_01.setFila(    "10" );
		asiento_01.setEstado(  true );
		
		//Asiento #2
		Asiento asiento_02 = new Asiento();
		asiento_02.setId( 2 );
		asiento_02.setColumna( "A"  );
		asiento_02.setFila(    "9"  );
		asiento_02.setEstado(  true );
		
		//Asiento #3
		Asiento asiento03 = new Asiento();
		asiento03.setId( 3 );
		asiento03.setColumna( "A"  );
		asiento03.setFila(    "5"  );
		asiento03.setEstado(  true );
		
		//Cliente
		Cliente cliente_01 = new Cliente();
		cliente_01.setId(        1 );
		cliente_01.setNombres(   "Felipe Carlos"   );
		cliente_01.setApellidos( "Sebastiani Vera" );
		cliente_01.setUsuario(   "fsebastiani"     );
		cliente_01.setPassword(  "12345678"        );
	
		//----- Agregando: [Agencia] en [Empresa] -----//
		List<Agencia> listaAgencia = new ArrayList<Agencia>();
		listaAgencia.add( agencia_01 );
		
		empresa.setListaAgencias( listaAgencia );
		
		//----- Agregando: [Servicio] en [Agencia] -----//
		List<Servicio> listaServicio = new ArrayList<Servicio>();
		listaServicio.add( servicio_01 );
		
		agencia_01.setListaServicios( listaServicio );
		
		//----- Agregando: [Salida] en [Servicio] -----//
		List<Salida> listaSalida = new ArrayList<Salida>();
		listaSalida.add( salida_01 );
		
		servicio_01.setListaSalidas( listaSalida );		
		
		//----- Agregando: [Calendario] en [Salida] -----//
		List<Calendario> listaCalendario = new ArrayList<Calendario>();
		listaCalendario.add( calendario_01 );
		
		salida_01.setListaCalendarioSalidas( listaCalendario );
		
		//----- Agregando: [Vehiculo] en [Servicio] -----//
		List<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();
		listaVehiculo.add( vehiculo_01 );
		
		servicio_01.setVehiculo( listaVehiculo.get( 0 ) );
		
		//----- Agregando: [Asiento] en [Vehiculo] -----//
		List<Asiento> listaAsiento = new ArrayList<Asiento>();
		listaAsiento.add( asiento_01 );
		listaAsiento.add( asiento_02 );
		
		vehiculo_01.setListaAsientos( listaAsiento );		
		
		//----- Agregando: [Cliente] en [Empresa] -----//
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		listaCliente.add( cliente_01 );
		
		empresa.setListaClientes( listaCliente );
		
		return empresa;
	}
	
	/**
	 * obteniendoObjetos
	 */
	public void obteniendoObjetos( Empresa empresa ){
		
		System.out.println( "" );
		System.out.println( "*********** IMPRESIÓN DE DATOS ***********" );
		
		int           idEmpresa    = empresa.getId();
		String        razonSocial  = empresa.getRazonSocial(); 
		
		List<Agencia> listaAgencia = empresa.getListaAgencias();
		List<Cliente> listaCliente = empresa.getListaClientes();
				
		System.out.println( " - Id.Empresa:     " + idEmpresa   );
		System.out.println( " - Razon Social:   " + razonSocial );
		
		for( int i=0; i<listaAgencia.size(); i++ ){
			 Agencia objAgencia = listaAgencia.get( i );
			 
			 int    idAgencia  = objAgencia.getId(); 
			 String nomAgencia = objAgencia.getNombre();
			 
			 List<Servicio> listaServicio = objAgencia.getListaServicios();
			 
			 System.out.println( " - Id.Agencia:     " + idAgencia  );
			 System.out.println( " - Nomb.Agencia:   " + nomAgencia );			 
			 
			 for( int j=0; j<listaServicio.size(); j++ ){
				  Servicio objServicio = listaServicio.get( j );
				  
				  int    idServicio  = objServicio.getId();
				  String nomServicio = objServicio.getNombre();
				  
				  List<Salida>   listaSalida   = objServicio.getListaSalidas();
				  Vehiculo  listaVehiculo = objServicio.getVehiculo();
				  
				  System.out.println( " - Id.Servicio:    " + idServicio  );
				  System.out.println( " - Nomb.Servicio:  " + nomServicio );
				  
				  for( int x=0; x<listaSalida.size(); x++ ){
					   Salida objSalida = listaSalida.get( x );
					   
					   int    idSalida   = objSalida.getId();
					   String depSalida  = objSalida.getDepartamentoSalida();
					   String depDestino = objSalida.getDepartamentoDestino();
					   
					   List<Calendario> listaCalendario = objSalida.getListaCalendarioSalidas();
					   
					   System.out.println( " - Id.Salida:      " + idSalida   );
					   System.out.println( " - Dep.Salida:     " + depSalida  );
					   System.out.println( " - Dep.Destino:    " + depDestino );
					   
					   for( int z=0; z<listaCalendario.size(); z++ ){
						   Calendario objCalendario = listaCalendario.get( z );
						   
						   int   idCalendario = objCalendario.getId();
						   Date  fechaSalida  = objCalendario.getFechaHoraSalida();
						   Date  fechaLlegada = objCalendario.getFechaHoraLlegada();
						   int   duracion     = objCalendario.getDuracion(); 
						   
						   System.out.println( " - Id.Calendario:  " + idCalendario );
						   System.out.println( " - Fec.Salida:     " + fechaSalida  );
						   System.out.println( " - Fec.Llegada:    " + fechaLlegada );
						   System.out.println( " - Duracion Viaje: " + duracion     );
					   }					   
				  }
				  
				 // for( int y=0; y<listaVehiculo.size(); y++ ){
					   Vehiculo objVehiculo = listaVehiculo;
					   
					   int    idVehiculo  = objVehiculo.getId();
					   String modVehiculo = objVehiculo.getModelo();
					   
					   List<Asiento> listaAsientos = objVehiculo.getListaAsientos();
					   
					   System.out.println( " - Id.Vehiculo:    " + idVehiculo  );
					   System.out.println( " - Mod.Vehiculo:   " + modVehiculo );
					   
					   for( int w=0; w<listaAsientos.size(); w++ ){
						    Asiento objAsiento = listaAsientos.get( w );
						    
						    int    idAsiento  = objAsiento.getId();
						    String nomFila    = objAsiento.getFila();
						    String nomColumna = objAsiento.getColumna();
						    
							System.out.println( " - Id.Asiento:     " + idAsiento  );
							System.out.println( " - Nom.Fila:       " + nomFila    );
							System.out.println( " - Nom.Columna:    " + nomColumna );
					   }
				  //}
			 }	
		}
		
		for( int t=0; t<listaCliente.size(); t++ ){
			 Cliente objCliente = listaCliente.get( t );
			 
			 int    idCliente   = objCliente.getId();
			 String nomCliente  = objCliente.getNombres();
			 String apeCliente  = objCliente.getApellidos();
			 String usuCliente  = objCliente.getUsuario();
			 String passCliente = objCliente.getPassword();
			 
			 System.out.println( " - Id.Cliente:     " + idCliente   );
			 System.out.println( " - Nom.Cliente:    " + nomCliente  );
			 System.out.println( " - Nom.Cliente:    " + apeCliente  );
			 System.out.println( " - Usu.Cliente:    " + usuCliente  );
			 System.out.println( " - Pass.Cliente:   " + passCliente );
		}
		
		System.out.println( "*******************************************" );
	}
	
}


