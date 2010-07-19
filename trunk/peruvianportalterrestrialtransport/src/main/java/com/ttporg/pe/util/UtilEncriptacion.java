package com.ttporg.pe.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import cryptix.util.core.Hex;

/**
 * @author: Ricardo Guerra.
 * @clase:  UtilEncriptacion.java  
 * @descripción: Esta clase la creo con la finalidad del manejo
 *               de encriptacion y desencriptacion de datos, utilizando los algoritmos
 *               'SHA1, MD5, BASE64, CIPHER, SHA1PRNG, SUNJCE, BLOWFISH'.
 * 
 *               Estos algoritmos producen una encriptacion en la que es imposible encontrar 
 *               dos diferentes mensajes que producen el mismo mensaje. 
 *               Si un mensaje se cambia ni siquiera por un solo carácter, el resultado será 
 *               un mensaje totalmente distinto.
 * 
 *               Importante, sobre el algoritmo SHA1 y MD5 son algoritmos para crear "hashes", 
 *               están diseñado para trabajar con el algoritmo de Firma Digital (DSA). Es una 
 *               forma de función de hash. Funciones en un solo sentido se caracterizan por dos 
 *               propiedades. La primera es que son de sentido único. Esto significa que usted 
 *               puede tomar un mensaje y calcular un valor hash, pero no se puede tomar un valor
 *               hash y recrear el mensaje original. También es libre de colisión y, por tanto, 
 *               no hay dos mensajes de hash en el mismo valor. 
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com 
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creación: 02-04-2009.
 * @fecha_de_ultima_actualización: 20-03-2009.
 * @versión: 2.0
 */
public class UtilEncriptacion implements Serializable{

	  private static final long serialVersionUID = 3365758641697960097L;
	
	  private String            algoritmoEncriptacion; 
	  
      private SecureRandom      aleatorioSHA1;
      private SecureRandom      aleatorioMD5;
       
      private MessageDigest     mensajeSHA1;
      private MessageDigest     mensajeMD5;
	  
      private byte[]            arrayBytesSHA1;
      private byte[]            arrayBytesMD5;
	  
	  private UtilConvertidores manejador;
	  
	  private String 			caracterDecodificacion;
      private Cipher 			encriptacionCipher; 
      private Cipher 			desencryptacionCipher; 
      private BASE64Encoder 	base64Encoder;
      private BASE64Decoder 	base64Decoder;
	  
      /** 
       * Constructor.
       */
	  public UtilEncriptacion(){
	    	this.algoritmoEncriptacion  = "";
			this.manejador              = new UtilConvertidores();
	    		    	
	    	this.caracterDecodificacion = "UTF-8";
	    	this.base64Encoder          = new BASE64Encoder();
	    	this.base64Decoder          = new BASE64Decoder();
	    	this.algoritmoEncriptacion  = "";
	    	
	    	//Inicializa 'Algoritmos Encriptacion'.
	    	this.inicializarDatos_MD5(); 
	    	this.inicializarDatos_SHA1();  
	    	this.inicializarDatos_CIPHER(); 
	  }
	  
