package com.ttporg.pe.util;

import java.io.File;

/**
 * @author: Ricardo Guerra.
 * @clase:  UtilContentType.java  
 * @descripción: Clase POJO utilitario para la validacion de formatos de ficheros Content Type.
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com 
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creación: 05-08-2009.
 * @fecha_de_ultima_actualización: 20-03-2009.
 * @versión: 2.0
 */
public final class UtilContentType{

  /** 
   * Ejecuta y prueba el manejo de la Clase.
   */
   public static void main( String[] args ){	    
		UtilContentType contentType = new UtilContentType(); 
		String  resultado =  (String)contentType.getContenTypeByString( "MiArchivo.ppt" );
	    System.out.println( "CONTENT TYPE: " + resultado );
	}
	
  /** 
   * Constructor.
   */
   public UtilContentType(){
   }
	
    /** Tipos de 'MIME TYPES' **/
    public static final String[][] MIME_TYPE_MAPPINGS = { { 
    	  
	    	"3dm",        "x-world/x-3dmf" }, {
	    	"3dmf",       "x-world/x-3dmf" }, {
	    	"a",          "application/octet-stream" }, {
	    	"aab",        "application/x-authorware-bin" }, {
	    	"aam",        "application/x-authorware-map" }, {	    	 
	    	"aas",        "application/x-authorware-seg" }, {
	    	"abc",        "text/vnd.abc" }, { 	
    	    "abs", 		  "audio/x-mpeg" }, {
            "ai", 		  "application/postscript" }, {
            "aif", 		  "audio/x-aiff" }, {
            "aifc", 	  "audio/x-aiff" }, {
            "aiff", 	  "audio/x-aiff" }, {
            "aim", 		  "application/x-aim" }, {
            "art", 		  "image/x-jg" }, {
            "asf", 		  "video/x-ms-asf" }, {
            "asx",		  "video/x-ms-asf" }, {
            "au", 		  "audio/basic" }, {
            "avi",		  "video/x-msvideo" }, {
            "avx",		  "video/x-rad-screenplay" }, {
            "bcpio",	  "application/x-bcpio" }, {
            "bin", 		  "application/octet-stream" }, {
            "bmp", 		  "image/bmp" }, {
            "body",		  "text/html" }, {
            "cdf", 		  "application/x-cdf" }, {
            "cer", 		  "application/x-x509-ca-cert" }, {
            "class",	  "application/java" }, {
            "cpio", 	  "application/x-cpio" }, {
            "csh",		  "application/x-csh" }, {
            "css",		  "text/css" }, {            	
        	"chat",       "application/x-chat" }, {
        	"class",      "application/java" }, {
        	"class",      "application/java-byte-code" }, {
        	"class",      "application/x-java-class" }, {
        	"com",        "application/octet-stream" }, {
        	"com",        "text/plain" }, {
        	"conf",        "text/plain" }, {  
            "dib",		  "image/bmp" }, {
            "doc",		  "application/msword" }, {
            "docx",       "application/vnd.openxmlformats-officedocument.wordprocessingml.document" }, {            	
            "dtd",		  "text/plain" }, {
            "dv", 		  "video/x-dv" }, {
            "dvi", 		  "application/x-dvi" }, {
            "eps",		  "application/postscript" }, {
            "etx",		  "text/x-setext" }, {
            "exe",		  "application/octet-stream" }, {            	
            "gif",		  "image/gif" }, {
            "gtar",		  "application/x-gtar" }, {
            "gz", 		  "application/x-gzip" }, {
            "hdf", 		  "application/x-hdf" }, {
            "hqx", 		  "application/mac-binhex40" }, {
            "htc",		  "text/x-component" }, {
            "htm",		  "text/html" }, {
            "html",		  "text/html" }, {            	
            "hqx", 		  "application/binhex" }, {
        	"hqx", 		  "application/binhex4" }, {
        	"hqx", 		  "application/mac-binhex" }, {
        	"hqx", 		  "application/mac-binhex40" }, {
        	"hqx", 		  "application/x-binhex40" }, {
        	"hqx", 		  "application/x-mac-binhex40" }, {
        	"hta", 		  "application/hta" }, {
        	"htc", 		  "text/c-component" }, {
        	"htm", 		  "text/html" }, {
        	"html", 	  "text/html" }, {
        	"htmls", 	  "text/html" }, { 
            "ief", 		  "image/ief" }, {
            "jad", 		  "text/vnd.sun.j2me.app-descriptor" }, {
            "jar", 		  "application/java-archive" }, {
            "java", 	  "text/plain" }, {
            "jnlp", 	  "application/x-java-jnlp-file" }, {
            "jpe", 		  "image/jpeg" }, {
            "jpeg", 	  "image/jpeg" }, {
            "jpg",		  "image/jpeg" }, {
            "js", 		  "text/javascript" }, {
            "jsf", 		  "text/plain" }, {
            "jspf",		  "text/plain" }, {
            "kar", 		  "audio/x-midi" }, {
            "latex",	  "application/x-latex" }, {
            "m3u",		  "audio/x-mpegurl" }, {
            "mac",		  "image/x-macpaint" }, {
            "man",		  "application/x-troff-man" }, {
            "me", 		  "application/x-troff-me" }, {
            "mid", 		  "audio/x-midi" }, {
            "midi", 	  "audio/x-midi" }, {
            "mif",		  "application/x-mif" }, {
            "mov",		  "video/quicktime" }, {
            "movie", 	  "video/x-sgi-movie" }, {
            "mp1", 		  "audio/x-mpeg" }, {           	
            "mp2", 		  "audio/mpeg" }, {
    		"mp2", 		  "audio/x-mpeg" }, {
        	"mp2", 		  "video/mpeg" }, {
        	"mp2", 		  "video/x-mpeg" }, {
        	"mp2", 		  "video/x-mpeq2a" }, {        		
        	"mp3", 		  "audio/x-mpeg" }, {
        	"mp3", 		  "audio/mpeg3" }, {
        	"mp3", 		  "audio/x-mpeg3" }, {
        	"mp3", 		  "video/mpeg" }, {
        	"mp3", 		  "video/x-mpeg" }, {
        	"mpa", 		  "audio/mpeg" }, {
        	"mpa", 		  "video/mpeg" }, {            	
            "mpa", 		  "audio/x-mpeg" }, {
            "mpe", 		  "video/mpeg" }, {
            "mpeg",		  "video/mpeg" }, {
            "mpega",	  "audio/x-mpeg" }, {
            "mpg", 		  "video/mpeg" }, {
            "mpv2", 	  "video/mpeg2" }, {
            "ms", 		  "application/x-wais-source" }, {            	
        	"mid", 		  "application/x-midi" }, {
        	"mid", 		  "audio/midi" }, {
        	"mid", 		  "audio/x-mid" }, {
        	"mid", 		  "audio/x-midi" }, {
        	"mid", 		  "music/crescendo" }, {
        	"mid", 		  "x-music/x-midi" }, {
        	"midi", 	  "application/x-midi" }, {
        	"midi", 	  "audio/midi" }, {
        	"midi", 	  "audio/x-mid" }, {
        	"midi", 	  "audio/x-midi" }, {
        	"midi", 	  "music/crescendo" }, {
        	"midi", 	  "x-music/x-midi" }, {
        	"mif", 		  "application/x-frame" }, {
        	"mif", 		  "application/x-mif" }, {
        	"mime", 	  "message/rfc822" }, {
        	"mime", 	  "www/mime" }, {            	
            "nc", 		  "application/x-netcdf" }, {            	
            "nif", 		  "image/x-niff" }, {
            "niff", 	  "image/x-niff" }, {  
            "oda", 		  "application/oda" }, {
            "pbm", 		  "image/x-portable-bitmap" }, {
            "pct", 		  "image/pict" }, {
            "pdf", 		  "application/pdf" }, {
            "pgm", 		  "image/x-portable-graymap" }, {           
        	"pgm", 		  "image/x-portable-graymap" }, {
        	"pgm", 		  "image/x-portalbe-greymap" }, {
        	"pic", 		  "image/pict" }, {
        	"pict", 	  "image/pict" }, {     	
            "pls", 		  "audio/x-scpls" }, {
            "png", 		  "image/png" }, {
            "pnm", 		  "image/x-portable-anymap" }, {
            "pnt", 		  "image/x-macpaint" }, {
            "ppm", 		  "image/x-portable-pixmap" }, { 
        	"pps",        "application/vnd.ms-powerpoint" }, {
            "pps",        "application/mspowerpoint" }, {
        	"ppt",        "application/vnd.ms-powerpoint" }, {
            "ppt",        "application/mspowerpoint" }, {
            "ppt",        "application/powerpoint" }, {
            "ppt",        "application/x-ms-powerpoint" }, {
            "pptx",       "application/vnd.openxmlformats-officedocument.presentationml.presentation" }, {
 	        "pot",        "application/vnd.ms-powerpoint" }, {             	
            "ps", 		  "application/postscript" }, {
            "psd",        "image/x-photoshop" }, {
            "qt",         "video/quicktime" }, {
            "qti", 		  "image/x-quicktime" }, {
            "qtif", 	  "image/x-quicktime" }, {
            "ras", 		  "image/x-cmu-raster" }, {
            "rar",        "application/x-rar-compressed" }, {	
            "rgb", 		  "image/x-rgb" }, {
            "rm", 		  "application/vnd.rn-realmedia" }, {
            "roff", 	  "application/x-troff" }, {
            "rtf", 		  "application/rtf" }, {
            "rtx", 		  "text/richtext" }, {
            "sh", 		  "application/x-sh" }, {
            "shar", 	  "application/x-shar" }, {
            "smf", 		  "audio/x-midi" }, {
            "snd", 		  "audio/basic" }, {
            "src", 		  "application/x-wais-source" }, {
            "sv4cpio",    "application/x-sv4cpio" }, {
            "sv4crc", 	  "application/x-sv4crc" }, {
            "swf", 		  "application/x-shockwave-flash" }, {
            "t",          "application/x-troff" }, {
            "tar", 		  "application/x-tar" }, {
            "tcl", 		  "application/x-tcl" }, {
            "tex", 		  "application/x-tex" }, {
            "texi", 	  "application/x-texinfo" }, {
            "texinfo", 	  "application/x-texinfo" }, {
            "tif", 		  "image/tiff" }, {
            "tiff", 	  "image/tiff" }, {
            "tr",         "application/x-troff" }, {
            "tsv", 		  "text/tab-separated-values" }, {
            "txt", 		  "text/plain" }, {            	
        	"txt", 		  "text/plain" }, {
        	"uil", 		  "text/x-uil" }, {
        	"uni", 		  "text/uri-list" }, {
        	"unis", 	  "text/uri-list" }, {
        	"unv", 		  "application/i-deas" }, {
        	"uri", 		  "text/uri-list" }, {
        	"uris", 	  "text/uri-list" }, {            	
            "ulw", 		  "audio/basic" }, {
            "ustar", 	  "application/x-ustar" }, {            	
        	"vrt", 		  "x-world/x-vrt" }, {
        	"vsd", 		  "application/x-visio" }, {
        	"vst", 		  "application/x-visio" }, {
        	"vsw", 		  "application/x-visio" }, {
        	"w60", 		  "application/wordperfect6.0" }, {
        	"w61", 		  "application/wordperfect6.1" }, {
        	"w6w", 		  "application/msword" }, {
        	"wav", 		  "audio/wav" }, {
        	"wav", 		  "audio/x-wav" }, {
        	"wb1", 		  "application/x-qpro" }, {
        	"wbmp", 	   "image/vnd.wap.wbmp" }, {
        	"web", 		  "application/vnd.xara" }, {
        	"wiz", 		  "application/msword" }, {
        	"wk1", 		  "application/x-123" }, {
        	"wmf", 		  "window/metafile" }, {
        	"wml", 		  "text/vnd.wap.wml" }, {
        	"wmlc", 	  "applciation/vnd.wap.wmlc" }, {
        	"wmls", 	  "text/vnd.wap.wmlscript" }, {
        	"wmlsc", 	  "application/vnd.wap.wmlscriptc" }, {
        	"word", 	  "application/msword" }, {
        	"wp", 		  "application/wordperfect" }, {
        	"wp5", 		  "application/wordperfect" }, {
        	"wp5", 		  "application/wordperfect6.0" }, {
        	"wp6", 		  "application/wordperfect" }, {
        	"wpd", 		  "application/wordperfect" }, {
        	"wpd", 		  "application/x-wpwin" }, {
        	"wq1", 		  "application/x-lotus" }, {
        	"wri", 		  "application/mswrite" }, {
        	"wri", 		  "application/x-wri" }, {
        	"wrl", 		  "application/x-world" }, {
        	"wrl", 		  "model/vrml" }, {
        	"wrl", 		  "x-world/x-vrml" }, {
        	"wrz", 		  "model/vrml" }, {
        	"wrz", 		  "x-world/x-vrml" }, {
        	"wsc", 		  "text/scriplet" }, {
        	"wsrc", 	  "application/x-wais-source" }, {
        	"wtk", 		  "application/x-wintalk" }, {
        	"xbm", 		  "image/x-xbitmap" }, {
        	"xbm", 		  "image/x-xbm" }, {
        	"xbm", 		  "image/xbm" }, {
        	"xdr", 		  "video/x-amt-demorun" }, {            	
            "xbm", 		  "image/x-xbitmap" }, {
            "xml", 		  "text/xml" }, {
            "xpm", 		  "image/x-xpixmap" }, {
            "xsl",        "text/xml" }, {
            "xls",        "application/vnd.ms-excel" }, {            	
            "xwd",        "image/x-xwindowdump" }, {            	
        	"xif", 		  "image/vnd.xiff" }, {
        	"xl", 		  "application/excel" }, {
        	"xla", 		  "application/excel" }, {
        	"xla", 		  "application/x-excel" }, {
        	"xla", 		  "application/x-msexcel" }, {
        	"xlb", 		  "application/excel" }, {
        	"xlb", 		  "application/vnd.ms-excel" }, {
        	"xlb", 		  "application/x-excel" }, {
        	"xlc", 		  "application/excel" }, {
        	"xlc", 		  "application/vnd.ms-excel" }, {
        	"xlc", 		  "application/x-excel" }, {
        	"xld", 		  "application/excel" }, {
        	"xld", 		  "application/x-excel" }, {
        	"xlk", 		  "application/excel" }, {
        	"xlk", 		  "application/x-excel" }, {
        	"xll", 		  "application/excel" }, {
        	"xll", 		  "application/vnd.ms-excel" }, {
        	"xll", 		  "application/x-excel" }, {
        	"xlm", 		  "application/excel" }, {
        	"xlm", 		  "application/vnd.ms-excel" }, {
        	"xlm", 		  "application/x-excel" }, {
    		"xls", 		  "application/vnd.ms-excel" }, {
        	"xls", 		  "application/excel" }, {
        	"xls", 		  "application/x-excel" }, {
        	"xls", 		  "application/x-msexcel" }, {
        	"xlsx", 	  "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" }, {
        	"xlt", 		  "application/excel" }, {
        	"xlt", 		  "application/x-excel" }, {
        	"xlv", 		  "application/excel" }, {
        	"xlv", 		  "application/x-excel" }, {
        	"xlw", 		  "application/excel" }, {
        	"xlw", 		  "application/vnd.ms-excel" }, {
        	"xlw", 		  "application/x-excel" }, {
        	"xlw", 		  "application/x-msexcel" }, {
        	"xm", 		  "audio/xm" }, {
        	"xml", 		  "application/xml" }, {
        	"xml", 		  "text/xml" }, {
        	"xmz", 		  "xgl/movie" }, {
        	"xpix", 	  "application/x-vnd.ls-xpix" }, { 
        	"xpm", 		  "image/x-xpixmap" }, {
        	"xpm", 		  "image/xpm" }, {  
            "wav",        "audio/x-wav" }, {
            "svg",        "image/svg+xml" }, {
            "svgz",       "image/svg+xml" }, {
            "wav",        "audio/x-wav" }, { 	
            "wbmp",       "image/vnd.wap.wbmp" }, {
            "wml",        "text/vnd.wap.wml" }, {
            "wmlc",       "application/vnd.wap.wmlc" }, {
            "wmls",       "text/vnd.wap.wmlscript" }, {
            "wmlscriptc", "application/vnd.wap.wmlscriptc" }, { 
            "wrl",        "x-world/x-vrml" }, {
            "Z",          "application/x-compress" }, {
            "z",          "application/x-compress" }, {
            "zip",        "application/zip" }, {
            "z", 		  "application/x-compress" }, {
            "z", 		  "application/x-compressed" }, {
            "zip", 		  "application/x-compressed" }, {
            "zip", 		  "application/x-zip-compressed" }, {
            "zip", 		  "application/zip" }, {
            "zip", 		  "multipart/x-zip" }, {
            "zoo", 		  "application/octet-stream" }, {
            "zsh", 		  "text/x-script.zsh" }              
    };

