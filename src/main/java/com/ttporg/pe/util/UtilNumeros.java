package com.ttporg.pe.util;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author: Ricardo Guerra.
 * @clase:  UtilNumeros.java  
 * @descripciun: Clase POJO utilitario para el manejo de numeros.
 * @author_web:  http://frameworksjava2008.blogspot.com - http://viviendoconjavaynomoririntentandolo.blogspot.com 
 * @author_email: cesarricardo_guerra19@hotmail.com.
 * @fecha_de_creaciun: 10-05-2009.
 * @fecha_de_ultima_actualizaciun: 20-03-2009.
 * @versiun: 3.0
 */
public class UtilNumeros{
	
	//Constructor ...
	public UtilNumeros(){		
	}
	
	/** GENERA UN NUMERO 'ALEATORIO' ENTRE [ num1, num2 ], TANTO PARA DATOS DE TIPO:  'int, double y long' */
	public static int getAleatorio( int num1, int num2 ){
		if( num2 < num1 ){
			return (int) ((num2 - num1 + 1) * Math.random() + num1);
		}
		else{
			return (int) ((num1 - num2 + 1) * Math.random() + num2);
		}	
	}
	
	public static long getAleatorio( long num1, long num2 ){
		if( num2 < num1 ){
			return (long) ((num2 - num1 + 1) * Math.random() + num1);
		}
		else{
			return (long) ((num1 - num2 + 1) * Math.random() + num2);
		}
	}
	
	public static double getAleatorio( double num1, double num2 ){
		if( num1 >= num2 ){
			return (double)((num1 - num2 + 1)* Math.random()+ num2);
		}
		else{ //a<b
			return (double)((num2 - num1 + 1)* Math.random()+ num1);
		}	
	}
	
	/**
	* FORMATEO DE NUMEROS DECIMALES 
	*
	* Con esta cadena, "#,#00.0#;(-#,#00.0#)" 
	* definimos el formato para los numero positivos y negativos
	* Los # indican valores no obligatorios
	* Los 0 indican que si no hay valor se pondru un cero
	*/
	public static String getDecimalFormateado(double decimal){
		String valor = "";
		DecimalFormat df = new DecimalFormat("#0.0;(-#0.0)");
		valor = df.format(decimal);
		return valor;
	}
	
	public static String formatea_con_separador_miles(long entero_largo){
		String valor = "", temporal="";
		DecimalFormat df = new DecimalFormat("#,###,###");
		temporal = df.format(entero_largo);
		
		for (int i = 0; i < temporal.length(); i++) {
			if(temporal.charAt(i)!='.')
				valor += temporal.charAt(i);
			else
				valor += ',';
		}
		return valor;
	}
	
	public static String getDecimalFormateado(String cadena_decimal, int numero_decimales){
		String valor = "";
		
		//Establece la configuraciun del formateador de numeros decimales.
		DecimalFormatSymbols dformater_rules = new DecimalFormatSymbols ();
		dformater_rules.setDecimalSeparator ('.');
		DecimalFormat df = new DecimalFormat ("0.00", dformater_rules);
		df.setMaximumFractionDigits(numero_decimales);
		df.setMinimumFractionDigits(numero_decimales);
		valor = df.format(cadena_decimal);
		return valor;
	}
	
	public static String getDecimalFormateado(float decimal, int numero_decimales){
		String valor = "";
		
		//Establece la configuraciun del formateador de numeros decimales.
		DecimalFormatSymbols dformater_rules = new DecimalFormatSymbols ();
		dformater_rules.setDecimalSeparator ('.');
		DecimalFormat df = new DecimalFormat ("0.00", dformater_rules);
		df.setMaximumFractionDigits(numero_decimales);
		df.setMinimumFractionDigits(numero_decimales);
		valor = df.format(decimal);
		return valor;
	}
	
	public static String getDecimalFormateado(double decimal, int numero_decimales){
		String valor = "";
		
		//Establece la configuraciun del formateador de numeros decimales.
		DecimalFormatSymbols dformater_rules = new DecimalFormatSymbols ();
		dformater_rules.setDecimalSeparator ('.');
		DecimalFormat df = new DecimalFormat ("0.00", dformater_rules);
		df.setMaximumFractionDigits(numero_decimales);
		df.setMinimumFractionDigits(numero_decimales);
		valor = df.format(decimal);
		return valor;
	}
	