	  /** 
	   * Ejecuta y prueba el manejo de la Clase.
	   */
	  public static void main( String[] args ){
			
		  try{
			    String  datoEncriptado_01 = null;
			    String  datoEncriptado_02 = null;
			    String  datoEncriptado_03 = null;
			    String  datoEncriptado_04 = null;
			    String  datoEncriptado_05 = null;
			    
			    boolean datoExistente_01  = false; 
			    boolean datoExistente_02  = false;
			    
			    String  datoDesencriptado_03 = null;
			    String  datoDesencriptado_04 = null;
			    String  datoDesencriptado_05 = null;
			    
			    String  llavePrivada = "JavaClavePrivada";  //Maximo 16 Caracterres...
			    String  llavePublica = "JavaClavePublica";  //Maximo 16 Caracterres...
			    
				String  datoOriginal = "Cesar Ricardo Guerra Arnaiz ==> 'JAVAMAN'";		
				System.out.println( "Dato Original a Encriptar: " + datoOriginal );
				
				UtilEncriptacion manejoEncriptacion = new UtilEncriptacion();
				
				/**-------------------------------------**/
				/**--------- ENCRIPTANDO DATOS ---------**/	
				/**-------------------------------------**/
				System.out.println( "" );
				
				datoEncriptado_01 = manejoEncriptacion.encriptarSHA1( datoOriginal );	
				System.out.println( "Dato Encriptado utilizando 'SHA1': "    + datoEncriptado_01 );
				
				datoEncriptado_02 = manejoEncriptacion.encriptarMD5( datoOriginal );	
				System.out.println( "Dato Encriptado utilizando 'MD5': "     + datoEncriptado_02 );	
				
				//datoEncriptado_03   = //manejoEncriptacion.encriptarBASE64( datoOriginal );
				///System.out.println( "Dato Encriptado utilizando 'BASE64': "  + datoEncriptado_03 );
				
				datoEncriptado_04   = manejoEncriptacion.encriptarCIPHER( datoOriginal );		
				System.out.println( "Dato Encriptado utilizando 'CIPHER': "  + datoEncriptado_04 );
					
				datoEncriptado_05 = manejoEncriptacion.encriptarBLOWFISH( datoOriginal, llavePrivada );
				System.out.println( "Dato Encriptado utilizando 'BLOWFISH': "  + datoEncriptado_05 );
				
				
				/**------------------------------------**/
				/**------- DESENCRIPTANDO DATOS -------**/	
				/**------------------------------------**/ 
				System.out.println( "" );
				datoExistente_01 = manejoEncriptacion.comparaDatoEncriptadoSHA1( datoOriginal, datoEncriptado_01 );
				System.out.println( "Dato Comparado Existente 'SHA1': " + datoExistente_01 );
				
				datoExistente_02 = manejoEncriptacion. comparaDatoEncriptadoMD5( datoOriginal, datoEncriptado_02 );
				System.out.println( "Dato Comparado Existente 'MD5': " + datoExistente_02 );
				
				//datoDesencriptado_03 = manejoEncriptacion.desencriptarBASE64( datoEncriptado_03 );
				//System.out.println( "Dato Desencriptado utilizando 'BASE64': " + datoDesencriptado_03 );
				
				datoDesencriptado_04 = manejoEncriptacion.desencriptarCIPHER( datoEncriptado_04 );
				System.out.println( "Dato Desencriptado utilizando 'CIPHER': " + datoDesencriptado_04 );

				datoDesencriptado_05 = manejoEncriptacion.desencriptarBLOWFISH( datoEncriptado_05, llavePrivada );	   
				System.out.println( "Dato Desencriptado utilizando 'BLOWFISH': " + datoDesencriptado_05 );
		   }
		   catch( Exception e ){
		 		  e.printStackTrace();
		   }
	  }		
	  
	  /*****************************************************/
	  /**************** ENCRIPTACION 'SHA1' ****************/
	  /*****************************************************/
	  
	  /**
	   * inicializarDatos_SHA1 prepara variables para el manejo del algoritmo 'SHA1'.
	   */  
	  public void inicializarDatos_SHA1(){	
	      
		  try{
			   this.algoritmoEncriptacion = "SHA1PRNG";
			   this.aleatorioSHA1  = SecureRandom.getInstance( this.algoritmoEncriptacion );
			    
			   this.algoritmoEncriptacion = "SHA-1"; 
			   this.mensajeSHA1    = MessageDigest.getInstance( this.algoritmoEncriptacion );
			   this.arrayBytesSHA1 = new byte[2];
	      }
	      catch( NoSuchAlgorithmException e ){
			     e.printStackTrace();
		  }
	      catch( Exception e ){
			     e.printStackTrace();
		  }
	  }
	  		
	  /**
	   * encriptarSHA1 Encripta una cadena usando el algoritmo 'SHA-1'
	   * @param  cadena 
	   * @return String
	   */
	  public String encriptarSHA1( String cadena ){
		  String datoEncriptado = this.encriptaDatoSHA1( cadena, this.getDatoAleatorioSHA1() );  
	      return datoEncriptado;
	  }
		  
	  /**
	   * comparaDatoEncriptadoSHA1 Verifica si una cadena sin encriptar (cadenaSiEncriptada), es igual 
	   *                           que una cadena encriptada (cadenaNoEncriptada).
	   * @param  cadenaSiEncriptada 
	   * @param  cadenaNoEncriptada 
	   * @return boolean
	   */
	  public boolean comparaDatoEncriptadoSHA1( String cadenaSiEncriptada, String cadenaNoEncriptada ){
	    
		boolean resultado = false;
	    
	    if( cadenaNoEncriptada != null ){
    	
	        String encriptado = this.encriptaDatoSHA1( cadenaSiEncriptada, this.getCadenaEncriptadaReducidaSHA1( cadenaNoEncriptada ) );
	        
	        if( cadenaNoEncriptada.equals( encriptado ) ){
	            resultado = true;
	        }
	    }
	    
	    return resultado;
	  } 	  
	  