    /**
     * getContenTypeByString Obtiene el 'content type', basado en el formato del archivo.
     * @param   rutaArchivo para el cual el 'content type' es determinado.
     * @return  el 'content type' del archivo y retorna 'null' si no encuentra el formato.
     */
    public String getContenTypeByString( String rutaArchivo ){
       
    	String contentType = null;

        if( rutaArchivo != null ){
            int extensionIndex = rutaArchivo.lastIndexOf('.');
            
            if( extensionIndex != -1 ){
            	
                if( extensionIndex + 1 < rutaArchivo.length() ){
                    String formato = rutaArchivo.substring( extensionIndex + 1 );
                    
                    for( int i = 0; i < MIME_TYPE_MAPPINGS.length; i++ ){
                         
                    	 if( formato.equals(MIME_TYPE_MAPPINGS[i][0]) ){
                             contentType = MIME_TYPE_MAPPINGS[i][1];
                             break;
                         }
                    }
                }
            }
        }

        return contentType;
    }

    /**
     * getContenTypeByFile Obtiene el 'content type', basado en el formato del archivo.
     * @param  rutaArchivo ruta del archivo.
     * @return el 'content type' del archivo y retorna 'null' si no encuentra el formato.
     */
    public String getContenTypeByFile( File rutaArchivo ){ 
        
    	String contentType = null;

        if( rutaArchivo != null ){
            contentType = getContenTypeByString( rutaArchivo.getName() );
        }

        return contentType;
    }
    
}

