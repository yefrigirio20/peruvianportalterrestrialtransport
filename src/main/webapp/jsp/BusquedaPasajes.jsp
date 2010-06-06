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

				  <table width="80%" border="0" align="center" cellpadding="0" cellspacing="2" >
				
				      <tr>
					     <td width="20%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="20%" >&nbsp;</td>
				      </tr>	
				      	  
					  <tr>
				        <td colspan="4" >
						  <center> 
				             <font color="#9E353F" size="5">
				               Busqueda de Pasajes
				             </font>  
				          </center>        
				        </td>          
					  </tr>
					  
				      <tr>
					     <td width="20%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="20%" >&nbsp;</td>
				      </tr>	
				        
					  <tr>	  
					     <td width="20%" >&nbsp;</td>
				         <td width="265">Departamento</td>
				         <td width="358">
				            <select name="select" style="width:150px;">
				               <option>Lima</option>
				               <option>Ica</option>
				               <option>Puno</option>
				            </select>
				         </td>    
					     <td width="20%" align="left" >
				          <input type="submit" name="Guardar" value="Consultar" width="200" />
				         </td>
				      </tr>
				      
					  <tr>
					     <td width="20%" >&nbsp;</td>
				         <td>Empresa:</td>
				         <td>
				           <select name="select" style="width:150px;">
				              <option>Cruz del Sur</option>
				              <option>Las Flores</option> 
				           </select>
				         </td>
					     <td width="20%" >&nbsp;</td>
				      </tr>
				      
				      <tr>
					     <td width="20%" >&nbsp;</td>
				         <td>Servicio Transporte:</td>
				         <td>
				           <select name="select" style="width:150px;">
				               <option>Premiun</option> 
				               <option>Ejecutivo</option> 
				               <option>Economico</option> 
				           </select>
				         </td>
					     <td width="20%" >&nbsp;</td>
				      </tr>
				      
				      <tr>
					     <td width="20%" >&nbsp;</td>
				         <td>Dia:</td>
				         <td>
				            <input type="text" name="textfield4" />
				         </td>
					     <td width="20%" >&nbsp;</td>
				      </tr>
				      
				      <tr>
					     <td width="20%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="20%" >&nbsp;</td>
				      </tr>	
				      
				      <tr> 
				         <td colspan="4">
				             <table border="0" width="100%" bgcolor="gray">
				                 <tr>
				                     <td>Orden</td>
				                     <td>Origen</td>
				                     <td>Destino</td>
				                     <td>Salida</td>
				                     <td>Duracion </td>
				                     <td>Nro. Asientos</td>
				                 </tr>
				                 <tr>
				                     <td>1</td>
				                     <td>Lima</td>
				                     <td>Ica</td>
				                     <td>10:00 p.m.</td>
				                     <td>4:00 hras</td>
				                     <td>                        
				    <a href="popupex.html" onclick="return popitup('PopupBus.html')">35</a> 
				                     </td>
				                 </tr>
				                 <tr>
				                     <td>2</td>
				                     <td>Lima</td>
				                     <td>Puno</td>
				                     <td>6:00 a.m.</td>
				                     <td>16:00 hras</td>
				                     <td>
				     <a href="popupex.html" onclick="return popitup('PopupBus.html')">20</a> 
				                     </td>         
				                 </tr>              
				            </table>       
				        </td>
				    </tr> 
				         
				    <tr>
				       <td width="20%" >&nbsp;</td>
				       <td width="40%" >&nbsp;</td>
				       <td width="40%" >&nbsp;</td>
				       <td width="20%" >&nbsp;</td>
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
		   
   </body>

</html>

