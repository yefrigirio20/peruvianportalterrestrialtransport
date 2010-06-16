
/********** ESTA FUNCION ES PARA EL PROCESO DE ENVIO DEL EMAIL **********/

 function crearObjetoHTTPAjax(){
		var objetoAjax = null;
		try{
			/* Para navegadores distintos a internet explorer */
			objetoAjax = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (error){
			try{
				/* Para explorer */
				objetoAjax  =  new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (error2){
				objetoAjax  =  null;
			}
		}	
		if (objetoAjax == null){
			objetoAjax = new XMLHttpRequest();
		}
		else if (typeof XMLHttpRequest != 'undefined'){
			objetoAjax = new XMLHttpRequest();
		}	
	 return objetoAjax;
 }

/************************************************************************/


//Remueve espacios en blanco
String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g, '');
}


//Hace una precarga de imagenes
function preloadImages() {
   if (document.images) {
      for (var i = 0; i < preloadImages.arguments.length; i++) {
         (new Image()).src = preloadImages.arguments[i];
      }
   }
}


function inicializar(){
	preloadImages();
}

document.onload = inicializar;

