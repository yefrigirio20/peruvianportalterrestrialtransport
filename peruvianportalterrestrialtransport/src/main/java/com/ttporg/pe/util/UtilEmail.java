package com.ttporg.pe.util;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.ttporg.pe.dto.BeanParametrosEmailDto;

/**
 * @author Cesar Ricardo.
 * @clase: UtilEmail.java  
 * @descripción descripción de la clase.
 * @author_web: http://frameworksjava2008.blogspot.com
                http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: nombre del email del autor.
 * @author_company: nombre de la compañía del autor.
 * @fecha_de_creación: dd-mm-yyyy.
 * @fecha_de_ultima_actualización: dd-mm-yyyy.
 * @versión 1.0
 **/
public class UtilEmail{

	private BeanParametrosEmailDto beanEmailDto;
	
	//Constructores ...
	public UtilEmail(){		
	}
	
	public UtilEmail( BeanParametrosEmailDto beanEmailDto ){		
		this.beanEmailDto = beanEmailDto;
	}
     
    /**
     * enviarEmailHtmlAdjunto
     * @param beanEmailDto
     **/
    public synchronized void enviarEmailHtmlAdjunto( BeanParametrosEmailDto beanEmailDto ){
        
    	try{        	
    		System.out.println( "**** DENTRO DE: 'enviarEmailHtmlAdjunto' ****" );
        	    		
    		if( beanEmailDto != null ){
    			
    			this.beanEmailDto = beanEmailDto;
    			
    			//se obtiene el objeto Session. La configuración es para
    			//una cuenta de gmail.
    			Properties propiedades = new Properties();  
    			
    			propiedades.put( "mail.smtp.host", this.beanEmailDto.getServidor() );
    			
    			propiedades.setProperty( "mail.smtp.starttls.enable", "true" );
    			propiedades.setProperty( "mail.smtp.port", this.beanEmailDto.getPuerto() );
    			propiedades.setProperty( "mail.smtp.user", this.beanEmailDto.getCuentaEmailRemitente() );
    			propiedades.setProperty( "mail.smtp.auth", "true" );
    			
    			Session sesion = Session.getDefaultInstance( propiedades, null ); 
    			sesion.setDebug( false );
    			
    			String mensajeHml = "" +
								"<HTML> " +        
								"<BODY> " +     
								"<LEFT> " +
								"  <FONT COLOR='#000066' size='4' face='Comic Sans MS'> " +
								     this.beanEmailDto.getCuerpoMensaje() +
								"  </FONT> " +  
								"</LEFT>   " +  
								      "<CENTER> " +  
								    	"<BR> " +    
							    		" <A href='http://www.cibertec.edu.pe' style='text-decoration:none; color:#0033FF' target='blank'> " +     
							    	    "    <img src='http://www.perucusco.com/DSC00032.JPG' width='185' height='124' style='text-decoration:none' /> " +   
							    		" </A> " +    
							     		" <BR> " +     
							    		" <BR> " +    
							    		" <STRONG> " +      
							    		"  <FONT size='3' FACE='Arial'> " +   
							    		"    <A href='http://localhost:8080/peruvianportalterrestrialtransport' " +
							    		"       style='text-decoration:none; color:#0033FF' " +
							    		"       target='blank'>http://localhost:8080/peruvianportalterrestrialtransport" +
							    		"    </A> " +   
							    		"  </FONT> " +     
							            " </STRONG>  " +    
								    "</CENTER> " +  	    
								  "</BODY> " +          
								"</HTML> "; 
    			
				//Crea el 'multipart' PRINCIPAL
    			MimeMultipart multiPartPrincipal = new MimeMultipart( "mixed" );
    			
    			//Crea el contenido del 'multipart' (PARA 'TEXTO' & 'HTML')
				MimeMultipart multiPartContenido = new MimeMultipart( "alternative" ); 
    							
				//Configuracion 'Texto HTML'
		        BodyPart textoHtml = new MimeBodyPart();
		        //textoHtml.setText(  this.beanEmailDto.getCuerpoMensaje() );
		        textoHtml.setContent( mensajeHml, this.beanEmailDto.getContentType() );
		        multiPartContenido.addBodyPart( textoHtml );
		        
				//Configuracion 'Texto Plano'
    			BodyPart textoPlano = new MimeBodyPart();
    			//textoPlano.setText(  this.beanEmailDto.getCuerpoMensaje() );
    			textoPlano.setContent( mensajeHml, "text/plain" );
    			multiPartContenido.addBodyPart( textoPlano );
    			
				//Configuracion 'Imagen Adjunta'
    			BodyPart adjunto = new MimeBodyPart();
    			adjunto.setDataHandler( new DataHandler( new FileDataSource( "C:/PublicidaEmail.jpg" ) ) );
    			adjunto.setFileName( this.beanEmailDto.getNombreAdjunto() );
    			multiPartPrincipal.addBodyPart( adjunto );
    			    			
				//CREA UN 'bodyPart' PARA EL 'multipart/alternative'
				BodyPart content_MultAlt = new MimeBodyPart();
				content_MultAlt.setContent( multiPartContenido );
		
				//AGREGA EL Add the root body part to the root multipart
				multiPartPrincipal.addBodyPart( content_MultAlt );
     			
    			//Se compone el correo, dando to, from, subject y el contenido.
    			MimeMessage mensaje = new MimeMessage( sesion ); 
    			mensaje.setFrom( new InternetAddress(  this.beanEmailDto.getCuentaEmailRemitente() ) );
    			
    			mensaje.addRecipient( Message.RecipientType.TO,  new InternetAddress( this.beanEmailDto.getCuentaEmailDestinatario()     ) );
    			mensaje.addRecipient( Message.RecipientType.CC,  new InternetAddress( this.beanEmailDto.getCuentaEmailDestinatario_Cc()  ) );
    			mensaje.addRecipient( Message.RecipientType.BCC, new InternetAddress( this.beanEmailDto.getCuentaEmailDestinatario_Bcc() ) );  
    			
    			mensaje.setSubject( this.beanEmailDto.getAsuntoMensaje() );
    			mensaje.setContent( multiPartPrincipal );
    			
    			// Se envia el correo.
    			Transport transportador = sesion.getTransport( this.beanEmailDto.getProtocolo() ); 
    			transportador.connect( this.beanEmailDto.getUsuario(), this.beanEmailDto.getPassword() );
    			transportador.sendMessage( mensaje, mensaje.getAllRecipients() );
    			transportador.close();
    		}    			
        }
        catch( Exception e ){
        	   e.printStackTrace();
        }
    }
    
	public BeanParametrosEmailDto getBeanEmailDto(){
		return beanEmailDto;
	}

	
	public void setBeanEmailDto( BeanParametrosEmailDto beanEmailDto ){
		this.beanEmailDto = beanEmailDto;
	}
	
} 

