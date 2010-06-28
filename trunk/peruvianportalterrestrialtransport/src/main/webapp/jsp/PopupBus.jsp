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
     
     <script type="text/javascript"> 
	    function centrarPopup(){ 
		    eje_x = (screen.width-document.body.clientWidth)   / 2; 
		    eje_y = (screen.height-document.body.clientHeight) / 2; 
		    moveTo( eje_x, eje_y );
	    }  

	    function conexionServlet( myFrm, idAsiento ){              
			 //alert( "**** DENTRO DE 'conexionServlet' ****" );	 
			 
	         var url = "<%=request.getContextPath()%>/ServletPopupBus";
	         //alert( url );

	         var urlNew = url + '?idAsiento=' + idAsiento;
	         //alert( urlNew );
	         	
	         myFrm.method = '' + 'POST';
	         myFrm.action = urlNew; 		 		 
	         myFrm.submit();
	    } 

	    function conexionCompraBoleto( myFrm, idAsiento ){              
			 //alert( "**** DENTRO DE 'conexionCompraBoleto' ****" );	 
			 
	         var url = "<%=request.getContextPath()%>/ServletPagoPasaje";
	         //alert( url );
             
	         var urlNew = url + '?idAsiento=' + idAsiento;
	         //alert( urlNew );
			 	
	         myFrm.method = '' + 'POST';
	         myFrm.action = urlNew; 		 		 
	         myFrm.submit();
	    } 
    </script>
 
</head>

 <body onload="detectarControlesEnabledDisabled()" > 

  <form id="idFrmPopupBus" name="frmBusquedaPasaje" >
    
  <center>
    <font class="textoTituloFormulario" > <fmt:message key="texto.label.tituloVerificaAsiento" /> </font>
  </center> 
   
  <!--   
  <center>
       <table border="0" background="<%=request.getContextPath()%>/images/BusPopup.jpg" >
            <tr>
                <td colspan="3" >&nbsp;  </td>
            </tr>
            <tr>
                <td>
	<input type="button" name="    " value="   1   " style="background:#060;color:#CCC" />
	<input type="button" name="    " value="   2   " style="background:#060;color:#CCC" />
                </td>
                <td>&nbsp;
                    </td>
                <td>
<input type="button" name="    " value="   4   " style="background:#060;color:#CCC" />
<input type="button" name="    " value="   5   " style="background:#060;color:#CCC" />
                </td>      
            </tr>
            <tr>
                <td >
<input type="button" name="    " value="   6   " style="background:#060;color:#CCC" />
<input type="button" name="    " value="   7   " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                    </td>
                <td>