	public static String entero_a_Hexadecimal(int valor){
		String	valor_hexadecimal="";
		
		valor_hexadecimal = Integer.toHexString(valor & 0Xffffff).toUpperCase();
		
		int num_valores = valor_hexadecimal.length();
		
		if(num_valores<6){
			for(int i=0;i<6 - num_valores;i++){
				valor_hexadecimal = "0" +valor_hexadecimal;
			}
		}
		return valor_hexadecimal;
	}

	public static String color_a_Hexadecimal(Color color){
		String	valor_hexadecimal="";
		
		valor_hexadecimal = "#" +entero_a_Hexadecimal(color.getRGB());
		
		return valor_hexadecimal;
	}
	
	public static double redondeaDouble(double valor, int num_decimales) {
		double rpta =0 ;
		double power_of_ten = 1;
		
		while (num_decimales-- > 0){
			power_of_ten *= 10.0;
		}
		
		rpta = Math.round(valor * power_of_ten)/power_of_ten;
		return rpta;
	}
	
	public static double redondeaDouble(String valor_texto, int num_decimales) {
		double valor = leeDouble(valor_texto);
		double rpta =0 ;
		double power_of_ten = 1;
		
		while (num_decimales-- > 0){
			power_of_ten *= 10.0;
		}
		
		rpta = Math.round(valor * power_of_ten)/power_of_ten;
		return rpta;
	}
	
	public static float redondeaFloat(float valor, int num_decimales) {
		float rpta =0 ;
		float power_of_ten = 1;
		
		while (num_decimales-- > 0){
			power_of_ten *= 10.0;
		}
		
		rpta = Math.round(valor * power_of_ten)/power_of_ten;
		return rpta;
	}
	
	public static int leeInteger(String cadena){
		int numero = 0;
			try {
				numero = Integer.parseInt(cadena);
			}
			catch (NumberFormatException e) {
				numero = 0;
			}
		return numero;
	}
	
	public static long leeLong(String cadena){
		long numero = 0;
			try {
				numero = Long.parseLong(cadena);
			}
			catch (NumberFormatException e) {
				numero = 0;
			}
		return numero;
	}
	
	public static double leeDouble(String cadena){
		double numero = -1;
			try {
				numero = Double.parseDouble(cadena);
			}
			catch (NumberFormatException e) {
				numero = 0;
			}
		return numero;
	}
	
	public static float leeFloat(String cadena){
		float numero = -1;
			try {
				numero = Float.parseFloat(cadena);
			}
			catch (NumberFormatException e) {
				numero = 0;
			}
		return numero;
	}
		
	/**
	* TRANSFORMACION DE VALOR NUMERICO A EXPRESION LITERAL
	*
	* Esta secciun permite transformar un valor numurico en la
	* correspondiente expresiun literal que represente a dicho valor.
	*/
	
	public static String  getCadenaLetras (int numero, long num_original) {
		  String   cadena = "", cc = "", dd = "", uu = "";
		  int      centena = 0, decena = 0, unidad = 0;
		  
		  centena = numero/100;
		  numero %= 100;
		  decena = numero/10;
		  unidad = numero%10;
		  
		  switch (centena) {
			  case 1: cc = "cien"; 
			  		if (decena != 0  ||  unidad != 0){ 
			  			cc += "to";
			  		}
		            break; 
			  case 2: cc = "doscientos";    break; 
			  case 3: cc = "trescientos";   break; 
			  case 4: cc = "cuatrocientos"; break; 
			  case 5: cc = "quinientos";    break; 
			  case 6: cc = "seiscientos";   break; 
			  case 7: cc = "setecientos";   break; 
			  case 8: cc = "ochocientos";   break; 
			  case 9: cc = "novecientos";   break;        
		}

		switch (decena) {
			case 1: switch (unidad) {
	   			case 0: dd = "diez";    break;
	   			case 1: dd = "once";    break;
	   			case 2: dd = "doce";    break;
	  			case 3: dd = "trece";   break;
	   			case 4: dd = "catorce"; break;		  
	   			case 5: dd = "quince";  break;
	   			default: dd = "dieci"; 
			} 	 
      		break;
			case 2: dd = "veint";
		        	if (unidad == 0)
		          		dd += "e";
		        	else dd += "i";  
		        	break; 
			case 3: dd = "treint";   break; 		        
			case 4: dd = "cuarent";  break; 		        
			case 5: dd = "cincuent"; break; 		        
			case 6: dd = "sesent";   break; 		        
			case 7: dd = "setent";   break;
			case 8: dd = "ochent";   break; 		        
			case 9: dd = "novent";   break;
		}
		
		if (decena > 2) {
			if (unidad == 0){
		  		dd += "a";
			}
			else{
				dd += "i";
			}
		}	

		if (decena != 1  ||  unidad > 5){
			switch (unidad) {
		 		case 1: if (numero <10 && num_original > 10){
		 					uu = "uno";
		 				}
		    	 		else{
		    	 			uu = "un";
		    	 		}
		 				break;
		 		case 2: uu = "dos";    break;
				case 3: uu = "tres";   break;
				case 4: uu = "cuatro"; break;
				case 5: uu = "cinco";  break;
				case 6: uu = "seis";   break;
				case 7: uu = "siete";  break;
				case 8: uu = "ocho";   break;
				case 9: uu = "nueve";  break;		        
	  		}
		}
		if (decena == 0  &&  unidad == 0){
	  		cadena = cc;
		}
		else{
			if(cc.equals("")==false){
				cadena = cc + " " + dd + uu;	
			}
			else{
				cadena = cc + "" + dd + uu;
			}
		}
		
		return  cadena;
	}
		
