
 <%
   final String nombServlet = "Servlet_Header_Request"; 
 %>


<%@page import="com.ttporg.pe.bean.Cliente"%>
<%@page import="com.ttporg.pe.bean.BaseBean"%>
<%@page import="com.ttporg.pe.util.UtilSingleton"%><jsp:include page="../include/Estilos.jsp" flush="true" />

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
	     
	     <% 	     
			//Obteniendo datos de 'Session'.
			UtilSingleton utilSingleton = UtilSingleton.getINSTANCIA_GUARDADA();
	     
	        if( utilSingleton != null && 
	            utilSingleton.getObjetoSingleton() != null && 
	            utilSingleton.getObjetoSingleton().getCliente() != null  ){
	     %>
	     
	     <a href="<%=request.getContextPath()%>/ServletBusquedaPasaje" style="cursor:hand; " />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>Disponibilidad de Asientos</strong></font>
	     </a>
	     
          <%}
          else{
            %>     
               <strong> <font size="2" face="Arial" color="red"> Registrarse  </font/> </strong>                 
            <%}%>  
	     
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
 
 
 