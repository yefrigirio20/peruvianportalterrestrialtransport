package com.ttporg.pe.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
 
/**
 * @author: Ricardo Guerra.
 * @clase:  UtilCalendario.java  
 * @descripcion: Clase POJO para el manejo de conversiones y utilitarios de fechas.
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com 
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creacion: 05-08-2009.
 * @fecha_de_ultima_actualizacion: 20-03-2009.
 * @version: 3.0
 */
public class UtilCalendario{
	
	private static String  cadenaFecha  =  "";
	
	private static int     diaNum;
	private static int     mesNum;
	private static int     anoNum;
	private static int     diaSemanaNum;
	
	private static String  diaTxt       =  ""; 
	private static String  mesTxt       =  "";
	private static String  anoTxt       =  "";	
	private static String  horasTxt     =  "";
	private static String  minutosTxt   =  "";
	private static String  segundosTxt  =  "";

	
	/**
	 * getConvertidorUtilDateToSqlDate
	 */
	public java.sql.Date getConvertidorUtilDateToSqlDate( java.util.Date fecha ){
		long tiempo = fecha.getTime();
		java.sql.Date SqlDateFecha = new java.sql.Date(tiempo);
		
		return SqlDateFecha;
	}

	/**
	 * getConvertidorUtilDateToSqlTimestamp
	 */
	public java.sql.Timestamp getConvertidorUtilDateToSqlTimestamp( java.util.Date fecha ){
		java.sql.Timestamp fechaDateTime = new java.sql.Timestamp( fecha.getTime() );		
		
		return fechaDateTime;
	}
        
        /**
	 * getHorasEntreDosFechas
	 */
	public int getHorasEntreDosFechas( Calendar fechaInicial, Calendar fechaFinal ){
            
            Integer    redondeoMesFecha = 1;
            List<Date> listaZonaHoraria = new ArrayList<Date>();
		
            int contadorHoras = 0;
            
            for( ; fechaInicial.before( fechaFinal ); fechaInicial.add( Calendar.HOUR_OF_DAY, redondeoMesFecha ) ){  //Calendar.DAY_OF_WEEK para Obtener los doas. 
                 //System.out.println( "Obteniendo Dias: " + fechaInicial.getTime() );
                 listaZonaHoraria.add( fechaInicial.getTime() );
                 
                 contadorHoras++;
            }
            
            return contadorHoras;
	}
	
	/**
	 * getDiasEntreDosFechas
	 */
	public List<Date> getDiasEntreDosFechas( Calendar fechaInicial, Calendar fechaFinal ){
            
            Integer    redondeoMesFecha = 1;
            List<Date> listaZonaHoraria = new ArrayList<Date>();
		
            for( ; fechaInicial.before( fechaFinal ); fechaInicial.add( Calendar.DAY_OF_WEEK, redondeoMesFecha ) ){  //Calendar.DAY_OF_WEEK para Obtener los doas. 
                 //System.out.println( "Obteniendo Dias: " + fechaInicial.getTime() );
                 listaZonaHoraria.add( fechaInicial.getTime() );
            }

            return listaZonaHoraria;
	}
	
	/**
	 * getMesesEntreDosFechas
	 */
	public List<Date> getMesesEntreDosFechas( Calendar fechaInicial, Calendar fechaFinal ){
		Integer redondeoMesFecha = 1;
		List<Date> listaZonaHoraria = new ArrayList<Date>();
		
        for( ; fechaInicial.before( fechaFinal ) ; fechaInicial.add( Calendar.MONTH, redondeoMesFecha ) ){  //Calendar.DAY_OF_WEEK para Obtener los doas. 
       	     //System.out.println( "Obteniendo Meses: " + fechaInicial.getTime() );
       	     listaZonaHoraria.add( fechaInicial.getTime() );
		}
        return listaZonaHoraria;
	}
	
	/**
	 * getZonaHoraria
	 */
	public Calendar getZonaHoraria( String parametro ){

		Calendar calendario  = Calendar.getInstance();
		Date     fecha       = calendario.getTime();
		Calendar zonaHoraria = null;
		
		if( (parametro != null) && !(parametro.equals("")) && !(parametro.equals("Default")) ){
			TimeZone timeZone = TimeZone.getTimeZone( parametro );
			calendario.setTimeZone( timeZone );
			System.out.println("Devolviendo Zona 'Horaria' para: " + calendario.getTimeZone().getID() );
			zonaHoraria = calendario;
		}
		else{
			calendario.getTimeZone().getDefault();
			System.out.println("Devolviendo Zona 'Horaria' para 'Default': " + calendario.getTimeZone().getID() );
			zonaHoraria = calendario;
		}
		
		return zonaHoraria;
	}
	
	/**
	 * getConvierteHoraStringDate
	 */
	public Date getConvierteHoraStringDate( String hora, String simbolo ){
        String[] horaTransformar = hora.split( simbolo );                
        horasTxt   = horaTransformar[0];
        minutosTxt = horaTransformar[1];  
        
        //System.out.println(" Hora Obtenida: "   + horasTxt   );
        //System.out.println(" Minuto Obtenido: " + minutosTxt );
        
        Calendar horaTemp = Calendar.getInstance();
        horaTemp.set( 0000, 00, 00, Integer.parseInt( horasTxt ), Integer.parseInt( minutosTxt ) );
        Date horaRetorno =  horaTemp.getTime();
          
		return horaRetorno;
	}
	
