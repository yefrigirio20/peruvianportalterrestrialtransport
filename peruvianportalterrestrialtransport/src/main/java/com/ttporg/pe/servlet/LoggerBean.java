package com.ttporg.pe.servlet;

/**
 * @author: Ricardo Guerra.
 * @clase: LoggerBean.java  
 * @descripción: clase que muestra el manejo de los logs de salida.
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com 
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creación: 10-01-2009.
 * @fecha_de_ultima_actualización: 23-07-2009.
 * @versión: 1.0
 **/
public class LoggerBean{

   private static org.apache.log4j.Logger loggerLog4j = null;
   
   private String nombreClase;
   
   //Constructor.   
   public LoggerBean( String nombreClase ){	   
	   this.nombreClase = nombreClase;
	   
	   loggerLog4j   = org.apache.log4j.Logger.getLogger( this.nombreClase );  
   }
   
   public static void main( String[] args ){

   	    LoggerBean imprimerLogger = new LoggerBean( "" );
   	 
   	    imprimerLogger.manejoLog4jLogger();
   	}
   
	/**
	 * manejoLog4jLogger.
	 */	
   public void manejoLog4jLogger(){  
	   	 System.out.println( "" );
    	 System.out.println( "NIVELES IMPRESION 'org.apache.log4j.Logger'" );
    	 System.out.println( "-------------------------------------------" );  
	  	 
    	 this.getLoggerLog4j().info(  "Log4jLogger NIVEL: 'INFO'"  );
		 this.getLoggerLog4j().debug( "Log4jLogger NIVEL: 'DEBUG'" );
	  	 this.getLoggerLog4j().error( "Log4jLogger NIVEL: 'ERROR'" );
	  	 this.getLoggerLog4j().warn(  "Log4jLogger NIVEL: 'WARN'"  );
	  	 this.getLoggerLog4j().trace( "Log4jLogger NIVEL: 'TRACE'" );
	  	 this.getLoggerLog4j().fatal( "Log4jLogger NIVEL: 'FATAL'" );
    }  
		
	/**
	 * @return Returns the loggerLog4j.
	 */
	public org.apache.log4j.Logger getLoggerLog4j(){
		return loggerLog4j;
	}
	
 }

