 <%@ page contentType="text/html;charset=utf-8" %>
 	
 <%@taglib uri="/struts-tags"      prefix="s"  %>
 <%@taglib uri="/struts-dojo-tags" prefix="sx" %> 

 <%@page import="com.ttporg.pe.bean.Usuario" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head> 
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" /> 
     
	<script type="text/javascript">
		dojo.event.topic.subscribe("/beforeSelect", function(event, tab, tabContainer){
		    event.cancel = true;
		});
	</script>     
 </head>

 <body style="margin:0px;" > 
  
   <!-- TABLA #1 -->
   <table width="100%" height="28" border="0" >
      <tr valign="top" >
        <td width="100%" height="22" colspan="4" >
             <jsp:include page="../include/Cabecera.jsp" flush="false" />
        </td>
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
			   <form id="frnBienvenida" name="frnBienvenida" >		      
			      Bienvenido Cliente: 
			      <strong>
			        <s:property value="#session.objCliente.nombres" /> &nbsp;&nbsp; <s:property value="#session.objCliente.apellidos" />
			      </strong>
 
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
                           <p>Esta es su página
                             principal del Portal Perubian Terrestrial Transport. Aquí Ud. Podrá elegir los destinos, horarios,
                             servicios, etc. entre todas las empresas registradas en nuestro portal web, para que se pueda dirigir al destino turistico de su agrado.
                           </p>
                           <p>Las empresas de
                             transporte registradas con nosotros, son empresas formalmente establecidas
                             y consolidadas, por lo que el servicio que Ud. encontrará entre nuestros
                             clientes será siempre de primera calidad.         
                           </p>
                           <p>Esperamos que el servicio
                             que reciba sea de su entera satisfacción.         
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
 
			   </form>
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
		   
   </body>

</html>

