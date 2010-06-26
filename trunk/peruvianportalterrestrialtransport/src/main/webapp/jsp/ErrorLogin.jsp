 <%@ page contentType="text/html;charset=utf-8" %>
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"  %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"  %>  

 <%@ taglib uri="/struts-tags" prefix="s" %>

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

 <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 
 <head> 
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" /> 
 </head>

 <body style="margin:0px;" > 
  
   <!-- TABLA #1 -->
   <table width="100%" height="28" border="0" >
      <tr>
        <td width="100%" height="22" colspan="4" id=LeftPane>
             <jsp:include page="../include/Cabecera.jsp" flush="false" />
        </td>
      </tr>
    </table>
      
   <!-- TABLA #2 -->
   <table width="100%" border=0>
       <tr>
         <td width="15%" valign="top" height="100%">
            <jsp:include page="../include/Menu.jsp" flush="true"/>
         </td>

         <!-- INCLUDE PRINCIPAL -->
         <td width="85%" valign="top">
                         
             <br></br>
			     <center> <label> <strong> <font color="#9E353F" size="5" > ERROR ENCONTRADO</font> </strong> </label> </center>
			 <br></br>
		    
		    <font color="white" size="3" >
		     <strong> <s:text name="#{login.error}"/> </strong>
		    </font> 
                      
         </td>
         <!-- FIN INCLUDE PRINCIPAL -->
         
       </tr>
    </table> 

   <!-- TABLA #3 -->
   <table width="100%" height="28" border="0">
       <tr>
         <td width="100%" height="22" colspan="4" id=LeftPane>
             <jsp:include page="../include/PiePagina.jsp" flush="false"/>   
         </td>
       </tr>   
    </table>  
		   
   </body>

</html>