	/**
	 * getFormatoFechaDateReturnaString
	 */
	public String getFormatoFechaDateReturnaString( int ano, int mes, int dia ){	
		
		try{
			if( dia < 10 ){
				diaTxt = "0" + dia;
			}
			else {
				diaTxt = dia + "";
			}
			
			if( mes < 10){
				mesTxt = "0" + mes;
			}
			else{
				mesTxt = mes + "";
			}
			
			anoTxt = ano + "";
			
			cadenaFecha = anoTxt + "-" + mesTxt + "-"+ diaTxt;
		}
		catch( Exception e ){
			e.printStackTrace();
			System.out.println("El Error encontrado es: " + e.getMessage() );
		}

		return cadenaFecha;
	}
	
	/**
	 * getFormatoFechaDateReturnaDate
	 */
	public Date getFormatoFechaDateReturnaDate( int ano, int mes, int dia ){

		Calendar calendario = null;
		Date     fechaDate	= null;
		
		try{			
	        int diaFormat  =  dia;
	        int mesFormat  =  mes - 1;
	        int anoFormat  =  ano;
	                        
	        calendario = Calendar.getInstance();        
	        calendario.set( anoFormat, mesFormat, diaFormat );
	        
	        fechaDate = calendario.getTime(); 
		}
		catch( Exception e ){
			e.printStackTrace();
			System.out.println("El Error encontrado es: " + e.getMessage() );
		}

		return fechaDate;
	}
	
	/**
	 * getTotalDiasDelMes
	 */
	public int getTotalDiasDelMes( int ano, int mes, int dia ){

		Calendar calendario = null;
		int      numDiasMes	= 0;
		
		try{			
	        calendario = new GregorianCalendar( ano, mes, dia );
	        numDiasMes  = calendario.getActualMaximum(  Calendar.DAY_OF_MONTH  );  //OBTIENE MAXIMO DE DIAS...
		}
		catch( Exception e ){
			e.printStackTrace();
			System.out.println("El Error encontrado es: " + e.getMessage() );
		}

		return numDiasMes;
	}

	/**
	 * getNumeroSemanaxMes
	 */
	public int getNumeroSemanaxMes( int ano, int mes, int dia ){

		Calendar calendario       =  null;
		int      numSemanaDelMes  =  0;
		
		try{			
	        calendario = new GregorianCalendar( ano, mes, dia );
	        numSemanaDelMes = calendario.get( Calendar.WEEK_OF_MONTH );                //OBTIENE LA SEMANA EXACTA... 
		}
		catch( Exception e ){
			e.printStackTrace();
			System.out.println("El Error encontrado es: " + e.getMessage() );
		}
		
		return numSemanaDelMes;
	}
	
	/**
	 * getValidaFechaFormatoDATE
	 */
	public boolean getValidaFechaFormatoDATE( String cadena, String separador ){
		
		boolean rpta = false;
		
		try{
			String[] cadenaSeparada = cadena.split( separador );    
			
			diaNum  = Integer.parseInt(cadenaSeparada[0]);  
			mesNum  = Integer.parseInt(cadenaSeparada[1]);   
			anoNum  = Integer.parseInt(cadenaSeparada[2]);   
			
			//Valida Cadena...
			if( (cadena.charAt(2) == '-') || (cadena.charAt(5) == '-') ){
				rpta = true;
			}
	        else{
				rpta = false;
			}
			
			//Valida dia...
			if( (diaNum > 0) && (diaNum < 31) ){
				rpta = true;
			}
	        else{
				rpta = false;
			}
			
			//Valida mes...
			if( (mesNum > 0) || (mesNum <= 12) ){
				rpta = true;
			}
	        else{
				rpta = false;
			}
			
			//Valida aoo...
		    if( anoNum < 1900 ){
				rpta = false;
			}
	        else{
				rpta = true;
			}
		}
		catch( Exception e ){
			rpta = false;
			System.out.println("El Error es: " + e.getMessage() );
			e.printStackTrace();
		}
		return rpta;
	}
	
	/**
	 * getFechaFormatDATEconSeparador
	 */
	public String getFechaFormatDATEconSeparador( Date fecha, char divisor ){
				
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime( fecha );
		
		diaNum  =  calendarioGregoriano.get(Calendar.DATE);
		mesNum  =  calendarioGregoriano.get(Calendar.MONTH) + 1;
        anoNum  =  calendarioGregoriano.get(Calendar.YEAR);
				
		try{
			if( diaNum < 10 ){
				diaTxt = "0" + diaNum;
			}
			else{ 
				diaTxt = diaNum + "";
			
			}
			if( mesNum < 10 ){
				mesTxt = "0" + mesNum;
			}
			else{
				mesTxt = mesNum + "";
			}
			
			anoTxt = anoNum + "";
			
			cadenaFecha = anoTxt + divisor + mesTxt + divisor + diaTxt;
		}
		catch( Exception e ){
			//logger.error("El Error es: " + e.getMessage() );
			cadenaFecha = "00" + divisor + "00" + divisor +"0000";
		}
		return cadenaFecha;
	}
	
