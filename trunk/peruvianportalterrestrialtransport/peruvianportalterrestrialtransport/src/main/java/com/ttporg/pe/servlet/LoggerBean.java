package com.ttporg.pe.servlet;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

/**
 * @author: Ricardo Guerra.
 * @clase: LoggerBean.java  
 * @descripción: clase que muestra el manejo de los logs de salida.
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com 
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creación: 10-01-2009.
 * @fecha_de_ultima_actualización: 23-07-2009.
 * @versión: 1.0
 */
public class LoggerBean{

   private static final org.apache.log4j.Logger        loggerLog4j   = org.apache.log4j.Logger.getLogger( LoggerBean.class );
   private static final org.apache.commons.logging.Log loggerCommons = org.apache.commons.logging.LogFactory.getLog( LoggerBean.class );	
   private static final java.util.logging.Logger       loggerUtil    = java.util.logging.Logger.getLogger( "UtilLogger" );	 
   
   //Constructor.
   public LoggerBean(){
   }
   
   public static void main( String[] args ){

   	    LoggerBean imprimerLogger = new LoggerBean();
   	 
   	    imprimerLogger.manejoLog4jLogger();
   	    imprimerLogger.manejoCommonsLogger();
   	    imprimerLogger.manejoUtilLogger();   
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
	 * manejoCommonsLogger.
	 */
    public void manejoCommonsLogger(){   	
	   	 System.out.println( "" );
    	 System.out.println( "NIVELES IMPRESION 'org.apache.commons.logging.Log'" );
    	 System.out.println( "--------------------------------------------------" );  
	   	 
    	 this.getLoggerCommons().info(  "CommonsLogger NIVEL: 'INFO'"  );
   	     this.getLoggerCommons().debug( "CommonsLogger NIVEL: 'DEBUG'" );
   	     this.getLoggerCommons().error( "CommonsLogger NIVEL: 'ERROR'" );
   	     this.getLoggerCommons().warn(  "CommonsLogger NIVEL: 'WARN'"  );
   	     this.getLoggerCommons().trace( "CommonsLogger NIVEL: 'TRACE'" );
   	     this.getLoggerCommons().fatal( "CommonsLogger NIVEL: 'FATAL'" );
    }
    
	/**
	 * manejoUtilLogger.
	 */
    public void manejoUtilLogger(){      	
	   	 System.out.println( "" );
    	 System.out.println( "NIVELES IMPRESION 'java.util.logging.Logger'" );
   	     System.out.println( "--------------------------------------------" );  
    	 
   	     //FORMA #1:
   	     System.out.println( "FORMA #1" );  
	     this.getLoggerUtil().info(    "UtilLogger NIVEL: 'INFO'"    );
	     this.getLoggerUtil().warning( "UtilLogger NIVEL: 'WARNING'" );
	     this.getLoggerUtil().severe(  "UtilLogger NIVEL: 'SEVERE'"  );  	
	    
    	 //FORMA #2:
   	     System.out.println( "FORMA #2" );  
	     this.getLoggerUtil().log( Level.INFO,    "UtilLogger NIVEL: 'INFO'"    );
	     this.getLoggerUtil().log( Level.WARNING, "UtilLogger NIVEL: 'WARNING'" );
	     this.getLoggerUtil().log( Level.SEVERE,  "UtilLogger NIVEL: 'SEVERE'"  );  	  
    } 
   
	/**
	 * @return Returns the loggerCommons.
	 */
	public org.apache.commons.logging.Log getLoggerCommons(){
	    return loggerCommons;
	}
		
	/**
	 * @return Returns the loggerLog4j.
	 */
	public org.apache.log4j.Logger getLoggerLog4j(){
		return loggerLog4j;
	}
	
	/**
	 * @return Returns the loggerUtil.
	 */
	public java.util.logging.Logger getLoggerUtil(){
		
		try{
			FileHandler fileHandler = new FileHandler();		
			Formatter   formato     = new SimpleFormatter();

		    fileHandler.setFormatter( formato );
		     
		    loggerUtil.addHandler( fileHandler );
		    loggerUtil.setLevel(   Level.ALL   );  
		}
		catch( Exception e ){
		       e.printStackTrace();
		}
		
		return loggerUtil;
	}
	
 }

