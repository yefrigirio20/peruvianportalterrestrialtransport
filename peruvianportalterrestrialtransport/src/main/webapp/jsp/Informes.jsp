  <%@ page contentType="text/html;charset=utf-8" %>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"  %>  
 
 <%@taglib uri="/struts-tags"                       prefix="s"    %>
 <%@taglib uri="/struts-dojo-tags"                  prefix="sx"   %> 
 
 <%@page import="com.ttporg.pe.bean.Usuario" %>
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head>
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" />    
     
     <fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" />    
 </head>

 <body style="margin:0px;" onload="detectarControlesEnabledDisabled()" > 
  
  <form id="idFrmBusquedaPasaje" name="frmBusquedaPasaje" >
  
   <!-- TABLA #1 -->
   <table width="100%" height="28" border="0" >
      <tr valign="top" >
        <td width="100%" height="22" colspan="4" ><jsp:include page="../include/Cabecera.jsp" flush="false" /></td>
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
			                <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloInformes" /> </font>  
			             </center>       
				        </td>       
					  </tr>
                      
				      <tr> <td width="10%" colspan="4" >&nbsp;</td> </tr>
                      
				      <tr>                         
					     <td width="10%" >&nbsp;</td>
				         <td width="80%" colspan="2" >
					         <label>
	                           Peruvian Portal Terrestrial Transport, brinda la informacion resaltante de cada empresa registrada en el Portal. 
					         </label>
				         </td>
				         <td width="10%" >&nbsp;</td>
				      </tr>
                    
				      <tr>   
				         <td colspan="4" >&nbsp;</td>
				      </tr>
                    
                     <tr> 
                         <td colspan="4" align="center">
                             <table border="0" width="70%" bgcolor="white">
  
                                 <tr> 
                                    <td>
                                    
                                     <table border="0" width="100%" bgcolor="white">
                                          <tr>
                                             <td width="60%" bgcolor="#0066FF" >                                                
                                             <center> <font color="#FFFFFF"> <strong>TITULO #1</strong></font> 
                                               </center>
                                             </td>
                                          </tr>      
                                                    
                      <tr>   
				         <td colspan="4" >&nbsp; XXX</td>
				      </tr>
                                         </table>
                                     </td>    
                                 </tr>
      
                            </table>       
                        </td>
                    </tr> 
                    
                  <tr>
                     <td width="10%" >&nbsp;</td>
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