	  //--------------------------- METODOS 'PRIVATE' ---------------------------/	  		
	  /**
	   * encriptaDatoSHA1 Encripta una cadena usando el algoritmo 'SHA-1'
	   * @param  cadenaNoEncriptada 
	   * @param  datoAleatorio 
	   * @return String
	   */
	  private String encriptaDatoSHA1( String cadenaNoEncriptada, String datoAleatorio ){
		    
			String cadena = cadenaNoEncriptada + datoAleatorio;
		    
		    byte[] arrayBytesHash = null; 
		    
		    synchronized( this.mensajeSHA1 ){
		    	this.mensajeSHA1.reset();
		    	this.mensajeSHA1.update( cadena.getBytes() );
		        arrayBytesHash = this.mensajeSHA1.digest();
		    }
		    
		    String datoHexagesinal = (this.getDatoHexagesinalSHA1( arrayBytesHash ) + datoAleatorio);
		    
		    return datoHexagesinal;
	  } 
		
	  /**
	   * getDatoAleatorioSHA1 Obtiene un dato aleatorio en 'Bytes' y un dato Hexagesimal.
	   * @return String
	   */
	  private String getDatoAleatorioSHA1(){
	      synchronized( this.aleatorioSHA1 ){
	    	 this.aleatorioSHA1.nextBytes( this.arrayBytesSHA1 );
	      }
	      String datoHexagesimal = this.getDatoHexagesinalSHA1( this.arrayBytesSHA1 );
	      return datoHexagesimal;
	  }	  
	  
	  /**
	   * getDatoHexagesinalSHA1 Convierte un dato en Bytes[] a Hexagesimal.
	   * @param  arrayBytesHash 
	   * @return String
	   */
	  private String getDatoHexagesinalSHA1( byte[] arrayBytesHash ){
		  StringBuffer cadena   = new StringBuffer();
		  String       caracter = Hex.dumpString( arrayBytesHash );
		  
		  for( int i=0; i<caracter.length(); i++ ){
			   if( (caracter.charAt(i) != ' ') && (caracter.charAt(i) != '\n') ){
				   cadena.append( caracter.charAt( i ) );
			   }	  
		  }
		  
		  return cadena.toString();
	  }		 
	  
	  /**
	   * getCadenaEncriptadaReducidaSHA1 Reduce el tamaño de una cadena encriptada (Obtiene ultimo digitos).
	   * @param  cadenaEncriptada 
	   * @return String
	   */
	  private String getCadenaEncriptadaReducidaSHA1( String cadenaEncriptada ){

		  String cadena = cadenaEncriptada.substring( cadenaEncriptada.length() - 4 );
		  
		  return cadena;
	  }
	  //--------------------------------------------------------------------------/
	  
	  
	  /*****************************************************/
	  /**************** ENCRIPTACION 'MD5' *****************/
	  /*****************************************************/
	  
	  /**
	   * inicializarDatos_MD5 prepara variables para el manejo del algoritmo 'MD5'.
	   */
	  public void inicializarDatos_MD5(){	
	      try{	
			   this.algoritmoEncriptacion = "SHA1PRNG";
			   this.aleatorioMD5  = SecureRandom.getInstance( this.algoritmoEncriptacion );
			    
			   this.algoritmoEncriptacion =  "MD5"; 
			   this.mensajeMD5    = MessageDigest.getInstance( this.algoritmoEncriptacion );
			   this.arrayBytesMD5 = new byte[2];
	      }
	      catch( NoSuchAlgorithmException e ){
			     e.printStackTrace();
		  }
	      catch( Exception e ){
			     e.printStackTrace();
		  }
	  }	
	 
	  /**
	   * encriptarMD5 Encripta una cadena usando el algoritmo 'MD5'
	   * @param  cadena 
	   * @return String
	   */
	  public String encriptarMD5( String cadena ){
			String datoEncriptado = this.encriptaDatoMD5( cadena, this.getDatoAleatorioMD5() );  
		    return datoEncriptado;
	  }
	  
	  /**
	   * comparaDatoEncriptadoMD5  Verifica si una cadena sin encriptar (cadenaSiEncriptada), es igual 
	   *                           que una cadena encriptada (cadenaNoEncriptada).
	   * @param  cadenaSiEncriptada 
	   * @param  cadenaNoEncriptada 
	   * @return boolean
	   */
	  
