
 <%@ page contentType="text/html;charset=utf-8" %>
 
 <%@ page import="com.ttporg.pe.util.UtilSingleton" %>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"  %>
 

<%@page import="com.ttporg.pe.bean.Cliente"%><fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" />  

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
	       prenderTodas( formulario );	  	        
		   formulario.estrella_02.src      =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
		   formulario.estrella_03.src      =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
		   formulario.estrella_04.src      =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
		   formulario.estrella_05.src      =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
	       formulario.mensajeRanking.value =  "Malo!!!";
	   }
	   if( parametro == "DOS" ){
	       prenderTodas( formulario );
		   formulario.estrella_03.src      =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
		   formulario.estrella_04.src      =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
		   formulario.estrella_05.src      =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
	       formulario.mensajeRanking.value =  'Regular!!!';		   		   
	   }
	   if( parametro == "TRES" ){
	       prenderTodas( formulario );
	       formulario.estrella_04.src      =  '<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif';
	       formulario.estrella_05.src      =  '<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif';
	       formulario.mensajeRanking.value =  'Pasable!!!';			   		   	
	   }
	   if( parametro == "CUATRO" ){
           prenderTodas( formulario );
           formulario.estrella_05.src      =  '<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif';	
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
	   
	 formulario.estrella_01.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaPrendida.gif";
	 formulario.estrella_02.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaPrendida.gif";
	 formulario.estrella_03.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaPrendida.gif";
	 formulario.estrella_04.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaPrendida.gif";
	 formulario.estrella_05.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaPrendida.gif";              
}

function apagarTodas( formulario ){
	 //alert( "apagarTodas" ); 
		 
	 formulario.estrella_01.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
	 formulario.estrella_02.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
	 formulario.estrella_03.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
	 formulario.estrella_04.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";
	 formulario.estrella_05.src   =  "<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif";   
}

function seleccionarEstrella( msnParam ){
     //alert( "seleccionarEstrella" ); 
		 
	   if( msnParam == "Malo!!!" ){
	       alert("Su opinion es: " + msnParam + ", gracias por votar." );  
	   }
	   if( msnParam == "Regular!!!" ){
	       alert("Su opinion es: " + msnParam + ", gracias por votar." );    	   		   
	   }
	   if( msnParam == "Pasable!!!" ){
	       alert("Su opinion es: " + msnParam + ", gracias por votar." );    		   		   	
	   }
	   if( msnParam == "Bueno!!!" ){
	       alert("Su opinion es: " + msnParam + ", gracias por votar." );    			
	   }
	   if( msnParam == "Excelente!!!" ){
	       alert("Su opinion es: " + msnParam + ", gracias por votar." );   		
	   }
}  
  //************** SCRIPT: MANEJO RANKING [FIN] **************//  
</script>

