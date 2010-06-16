
package com.ttporg.pe.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.commons.lang.StringUtils;

/**
 * @author: Ricardo Guerra.
 * @clase:  UtilFicheros.java
 * @descripci?n: Clase POJO utilitario para el manejo de ficheros, tanto para la manipulacion de sus
 *               registros internos, como para el mantenimiento, compresion, etc de los ficheros y
 *               Directorios en si.
 *
 *               java.util.zip.Checksum calculan la suma de comprobaci?n requerida para la compresi?n de datos.
 *               Estas sumas de comprobaci?n se usan para detectar archivos o mensajes corruptos o se corrompieron
 *               durante la transmisi?n.
 *               El algoritmo Adler32 se conoce por ser mas r?pido que el algoritmo CRC32, y ?ste ?ltimo es conocido
 *               por ser m?s confiable.
 *
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creaci?n: 05-08-2009.
 * @fecha_de_ultima_actualizaci?n: 26-09-2009.
 * @versi?n: 3.0
 */
public class UtilFicheros{

	private static String   rutaDirectorio    = "C:\\Ficheros\\";
	private static String   ficheroOrigen     = (rutaDirectorio + "PersonasLog.txt");
	private static String   ficheroDestino    = (rutaDirectorio + "PersonasLogCOPY.txt");
	private static String   ficheroRenombrado = (rutaDirectorio + "PersonasLog_2009.txt");

	private static String   saltoLinea        = "\n";
	private static String   registrosInicio   = "1, Cesar Ricardo,    Guerra Arnaiz,   av.Huaylas 357,     Chorrillos, 93453770" + saltoLinea +
			  		                            "2, Carlos Aurelio,   Cotrina Vera,    av.Los Jazmins 453, Callao,     93254561" + saltoLinea +
						                        "3, Paolo Pedro,      Guerrero Palma,  av.Arenales 1234,   San Isidro, 93423440" + saltoLinea +
						                        "4, Catherine Magaly, Cotrina Vasquez, av.Naranjal 1029,   Los Olivos, 98475548";

	private static List     listaDatos        = null;
	private static String   separador         = ",";
	private static String[] cadenasBuscar     = { "Guer", "av" };

	private static String   rutaDirectorioBackup  = "C:\\BackupDestino\\";
	private static String   ficheroBackup         = "RicardoGuerra.jpg";

	private static String[]	archivoZipear	      = new String[]{ "C:\\ORIGEN\\VIDEO1.mpg", "C:\\ORIGEN\\VIDEO2.mpg", "C:\\ORIGEN\\VIDEO3.mpg" };
	private static String	rutaArchivoComprimido = "C:\\DESTINO\\Comprimido.zip";
	private static String	rutaSalida		      = "C:\\DESTINO";
	private static int	    TAMANO_BUFFER	      = 8192;

	//Constructor.
	public UtilFicheros(){
	}

	public static void main( String[] args ) throws IOException{

		UtilFicheros manejoFicheros = new UtilFicheros();

		boolean creaReg     = false;
		boolean leeReg      = false;
		boolean buscaReg    = false;
		boolean cargaReg    = false;

		boolean modificaReg = false;
		boolean eliminaReg  = false;

		boolean estado      = false;

		//estado = manejoFicheros.creaDirectorioFichero( rutaDirectorio, ficheroOrigen );  //100pre se carga al inicio ...

		//if( estado == true ){
			//creaReg  = manejoFicheros.creaRegistrosFichero( ficheroOrigen, registrosInicio );
			//System.out.println( "====> Se Creo Registros en el Fichero: "  + creaReg  );

			//leeReg   = manejoFicheros.leeRegistrosFichero(  ficheroOrigen );
			//System.out.println( "====> Se pudo Leer los Registros del Fichero: " + leeReg   );

			//buscaReg = manejoFicheros.buscaCadenasEnRegistrosFichero( ficheroOrigen, cadenasBuscar, ficheroDestino );
			//System.out.println( "====> Se pudo Encontrar Registros en el Fichero: " + buscaReg   );

			//cargaReg   = manejoFicheros.cargarRegistrosFichero( ficheroOrigen, separador );
			//System.out.println( "====> Se pudo Cargar los Registros del Fichero en Memoria: " + cargaReg );
		//}

		/*
		Persona persona = new Persona();
		persona.setCodigo(    2 );
		persona.setNombres(   "Ivan Arturo" );
		persona.setApellidos( "Silva Vera" );
		persona.setDireccion( "Av.Los Mirtos 567 San Isidro" );
		persona.setDistito(   "San Isidro" );
		persona.setTelefono(  "12345678" );

		if( estado == true ){
			//modificaReg = manejoFicheros.modificarGuardarRegistrosFichero( persona, ficheroOrigen );
			//System.out.println( "Se Modifico los Registros del Fichero: "  + modificaReg );

			//eliminaReg  = manejoFicheros.eliminarRegistrosFichero( "2", ficheroOrigen );
			//System.out.println( "Se Elimino el Registro del Fichero: "     + eliminaReg  );
		}
		*/

		/*
		String rutaDirectorioPadre = "."; //Obtiene automaticamente la ruta del Path hasta el nombre del proyecto.

		List<File> listaDirectorios = manejoFicheros.getListadoDirectorios_x_Ruta( rutaDirectorioPadre );

		for( int i=0; i<listaDirectorios.size(); i++ ){
			 System.out.println( listaDirectorios.get( i ).getCanonicalPath() );
		}
		*/

		/** PARA VALIDACION DE RUTA FICHERO... **/
		//boolean existe   = manejoFicheros.existeFichero(    ficheroOrigen );
		//System.out.println( "Existe el Fichero en la ruta indicada: "   + existe   );

		//boolean clona    = manejoFicheros.clonarFichero(    ficheroOrigen, ficheroDestino    );
		//System.out.println( "Se Clono el Fichero en otra ubicacion: "  + clona    );

		//boolean renombra = manejoFicheros.renombrarFichero( ficheroOrigen, ficheroRenombrado );
		//System.out.println( "Se Renombro el Fichero: " + renombra );

		//boolean elimina  = manejoFicheros.eliminaFichero(   ficheroOrigen );
		//System.out.println( "Se Elimino el Fichero: "  + elimina  );

		//Copiando un fichero, imagen, etc (Ya creado). Desde una ruta ORIGEN a una diferente de DESTINO.
		//estado = manejoFicheros.creaDirectorioFichero( rutaDirectorioBackup, ficheroBackup );    //100pre se carga al inicio ...
	    //manejoFicheros.copiaArchivoRutaNueva( ("C:\\" + ficheroBackup), (rutaDirectorioBackup + ficheroBackup) );

		/** PARA MANEJO DE COMPRESION .ZIP **/
		manejoFicheros.comprimirFicheros(                archivoZipear, rutaArchivoComprimido );
		//manejoFicheros.comprimirFicheros_x_algoritmo(    archivoZipear, rutaArchivoComprimido, "Adler32" );
		//manejoFicheros.descomprimirFicheros(             rutaArchivoComprimido,  rutaSalida );
		//manejoFicheros.descomprimirFicheros_x_algoritmo( rutaArchivoComprimido,  rutaSalida, "CRC32" );
		//manejoFicheros.verContenidorComprimido(          rutaArchivoComprimido,  rutaSalida );

	}

