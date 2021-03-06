 <%@ page contentType="text/html;charset=utf-8" %>
  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>   
 
 <%@ taglib uri="/struts-tags"                      prefix="s"   %>
 <%@ taglib uri="/struts-dojo-tags"                 prefix="sx"  %>  

 <%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags" prefix="ajax" %>
 <%@ taglib uri="http://displaytag.sf.net"                      prefix="display" %>

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head>
	 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" ></meta>
	 
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" />    
     
     <fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" /> 
          
     <script type="text/javascript" > 
	 
	    function centrarPopup(){ 
		    eje_x = (screen.width-document.body.clientWidth)   / 2; 
		    eje_y = (screen.height-document.body.clientHeight) / 2; 
		    moveTo( eje_x, eje_y );
	    }  

	    function conexionServlet( myFrm, idFila, idServicio, idAsiento, txtFila ){              
			 //alert( "**** DENTRO DE 'conexionServlet' ****" );	 
			 
	         var url = "<%=request.getContextPath()%>/ServletPopupBus";
	         //alert( url );

	         //idFila     = ${objListaPopup.idAsiento}, 
	         //idServicio = ${objListaPopup.idServicio}, 
	         //idAsiento  = ${objListaPopup.columnaAsientoA},
	         //txtFila    =  '-A'
	         
	         var urlNew = url + '?idServicio=' + idServicio + '&idFila=' + idFila + txtFila + '&idAsiento=' + idAsiento;
	         //alert( urlNew );
	         	
	         myFrm.method = '' + 'POST';
	         myFrm.action = urlNew; 		 		 
	         myFrm.submit();
	    }  
 
		 var vAJAX;
			
		 function conexionAjaxServlet( myFrm, idAsiento ){
			//alert( "**** DENTRO DE 'conexionAjaxServlet' ****" );	

			//alert( "idAsiento: " + idAsiento );
		    
			//CREAMOS EL CONTROL 'XMLHttpRequest', SEGÚN EL NAVEGADOR UTILIZADO: 
			if( window.XMLHttpRequest ){
				vAJAX = new XMLHttpRequest();                      //SI NO ES 'INTERNET EXPLORER'
			}
			else{
				vAJAX = new ActiveXObject( "Microsoft.XMLHTTP" );  //SI ES 'INTERNET EXPLORER'
		    }
			
			//ALMACENAMOS EN EL CONTROL, LA FUNCION QUE INVOCARA CUANDO LA PETICION CAMBIE DE ESTADO	
			vAJAX.onreadystatechange = funcionCallback;        //IMPORTANTE LOS LLAMADOS A LOS METODOS SE HACEN SIN PONER '()'
		    
			//ENVIAMOS LA PETICION...
			vAJAX.open( "GET", "<%=request.getContextPath()%>/ServletAjax?idAsiento=" + idAsiento , true );
			vAJAX.send( "" );
		 }
		
		 function funcionCallback(){
		
			//COMPROBAMOS SI LA PETICION SE HA COMPROBADO:  (TIENE QUE COINCIDIR CON EL ESTADO #4)
			if( vAJAX.readyState == 4 ){
			
				//COMPROBAMOS SI LA RESPUESTA HA SIDO CORRECTA:  (TIENE QUE COINCIDIR CON 'HTTP 200')
				if( vAJAX.status == 200 ){
					//ESCRIBIMOS EL RESULTADO DE LA PAGINA 'HTML' MEDIANTE 'DHTML'
					document.all.IMPRIMIR.innerHTML = "<STRONG><FONT COLOR='RED'>" + vAJAX.responseText + "</FONT></STRONG>";	
				}
				else{
				     //alert("NO SE PUDO EN: 'vAJAX.status == 200' ");
				}
			}
			else{
				 //alert("NO SE PUDO EN: 'vAJAX.readyState == 4' ");
			}
		 }
	    		
    </script>
 
