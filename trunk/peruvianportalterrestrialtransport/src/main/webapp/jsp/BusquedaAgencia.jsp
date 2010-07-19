 <%@ page contentType="text/html;charset=utf-8" %>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"  %>  
 
 <%@taglib uri="/struts-tags"                       prefix="s"    %>
 <%@taglib uri="/struts-dojo-tags"                  prefix="sx"   %>  

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

				  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="2" >
				
				      <tr>
					     <td width="10%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="10%" >&nbsp;</td>
				      </tr>	
				      	  
					  <tr>
	                   <td colspan="4" >
	                     <center>
	                       <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloAgencia" /> </font>
	                     </center>
	                   </td>        
					  </tr>
                      
				      <tr> <td width="10%" colspan="4" >&nbsp;</td> </tr>
                      
				      <tr>                         
					     <td width="10%" >&nbsp;</td>
				         <td width="80%" colspan="2" >
				         <label>
                            Peruvian Portal Terrestrial Transport. Cuenta con un motor de busqueda de las agencias de las diferentes Empresas de Transporte subscritas al portal.
                         </label>
                         </td> 
				         <td width="10%" >&nbsp;</td>
				      </tr>	
				        
				      <tr> <td width="10%" colspan="4" >&nbsp;</td> </tr>
                        
				      <tr>
					     <td width="10%" >&nbsp;</td>
				         <td width="80%" colspan="2"> 
	                      <fieldset style="border:1px solid #0066FF;font-family: Arial; font-size: 13px;" >
				             <legend accesskey=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" ><fmt:message key="texto.label.filtro" />: </legend>
	                   
	                          <table width="100%" >
                                 
                                  <tr>	  
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%"><label><fmt:message key="texto.label.departamento" />:</label></td>
                                     <td width="40%">
                                        <select id="idChoDepartamento" name="choDepartamento" style="width:150px;">
                                           <option>Lima</option>
                                           <option>Ica</option>
                                           <option>Puno</option>
                                        </select>
                                     </td>    
                                     <td width="10%" align="left" >
                                         <button id="idBtnConsultar" type="submit" > <fmt:message key="texto.button.consultar" /> </button>   
                                     </td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td><label><fmt:message key="texto.label.empresa" />:</label></td>
                                     <td>
                                       <select id="idChoEmpresa" name="choEmpresa" style="width:150px;">
                                          <option>Cruz del Sur</option>
                                          <option>Las Flores</option> 
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>

                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%" >&nbsp;</td>
                                     <td width="40%" >&nbsp;</td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>	
                                                                  
	                          </table>
	                       </fieldset>      
				         </td>
     
                         
				         <td width="10%" >&nbsp;</td>
				    </tr>
                    	 
				      <tr> <td width="10%" colspan="4" >&nbsp;</td> </tr>
                    
                     <tr> 
                         <td colspan="4" align="center">
                             <table border="0" width="70%" bgcolor="white">
  
                                 <tr> 
                                    <td>
                                    
                                     <table border="0" width="100%" bgcolor="white">
                                          <tr>
                                             <td bgcolor="#0066FF" colspan="2" >                                                <center> <font color="#FFFFFF"> <strong>Empresa</strong></font> 
                                               </center>
                                             </td>
                                          </tr> 
                                          
                                          <tr> 
                                            <td width="39%"><strong>Razon Social:</strong></td>
                                            <td width="61%">aaa</td> 
                                          </tr> 
                                         
                                           <tr> 
                                            <td><strong>Departamento:</strong></td>
                                            <td>aaa</td> 
                                          </tr> 
                                          
                                          <tr> 
                                            <td><strong>Ruc:</strong></td>
                                            <td>aaa</td> 
                                          </tr> 
                                         
                                          <tr> 
                                            <td><strong>Direccion:</strong></td>
                                            <td>aaa</td> 
                                          </tr> 
                                            
                                          <tr> 
                                            <td><strong>Telefono:</strong></td>
                                            <td>aaa</td> 
                                          </tr>
                                          
                                           <tr> 
                                            <td><strong>Email:</strong></td>
                                            <td>aaa</td> 
                                          </tr> 
                                            
                                         </table>
                                     </td>    
                                 </tr>
                                 
                                 <tr>
                                     <td>
                                      <table border="0" width="100%" bgcolor="white">
                                          <tr>
                                             <td bgcolor="#0066FF" colspan="2" >                                                <center> <font color="#FFFFFF"><strong>Agencias</strong></font> 
                                               </center>
                                             </td>
                                          </tr> 
                                          
                                          <tr> 
                                            <td width="39%"><strong>Nombre:</strong></td>
                                            <td width="61%">aaa</td> 
                                          </tr> 
                                         
                                          <tr> 
                                            <td width="39%"><strong>Departamento:</strong></td>
                                            <td width="61%">aaa</td> 
                                          </tr> 
                                         
                                           <tr> 
                                            <td><strong>Direccion:</strong></td>
                                            <td>aaa</td> 
                                          </tr> 
                                          
                                          <tr> 
                                            <td><strong>Telefono:</strong></td>
                                            <td>aaa</td> 
                                          </tr> 
                                            
                                           <tr> 
                                            <td>&nbsp;</td>
                                            <td>&nbsp;</td> 
                                          </tr>  
                                            
                                         </table>
                                     </td>
                                 </tr> 
                                              
                            </table>       
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
                     <td width="40%" >&nbsp;</td>
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

