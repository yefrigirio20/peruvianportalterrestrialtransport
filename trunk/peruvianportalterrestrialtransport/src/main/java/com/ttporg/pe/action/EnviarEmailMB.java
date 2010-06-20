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
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.commons.lang.StringUtils;

import com.ttporg.pe.dto.BeanParametrosEmailDto;
 import com.ttporg.pe.servicio.EmpresaService;
 import com.ttporg.pe.servicio.impl.EmpresaServiceImpl;
import com.ttporg.pe.servlet.LoggerBean; 
 
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
 */
 public class EnviarEmailMB extends HttpServlet{
	
	private static final long serialVersionUID = 5940034219102598271L;

	private	 BeanParametrosEmailDto  objEMAIL 	       =  null;
	private	 Properties 		  props 	       =  null;
	private  String               Confirmacion     =  "";
	private  int                  totalEMAILs      =  0;	
	private  String               PaginaSiguiente  =  "/jsp/interfaces/Confirmacion.jsp";    /** PAGINA SIGUIENTE **/
	
	private  String               FROM;
	private  String               TO;
	private  String               CC;
	private  String               BCC;
	private  String               MENSAJE;
	private  String               SUBJECT;
	private  int                  COPIAS;
	private  String               content_type;
	private  String               NombreArchivo;
	private  String               CodigoAleatorio;
	
	private  EmpresaService       servicio   = null;
	private  BeanParametrosEmailDto  paramEmail = null;
	
	//Generacion de Log.
	private LoggerBean loggerBean   = null;
	
	{
	 this.servicio           = new EmpresaServiceImpl();	
	 this.loggerBean         = new LoggerBean();
	 this.paramEmail         = new BeanParametrosEmailDto();
	}
	
	public void EnviarEMAIL() throws ServletException, IOException{
		System.out.println("DENTRO DE: 'EnviarEMAIL'");
		PROCESAR();
	}
	
	public void service( HttpServletRequest request, HttpServletResponse response )throws ServletException, IOException{ 
	
		System.out.println("DENTRO DE: 'EnviarEmail_HTML_Adjunto'");
		
		System.out.println("Nombre Clase #1: " + this.getClass().getName().toString() );
		System.out.println("Nombre Clase #2: " + this.getClass().getSimpleName().toString() );
		
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
				
		System.out.println("EL 'MENSAJE_HTML' ES: " + MENSAJE_HTML );

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
		
		this.PROCESAR();   //MANDA A PROCEAR!!!
				
		EnviarEmailMB ENVIADOR = new EnviarEmailMB();  //REFERENCIA A LA MISMA CLASE
		
		ENVIADOR.setParametrosEmail(objParametrosEMAIL);     //ENVIA TODO LO SETEADO
				
		try{
			ENVIADOR.EnviarEMAIL();			
		}
		catch( ServletException e ){
			 MENSAJE = e.getMessage();
		     System.out.println("EL ERROR ES: " + MENSAJE );
		     e.printStackTrace();
		} 
		catch( IOException e ){
			 MENSAJE = e.getMessage();
		     System.out.println("EL ERROR ES: " + MENSAJE );
		     e.printStackTrace();
		}
		catch( Exception e ){
			 MENSAJE = e.getMessage();
		     System.out.println("EL ERROR ES: " + MENSAJE );
		     e.printStackTrace();
		}
		
		//VALIDANDO MENSAJE
		if( MENSAJE == null ){
			Confirmacion = "PROBLEMS TO SEND THE MESSAGE.";
			System.out.println("" + Confirmacion );
		}
		else{
			Confirmacion = "THE MESSAGE HAVE BEEN SENT.";
			System.out.println("" + Confirmacion );
		}
				
		System.out.println("totalEMAILs: " + this.totalEMAILs );  
		System.out.println("COPIAS: "      + this.COPIAS ); 
		
		request.setAttribute( "Confirmacion" , Confirmacion );
		request.setAttribute( "Emails" ,       String.valueOf(this.totalEMAILs) );
		request.setAttribute( "Copias" ,       String.valueOf(this.COPIAS) );
		
		this.totalEMAILs = 0;     //REINICIANDO EL CONTADOR 
		getServletContext().getRequestDispatcher( this.PaginaSiguiente ).forward( request, response );
	}
		
	private void PROCESAR(){				   
		
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
				
				System.out.println( "" );
				System.out.println("EMAILs ENVIADOS:" );
				System.out.println( "***************" );
				
				if( !(objEMAIL.getCuentaEmailDestinatario().equals("")) ){
					MENSAJE.addRecipients( Message.RecipientType.TO, getARREGLO_DIRECCION( this.objEMAIL.getVectorEmailsReceptores(), this.objEMAIL.getCopia() ));	
				}

				if( !(objEMAIL.getCuentaEmailDestinatario_Cc().equals("")) ){
					MENSAJE.addRecipients( Message.RecipientType.CC, getARREGLO_DIRECCION( this.objEMAIL.getVectorEmailsReceptores_CC(), this.objEMAIL.getCopia() ));	
				}
				
				if( !(objEMAIL.getCuentaEmailDestinatario_Bcc().equals("")) ){
					MENSAJE.addRecipients( Message.RecipientType.BCC, getARREGLO_DIRECCION( this.objEMAIL.getVectorEmailsReceptores_BCC(), this.objEMAIL.getCopia() ));	
				}
				
				System.out.println( "*************" );
				System.out.println( "" );
				
				//SE ESTABLE EL TIPO DE MENSAJE
				content_type = this.objEMAIL.getContentType();
						
				if( (content_type != null) && (this.content_type.equals("")) ){
					System.out.println("SI EL CONTENT TYPE ES != NULL & '': " + content_type );
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
				System.out.println("EL ERROR ES: " + e.getMessage() );
				e.printStackTrace();
			}
		}
		else{
			System.out.println("EL 'objEMAIL' ES: NULL" );
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
	
					System.out.println("Email enviado: " + Internet_Address.getAddress().toString() );
				}
				catch( AddressException e ){
					System.out.println("NO SE AGREGO EL 'Internet_Address' " );
					e.printStackTrace();
				}			
			}
		}
		
		System.out.println("Total de Copias Enviada a cada 'EMAIL': " + COPIAS );
		
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
		System.out.println( " ");
		System.out.println( "PARAMETROS DE ENVIO DEL EMAIL");
		System.out.println( "-----------------------------");
		System.out.println( "EMAIL REMITENTE: "         +  objEMAIL.getCuentaEmailRemitente() );
		System.out.println( "EMAIL DESTINATARIO: "      +  objEMAIL.getDireccion() );
		System.out.println( "PUERO SERVIDOR: "          +  objEMAIL.getPuerto() );
		System.out.println( "CONEXION SEGURA: "         +  objEMAIL.isRequiereConexionSegura() );
		System.out.println( "AUTENTICACION: "           +  objEMAIL.isRequiereAuthenticacion() );
		System.out.println( "MODO DEPURACION: "         +  objEMAIL.isModoDebug()  );
		System.out.println( "PROTOCOLO: "               +  objEMAIL.getProtocolo() );
		System.out.println( "ID: "                      +  objEMAIL.getUsuario()   );
		System.out.println( "PASSWORD: "                +  objEMAIL.getPassword()  );
		System.out.println( "MENSAJE: "                 +  objEMAIL.getAsuntoMensaje() );
		System.out.println( "EMAIL DESTINATARIO: "      +  objEMAIL.getCuentaEmailDestinatario()     );
		System.out.println( "EMAIL DESTINATARIO CC: "   +  objEMAIL.getCuentaEmailDestinatario_Cc()  );
		System.out.println( "EMAIL DESTINATARIO BCC: "  +  objEMAIL.getCuentaEmailDestinatario_Bcc() );
		System.out.println( "NOMBRE ADJUNTO: "          +  objEMAIL.getUbicacionAdjunto() );
		System.out.println( "CODIGO ALEATORIO: "        +  objEMAIL.getCodigoAleatorio() );
		System.out.println( " ");
	}
	
  } 
 