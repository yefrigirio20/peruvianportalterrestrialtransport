package com.ttporg.pe.servlet;
 
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ttporg.pe.bean.Cliente;
import com.ttporg.pe.dto.BeanValidacionDto;
import com.ttporg.pe.servicio.ClienteService;
import com.ttporg.pe.util.UtilCalendario;
import com.ttporg.pe.util.UtilSingleton;
  
/**
 * @author Cesar Ricardo.
 * @clase: ServletRegistroCliente.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 */
public class ServletRegistroCliente extends HttpServlet implements Servlet{
 
	private static final long serialVersionUID = 509943115648134836L;

	private ServletContext    contexto       = null;
	private RequestDispatcher despachador    = null;
	
	//Singleton ...
	private UtilSingleton     utilSingleton  = null;
	
	//Service ...
	private ClienteService    servicio       = null;
	
	//Utilitarios ...
	private UtilCalendario    utilCalendario = new UtilCalendario();
	
	private String REDIRECCIONAMIENTO        = "/jsp/RegistroCliente.jsp";	
	
	/**
	 * service
	 * @param request
	 * @param response
	 */	
	 public void service( HttpServletRequest request, HttpServletResponse response ){ 
	    System.out.println( "********* DENTRO DE service **********" ); 
 
	    BeanValidacionDto objValidacion      = new BeanValidacionDto();
	    boolean           estadoValidacion   = true;
	    String            MENSAJE_VALIDACION = " * Ingresar un valor en: ";
	    
	    try{	    	   
    	    String nombres         = request.getParameter( "txtNombres"   );
    	    String apellidos       = request.getParameter( "txtApellidos" );
    	    String fechaNacimiento = request.getParameter( "txtFechaNacimiento" );
    	    String direccion       = request.getParameter( "txtDireccion" );
    	    String email           = request.getParameter( "txtEmail"     );
    	    String usuario         = request.getParameter( "txtUsuario"   );
    	    String password        = request.getParameter( "txtPassword"  );
    	    String confirPassword  = request.getParameter( "txtConfirmPassword" );
    	    String dni             = request.getParameter( "txtDni"       );
    	        	   
    	    System.out.println( "" );
    	    System.out.println( "DATOS INGRESADOS DEL CLIENTE: "      );
    	    System.out.println( "------------------------------"      ); 
    	    System.out.println( "Nombres:         " + nombres         ); 
    	    System.out.println( "Apellidos:       " + apellidos       );
    	    System.out.println( "FechaNacimiento: " + fechaNacimiento ); 
    	    System.out.println( "Direccion:       " + direccion       );
    	    System.out.println( "Email:           " + email           ); 
    	    System.out.println( "Dni:              " + dni            );
    	    System.out.println( "Usuario:         " + usuario         );
    	    System.out.println( "Password:        " + password        ); 
    	    System.out.println( "Conf.Password:   " + confirPassword  );
    	    System.out.println( "" );
    	       	   
    	    //------------- VALIDACION 'JSP' -------------//
    	    if( nombres.equals( "" ) ){
    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Nombres]" );
    		    estadoValidacion = false;
    	    }
    	    if( apellidos.equals( "" ) ){
    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Apellidos]" );
    		    estadoValidacion = false;
    	    }
    	    if( fechaNacimiento.equals( "" ) ){
    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Fecha Nacimiento]" );
    		    estadoValidacion = false;
    	    }
    	    if( direccion.equals( "" ) ){
    	 	    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Direccion]" );
   		        estadoValidacion = false;
    	    }
    	    if( dni.equals( "" ) ){
    	 	    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Dni]" );
   		        estadoValidacion = false;
    	    }
    	    if( email.equals( "" ) ){
    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Email]" );
    		    estadoValidacion = false;
    	    }
    	    if( usuario.equals( "" ) ){
    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Usuario]" );
    		    estadoValidacion = false;
    	    }
    	    if( password.equals( "" ) ){
    	 	    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Password]" );
    		    estadoValidacion = false;
    	    }
    	    if( confirPassword.equals( "" ) ){
    		    objValidacion.getMensajesNOK().add( MENSAJE_VALIDACION + "[Apellidos]" );
    		    estadoValidacion = false;
    	    }
    	    if( !(password.equals( confirPassword )) ){
    		      objValidacion.getMensajesNOK().add( " * Confirmacion de Password Incorrecta." );
    		      estadoValidacion = false;
    	    }
    	    //---------------------------------------//
    	    
    	    //Validacion ...
    	    if( estadoValidacion == true ){
    	    	objValidacion.setMensajeOK( "Proceso Exitoso" ); 
    	           	   
	    	    //---------------------------- MEMORIA Y/O BD ----------------------------//
	    	    //this.servicio.ingresarCliente( objCliente );  //PERSISTENCIA.
	    	    
	    	    String[] arrayCadena = fechaNacimiento.split( "-" );  //Fecha STRING a DATE.
	    	    
	    	    String anio = arrayCadena[ 0 ];
	    	    String mes  = arrayCadena[ 1 ];
	    	    String dia  = arrayCadena[ 2 ];
	    	    
	    	    System.out.println( "Anio: " + anio );
	    	    System.out.println( "Mes:  " + mes  );
	    	    System.out.println( "Dia:  " + dia  );
	    	    
	    	    Date cumpleanos = this.utilCalendario.getFecha( Integer.parseInt( anio ), 
	    	    		                                        Integer.parseInt( mes  ), 
	    	    		                                        Integer.parseInt( dia  ) );
	    	    
	    	    Cliente objCliente = new Cliente( 1, nombres, apellidos, cumpleanos, direccion, 
	                                              null, email, dni, usuario, password, "USUARIO", "true" ); 
	    	    
	    	    //------------- Guardar el 'SINGLETON'. -------------//
	    	    this.utilSingleton = UtilSingleton.getInstancia();
	    	    this.utilSingleton.setEstadoActivacion( true );
	    	    this.utilSingleton.getObjetoSingleton().setCliente( objCliente );	    	    
	    	    //---------------------------------------------------//    	    
    	    }
    	    
            request.setAttribute( "estadoValidacion", estadoValidacion );  //estadoValidacion ...
            request.setAttribute( "objValidacion",    objValidacion    );  //Objeto Validacion ...
    	   
            this.contexto    = this.getServletContext();
            this.despachador = this.contexto.getRequestDispatcher( this.REDIRECCIONAMIENTO );
           
            this.despachador.forward( request, response );            //Redirecciona con los parametros seteados.	           
	    }
	    catch( Exception e ){
			   e.printStackTrace();
		}	    
	 }    
	
}
