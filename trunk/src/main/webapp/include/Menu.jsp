
<%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="../include/Estilos.jsp" flush="true" />

<script language="JavaScript" type="text/javascript">
//************** SCRIPT: MANEJO RANKING [INICIO] **************//
function cambiarEstrella( parametro ){      
	   //alert( parametro );     
	   var formulario   =  document.getElementById( "frmRanking" );
	   
	   var estrella_01  =  document.getElementById( "estrella_01" );
	   var estrella_02  =  document.getElementById( "estrella_02" ); 
	   var estrella_03  =  document.getElementById( "estrella_03" ); 
	   var estrella_04  =  document.getElementById( "estrella_04" );
	   var estrella_05  =  document.getElementById( "estrella_05" );  
	   
	   if( parametro == "UNO" ){
	       apagarTodas( formulario );	   
	       formulario.estrella_01.src      =  "<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif";
	       formulario.mensajeRanking.value =  "Malo!!!";
	   }
	   if( parametro == "DOS" ){
	       apagarTodas( formulario );
	       formulario.estrella_01.src      =  '<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif';
	       formulario.estrella_02.src      =  '<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif';
	       formulario.mensajeRanking.value =  'Regular!!!';		   		   
	   }
	   if( parametro == "TRES" ){
	       apagarTodas( formulario );
	       formulario.estrella_01.src      =  '<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif';
	       formulario.estrella_02.src      =  '<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif';
	       formulario.estrella_03.src      =  '<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif';
	       formulario.mensajeRanking.value =  'Pasable!!!';			   		   	
	   }
	   if( parametro == "CUATRO" ){
           prenderTodas( formulario );
           formulario.estrella_05.src      =  '<%=request.getContextPath()%>/imagenes/estrellaApagada.gif';	
           formulario.mensajeRanking.value =  'Bueno!!!';				
	   }
	   if( parametro == "CINCO" ){
	       apagarTodas(  formulario );
           prenderTodas( formulario );
           formulario.mensajeRanking.value =  'Excelente!!!';				
	   }
}

function prenderTodas( formulario ){
	 //alert( "prenderTodas" ); 
	   
	 formulario.estrella_01.src   =  "<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif";
	 formulario.estrella_02.src   =  "<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif";
	 formulario.estrella_03.src   =  "<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif";
	 formulario.estrella_04.src   =  "<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif";
	 formulario.estrella_05.src   =  "<%=request.getContextPath()%>/imagenes/estrellaPrendida.gif";              
}

function apagarTodas( formulario ){
	 //alert( "apagarTodas" ); 
		 
	 formulario.estrella_01.src   =  "<%=request.getContextPath()%>/imagenes/estrellaApagada.gif";
	 formulario.estrella_02.src   =  "<%=request.getContextPath()%>/imagenes/estrellaApagada.gif";
	 formulario.estrella_03.src   =  "<%=request.getContextPath()%>/imagenes/estrellaApagada.gif";
	 formulario.estrella_04.src   =  "<%=request.getContextPath()%>/imagenes/estrellaApagada.gif";
	 formulario.estrella_05.src   =  "<%=request.getContextPath()%>/imagenes/estrellaApagada.gif";   
}

function seleccionarEstrella( msnParam ){
     //alert( "seleccionarEstrella" ); 
		 
	   if( msnParam == "Malo!!!" ){
	       alert("Su opinion es: " + msnParam );  
	   }
	   if( msnParam == "Regular!!!" ){
	       alert("Su opinion es: " + msnParam );  	   		   
	   }
	   if( msnParam == "Pasable!!!" ){
	       alert("Su opinion es: " + msnParam );  		   		   	
	   }
	   if( msnParam == "Bueno!!!" ){
	       alert("Su opinion es: " + msnParam );  			
	   }
	   if( msnParam == "Excelente!!!" ){
	       alert("Su opinion es: " + msnParam );  		
	   }
}  
  //************** SCRIPT: MANEJO RANKING [FIN] **************//  
</script>

<table width="100%" height="700" border="1" cellPadding="4" cellSpacing="0" style="BORDER-COLLAPSE: collapse" bgcolor="white" > 
  <tr>
    <td  height="30" align="center" class="menu" > <StrONG> MENU </StrONG> </td>
  </tr>
  
  <tr> 
    <td>
		<form id="frmRanking" name="frmRanking">
		
		<table width="140" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		   <td valign="top" width="22">  
		   <img src="<%=request.getContextPath()%>/imagenes/estrellaApagada.gif" name="estrella_01" id="estrella_01" onMouseOver="cambiarEstrella('UNO')" 
		        onClick="seleccionarEstrella('Malo!!!')" />   
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/estrellaApagada.gif" name="estrella_02" id="estrella_02" onMouseOver="cambiarEstrella('DOS')"    
		        onClick="seleccionarEstrella('Regular!!!')"/>   
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/estrellaApagada.gif" name="estrella_03" id="estrella_03" onMouseOver="cambiarEstrella('TRES')"    
		        onClick="seleccionarEstrella('Pasable!!!')"/>   
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/estrellaApagada.gif" name="estrella_04" id="estrella_04" onMouseOver="cambiarEstrella('CUATRO')"    
		        onClick="seleccionarEstrella('Bueno!!!')"/>   
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/estrellaApagada.gif" name="estrella_05" id="estrella_05" onMouseOver="cambiarEstrella('CINCO')"    
		        onClick="seleccionarEstrella('Excelente!!!')"/>   
		   </td>
		  </tr>
		  
		  <tr>
		    <td colspan="5"> 
			  <input type="text" id="mensajeRanking" value="Ranking seleccionar!!!" class="textoMenu" >
			</td>
		  </tr>    
		</table>
		 
		</form>  
    </td> 
  </tr> 

  <tr> 
	  <td>
	     <a href="<%=request.getContextPath()%>/jsp/Opcion_01.jsp" >
		   <img src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Opcion #1" width="20" height="19"  border="0" />
		   <font size="2" face="Arial" class="textoMenu" >Opcion #1</font>
	     </a>
	  </td> 
  </tr> 
  
  <tr> <td></td> </tr> 
  
  <tr> 
	  <td>
	     <a href="<%=request.getContextPath()%>/jsp/Opcion_02.jsp" >
		   <img src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Opcion #2" width="20" height="19"  border="0" />
		   <font size="2" face="Arial" class="textoMenu" >Opcion #2</font>
	     </a>
	  </td> 
  </tr> 
  
  <tr> <td></td> </tr> 
  
  <tr> 
	  <td>
	     <A href="<%=request.getContextPath()%>/jsp/Opcion_03.jsp" >
		   <IMG src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Opcion #3" width="20" height="19" border="0" />
		   <font size="2" face="Arial" class="textoMenu" >Opcion #3</font>
	     </A>
	  </td> 
  </tr> 
  
  <tr> <td></td> </tr> 
  
  <tr> 
	  <td>
	     <A href="<%=request.getContextPath()%>/jsp/Opcion_04.jsp" >
		   <img src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Opcion #4" width="20" height="19" border="0" />
		   <font size="2" face="Arial" class="textoMenu" >Opcion #4</font>
	     </A>
	  </td> 
  </tr>   
  
  <tr> <td></td> </tr> 
              
</table>




		
