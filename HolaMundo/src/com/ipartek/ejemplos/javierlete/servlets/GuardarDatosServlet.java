package com.ipartek.ejemplos.javierlete.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/guardar")
public class GuardarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("dato");

		HttpSession session = request.getSession();

		session.setAttribute("dato", dato);

		ServletContext application = getServletContext();

		application.setAttribute("todos", "Común");

		// request.getSession().setAttribute("dato", dato);
	}

}
