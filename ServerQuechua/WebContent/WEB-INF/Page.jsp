<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Correcteur</title>
    </head>

    <body>
    <center><h1>Correcteur Orthographique Quechua</h1></center>
        <center>
        	<FORM action="/Corrector" method="post">
        	<fieldset>    
        		<legend>Correction</legend>
        		<TEXTAREA id="text" rows="5" cols="33"></TEXTAREA>
        		<br><input type="submit" value="Corriger">
        	</fieldset>
        	</FORM>
        </center>
        <p>
            <%
            ArrayList<String> liste = new  ArrayList<String>();
            liste = (ArrayList<String>) request.getAttribute("test");
            for ( int i=0; i<liste.size(); i++ ) 
                out.println(liste.get(i));   
            %>
        </p>
    </body>
</html>