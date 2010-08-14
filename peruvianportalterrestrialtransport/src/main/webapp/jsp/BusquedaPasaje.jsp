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
     
	  <!-- ESTILO DE FORMATO DLE CALENDARIO -->
	  <link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/js/calendario/calendar-win2k-cold-1.css" title="calendar-win2k-cold-1.css" />
	
	  <!-- PROGRAMA PRINCIPAL DEL CALENDARIO -->
	  <script type="text/javascript" src="<%=request.getContextPath()%>/js/calendario/calendar.js">       </script>
	
	  <!-- LENGUAJE DEL CALENDARIO -->
	  <script type="text/javascript" src="<%=request.getContextPath()%>/js/calendario/calendar-en.js">    </script>
	
	  <!-- FUNCIONES PARA EL CALENDARIO -->
	  <script type="text/javascript" src="<%=request.getContextPath()%>/js/calendario/calendar-setup.js"> </script>     
     
	  <script type="text/javascript" >
	    function catcalc( cal ){
	        var date = cal.date;
	        var time = date.getTime()
	        
	        //use the _other_ field
	        var field = document.getElementById("f_calcdate");

	        if (field == cal.params.inputField){
	            field = document.getElementById("f_date_a");
	            time -= Date.WEEK; // substract one week
	        } 
	        else {
	            time += Date.WEEK; // add one week
	        }
	        var date2 = new Date(time);
	        field.value = date2.print("%Y-%m-%d %H:%M");
	   }     
 	   
	   function conexionServlet( myFrm, tipo ){              
			 //alert( "**** DENTRO DE 'conexionServlet' ****" );	 
			 
	         var url = "<%=request.getContextPath()%>/ServletBusquedaPasaje";
	         
	         url = url + '?opcionProceso=' + tipo; 
	         	 
   	         //alert( url );
   	     	
   	         myFrm.method = '' + 'POST';
   	         myFrm.action = url; 	 		 
   	         myFrm.submit();           
	    }  

	   function conexionServletConsultar( myFrm, tipo ){              
			   //alert( "**** DENTRO DE 'conexionServletConsultar' ****" );	 
			 
	           var url = "<%=request.getContextPath()%>/ServletBusquedaPasaje";
	         
	           url = url + '?opcionProceso=' + tipo; 
	         
		       var departamento = myFrm.idChoDepartamento.selectedIndex;         
		       var fecha        = myFrm.txtIdFecha.value;   
		       var empresa      = myFrm.idChoEmpresa.selectedIndex;
		       var agencia      = myFrm.idChoAgencia.selectedIndex;
		       var servicio     = myFrm.idChoServTransporte.selectedIndex;
		       var ciuOrigen    = myFrm.idChoCiudadOrigen.selectedIndex;
		       var ciuDestino   = myFrm.idChoCiudadDestino.selectedIndex;
		       
		       alert( "Obj.departamento: " + departamento );
		       alert( "Obj.fecha:        " + fecha );
		       alert( "Obj.empresa: " + empresa );
		       alert( "Obj.agencia: " + agencia );
		       alert( "Obj.servicio: " + servicio );
		       alert( "Obj.ciuOrigen: " + ciuOrigen );
		       alert( "Obj.ciuDestino: " + ciuDestino );
               				
		       if( departamento == '0' || departamento == '-1' ){
		      	   alert( "Seleccionar un Departamento por favor." );
		       }
		       else if( empresa == '0' || empresa == '-1' ){
		      	        alert( "Ingresar una Empresa por favor." );
		       }
		       else if( agencia == '0' || agencia == '-1' ){
		      	        alert( "Ingresar una Agencia por favor." );
		       }
		       else if( servicio == '0' || servicio == '-1' ){
		      	        alert( "Ingresar una Ciudad de Origen por favor." );
		       }  
		       else if( ciuDestino == '0' || ciuDestino == '-1' ){
		      	        alert( "Ingresar una Ciudad de Destino por favor." );
		       }
		       else if( fecha == '' ){
		      	        alert( "Ingresar una Fecha por favor." );
		       }  
		       else{
		   	        myFrm.method = '' + 'POST';
		   	        myFrm.action = url; 	 		 
		   	        myFrm.submit();    
		       }
	   }  
	    
	   function conexionServletPopup( myFrm, parametro ){              
			 //alert( "**** DENTRO DE 'conexionServletPopup' ****" );	 
			 
	         var url = "<%=request.getContextPath()%>/ServletPopupBus";

	         url = url + '?idServicio=' + parametro; 
	         
	         //alert( url );
	
	 		 var newwindow = window.open( url, 'name','height=540 width=400, scrollbars=1, left=500, top=50' );
			
			 if( window.focus ){ 
			     newwindow.focus()
			 }
	    } 
	  </script>
 </head>

 <body style="margin:0px;" onload="detectarControlesEnabledDisabled()" > 
  
  <form id="idFrmBusquedaPasaje" name="frmBusquedaPasaje" >
  
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

				  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="2" >
				
				      <tr>
					     <td width="10%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="10%" >&nbsp;</td>
				      </tr>	
				      	  
					  <tr>
	                   <td colspan="4" >
	                     <center>
	                       <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloBusquedaPasaje" /> </font>
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
				         <td width="80%" colspan="2" > 
				         
				         <c:if test="${estado != 'INICIO'}" > 		         			 
		                       
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
				         
	                      <fieldset style="border:1px solid #0066FF;font-family: Arial; font-size: 13px;" >
	                        <legend accesskey=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" ><label><fmt:message key="texto.label.filtro" />:</label> </legend>
	                   
	                          <table width="100%" >
                                 
                                  <tr>	  
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%"><label><fmt:message key="texto.label.departamento" />:</label></td>
                                     <td width="40%" >
                                         <select id="idChoDepartamento" name="choDepartamento" style="width:150px;" onchange="conexionServlet( this.form, 'cargarEmpresa' )" >  
  										    <option value="0" > Seleccionar </option>
  										    <c:forEach var="paramListaDepartamento" items="${listaDepartamento}" >  										       
            								   <option value="${paramListaDepartamento.id}" ${paramListaDepartamento.id == codigoDepartamento ? 'selected' : ''}>${paramListaDepartamento.id} - ${paramListaDepartamento.nombre}</option>  
                                            </c:forEach>
					                     </select>
                                     </td>    
                                     <td width="10%" align="left" >
                                         <button id="idBtnConsultar" type="submit" width="200" onclick="conexionServlet( this.form, 'cargarListadoFiltrado' )" > <fmt:message key="texto.button.consultar" /> </button> 
                                     </td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%"><label><fmt:message key="texto.label.empresa" />:</label></td>
                                     <td width="40%" >
                                       <select id="idChoEmpresa" name="choEmpresa" style="width:150px;" onchange="conexionServlet( this.form, 'cargarAgencia' )" >
                                           <c:if test="${listaEmpresa != null}" > 
	  										    <c:forEach var="paramListaEmpresa" items="${listaEmpresa}" >
	            								   <option value="${paramListaEmpresa.id}" ${paramListaEmpresa.id == codigoEmpresa ? 'selected' : ''}>${paramListaEmpresa.id} - ${paramListaEmpresa.razonSocial}</option>  
	                                            </c:forEach>
                                           </c:if> 
                                       </select>
                                     </td>
                                     <td width="10%" align="left" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%"><label><fmt:message key="texto.label.agencia" />:</label></td>
                                     <td width="40%" >
                                       <select id="idChoAgencia" name="choAgencia" style="width:150px;" onchange="conexionServlet( this.form, 'cargarServTransporte' )" >
                                           <c:if test="${listaAgencia != null}" > 
	  										    <c:forEach var="paramListaAgencia" items="${listaAgencia}" >
	            								   <option value="${paramListaAgencia.id}" ${paramListaAgencia.id == codigoAgencia ? 'selected' : ''}>${paramListaAgencia.id} - ${paramListaAgencia.nombre}</option>  
	                                            </c:forEach>
                                           </c:if> 
                                       </select>
                                     </td>
                                     <td width="10%" align="left" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td><label><fmt:message key="texto.label.servicioTransporte" />:</label></td>
                                     <td>
                                       <select id="idChoServTransporte" name="choServTransporte" style="width:150px;">
                                           <c:if test="${listaServicio != null}" > 
	                                           <c:forEach var="paramListaServicio" items="${listaServicio}" >
	                                              <option value="${paramListaServicio.id}">${paramListaServicio.id} - ${paramListaServicio.nombre}</option>                         
	                                           </c:forEach>
                                           </c:if> 
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td><label><fmt:message key="texto.label.ciudadOrigen" />:</label></td>
                                     <td>
                                       <select id="idChoCiudadOrigen" name="choCiudadOrigen" style="width:150px;">
                                           <!-- 
                                           <option value="LIMA"  > LIMA </option> 
                                           <option value="ICA"  > ICA </option> 
                                           <option value="CHINCHA" > CHINCHA </option> 
                                           <option value="AYACUCHO"  > AYACUCHO </option> 
                                           <option value="CUZCO"  > CUZCO </option> 
                                           <option value="LORETO"  > LORETO </option> 
                                           <option value="PIURA"  > PIURA</option> 
                                           <option value="TACNA"  > TACNA </option> 
                                           <option value="HUANUCO"  > HUANUCO </option> 
                                           <option value="HUANCAYO" > HUANCAYO </option> 
                                           <option value="CAJAMARCA" > CAJAMARCA </option> 
                                           <option value="SAN MARTIN" > SAN MARTIN </option> 
                                           <option value="PUNO" > PUNO </option> 
                                           <option value="UCAYALI" > UCAYALI </option> 
                                           <option value="CHIMBOTE" > CHIMBOTE </option> 
                                           -->
                                           <option value="0" > Seleccionar </option>                                           
                                           <c:forEach var="paramListaDepartamentoOrigen" items="${listaDepartaOrigen}" >                                              
            								  <option value="${paramListaDepartamentoOrigen.id}">${paramListaDepartamentoOrigen.nombre}</option>  
                                           </c:forEach>
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td><label><fmt:message key="texto.label.ciudadDestino" />:</label></td>
                                     <td>
                                       <select id="idChoCiudadDestino" name="choCiudadDestino" style="width:150px;">
                                           <!-- 
                                           <option value="ICA"  > ICA </option> 
                                           <option value="CHINCHA"  > CHINCHA </option> 
                                           <option value="AYACUCHO"  > AYACUCHO </option> 
                                           <option value="CUZCO"  > CUZCO </option> 
                                           <option value="LORETO"  > LORETO </option> 
                                           <option value="PIURA"  > PIURA</option> 
                                           <option value="TACNA"  > TACNA </option> 
                                           <option value="HUANUCO"  > HUANUCO </option> 
                                           <option value="HUANCAYO" > HUANCAYO </option> 
                                           <option value="CAJAMARCA" > CAJAMARCA </option> 
                                           <option value="SAN MARTIN" > SAN MARTIN </option> 
                                           <option value="PUNO" > PUNO </option> 
                                           <option value="UCAYALI" > UCAYALI </option> 
                                           <option value="CHIMBOTE" > CHIMBOTE </option> 
                                           -->
                                           <option value="0" > Seleccionar </option>
                                           <c:forEach var="paramListaDepartamentoDestino" items="${listaDepartaDestino}" >
            								  <option value="${paramListaDepartamentoDestino.id}">${paramListaDepartamentoDestino.nombre}</option> 
                                           </c:forEach>
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td><label><fmt:message key="texto.label.fecha" />:</label></td>
                                     <td>
                                        <input type="text" id="txtIdFecha" name="fechaViaje" /><img src="<%=request.getContextPath()%>/imagenes/Calendario.jpg" id="idLlamarObjetoCalendario" style="cursor:pointer; border:0" > 
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
				       
                     <tr> 
                       <td colspan="4" align="center" >        
                         
                         <c:if test="${listaCalendario == null}" > 
 	                        <table border="0" width="80%" bgcolor="white" >
	                              
	                                 <tr>
	                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center"><fmt:message key="texto.label.empresa" /></td>
	                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center"><fmt:message key="texto.label.agencia" /></td>
	                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center"><fmt:message key="texto.label.servicio" /></td>
	                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center"><fmt:message key="texto.label.origen" /></td>
	                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center"><fmt:message key="texto.label.destino" /></td>
	                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center"><fmt:message key="texto.label.duracion" /></td>
	                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center"><fmt:message key="texto.label.ver" /></td>
	                                 </tr>
	                                 
	                                 <c:if test="${listaDetallePasajeDTO != null}" > 
		                                 <c:forEach var="objlistaDetallePasajeDTO" items="${listaDetallePasajeDTO}" >                                 
			                                 <tr>
			                                     <td style="text-align:center"><label>${objlistaDetallePasajeDTO.razonSocial} </label></td>
			                                     <td style="text-align:center"><label>${objlistaDetallePasajeDTO.nomAgencia}</label></td>
			                                     <td style="text-align:center"><label>${objlistaDetallePasajeDTO.nomServicio}</label></td>
					                                  
			                                     <td style="text-align:center">
	                                                <fmt:formatDate value="${objlistaDetallePasajeDTO.fechaHoraSalida}" type="DATE" pattern="MM-dd-yyyy--hh:mm"/>
	                                             </td>
	                                             
			                                     <td style="text-align:center">
	                                                <fmt:formatDate value="${objlistaDetallePasajeDTO.fechaHoraLlegada}" type="DATE" pattern="MM-dd-yyyy--hh:mm"/>
	                                             </td>
	                                             
			                                     <td style="text-align:center"><label> ${objlistaDetallePasajeDTO.duracion} </label></td> 
				  					                                     
			                                     <td style="text-align:center" >   
				                                     <a href="javascript:conexionServletPopup( this.form, ${objlistaDetallePasajeDTO.idServicio} )" title="Ver Asientos" >                
				                                        <img src="<%=request.getContextPath()%>/imagenes/Buscar_01.gif" alt="Ver Asientos" width="20" height="19"  border="0" />
				                                     </a>
			                                     </td>
			                                     
			                                 </tr>                                                                 
		                               </c:forEach> 
		                            </c:if>
                            </table>  
                         </c:if> 
              
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
        
	   <!-- TABLA #3 -->
	   <table width="100%" height="28" border="0">
	       <tr>
	         <td width="100%" height="22" colspan="4" id="panelPie" >
	             <jsp:include page="../include/PiePagina.jsp" flush="false"/>   
	         </td>
	       </tr>   
	    </table>  
		   		   
	</form> 
	  
	<script type="text/javascript">
	    Calendar.setup({
	        inputField     :    "txtIdFecha",                // ID DEL ARCHIVO DE ENTRADA (PARA TEXTFIELD)
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

 