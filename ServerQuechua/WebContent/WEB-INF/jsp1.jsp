<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>JSP1</title>
    </head>

    <body>
        <p>Ceci est une page générée depuis une JSP.</p>
        
        <p>
	        <% 
	        String attributreq = (String) request.getAttribute("test");
	        out.println( attributreq );
	        
            String parametre = request.getParameter( "auteur" );
            out.println( parametre );
	        %>
        </p>
        
        
        <p>
        	Récupération du bean :
        	<%
        	beans.Alain notreBean = (beans.Alain) request.getAttribute("alain");
        	out.println(notreBean.getPrenom());
        	out.println(notreBean.getNom());
        	
        	%>
        
        </p>
    </body>
</html>