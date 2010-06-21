 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"  %>  
 
 <%@page import="com.ttporg.pe.bean.Usuario" %>
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head> 
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" /> 
     
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

	  function PopupBus( url ){

		var newwindow = window.open( url, 'name','height=460, width=250, scrollbars=1, left=520, top=180' );
		
		if( window.focus){ 
		    newwindow.focus()
		}
		
		return false;
	   } 
	   
	   function conexionServlet( myFrm, tipo ){              
			 //alert( "**** DENTRO DE 'conexionServlet' ****" );	 
			 
	         var url = "<%=request.getContextPath()%>/ServletBusquedaPasaje";
	         //alert( url );
	
	         myFrm.method = '' + 'POST';
	         myFrm.action = url + '?opcion=' + tipo; 		 		 
	         myFrm.submit();
	    }  
	        
	  </script>
 </head>

 <body> 
  
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
				             <font color="#9E353F" size="5">
				               Busqueda de Pasajes
				             </font>  
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
				         <td width="80%" colspan="2"> 
				         
	                      <fieldset style="border:1px solid #0066FF;font-family: Arial; font-size: 13px;" >
	     <legend accesskey=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" >Filtro: </legend>
	                   
	                          <table width="100%" >
                                 
                                  <tr>	  
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%">Departamento</td>
                                     <td width="40%" >
                                         <select id="idChoDepartamento" name="choDepartamento" style="width:150px;" onchange="conexionServlet( this.form, 'cargarEmpresa' )" >  
  										    <c:forEach var="paramListaDepartamento" items="${listaDepartamento}" >
            								   <option value="${paramListaDepartamento.id}" ${paramListaDepartamento.id == codigoDepartamento ? 'selected' : ''}>${paramListaDepartamento.nombre}</option>  
                                            </c:forEach>
					                     </select>
                                     </td>    
                                     <td width="10%" align="left" >
 <input type="submit" id="idBtnConsultar" name="btnConsultar" value="Consultar" width="200" onclick="conexionServlet( this.form, 'cargarListadoFiltrado' )" /> 
                                     </td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%">Empresa:</td>
                                     <td width="40%" >
                                       <select id="idChoEmpresa" name="choEmpresa" style="width:150px;" onchange="conexionServlet( this.form, 'cargarServTransporte' )" >
                                           <c:if test="${listaEmpresa != null}" > 
	  										    <c:forEach var="paramListaEmpresa" items="${listaEmpresa}" >
	            								   <option value="${paramListaEmpresa.id}" ${paramListaEmpresa.id == codigoEmpresa ? 'selected' : ''}>${paramListaEmpresa.razonSocial}</option>  
	                                            </c:forEach>
                                           </c:if> 
                                       </select>
                                     </td>
                                     <td width="10%" align="left" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td>Servicio Transporte:</td>
                                     <td>
                                       <select id="idChoServTransporte" name="choServTransporte" style="width:150px;">
                                           <c:if test="${listaServicio != null}" > 
	                                           <c:forEach var="paramListaServicio" items="${listaServicio}" >
	                                              <option value="${paramListaServicio.id}">${paramListaServicio.nombre}</option>                         
	                                           </c:forEach>
                                           </c:if> 
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td>Ciudad Origen:</td>
                                     <td>
                                       <select id="idChoCiudadOrigen" name="choCiudadOrigen" style="width:150px;">
                                           <option value="1"  > LIMA </option> 
                                           <option value="2"  > ICA </option> 
                                           <option value="3"  > CHINCHA </option> 
                                           <option value="4"  > AYACUCHO </option> 
                                           <option value="5"  > CUZCO </option> 
                                           <option value="6"  > LORETO </option> 
                                           <option value="7"  > PIURA</option> 
                                           <option value="8"  > TACNA </option> 
                                           <option value="9"  > HUANUCO </option> 
                                           <option value="10" > HUANCAYO </option> 
                                           <option value="11" > CAJAMARCA </option> 
                                           <option value="12" > SAN MARTIN </option> 
                                           <option value="13" > PUNO </option> 
                                           <option value="14" > UCAYALI </option> 
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td>Ciudad Destino:</td>
                                     <td>
                                       <select id="idChoCiudadDestino" name="choCiudadDestino" style="width:150px;">
                                           <option value="1"  > LIMA </option> 
                                           <option value="2"  > ICA </option> 
                                           <option value="3"  > CHINCHA </option> 
                                           <option value="4"  > AYACUCHO </option> 
                                           <option value="5"  > CUZCO </option> 
                                           <option value="6"  > LORETO </option> 
                                           <option value="7"  > PIURA</option> 
                                           <option value="8"  > TACNA </option> 
                                           <option value="9"  > HUANUCO </option> 
                                           <option value="10" > HUANCAYO </option> 
                                           <option value="11" > CAJAMARCA </option> 
                                           <option value="12" > SAN MARTIN </option> 
                                           <option value="13" > PUNO </option> 
                                           <option value="14" > UCAYALI </option>  
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td>Fecha:</td>
                                     <td>
                                        <input type="text" id="txtIdFecha" name="txtFecha" /><img src="<%=request.getContextPath()%>/imagenes/Calendario.jpg" id="idLlamarObjetoCalendario" style="cursor:pointer; border:0" > 
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
                         <td colspan="4">
                             <table border="0" width="100%" bgcolor="white">
                                 <tr>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Orden</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Origen</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Destino</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Salida</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Duracion </td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Nro. Asientos</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Acciones</td>
                                 </tr>
                                 <tr>
                                     <td style="text-align:center">1</td>
                                     <td style="text-align:center">Lima</td>
                                     <td style="text-align:center">Ica</td>
                                     <td style="text-align:center">10:00 p.m.</td>
                                     <td style="text-align:center">4:00 hrs</td>
                                     <td style="text-align:center">                        
                                        <font> 35 </font>                  
                                     </td>
                                     <td style="text-align:center">   
                                     <a href="popupex.html" onclick="return PopupBus('PopupBus.jsp')" title="Ver Asientos">                
                    <img src="<%=request.getContextPath()%>/imagenes/Buscar_01.gif" alt="Ver Asientos" width="20" height="19"  border="0" />
                                     </a>
                                     </td>
                                 </tr>
                                 <tr>
                                     <td style="text-align:center">2</td>
                                     <td style="text-align:center">Lima</td>
                                     <td style="text-align:center">Puno</td>
                                     <td style="text-align:center">6:00 a.m.</td>
                                     <td style="text-align:center">16:00 hrs</td>
                                          <td style="text-align:center">                        
                                        <font> 20 </font>                  
                                     </td>
                                     <td style="text-align:center">   
                                     <a href="popupex.html" onclick="return popitup('PopupBus.jsp')" title="Ver Asientos">                
                    <img src="<%=request.getContextPath()%>/imagenes/Buscar_01.gif" alt="Ver Asientos" width="20" height="19"  border="0" />
                                     </a>
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