<script src="Scripts/swfobject_modified.js" type="text/javascript"></script>
 <table width="101%" height="700" border="1" cellPadding="4" cellSpacing="0" style="BORDER-COLLAPSE: collapse" bgcolor="white" > 
 
  <tr>
    <td height="30" align="center" class="menu" > 
       <font size="2" face="Arial" class="textoMenu" style="color:white" ><strong><fmt:message key="texto.label.menu.home" /></strong></font>
    </td>
  </tr>
  
  <tr> 
	  <td align="center">
        <object classid="clsid:166B1BCA-3F9C-11CF-8075-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/director/sw.cab#version=10,1,1,0" width="257" height="162" >  
           <param name="src" value="../swf/AmimacionLogos.swf" />
           <embed src="<%=request.getContextPath()%>/swf/AmimacionLogos.swf" pluginspage="http://www.adobe.com/shockwave/download/" width="257" height="162" ></embed>
        </object>
      </td> 
  </tr> 
  
  <tr> <td></td> </tr> 
  
  <tr> 
	  <td>                 
         <table width="100%" border="0" bgcolor="#0066FF" >
            <tr> 
             <td align="center" >
 	     <a href="<%=request.getContextPath()%>/jsp/Opcion_02.jsp" style="cursor:hand" />
 	        <font size="2" face="Arial" class="textoMenu" style="color:white" ><strong><fmt:message key="texto.label.menu.servicios" /></strong></font>
	     </a>            
              </td> 
            </tr> 
         </table> 
         
         <marquee bgcolor="#FFFFFF" width="50%" height="80" direction="up" scrolldelay="250" >   
            
         <table width="100" border="0">
         
             <tr> 
                <td width="20"> </td>  
                <td width="80"> </td>
             </tr> 
              
		     <% 	
		        Cliente objClienteSesion = (Cliente)session.getAttribute( "objCliente" );
	 
		        if( objClienteSesion != null ){
		     %>
              
             <tr> 
                <td width="20">   
                 <a href="<%=request.getContextPath()%>/jsp/BusquedaAgencia.jsp" style="cursor:hand" />
                   <img src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Empresas" width="20" height="19"  border="0" />
                 </a>
                </td>  
                <td width="80">
                   <a href="<%=request.getContextPath()%>/jsp/BusquedaAgencia.jsp" style="cursor:hand" />
                      <font size="2" face="Arial" class="textoMenu" ><fmt:message key="texto.label.menu.agencias" /></font> 
                   </a>             
                </td>
              </tr>
              
              <tr> 
                <td width="20">
                     <a href="<%=request.getContextPath()%>/jsp/BusquedaBuses.jsp" style="cursor:hand" />
                       <img src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Buses" width="20" height="19"  border="0" />
                     </a>
                </td>  
                <td width="80">
                   <a href="<%=request.getContextPath()%>/jsp/BusquedaBuses.jsp" style="cursor:hand" />
                      <font size="2" face="Arial" class="textoMenu" ><fmt:message key="texto.label.menu.buses" /></font> 
                   </a>            
                </td>
              </tr>
              
             <%}
	           else{
               %>     
                  <tr> 
                    <td width="100" colspan="2"> <strong> <font size="2" face="Arial" color="red"> <fmt:message key="texto.label.menuPrincipal.registrarse" /> </font> </strong>  </td>  
                  </tr> 
               <%}%>  
              
        </table>
        
        </marquee>
        
	  </td>  
  </tr> 
  
  <tr> <td></td> </tr> 
    
 <tr> 
	  <td>
         <table width="100%" border="0" bgcolor="#0066FF" >
            <tr> 
             <td align="center" >
		 	     <a href="<%=request.getContextPath()%>/jsp/Opcion_02.jsp" style="cursor:hand" />
		            <font size="2" face="Arial" class="textoMenu" style="color:white" ><strong><fmt:message key="texto.label.menu.informes" /></strong></font>
			     </a>            
              </td> 
            </tr> 
         </table> 
 
         <marquee bgcolor="#FFFFFF" width="50%" height="200" direction="up" scrolldelay="250" > 
             <table width="100" border="0">             
                  <tr> 
                    <td width="20"> </td>  
                    <td width="80"> </td>
                  </tr>                   
		     <%  
		        if( objClienteSesion != null ){
		     %>
                  
                  <tr> 
                    <td width="20">                
                     <a href="<%=request.getContextPath()%>/jsp/BusquedaAgencia.jsp" style="cursor:hand" />
                       <img src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Empresas" width="20" height="19"  border="0" />
                     </a>
                    </td>  
                    <td width="80">
                       <a href="<%=request.getContextPath()%>/jsp/Informes.jsp" style="cursor:hand" />
                          <font size="2" face="Arial" class="textoMenu" ><fmt:message key="texto.label.menu.informacion" /></font> 
                       </a>             
                    </td>
                  </tr>
                  
                  <tr> 
                    <td width="20">
                         <a href="<%=request.getContextPath()%>/jsp/Informes.jsp" style="cursor:hand" />
                           <img src="<%=request.getContextPath()%>/imagenes/Seleccion.gif" alt="Buses" width="20" height="19"  border="0" />
                         </a>
                    </td>  
                    <td width="80">
                       <a href="<%=request.getContextPath()%>/jsp/BusquedaBuses.jsp" style="cursor:hand" />
                          <font size="2" face="Arial" class="textoMenu" ><fmt:message key="texto.label.menu.informacion" /></font> 
                       </a>            
                    </td>
                  </tr>
                  
             <%}
	           else{
               %>     
                  <tr> 
                    <td width="100" colspan="2"> <strong> <font size="2" face="Arial" color="red"> <fmt:message key="texto.label.menuPrincipal.registrarse" /> </font> </strong>  </td>  
                  </tr>  
               <%}%>  
                  
            </table>
        
        </marquee>    
            
	  </td>  
  </tr> 
  
  <tr> <td></td> </tr> 
  
   <tr> 
    <td>
		<form id="frmRanking" name="frmRanking">
		
         <table width="100%" border="0" bgcolor="#0066FF" >
            <tr> 
             <td align="center" >
		 	     <a href="<%=request.getContextPath()%>/jsp/Opcion_02.jsp" style="cursor:hand" />
		            <font size="2" face="Arial" class="textoMenu" style="color:white" ><strong><fmt:message key="texto.label.menu.ranking" /></strong></font>
			     </a>            
              </td> 
            </tr> 
         </table>         
        
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr> 
            <td colspan="5">
             &nbsp;
            </td>  
          </tr>
        
		  <tr> 
            <td colspan="5">
             &nbsp;Califique porfavor el servicio que le ofrecemos.
            </td>  
          </tr>
        </table>
        
		<table width="70%" border="0" cellspacing="0" cellpadding="0">
           <tr>          
		   <td colspan="5">&nbsp; </td>          
          </tr>
          
          <tr>
		   <td valign="top" width="22" >  
		   <img src="<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif" name="estrella_01" id="estrella_01" onMouseOver="cambiarEstrella('UNO')" 
		      onClick="seleccionarEstrella('Malo!!!')" style="cursor:hand" />   
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif" name="estrella_02" id="estrella_02" onMouseOver="cambiarEstrella('DOS')"    
		      onClick="seleccionarEstrella('Regular!!!')" style="cursor:hand" />    
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif" name="estrella_03" id="estrella_03" onMouseOver="cambiarEstrella('TRES')"    
		      onClick="seleccionarEstrella('Pasable!!!')" style="cursor:hand" />   
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif" name="estrella_04" id="estrella_04" onMouseOver="cambiarEstrella('CUATRO')"    
		      onClick="seleccionarEstrella('Bueno!!!')" style="cursor:hand" />    
		   </td>
		   <td valign="top" width="22">
		   <img src="<%=request.getContextPath()%>/imagenes/EstrellaApagada.gif" name="estrella_05" id="estrella_05" onMouseOver="cambiarEstrella('CINCO')"    
		     onClick="seleccionarEstrella('Excelente!!!')" style="cursor:hand" />    
		   </td>
		  </tr>
		  
		  <tr> <td></td> </tr> 
		  
		  <tr>
		    <td colspan="5"> 
			  <input type="text" id="mensajeRanking" value="Ranking seleccionar!!!" class="textoMenu" >
			</td>
		  </tr>    
		</table>
		 
		</form>  
    </td> 
  </tr> 
  
  <tr> <td></td> </tr> 
  
  <tr> 
	  <td align="center"> 
	  
	    <br>
	    <br>
	    
        <object classid="clsid:166B1BCA-3F9C-11CF-8075-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/director/sw.cab#version=10,1,1,0" width="243" height="138">
            <param name="src" value="../swf/Paisajes.swf" />
            <embed src="<%=request.getContextPath()%>/swf/Paisajes.swf" pluginspage="http://www.adobe.com/shockwave/download/" width="243" height="138"></embed>
      </object>
      
      <br>
      <br>
      
      </td> 
  </tr>   
  
  <tr> <td></td> </tr> 
              
</table>
