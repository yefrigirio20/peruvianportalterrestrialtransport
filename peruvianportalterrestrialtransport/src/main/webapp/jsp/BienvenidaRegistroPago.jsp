 <%@ page contentType="text/html;charset=utf-8" %>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>   
 
 <%@ taglib uri="/struts-tags"                      prefix="s"   %>
 <%@ taglib uri="/struts-dojo-tags"                 prefix="sx"  %>  

 <%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax" %>
 <%@ taglib uri="http://displaytag.sf.net"                      prefix="display" %>

 <%@page import="com.ttporg.pe.bean.Cliente" %> 
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head> 
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" /> 
     
     <fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" />  
 </head>

 <body style="margin:0px;" onload="detectarControlesEnabledDisabled()" > 
  
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
           <form id="frnRegistroCliente" >		 
           
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="2" >
                 <tr></tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="40%" >&nbsp;</td>
                   <td width="40%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td colspan="4" >
                     <center>
                       <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloProcesoPago" /> </font>
                     </center>
                   </td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="40%" >&nbsp;</td>
                   <td width="40%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" colspan="2" >
                      <label>
	                     Pague de forma sergura y rapida por internet. El proceso de pago esta respaldada por una entidad respetada <strong>
	                       <a href="http://www.verisign.es/ssl/ssl-information-center/index.html?sl=t13630207740000018">VeriSign</a>
	                   </strong>, para la acreditacion y serguridad en los pagos respectivos. 
                     </label>
                   </td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="80" colspan="2"><IMG src="../imagenes/PagoInternet.jpg" width="900" height="400"></td>
                   <td width="10%" align="left" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>
                    <table border="0" align="right" >
                     <tr>
                       <td><img src="../imagenes/LogoVisa.gif" width="37" height="23" /></td>
                       <td><img src="../imagenes/LogoMasterCard.gif" width="37" height="23" /></td>
                     </tr>
                   </table>
                   </td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" height="30" >&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td><input type="submit" name="Seguir" value="Seguir" style="width:100px; height:30px;" /></td>
                   <td>&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="45%" align="right" >
	                   <a href="http://www.verisign.es/ssl/ssl-information-center/index.html?sl=t13630207740000018" >
	                     <img src="../imagenes/LogoVeriSign.gif" width="100" height="45" />
	                   </a>
                   </td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
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

