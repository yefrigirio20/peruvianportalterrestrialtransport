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
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head>
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" />    
     
     <fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" />  
     
	 <!-- ESTILO DE FORMATO DLE CALENDARIO -->
	 <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/js/calendario/calendar-win2k-cold-1.css" title="calendar-win2k-cold-1.css" />
	
	 <!-- PROGRAMA PRINCIPAL DEL CALENDARIO -->
	 <script type="text/javascript" src="<%=request.getContextPath()%>/js/calendario/calendar.js">       </script>
	
	 <!-- LENGUAJE DEL CALENDARIO -->
	 <script type="text/javascript" src="<%=request.getContextPath()%>/js/calendario/calendar-en.js">    </script>
	
	 <!-- FUNCIONES PARA EL CALENDARIO -->
	 <script type="text/javascript" src="<%=request.getContextPath()%>/js/calendario/calendar-setup.js"> </script>     
     
	 <script type="text/javascript">
	    function catcalc( cal ){
	        var date = cal.date;
	        var time = date.getTime()
	        // use the _other_ field
	        var field = document.getElementById("f_calcdate");
	        if (field == cal.params.inputField){
	            field = document.getElementById("f_date_a");
	            time -= Date.WEEK; // substract one week
	        } else {
	            time += Date.WEEK; // add one week
	        }
	        var date2 = new Date(time);
	        field.value = date2.print("%Y-%m-%d %H:%M");
	    }    
	</script>    
     
 </head>

 <body style="margin:0px;" onload="detectarControlesEnabledDisabled()" > 
  
   <!-- TABLA #1 -->
   <table width="100%" height="28" border="0" >
      <tr valign="top" >
        <td width="100%" height="22" colspan="4" >
            <strong> <fmt:message key="texto.label.usuario" /> </strong>
            
            <jsp:include page="../include/Cabecera.jsp" flush="false" />
        </td>
      </tr>
    </table>
      
   <!-- TABLA #2 -->
   <table width="100%" border="0" >
       <tr valign="top" >
       
         <td width="15%" valign="top" height="100%" >  
         
           <form id="idFrnMenu" >
              <jsp:include page="../include/Menu.jsp" flush="true" />
           </form> 
         </td>

         <!-- INCLUDE PRINCIPAL -->
         <td width="85%" valign="top">             
     	 
           <form id="idFrnRegistroCliente" name="frnRegistroCliente" method="post" action="<%=request.getContextPath()%>/ServletRegistroCliente" >
             
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="2" >
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 
				  <tr>
                   <td colspan="4" >
                     <center>
                       <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloRegisCliente" /> </font>
                     </center>
                   </td>        
				  </tr>
                 
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" >&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" colspan="2" ><label>Los campos marcados con <strong><font color="#FF0000" size="+1" >*</font></strong> deben de ser ingresados de forma obligatoria.<label></td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 
                 <!-- ******************* VALIDACION DE 'JSP' ******************* -->
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="80%" colspan="2" > 
 
                     <c:if test="${objValidacion.mensajesNOK != null}" >  
			 	        <table width="40%" >
				            <c:forEach var="paramObjeto" items="${objValidacion.mensajesNOK}">
				
				               <tr> <td> <span class="mensajeTextoError" > ${paramObjeto} </span> </td> </tr>
				
				            </c:forEach>
				            
					        <c:if test="${estadoValidacion == true}" > 					        
						        <strong><span class="mensajeTextoError" > ${objValidacion.mensajeOK} </span> </strong>	 
					        </c:if>  
				        </table>
				        <br></br>
                     </c:if> 
                     
                   </td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <!-- ************************************************************** -->
                 
                 <tr> 
                   <td width="10%" >&nbsp;</td>
                   <td width="80%" colspan="2" > 
                      <fieldset style="border:1px solid #0066FF;font-family: Arial; font-size: 13px; width:400" >
			             <legend accesskey=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" ><fmt:message key="texto.label.datosCliente" />: </legend>
                   
                          <table width="100%" >  
                             
                            <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" ><label><fmt:message key="texto.label.nombres" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong></td>
                               <td width="40%" ><input type="text" id="txtIdNombres" name="txtNombres" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" ><label><fmt:message key="texto.label.apellidos" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong></td>
                               <td width="40%" ><input type="text" id="txtIdApellidos" name="txtApellidos" /></td>
                               <td width="10%" align="left" >&nbsp;</td>
                             </tr>
                             
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" ><label><fmt:message key="texto.label.dni" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong>:</td>
                               <td width="40%" ><input type="text" id="txtIdDni" name="txtDni" /> </td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                             
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" ><label><fmt:message key="texto.label.fechaNacimiento" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong>:</td>
                               <td width="40%" ><input type="text" id="txtIdFechaNacimiento" name="txtFechaNacimiento" /> <img src="<%=request.getContextPath()%>/imagenes/Calendario.jpg" id="idLlamarObjetoCalendario" style="cursor:pointer; border:0" /> </td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                             
                             <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" ><label><fmt:message key="texto.label.direccion" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong>:</td>
                               <td width="40%" ><input type="text" id="txtIdDireccion" name="txtDireccion" value="" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                              <tr>
                               <td width="10%" >&nbsp;</td>
                               <td width="40%" ><label><fmt:message key="texto.label.email" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong>:</td>
                               <td width="40%" ><input type="text" id="txtIdEmail" name="txtEmail" /></td>
                               <td width="10%" >&nbsp;</td>
                             </tr>
                          </table> 
                          
                        </fieldset>  
                   </td>
                   <td width="10%" >&nbsp;</td>
                 </tr>                 
 
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="80%" colspan="2" >
                      <fieldset style="border:1px solid #0066FF;font-family: Arial; font-size: 13px; width:400" >
                        <legend accesskey=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" ><fmt:message key="texto.label.autenticacion" />: </legend>
                        <table width="100%" align="center" >
                              <tr align="left">
                                <td width="10%" >&nbsp;</td>
                                <td width="40%"><label><fmt:message key="texto.label.usuario" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong> </td>
                                <td width="40%"><input type="text" id="txtIdUsuario" name="txtUsuario" />	</td>
                                <td width="10%" >&nbsp;</td>
                              </tr>
                              <tr align="left">
                                <td width="10%" >&nbsp;</td>
                                <td width="40%"><label><fmt:message key="texto.label.password" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong> </td>
                                <td width="40%"><input type="password" id="txtIdPassword" name="txtPassword" />	</td>
                                <td width="10%" >&nbsp;</td>
                              </tr>
                              <tr align="left">
                                <td width="10%" >&nbsp;</td>
                                <td width="40%"><label><fmt:message key="texto.label.confPassword" />:</label><strong><font color="#FF0000" size="+1" >*</font></strong> </td>
                                <td width="40%"><input type="password" id="txtIdConfirmPassword" name="txtConfirmPassword" />	</td>
                                <td width="10%" >&nbsp;</td>
                              </tr>
                          </table>
                        </fieldset>
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
                   <td>
                      <button id="idBtnPagar" name="Pagar" style="width:100px; height:30px;" > <fmt:message key="texto.button.guardar" /> </button>
                    </td>
                   <td>&nbsp;</td>
                   <td width="10%" >&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="60%" >&nbsp;</td>
                   <td width="45%" align="right" ><a href="http://www.verisign.es/ssl/ssl-information-center/index.html?sl=t13630207740000018">
                     <img src="../imagenes/LogoVeriSign.gif" width="100" height="45" />
                   </a></td>
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
		 
	<script type="text/javascript">
	    Calendar.setup({
	        inputField     :    "txtIdFechaNacimiento",      // ID DEL ARCHIVO DE ENTRADA (PARA TEXTFIELD)
	        ifFormat       :    "%Y-%m-%d",                  // FORMATO DEL ARCHIVO DE ENTRADA
			showsTime      :    true,                        // MOSTRAR EL TIEMPO DE SELECCION
	        button         :    "idLlamarObjetoCalendario",  // NOMBRE DEL SCRIPT PARA EL CALENDARIO(PARA OPCIONES DEL BOTON E IMAGENES)
	        align          :    "Tl",                        // ALINEAMIENTO (defaults to "Bl")
	        singleClick    :    true,                        // MODO DOBLE CLICK
	        step           :    1                            // MOSTRAR TODOS LOS AÑOS EN COMBO BOX
	    });
	</script>	 
		   
   </body>

</html>

