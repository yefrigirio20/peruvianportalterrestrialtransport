
 <%
   final String nombServlet = "Servlet_Header_Request"; 
 %>

<jsp:include page="../include/Estilos.jsp" flush="true" />

<%@ taglib prefix="s" uri="/struts-tags" %>
 
 <table width="100%" class="menuPrincipal" > 
   <tr>   
     <td height="30"> 
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/Home.jsp" style="cursor:hand" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>Home</strong></font>
	     </a>
		</center> 
     </td>  
    
 
    
     <td >
	    <center>
	     <!--  
	     <a href="<%=request.getContextPath()%>/jsp/BusquedaPasaje.jsp" style="cursor:hand; " />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>Disponibilidad de Asientos</strong></font>
	     </a>
	     -->
	     
	     <a href="<%=request.getContextPath()%>/ServletBusquedaPasaje" style="cursor:hand; " />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>Disponibilidad de Asientos</strong></font>
	     </a>
		</center> 
     </td>

     <td >
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/RegistroCliente.jsp" style="cursor:hand;" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>&nbsp; &nbsp; Registro &nbsp; &nbsp;</strong></font>
	     </a>
		</center> 
     </td> 
         
    <td >
	    <center>
	     <a href="<%=request.getContextPath()%>/login.action" style="cursor:hand;" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>&nbsp; &nbsp; Login &nbsp; &nbsp;</strong></font>
	     </a>
        </center>
     </td>  
          
   </tr>
   
 </table>
 
 
 