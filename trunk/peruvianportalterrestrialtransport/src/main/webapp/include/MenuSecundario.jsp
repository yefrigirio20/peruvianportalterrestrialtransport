
 <%@ page contentType="text/html;charset=utf-8" %>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <fmt:setBundle basename="com.ttporg.pe.msj.Internacionalizacion_es" />  
 
 <%@ page import="com.ttporg.pe.bean.BaseBean"      %>
 <%@ page import="com.ttporg.pe.bean.Cliente"       %>
 <%@ page import="com.ttporg.pe.bean.BaseBean"      %>
 <%@ page import="com.ttporg.pe.util.UtilSingleton" %>

 <jsp:include page="../include/Estilos.jsp" flush="true" />
 
 <table width="100%" class="menuPrincipal" > 
   <tr>   
     <td height="30"> 
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/Home.jsp" style="cursor:hand" />
		    <font size="2" face="Arial" class="textoMenuPrincipal" ><strong><fmt:message key="texto.label.menuPrincipal.home" /></strong></font>
	     </a>
		</center> 
     </td>       
    
     <td>
	    <center>
	     
	     <% 	
	        Cliente objClienteSesion = (Cliente)session.getAttribute( "objCliente" );
 
	        if( objClienteSesion != null ){
	     %>
	     
	     <a href="<%=request.getContextPath()%>/ServletBusquedaPasaje" style="cursor:hand; " />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong><fmt:message key="texto.label.menuPrincipal.disponibilidadAsientos" /></strong></font>
	     </a>
	     
          <%}
            else{
            %>     
               <strong> <font size="2" face="Arial" color="red"> <fmt:message key="texto.label.menuPrincipal.registrarse" /> </font/> </strong>                 
            <%}%>  
	     
		</center> 
     </td>

     <td >
	    <center>
	     <a href="<%=request.getContextPath()%>/jsp/RegistroCliente.jsp" style="cursor:hand;" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>&nbsp; &nbsp; <fmt:message key="texto.label.menuPrincipal.registro" /> &nbsp; &nbsp;</strong></font>
	     </a>
		</center> 
     </td> 
         
    <td >
	    <center>
	     <a href="<%=request.getContextPath()%>/login.action" style="cursor:hand;" />
		   <font size="2" face="Arial" class="textoMenuPrincipal" ><strong>&nbsp; &nbsp; <fmt:message key="texto.label.menuPrincipal.login" /> &nbsp; &nbsp;</strong></font>
	     </a>
        </center>
     </td>  
          
   </tr>
   
 </table>
 
 
 