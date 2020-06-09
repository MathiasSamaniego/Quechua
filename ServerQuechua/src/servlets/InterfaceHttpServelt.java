package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Correcteur.Algo;

public class InterfaceHttpServelt extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		Algo a = new Algo();
		request.setAttribute( "test", a.getListCorrection() );
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Page.jsp" ).forward( request, response );
	}
}