	/**
	 * getFechaFormatDATE
	 */
	public String getFechaFormatDATE( Date fecha ){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();		
		calendarioGregoriano.setTime(fecha);
		
		diaNum = calendarioGregoriano.get(Calendar.DATE);
        mesNum = calendarioGregoriano.get(Calendar.MONTH) + 1;
        anoNum = calendarioGregoriano.get(Calendar.YEAR);
        
		cadenaFecha  = "";
	    diaTxt      = ""; 
		mesTxt      = ""; 
		anoTxt      = "";
		
		try{
			if(diaNum < 10){
				diaTxt = "0" + diaNum;
			}
			else {
				diaTxt = diaNum + "";
			}
			
			if(mesNum < 10){
				mesTxt = "0" + mesNum;
			}else{
				mesTxt = mesNum + "";
			}
			
			anoTxt = anoNum + "";
			
			cadenaFecha = anoTxt + "-" + mesTxt + "-"+ diaTxt;
		}
		catch (Exception e) {
			//logger.error("El Error es: " + e.getMessage() );
			cadenaFecha = "1900-01-01";
		}

		return cadenaFecha;
	}

	/**
	 * getFechaFormatDiaMesAnoGuion
	 */
	public String getFechaFormatDiaMesAnoGuion(){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		
		diaNum = calendarioGregoriano.get(Calendar.DAY_OF_MONTH);
		mesNum = calendarioGregoriano.get(Calendar.MONTH) + 1;
		anoNum = calendarioGregoriano.get(Calendar.YEAR);    

		String  textoFecha;

		if(diaNum < 10){
			if(mesNum < 10){
				textoFecha = "0" + diaNum + "-0" + mesNum + "-" + anoNum;
			}
			else{
				textoFecha = "0" + diaNum + "-" + mesNum + "-" + anoNum;
			}
		}
		else{
			if(mesNum < 10){
				textoFecha = diaNum + "-0" + mesNum + "-" + anoNum;
			}
			else{
				textoFecha = diaNum + "-" + mesNum + "-" + anoNum;
			}
		}
				
		return  textoFecha;
	}

	/**
	 * getFechaFormatDiaMesAnoLargoEspanolFormato01
	 */
	public String getFechaFormatDiaMesAnoLargoEspanolFormato01( Date fecha ){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime(fecha);
		
		diaSemanaNum = calendarioGregoriano.get(Calendar.DAY_OF_WEEK);
		diaNum = calendarioGregoriano.get(Calendar.DAY_OF_MONTH);
		mesNum = calendarioGregoriano.get(Calendar.MONTH);
        anoNum = calendarioGregoriano.get(Calendar.YEAR); 
		
		diaTxt = "";
		mesTxt = ""; 
		String textoFecha;
		
		diaTxt = getNombreDiaEspanol(diaSemanaNum);
		mesTxt = getNombreMesEspanol(mesNum);

		if(diaNum < 10){
			textoFecha = diaTxt + ", 0" + diaNum + " de " + mesTxt + " de " + anoNum;			
		}
		else{
			textoFecha = diaTxt + ", " + diaNum + " de " + mesTxt + " de " + anoNum;
		}
				
		return  textoFecha;
	}
	
	/**
	 * getFechaFormatDiaMesAnoLargoEspanol
	 */
	public String getFechaFormatDiaMesAnoLargoEspanol( Date fecha ){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime(fecha);
		
		diaSemanaNum = calendarioGregoriano.get(Calendar.DAY_OF_WEEK);
		diaNum       = calendarioGregoriano.get(Calendar.DAY_OF_MONTH);
		mesNum       = calendarioGregoriano.get(Calendar.MONTH);
        anoNum       = calendarioGregoriano.get(Calendar.YEAR); 
		
		diaTxt = "";
		mesTxt = ""; 
		String textoFecha;
		
		diaTxt = getNombreDiaEspanol(diaSemanaNum);
		mesTxt = getNombreMesEspanol(mesNum);

		if(diaNum < 10){
			textoFecha = " 0" + diaNum + " de " + mesTxt + " de " + anoNum;			
		}
		else{
			textoFecha = " " + diaNum + " de " + mesTxt + " de " + anoNum;
		}
				
		return  textoFecha;
	}

	/**
	 * getFechaFormatDiaMesAnoLargoPortuguesFormato01
	 */
	public String getFechaFormatDiaMesAnoLargoPortuguesFormato01( Date fecha ){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime(fecha);
		
		diaSemanaNum = calendarioGregoriano.get(Calendar.DAY_OF_WEEK);
		diaNum = calendarioGregoriano.get(Calendar.DAY_OF_MONTH);
		mesNum = calendarioGregoriano.get(Calendar.MONTH);
        anoNum = calendarioGregoriano.get(Calendar.YEAR); 
		
		diaTxt = "";
		mesTxt = ""; 
		String textoFecha;
		
		diaTxt = getNombreDiaEspanol(diaSemanaNum);
		mesTxt = getNombreMesEspanol(mesNum);

		if( diaNum < 10 ){
			textoFecha = diaTxt + ", 0" + diaNum + " de " + mesTxt + " de " + anoNum;			
		}
		else{
			textoFecha = diaTxt + ", " + diaNum + " de " + mesTxt + " de " + anoNum;
		}
				
		return  textoFecha;
	}

