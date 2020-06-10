package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Correcteur.Algo;

public class InterfaceHttpServelt extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1590123697010812279L;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		try {
		Algo a = new Algo();
        request.setAttribute( "test", a.getPhraseACorriger());
        this.getServletContext().getRequestDispatcher( "/WEB-INF/PageCorrection.jsp" ).forward( request, response );
		}
		catch(Exception e) {}
	}
}