<input type="button" name="    " value="   8   " style="background:#060;color:#CCC" />
<input type="button" name="    " value="   9   " style="background:#060;color:#CCC" />
                </td>  
            </tr>
            <tr>
                <td >
 <input type="button" name="    " value="  10  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  11  " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  12  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  13  " style="background:#060;color:#CCC" />
                </td>  
            </tr>
            <tr>
                <td>
 <input type="button" name="    " value="  14  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  15  " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  16  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  17  " style="background:#060;color:#CCC" />
                </td>  
            </tr>
            <tr>
                <td>
 <input type="button" name="    " value="  18  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  19  " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  20  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  21  " style="background:#060;color:#CCC" />
                </td>  
            </tr>
            <tr>
                <td>
 <input type="button" name="    " value="  22  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  23  " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  24  " style="background:#060;color:#CCC" />
 <input type="button" name="    " value="  25  " style="background:#060;color:#CCC" />
                </td>  
            </tr>
            <tr>
                <td>
   <input type="button" name="    " value="  26  " style="background:#060;color:#CCC" />
   <input type="button" name="    " value="  27  " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                    </td>
                <td>
   <input type="button" name="    " value="  28  " style="background:#060;color:#CCC" />
   <input type="button" name="    " value="  29  " style="background:#060;color:#CCC" />
                </td>  
            </tr>
            <tr>
                <td>
   <input type="button" name="    " value="  30  " style="background:#060;color:#CCC" />
   <input type="button" name="    " value="  31  " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                 </td>
                <td>
   <input type="button" name="    " value="  32  " style="background:#060;color:#CCC" />
   <input type="button" name="    " value="  33  " style="background:#060;color:#CCC" />
                </td>  
            </tr>
            <tr>
                <td>
   <input type="button" name="    " value="  34  " style="background:#060;color:#CCC" />
   <input type="button" name="    " value="  35  " style="background:#060;color:#CCC" />
                </td>  
                <td>&nbsp;
                    </td>
                <td>
   <input type="button" name="    " value="  36  " style="background:#900" />
   <input type="button" name="    " value="  37  " style="background:#900" />
                </td>  
            </tr>
        </table>
        
        <br> </br>
       -->
        
        <br> </br>
        
        <% int contador = 0; %>
       
        <c:if test="${listaAsiento != null}" > 
          <center>
            <table border="0" width="80%" >                    
                        
                 <c:forEach var="objListaAsientos" items="${listaAsiento}" >                                 
	                  <tr>   
	                      
	                      <% 
	                      System.out.println( "contador: " + contador );
	                      
	                      if( contador < 10 ){ 
	                    	  System.out.println( "opcion #1: " );
	                      %>	                      
	                        <td style="text-align:center" bgcolor="#999999" >                 	                       	                      
	                          <c:if test="${objListaAsientos.estado == false}" >
	                          	 <input type="button" name="    " value="  ${objListaAsientos.id}  " 
	                          	        style="background:#060;color:#CCC" onclick="javascript:conexionServlet( this.form, ${objListaAsientos.id} )" />
	                          </c:if>
	                          
	                          <c:if test="${objListaAsientos.estado == true}" >
	                          	 <input type="button" name="    " value="  ${objListaAsientos.id}  " 
	                          	        style="background:#900;color:#CCC" onclick="javascript:conexionServlet( this.form, ${objListaAsientos.id} )" />
	                          </c:if>                     
	                      	</td>
	                      <%}
	                      if( contador > 10 ){ 	                    	  
	                    	  System.out.println( "opcion #2: " );
	                      %>	
	                        <td style="text-align:center"  bgcolor="#CDCDCD">              	                       	                      
	                          <c:if test="${objListaAsientos.estado == false}" >
	                          	 <input type="button" name="    " value="  ${objListaAsientos.id}  " 
	                          	        style="background:#060;color:#CCC" onclick="javascript:conexionServlet( this.form, ${objListaAsientos.id} )" />
	                          </c:if>
	                          
	                          <c:if test="${objListaAsientos.estado == true}" >
	                          	 <input type="button" name="    " value="  ${objListaAsientos.id}  "    
	                          	        style="background:#900;color:#CCC" onclick="javascript:conexionServlet( this.form, ${objListaAsientos.id} )" />
	                          </c:if>                     
	                      	</td>	                          
	                      <%}%>  
	                      
	                      <% contador ++; %>                
	                  </tr>                                                                 
                  </c:forEach> 	                                    
             </table>   
             </center>
         </c:if>         
       
       <br> </br>
       
       <center>  
	       <table width="70%">
	            <tr>
	                <td>
	                    <input type="button" name="    " value="    " style="background:#060" />
	                    <font face="Arial" size="2" color="#060" > <fmt:message key="texto.label.disponible" /> </font>
	                </td> 
	                
	                 <td>
	                    <input type="button" name="    " value="    " style="background:#900" />
	                    <font face="Arial" size="2" color="#900" > <fmt:message key="texto.label.ocupado" /> </font>
	                </td> 
	            </tr>
	       </table>
       </center>    
        
        <br> </br>
        
        <center>
          <strong>#<fmt:message key="texto.label.totalAsientos" />:</strong> <input type="text" name="datos" id="datos" value="<%=contador%>" width="280" style=" width : 103px;"/>
        </center>
        
        <br> </br>
        <br> </br>
        <br> </br>
        
        <center> 
	        <table width="80%" >
	                 <tr>
	                   <td width="10%" >&nbsp;</td>
	                   <td width="90%" colspan="2" align="center" >                                      
	                       <a onclick="opener.location=('<%=request.getContextPath()%>/ServletPagoPasaje'); self.close();" style="cursor:pointer">
	                          <strong> <font style="color:#FFF; background:#F00; border:thin; border-color:#000; " > &nbsp;&nbsp;&nbsp; <fmt:message key="texto.label.comprarPasaje" /> &nbsp;&nbsp;&nbsp; </font> </strong>
	                       </a>
	                   </td>
	                   <td width="10%" >&nbsp;
	                   </td>
	              </tr>        
	         </table>
        </center>
        
        <br> </br>
        <br> </br>
        
    </center>
    
    </form>
    
  </body>
  
</html>
