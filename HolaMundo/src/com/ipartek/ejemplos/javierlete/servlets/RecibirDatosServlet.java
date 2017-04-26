package com.ipartek.ejemplos.javierlete.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/recibir")
public class RecibirDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String dato = (String) session.getAttribute("dato");

		ServletContext application = getServletContext();

		String todos = (String) application.getAttribute("todos");

		PrintWriter out = response.getWriter();

		out.println("El dato guardado en sesión es " + dato);
		out.println("El dato global en aplicación es " + todos);
	}

}