	public static String  getCadenaNumericaEnPalabras (long numero) {
	 	String  cadena = "", c;
	 	int     x = 0, n;
	 	while (numero > 0) {
	 		x++;
	 		n = (int) (numero % 1000);
	 		c = "";
	 		switch (x) {
	   	  		case  2:
	   	  		case  4:
	   	  		case  6:
	   	  		case  8: if (n > 0)
	   	             		c = " mil ";
	   	           		 break;
	   	  		case  3: if (numero == 1)
	   	             		c = " millun ";
	   	           		 else
	   	           			 c = " millones "; 
	   	           	     break;
	   	  		case  5: if (numero == 1)
	   	             		c = " billun ";
	   	           		 else
	   	           			 c = " billones "; 
	  	           		 break;
	   	  		case  7: if (numero == 1)
	   	             	  	c = " trillun ";
	   	           		 else
	   	           			 c = " trillones "; 
	   	           		 break;	  	           
	    	}		 	
	    	numero /= 1000;
	    	cadena = getCadenaLetras(n, numero) + c + cadena;
	 	}
	 	return  cadena; 
	}
	
	public static String getCadenaNumericaEnPalabrasMoneda(double n, String moneda){
		String  cadena         =  "";
		String  parte_entera   =  getCadenaNumericaEnPalabras((long)n);
		String  parte_decimal  =  "";
		
		double valor_decimal = n;
		valor_decimal = UtilNumeros.redondeaDouble(valor_decimal,2);
		parte_decimal = valor_decimal + "";
		parte_decimal = parte_decimal.substring(parte_decimal.indexOf('.')+1, parte_decimal.length());
		
		
		if(UtilNumeros.leeInteger(parte_decimal) <10){
			parte_decimal = parte_decimal + "0";
		}
		
		if(parte_entera.length()>1){
			parte_entera = (parte_entera.charAt(0)+"").toUpperCase() + parte_entera.substring(1,parte_entera.length()); 
		}
		else{
			parte_entera = "Cero";
		}
		
		cadena = "Son " + parte_entera + " y " + parte_decimal + "/100 " + moneda;

		return cadena;
	}
	
	public static boolean isDoubleAndInteger(double n) {
		boolean b = false;
		int temp = (int)n;
		if(n-temp == 0) {//Example: 11.00 - 11 = 0.00
			b = true;
		}
		return b;
	}
	
	/**
	 * 
	 * Obtiene la distancia entre 2 puntos A(a,b) y B(c,d)
	*/
	public static double getDistanciaEntreDosPuntos(double a, double b, double c, double d) {
		double distancia = 0;
		
		distancia = Math.sqrt(Math.pow(a-c, 2) + Math.pow(b-d, 2)); 
		
		return distancia;
	}

	/**
	 * 
	 * Obtiene la distancia entre 2 puntos A(a,b) y B(c,d)
	*/
	public static int getDistanciaEntreDosPuntos(int a, int b, int c, int d) {
		int distancia = 0;
		
		distancia = (int)Math.sqrt(Math.pow(a-c, 2) + Math.pow(b-d, 2)); 
		
		return distancia;
	}
	
 }
