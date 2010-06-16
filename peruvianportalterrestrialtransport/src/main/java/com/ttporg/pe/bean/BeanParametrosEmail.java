package com.ttporg.pe.bean;

import java.io.Serializable;
import java.util.Vector;
import javax.mail.internet.MimeMultipart;

 /**
  * @author Cesar Ricardo.
  * @clase: BeanParametrosEmail.java  
  * @descripción descripción de la clase.
  * @author_web: http://frameworksjava2008.blogspot.com
                 http://viviendoconjavaynomoririntentandolo.blogspot.com
  * @author_email: nombre del email del autor.
  * @author_company: nombre de la compañía del autor.
  * @fecha_de_creación: dd-mm-yyyy.
  * @fecha_de_ultima_actualización: dd-mm-yyyy.
  * @versión 1.0
  */
 public class BeanParametrosEmail implements Serializable{
 
	private static final long serialVersionUID = -3234147478034925761L;
	
	private  int    		id 					           =   0;
	private  String 		usuario 					   =   "";
	private  String 		password 					   =   "";	
	private  String 		cuentaEmailRemitente           =   "";
	private  String 		cuentaEmailDestinatario        =   "";
	private  String 		cuentaEmailDestinatario_Cc     =   "";
	private  String 		cuentaEmailDestinatario_Bcc    =   "";	
	private  String 		direccion                	   =   "";
	private  String 		protocolo				       =   "";
	private  String 		puerto                         =   "";
	private  String 		asuntoMensaje 				   =   "";
	private  String 		cuerpoMensaje 				   =   "";
	private  int 			copia       				   =   0;
	private  String 		contentType 				   =   "";
	private  boolean 		requiereAuthenticacion 		   =   false;
	private  boolean 		requiereConexionSegura 		   =   false;
	private  boolean		modoDebug 					   =   false;
	private  boolean 		esperarCommandQuit 			   =   false;	
	private  Vector<String> vectorEmailsReceptores   	   =   null;
	private  Vector<String> vectorEmailsReceptores_CC	   =   null;
	private  Vector<String> vectorEmailsReceptores_BCC	   =   null;
	
	private  String 		ubicacionAdjunto			   =   "";
	private  String 		codigoAleatorio  			   =   "";
	private  MimeMultipart  objMultiParte	               =   null;
 
	//Constructores ... 
	public BeanParametrosEmail(){		
	}
	
	public int getId(){
		return id;
	}
	
	public void setId( int id ){
		this.id = id;
	}
	
	public String getUsuario(){
		return usuario;
	}
	
	public void setUsuario( String usuario ){
		this.usuario = usuario;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword( String password ){
		this.password = password;
	}
	
	public String getCuentaEmailRemitente(){
		return cuentaEmailRemitente;
	}
	
	public void setCuentaEmailRemitente( String cuentaEmailRemitente ){
		this.cuentaEmailRemitente = cuentaEmailRemitente;
	}
	
	public String getCuentaEmailDestinatario(){
		return cuentaEmailDestinatario;
	}
	
	public void setCuentaEmailDestinatario( String cuentaEmailDestinatario ){
		this.cuentaEmailDestinatario = cuentaEmailDestinatario;
	}
	
	public String getCuentaEmailDestinatario_Cc(){
		return cuentaEmailDestinatario_Cc;
	}
	
	public void setCuentaEmailDestinatario_Cc( String cuentaEmailDestinatario_Cc ){
		this.cuentaEmailDestinatario_Cc = cuentaEmailDestinatario_Cc;
	}
	
	public String getCuentaEmailDestinatario_Bcc(){
		return cuentaEmailDestinatario_Bcc;
	}
	
	public void setCuentaEmailDestinatario_Bcc( String cuentaEmailDestinatario_Bcc ){
		this.cuentaEmailDestinatario_Bcc = cuentaEmailDestinatario_Bcc;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public void setDireccion( String direccion ){
		this.direccion = direccion;
	}
	
	public String getProtocolo(){
		return protocolo;
	}
	
	public void setProtocolo( String protocolo ){
		this.protocolo = protocolo;
	}
	
	public String getPuerto(){
		return puerto;
	}
	
	public void setPuerto( String puerto ){
		this.puerto = puerto;
	}
	
	public String getAsuntoMensaje(){
		return asuntoMensaje;
	}
	
	public void setAsuntoMensaje( String asuntoMensaje ){
		this.asuntoMensaje = asuntoMensaje;
	}
	
	public String getCuerpoMensaje(){
		return cuerpoMensaje;
	}
	
	public void setCuerpoMensaje( String cuerpoMensaje ){
		this.cuerpoMensaje = cuerpoMensaje;
	}
	
	public int getCopia(){
		return copia;
	}
	
	public void setCopia( int copia ){
		this.copia = copia;
	}
	
	public String getContentType(){
		return contentType;
	}
	
	public void setContentType( String contentType ){
		this.contentType = contentType;
	}
	
	public boolean isRequiereAuthenticacion(){
		return requiereAuthenticacion;
	}
	
	public void setRequiereAuthenticacion( boolean requiereAuthenticacion ){
		this.requiereAuthenticacion = requiereAuthenticacion;
	}
	
	public boolean isRequiereConexionSegura(){
		return requiereConexionSegura;
	}
	
	public void setRequiereConexionSegura( boolean requiereConexionSegura ){
		this.requiereConexionSegura = requiereConexionSegura;
	}
	
	public boolean isModoDebug(){
		return modoDebug;
	}
	
	public void setModoDebug( boolean modoDebug ){
		this.modoDebug = modoDebug;
	}
	
	public boolean isEsperarCommandQuit(){
		return esperarCommandQuit;
	}
	
	public void setEsperarCommandQuit( boolean esperarCommandQuit ){
		this.esperarCommandQuit = esperarCommandQuit;
	}
	
	public Vector<String> getVectorEmailsReceptores(){
		return vectorEmailsReceptores;
	}
	
	public void setVectorEmailsReceptores( Vector<String> vectorEmailsReceptores ){
		this.vectorEmailsReceptores = vectorEmailsReceptores;
	}
	
	public Vector<String> getVectorEmailsReceptores_CC(){
		return vectorEmailsReceptores_CC;
	}

	public void setVectorEmailsReceptores_CC( Vector<String> vectorEmailsReceptores_CC ){
		this.vectorEmailsReceptores_CC = vectorEmailsReceptores_CC;
	}
	
	public Vector<String> getVectorEmailsReceptores_BCC(){
		return vectorEmailsReceptores_BCC;
	}
	
	public void setVectorEmailsReceptores_BCC( Vector<String> vectorEmailsReceptores_BCC ){
		this.vectorEmailsReceptores_BCC = vectorEmailsReceptores_BCC;
	}
	
	public String getUbicacionAdjunto(){
		return ubicacionAdjunto;
	}
	
	public void setUbicacionAdjunto( String ubicacionAdjunto ){
		this.ubicacionAdjunto = ubicacionAdjunto;
	}
	
	public String getCodigoAleatorio(){
		return codigoAleatorio;
	}
	
	public void setCodigoAleatorio( String codigoAleatorio ){
		this.codigoAleatorio = codigoAleatorio;
	}
	
	public MimeMultipart getObjMultiParte(){
		return objMultiParte;
	}
	
	public void setObjMultiParte( MimeMultipart objMultiParte ){
		this.objMultiParte = objMultiParte;
	}

	public static long getSerialVersionUID(){
		return serialVersionUID;
	}
    
 }
 