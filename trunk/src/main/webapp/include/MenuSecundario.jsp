
 <%
   final String nombServlet = "Servlet_Header_Request"; 
 %>

<jsp:include page="../include/Estilos.jsp" flush="true" />

<%@ taglib prefix="s" uri="/struts-tags" %>
 
 <table width="100%" class="menuPrincipal" > 
   <tr>   
     <td height="30"> 
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/Opcion_01.jsp" style="cursor:hand" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" >Opcion #1</font>
	     </a>
		</center> 
     </td>  
    
     <td>
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/Opcion_02.jsp" style="cursor:hand" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" >Opcion #2</font>
	     </a>
		</center> 
     </td> 
     
     <td>
	     <center>
		   <a href="<%=request.getContextPath()%>/jsp/BusquedaPasaje.jsp" style="cursor:hand" />
	       <font size="2" face="Arial" class="textoMenuPrincipal" >Buscar</font> </a> 
		 </center>
    </td> 
     
    <td>
	    <center>
	     <a href="<%=request.getContextPath()%>/login.action" style="cursor:hand" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" >Login</font>
	     </a>
        </center>
     </td>  
     
      <td> 
	    <center>                 
         <a href="<%=request.getContextPath()%>/ValidaServlet" class="textoMenuPrincipal" style="cursor:hand" />
            ValidaServlet
         </a> 
		</center> 
      </td>    
  
      <td>   
	     <center>               
         <a href="/login.action" class="textoMenuPrincipal" style="cursor:hand" />
            XXX
         </a> 
		</center> 
      </td>           
   </tr>
   
 </table>
 
 