	/**
	 * getFechaFormatDiaMesAnoLargoPortugues
	 */
	public String getFechaFormatDiaMesAnoLargoPortugues( Date fecha ){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime(fecha);
		
		diaSemanaNum = calendarioGregoriano.get(Calendar.DAY_OF_WEEK);
		diaNum       = calendarioGregoriano.get(Calendar.DAY_OF_MONTH);
		mesNum       = calendarioGregoriano.get(Calendar.MONTH);
        anoNum       = calendarioGregoriano.get(Calendar.YEAR); 
		
		diaTxt = "";
		mesTxt = ""; 
		String textoFecha;
		
		diaTxt = getNombreDiaEspanol(diaSemanaNum);
		mesTxt = getNombreMesEspanol(mesNum);

		if(diaNum < 10){
			textoFecha = " 0" + diaNum + " de " + mesTxt + " de " + anoNum;			
		}
		else{
			textoFecha = " " + diaNum + " de " + mesTxt + " de " + anoNum;
		}
				
		return  textoFecha;
	}
	
	/**
	 * getFechaFormatDATETIME
	 */
	public String getFechaFormatDATETIME( Date fecha ){
		
		try{
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(fecha);
			
			anoTxt = calendario.get(Calendar.YEAR)+"";
			
			if((calendario.get(Calendar.MONTH) + 1) < 10){
				mesTxt = "0" + (calendario.get(Calendar.MONTH) + 1);
			}
			else{
				mesTxt = (calendario.get(Calendar.MONTH) + 1) + "";
			}
			
			if(calendario.get(Calendar.DATE) < 10){
				diaTxt = "0" + calendario.get(Calendar.DATE);
			}else{
				diaTxt = "" + calendario.get(Calendar.DATE);			
			}
			
			if(calendario.get(Calendar.HOUR_OF_DAY) < 10){
				horasTxt = "0" + calendario.get(Calendar.HOUR_OF_DAY);
			}
			else{
				horasTxt = "" + calendario.get(Calendar.HOUR_OF_DAY);
			}
			
			if(calendario.get(Calendar.MINUTE) < 10){
				minutosTxt = "0" + calendario.get(Calendar.MINUTE);
			}
			else{
				minutosTxt = "" + calendario.get(Calendar.MINUTE);
			}
			
			if(calendario.get(Calendar.SECOND) < 10){
				segundosTxt = "0" + calendario.get(Calendar.SECOND);
			}
			else{
				segundosTxt = "" + calendario.get(Calendar.SECOND);
			}
			
			cadenaFecha = anoTxt + "-" + mesTxt + "-" + diaTxt + " " + horasTxt + ":" + minutosTxt + ":" + segundosTxt;
		}
		catch( Exception e ) {
			//logger.error("El Error es: " + e.getMessage() );
			e.printStackTrace();
		}
		return cadenaFecha;
	}

	/**
	 * getFechaFormatDATETIMEjtable
	 */
	public String getFechaFormatDATETIMEjtable( Date fecha ){
				
		try{
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(fecha);
			
			anoTxt = calendario.get(Calendar.YEAR)+"";
			String parte_meridiano = "";
			
			if(calendario.get(Calendar.DATE) < 10) {
				diaTxt = "0" + calendario.get(Calendar.DATE);
			}
			else {
				diaTxt = "" + calendario.get(Calendar.DATE);
			}
			
			if((calendario.get(Calendar.MONTH) + 1) < 10) {
				mesTxt = "0" + (calendario.get(Calendar.MONTH) + 1);
			}
			else {
				mesTxt = (calendario.get(Calendar.MONTH) + 1) + "";
			}
			
			
			if(calendario.get(Calendar.HOUR) < 10) {
				horasTxt = "0" + calendario.get(Calendar.HOUR);
			}
			else {
				horasTxt = "" + calendario.get(Calendar.HOUR);
			}
			
			if(calendario.get(Calendar.MINUTE) < 10) {
				minutosTxt = "0" + calendario.get(Calendar.MINUTE);
			}
			else {
				minutosTxt = "" + calendario.get(Calendar.MINUTE);
			}
			
			if(calendario.get(Calendar.SECOND) < 10) {
				segundosTxt = "0" + calendario.get(Calendar.SECOND);
			}
			else{
				segundosTxt = "" + calendario.get(Calendar.SECOND);
			}
	
			if(calendario.get(Calendar.HOUR_OF_DAY) < 12) {
				parte_meridiano = "a.m.";
			}
			else {
				parte_meridiano = "p.m.";
			}
			
			cadenaFecha = diaTxt + "/" + mesTxt + "/" + anoTxt + " - " + horasTxt + ":" + minutosTxt + ":" + segundosTxt + " " + parte_meridiano;
		}
		catch (Exception e) {
			cadenaFecha = null;
			//logger.error("El Error es: " + e.getMessage() );
			e.printStackTrace();
		}
		return cadenaFecha;
	}
	
	/**
	 * getFechaFormatDiaMesConSeparador
	 */
	public String getFechaFormatDiaMesConSeparador( Object cadenaTipoDate, char divisor ){
		
		String auxCadenaFecha = cadenaTipoDate + "";
		
		try{
			diaTxt = auxCadenaFecha.charAt(8) + "" + auxCadenaFecha.charAt(9) + "";
			mesTxt = auxCadenaFecha.charAt(5) + "" + auxCadenaFecha.charAt(6) + "";
			anoTxt = auxCadenaFecha.charAt(0) + "" + auxCadenaFecha.charAt(1) + "" + auxCadenaFecha.charAt(2) + "" + auxCadenaFecha.charAt(3) + "";
			
			cadenaFecha = diaTxt + divisor + mesTxt + divisor + anoTxt;
		}
		catch (Exception e) {
			cadenaFecha = "";
		}
		return cadenaFecha;
	}

