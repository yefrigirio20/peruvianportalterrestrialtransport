
//************** SCRIPT: MOVIMIENTO EN BARRA ESTADO [INICIO] **************//
var mensaje = "...::: PORTAL TERRESTIAL TRANSPORT:::...";    
var message = mensaje + "          "; 

var i         = "0";			         
var temptitle = "";

function mensajeBarraTitulo(){

	if( !document.all && !document.getElementById )
        return
        
	document.title = temptitle + message.charAt(i);
		
	temptitle = temptitle + message.charAt(i);
	
	i++;	
	
	if( i == message.length ){
	    i = "0";
	    temptitle = "";
	}
	
	setTimeout( "mensajeBarraTitulo()", 80 );
}

window.onload = mensajeBarraTitulo;
//************** SCRIPT: MOVIMIENTO EN BARRA ESTADO [FIN] **************//


/*******************************************************************************************************************/
/******** 'JS', CONTENIENDO 2 FUNCIONES PARA EL MANEJO DIFERENCIACION DE ESTILOS PARA 'ENABLED' Y 'DISABLED' *******/
/*******************************************************************************************************************/

function detectarControlesEnabledDisabled(){    
	//alert( "DENTRO DE 'detectarControlesEnabledDisabled()' " );
	
	var formulario    = document.getElementById( "frnValidacion" );
	
	var objControles  = formulario.getElementsByTagName( 'input'    );  //Obtiene todos los Controles 'Input'.
	var objControles2 = formulario.getElementsByTagName( 'textarea' );  //Obtiene todos los Controles 'TextArea'.
	var objControles3 = formulario.getElementsByTagName( 'select'   );  //Obtiene todos los Controles 'Select'.		
				
				
	//RECORRIDO OBJETOS 'INPUT'.
	for( var i=0; i<objControles.length; i++ ){ 

		 //alert( "Dentro del 'FOR' de Controles " );
		 
		 var control   = objControles[i];    //Asigna el Objeto obtenido.
         var nombre    = control.id;         //Obtiene el Id del campo.
		 var validator = control.disabled;   //Obtiene si el campo esta Desabilitado.
		 
		 //alert( "Nombre Control: " + nombre );
		 
		 //Valida si es tipo 'INPUT-TEXT'.
		 if( control.type == 'text' ){
		     //alert( " Si es un control tipo 'TEXT' " );
			 this.aplicaCSS( control, validator );
		 }
		 
		 //Valida si es tipo 'INPUT-CHECKBOX'.
		 if( control.type == 'checkbox' ){
		     //alert( " Si es un control tipo 'CHECKBOX' " );
			 this.aplicaCSS( control, validator );
		 }				 
		 
		 //Valida si es tipo 'INPUT-BUTTON'.
		 if( control.type == 'button' ){
		     //alert( " Si es un control tipo 'BUTTON' " );
			 this.aplicaCSS( control, validator );
		 }
		 
		 //Valida si es tipo 'INPUT-SUBMIT'.
		 if( control.type == 'submit' ){
		     //alert( " Si es un control tipo 'SUBMIT' " );
			 this.aplicaCSS( control, validator );
		 } 
	}		
	
	//RECORRIDO OBJETOS 'TEXT-AREA'.
	for( var j=0; j<objControles2.length; j++ ){ 
		 
		 var control2   = objControles2[j];    //Asigna el Objeto obtenido.
         var nombre2    = control2.id;         //Obtiene el Id del campo.
		 var validator2 = control2.disabled;   //Obtiene si el campo esta Desabilitado.
		 
		 //alert( "Nombre Control: " + nombre2 );
		 
		 //alert( " Si es un control tipo 'TEXT-AREA' " );
		 this.aplicaCSS( control2, validator2 );
    }	
    
	//RECORRIDO OBJETOS 'SELECT'.
	for( var x=0; x<objControles3.length; x++ ){ 
		 
		 var control3   = objControles3[x];    //Asigna el Objeto obtenido.
         var nombre3    = control3.id;         //Obtiene el Id del campo.
		 var validator3 = control3.disabled;   //Obtiene si el campo esta Desabilitado.
		 
		 //alert( "Nombre Control: " + nombre3 );
		 
		 //alert( " Si es un control tipo 'SELECT' " );
		 this.aplicaCSS( control3, validator3 );
    }	
     
}
		
function aplicaCSS( control, validator ){	
	 if( validator == true ){
		 //alert( "DISABLED 'TRUE' " );
		 control.style.color      = "#FFFFFF";
		 control.style.background = "#B5B9B9";
	 }
	 else{
		 //alert( "DISABLED 'FALSE' " );
		 control.style.color      = "#003979";
		 control.style.background = "#C6CACA";
	 }
 }

