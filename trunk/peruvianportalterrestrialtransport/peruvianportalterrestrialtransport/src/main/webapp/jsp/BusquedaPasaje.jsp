<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">

<%@page import="com.ttporg.pe.bean.Usuario"%><html>
<%@taglib prefix="s" uri="/struts-tags" %>

 <head>
     <jsp:include page="../include/Titulo.jsp"  flush="false" />
     <jsp:include page="../include/Estilos.jsp" flush="false" />
     <jsp:include page="../include/Scripts.jsp" flush="false" /> 
     
    <script type="text/javascript">

	  function popitup( url ){

		var newwindow = window.open( url, 'name','height=300, width=610, scrollbars=1, left=520, top=185');
		
		if( window.focus){ 
		    newwindow.focus()
		}
		return false;
		}
    </script>
     
 </head>

 <body style="margin:0px;" > 
  
   <!-- TABLA #1 -->
   <table width="100%" height="28" border="0" >
      <tr valign="top" >
        <td width="100%" height="22" colspan="4" ><jsp:include page="../include/Cabecera.jsp" flush="false" /></td>
      </tr>
    </table>
      
   <!-- TABLA #2 -->
   <table width="100%" border="0" >
       <tr valign="top" >
         <td width="15%" valign="top" height="100%">
            <jsp:include page="../include/Menu.jsp" flush="true"/>
         </td>

         <!-- INCLUDE PRINCIPAL -->
         <td width="85%" valign="top">             

				  <table width="90%" border="0" align="center" cellpadding="0" cellspacing="2" >
				
				      <tr>
					     <td width="10%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="10%" >&nbsp;</td>
				      </tr>	
				      	  
					  <tr>
				        <td colspan="4" >
						  <center> 
				             <font color="#9E353F" size="5">
				               Busqueda de Pasajes
				             </font>  
				          </center>        
				        </td>          
					  </tr>
					  
				      <tr>
					     <td width="10%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="40%" >&nbsp;</td>
				         <td width="10%" >&nbsp;</td>
				      </tr>	
				        
				      <tr>
					     <td width="10%" >&nbsp;</td>
				         <td width="80%" colspan="2"> 
	                      <FIELDSET style="border:1px solid #0066FF;font-family: Arial; font-size: 13px;" >
				             <LEGEND ACCESSKEY=I style="color:#0066FF; background-color:#AFD2F9; font-size:12px; font-family:Arial; text-align:left; font:bold" >Filtro: </LEGEND>
	                   
	                          <table width="100%" >
                                 
                                  <tr>	  
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%">Departamento</td>
                                     <td width="40%">
                                        <select name="select" style="width:150px;">
                                           <option>Lima</option>
                                           <option>Ica</option>
                                           <option>Puno</option>
                                        </select>
                                     </td>    
                                     <td width="10%" align="left" ><input type="submit" name="Guardar" value="Consultar" width="200" /></td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td>Empresa:</td>
                                     <td>
                                       <select name="select" style="width:150px;">
                                          <option>Cruz del Sur</option>
                                          <option>Las Flores</option> 
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td>Servicio Transporte:</td>
                                     <td>
                                       <select name="select" style="width:150px;">
                                           <option>Premiun</option> 
                                           <option>Ejecutivo</option> 
                                           <option>Economico</option> 
                                       </select>
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td>Dia:</td>
                                     <td>
                                        <input type="text" name="textfield4" />
                                     </td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                     <td width="10%" >&nbsp;</td>
                                     <td width="40%" >&nbsp;</td>
                                     <td width="40%" >&nbsp;</td>
                                     <td width="10%" >&nbsp;</td>
                                  </tr>	
                                                                  
	                          </table>
	                       </FIELDSET>      
				         </td>
				         <td width="10%" >&nbsp;</td>
				    </tr>	 
				       
                     <tr> 
                         <td colspan="4">
                             <table border="0" width="100%" bgcolor="white">
                                 <tr>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Orden</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Origen</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Destino</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Salida</td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Duracion </td>
                                     <td bgcolor="#0066FF" style="color:#D7D7D7;text-align:center">Nro. Asientos</td>
                                 </tr>
                                 <tr>
                                     <td style="text-align:center">1</td>
                                     <td style="text-align:center">Lima</td>
                                     <td style="text-align:center">Ica</td>
                                     <td style="text-align:center">10:00 p.m.</td>
                                     <td style="text-align:center">4:00 hrs</td>
                                     <td style="text-align:center">                        
                    <a href="popupex.html" onclick="return popitup('PopupBus.jsp')" title="Ver"><font color="#FF0000"> 35 </font></a> 
                                     </td>
                                 </tr>
                                 <tr>
                                     <td style="text-align:center">2</td>
                                     <td style="text-align:center">Lima</td>
                                     <td style="text-align:center">Puno</td>
                                     <td style="text-align:center">6:00 a.m.</td>
                                     <td style="text-align:center">16:00 hrs</td>
                                     <td style="text-align:center">
                     <a href="popupex.html" onclick="return popitup('PopupBus.jsp')"><font color="#FF0000"> 20 </font></a> 
                                     </td>         
                                 </tr>              
                            </table>       
                        </td>
                    </tr> 
                    
                  <tr>
                     <td width="10%" >&nbsp;</td>
                     <td width="40%" >&nbsp;</td>
                     <td width="40%" >&nbsp;</td>
                     <td width="10%" >&nbsp;</td>
                  </tr>	
                  
                  <tr>
                     <td width="10%" >&nbsp;</td>
                     <td width="40%" >&nbsp;</td>
                     <td width="40%" >&nbsp;</td>
                     <td width="10%" >&nbsp;</td>
                  </tr>	 
                                     
				  </table>
				
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