</head>

 <body onload="detectarControlesEnabledDisabled()" > 

  <form id="idFrmPopupBus" name="frmBusquedaPasaje" >
    
	  <center>
	    <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloVerificaAsiento" /> </font>
	  </center> 
	   
	  <br> </br>
	  <br> </br>
        
        <% int contador = 0; %>
        
        <!-- GRAFICO BUS --> 
        <c:if test="${listaDetalleAsientoDTO != null}" > 
          <center>
            <table border="0" width="70%" bgcolor="#003300" >
               <tr>
                <td> 
                  <table border="0" width="100%" bgcolor="black" > 
                       <tr> 
                            <td> 
                                <center> 
                                    <font size="3" style="color:white; border:thin; border-color:#000; " > 
                                          <strong> &nbsp; &nbsp; &nbsp; A &nbsp; &nbsp; &nbsp; </strong>
                                    </font> 
                                </center>                              
                            </td>
                            
                            <td> 
                                 <center> 
                                    <font size="3" style="color:white; border:thin; border-color:#000; " > 
                                          <strong> &nbsp; &nbsp; &nbsp; B &nbsp; &nbsp; &nbsp; </strong> 
                                    </font> 
                                </center>  
                            </td>
                            
                            <td> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </td>
                            
                            <td> 
                                <center> 
                                    <font size="3" style="color:white; border:thin; border-color:#000; size:4" > 
                                         <strong> &nbsp; &nbsp; &nbsp; C &nbsp; &nbsp; &nbsp; </strong> 
                                    </font> 
                                </center>  
                            </td>
                            
                            <td> 
                                <center> 
                                    <font size="3" style="color:white; border:thin; border-color:#000; " > 
                                        <strong> &nbsp; &nbsp; &nbsp; D &nbsp; &nbsp; &nbsp; </strong> 
                                    </font> 
                                </center>  
                            </td>
                       </tr> 
                   </table>
                   
                 </td>
               </tr>
            
               <tr>
                <td>   
                    <table border="0" width="100%" bgcolor="white" >    
                         <tr> 
                            <td colspan="2" bgcolor="#003300" >
                                <center> 
                                    <font style="color:#FFF; border:thin; border-color:#000; " > 
                                        <strong> &nbsp; &nbsp; &nbsp; &nbsp; CHOFER &nbsp; &nbsp; &nbsp; &nbsp; </strong> 
                                    </font> 
                                </center>  
                            </td>
                            <td colspan="3" > &nbsp;&nbsp; 	 
                            </td>

                         </tr>    
                                
                         <c:forEach var="objListaPopup" items="${listaDetalleAsientoDTO}" >                                 
                              <tr>   
                                  <% 
                                   //System.out.println( "contador: " + contador );
                                  %>	
                                                          
                                  <td style="text-align:center" bgcolor="white" >  		                      
                                         
                                      <c:if test="${objListaPopup.estado_A == 'FALSE'}" >
                                                                                
	                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoA}" 
	                                                style="background:#060; color:#CCC;cursor:pointer" class="onMouseOver_A" 
	                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoA}, '-A' )" />    
									             
	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_A"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01" 
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if>                                       
                                      
                                      <c:if test="${objListaPopup.estado_A == 'TRUE'}" >
                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoA}  " 
                                                style="background:#BB0000; color:#CCC;cursor:pointer" class="onMouseOver_B"
                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoA}, '-A' )" />
									             
	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_B"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01"  
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if>                                    
                                  </td>   
                                  
                                  <td style="text-align:center" bgcolor="white" >  		                      
                                         
                                      <c:if test="${objListaPopup.estado_B == 'FALSE'}" >
                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoB}  " 
                                                style="background:#060; color:#CCC;cursor:pointer" class="onMouseOver_B"
                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoB}, '-B' )" />
 	       		                             
 	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_B"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01" 
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if> 
                                      
                                      <c:if test="${objListaPopup.estado_B == 'TRUE'}" >
                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoB}  " 
                                                style="background:#BB0000;color:#CCC;cursor:pointer" class="onMouseOver_B"
                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoB}, '-B' )" />
		                             
 	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_B"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01" 
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if>                                    
                                  </td> 
                                  
                                  <td style="text-align:center" bgcolor="white" > 
                                     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                  </td> 
                                  
                                  <td style="text-align:center" bgcolor="white" >  	                      
                                         
                                      <c:if test="${objListaPopup.estado_C == 'FALSE'}" >
                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoC}  " 
                                                style="background:#060;color:#CCC;cursor:pointer" class="onMouseOver_C"
                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoC}, '-C' )" />
		                             
 	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_C"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01" 
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if> 
                                      
                                      <c:if test="${objListaPopup.estado_C == 'TRUE'}" >
                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoC}  " 
                                                style="background:#BB0000;color:#CCC;cursor:pointer" class="onMouseOver_C"
                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoC}, '-C' )" />
		                             
 	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_C"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01" 
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if>                                     
                                  </td> 
                                  
                                  <td style="text-align:center" bgcolor="white" >  	                      
                                         
                                      <c:if test="${objListaPopup.estado_D == 'FALSE'}" >
                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoD}  " 
                                                style="background:#060;color:#CCC;cursor:pointer" class="onMouseOver_D"
                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoD}, '-D' )" />
		                             
 	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_D"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01" 
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if>
                                      
                                      <c:if test="${objListaPopup.estado_D == 'TRUE'}" >
                                         <input type="button" name="    " value="  ${objListaPopup.columnaAsientoD}  " 
                                                style="background:#BB0000;color:#CCC;cursor:pointer" class="onMouseOver_D"
                                                onclick="javascript:conexionServlet( this.form, ${objListaPopup.idAsiento}, ${objListaPopup.idServicio}, ${objListaPopup.columnaAsientoD}, '-D' )" />
		                             
 	       		                             <ajax:callout baseUrl     = "${pageContext.request.contextPath}/ServletAjax" 
										                   sourceClass = "onMouseOver_D"
										                   parameters  = "idAsiento={ajaxParameter},opcionAjax=PROCESO_AJAX_01" 
										                   title       = "REGISTRO DE PASAJES"  										                   
										     />
                                      </c:if>                                    
                                  </td>                     
                                  
                                  <% contador ++; %>                
                              </tr>   	                                                                                
                          </c:forEach> 
                          
                         <tr>
                            <td colspan="3"> &nbsp;&nbsp; </td>
                            <td colspan="2" bgcolor="#0066FF" >
                                <center> 
                                    <font style="color:#FFF; border:thin; border-color:#000; " > 
                                          &nbsp; &nbsp; &nbsp; &nbsp; BAÑO &nbsp; &nbsp; &nbsp; &nbsp;
                                    </font> 
                                </center>  
                            </td>
                         </tr>   
                                                                
                      </table>   
                      
                </td>
             </tr>   
                                                    
          </table> 
          
          <table>
            <tr>  
              <td>
                <span id="IMPRIMIR" ></span>
              </td>
            </tr>            
          </table>
              
         </center>
       </c:if>         
       <!-- GRAFICO BUS --> 
         
       <br></br>
         
       <center>  
	       <table width="70%">
	            <tr>
	                <td>
	                    <input type="button" name="    " value="    " style="background:#060" />
	                    <font face="Arial" size="2" color="#060" > <fmt:message key="texto.label.disponible" /> </font>
	                </td> 
	                
	                 <td>
	                    <input type="button" name="    " value="    " style="background:#BB0000" />
	                    <font face="Arial" size="2" color="#900" > <fmt:message key="texto.label.ocupado" /> </font>
	                </td> 
	            </tr>
	       </table>
       </center>    
        
        <br></br>
        
        <center>
          <% 
            contador = (contador * 4);
          %>
                  
          <strong>#<fmt:message key="texto.label.totalAsientos" />:</strong> 
          <input type="text" name="datos" id="datos" value="<%=contador%>" width="280" style=" width : 103px;" />
        </center>

        <br></br>
        
        <center> 
	        <table width="80%" >
	                 <tr>
	                   <td width="10%" >&nbsp;</td>
	                   <td width="90%" colspan="2" align="center" >                                      
	                       <a onclick="opener.location=('<%=request.getContextPath()%>/ServletPagarPasaje?estadoPopup=FALSE'); self.close();" 
                              style="cursor:pointer">
	                          <strong> 
                                  <font style="color:#FFF; background:#BB0000; border:thin; border-color:#000; " > 
                                        &nbsp;&nbsp;&nbsp; <fmt:message key="texto.label.comprarPasaje" /> &nbsp;&nbsp;&nbsp; 
                                  </font> 
                              </strong>
	                       </a>
	                   </td>
	                   <td width="10%" >&nbsp;
	                   </td>
	              </tr>        
	         </table>
        </center>

        <br></br>
     
    </form>
    
  </body>
  
</html>
