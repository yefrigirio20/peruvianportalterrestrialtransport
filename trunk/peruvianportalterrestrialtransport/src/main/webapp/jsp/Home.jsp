 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"  %>  

 <%@ page import="com.ttporg.pe.bean.Usuario" %>  

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head>
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" />
     
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
 </head>

 <body onload="MM_preloadImages('<%=request.getContextPath()%>/imagenes/Paisaje_02.png','<%=request.getContextPath()%>/imagenes/Paisaje_05.png')"> 
  
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
				        <td colspan="4" >
						  <center> 
				             <font color="#9E353F" size="5">
				               Bienvenida
				             </font>  
				          </center>        
				        </td>          
					  </tr>
                      
				      <tr> <td width="10%" colspan="4" >&nbsp;</td> </tr>
                      
				      <tr>                         
					     <td width="10%" >&nbsp;</td>
				         <td width="80%" colspan="2" >
                           <p>Esta es su p�gina
                             principal del Portal Perubian Terrestrial Transport. Aqu� Ud. Podr� elegir los destinos, horarios,
                             servicios, etc. entre todas las empresas registradas en nuestro portal web, para que se pueda dirigir al destino turistico de su agrado.
                           </p>
                           <p>Las empresas de
                             transporte registradas con nosotros, son empresas formalmente establecidas
                             y consolidadas, por lo que el servicio que Ud. encontrar� entre nuestros
                             clientes ser� siempre de primera calidad.         
                           </p>
                           <p>Esperamos que el servicio
                             que reciba sea de su entera satisfacci�n.         
                         </p></td> 
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
         <td width="100%" height="22" colspan="4" id=LeftPane>
             <jsp:include page="../include/PiePagina.jsp" flush="false"/>   
         </td>
       </tr>   
   </table>  
		   		   
	</form> 
	  
</body>

</html>