	/**
	 * getFechaFormatMesDiaAnoGuion
	 */
	public String getFechaFormatMesDiaAnoGuion( Date fecha ){ 
		
		String nuevaFecha = "";
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		
		diaNum = calendario.get(Calendar.DATE);
		mesNum = calendario.get(Calendar.MONTH) + 1;
		anoNum = calendario.get(Calendar.YEAR);

		//Dia
		if( diaNum < 10 ){
			diaTxt = "0" + diaNum;
		}
		else{
			diaTxt = "" + diaNum;
		}	
		
		//Mes
		if( mesNum < 10 ){
			mesTxt = "0" + mesNum;
		}
		else{
			mesTxt = "" + mesNum;
		}
		
		nuevaFecha = diaTxt + "-" +  mesTxt + "-" + anoNum;
		
		return nuevaFecha;
	}
	
	/**
	 * getFechaFormatDiaMesAnoLargoInglesFormato01
	 */
	public String getFechaFormatDiaMesAnoLargoInglesFormato01( Date fecha ){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();		
		calendarioGregoriano.setTime(fecha);
		
		diaSemanaNum  = calendarioGregoriano.get(Calendar.DAY_OF_WEEK);
		diaNum        = calendarioGregoriano.get(Calendar.DAY_OF_MONTH);
		mesNum 	      = calendarioGregoriano.get(Calendar.MONTH);
		anoNum        = calendarioGregoriano.get(Calendar.YEAR);     
		
		diaTxt = getNombreDiaIngles(diaSemanaNum);
		mesTxt = getNombreMesIngles(mesNum);
		
		if( diaNum < 10 ){
			cadenaFecha = diaTxt + ", 0" + diaNum + " of " + mesTxt + " of " + anoNum;			
		}
		else{
			cadenaFecha = diaTxt + ", " + diaNum + " of " + mesTxt + " of " + anoNum;
		}
				
		return  cadenaFecha;
	}

	/**
	 * getFechaFormatDiaMesAnoLargoIngles
	 */	
	public String getFechaFormatDiaMesAnoLargoIngles( Date fecha ){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();		
		calendarioGregoriano.setTime(fecha);
		
		diaSemanaNum   = calendarioGregoriano.get(Calendar.DAY_OF_WEEK);
		diaNum         = calendarioGregoriano.get(Calendar.DAY_OF_MONTH);
		mesNum 	       = calendarioGregoriano.get(Calendar.MONTH);
		anoNum         = calendarioGregoriano.get(Calendar.YEAR);     
		
		diaTxt = getNombreDiaIngles(diaSemanaNum);
		mesTxt = getNombreMesIngles(mesNum);
		
		if(diaNum < 10){
			cadenaFecha = mesTxt + " 0" + diaNum + ", " + anoNum;		
		}
		else{
			cadenaFecha = mesTxt + " " + diaNum + ", " + anoNum;
		}
				
		return  cadenaFecha;
	}

	/**
	 * getDia
	 */
	public int getDia( Date fecha ){
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		int dia = calendario.get(Calendar.DATE);

		return dia;
	}
	
	/**
	 * getMes
	 */
	public int getMes( Date fecha ){
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		int mes = calendario.get(Calendar.MONTH) + 1;

		return mes;
	}

	/**
	 * getAno
	 */
	public int getAno( Date fecha ){
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime( fecha );
		int anio = calendario.get( Calendar.YEAR );

		return anio;
	}	

	/**
	 * getDiaActual
	 */
	public int getDiaActual(){
		
		GregorianCalendar  calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime( new Date() );
		int		numDiaMes = calendarioGregoriano.get( Calendar.DAY_OF_MONTH );

		return  numDiaMes;
	}
	
	/**
	 * getMes_actual
	 */
	public int getMes_actual(){
		
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime( new Date() );
		int		numMes = calendarioGregoriano.get( Calendar.MONTH );

		return  numMes;
	}

	/**
	 * getAnoActual
	 */
	public int getAnoActual(){
		
		GregorianCalendar  calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTime( new Date() );
		int		numAnio = calendarioGregoriano.get( Calendar.YEAR );

		return  numAnio;
	}

	/**
	 * getFecha
	 */
	public Date getFecha( int anho, int mes, int dia ){
		
		GregorianCalendar  calendarioGregoriano = new GregorianCalendar( anho, mes-1, dia );
		Date fecha = calendarioGregoriano.getTime();              
		return fecha;
	}
	
	/**
	 * getFecha_actual
	 */
	public Date getFecha_actual(){
		
		GregorianCalendar  calendarioGregoriano = new GregorianCalendar();
		Date fecha = calendarioGregoriano.getTime();              
		
		return fecha;
	}
	
