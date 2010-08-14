package com.ttporg.pe.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.ttporg.pe.bean.Agencia;
import com.ttporg.pe.bean.Asiento;
import com.ttporg.pe.bean.BaseBean;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.bean.Departamento;
import com.ttporg.pe.bean.Empresa;
import com.ttporg.pe.bean.Pago;
import com.ttporg.pe.bean.Salida;
import com.ttporg.pe.bean.Servicio;
import com.ttporg.pe.bean.Transaccion;
import com.ttporg.pe.bean.Vehiculo;
import com.ttporg.pe.dao.AgenciaDao;
import com.ttporg.pe.dao.AsientoDao;
import com.ttporg.pe.dao.CalendarioDao;
import com.ttporg.pe.dao.ClienteDao;
import com.ttporg.pe.dao.ClientePagoDao;
import com.ttporg.pe.dao.DepartamentoDao;
import com.ttporg.pe.dao.EmpresaDao;
import com.ttporg.pe.dao.PagoDao;
import com.ttporg.pe.dao.SalidaDao;
import com.ttporg.pe.dao.ServicioDao;
import com.ttporg.pe.dao.TransaccionDao;
import com.ttporg.pe.dao.VehiculoDao;
import com.ttporg.pe.dao.impl.AgenciaDaoImpl;
import com.ttporg.pe.dao.impl.AsientoDaoImpl;
import com.ttporg.pe.dao.impl.CalendarioDaoImpl;
import com.ttporg.pe.dao.impl.ClienteDaoImpl;
import com.ttporg.pe.dao.impl.ClientePagoDaoImpl;
import com.ttporg.pe.dao.impl.DepartamentoDaoImpl;
import com.ttporg.pe.dao.impl.EmpresaDaoImpl;
import com.ttporg.pe.dao.impl.PagoDaoImpl;
import com.ttporg.pe.dao.impl.SalidaDaoImpl;
import com.ttporg.pe.dao.impl.ServicioDaoImpl;
import com.ttporg.pe.dao.impl.TransaccionDaoImpl;
import com.ttporg.pe.dao.impl.VehiculoDaoImpl;

/**
 * @author Cesar Ricardo.
 * @clase: UtilGeneraBoletoViaje.java
 * @descripci�n descripci�n de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
 *              http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compa��a del autor.
 * @fecha_de_creaci�n: dd-mm-yyyy.
 * @fecha_de_ultima_actualizaci�n: dd-mm-yyyy.
 * @versi�n 1.0
 **/
public class UtilGeneraBoletoViaje{

	private static final String	RUTA_PATH = System.getProperty( "user.dir" );
	private static final String	FICHERO	  = "Reporte_2010.pdf";
 
	//Service ... 
	//private ServiceFactory    servicio           = null;
	
	//Daos [SPRING] ...
	private ClienteDao        clienteDAO         = null;
	private EmpresaDao        empresaDAO         = null;	
	private DepartamentoDao   departamentoDAO    = null;
	private AgenciaDao        agenciaDAO         = null;		
	private VehiculoDao       vehiculoDAO        = null;	
	private ServicioDao       servicioDAO        = null;
	private AsientoDao        asientoDAO         = null;
	private SalidaDao         salidaDAO          = null;
	private CalendarioDao     calendarioDAO      = null;
	private PagoDao           pagoDAO            = null;
	private ClientePagoDao    clientePagoDAO     = null;
	private TransaccionDao    transaccionDAO     = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario     = null;
	private BaseBean          beanBase           = null;	
		
	{
	 //this.servicio     = new ServiceFactory();
		
	 this.clienteDAO      = new ClienteDaoImpl();
	 this.empresaDAO      = new EmpresaDaoImpl();	
	 this.departamentoDAO = new DepartamentoDaoImpl();
	 this.agenciaDAO      = new AgenciaDaoImpl();		
	 this.vehiculoDAO     = new VehiculoDaoImpl();	
	 this.servicioDAO     = new ServicioDaoImpl();
	 this.asientoDAO      = new AsientoDaoImpl();
	 this.salidaDAO       = new SalidaDaoImpl();
	 this.calendarioDAO   = new CalendarioDaoImpl();
	 this.pagoDAO         = new PagoDaoImpl();
	 this.clientePagoDAO  = new ClientePagoDaoImpl();
	 this.transaccionDAO  = new TransaccionDaoImpl();
 
	 this.utilCalendario  = new UtilCalendario();
	 this.beanBase        = new BaseBean();
	}
	
