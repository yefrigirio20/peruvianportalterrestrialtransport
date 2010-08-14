 <%@ page contentType="text/html;charset=utf-8" %>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>  
 
 <%@taglib uri="/struts-tags"                       prefix="s"   %>
 <%@taglib uri="/struts-dojo-tags"                  prefix="sx"  %> 
 
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
      <tr>
        <td width="100%" height="22" colspan="4" id=LeftPane>
             <jsp:include page="../include/Cabecera.jsp" flush="false" />
        </td>
      </tr>
    </table>
      
   <!-- TABLA #2 -->
   <table width="100%" border=0>
       <tr>
         <td width="15%" valign="top" height="100%">
            <jsp:include page="../include/Menu.jsp" flush="true"/>
         </td>

         <!-- INCLUDE PRINCIPAL -->
         <td width="85%" valign="top">             
             
             <br></br>
             
             <center>
                <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloLogin" /> </font>
             </center> 
                
             <br></br>
             <br></br>
                   
			 <s:form id="frnValidacion" name="frnValidacion" action="/login.action" method="post" >	
			 
			   		<s:i18n name="com.ttporg.pe.msj.Internacionalizacion_es" > 
				    
				        <span class="mensajeTextoError" >
					      <s:actionerror cssErrorStyle="mensajeTextoError" />  
					      <s:fielderror  cssErrorStyle="mensajeTextoError" />  
					    </span>
					  					                      
		                <center> 
					    <table width="80%" > 
					      <tr> 
		                   <td align="right" width="30%" >
		                     &nbsp; &nbsp; &nbsp; &nbsp; <img src="<%=request.getContextPath()%>/imagenes/Atenticacion.png" alt="Atenticacion" width="200" height="205" border="0" />
		                   </td>               
		                  
						   <td align="right" width="90%" >  
						     
						       <table width="70%"> 
		                       
		                          <!--
							   	  <tr>                           
									  <td>										 
										 <label><fmt:message key="texto.label.usuario" /></label>										   
									  </td>
									 <td>
									     <s:textfield name="usuario" cssStyle="textoLabel" disabled="false" />  
								     </td>
								  </tr>  
								  								    
								  <tr> 
									  <td>
										  <span class="textoLabel" >
										    <fmt:message key="texto.label.password" />
										  </span>
									  </td>
									  <td> 
									    <s:password name="password" cssStyle="textoLabel" disabled="false" />
									    
									  </td>
								  </tr>								  
								  -->
								  
								  <tr>
									 <td colspan="2" align="center" > 
                                         <s:textfield name="usuario" key="texto.label.usuario" size="25" />
 									 </td>
								  </tr>	
								  								  
								  <tr>
									 <td colspan="2" align="center" > 
                                         <s:password name="password" key="texto.label.password" size="25" />
 									 </td>
								  </tr>								  
								  								  								  
							   	  <tr>
									 <td colspan="2" align="center" > 
	                                     <br></br>
	                                     <br></br>
 									 </td>
								  </tr>	
								  								  
							   	  <tr>
									 <td colspan="2" align="center" >
									   <span class="botonStruts2" > 
	                                      <s:submit method="execute" name="btnLogin"  key="texto.button.procesar" align="center" />
	                                   </span>  
 									 </td>
								  </tr>				  		  
								  
								</table>							   
						     </td>   
						  </tr>
						  
						</table> 
							 						
					  </center>					 
					
	              </s:i18n>  	
			  </s:form>
     
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

