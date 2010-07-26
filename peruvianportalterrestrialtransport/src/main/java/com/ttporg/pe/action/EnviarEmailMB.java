package com.ttporg.pe.action;

import java.io.IOException;
import java.util.Properties;
import java.util.Vector;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address; 
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.ttporg.pe.bean.BaseBean;
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
import com.ttporg.pe.dto.BeanParametrosEmailDto;
import com.ttporg.pe.util.UtilCalendario;
  
/**
 * @author Cesar Ricardo.
 * @clase: EnviarEmailMB.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
 public class EnviarEmailMB extends HttpServlet{
	
	private static final long serialVersionUID = 5940034219102598271L;

	private	 BeanParametrosEmailDto objEMAIL 	    =  null;
	private	 Properties 		    props 	        =  null;
	private  String                 Confirmacion    =  "";
	private  int                    totalEMAILs     =  0;	
	private  String                 PaginaSiguiente =  "/jsp/interfaces/Confirmacion.jsp";    /** PAGINA SIGUIENTE **/
	
	private  String                 FROM;
	private  String                 TO;
	private  String                 CC;
	private  String                 BCC;
	private  String                 MENSAJE;
	private  String                 SUBJECT;
	private  int                    COPIAS;
	private  String                 content_type;
	private  String                 NombreArchivo;
	private  String                 CodigoAleatorio;

	private  BeanParametrosEmailDto  paramEmail  = null;
		
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
 
	 this.paramEmail      = new BeanParametrosEmailDto();
	 this.beanBase        = new BaseBean();
	}
	
	public void EnviarEMAIL() throws ServletException, IOException{
		this.imprimeLog("DENTRO DE: 'EnviarEMAIL'");
		this.procesar(); 
		
		//INICIALIZANDO 'DAOs'...
		this.inicializaDAOs();	
	}
	
	public void service( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException{ 
	
		this.imprimeLog("DENTRO DE: 'EnviarEmail_HTML_Adjunto'");
		
		this.imprimeLog("Nombre Clase #1: " + this.getClass().getName().toString() );
		this.imprimeLog("Nombre Clase #2: " + this.getClass().getSimpleName().toString() );
		
		this.FROM             =  request.getParameter("FROM");
		this.TO               =  request.getParameter("TO");
		this.CC               =  request.getParameter("Cc");
		this.BCC              =  request.getParameter("Bcc");
		this.MENSAJE          =  request.getParameter("MENSAJE");
		this.SUBJECT          =  request.getParameter("SUBJECT");
		this.COPIAS           =  Integer.parseInt( request.getParameter("COPIAS") );
		this.NombreArchivo    =  request.getParameter("NombreArchivo"); 	
		this.CodigoAleatorio  =  request.getParameter("CodigoAleatorio");
		
		if( this.COPIAS == 0 ){
			this.COPIAS = 1;
		}
				
		BeanParametrosEmailDto objParametrosEMAIL = new BeanParametrosEmailDto();

		objParametrosEMAIL.setCuentaEmailRemitente( this.FROM );        //QUIEN MANDARA - handymansconsultant@gmail.com
		objParametrosEMAIL.setDireccion( "smtp.gmail.com");
		objParametrosEMAIL.setPuerto( "465");
		objParametrosEMAIL.setRequiereConexionSegura(true);
		objParametrosEMAIL.setRequiereAuthenticacion(true);
		//objParametrosEMAIL.setModoDebug(true);
		objParametrosEMAIL.setProtocolo( "smtp");           //SEGURO ==> smtps,  NO SEGURO ==> smtp
		objParametrosEMAIL.setUsuario(  "cesarricardo.guerra19@gmail.com");
		objParametrosEMAIL.setPassword( "41816133");
		objParametrosEMAIL.setAsuntoMensaje( this.SUBJECT );
		objParametrosEMAIL.setCopia( this.COPIAS );		
		objParametrosEMAIL.setCuentaEmailDestinatario(     this.TO  );
		objParametrosEMAIL.setCuentaEmailDestinatario_Cc(  this.CC  );
		objParametrosEMAIL.setCuentaEmailDestinatario_Bcc( this.BCC );		
		objParametrosEMAIL.setUbicacionAdjunto( this.NombreArchivo );
		objParametrosEMAIL.setCodigoAleatorio( this.CodigoAleatorio );
		
		this.imprimir( objParametrosEMAIL );                     //MANDA A IMPRIMIR
			
		String MENSAJE_HTML = "" +
			"<HTML>"       + 
			   "<BODY>"    +
				  "<LEFT><FONT COLOR='#000066' size='2' FACE='Arial'>" + MENSAJE + "</FONT></LEFT>" +
				  "<CENTER>"     +
				  "<BR> "  +
				  "<BR> "  +
				  "<A href='http://www.cibertec.edu.pe' style='text-decoration:none; color:#0033FF' target='blank'> "   +
				   "<img src='http://us.f13.yahoofs.com/bc/48409961_1010f/bc/imagenes/CIBERTEC.gif?bf33JQIBn2k_0LuB'/> " +
				  "</A> "  +
 				  "<BR> "  +
				  "<BR> "  +
				  "<STRONG> "    +
					"<FONT size='3' FACE='Arial'> " +
					"<A href='http://www.cibertec.edu.pe' style='text-decoration:none; color:#0033FF' target='blank'>http://www.cibertec.edu.pe</A> " +
					"</FONT>  "  +
			      "</STRONG>  "  +
				"</CENTER>	  "  +
			   "</BODY>       "  +
			"</HTML>          "; 
				
		this.imprimeLog("EL 'MENSAJE_HTML' ES: " + MENSAJE_HTML );

		objParametrosEMAIL.setContentType("text/html");
		objParametrosEMAIL.setEsperarCommandQuit(true);
		
		/***************************************************/
		/**************** MANEJO DE ADJUNTO ****************/
		/***************************************************/
		if( (objParametrosEMAIL.getUbicacionAdjunto() != null ) && (objParametrosEMAIL.getCodigoAleatorio() != null )  ){
			
			try{				
				//CREA EL 'multipart' PRINCIPAL
				MimeMultipart mp_Principal = new MimeMultipart("mixed"); 
		
				//CREA EL CONTENIDO DEL 'multipart' (PARA 'TETXO' & 'HTML')
				MimeMultipart mp_Contenido = new MimeMultipart("alternative");
						
				//AGREGA 'TEXTO HTML'
		        BodyPart texto_HTML = new MimeBodyPart();
		        texto_HTML.setContent( MENSAJE_HTML, objParametrosEMAIL.getContentType() );
				mp_Contenido.addBodyPart( texto_HTML );
				
				//AGREGA 'TEXTO ESTATICO'
				BodyPart texto_Estatico = new MimeBodyPart();
				texto_Estatico.setContent( MENSAJE_HTML, "text/plain"); //texto_Estatico.setText("MENSAJE TEXTO ESTATICO" );
				mp_Contenido.addBodyPart( texto_Estatico ); 
				
				//AGREGA 'ARCHIVO ADJUNTO'
		        BodyPart adjunto = new MimeBodyPart();
		        adjunto.setDataHandler( new DataHandler( new FileDataSource("C:/ARCHIVOS/" + objParametrosEMAIL.getUbicacionAdjunto() ) ) );
		        adjunto.setFileName( objParametrosEMAIL.getUbicacionAdjunto() );			
		        mp_Principal.addBodyPart( adjunto );
					        
				//CREA UN 'bodyPart' PARA EL 'multipart/alternative'
				BodyPart content_MultAlt = new MimeBodyPart();
				content_MultAlt.setContent( mp_Contenido );
		
				//AGREGA EL Add the root body part to the root multipart
				mp_Principal.addBodyPart( content_MultAlt );
		        
				objParametrosEMAIL.setObjMultiParte( mp_Principal );   //IMPORTANTE AGREGA EL 'multipart' PRINCIPAL
			} 
	        catch( MessagingException e ){
				e.printStackTrace();
			} 	        
		}
		/***************************************************/
		/***************************************************/
		/***************************************************/
		        
		objParametrosEMAIL.setCuerpoMensaje( MENSAJE_HTML );  //MANDA EL MENSAJE CON HTML INCLUIDO!!!	
		
		
		/*** ADJUNTANDO EMAILs, PARA ENVIAR ***/		
		if( !(TO.equals("")) ){
			Vector VectorEmailsReceptores = new Vector();
		    
			//-----------------------------------------------		    
			String[] CORREOS = StringUtils.split( TO.trim(), ";" );
			
	        for( int i=0; i<CORREOS.length; i++ ){
	            VectorEmailsReceptores.addElement( CORREOS[i] );                             //QUIENES RECIBIRAN
	        }
	        //-----------------------------------------------	
	        
		    objParametrosEMAIL.setVectorEmailsReceptores( VectorEmailsReceptores );
		    
		    this.totalEMAILs += objParametrosEMAIL.getVectorEmailsReceptores().size();      //CONTADOR EMAILs ENVIADOS
		}
		
		/*** ADJUNTANDO EMAILs 'CC', PARA ENVIAR ***/
		if( !(CC.equals("")) ){
			Vector VectorEmailsReceptores_CC = new Vector();
			
			//-----------------------------------------------		    
			String[] CORREOS_Cc = StringUtils.split( CC.trim(), ";" );
			
	        for( int i=0; i<CORREOS_Cc.length; i++ ){            
	            VectorEmailsReceptores_CC.addElement( CORREOS_Cc[i] );                         //QUIENES RECIBIRAN
	        }
	        //-----------------------------------------------	
			
	        //VectorEmailsReceptores_CC.addElement("the_aibo@yahoo.com");
			//VectorEmailsReceptores_CC.addElement("i220051@cibertec.edu.pe");
					
			objParametrosEMAIL.setVectorEmailsReceptores_CC( VectorEmailsReceptores_CC );
			
		    this.totalEMAILs += objParametrosEMAIL.getVectorEmailsReceptores_CC().size();   //CONTADOR EMAILs ENVIADOS
        }
		
		/*** ADJUNTANDO EMAILs 'BCC' (OCULTOS), PARA ENVIAR ***/
		if( !(BCC.equals("")) ){
			Vector VectorEmailsReceptores_BCC = new Vector();	
			
			//-----------------------------------------------		    
			String[] CORREOS_Bcc = StringUtils.split( BCC.trim(), ";" );
			
	        for( int i=0; i<CORREOS_Bcc.length; i++ ){	            
	            VectorEmailsReceptores_BCC.addElement( CORREOS_Bcc[i] );                       //QUIENES RECIBIRAN
	        }
	        //-----------------------------------------------	

			//VectorEmailsReceptores_BCC.addElement("i220051@cibertec.edu.pe");            //QUIENES RECIBIRAN OCULTOS
			//VectorEmailsReceptores_BCC.addElement("cesarricardo_guerra19@hotmail.com");  //QUIENES RECIBIRAN OCULTOS
			//VectorEmailsReceptores_BCC.addElement("cesarricardo_guerra19@yahoo.com");    //QUIENES RECIBIRAN OCULTOS
					
			objParametrosEMAIL.setVectorEmailsReceptores_BCC( VectorEmailsReceptores_BCC );
			
			this.totalEMAILs += objParametrosEMAIL.getVectorEmailsReceptores().size();     //CONTADOR EMAILs ENVIADOS
		}
		
		this.procesar();   //MANDA A PROCEAR!!!
				
		EnviarEmailMB ENVIADOR = new EnviarEmailMB();  //REFERENCIA A LA MISMA CLASE
		
		ENVIADOR.setParametrosEmail(objParametrosEMAIL);     //ENVIA TODO LO SETEADO
				
		try{
			ENVIADOR.EnviarEMAIL();			
		}
		catch( ServletException e ){
			 MENSAJE = e.getMessage();
		     this.imprimeLog("EL ERROR ES: " + MENSAJE );
		     e.printStackTrace();
		} 
		catch( IOException e ){
			 MENSAJE = e.getMessage();
		     this.imprimeLog("EL ERROR ES: " + MENSAJE );
		     e.printStackTrace();
		}
		catch( Exception e ){
			 MENSAJE = e.getMessage();
		     this.imprimeLog("EL ERROR ES: " + MENSAJE );
		     e.printStackTrace();
		}
		
		//VALIDANDO MENSAJE
		if( MENSAJE == null ){
			Confirmacion = "PROBLEMS TO SEND THE MESSAGE.";
			this.imprimeLog("" + Confirmacion );
		}
		else{
			Confirmacion = "THE MESSAGE HAVE BEEN SENT.";
			this.imprimeLog("" + Confirmacion );
		}
				
		this.imprimeLog("totalEMAILs: " + this.totalEMAILs );  
		this.imprimeLog("COPIAS: "      + this.COPIAS ); 
		
		request.setAttribute( "Confirmacion" , Confirmacion );
		request.setAttribute( "Emails" ,       String.valueOf(this.totalEMAILs) );
		request.setAttribute( "Copias" ,       String.valueOf(this.COPIAS) );
		
		this.totalEMAILs = 0;     //REINICIANDO EL CONTADOR 
		getServletContext().getRequestDispatcher( this.PaginaSiguiente ).forward( request, response );
	}
		
	/**
	 * procesar
	 **/
	private void procesar(){				   
		
		if( this.objEMAIL != null){
			
			props = new Properties();
			
			props.put("mail.smtp.user",               this.objEMAIL.getCuentaEmailRemitente()     );
			props.put("mail.smtp.host",         	  this.objEMAIL.getDireccion() );
			props.put("mail.smtp.port",         	  this.objEMAIL.getPuerto()    );
			props.put("mail.smtp.starttls.enable",(   this.objEMAIL.isRequiereConexionSegura() + "" ) );
			props.put("mail.smtp.auth",(              this.objEMAIL.isRequiereAuthenticacion() + "" ) );
			props.put("mail.smtp.debug",(			  this.objEMAIL.isModoDebug() + "" )         );
			props.put("mail.smtp.socketFactory.port", this.objEMAIL.getPuerto()        );
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory" );
			props.put("mail.smtp.socketFactory.fallback", "false" );
			props.put("mail.transport.protocol",      this.objEMAIL.getProtocolo()     );

			if( this.objEMAIL.isRequiereConexionSegura() == true){
				props.put("mail.smtps.quitwait",( this.objEMAIL.isEsperarCommandQuit() + "" ) );
			}
			else{
				props.put("mail.smtp.quitwait",(  this.objEMAIL.isEsperarCommandQuit() + "" ) );
			}
	
			try{
				Authenticator  AUTENTICADOR  =  new SMTPAuthenticator(objEMAIL);
				Session        SESION        =  Session.getInstance(props, AUTENTICADOR);
				
				SESION.setDebug( objEMAIL.isModoDebug() );
	
				MimeMessage MENSAJE = new MimeMessage(SESION);
				MENSAJE.setSubject( this.objEMAIL.getAsuntoMensaje() );
				MENSAJE.setText(    this.objEMAIL.getCuerpoMensaje() );
				//MENSAJE.setFrom (new InternetAddress( this.objEMAIL.getCUENTA_EMAIL_ENVIADOR()) );   //YA NO NECESITA...
				
				this.imprimeLog( "" );
				this.imprimeLog("EMAILs ENVIADOS:" );
				this.imprimeLog( "***************" );
				
				if( !(objEMAIL.getCuentaEmailDestinatario().equals("")) ){
					MENSAJE.addRecipients( Message.RecipientType.TO, getARREGLO_DIRECCION( this.objEMAIL.getVectorEmailsReceptores(), this.objEMAIL.getCopia() ));	
				}

				if( !(objEMAIL.getCuentaEmailDestinatario_Cc().equals("")) ){
					MENSAJE.addRecipients( Message.RecipientType.CC, getARREGLO_DIRECCION( this.objEMAIL.getVectorEmailsReceptores_CC(), this.objEMAIL.getCopia() ));	
				}
				
				if( !(objEMAIL.getCuentaEmailDestinatario_Bcc().equals("")) ){
					MENSAJE.addRecipients( Message.RecipientType.BCC, getARREGLO_DIRECCION( this.objEMAIL.getVectorEmailsReceptores_BCC(), this.objEMAIL.getCopia() ));	
				}
				
				this.imprimeLog( "*************" );
				this.imprimeLog( "" );
				
				//SE ESTABLE EL TIPO DE MENSAJE
				content_type = this.objEMAIL.getContentType();
						
				if( (content_type != null) && (this.content_type.equals("")) ){
					this.imprimeLog("SI EL CONTENT TYPE ES != NULL & '': " + content_type );
				}
			
				/**** SI NO HAY ADJUNTO ****/
				if( (this.objEMAIL.getUbicacionAdjunto() == null) && (this.objEMAIL.getCodigoAleatorio() == null) ){
				    MENSAJE.setContent( this.objEMAIL.getCuerpoMensaje(), this.objEMAIL.getContentType() );   //MANEJO 'HTML'
				}
				/**** SI HAY ADJUNTO ****/
				if( !(this.objEMAIL.getUbicacionAdjunto() == null) && !(this.objEMAIL.getCodigoAleatorio() == null) ){
				
					MENSAJE.setContent( this.objEMAIL.getObjMultiParte() );   //MANEJO 'ADJUNTO'
					
					this.paramEmail.setCodigoAleatorio( objEMAIL.getCodigoAleatorio() );
					//this.servicio.eliminarAdjunto( this.paramEmail );                   //ELIMINAR 'REGISTRO BD'
				}
				
				Transport.send( MENSAJE );    //MANDA EL EMAIL
			}
			catch( Exception e ){
				this.imprimeLog("EL ERROR ES: " + e.getMessage() );
				e.printStackTrace();
			}
		}
		else{
			this.imprimeLog("EL 'objEMAIL' ES: NULL" );
		}
	}
	
	private Address[] getARREGLO_DIRECCION ( Vector VectorDireccionesEmail, int COPIAS ){
		
		Vector<Address> VectorEmails = new Vector<Address>();
		
		Address[] ArregloEmail = null;
						
		for( int j=0; j<COPIAS; j++ ){
			
			for( int i=0; i<VectorDireccionesEmail.size(); i++ ){
				try{
					InternetAddress Internet_Address = new InternetAddress( (String)VectorDireccionesEmail.elementAt(i) );
					VectorEmails.addElement( Internet_Address );
	
					this.imprimeLog("Email enviado: " + Internet_Address.getAddress().toString() );
				}
				catch( AddressException e ){
					this.imprimeLog("NO SE AGREGO EL 'Internet_Address' " );
					e.printStackTrace();
				}			
			}
		}
		
		this.imprimeLog("Total de Copias Enviada a cada 'EMAIL': " + COPIAS );
		
		ArregloEmail = new Address[VectorEmails.size()]; //INICIALIZA EL ARREGLO CON EL TAMAÑO DEL VECTOR
		
		for( int i=0; i<VectorEmails.size(); i++){
			ArregloEmail[i] = VectorEmails.elementAt(i);
		}
		return ArregloEmail;		
	}
		
	public BeanParametrosEmailDto getBeanParametrosEMAIL(){
		return objEMAIL;
	}

	public void setParametrosEmail( BeanParametrosEmailDto ParametrosEmail ){
		this.objEMAIL = ParametrosEmail;
	}
	
	/***********************************************/ 	
	/**************** AUTENTICACION ****************/
	/***********************************************/ 	
	
	private class SMTPAuthenticator extends javax.mail.Authenticator{
		
		private	BeanParametrosEmailDto	 objParametrosEmail  =  null;

		public SMTPAuthenticator(){			
		}

		public SMTPAuthenticator( BeanParametrosEmailDto ParametrosEmail){
			this.objParametrosEmail = ParametrosEmail;
		}

		public PasswordAuthentication getPasswordAuthentication(){
			PasswordAuthentication AUTENTICADOR_PASSWORD = new PasswordAuthentication(objParametrosEmail.getUsuario(), objParametrosEmail.getPassword() );
			
			return AUTENTICADOR_PASSWORD;
		}
	 }
	
	/***********************************************/ 	
	/****************** IMPRESION ******************/
	/***********************************************/ 	
	
	private void imprimir( BeanParametrosEmailDto objEMAIL ){		
		this.imprimeLog( " ");
		this.imprimeLog( "PARAMETROS DE ENVIO DEL EMAIL");
		this.imprimeLog( "-----------------------------");
		this.imprimeLog( "EMAIL REMITENTE: "         +  objEMAIL.getCuentaEmailRemitente() );
		this.imprimeLog( "EMAIL DESTINATARIO: "      +  objEMAIL.getDireccion() );
		this.imprimeLog( "PUERO SERVIDOR: "          +  objEMAIL.getPuerto() );
		this.imprimeLog( "CONEXION SEGURA: "         +  objEMAIL.isRequiereConexionSegura() );
		this.imprimeLog( "AUTENTICACION: "           +  objEMAIL.isRequiereAuthenticacion() );
		this.imprimeLog( "MODO DEPURACION: "         +  objEMAIL.isModoDebug()  );
		this.imprimeLog( "PROTOCOLO: "               +  objEMAIL.getProtocolo() );
		this.imprimeLog( "ID: "                      +  objEMAIL.getUsuario()   );
		this.imprimeLog( "PASSWORD: "                +  objEMAIL.getPassword()  );
		this.imprimeLog( "MENSAJE: "                 +  objEMAIL.getAsuntoMensaje() );
		this.imprimeLog( "EMAIL DESTINATARIO: "      +  objEMAIL.getCuentaEmailDestinatario()     );
		this.imprimeLog( "EMAIL DESTINATARIO CC: "   +  objEMAIL.getCuentaEmailDestinatario_Cc()  );
		this.imprimeLog( "EMAIL DESTINATARIO BCC: "  +  objEMAIL.getCuentaEmailDestinatario_Bcc() );
		this.imprimeLog( "NOMBRE ADJUNTO: "          +  objEMAIL.getUbicacionAdjunto() );
		this.imprimeLog( "CODIGO ALEATORIO: "        +  objEMAIL.getCodigoAleatorio() );
		this.imprimeLog( " ");
	}
	
	/**
	 * inicializaDAOs
	 **/
	public void inicializaDAOs(){
		
		//OBTENER [ServletContext] USANDO [STRUTs 2]: 'ServletActionContext.getServletContext()'.
		//OBTENER [ServletContext] USANDO [SERVLETs]: 'this.getServletContext()'.
		ServletContext servletContext = this.getServletContext();	
		this.imprimeLog( "=====> servletContext: " + servletContext );
				 
		WebApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext( servletContext );
		this.imprimeLog( "=====> contexto: " + contexto );
		
		this.imprimeLog( "****************** OBTENIENDO 'DAOS' [INICIO] ******************" );

		this.clienteDAO      = (ClienteDaoImpl)contexto.getBean(      "clienteDao"      ); 
		this.empresaDAO      = (EmpresaDaoImpl)contexto.getBean(      "empresaDao"      );
		this.departamentoDAO = (DepartamentoDaoImpl)contexto.getBean( "departamentoDao" );
		this.agenciaDAO      = (AgenciaDaoImpl)contexto.getBean(      "agenciaDao"      );	
		this.vehiculoDAO     = (VehiculoDaoImpl)contexto.getBean(     "vehiculoDao"     );
		this.servicioDAO     = (ServicioDaoImpl)contexto.getBean(     "servicioDao"     );
		this.asientoDAO      = (AsientoDaoImpl)contexto.getBean(      "asientoDao"      );
		this.salidaDAO       = (SalidaDaoImpl)contexto.getBean(       "salidaDao"       );
		this.calendarioDAO   = (CalendarioDaoImpl)contexto.getBean(   "calendarioDao"   );
		this.pagoDAO         = (PagoDaoImpl)contexto.getBean(         "pagoDao"         );
		this.clientePagoDAO  = (ClientePagoDaoImpl)contexto.getBean(  "clientePagoDao"  );
		this.transaccionDAO  = (TransaccionDaoImpl)contexto.getBean(  "transaccionDao"  );
		
		this.imprimeLog( "====> [clienteDAO]:      " + this.clienteDAO      );
		this.imprimeLog( "====> [empresaDAO]:      " + this.empresaDAO      );
		this.imprimeLog( "====> [departamentoDAO]: " + this.departamentoDAO );
		this.imprimeLog( "====> [agenciaDAO]:      " + this.agenciaDAO      );
		this.imprimeLog( "====> [vehiculoDAO]:     " + this.vehiculoDAO     );
		this.imprimeLog( "====> [servicioDAO]:     " + this.servicioDAO     );
		this.imprimeLog( "====> [asientoDAO]:      " + this.asientoDAO      );
		this.imprimeLog( "====> [salidaDAO]:       " + this.salidaDAO       );
		this.imprimeLog( "====> [calendarioDAO]:   " + this.calendarioDAO   );
		this.imprimeLog( "====> [pagoDAO]:         " + this.pagoDAO         );
		this.imprimeLog( "====> [clientePagoDAO]:  " + this.clientePagoDAO  );
		this.imprimeLog( "====> [transaccionDAO]:  " + this.transaccionDAO  );
		
		this.imprimeLog( "******************* OBTENIENDO 'DAOS' [FIN] *******************" );
	}	
	
	/**
	 * imprimeLog
	 * @param mensaje
	 **/
	public void imprimeLog( String mensaje ){ 
		this.beanBase.imprimeLog( mensaje, this.getClass().toString() );
	}
	
  } 
 