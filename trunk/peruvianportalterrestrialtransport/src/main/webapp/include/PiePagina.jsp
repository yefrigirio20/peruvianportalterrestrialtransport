
 <%@ page contentType="text/html;charset=utf-8" %>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" />  

 <hr align="center" size="2" noShade />

 <jsp:include page="../include/Estilos.jsp" flush="true" />

 <table width="100%" class="piePagina" >
   <tr>
     <td height="30" > 
	  <center>            
            <br>
            
			<table>				
				<tr align="center">
				   <td><font color="#003D97"><fmt:message key="texto.label.piePagina.copyright" /> - <strong><fmt:message key="texto.label.piePagina.mensaje_01" /></strong>.</font></td>
				</tr>   
				<tr align="center">
				  <td><font color="#003D97"><fmt:message key="texto.label.piePagina.mensaje_02" /></font></td>
				</tr>
				<tr align="center">
				   <td>
				      <a href="http://localhost:8080/peruvianportalterrestrialtransport" style="cursor:hand" ><font color="red"><strong><fmt:message key="texto.label.piePagina.linkWebsite" /></strong></font></a>  
				    </td>
				</tr>
			</table>   
	    </center>	
	</td>
  </tr>  
</table>