	//Constructor ...
    public UtilGeneraBoletoViaje( ClienteDao clienteDAO, EmpresaDao empresaDAO, DepartamentoDao departamentoDAO, 
    		                      AgenciaDao agenciaDAO, VehiculoDao vehiculoDAO, ServicioDao servicioDAO, 
    		                      AsientoDao asientoDAO, SalidaDao salidaDAO, CalendarioDao calendarioDAO, 
    		                      PagoDao pagoDAO, ClientePagoDao clientePagoDAO, TransaccionDao transaccionDAO ){
    	
    	 this.clienteDAO      = clienteDAO;
	   	 this.empresaDAO      = empresaDAO;	
		 this.departamentoDAO = departamentoDAO;
		 this.agenciaDAO      = agenciaDAO;		
		 this.vehiculoDAO     = vehiculoDAO;	
		 this.servicioDAO     = servicioDAO;
		 this.asientoDAO      = asientoDAO;
		 this.salidaDAO       = salidaDAO;
		 this.calendarioDAO   = calendarioDAO;
		 this.pagoDAO         = pagoDAO;
		 this.clientePagoDAO  = clientePagoDAO;
		 this.transaccionDAO  = transaccionDAO;
	}

	/**
     * muestraBoletoViaje
     * @param objCliente
     * @param objPago
     * @param idServicio
     * @param idAsientoSeleccionado
     **/
	public void muestraBoletoViaje( Cliente objCliente,        Pago objPago, 
			                        String codigoDepartamento, String codigoEmpresa,
			                        String codigoAgencia,      String codigoServicio, 
			                        String codigoFilaAsiento,  String txtFilaAsiento,         
			                        String codigoAsiento ){
		
		this.imprimeLog( "********* DENTRO DE [muestraBoletoViaje] **********" ); 
		
		String tituloPDF = "...::: BOLETO DE VIAJE :::...";
				
		Departamento   objDepartamento = (Departamento)this.departamentoDAO.obtenerObjetoDepartamento_x_codigo( Integer.parseInt( codigoDepartamento ) );
		Empresa        objEmpresa      = (Empresa)this.empresaDAO.obtenerObjetoEmpresa_x_codigo(        Integer.parseInt( codigoEmpresa  ) );
		Agencia        objAgencia      = (Agencia)this.agenciaDAO.obtenerObjetoAgencia_x_codigo(        Integer.parseInt( codigoAgencia  ) );
		Servicio       objServicio     = (Servicio)this.servicioDAO.obtenerObjetoServicio_x_codigo(     Integer.parseInt( codigoServicio ) );		
		Asiento        objAsiento      = (Asiento)this.asientoDAO.obtenerObjetoAsiento_x_codigo(        Integer.parseInt( codigoFilaAsiento   ) );		
		List<Vehiculo> objVehiculo     = (List<Vehiculo>)this.vehiculoDAO.obtenerListaVehiculo_x_idServicio( Integer.parseInt( codigoServicio ) );
		List<Salida>   objSalida       = (List<Salida>)this.salidaDAO.obtenerListaSalida_x_idServicio(       Integer.parseInt( codigoServicio ) );
		
		this.imprimeLog( "objDepartamento: " + objDepartamento );
		this.imprimeLog( "objEmpresa:      " + objEmpresa  );
		this.imprimeLog( "objAgencia:      " + objAgencia  );
		this.imprimeLog( "objServicio:     " + objServicio );
		this.imprimeLog( "objAsiento:      " + objAsiento  );
		this.imprimeLog( "objVehiculo:     " + objVehiculo.get( 0 ) );
		this.imprimeLog( "objSalida:       " + objSalida.get(   0 ) );
		
		//Seteando datos para la 'TRANSACCION'.
		Transaccion objTransaccion = new Transaccion();
 		
		objTransaccion.setId( 1 );
		objTransaccion.getEmpresa().setDepartamento( objDepartamento );
		objTransaccion.setEmpresa(   objEmpresa  );
		objTransaccion.setCliente(   objCliente  );
		objTransaccion.setAgencia(   objAgencia  );
		objTransaccion.setServicio(  objServicio );
		objTransaccion.setSalida(    objSalida.get( 0 )   );
		objTransaccion.setVehiculo(  objVehiculo.get( 0 ) );
		objTransaccion.setAsiento(   objAsiento  );
		
		//APLICAR GUARDAR EN BD EL OBJETO.
		String saltoLinea = "\n";
		
		String textPDF = saltoLinea +
		" - NOMBRE CLIENTE: " + objTransaccion.getCliente().getNombres() + " " + objTransaccion.getCliente().getApellidos() + saltoLinea + 
		" - NOMBRE EMPRESA: " + objTransaccion.getEmpresa().getRazonSocial() + "\n" + "\n" + 
		" - LUGAR DE SALIDA:     LIMA      " + saltoLinea +
		" - LUGAR DE DESTINO:    CAJAMARCA " + saltoLinea +
		" - FECHA & HORA SALIDA: 2010-06-30 06:00 a.m. " + saltoLinea +
		" - DURACION ESTIMADA:   8hras."                 + saltoLinea +
		" - TIPO VEHICULO:   " + objTransaccion.getVehiculo().getNombre() + " - " + objTransaccion.getVehiculo().getTipo() + saltoLinea +
		" - NUM. ASIENTO:    " + objTransaccion.getAsiento().getId() + saltoLinea + saltoLinea +
		" - PAGO TOTAL:    S/" + 45;
		 
		//Guarda en BD la transaccion.
		Boolean  objEstadoTransaccion = (Boolean)this.transaccionDAO.ingresarTransaccion( objTransaccion );
		
		//Modificando Asiendo en BD. (FALTA MOFICAR EN BD EL ASIENTO)
		if( txtFilaAsiento.equalsIgnoreCase( "A" ) ){			
			objAsiento.setEstado_A( "TRUE" );		
		}
		else if( txtFilaAsiento.equalsIgnoreCase( "B" ) ){
			objAsiento.setEstado_B( "TRUE" );		
		}
		else if( txtFilaAsiento.equalsIgnoreCase( "C" ) ){
			objAsiento.setEstado_C( "TRUE" );		
		}
		else if( txtFilaAsiento.equalsIgnoreCase( "D" ) ){
			objAsiento.setEstado_D( "TRUE" );		
		}
		
		//Guarda en BD.
		this.asientoDAO.modificarAsiento( objAsiento );
		
		//GUI		
		int ancho = 800;
		int alto  = 600;
		
		Rectangle        objRectangulo = null;
		Document         objDocumento  = null;
		Paragraph        objParagraph  = null;
		File             archivoSalida = null;
		FileOutputStream archivoOutput = null;
		String           rutaFichero   = null;
		
		try{
			objRectangulo = new Rectangle( ancho, alto );
			objDocumento  = new Document( objRectangulo );
			archivoOutput = new FileOutputStream( FICHERO ); 
			
			PdfWriter.getInstance( objDocumento, archivoOutput );
			
			objDocumento.addTitle( tituloPDF );
			objDocumento.open();
			
			objParagraph = new Paragraph( textPDF );
			objDocumento.add( objParagraph );
			
			rutaFichero = ( RUTA_PATH + "/" + FICHERO );
			System.out.println( "RUTA PATH: " + rutaFichero );
			
			archivoSalida = new File( rutaFichero );
		}
		catch( IOException e ){
			   e.printStackTrace();
		}
		catch( Exception e ){
			   e.printStackTrace();
		}
		finally{
			if( objDocumento != null ){
				if( objDocumento.isOpen() == true ){
					objDocumento.close();
				}
			}
		}
		try{
			//Manda Abrir Fichero 'PDF'.
			Runtime.getRuntime().exec( "rundll32 url.dll, FileProtocolHandler " + archivoSalida );
		}
		catch( Exception e ){
			e.printStackTrace();
		} 
		
		
		Transaccion  objTransaccionA  = (Transaccion)this.transaccionDAO.obtenerObjetoTransaccion_x_codigo( 1 );
		System.out.println( "objTransaccionA: " + objTransaccionA );
	}
	
	/**
	 * imprimeLog
	 * @param mensaje
	 **/
	public void imprimeLog( String mensaje ){ 
		this.beanBase.imprimeLog( mensaje, this.getClass().toString() );
	}
	
}
