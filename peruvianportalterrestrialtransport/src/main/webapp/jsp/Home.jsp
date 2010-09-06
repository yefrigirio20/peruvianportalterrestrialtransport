 <%@ page contentType="text/html;charset=utf-8" %>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>   
 
 <%@ taglib uri="/struts-tags"                      prefix="s"   %>
 <%@ taglib uri="/struts-dojo-tags"                 prefix="sx"  %>  

 <%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax" %>
 <%@ taglib uri="http://displaytag.sf.net"                      prefix="display" %>
 
 <%@ page import="com.ttporg.pe.bean.Cliente" %> 
 
 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head>
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" />    
     
     <fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" /> 
     
	 <script type="text/javascript">
			function MM_swapImgRestore() { //v3.0
			  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
			}
			function MM_preloadImages() { //v3.0
			  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
			    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
			    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
			}
			
			function MM_findObj(n, d) { //v4.01
			  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
			    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
			  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
			  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
			  if(!x && d.getElementById) x=d.getElementById(n); return x;
			}
			
			function MM_swapImage() { //v3.0
			  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
			   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
			}
	</script>	
	
	<script type="text/javascript">
	
	 var vAJAX;
	
	 function RecuperaResidencia( myFrm ){
	    alert( "DENTRO DE 'RecuperaResidencia' " );
	 
	    var vPERSONA = "java"; //document.all.INGRESO_DATOS.value;     //OBTENEMOS EL Id DE LA PERSONA
	    
	    alert("LA PERSONA ES: " + vPERSONA);
	    
		//CREAMOS EL CONTROL 'XMLHttpRequest', SEGÚN EL NAVEGADOR UTILIZADO: 
		if( window.XMLHttpRequest ){
			vAJAX = new XMLHttpRequest();                      //SI NO ES 'INTERNET EXPLORER'
		}
		else{
			vAJAX = new ActiveXObject( "Microsoft.XMLHTTP" );  //SI ES 'INTERNET EXPLORER'
	    }
		
		//ALMACENAMOS EN EL CONTROL, LA FUNCION QUE INVOCARA CUANDO LA PETICION CAMBIE DE ESTADO	
		vAJAX.onreadystatechange = funcionCallback;        //IMPORTANTE LOS LLAMADOS A LOS METODOS SE HACEN SIN PONER '()'
	    
		//ENVIAMOS LA PETICION...
		vAJAX.open( "GET", "<%=request.getContextPath()%>/ServletAjax?PERSONA=" + vPERSONA , true );
		vAJAX.send( "" );
	 }
	
	 function funcionCallback(){
	
		//COMPROBAMOS SI LA PETICION SE HA COMPROBADO:  (TIENE QUE COINCIDIR CON EL ESTADO #4)
		if( vAJAX.readyState == 4 ){
		
			//COMPROBAMOS SI LA RESPUESTA HA SIDO CORRECTA:  (TIENE QUE COINCIDIR CON 'HTTP 200')
			if( vAJAX.status == 200 ){
				//ESCRIBIMOS EL RESULTADO DE LA PAGINA 'HTML' MEDIANTE 'DHTML'
				document.all.IMPRIMIR.innerHTML = "<STRONG><FONT COLOR='RED'>" + vAJAX.responseText + "</FONT></STRONG>";	
			}
			else{
			     //alert("NO SE PUDO EN: 'vAJAX.status == 200' ");
			}
		}
		else{
			     //alert("NO SE PUDO EN: 'vAJAX.readyState == 4' ");
		}
	 }
	</script>
	
 </head>

 <body style="margin:0px;" onload="MM_preloadImages('<%=request.getContextPath()%>/imagenes/Paisaje_02.png','<%=request.getContextPath()%>/imagenes/Paisaje_05.png'), detectarControlesEnabledDisabled()"> 
      
  <form id="idHome" name="frmHome" >
   
   <!-- TABLA #1 -->
 <table width="100%" height="28" border="0" >
      <tr valign="top" >
        <td width="100%" height="22" colspan="4" >
        <jsp:include page="../include/Cabecera.jsp" flush="false" /></td>
      </tr>
 </table>
      
   <!-- TABLA #2 -->
   <table width="100%" border="0" >
       <tr valign="top" >
         <td width="15%" valign="top" height="100%">
            <jsp:include page="../include/Menu.jsp" flush="true"/>
         </td>

         <!-- INCLUDE PRINCIPAL -->
         <td width="85%" valign="top">             

				  <table width="70%" border="0" align="center" cellpadding="0" cellspacing="2" >
				
				      <tr>
					     <td width="10%" >&nbsp;</td>
				         <td width="80%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="10%" >&nbsp;</td>
				      </tr>	
				      	  
					  <tr>
					    <td align="center" colspan="4" >
			             <center>
			             
			            <!--  AJAX
						<input type="text"   id="INGRESO_DATOS" size="77" name="INGRESO_DATOS" />
						<input type="button" value="Consultar" onclick="RecuperaResidencia()"  />
					  
					     AQUI: <span id="IMPRIMIR"></span>  --> 
					     <!--PARA QUE SE VISUALICE AQUI EL 'DISTRITO' -->  
	             		 	                   			             
			                <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloBienvenida" /> </font>  
			             </center>       
				        </td>       
					  </tr>
                      
				      <tr> <td width="10%" colspan="4" >&nbsp;</td> </tr>
                      
				      <tr>                         
					     <td width="10%" >&nbsp;</td>
				         <td width="80%" colspan="2" >
				           <label>
	                           Esta es su página principal del Portal Perubian Terrestrial Transport. Aquí Ud. Podrá elegir los destinos, horarios, servicios, etc. entre todas las empresas registradas en nuestro portal web, para que se pueda dirigir al destino turistico de su agrado.
	                       </label>	  
	                                            
	                       <br></br>
	                       <br></br>
	                       
	                       <label>    
	                           Las empresas de transporte registradas con nosotros, son empresas formalmente establecidas y consolidadas, por lo que el servicio que Ud. encontrará entre nuestros clientes será siempre de primera calidad.         
	                       </label>  
	                       
	                       <br></br>
	                       <br></br>
	                       
	                       <label>   	
	                           Esperamos que el servicio que reciba sea de su entera satisfacción. 
	                       </label>
                         </td> 
				         <td width="10%" >&nbsp;</td>
				      </tr>
                    
				      <tr>   
				         <td colspan="4" >&nbsp;</td>
				      </tr>
				      <tr>   
				         <td colspan="4" >&nbsp;</td>
				      </tr>
				      <tr>   
				         <td colspan="4" >&nbsp;</td>
				      </tr>
                      
                     <tr> 
                         <td colspan="4" align="center">
                             <table border="0" width="70%" cellpadding="0" cellspacing="0" >
  
                                 <tr> 
                                    <td><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Imagenes_01','','<%=request.getContextPath()%>/imagenes/Paisaje_02.png',1)"><img src="<%=request.getContextPath()%>/imagenes/Paisaje_01.png" name="Imagenes_01" width="430" height="300" border="0" id="Imagenes_01" /></a></td> 
                                    
                                    <td> &nbsp; &nbsp; &nbsp; &nbsp;<td>
                                    
                                         <td><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Imagenes_02','','<%=request.getContextPath()%>/imagenes/Paisaje_05.png',1)"><img src="<%=request.getContextPath()%>/imagenes/Paisaje_04.png" name="Imagenes_02" width="430" height="300" border="0" id="Imagenes_02" /></a></td>                                   </tr>
      
                            </table>       
                        </td>
                    </tr> 
                    
                  <tr>
                     <td width="10%" >

                     </td>
                     <td width="80%" >&nbsp;</td>
                     <td width="40%" >&nbsp;</td>
                     <td width="10%" >&nbsp;</td>
                  </tr>	
                  
                  <tr style=" width : 758px; height : 53px;">
                     <td width="10%" >&nbsp;</td>
                     <td width="80%" >&nbsp;</td>
                     <td width="40%" >&nbsp;</td>
                     <td width="10%" >&nbsp;</td>
                  </tr>	 
                                     
				  </table>
				
 </td>
                 <!-- FIN INCLUDE PRINCIPAL -->
                 
               </tr>
            </table> 

   <!-- TABLA #3 -->
   <table width="100%" height="28" border="0">
       <tr>
         <td width='100%' height='22"' colspan='4' id='leftPane' >
             <jsp:include page="../include/PiePagina.jsp" flush="false"/>   
         </td>
       </tr>   
   </table>  
		   		   
	</form> 
	  
</body>

</html>