	/**
	 * getHora
	 */
	public String getHora( Date fecha ){
		
		GregorianCalendar  calendarioGregoriano = new GregorianCalendar();
						   calendarioGregoriano.setTime(fecha);
		
		int                horas = calendarioGregoriano.get(Calendar.HOUR_OF_DAY),
			               minutos = calendarioGregoriano.get(Calendar.MINUTE),
			               segundos = calendarioGregoriano.get(Calendar.SECOND);
		
		String             parteDelDia = "", textoHora = "";
		
		if( horas == 0 ){
			textoHora = "12";		
		}
		else if( horas < 10 ){
			textoHora = "0" + horas;
		}
		else if( horas < 13 ){
			textoHora = "" + horas;
		}
		else{
			if( horas - 12 < 10 ){
				textoHora = "0" + (int)(horas - 12);
			}
			else{
				textoHora = "" + (int)(horas - 12);
			}
		}
		//Establece la parte del doa.
		if( horas < 12 ){
			parteDelDia = " a.m.";
		}
		else{
			parteDelDia = " p.m.";
		}
				
		textoHora += ":";
		
		if( minutos < 10 ){
			textoHora = textoHora + "0" + minutos;
		}
		else{
			textoHora = textoHora + minutos;
		}
		
		textoHora += ":";
		
		if( segundos < 10 ){
			textoHora = textoHora + "0" + segundos;
		}
		else{
			textoHora = textoHora + "" + segundos;
		}
		textoHora += parteDelDia;
		
		return  textoHora;
	}
	
	/**
	 * getHora_actual
	 */
	public String getHora_actual(){
		
		GregorianCalendar  calendarioGregoriano = new GregorianCalendar();
		
		int horas       = calendarioGregoriano.get(Calendar.HOUR_OF_DAY),
			minutos     = calendarioGregoriano.get(Calendar.MINUTE),
		    segundos    = calendarioGregoriano.get(Calendar.SECOND);
		
		String parteDelDia = "", textoHora = "";
		
		if(horas == 0)
			textoHora = "12";
		else if (horas < 10){
			textoHora = "0" + horas;
		}
		else if (horas < 13){
			textoHora = "" + horas;
		}
		else{
			if (horas - 12 < 10){
				textoHora = "0" + (int)(horas - 12);
			}
			else{
				textoHora = "" + (int)(horas - 12);
			}
		}
		//Establece la parte del doa.
		if(horas < 12){
			parteDelDia = " a.m.";
		}
		else{
			parteDelDia = " p.m.";
		}
				
		textoHora += ":";
		
		if (minutos < 10)
			textoHora = textoHora + "0" + minutos;
		else
			textoHora = textoHora + minutos;
		
		textoHora += ":";
		
		if (segundos < 10)
			textoHora = textoHora + "0" + segundos;
		else
			textoHora = textoHora + "" + segundos;
		
		textoHora += parteDelDia;
		
		return  textoHora;
	}
	
	/**
	 * getNumHoras
	 */
	public String getNumHoras(){
		
		String numHoras = "12";
		
		Calendar calendario = Calendar.getInstance();
		
		if(calendario.get(Calendar.HOUR_OF_DAY) < 10){
			numHoras = "0" + calendario.get(Calendar.HOUR_OF_DAY);
		}
		else{
			numHoras = "" + calendario.get(Calendar.HOUR_OF_DAY);
		}
		
		return numHoras;
	}
	
	/**
	 * getNumeroMes
	 */
	public int getNumeroMes( String nombreMes ){
		
		String[] meses = new String[12];
		
		int num_mes = -1;
		meses[0] 	= "ENERO";
		meses[1] 	= "FEBRERO";
		meses[2] 	= "MARZO";
		meses[3] 	= "ABRIL";
		meses[4] 	= "MAYO";
		meses[5] 	= "JUNIO";
		meses[6] 	= "JULIO";
		meses[7] 	= "AGOSTO";
		meses[8] 	= "SETIEMBRE";
		meses[9]	= "OCTUBRE";
		meses[10] 	= "NOVIEMBRE";
		meses[11] 	= "DICIEMBRE";

		for( short i=0; i<meses.length; i++ ){
			if( meses[i].equals(nombreMes.toUpperCase() ) ){
				num_mes = i;
				break;
			}
		}
		return num_mes;
	}
	
	/**
	 * getNombreMesIngles
	 */
	public String getNombreMesIngles( int numMes ){
		String nombreMes = "";
		
		switch( numMes ){
			case  0: nombreMes = "January";
					 break;
			case  1: nombreMes = "February";
					 break;
			case  2: nombreMes = "March";
					 break;
			case  3: nombreMes = "April"; 
					 break;
			case  4: nombreMes = "May";
					 break;
			case  5: nombreMes = "June";
					 break;
			case  6: nombreMes = "July";
					 break;
			case  7: nombreMes = "August";
					 break;
			case  8: nombreMes = "September";
					 break;
			case  9: nombreMes = "October";
					 break;
			case 10: nombreMes = "November";
					 break;
			case 11: nombreMes = "December";
					 break;
			default: nombreMes = "null";
		}
		return nombreMes;
	}

	/**
	 * getNombreMesEspanol
	 */
	public String getNombreMesEspanol( int numMes ){
		String nombreMes = "";
		
		switch( numMes ){
			case  0: nombreMes = "Enero";
			         break;
			case  1: nombreMes = "Febrero";
					 break;
			case  2: nombreMes = "Marzo";
					 break;
			case  3: nombreMes = "Abril"; 
					 break;
			case  4: nombreMes = "Mayo";
					 break;
			case  5: nombreMes = "Junio";
					 break;
			case  6: nombreMes = "Julio";
					 break;
			case  7: nombreMes = "Agosto";
					 break;
			case  8: nombreMes = "Setiembre";
					 break;
			case  9: nombreMes = "Octubre";
					 break;
			case 10: nombreMes = "Noviembre";
					 break;
			case 11: nombreMes = "Diciembre";
					 break;
			default: nombreMes = "null";
		}
		return nombreMes;
	}
	
