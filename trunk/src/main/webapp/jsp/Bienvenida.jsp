<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">

<%@page import="com.ttporg.pe.bean.Usuario"%><html>
<%@taglib prefix="s" uri="/struts-tags" %>

 <head>
     <s:include value="../include/Titulo.jsp"  />  
     <s:include value="../include/Estilos.jsp" /> 
     <s:include value="../include/Scripts.jsp" /> 
 </head>

 <body bottomMargin="0" leftMargin="0" topMargin="0" rightMargin="0" marginwidth="0" marginheight="0" bgcolor="white">
  
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
			      Bienvenido Sr(a): 
			      <strong>
			      <s:property value="#session.objUsuario.nombres"   />
			      <s:property value="#session.objUsuario.apellidos" />
			      </strong>
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

