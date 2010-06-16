
<%@page session="false" %> 
 
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

 <% 
   response.sendRedirect( request.getContextPath()+"/login.action" );
 %>