	/**
	 * getNombreDiaIngles
	 */
	public String getNombreDiaIngles( int numDiaSemana ){
		String nombreDia ="" ;
		
		if( numDiaSemana == Calendar.MONDAY ){
			nombreDia = "Monday";
		}
		else if( numDiaSemana == Calendar.TUESDAY ){
			nombreDia = "Tuesday";
		}
		else if( numDiaSemana == Calendar.WEDNESDAY ){
			nombreDia = "Wendnesday";
		}
		else if( numDiaSemana == Calendar.THURSDAY ){			
			nombreDia = "Thursday";
		}
		else if(numDiaSemana == Calendar.FRIDAY ){
			nombreDia = "Friday";
		}
		else if( numDiaSemana == Calendar.SATURDAY ){
			nombreDia = "Saturday";
		}
		else if( numDiaSemana == Calendar.SUNDAY ){
			nombreDia = "Sunday";
		}
		else{
			nombreDia = "null";
		}
		return nombreDia;
	}

	/**
	 * getNombreDiaEspanol
	 */
	public String getNombreDiaEspanol( int numDiaSemana ){
		String nombreDia ="" ;
		
		if( numDiaSemana == Calendar.MONDAY ){
			nombreDia = "Lunes";
		}
		else if( numDiaSemana == Calendar.TUESDAY ){
			nombreDia = "Martes";
		}
		else if( numDiaSemana == Calendar.WEDNESDAY ){
			nombreDia = "Miercoles";
		}
		else if( numDiaSemana == Calendar.THURSDAY ){			
			nombreDia = "Jueves";
		}
		else if( numDiaSemana == Calendar.FRIDAY ){
			nombreDia = "Viernes";
		}
		else if( numDiaSemana == Calendar.SATURDAY ){
			nombreDia = "Sabado";
		}
		else if( numDiaSemana == Calendar.SUNDAY ){
			nombreDia = "Domingo";
		}
		else{
			nombreDia = "null";
		}
		
		return nombreDia;
	}
	
	/**
	 * getNombreDiaSemana
	 */
	public String getNombreDiaSemana( Date fecha ){
		String diaSemana = "";
		
		if( fecha.getDay()== 1 ){
			diaSemana = "Lunes" + " - " + fecha.getDate();
		}
		if( fecha.getDay()== 2 ){
			diaSemana = "Martes" + " - " + fecha.getDate();
		}
		if( fecha.getDay()== 3 ){
			diaSemana = "Miercoles" + " - " + fecha.getDate();
		}
		if( fecha.getDay()== 4 ){
			diaSemana = "Jueves" + " - " + fecha.getDate();
		}
		if( fecha.getDay()== 5 ){
			diaSemana = "Viernes" + " - " + fecha.getDate();
		}
		if( fecha.getDay()== 6 ){
			diaSemana = "Sabado" + " - " + fecha.getDate();
		}
		if( fecha.getDay()== 0 ){
			diaSemana = "Domingo" + " - " + fecha.getDate();
		}
		return diaSemana;
	}
	
	/**
	 * getCadenaFecha_ultimaModificacion
	 */
	public String getCadenaFecha_ultimaModificacion( long ultimaModicacion ){
		
		String cadenaFechaModificada = null;
		
		java.text.DateFormat formateador     = new java.text.SimpleDateFormat( "EEEE MMMM d, yyyy ");
		java.util.Date       fechaModificada = new java.util.Date(ultimaModicacion);
		
		cadenaFechaModificada = formateador.format( fechaModificada );
		
		return cadenaFechaModificada;
	}
	
	/**
	*	getNumeroDiasEntreDosFechas  Obtiene el nomero de doas entre 2 fechas. El valor 0 es retornado si
	*	las fechas son las mismas.
	*	El orden de las fechas no importa, el resultado es un valor absoluto,
	*	es decir, el nomero de doas >=0.
	*/
	public long getNumeroDiasEntreDosFechas( Date fechaInicio, Date fechaFin ){
		
		long numDias = 0;
		
		Calendar fechaInicial = Calendar.getInstance();		
		Calendar fechaFinal   = Calendar.getInstance();
		
		fechaInicial.setTime( fechaInicio );
		fechaFinal.setTime(   fechaFin );
		
		
		if( fechaInicial.after(fechaFinal) ){  // swap dates so that fecha_inicial is start and fecha_final is end
	        Calendar swap = fechaInicial;
	        fechaInicial  = fechaFinal;
	        fechaFinal    = swap;
	    }
	    
		numDias = fechaFinal.get(Calendar.DAY_OF_YEAR) - fechaInicial.get(Calendar.DAY_OF_YEAR);
	   
		int y2 = fechaFinal.get(Calendar.YEAR);
		
	    if( fechaInicial.get(Calendar.YEAR) != y2) {
	        fechaInicial = (Calendar) fechaInicial.clone();
	        
	        do{
	        	numDias += fechaInicial.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
	            fechaInicial.add(java.util.Calendar.YEAR, 1);
	        }
	        while(fechaInicial.get(java.util.Calendar.YEAR) != y2);
	    }
	    
	    return numDias;
	}
	