	  public boolean comparaDatoEncriptadoMD5( String cadenaSiEncriptada, String cadenaNoEncriptada ){
		    
			boolean resultado = false;
		    
		    if( cadenaNoEncriptada != null ){
	    	
		        String encriptado = this.encriptaDatoMD5( cadenaSiEncriptada, this.getCadenaEncriptadaReducidaMD5( cadenaNoEncriptada ) );
		        
		        if( cadenaNoEncriptada.equals( encriptado ) ){
		            resultado = true;
		        }
		    }
		    
		    return resultado;
		  }
	  
	  //--------------------------- METODOS 'PRIVATE' ---------------------------/	
	  /**
	   * encriptaDatoMD5 Encripta una cadena usando el algoritmo 'MD5'
	   * @param  cadenaNoEncriptada 
	   * @param  datoAleatorio 
	   * @return String
	   */
	  private String encriptaDatoMD5( String cadenaNoEncriptada, String datoAleatorio ){
		    
			String cadena = cadenaNoEncriptada + datoAleatorio;
		    
		    byte[] arrayBytesHash = null; 
		    
		    synchronized( this.mensajeMD5 ){
		    	this.mensajeMD5.reset();
		    	this.mensajeMD5.update( cadena.getBytes() );
		        arrayBytesHash = this.mensajeMD5.digest();
		    }
		    
		    String datoHexagesinal = (this.getDatoHexagesinalMD5( arrayBytesHash ) + datoAleatorio);
		    
		    return datoHexagesinal;
	  }	 
	  
	  /**
	   * getDatoAleatorioMD5 Obtiene un dato aleatorio en 'Bytes' y un dato Hexagesimal.
	   * @return String
	   */
	  private String getDatoAleatorioMD5(){
	      synchronized( this.aleatorioMD5 ){
	    	 this.aleatorioMD5.nextBytes( this.arrayBytesMD5 );
	      }
	      String datoHexagesimal = this.getDatoHexagesinalMD5( this.arrayBytesMD5 );
	      return datoHexagesimal;
	  }
	  
	  /**
	   * getDatoHexagesinalMD5 Convierte un dato en Bytes[] a Hexagesimal.
	   * @param  arrayBytesHash 
	   * @return String
	   */
	  private String getDatoHexagesinalMD5( byte[] arrayBytesHash ){
		  StringBuffer cadena   = new StringBuffer();
		  String       caracter = Hex.dumpString( arrayBytesHash );
		  
		  for( int i=0; i<caracter.length(); i++ ){
			   if( (caracter.charAt(i) != ' ') && (caracter.charAt(i) != '\n') ){
				   cadena.append( caracter.charAt( i ) );
			   }	  
		  }
		  
		  return cadena.toString();
	  }	

	  /**
	   * getCadenaEncriptadaReducidaMD5 Reduce el tamaño de una cadena encriptada (Obtiene ultimo digitos).
	   * @param  cadenaEncriptada 
	   * @return String
	   */
	  private String getCadenaEncriptadaReducidaMD5( String cadenaEncriptada ){

		  String cadena = cadenaEncriptada.substring( cadenaEncriptada.length() - 4 );
		  
		  return cadena;
	  }	  
	  //--------------------------------------------------------------------------/
	  
	  
	  /*****************************************************/
	  /*************** ENCRIPTACION 'BASE65' ***************/
	  /*****************************************************/
	  
	
	  
	  
	  /*****************************************************/
	  /*************** ENCRIPTACION 'CIPHER' ***************/
	  /*****************************************************/
	  
	  /**
	   * inicializarDatos_CIPHER prepara variables para el manejo del algoritmo 'CIPHER'.
	   */
	  public void inicializarDatos_CIPHER(){			
	    	 try{
	    	    //Make sure SUN JCE are a provider.
	    	    Security.addProvider( new com.sun.crypto.provider.SunJCE() );
		        					
				final byte[] keyBytes =	{
										  0x21, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
										  0x09, 0x0a, 0x3b, 0x0c, 0x0d, 0x4e, 0x0f, 0x10,
										  0x01, 0x02, 0x03, 0x04, 0x15, 0x06, 0x07, 0x08,
						                };
		
				final byte[] ivBytes  = {
										  0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07
									    };  
				
		    	this.algoritmoEncriptacion = "DESede";
				SecretKey       key = new SecretKeySpec(   keyBytes, this.algoritmoEncriptacion );
		        IvParameterSpec iv  = new IvParameterSpec( ivBytes );
		        
		        
		    	this.algoritmoEncriptacion = "SunJCE";
		        //Inicializando Encriptacion 'Cipher'.
		        this.encriptacionCipher    = Cipher.getInstance( "DESede/CBC/PKCS5Padding", "SunJCE" );
		        this.encriptacionCipher.init( javax.crypto.Cipher.ENCRYPT_MODE, key, iv );
		      
		        //Inicializando Desencriptacion 'Cipher'.
		        this.desencryptacionCipher = Cipher.getInstance( "DESede/CBC/PKCS5Padding", "SunJCE" );
		        this.desencryptacionCipher.init( javax.crypto.Cipher.DECRYPT_MODE, key, iv );	
			}
			catch( Exception e ){
				e.printStackTrace();
			}  
	  }
	  