	/**
	 * creaDirectorioFichero  crea el fichero validando la existencia de las carpetas y el fichero en si.
	 * @param   rutaDirectorio  rura del directorio para validar su existencia.
	 * @param   ficheroOrigen   ruta del fichero origen, para validar su existencia.
	 * @return  estado del proceso realizado.
	 */
	public boolean creaDirectorioFichero( String rutaDirectorio, String ficheroOrigen ){

		boolean estado = false;
		boolean existe = this.existeDirectorio( rutaDirectorio );

		//Si la ruta del 'Directorio' EXISTE.
		if( existe == true ){
			existe = this.existeFichero( ficheroOrigen );

			//Si la ruta del 'Fichero' EXISTE.
			if( existe == true ){
				estado = true;
			}
		}

		return estado;
	}

	/**
	 * buscaCadenasEnRegistrosFichero  aqui se buscan texto entre los registros del fichero
	 * @param   rutaFichero  String
	 * @param   cadenas      String[]
	 * @param   rutaDestino  String
	 * @return  estado del proceso realizado.
	 */
	public boolean buscaCadenasEnRegistrosFichero( String rutaFichero, String[] cadenas, String rutaDestino ){
	        System.out.println( "" );
	        System.out.println( "*********** DENTRO DE 'buscaCadenasEnRegistrosFichero' ***********" );

		boolean estado        = false;
		String  texto         = "";
		String  linea         = null;
		String  saltoLinea    = "\n";
		String  cadenaRetorno = "";

		try{
                    FileReader     lector  = new FileReader(  rutaFichero );
                    BufferedReader entrada = new BufferedReader( lector );

                    while( (linea = entrada.readLine() ) != null ){

                               texto = (linea + saltoLinea);  //Se asigna, No se concatena

                               String cadena_01 = cadenas[0];
                               String cadena_02 = cadenas[1];

                               int existe_01 = texto.indexOf( cadena_01 );
                               int existe_02 = texto.indexOf( cadena_02 );

                               if( (existe_01 != -1) && (existe_02 != -1) ){
                                       cadenaRetorno += texto;   //Se concatena.
                                       estado = true;
                               }
                    }

                    System.out.println( "Registros Encontrados: " + saltoLinea + cadenaRetorno );

                    //------------ GRABANDO -----------//
                    FileWriter     escritor = new FileWriter(     rutaDestino );
		    BufferedWriter salida   = new BufferedWriter( escritor );
		    PrintWriter    imprime  = new PrintWriter(    salida );

		    imprime.println( cadenaRetorno.trim() );   //Imprime en el '.txt' asignado.
		    imprime.close();
			//---------------------------------//
		}
		catch( FileNotFoundException e ){
                       System.out.println( "No se encontro el Archivo" );
                       e.printStackTrace();
                       estado = false;
		}
		catch( IOException e ){
                       System.out.println( "Error de I/O" );
                       e.printStackTrace();
                       estado = false;
		}

		return estado;
	}