	/**
	*	getNumeroMesesEntreDosFechas Obtiene el nomero de meses entre 2 fechas. El valor 0 es retornado si
	*	las fechas son las mismas.
	*	El orden de las fechas no importa, el resultado es un valor absoluto,
	*	es decir, el nomero de meses >=0.
	*	
	*	Se han considerado meses de 30 doas.
	*/
	public long getNumeroMesesEntreDosFechas( Date fechaInicio, Date fechaFin ){
		long Fecha = (getNumeroDiasEntreDosFechas(fechaInicio, fechaFin)/30);
		
		return Fecha;
	}
	
	/**
	*	getNumeroAnosEntreDosFechas Obtiene el nomero de aoos entre 2 fechas. El valor 0 es retornado si
	*	las fechas son las mismas.
	*	El orden de las fechas no importa, el resultado es un valor absoluto,
	*	es decir, el nomero de aoos >=0.
	*/
	public long getNumeroAnosEntreDosFechas( Date fechaInicio, Date fechaFin ){
		long fecha = (getNumeroDiasEntreDosFechas(fechaInicio, fechaFin)/365);
		
		return fecha;
	}
	
	/**
	*	getFechaEnElTiempo  Obtiene la fecha aumentada o disminuida en n doas segon la fecha parometro.
	*	Acepta n doas negativos
	**/	
	public Date getFechaEnElTiempo( Date fechaActual, int n, String unidadTiempo ){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		
		if( unidadTiempo.equals("DIAS") == true ){
			calendar.add(Calendar.DAY_OF_YEAR,n);
		}
		else if( unidadTiempo.equals("MESES") == true ){
			calendar.add(Calendar.MONTH,n);
		}
		else if( unidadTiempo.equals("AoOS") == true ){
			calendar.add(Calendar.YEAR,n);
		}
		
		return calendar.getTime();
	}	 
		
	/**
	 * getHoraMinuto
	 */
	public String getHoraMinuto( int hora, int minuto ){

		int horas = hora, 
			minutos = minuto;
		
		String parte_del_dia = "", texto_hora = "";
		
		if( horas == 0 ){
			texto_hora = "12";
		}
		else if( horas < 10 ){
			texto_hora = "0" + horas;
		} 
		else if( horas < 23 ){
			texto_hora = "" + horas;
		} 
		else{
			if( horas - 12 < 10 ){
				texto_hora = "0" + (int) (horas - 12);
			} 
			else {
				texto_hora = "" + (int) (horas - 12);
			}
		}

		texto_hora += ":";

		if( minutos < 10 ){
			texto_hora = texto_hora + "0" + minutos;
		}
		else{
			texto_hora = texto_hora + minutos;
		} 
		texto_hora += parte_del_dia;

		return texto_hora;
	}

	/**
	 * getSumaHoras
	 */
	public String getSumaHoras( String horaMinuendoStr, String horaSustraendoStr, boolean suma ){
		String hMin = horaMinuendoStr.split(":")[0];
		String mMin = horaMinuendoStr.split(":")[1];
		String hSus = horaSustraendoStr.split(":")[0];
		String mSus = horaSustraendoStr.split(":")[1];
				
		int hMinNum = Integer.parseInt(hMin);
		int mMinNum = Integer.parseInt(mMin);
		int hSusNum = Integer.parseInt(hSus);
		int mSusNum = Integer.parseInt(mSus);
				
		Calendar horaMinuendo   = Calendar.getInstance();
		Calendar horaSustraendo = Calendar.getInstance();
				
		horaMinuendo.set( 2000, 1, 1, hMinNum, mMinNum );
		horaSustraendo.set( 2000, 1, 1, hSusNum, mSusNum );
		
		int difHoras 	= 0;
		int difMin 		= 0;
		
		if( suma ){
			difHoras 	= horaMinuendo.get(Calendar.HOUR_OF_DAY) + horaSustraendo.get(Calendar.HOUR_OF_DAY);
			difMin 		= horaMinuendo.get(Calendar.MINUTE) + horaSustraendo.get(Calendar.MINUTE);
		} 
		else{
			difHoras 	= horaMinuendo.get(Calendar.HOUR_OF_DAY) - horaSustraendo.get(Calendar.HOUR_OF_DAY);
			difMin 		= horaMinuendo.get(Calendar.MINUTE) - horaSustraendo.get(Calendar.MINUTE);
		}

		int dif = (difHoras * 60) + difMin;
		
		Calendar horaResultado = Calendar.getInstance();
		horaResultado.set(2000, 1, 1, 0, 0);
		horaResultado.add(Calendar.MINUTE, dif);
		
		String horaFinal;
		String minutoFinal;
		
		if( horaResultado.get(Calendar.HOUR_OF_DAY)<10 ){
			 horaFinal = "0" + horaResultado.get(Calendar.HOUR_OF_DAY);
		}
		else{
			 horaFinal = "" + horaResultado.get(Calendar.HOUR_OF_DAY);
		}
		
		if(horaResultado.get(Calendar.MINUTE)<10){
			 minutoFinal = "0" + horaResultado.get(Calendar.MINUTE);
		}
		else{
			 minutoFinal = "" + horaResultado.get(Calendar.MINUTE);
		}

		String htrx = horaFinal + ":" + minutoFinal;

		return htrx;
	}		
	
 }
