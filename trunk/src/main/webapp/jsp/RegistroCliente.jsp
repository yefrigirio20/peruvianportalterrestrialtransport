<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">

<%@page import="com.ttporg.pe.bean.Usuario"%><html>
<%@taglib prefix="s" uri="/struts-tags" %>

 <head>
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" /> 
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
           <form id="frnRegistroCliente" >		 
           
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="2" >
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td colspan="4" ><center>
                     <font color="#9E353F" size="5"> Registro de Cliente </font>
                   </center></td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" colspan="2" >Los campos marcados con <strong><font color="#FF0000" size="+1" >*</font></strong> deben de ser ingresados de forma obligatoria.</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 
                 <tr> 
                   <td width="10%" >&nbsp;</td>
                   <td width="80%" colspan="2" > 
                      <FIELDSET style="border:1px solid #0066FF;font-family: Arial; font-size: 13px; width:400" >
			             <LEGEND ACCESSKEY=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" >Datos Cliente: </LEGEND>
                   
                          <table width="100%" >  
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" >Nombres:<strong><font color="#FF0000" size="+1" >*</font></strong></td>
                               <td width="40%" ><input type="text" name="textfield5" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                             
                            <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" >Nombres:<strong><font color="#FF0000" size="+1" >*</font></strong></td>
                               <td width="40%" ><input type="text" name="textfield" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" >Apellidos:<strong><font color="#FF0000" size="+1" >*</font></strong></td>
                               <td width="40%" ><input type="text" name="textfield" /></td>
                               <td width="10%" align="left" >&nbsp;</td>
                             </tr>
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" >Fecha Nacimiento<strong><font color="#FF0000" size="+1" >*</font></strong>:</td>
                               <td width="40%" ><input type="text" name="textfield2" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" >Direccion<strong><font color="#FF0000" size="+1" >*</font></strong>:</td>
                               <td width="40%" ><input type="text" name="textfield3" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                              <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" >Email<strong><font color="#FF0000" size="+1" >*</font></strong>:</td>
                               <td width="40%" ><input type="text" name="textfield4" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                          </table> 
                          
                        </FIELDSET>  
                   </td>
                   <td width="10%" >&nbsp;</td>
                 </tr>                 
 
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="80%" colspan="2" >
                      <FIELDSET style="border:1px solid #0066FF;font-family: Arial; font-size: 13px; width:400" >
                        <LEGEND ACCESSKEY=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" >Atenticación: </LEGEND>
                        <table width="100%" align="center" >
                              <tr align="left">
                                <td width="10%" >&nbsp;</td>
                                <td width="40%">Usuario<font color="#FF0000" size="+1" >*</font></strong>: </td>
                                <td width="40%"><input type="text" name="textfield7" />	</td>
                                <td width="10%" >&nbsp;</td>
                              </tr>
                              <tr align="left">
                                <td width="10%" >&nbsp;</td>
                                <td width="40%">Password<font color="#FF0000" size="+1" >*</font></strong>: </td>
                                <td width="40%"><input type="text" name="textfield7" />	</td>
                                <td width="10%" >&nbsp;</td>
                              </tr>
                        </table>
                        </FIELDSET>
                   </td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
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
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" align="right" ><A href="http://www.verisign.es/ssl/ssl-information-center/index.html?sl=t13630207740000018">
                     <IMG src="../imagenes/LogoVeriSign.gif" width="100" height="45">
                   </A></td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
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

