<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

 <head>
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" />      
 </head>

<body bottomMargin=0 leftMargin=0 topMargin=0 rightMargin=0 marginwidth="0" marginheight="0" bgcolor="white" onLoad="detectarControlesEnabledDisabled()" > 
  
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
			     <center> <label> <strong> <font color="red" size="5" > INTRANET </font> </strong> </label> </center>
			 <br></br>
		 
			 <s:form id="frnValidacion" name="frnValidacion" action="/login.action" >	
			     
			    <s:actionerror cssErrorStyle="mensajeTextoError" />  
			    <s:fielderror  cssErrorStyle="mensajeTextoError" />  
			     
			    <table width="100%" > 
			      <tr> 
				   <td>    
				     <center>
				       <table width="60%"> 
					   	  <tr> 
					   	     <td> &nbsp; </td>
							 <td> <s:textfield name="usuario" label="Usuario " cssStyle="mensajeTextoError" disabled="false" />  </td>
						  </tr>  
						  <tr> 
							  <td> &nbsp; </td>
							  <td> <s:password name="password" label="Password " cssStyle="mensajeTextoError" disabled="false"  /> </td>
						  </tr>
						  
					   	  <tr>
							 <td colspan="2" > <s:submit value="Continuar" align="center" /> </td>
						  </tr>				  		  
						  
						</table>
					  </center>
				   </td>   
				  </tr>
				  
				</table> 
					
			  </s:form>
                      
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

