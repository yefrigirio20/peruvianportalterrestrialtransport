
 <%
   final String nombServlet = "Servlet_Header_Request"; 
 %>

<jsp:include page="../include/Estilos.jsp" flush="true" />

<%@ taglib prefix="s" uri="/struts-tags" %>
 
 <table width="100%" class="menuPrincipal" > 
   <tr>   
     <td height="30"> 
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/Opcion_01.jsp">
		   <font size="2" face="Arial" class="textoMenuPrincipal" >Opcion #1</font>
	     </a>
		</center> 
     </td>  
    
     <td>
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/Opcion_02.jsp">
		   <font size="2" face="Arial" class="textoMenuPrincipal" >Opcion #2</font>
	     </a>
		</center> 
     </td> 
     
     <td>
	     <center>
		   <a href="<%=request.getContextPath()%>/jsp/Opcion_03.jsp" >
	       <font size="2" face="Arial" class="textoMenuPrincipal" >Opcion #3</font> </a> 
		 </center>
    </td> 
     
    <td>
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/Login.jsp" >
		   <font size="2" face="Arial" class="textoMenuPrincipal" >Opcion #4</font>
	     </a>
        </center>
     </td>  
     
      <td> 
	    <center>                 
         <a href="Servlet_Header_Request" class="textoMenuPrincipal"  >
            Servlet_Header_Request
         </a> 
		</center> 
      </td>    
  
      <td>   
	     <center>               
         <a href="ValidaUsuarioServlet" class="textoMenuPrincipal"  >
            XXX
         </a> 
		</center> 
      </td>           
   </tr>
   
 </table>
 
 