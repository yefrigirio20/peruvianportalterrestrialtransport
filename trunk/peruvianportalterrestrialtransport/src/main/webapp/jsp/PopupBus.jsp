
<html>
  
   <head>

    <script type="text/javascript">
 
	    function centrarPopup(){ 
		    eje_x = (screen.width-document.body.clientWidth)   / 2; 
		    eje_y = (screen.height-document.body.clientHeight) / 2; 
		    moveTo( eje_x, eje_y );
	    } 
 
    </script>
 
</head>
<body onLoad="centrarPopup()" bgcolor="#AFD2F9" >

  <form id="idFrmPopupBus" name="frmBusquedaPasaje" >
  
  <br>
    
  <center> 
     <font face="Arial" color="#9E353F" size="5">
       Verificaci�n de Asientos
     </font>   
  </center>
   
  <center>
        <table border="0" background="images/BusPopup.jpg" >
            <tr>
                <td colspan="3" >&nbsp;  </td>
            </tr>
            <tr>
                <td >
<input type="button" name="    " value="   1   " style="background:#060;color:#CCC" >
<input type="button" name="    " value="   2   " style="background:#060;color:#CCC" >
                </td>
                <td>&nbsp;
                    </td>
                <td>
<input type="button" name="    " value="   4   " style="background:#060;color:#CCC" >
<input type="button" name="    " value="   5   " style="background:#060;color:#CCC" >
                </td>      
            </tr>
            <tr>
                <td >
<input type="button" name="    " value="   6   " style="background:#060;color:#CCC" >
<input type="button" name="    " value="   7   " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                    </td>
                <td>
<input type="button" name="    " value="   8   " style="background:#060;color:#CCC" >
<input type="button" name="    " value="   9   " style="background:#060;color:#CCC" >
                </td>  
            </tr>
            <tr>
                <td >
 <input type="button" name="    " value="  10  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  11  " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  12  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  13  " style="background:#060;color:#CCC" >
                </td>  
            </tr>
            <tr>
                <td>
 <input type="button" name="    " value="  14  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  15  " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  16  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  17  " style="background:#060;color:#CCC" >
                </td>  
            </tr>
            <tr>
                <td>
 <input type="button" name="    " value="  18  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  19  " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  20  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  21  " style="background:#060;color:#CCC" >
                </td>  
            </tr>
            <tr>
                <td>
 <input type="button" name="    " value="  22  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  23  " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                    </td>
                <td>
 <input type="button" name="    " value="  24  " style="background:#060;color:#CCC" >
 <input type="button" name="    " value="  25  " style="background:#060;color:#CCC" >
                </td>  
            </tr>
            <tr>
                <td>
   <input type="button" name="    " value="  26  " style="background:#060;color:#CCC" >
   <input type="button" name="    " value="  27  " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                    </td>
                <td>
   <input type="button" name="    " value="  28  " style="background:#060;color:#CCC" >
   <input type="button" name="    " value="  29  " style="background:#060;color:#CCC" >
                </td>  
            </tr>
            <tr>
                <td>
   <input type="button" name="    " value="  30  " style="background:#060;color:#CCC" >
   <input type="button" name="    " value="  31  " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                 </td>
                <td>
   <input type="button" name="    " value="  32  " style="background:#060;color:#CCC" >
   <input type="button" name="    " value="  33  " style="background:#060;color:#CCC" >
                </td>  
            </tr>
            <tr>
                <td>
   <input type="button" name="    " value="  34  " style="background:#060;color:#CCC" >
   <input type="button" name="    " value="  35  " style="background:#060;color:#CCC" >
                </td>  
                <td>&nbsp;
                    </td>
                <td>
   <input type="button" name="    " value="  36  " style="background:#060;color:#CCC" >
   <input type="button" name="    " value="  37  " style="background:#060;color:#CCC" >
                </td>  
            </tr>
        </table>
        
        <br>
       
       <table width="70%">
            <tr>
                <td>
   <input type="button" name="    " value="    " style="background:#060" >
                    <font face="Arial" size="2" color="#060" >Disponible</font>
                </td> 
                
                 <td>
   <input type="button" name="    " value="    " style="background:#900" >
                    <font face="Arial" size="2" color="#900" >Ocupado</font>
                </td> 
            </tr>
       </table>
            
        <br> 
        
                <input type="text" name="datos" id="datos" value="Escribe aca lo que quieras pasar al 'frmPADRE'" width="280"/>
        <br> 
         
        <table width="80%" >
                 <tr>
                   <td width="10%" >&nbsp;</td>
                   <td width="90%" colspan="2" align="center" >                                      
                     <a href="JavaScript:close();" title="pasar valor" onClick="window.opener.document.idFrmBusquedaPasaje.idTxtDia.value = window.document.idFrmPopupBus.datos.value;" >              
                         <input type="button" name="btnComprar" value="Comprar" >
                     </a>                   
                   </td>
                   <td width="10%" >&nbsp;</td>
              </tr>
        
        </table>
        
       <br>
       <br>
        
    </center>
    
    </form>
    
  </body>
  
</html>