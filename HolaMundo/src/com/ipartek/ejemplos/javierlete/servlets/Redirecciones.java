package com.ipartek.ejemplos.javierlete.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redir")
public class Redirecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.sendRedirect("http://www.google.es");
		getServletContext().getRequestDispatcher("/recibir").forward(request, response);
	}

}