	  /**
	   * encriptarCIPHER Encripta una cadena usando el algoritmo 'CIPHER'
	   * @param  cadena 
	   * @return String
	   */ 
	  public String encriptarCIPHER( String cadena ) throws Exception{
		 
		  String datoEncriptado = null;
		  
		  try{	
		      byte[] cadenaArrayBytes = cadena.getBytes( this.caracterDecodificacion );
	          byte[] cadenaEncriptada = this.encriptacionCipher.doFinal( cadenaArrayBytes );
	          datoEncriptado   = this.base64Encoder.encode( cadenaEncriptada );
		  }
		  catch( Exception e ){
			     e.printStackTrace();
		  }
		  
		  return datoEncriptado;
	  }
	    
	  /**
	   * desencriptarCIPHER Desencripta una cadena usando el algoritmo 'CIPHER'
	   * @param  cadena 
	   * @return String
	   */ 
	  public String desencriptarCIPHER( String cadenaEncryptada ) throws Exception{
			 
		  String datoDesenCriptado = null;
		  
		  try{	
		      byte[] cadenaArrayBytes  = this.base64Decoder.decodeBuffer( cadenaEncryptada );
	          byte[] cadenaEncriptada  = this.desencryptacionCipher.doFinal( cadenaArrayBytes );
	          datoDesenCriptado = new String( cadenaEncriptada, this.caracterDecodificacion );
		  }
		  catch( Exception e ){
			     e.printStackTrace();
		  }
	      
		  return datoDesenCriptado;
	  }
	    
	  
	  /*****************************************************/
	  /************** ENCRIPTACION 'BLOWFISH' **************/
	  /*****************************************************/
	  
	  public String encriptarBLOWFISH( String cadena, String key ){
			 
		  String datoEncriptado = null;
		  
		  try{
			  datoEncriptado = this.crypt( cadena, key, Cipher.ENCRYPT_MODE );
		  } 
		  catch( Exception e ){
			     e.printStackTrace();
		  }
		  
		  return datoEncriptado;
	  }
	  
	  public String desencriptarBLOWFISH( String cadena, String key ){
			
		  String datoDesenCriptado = null;
		  
		  try{
			  datoDesenCriptado = this.crypt( cadena, key, Cipher.DECRYPT_MODE );
		  } 
		  catch( Exception e ){
			     e.printStackTrace();
		  }
			
		  return datoDesenCriptado;
	  }
	  
	  //--------------------------- METODOS 'PRIVATE' ---------------------------/
	  private String crypt( String input, String key, int mode ){
			
		   String datoEncriptado = null;
		   
		   try{
			    //Proveedor
				Provider proveedor = new com.sun.crypto.provider.SunJCE();
				Security.addProvider(proveedor);
	
				this.algoritmoEncriptacion = "Blowfish";
				KeyGenerator generador = KeyGenerator.getInstance( this.algoritmoEncriptacion );
				generador.init( 448 );
				SecretKey llaveSecreta = generador.generateKey();
				
				byte[] arrayBytes = key.getBytes();
				SecretKeySpec llaveSecretaEpecifico = new SecretKeySpec( arrayBytes, this.algoritmoEncriptacion );
	
				Cipher cipher = Cipher.getInstance( "Blowfish/ECB/PKCS5Padding" );
				cipher.init( mode, llaveSecretaEpecifico );
	
				ByteArrayOutputStream salidaStream  = new ByteArrayOutputStream();
				ByteArrayInputStream  entradaStream = new ByteArrayInputStream( input.getBytes() );
				CipherOutputStream    salida        = new CipherOutputStream(   salidaStream, cipher );
	
				int    length = 0;
				byte[] buffer = new byte[8192];
	
				while( ( length = entradaStream .read( buffer ) ) != -1 ){
					salida.write( buffer, 0, length );
				}
	
				entradaStream.close();
				salida.close();
				
				datoEncriptado = salidaStream.toString();
		  } 
		  catch( Exception e ){
			     e.printStackTrace();
		  }
		  
		  return datoEncriptado;
	  }	  
	  //--------------------------------------------------------------------------/
	  
}