	/**
	 * esDirectorio valida si la ruta indicada es la de un Directorio.
	 *
	 * @param rutaFichero String
	 * @return estado del proceso realizado.
	 */
	public boolean esDirectorio( String rutaCarpeta ){
		System.out.println( "" );
		System.out.println( "*********** DENTRO DE 'esDirectorio' ***********" );

		boolean estado = false;
		File    archivo = new File( rutaCarpeta );
		boolean existe = archivo.exists();

		try{
			if( existe == true ){
				if( archivo.isDirectory() == true ){
					System.out.println( "El archivo es un Directorio ...!!!" );
					estado = true;
				}
				else{
					System.out.println( "El archivo no es un Directorio ...!!!" );
					estado = false;
				}
			}
			else{
				System.out.println( "La ruta no existe ...!!!" );
			}
		}
		catch( Exception e ){
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * esFichero valida si la ruta indicada es la de un Fichero.
	 *
	 * @param rutaFichero String
	 * @return estado del proceso realizado.
	 */
	public boolean esFichero( String rutaFichero ){
		System.out.println( "" );
		System.out.println( "*********** DENTRO DE 'esFichero' ***********" );

		boolean estado  = false;
		File    archivo = new File( rutaFichero );
		boolean existe  = archivo.exists();

		try{
			if( existe == true ){
				if( archivo.isFile() == true ){
					System.out.println( "El archivo es un Fichero ...!!!" );
					estado = true;
				}
				else{
					System.out.println( "El archivo no es un Fichero ...!!!" );
					estado = false;
				}
			}
			else{
				System.out.println( "La ruta no existe ...!!!" );
			}
		}
		catch( Exception e ){
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * existeDirectorio  busca la existencia de la carpeta en una ruta indicada, si no existe se crea la carpeta.
	 * @param   rutaCarpeta  String
	 * @return  estado del proceso realizado.
	 */
	public boolean existeDirectorio( String rutaCarpeta ){
		   System.out.println( "" );
		   System.out.println( "*********** DENTRO DE 'existeDirectorio' ***********" );

		   boolean estado  = false;
	 	   File    archivo = new File( rutaCarpeta );
		   boolean existe  = archivo.exists();

		   try{
			   if( existe == false ){
			   	   archivo.mkdir();
			   	   System.out.println( "El Directorio se creo correctamente ...!!!" );
			   }
			   else{
			   	   System.out.println( "El Directorio ya Existe ...!!!" );
			   }

			   estado = true;
		   }
		   catch( Exception e ){
				  e.printStackTrace();
				  estado = false;
		   }

		   return estado;
		}

	/**
	 * existeFichero busca la existencia de un fichero en una ruta indicada, si no existe el fichero se crea.
	 * @param   rutaFichero  String
	 * @return  estado del proceso realizado.
	 */
	public boolean existeFichero( String rutaFichero ){
	   System.out.println( "" );
	   System.out.println( "*********** DENTRO DE 'existeFichero' ***********" );

	   boolean estado  = false;
 	   File    archivo = new File( rutaFichero );
	   boolean existe  = archivo.exists();

	   try{
		   if( existe == false ){
		   	   archivo.createNewFile();
		   	   System.out.println( "El Fichero se creo correctamente ...!!!" );
		   }
		   else{
		   	   System.out.println( "El Fichero ya Existe ...!!!" );
		   }

		   estado = true;
	   }
	   catch( Exception e ){
			  e.printStackTrace();
			  estado = false;
	   }

	   return estado;
	}

	/**
	 * clonarFichero busca un fichero en una ruta y lo clona.
	 * @param   rutaFicheroOrigen   String
	 * @param   rutaFicheroDestino  String
	 * @return  estado del proceso realizado.
	 */
	public boolean clonarFichero( String rutaFicheroOrigen, String rutaFicheroDestino ){
	    System.out.println( "" );
	    System.out.println( "*********** DENTRO DE 'clonarFichero' ***********" );

		boolean estado = false;

		try{
		    FileInputStream  entrada = new FileInputStream(  rutaFicheroOrigen  );
		    FileOutputStream salida  = new FileOutputStream( rutaFicheroDestino );

		    FileChannel canalOrigen  = entrada.getChannel();
		    FileChannel canalDestino = salida.getChannel();

		    canalOrigen.transferTo( 0, canalOrigen.size(), canalDestino );   //Clona el archivo.

		    entrada.close();
		    salida.close();

		    estado = true;
		}
		catch( IOException e ){
			   System.out.println( "No se encontro el archivo" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * clonarFichero busca un fichero en una ruta y lo clona.
	 * @param   rutaFicheroOrigen   String
	 * @param   rutaFicheroDestino  String
	 * @return  estado del proceso realizado.
	 */
	public boolean clonarFichero( FileInputStream rutaFicheroOrigen, String rutaFicheroDestino ){
	    System.out.println( "" );

            boolean estado = false;

            try{
                FileOutputStream salida  = new FileOutputStream( rutaFicheroDestino );

                FileChannel canalOrigen  = rutaFicheroOrigen.getChannel();
                FileChannel canalDestino = salida.getChannel();

                canalOrigen.transferTo( 0, canalOrigen.size(), canalDestino );   //Clona el archivo.

                rutaFicheroOrigen.close();
                salida.close();

                estado = true;
            }
            catch( IOException e ){
                       System.out.println( "No se encontro el archivo" );
                       e.printStackTrace();
                       estado = false;
            }

            return estado;
	}

	/**
	 * renombrarFichero  busca un fichero en una ruta y lo renombra con 'rutaFicheroRenombre'.
	 * @param   rutaFicheroOrigen   String
	 * @param   rutaFicheroDestino  String
	 * @return  estado del proceso realizado.
	 */
	public boolean renombrarFichero( String rutaFicheroOrigen, String rutaFicheroRenombre ){
	   System.out.println( "" );
	   System.out.println( "*********** DENTRO DE 'renombrarFichero' ***********" );

	   boolean estado     = false;
 	   File    archivo    = new File( rutaFicheroOrigen   );
 	   File    archivoNEW = new File( rutaFicheroRenombre );
	   boolean existe     = archivo.exists();

	   try{
               if( existe == true ){
                   archivo.renameTo( archivoNEW );
                   System.out.println( "El archivo se Renombro ...!!!" );
                   estado = true;
               }
               else{
                   System.out.println( "El archivo no se pudo Renombrar ...!!!" );
                   estado = false;
               }
	   }
	   catch( Exception e ){
                  e.printStackTrace();
                  estado = false;
           }

	   return estado;
	}

	/**
	 * eliminaFichero  elimina un fichero en una ruta indicada.
	 * @param   rutaFichero  String
	 * @return  estado del proceso realizado.
	 */
	public boolean eliminaFichero( String rutaFichero ){
	   System.out.println( "" );
	   System.out.println( "*********** DENTRO DE 'eliminaFichero' ***********" );

	   boolean estado  = false;
 	   File    archivo = new File( rutaFichero );
	   boolean existe  = archivo.exists();

	   try{
		   if( existe == true ){
		   	   archivo.delete();
		   	   System.out.println( "El archivo a sido Eliminado ...!!!" );
		   	   estado = true;
		   }
		   else{
		   	   System.out.println( "El archivo no a sido Eliminado ...!!!" );
		   	   estado = false;
		   }
	   }
	   catch( Exception e ){
		      e.printStackTrace();
		      estado = false;
       }

	   return estado;
	}

	/**
	 * creaRegistrosFichero  crea un fichero en una ruta indicada y crea registros de inicio en el.
	 * @param   rutaFichero     ruta del fichero a crear.
	 * @param   registrosInicio cada registro debe estar separado con separado con ','
	 * @return  estado del proceso realizado.
	 */
	public boolean creaRegistrosFichero( String rutaFichero, String registrosInicio ){
	    System.out.println( "" );
	    System.out.println( "*********** DENTRO DE 'creaRegistrosFichero' ***********" );

		boolean estado = false;

		try{
	            FileWriter     escritor   = new FileWriter( rutaFichero );
		    BufferedWriter salida     = new BufferedWriter( escritor );
		    PrintWriter    imprime    = new PrintWriter( salida );

		    imprime.println( registrosInicio );  //Imprime en el '.txt' creado.
		    imprime.close();

		    estado = true;
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo: " + registrosInicio );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

        public boolean creaFichero( String rutaFichero, String registrosInicio ){
	    System.out.println( "" );
	    System.out.println( "*********** DENTRO DE 'creaRegistrosFichero' ***********" );

		boolean estado = false;

		try{
	            FileWriter     escritor   = new FileWriter( rutaFichero );
		    BufferedWriter salida     = new BufferedWriter( escritor );
		    PrintWriter    imprime    = new PrintWriter( salida );

		    estado = true;
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo: " + registrosInicio );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}
	/**
	 * leeRegistrosFichero   leer el contenido de los registro en base a la ruta indicada.
	 * @param   rutaFichero  ruta del fichero a crear.
	 * @return  estado del proceso realizado.
	 */
	public boolean leeRegistrosFichero( String rutaFichero ){
	    System.out.println( "" );
	    System.out.println( "*********** DENTRO DE 'leeRegistrosFichero' ***********" );

		boolean estado     = false;
		String  texto      = "";
		String  linea      = null;
		String  saltoLinea = "\n";

		try{
			FileReader     lector     = new FileReader( rutaFichero );
			BufferedReader entrada    = new BufferedReader( lector );

			while( (linea = entrada.readLine()) != null ){
				    texto += (linea + saltoLinea);
			}

			entrada.close();

			System.out.println( "" + texto.trim() );
			estado = true;
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo" );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * leeRegistrosFicheroII  leer el contenido de los registro en base a la ruta indicada.
	 * @param   rutaFichero  ruta del fichero a crear.
	 * @return  estado del proceso realizado.
	 */
	public boolean leeRegistrosFicheroII( String rutaFichero ){

		boolean estado     = false;
		String  texto      = "";
		String  linea      = null;
		String  saltoLinea = "\n";

		try{
			//r = lectura | rw = lectura/escritura
			RandomAccessFile ficheroAleatorio = new RandomAccessFile( rutaFichero, "r" );

			while( ( linea = ficheroAleatorio.readLine() ) != null ){
				 texto += (linea + saltoLinea);
			}

			System.out.println( texto );

			ficheroAleatorio.close();
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo" );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * guardarCadenaEnRegistro guarda una cadena en una posicion indicada.
	 * @param   rutaFichero  ruta del fichero a crear.
	 * @param   cadena       cadena que sera insertada.
	 * @param   posicion     posicion a insertar la cadena.INICIO inserta al inicio, ULTIMO
	 *                       inserta al ultimo o el numero de la fila donde se insertara.
	 * @return  estado del proceso realizado.
	 */
	public boolean guardarCadenaEnRegistro( String rutaFichero, String cadena, String posicion ){

		boolean estado     = false;
		String  texto      = "";
		String  linea      = null;
		String  saltoLinea = "\n";
		int     contador   = 0;

		try{
                    //r = lectura | rw = lectura/escritura
                    RandomAccessFile ficheroAleatorio = new RandomAccessFile( rutaFichero, "rw" );

                    long ultimaFila = ficheroAleatorio.length();

                    if( posicion != null ){

                        if( posicion.equalsIgnoreCase( "INICIO" ) ){
                            //Nos vamos al Inicio del Fichero.
                            ficheroAleatorio.seek( 0 );

                            //Imprimimos la cadena en el Fichero.
                            ficheroAleatorio.writeBytes( cadena + saltoLinea );  //writeUTF
                        }
                        else if( posicion.equalsIgnoreCase( "ULTIMO" ) ){
                            //Nos vamos al Final del Fichero.
                            ficheroAleatorio.seek( ultimaFila );

                            //Imprimimos la cadena en el Fichero.
                            ficheroAleatorio.writeBytes( cadena + saltoLinea );  //writeUTF
                        }
                        else{
                            while( ( linea = ficheroAleatorio.readLine() ) != null ){
                                     texto += (linea + saltoLinea);
                                     contador ++;

                                     if( contador == Integer.parseInt( posicion ) ){

                                         //Imprimimos la cadena en el Fichero.
                                         ficheroAleatorio.writeBytes( cadena );
                                     }
                            }
                        }
                    }

                    //System.out.println( texto );

                    //Cierra conexion con Fichero.
                    ficheroAleatorio.close();

                    estado = true;
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo " );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * cargarRegistrosFichero carga el contenido de los registros en base a una ruta de un fichero indicado.
	 * @param   rutaFichero   ruta del fichero a crear.
	 * @param   separador     separador para cada registro del fichero.
	 * @return  estado del proceso realizado.

	public boolean cargarRegistrosFichero( String rutaFichero, String separador ){
	    System.out.println( "" );
	    System.out.println( "*********** DENTRO DE 'cargarRegistrosFichero' ***********" );

		boolean  estado    = false;
		String   linea     = "";
		Empleado  persona   = null;

		listaDatos = new ArrayList();

		try{
			BufferedReader lector = new BufferedReader( new FileReader( rutaFichero ) );

			while( (linea = lector.readLine()) != null ){

				System.out.println( "Linea Obtenida: [" + linea + "]" );

				if( !(linea.equals( "" )) ){

					if( !(linea.trim().equals( "" )) ){

						StringTokenizer tokens = new StringTokenizer( linea, separador );

						String  codigo    = ( tokens.nextToken() );
						String	nombres   = ( tokens.nextToken() );
						String	apellidos = ( tokens.nextToken() );
						String  direccion = ( tokens.nextToken() );
						String	distrito  = ( tokens.nextToken() );
						String	telefono  = ( tokens.nextToken() );

						System.out.println( "" );
						System.out.println( "codigo:    " + codigo    );
						System.out.println( "nombres:   " + nombres   );
						System.out.println( "apellidos: " + apellidos );
						System.out.println( "direccion: " + direccion );
						System.out.println( "distrito:  " + distrito  );
						System.out.println( "telefono:  " + telefono  );
						System.out.println( "" );

						//Seteando Datos Fichero.
						persona  = new Empleado();
						persona.setCodigo(    Integer.parseInt( codigo.trim() ) );
						persona.setNombres(   nombres.trim()   );
						persona.setApellidos( apellidos.trim() );
						persona.setDireccion( direccion.trim() );
						persona.setDistrito(  distrito.trim()  );
						persona.setTelefono(  telefono.trim()  );

						listaDatos.add( persona );
					}
				}
			}

			System.out.println( "Tama?o Lista Datos: " + listaDatos.size() );

			//Imprime Datos Obtenidos del Fichero.
			this.imprimeRegistrosFichero( listaDatos );

			lector.close();
			estado = true;
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo" );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}
	*/

	/**
	 * eliminarRegistrosFichero elimina el registro del fichero en base a la ruta indicada.
	 * @param   codigo        codigo del registro del fichero a eliminar.
	 * @param   rutaFichero   ruta del fichero a crear.
	 * @return  estado del proceso realizado.

	public boolean eliminarRegistrosFichero( String codigo, String rutaFichero ){
	    System.out.println( "" );
	    System.out.println( "*********** DENTRO DE 'eliminarRegistrosFichero' ***********" );

		boolean estado         = false;
		String  cadenaFichero  = "";
		String  saltoLinea     = "\n";

		try{
			this.cargarRegistrosFichero( rutaFichero, separador );

			//Eliminando Registro de Fichero.
			for( int i=0; i<this.listaDatos.size(); i++ ){
			     Empleado persona = (Empleado)listaDatos.get( i );

			     if( String.valueOf(persona.getCodigo()).equalsIgnoreCase( codigo ) ){
			         this.listaDatos.remove( persona.getCodigo() - 1 );  //Elimina el Registro Indicado.
			     }
			}

			//Armando Fichero a grabar.
			for( int i=0; i<this.listaDatos.size(); i++ ){
			     Empleado persona = (Empleado)listaDatos.get( i );

			     cadenaFichero += persona.getCodigo()    + ", " + persona.getNombres()  + ", " + persona.getApellidos() + ", " +
				 				  persona.getDireccion() + ", " + persona.getDistrito() + ", " + persona.getTelefono()  + saltoLinea;
			}

			//------------ GRABANDO -----------//
			FileWriter     escritor   = new FileWriter( rutaFichero );
		    BufferedWriter salida     = new BufferedWriter( escritor );
		    PrintWriter    imprime    = new PrintWriter( salida );

		    imprime.println( cadenaFichero );   //Imprime en el '.txt' asignado.
		    imprime.close();
			//---------------------------------//

			estado = true;
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo" );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}
	*/

	/**
	 * modificarGuardarRegistrosFichero
	 * @param   persona     objeto del fichero del cual se modificaran sus registros.
	 * @param   rutaFichero ruta del fichero a modificar.
	 * @return  estado del proceso realizado.

	public boolean modificarGuardarRegistrosFichero( Empleado persona, String rutaFichero  ){
	    System.out.println( "" );
	    System.out.println( "*********** DENTRO DE 'modificarGuardarRegistrosFichero' ***********" );

		boolean estado        = false;
		String  cadenaFichero = "";
		String  saltoLinea    = "\n";

		try{
			this.cargarRegistrosFichero( rutaFichero, separador );  //Carga los Datos en Memoria.

			//Eliminando Registro de Fichero.
			for( int i=0; i<this.listaDatos.size(); i++ ){
			     Empleado objPersona = (Empleado)listaDatos.get( i );

			     if( objPersona.getCodigo() == persona.getCodigo() ){

			     	 //Elimina el Registro del codigo se?alado.
			     	 this.listaDatos.remove( persona.getCodigo() - 1 );

			     	 //Crea un nuevo Registro con el Objeto en su misma posicion x orden de Codigo.
			     	 this.listaDatos.add( (persona.getCodigo() - 1), persona );
			     }
			}

			//Armando Fichero a grabar.
			for( int i=0; i<this.listaDatos.size(); i++ ){
			     Empleado objPersona = (Empleado)this.listaDatos.get( i );

			     cadenaFichero += objPersona.getCodigo()    + ", " + objPersona.getNombres()  + ", " + objPersona.getApellidos() + ", " +
			     				  objPersona.getDireccion() + ", " + objPersona.getDistrito() + ", " + objPersona.getTelefono()  + saltoLinea;
			}

			//------------ GRABANDO -----------//
			FileWriter     escritor   = new FileWriter( rutaFichero );
		    BufferedWriter salida     = new BufferedWriter( escritor );
		    PrintWriter    imprime    = new PrintWriter( salida );

		    imprime.println( cadenaFichero );    //Imprime en el '.txt' asignado.
		    imprime.close();
			//---------------------------------//

		    estado = true;
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo" );
			   e.printStackTrace();
			   estado = false;
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}
	*/

	/**
	 * getListadoDirectorios_x_Ruta obtiene una lista de nombres de rutas de directorios hijos en
	 *                              base a una ruta padre.
	 * @param    rutaDirectorioPadrea.
	 * @return   lista de directorios hijos.
	 */
	public List<File> getListadoDirectorios_x_Ruta( String rutaDirectorioPadrea ){

		List<File> listaDirectorios = new Vector<File>();

		try{
			if( (rutaDirectorioPadrea != null) && !(rutaDirectorioPadrea.equals( "" ) ) ){

			    File directorioRaiz = new File( rutaDirectorioPadrea );

			    if( directorioRaiz.exists() == true ){

			    	File[] listadoArchivos = directorioRaiz.listFiles();

			    	for( int i=0; i<listadoArchivos.length; i++ ){
			    		 if( listadoArchivos[i].isDirectory() == true ){
			    			 listaDirectorios.add( listadoArchivos[i] );
			    		 }
			    	}
			    }
			}
		}
		catch( Exception e ){
			   e.printStackTrace();
		}

		return listaDirectorios;
	}

	/**
	 * imprimeRegistrosFichero impresion de registros en base al objeto persona.
	 **
	public void imprimeRegistrosFichero( Object objeto ){

		List listaDatos = (List)objeto;

		System.out.println( "" );
		System.out.println( "********** LISTADO CARGADO DEL .txt **********" );
		System.out.println( "" );

		for( int i=0; i<listaDatos.size(); i++ ){
		     Empleado persona = (Empleado)listaDatos.get( i );

		     System.out.println( "CODIGO:    " + persona.getCodigo()    );
		     System.out.println( "NOMBRES:   " + persona.getNombres()   );
		     System.out.println( "APELLIDOS: " + persona.getApellidos() );
		     System.out.println( "DIRECCION: " + persona.getDireccion() );
		     System.out.println( "DISTRITO:  " + persona.getDistrito()  );
		     System.out.println( "TELEFONO:  " + persona.getTelefono()  );
			 System.out.println( "" );
		}
	}
	*/

	/**
	 * comprimirFicheros  m?todo utilizado para la compresion estandar de directorios y ficheros.
	 *
	 * @param  archivoZipear
	 * @param  rutaArchivoComprimido
	 * @return boolean
	 */
	public boolean comprimirFicheros( String[] archivoZipear, String rutaArchivoComprimido ){
		System.out.println( "**** DENTRO DE 'comprimirFicheros' ****" );

		boolean estado = false;

		try{
			FileInputStream     entradaFile   = null;
			BufferedInputStream entradaBuffer = null;
			File                archivo       = new File( rutaArchivoComprimido );
			FileOutputStream    salidaFile    = new FileOutputStream( archivo );
			ZipOutputStream     ZIP           = new ZipOutputStream(  salidaFile );

			//Crea un buffer para la lectura de los datos de los archivos.
			byte[] datos = new byte[TAMANO_BUFFER];

			//Comprimiendo los archivos.
			for( int i=0; i<archivoZipear.length; i++ ){
				String nombreArchivo = archivoZipear[i];

				System.out.println( "Archivos: " + nombreArchivo );

				entradaFile   = new FileInputStream(     nombreArchivo );
				entradaBuffer = new BufferedInputStream( entradaFile, TAMANO_BUFFER );

				//Agregar las entradas ZIP al OutputStream.
				ZipEntry entradaZip = new ZipEntry( archivoZipear[i] );
				ZIP.putNextEntry( entradaZip );

				//Transferencia de bytes desde el archivo original al archivo ZIP.
				int bytes;
				while( ( bytes = entradaBuffer.read( datos ) ) > 0 ){
					     ZIP.write( datos, 0, bytes );
					     estado = true;
				}

				ZIP.closeEntry();
				entradaFile.close();
			}

			ZIP.close();
		}
		catch( IOException e ){
			   e.printStackTrace();
			   estado = false;
		}
		catch( Exception e ){
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * comprimirFicheros_x_algoritmo  m?todo utilizado para la compresion de directorios y ficheros
	 *                                en base a dos algoritmos de compresion .
	 *
	 *                                - Adler32: Para Mayor Rapidez.
	 *                                - CRC32:   Para Mayor Seguridad (Confiable).
	 *
	 * @param archivoZipear
	 * @param rutaArchivoComprimido
	 * @param nombreAlgoritmo
	 * @return boolean
	 */
	public boolean comprimirFicheros_x_algoritmo( String[] archivoZipear, String rutaArchivoComprimido, String nombreAlgoritmo ){
		System.out.println( "**** DENTRO DE 'comprimirFicheros_x_algoritmo' ****" );

		boolean estado = false;

		try{
			Checksum algoritmoCompresor = null;

			if( nombreAlgoritmo.equalsIgnoreCase( "Adler32" ) ){
				algoritmoCompresor = new Adler32();	 //Para Mayor Rapidez.
			}
			else if( nombreAlgoritmo.equalsIgnoreCase( "CRC32" ) ){
				algoritmoCompresor = new CRC32();  	 //Para Mayor Seguridad (Confiable).
			}

			FileInputStream     entradaFile   = null;
			BufferedInputStream entradaBuffer = null;
			FileOutputStream    salidaFile    = new FileOutputStream( rutaArchivoComprimido );
			CheckedOutputStream comprobacion  = new CheckedOutputStream( salidaFile, algoritmoCompresor );
			ZipOutputStream     ZIP           = new ZipOutputStream( new BufferedOutputStream( comprobacion ) );

			System.out.println( "Algoritmo Compresor: " + nombreAlgoritmo );

			//Crea un buffer para la lectura de los datos de los archivos.
			byte[] datos = new byte[TAMANO_BUFFER];

			for( int i= 0; i<archivoZipear.length; i++ ){
				String nombreArchivo = archivoZipear[i];

				System.out.println( "Archivos: " + nombreArchivo );

				entradaFile   = new FileInputStream(     nombreArchivo );
				entradaBuffer = new BufferedInputStream( entradaFile, TAMANO_BUFFER );

				//Agregar las entradas ZIP al OutputStream.
				ZipEntry entradaZip = new ZipEntry( nombreArchivo );
				ZIP.putNextEntry( entradaZip );

				//Transferencia de bytes desde el archivo original al archivo ZIP.
				int bytes;
				while( ( bytes = entradaBuffer.read( datos, 0, TAMANO_BUFFER ) ) != -1 ){
					     ZIP.write( datos, 0, bytes );
					     estado = true;
				}

				entradaBuffer.close();
			}

			ZIP.close();
		}
		catch( IOException e ){
			   e.printStackTrace();
			   estado = false;
		}
		catch( Exception e ){
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * descomprimirFicheros  m?todo utilizado para descomprimir directorios y ficheros
	 *                       de forma estandar.
	 *
	 * @param rutaArchivoZipeado
	 * @param rutaSalida
	 * @return boolean
	 */
	public boolean descomprimirFicheros( String rutaArchivoZipeado, String rutaSalida ){
		System.out.println( "**** DENTRO DE 'descomprimirFicheros' ****" );

		boolean estado = false;

		try{
			BufferedOutputStream salidaBuffer  = null;
			FileOutputStream     salidaFile    = null;
			FileInputStream      entradaFile   = new FileInputStream( rutaArchivoZipeado );
			BufferedInputStream  entradaBuffer = new BufferedInputStream( entradaFile );
			ZipInputStream       ZIP           = new ZipInputStream( entradaBuffer );
			ZipEntry             entradaZip    = null;

			//Recorre el contenido del archivo .ZIP
			int bytes;

			//Crea un buffer para la lectura de los datos de los archivos.
			byte[] datos = new byte[TAMANO_BUFFER];

			while( ( entradaZip = ZIP.getNextEntry() ) != null ){
				if( !( entradaZip.isDirectory() ) ){
					System.out.println( "Archivos Extraidos: " + entradaZip );

					String rutaInternaArchivo = entradaZip.getName();
					String nuevaRutaSalida    = this.redireccionaDirectorioSalida( rutaSalida, rutaInternaArchivo );

					//Escribe los archivos en el sistema.
					salidaFile   = new FileOutputStream(     nuevaRutaSalida );
					salidaBuffer = new BufferedOutputStream( salidaFile, TAMANO_BUFFER );

					while( ( bytes = ZIP.read( datos, 0, TAMANO_BUFFER ) ) != -1 ){
						     salidaBuffer.write( datos, 0, bytes );
						     estado = true;
					}

					salidaBuffer.flush();
					salidaBuffer.close();
				}
			}

			ZIP.close();
		}
		catch( IOException e ){
			   e.printStackTrace();
			   estado = false;
		}
		catch( Exception e ){
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * descomprimirFicheros_x_algoritmo  m?todo utilizado para descomprimir directorios y ficheros
	 *                                   en base a dos algoritmos de compresion .
	 *
	 *                                   - Adler32: Para Mayor Rapidez.
	 *                                   - CRC32:   Para Mayor Seguridad (Confiable).
	 * @param rutaArchivoZipeado
	 * @param rutaSalida
	 * @param nombreAlgoritmo
	 * @return boolean
	 */
	public boolean descomprimirFicheros_x_algoritmo( String rutaArchivoZipeado, String rutaSalida, String nombreAlgoritmo ){
		System.out.println( "**** DENTRO DE 'descomprimirFicheros_x_algoritmo' ****" );

		boolean estado = false;

		try{
			Checksum algoritmoCompresor = null;

			if( nombreAlgoritmo.equalsIgnoreCase( "Adler32" ) ){
				algoritmoCompresor = new Adler32();	//Para Mayor Rapidez.
			}
			else if( nombreAlgoritmo.equalsIgnoreCase( "CRC32" ) ){
				algoritmoCompresor = new CRC32();  	//Para Mayor Seguridad (Confiable).
			}

			BufferedOutputStream salidaBuffer  = null;
			FileOutputStream     salidaFile    = null;
			FileInputStream      entradaFile   = new FileInputStream( rutaArchivoZipeado );
			CheckedInputStream   comprobacion  = new CheckedInputStream( entradaFile, algoritmoCompresor );
			BufferedInputStream  entradaBuffer = new BufferedInputStream( comprobacion );
			ZipInputStream       ZIP           = new ZipInputStream( entradaBuffer );
			ZipEntry             entradaZip    = null;

			//Recorre el contenido del archivo .ZIP
			int bytes;

			//Crea un buffer para la lectura de los datos de los archivos.
			byte[] datos = new byte[TAMANO_BUFFER];

			while( ( entradaZip = ZIP.getNextEntry() ) != null ){
				if( !( entradaZip.isDirectory() ) ){
					System.out.println( "Archivos Extraidos: " + entradaZip );

					String rutaInternaArchivo = entradaZip.getName();
					String nuevaRutaSalida    = this.redireccionaDirectorioSalida( rutaSalida, rutaInternaArchivo );

					//Escribe los archivos en el sistema.
					salidaFile   = new FileOutputStream(     nuevaRutaSalida );
					salidaBuffer = new BufferedOutputStream( salidaFile, TAMANO_BUFFER );

					while( ( bytes = ZIP.read( datos, 0, TAMANO_BUFFER ) ) != -1 ){
						     salidaBuffer.write( datos, 0, bytes );
						     estado = true;
					}

					salidaBuffer.flush();
					salidaBuffer.close();
				}
			}

			ZIP.close();
		}
		catch( IOException e ){
			   e.printStackTrace();
			   estado = false;
		}
		catch( Exception e ){
			   e.printStackTrace();
			   estado = false;
		}

		return estado;
	}

	/**
	 * verContenidorComprimido m?todo utilizado para ver el contenidor de un archivo comprimido.
	 *
	 * @param  rutaArchivoZipeado
	 * @param  rutaSalida
	 * @return boolean
	 */
	public void verContenidorComprimido( String rutaArchivoZipeado, String rutaSalida ){
		System.out.println( "**** DENTRO DE 'verContenidorComprimido' ****" );

		try{
			FileInputStream     archivoEntrada = new FileInputStream(     rutaArchivoZipeado );
			BufferedInputStream entradaBuffer  = new BufferedInputStream( archivoEntrada );
			ZipInputStream      ZIP            = new ZipInputStream(      entradaBuffer  );
			ZipEntry            entradaZip     = null;

			//Recorre el contenido del archivo .ZIP
			DateFormat formato = DateFormat.getDateTimeInstance( DateFormat.SHORT, DateFormat.SHORT );

			while( ( entradaZip = ZIP.getNextEntry() ) != null ){
				if( !( entradaZip.isDirectory() ) ){
					System.out.println( "" );
					System.out.println( "Nombre:     " + entradaZip.getName() );
					System.out.println( "F.Creacion: " + formato.format( new Date( entradaZip.getTime() ) ) );
					System.out.println( "Tama?o (-1 si no se conoce):     " + entradaZip.getSize() );
					System.out.println( "Compresion (-1 si no se conoce): " + entradaZip.getCompressedSize() );
				}
			}
		}
		catch( Exception e ){
			   e.printStackTrace();
		}
	}

	/**
	 * redireccionaDirectorioSalida  m?todo utilizado para cambiar la ruta de salida de
	 *                               un fichero comprimido al momento de su descompresion.
	 *
	 * @param  rutaSalida
	 * @param  entradaFile
	 * @return String
	 **/
	public String redireccionaDirectorioSalida( String rutaSalida, String entradaFile ){

		String datoRetorno     = "";
		String cadenaInvertida = "";
		String separador       = "";
		int    contador        = 0;

		boolean estado = this.esFichero( entradaFile );
		System.out.println( "esFichero: " + estado );

		if( estado == true ){
			//Recorremos la cadena de atras para adelante.
			for( int i=entradaFile.length()-1; i>=0; i-- ){
				 Character caracter = (Character)entradaFile.charAt(i);
				 cadenaInvertida += caracter; //Concatenamos y formamos la nueva cadena Invertida.

				 //Validamos cuantos separadores posee.
				 if( caracter == '\\' ){
					 contador ++;
					 separador = ( ('\\') + "" );
				 }
				 else if( caracter == '/' ){
					 contador ++;
					 separador = ( ('/') + "" );
				 }
				 else if( caracter == File.separatorChar ){
					 contador ++;
					 separador = ((File.separatorChar) + "");
				 }
			}

			System.out.println( "Cadena 'ANTES':   " + entradaFile );
			System.out.println( "Cadena 'DESPUES': " + cadenaInvertida );

			System.out.println( "Total Separadores#: " + contador );

			if( contador != 0 ){

				System.out.println( "Separador Aplicado: " + separador );

				String[] arrayCadenaInvertida = StringUtils.split( cadenaInvertida, separador );
				String   cadenaReversa        = StringUtils.reverse( arrayCadenaInvertida[0] );

				datoRetorno = cadenaReversa;

				System.out.println( "Nombre Fichero Obtenido: " + arrayCadenaInvertida[0] );
				System.out.println( "Nombre Fichero Invertido: " + datoRetorno );
			}
			else{
				datoRetorno = cadenaInvertida;
				System.out.println( "Nombre Fichero Obtenido: " + datoRetorno );
			}
		}

		datoRetorno = (rutaSalida + File.separator + datoRetorno);
		System.out.println( "Nueva Ruta Descomprimir Fichero: " + datoRetorno );

		return datoRetorno;
	}

	//-----------------------------------------------------------------//
	/**
	 * copiaArchivoRutaNueva    copia el fichero desde en una ruta origen a una de destino.
	 * @param   rutaArchivoOrigen
	 * @param   rutaArchivoDestino.
	 */
	public void copiaArchivoRutaNueva( String rutaArchivoOrigen, String rutaArchivoDestino ){

		  try{
			  File archivoOrigen  = new File( rutaArchivoOrigen  );
			  File archivoDestino = new File( rutaArchivoDestino );

			  //No es obligatorio llama a 'validaFichero_01', 100pre y cuando se ejecute el m?todo: 'creaDirectorioFichero' previamente.
			  this.validaFichero_01( rutaArchivoOrigen, rutaArchivoDestino );

			  System.out.println( "" );

			  //Si existe el archivo 'Destino'.
			  if( archivoDestino.exists() == true ){
				  System.out.println( "********* Archivo de DESTINO, 'existente' *********" );
			  }
			  //Si NO existe el archivo 'Destino'.
			  else{
				  System.out.println( "********* Archivo de DESTINO, 'NO existente' *********" );

				  //No es obigatorio llama a 'validaFichero_01', 100pre y cuando se ejecute el m?todo: 'creaDirectorioFichero' previamente.
				  this.validaFichero_02( rutaArchivoDestino, rutaArchivoDestino );
			  }

			  //Manda a guardar la nueva copia.
			  this.guardarCopiaArchivo( archivoOrigen, archivoDestino );
		  }
		  catch( Exception e ){
			     e.printStackTrace();
		  }
	}

	/**
	 * guardarCopiaArchivo  guarda el archivo en una nueva ruta.
	 * @param   archivoOrigen
	 * @param   archivoDestino.
	 */
	public void guardarCopiaArchivo( File archivoOrigen, File archivoDestino ){

		  try{
			  FileInputStream  entrada = null;
			  FileOutputStream salida  = null;

			  entrada = new FileInputStream(  archivoOrigen  );
			  salida  = new FileOutputStream( archivoDestino );

			  byte[] buffer = new byte[4096];
			  int    bytesRead;

			  while( (bytesRead = entrada.read(buffer)) != -1 ){
				     salida.write( buffer, 0, bytesRead );       //Escribiendo el archivo en la nueva ruta.
			  }

			  if( entrada != null ){
				  salida.close();
			  }

			  if( entrada != null ){
				  salida.close();
			  }

			  System.out.println( "Proceso de copia de archivos en nueva ubicacion 'Exitoso' ...!!!" );
		  }
		  catch( Exception e ){
			     e.printStackTrace();
				 System.err.println( "Error durante el proceso de copia...!!!" );
		  }
	}

	/**
	 * validaFichero_01
	 * @param   rutaArchivoOrigen
	 * @param   rutaArchivoDestino
	 */
	private void validaFichero_01( String rutaArchivoOrigen, String rutaArchivoDestino ){

		  try{
			  File archivoOrigen  = new File( rutaArchivoOrigen  );
			  File archivoDestino = new File( rutaArchivoDestino );

			  if( archivoOrigen.exists() == false ){
				  throw new IOException( "El fichero: [" + rutaArchivoOrigen + "], no Encontrado " );
			  }

			  if( archivoOrigen.isFile() == false ){
				  throw new IOException( "No se puede copiar el directorio: [" + rutaArchivoOrigen + "]" );
			  }

			  if( archivoOrigen.canRead() == false ){
				  throw new IOException( "El fichero: [" + rutaArchivoOrigen + "], es ilegible." );
			  }

			  if( archivoDestino.isDirectory() == true ){
				  archivoDestino = new File( archivoDestino, archivoOrigen.getName() );
			  }
		  }
		  catch( Exception e ){
			     e.printStackTrace();
		  }
	}

	/**
	 * validaFichero_02
	 * @param   rutaArchivoOrigen
	 * @param   rutaArchivoDestino
	 */
	private void validaFichero_02( String rutaArchivoOrigen, String rutaArchivoDestino ){

		  try{
			  File archivoDestino = new File( rutaArchivoDestino );

		      String directorioPadre = archivoDestino.getParent();  //Obtiene la ruta padre del directorio.

		      if( directorioPadre == null ){
		    	  directorioPadre = System.getProperty( "user.dir" );
		      }

		      File directorio = new File( directorioPadre );

		      if( directorio.exists() == false ){
		    	  throw new IOException( "El Fichero de destino [" + directorioPadre + "], no existe." );
		      }

		      if( directorio.canWrite() == false ){
		    	  throw new IOException( "El Fichero de destino: [" + directorioPadre + "], no tiene permisos de escritura. " );
		      }

		      if( directorio.isFile() == true ){
		    	  throw new IOException( "La ruta para el directorio: [" + directorioPadre + "], no es un directorio." );
		      }
		  }
		  catch( Exception e ){
			     e.printStackTrace();
		  }
	}
	//-----------------------------------------------------------------//

	/**
	 * leeCodigoFichero  leer el contenido de los registro en base a la ruta indicada.
	 * @param   rutaFichero  ruta del fichero a crear.
	 * @return  estado del proceso realizado.
	 */
	public String leeCodigoFichero( String rutaFichero ){

		String  texto      = "";
		String  linea      = null;
		String  saltoLinea = "\n";

		try{
                    //r = lectura | rw = lectura/escritura
                    RandomAccessFile ficheroAleatorio = new RandomAccessFile( rutaFichero, "r" );

                    while( ( linea = ficheroAleatorio.readLine() ) != null ){
                             texto += (linea + saltoLinea);
                    }

                    System.out.println( texto );

                    ficheroAleatorio.close();
		}
		catch( FileNotFoundException e ){
			   System.out.println( "No se encontro el Archivo" );
			   e.printStackTrace();
			   texto = "";
		}
		catch( IOException e ){
			   System.out.println( "Error de I/O" );
			   e.printStackTrace();
			   texto = "";
		}

		return texto;
	}

 }
